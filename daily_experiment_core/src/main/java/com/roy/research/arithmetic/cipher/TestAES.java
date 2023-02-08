package com.roy.research.arithmetic.cipher;

import org.apache.commons.codec.binary.Base64;
import org.slf4j.LoggerFactory;

import javax.crypto.*;
import javax.crypto.spec.SecretKeySpec;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;

/**
 *
 * 对称加密AES算法
 *
 *
 *
 *
 */
public enum TestAES {

 
    /**
     * 单例
     */
    SINGLETON;

    private static final org.slf4j.Logger logger = LoggerFactory.getLogger(TestAES.class);
    private static final String SECRET_KEY_SEED = "passwrod";
    private String secretKeyBase64String ;

    private String secretKeyBase64Encode ;

    /**
     * base64编码后的secret_key,  AES必须是16位字节数组
     * 所以是32位(24扩大三分之一)
     *
     * java 原生jdk默认只有AES128，生成128位的对称密钥
     */
    private static String SECRET_KEY = "D7BclY7N98ONvsRW+a+Tyw==";//24*3/4=16
//    private static String SECRET_KEY = "D7BclY7N98ONvsRW+a+Ty61b/X73xfqs";//32*3/4=24
    private static String KEY_ALGORITHM = "AES";
    private static String CIPHER_ALGORITHM = "AES/ECB/PKCS5Padding";


    public String initSecretKey() {
        KeyGenerator keyGenerator = null;
        try {
            keyGenerator = KeyGenerator.getInstance(KEY_ALGORITHM);
            //初始化密钥生成器，128可以不指定，指定密钥长度为128，指定随机源的种子为指定的密钥(这里是"passward")
            keyGenerator.init(new SecureRandom(SECRET_KEY_SEED.getBytes()));//SECRET_KEY_SEED密钥种子指定时，secretKey.getEncoded()固定，不传secretKey.getEncoded()就随机
            SecretKey secretKey = keyGenerator.generateKey();
            secretKeyBase64Encode = Base64.encodeBase64String(secretKey.getEncoded());
        } catch (NoSuchAlgorithmException e) {
            logger.error(e.getMessage(), e);
        }
        return secretKeyBase64Encode;
    }



    public byte[] doEncrypt(String srcStr) {
        Cipher cipher = null;
        try {
            cipher = Cipher.getInstance(CIPHER_ALGORITHM);
            SecretKeySpec key = new SecretKeySpec(Base64.decodeBase64(SECRET_KEY), KEY_ALGORITHM);
            cipher.init(Cipher.ENCRYPT_MODE, key);
            return cipher.doFinal(srcStr.getBytes("utf-8"));
        } catch (Exception e) {
            logger.error(e.getMessage(), e);
        }
        return null;
    }

    public byte[] doDecrypt(String srcStr) {
        Cipher cipher = null;
        try {
            cipher = Cipher.getInstance(KEY_ALGORITHM);
            SecretKeySpec key = new SecretKeySpec(Base64.decodeBase64(SECRET_KEY), KEY_ALGORITHM);
            cipher.init(Cipher.DECRYPT_MODE, key);
            return cipher.doFinal(Base64.decodeBase64(srcStr));
        } catch (Exception e) {
            logger.error(e.getMessage(), e);
        }
        return null;
    }

    public String wrap(String keyString) throws Exception {
        KeyGenerator keyGenerator = KeyGenerator.getInstance(KEY_ALGORITHM);
        //初始化密钥生成器，指定密钥长度为128, AES只能128， DES3只能192
        keyGenerator.init(new SecureRandom(SECRET_KEY_SEED.getBytes()));
        SecretKey secretKey = keyGenerator.generateKey();
        secretKeyBase64String = Base64.encodeBase64String(secretKey.getEncoded());
        logger.info("生成的秘钥[decode编码]为: {}", secretKeyBase64String);
        SecretKeySpec secretKeySpec = new SecretKeySpec(secretKey.getEncoded(), KEY_ALGORITHM);
        Cipher cipher = Cipher.getInstance(KEY_ALGORITHM);
        cipher.init(Cipher.WRAP_MODE, secretKeySpec);
        SecretKeySpec key = new SecretKeySpec(keyString.getBytes(), KEY_ALGORITHM);
        byte[] bytes = cipher.wrap(key);
        return Base64.encodeBase64String(bytes);
    }

    public String unwrap(String keyString) throws Exception {
        byte[] rawKey = Base64.decodeBase64(keyString);
        byte[] secretKeyBytes = Base64.decodeBase64(secretKeyBase64String);
        SecretKeySpec secretKeySpec = new SecretKeySpec(secretKeyBytes, KEY_ALGORITHM);
        Cipher cipher = Cipher.getInstance(KEY_ALGORITHM);
        cipher.init(Cipher.UNWRAP_MODE, secretKeySpec);
        SecretKey key = (SecretKey) cipher.unwrap(rawKey, KEY_ALGORITHM, Cipher.SECRET_KEY);
        return new String(key.getEncoded());
    }
 
    public static void main(String[] args) throws Exception {
        String wrapKey = TestAES.SINGLETON.wrap("doge");
        logger.info("wrap {}",wrapKey);
        logger.info("unwrap {}",TestAES.SINGLETON.unwrap("dwUHQhiNS5eh1AHbkCuGTQ=="));


        logger.info(TestAES.SINGLETON.initSecretKey());
        logger.info(TestAES.SINGLETON.initSecretKey());

        byte[] encrypt = TestAES.SINGLETON.doEncrypt("123");
        logger.info("encrypt {}", Base64.encodeBase64String(encrypt));
        byte[] decrypt = TestAES.SINGLETON.doDecrypt(Base64.encodeBase64String(encrypt));
        logger.info("decrypt {}", new String(decrypt));
    }
}