package com.roy.miscellaneous.mainTest;

import java.io.FileInputStream;
import java.nio.charset.StandardCharsets;
import java.security.KeyStore;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.PrivateKey;
import java.security.PublicKey;

import javax.crypto.Cipher;

import org.apache.commons.codec.binary.Base64;
import org.apache.commons.codec.binary.Hex;

import lombok.extern.slf4j.Slf4j;

/**
 * 1.演示pfx文件生成和提取公私钥加密解密
 * 2.中台的用户密码存储和登录密码校验
 *
 *  中台的登录和密码加密
 *
 *  0. 公私钥生成
 *    1）openssl生成pfx文件
 *    2）KeyStore读取pfx文件即可获的priKey, pubKey
 *
 * 1. 验证
 *    1) 如果password长度为344(base encode后344)，  私钥解密（baseDecode（password）), 赋值给password
 *    2) password长度不为64，SHA-256加密成64长度（messageDigest.digest 256后Hex.encodeHexString(hash)成64）
 *    3）把库里的密码，进行第一步操作解密， 结果和第二步比较即可
 *
 * 2. 生成密码
 *    1) 如果password长度为344(base encode后344)，  私钥解密（baseDecode（password）), 赋值给password
 *    2）password长度不为64，“数字，字母，下划线”校验，通过后 SHA-256加密成64长度（messageDigest.digest后  256Hex.encodeHexString(hash)成64）
 *    3） 把64位 password 公钥加密结果baseEncode, 赋值给password,长度即为344
 *
 * @author guojun
 * @date 2022/8/17 16:30
 */
@Slf4j
public class TestPfxPriPubKey {
  /**
   * 生成pfx证书步骤：
   * 1.生成key文件 openssl genrsa -out openssl.key 2048
   * 2.生成cer证书 openssl req -new -x509 -key openssl.key -out openssl.cer -days 9650 -subj /CN=roy-guo.com
   * 3.生成PFX私钥文件 openssl pkcs12 -export -out roy-guo.pfx -inkey openssl.key -in openssl.cer
   */

  static class Solution {
//    public static final String pfx_path = "/Users/apple/guojun/test/test_pfx/roy-guo.pfx";
    public static final String pfx_path = "/Users/apple/guojun/test/test_pfx/bigdata.pfx";
    private PublicKey publicKey;
    private PrivateKey privateKey;


    /**
     * 初始化私钥公钥
     */
    public void initPriPubKey() {
      try {
//        String password = "07136231227";
        String password = "yunli@AUG";
        KeyStore keyStore = KeyStore.getInstance("pkcs12");
        keyStore.load(new FileInputStream(pfx_path), password.toCharArray());
        String alias = keyStore.aliases().nextElement();
        publicKey = keyStore.getCertificate(alias).getPublicKey();
        privateKey = (PrivateKey) keyStore.getKey(alias, password.toCharArray());
      } catch (Exception e) {
        log.error(e.getMessage(), e);
      }
    }

    /**
     * 解密 (私钥， 公钥)
     * @param cipherText
     * @return
     */
    public String decrypt(String cipherText) {
      Cipher cipher = null;
      try {
        //decode base64
        byte[] bytes = Base64.decodeBase64(cipherText);
        cipher = Cipher.getInstance("RSA");
        cipher.init(Cipher.DECRYPT_MODE, privateKey);
        byte[] doFinal = cipher.doFinal(bytes);
        return new String(doFinal, StandardCharsets.UTF_8);
      } catch (Exception e) {
        log.error(e.getMessage(), e);
        return null;
      }
    }

    /**
     * 加密 (公钥，私钥 )
     * @param plainText
     * @return
     */
    public String encrypt(String plainText) {
      try {
        Cipher cipher = Cipher.getInstance("RSA");
        cipher.init(Cipher.ENCRYPT_MODE, publicKey);
        byte[] bytes = cipher.doFinal(plainText.getBytes(StandardCharsets.UTF_8));
        //encode base64
        return Base64.encodeBase64String(bytes);
      } catch (Exception e) {
        log.error(e.getMessage(), e);
        return null;
      }
    }

    public  String getSHA256String(String string) {
      MessageDigest messageDigest;
      String temp = "";
      try {
        messageDigest = MessageDigest.getInstance("SHA-256");
        byte[] hash = messageDigest.digest(string.getBytes(StandardCharsets.UTF_8));
        temp = Hex.encodeHexString(hash);
      } catch (NoSuchAlgorithmException e) {
        log.error(e.getMessage(), e);
      }
      return temp;
    }
  }


  public static void main(String[] args) {

    //新增用户传入的密码
    Solution solution = new Solution();
    solution.initPriPubKey();
    String plainText = "c8f4ad0417cf3cdba06f2cbd6a1a9904850c648be06b9cb90c21bfaeb92d4769";
    log.info("中间明文64：len:{} {}", plainText.length(), plainText);
    String cipherText = solution.encrypt(plainText);
    //密文每次执行会变化,但解密后对应同一个明文
    log.info("中间明文加密后base64：len:{}  {}\n", cipherText.length(), cipherText);
    log.info("===================================================================================================");

    //库里秘文
    cipherText = "kg3xsfOdA86K1TUVwiCOzW0Obc2YaZO1s2rGSLJ0Uva8WEw1LvWOSIusPEQ72CgkbfC2XDCSjzFDBIiNcqMYcGwZF8p7GPHJDj3p0wO7WScR1G+OmPhxjrlc1Igl6JA3lbk61+/mFaxsKs66B1dpu9QIRhYdMbTGiye+OIRYWSaKG4TneP3LJC+tZACIAe/vl7XKvnAgibm39QZJtr7JAXVRehc+JlYuCXBOTEbN9eIWYoI+YafIYxEimQhpY+MFmpQQLlz6IKQD+WpUzCTctsKVq7vi5FJFvc0SA04M1tU/jmr5gjISXn+aEVtPRUC9r+zMnLdBIeBufNouDBlryA==";
    log.info("db密文base64：len:{}  {}", cipherText.length(), cipherText);
    plainText = solution.decrypt(cipherText);
    log.info("db解密后64位明文： len:{}  {}\n", plainText.length() ,plainText);

    //登录时传入的密码(公钥加密过的)，可变，利用不同密文对应同一个明文
    cipherText = "UpcGaha83Dfe1jlDf/34q4dvdd9X9BQIFnzzh2Rg+RcY/tHnD+lckYX4tj4bkd0+tGFY/vVueWcxd5cplxEsuRrAeofO+R4rP4MunMW0sFNBGU6R4y10C+WUCoZ+X8A8KRZ5zezBGLj80caqCwjI8kwTGM5FOKn0fbaF2eabyS1DqSR6QhQ162ura7v3lvaYqXixfBPXGgi6Z3un+UcXPCkDmZF5LrXSO32GxmYkF484sYBOkFAJK7RxqIQ8KHvloRrGEgey1jP1uY0fPILrKKE22fD1GDS3DDgvzEiWK0ZFa1os4hRzWjoEzDYlAtwf6ZcnY9+rrgb2lyu3DrheQQ==";
    log.info("登录密文base64：len:{}  {}", cipherText.length(), cipherText);
    plainText = solution.decrypt(cipherText);
    log.info("登录明文：len:{} {}\n",plainText.length(), plainText);

    plainText = "P@ssw0rd01!";
    log.info("彻底的明文：{}", plainText);
    log.info("输入框明文后转64位：len:{} {}", solution.getSHA256String(plainText).length(), solution.getSHA256String(plainText));


  }
}
