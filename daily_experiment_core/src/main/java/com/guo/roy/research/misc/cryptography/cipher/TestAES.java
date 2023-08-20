package com.guo.roy.research.misc.cryptography.cipher;

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


    /**
     * base64编码后的secret_key,  AES必须是16位字节数组
     * 所以是32位(24扩大三分之一)
     *
     * java 原生jdk默认只有AES128，生成128位的对称密钥 AES128, 192, 256
     */
    private static String SECRET_KEY = "wIoq0AfVEpjZlpHGa3AYjQ==";//24*3/4=16   24 32
    private String secretKeyBase64Encode ;
    private static String KEY_ALGORITHM = "AES";
    private static String CIPHER_ALGORITHM = "AES/ECB/PKCS5Padding";

    /**
     * 初始化，生成随机秘钥
     * @return
     */
    public String initSecretKey() {
        KeyGenerator keyGenerator = null;
        try {
            keyGenerator = KeyGenerator.getInstance(KEY_ALGORITHM);
            //初始化密钥生成器，128可以不指定，指定密钥长度为128，指定随机源的种子为指定的密钥(这里是"passward")
            keyGenerator.init(new SecureRandom());//SECRET_KEY_SEED密钥种子指定时，secretKey.getEncoded()固定，不传secretKey.getEncoded()就随机
            SecretKey secretKey = keyGenerator.generateKey();
            secretKeyBase64Encode = Base64.encodeBase64String(secretKey.getEncoded());
        } catch (NoSuchAlgorithmException e) {
            logger.error(e.getMessage(), e);
        }
        return secretKeyBase64Encode;
    }

    /**
     * getSecretKeyBase64Encode
     * @return
     */
    public String getSecretKeyBase64Encode(){
        return secretKeyBase64Encode;
    }


    /**
     * 加密
     * @param srcStr
     * @return
     */
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

    /**
     * 解密
     * @param srcStr
     * @return
     */
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

    /**
     * wrap秘钥
     * @return
     * @throws Exception
     */
    public String wrap() throws Exception {

        byte[] secretKeyBytes = Base64.decodeBase64(secretKeyBase64Encode);
        SecretKeySpec secretKeySpec = new SecretKeySpec(secretKeyBytes, KEY_ALGORITHM);
        Cipher cipher = Cipher.getInstance(KEY_ALGORITHM);
        cipher.init(Cipher.WRAP_MODE, secretKeySpec);
        SecretKeySpec key = new SecretKeySpec(secretKeyBase64Encode.getBytes(), KEY_ALGORITHM);
        byte[] bytes = cipher.wrap(key);
        return Base64.encodeBase64String(bytes);
    }

    /**
     * unwrap秘钥
     * @param keyString
     * @return
     * @throws Exception
     */
    public String unwrap(String keyString) throws Exception {
        byte[] rawKey = Base64.decodeBase64(keyString);
        byte[] secretKeyBytes = Base64.decodeBase64(secretKeyBase64Encode);
        SecretKeySpec secretKeySpec = new SecretKeySpec(secretKeyBytes, KEY_ALGORITHM);
        Cipher cipher = Cipher.getInstance(KEY_ALGORITHM);
        cipher.init(Cipher.UNWRAP_MODE, secretKeySpec);
        SecretKey key = (SecretKey) cipher.unwrap(rawKey, KEY_ALGORITHM, Cipher.SECRET_KEY);
        return new String(key.getEncoded());
    }
 
    public static void main(String[] args) throws Exception {
        TestAES.SINGLETON.initSecretKey();
        logger.info("生成的秘钥[decode编码]为: {}", TestAES.SINGLETON.getSecretKeyBase64Encode());

        String wrapKey = TestAES.SINGLETON.wrap();
        logger.info("wrap秘钥安全传输 {}",wrapKey);
        logger.info("unwrap秘钥 {}",TestAES.SINGLETON.unwrap(wrapKey));

        logger.info("生成的秘钥[decode编码]为: {}", TestAES.SINGLETON.getSecretKeyBase64Encode());

        byte[] encrypt = TestAES.SINGLETON.doEncrypt("1231111111111111aaaaa");
        logger.info("encrypt {}", Base64.encodeBase64String(encrypt));
        byte[] decrypt = TestAES.SINGLETON.doDecrypt(Base64.encodeBase64String(encrypt));
        logger.info("decrypt {}", new String(decrypt));
    }
}