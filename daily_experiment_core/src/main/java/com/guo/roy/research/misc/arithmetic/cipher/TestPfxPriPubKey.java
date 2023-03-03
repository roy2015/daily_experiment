package com.guo.roy.research.misc.arithmetic.cipher;

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
 * 1.演示pfx文件生成和提取公私钥加密解密 2.中台的用户密码存储和登录密码校验
 *
 * 中台的登录和密码加密
 *
 * 0. 公私钥生成
 * 1）openssl生成pfx文件
 * 2）KeyStore读取pfx文件即可获的priKey, pubKey
 *
 * 1. 验证
 * 1) 如果password长度为344(base encode后344)， 对其私钥解密（baseDecode（password）), 赋值给password
 * 2) password长度不为64，SHA-256加密成64长度（messageDigest.digest 256后Hex.encodeHexString(hash)成64）
 * 3）把库里的密码，进行第一步操作解密， 结果和第二步比较即可
 *
 * 2. 生成密码
 * 1) 如果password长度为344(base encode后344)， 私钥解密（baseDecode（password）), 赋值给password
 * 2）password长度不为64，“数字，字母，下划线”校验，通过后 SHA-256加密成64长度（messageDigest.digest后
 * 256Hex.encodeHexString(hash)成64）
 * 3） 把64位 password 公钥加密结果baseEncode, 赋值给password,长度即为344
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
     * 3.生成PFX私钥文件
     * openssl pkcs12 -export -out roy-guo.pfx -inkey openssl.key -in openssl.cer
     */

    static class Solution {
        public static final String pfx_path = "/Users/apple/guojun/test/test_pfx/guojun.pfx";

        // public static final String pfx_path = "/Users/apple/guojun/test/test_pfx/bigdata.pfx";
        private PublicKey publicKey;
        private PrivateKey privateKey;

        /**
         * 初始化私钥公钥
         */
        public void initPriPubKey() {
            try {
                String password = "07136231227roy";
                // String password = "yunli@AUG";
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
         * 
         * @param cipherText
         * @return
         */
        public String decrypt(String cipherText) {
            Cipher cipher = null;
            try {
                // decode base64
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
         * 
         * @param plainText
         * @return
         */
        public String encrypt(String plainText) {
            try {
                Cipher cipher = Cipher.getInstance("RSA");
                cipher.init(Cipher.ENCRYPT_MODE, publicKey);
                byte[] bytes = cipher.doFinal(plainText.getBytes(StandardCharsets.UTF_8));
                // encode base64
                return Base64.encodeBase64String(bytes);
            } catch (Exception e) {
                log.error(e.getMessage(), e);
                return null;
            }
        }

        public String getSHA256String(String string) {
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
        // 新增用户传入的密码
        Solution solution = new Solution();
        solution.initPriPubKey();

        // 密文每次执行会变化,但解密后对应同一个明文
        String password = "P@ssw0rd01!";
        String midPlainText = solution.getSHA256String(password);
        log.info("===================================================================================================");
        log.info("彻底的明文：{}", password);
        log.info("输入框明文后转64位：len:{} {}\n", midPlainText.length(), midPlainText);
        log.info("===================================================================================================");
        log.info("中间明文64：len:{} {}", midPlainText.length(), midPlainText);
        //对中间明文加密，每次执行结果会变化
        String cipherText = solution.encrypt(midPlainText);
        log.info("中间明文加密后base64：len:{}  {}\n", cipherText.length(), cipherText);
        log.info("===================================================================================================");
        //假设db里秘文,只记录一次
        cipherText = "mr5GFgRHCkKI1qC5SU1SN/HriSsAgsKgsIVOklw6taNOMi6CVTbCeNJuEExodvl+FHuA9BbkyKqkjOyZraB5xXxRUWNHkVe3BJg2Cm+efQIZ5pDBhsnSmuW01J5KumlcpRu+58bKoAvbz5gFVrmpzUOa7ybEOjih3wmFZy05RBrAjfylKoEO+kPHuCx+AtGuZCOeQxr4GFqT6duGp5wrC0+js7BO2iCgnnlu/aLVJW7eK69xymAh6HeW+BqW744VKKvQ3RzgD5n7Itcsp929LDNYFP29qTGpBMLOob/ajunITRyfJGuHgeq6/AAW//iM8F+pGe7CYxG2+WGggaam3Q==";
        log.info("db密文base64：len:{}  {}", cipherText.length(), cipherText);
        String plainText = solution.decrypt(cipherText);
        log.info("db密文解密后64位明文： len:{}  {}\n", plainText.length(), plainText);
        log.info("===================================================================================================");
        log.info("彻底的明文(明文密码)：{}", password);
        log.info("输入框明文后转64位：len:{} {}", solution.getSHA256String(plainText).length(), midPlainText);
        // 登录时传入的密码，密码生成过程前端实现步骤(明文密码 sha256散列(32bytes)hex成64位bytes -》公钥加密(256bytes)base64(344bytes)  )，可变，每次操作结果不一样
        cipherText = "S7vul9My0MVTFt6LKOvcOi9JutCf+lMOsxVxR4O6Y9HLzKUCcYy+BeJfGDBMzubiRjcm0FdqSrL9KDRAtyMM8Lsmyw/nQCipGSygaFqq7DOFtlk4BZlneazckVNpjNVgUEQvXImq9CppDex6k+Qrh50xoB2H0GQLqysYbgZKYyI3FTiFippN/J4y9Ri3ma2XJkdSqh12RrdFznS64SDCws6d5WtuzJwJFf5PJMTrvSDwopejn1h+xn8Lvs/wWBDclqNKZYmqwt3S2RI07m4yoCtVpn6rMnbVSaOxmUSJv7+YRXqts722DbTtTkbEMhHseLRYiCzGaTSJkF1B+Zs63g==";
        log.info("登录密文base64：len:{}  {}", cipherText.length(), cipherText);
        //登录的密文解密成中间明文
        plainText = solution.decrypt(cipherText);
        log.info("登录明文：len:{} {}\n", plainText.length(), plainText);
        log.info("===================================================================================================");

    }
}
