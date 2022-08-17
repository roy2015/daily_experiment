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
    log.info("64位：{}", "1e6e63275ce0660d49ccfaeb01f3cb2b6733a843729c1a38ddd96eaffe71b7bf".length());
    Solution solution = new Solution();
    solution.initPriPubKey();
    String plainText = "1e6e63275ce0660d49ccfaeb01f3cb2b6733a843729c1a38ddd96eaffe71b7bf";
    log.info("明文：{}", plainText);
    String cipherText = solution.encrypt(plainText);
    //密文每次执行会变化
    log.info("加密后密文base64：len:{}  {}\n", cipherText.length(), cipherText);

    //不同密文对应同一个明文
    cipherText = "wSQWpPO2COfyvVGCantI/XeNh1NBK0y7rMhNkQIT6ewpkVMtipZUHSFUpRDMYaoxyvnvomr3XcCRFpq1ePKn8JsjGEz+EzigFihpiNrpOBYMr+ewtRzIVBGzoMitQ7megFkiqrYSXLtZ88oe34NvxDNAqO1ZgqsQohEP/U9rUtNWfPbH8bW8x/JZLoD8SjbIsNDrV4Cu26dw5dQDLSd+3R+dy/TBiAATTqAfkPqex0wL6cebE34oICRPMemm02J1BCKVSMMI4EkSyLuRVudErKigOo2uu7X4FvmNxLiYytoz5OHDi+xakBPywlYZ8CwfkkrbG54Bp9R/I6bFwuArAA==";
    log.info("密文base64：len:{}  {}", cipherText.length(), cipherText);
    plainText = solution.decrypt(cipherText);
    log.info("解密后明文：{}\n", plainText);

    //登录时传入的密码，可变，利用不同密文对应同一个明文
    cipherText = "TctBplZSYmHV/EzW/3r+Mwts/cLM61EfkJL+fbZJbPpTyVSseZCwd9T2uMF81g6Z3ExmoiAeis2xhpfZ0W0oW2FRMih8woZHaZ76PxHO6oOrcZ0Rxy+cu1a6vejF2ZhXKhBMItx4zxNZh+mYtPolm4g4hzcYlHjeKgFfZa9lEIfo2iQuqpMEogX0ZiQtt/qdiD179vLvIGBrDuaGm8cyPHTYSURPhNsVqP5lprgbYFveuat9O8FhuRWZsSa/dgGvO+LyETBq5UzhpGxZdc10k1AZUJ2aoRFmd1GWSiSokRfmiVUMdi+y4JCBRhyY12D3C6Y17SSUNXlwK3JTzR/iAw==";
    log.info("密文base64：len:{}  {}", cipherText.length(), cipherText);
    plainText = solution.decrypt(cipherText);
    log.info("明文：{}\n", plainText);

    //中间明文
    String midClipherText = solution.getSHA256String(plainText);
    log.info("中间明文：{}", midClipherText);
  }
}
