package com.roy.miscellaneous.arithmetic.cipher;

import com.sun.xml.internal.rngom.parse.host.Base;
import org.apache.commons.codec.binary.Base64;
import org.apache.commons.codec.binary.Hex;
import org.slf4j.LoggerFactory;

import javax.crypto.*;
import javax.crypto.spec.SecretKeySpec;
import java.io.UnsupportedEncodingException;
import java.security.InvalidKeyException;
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
    private static final String SECRECT = "passwrod";
    private String secretKeyHexString = "8c3f9fe5e8b1641790b51de9f1f22f49";

    public String wrap(String keyString) throws Exception {
        KeyGenerator keyGenerator = KeyGenerator.getInstance("AES");
        //初始化密钥生成器，指定密钥长度为128，指定随机源的种子为指定的密钥(这里是"passward")
        keyGenerator.init(128, new SecureRandom(SECRECT.getBytes()));
        SecretKey secretKey = keyGenerator.generateKey();
        secretKeyHexString = Hex.encodeHexString(secretKey.getEncoded());
        logger.info("生成的秘钥[HEX编码]为: {}", secretKeyHexString);
        SecretKeySpec secretKeySpec = new SecretKeySpec(secretKey.getEncoded(), "AES");
        Cipher cipher = Cipher.getInstance("AES");
        cipher.init(Cipher.WRAP_MODE, secretKeySpec);
        SecretKeySpec key = new SecretKeySpec(keyString.getBytes(), "AES");
        byte[] bytes = cipher.wrap(key);
        return Hex.encodeHexString(bytes);
    }
 
    public String unwrap(String keyString) throws Exception {
        byte[] rawKey = Hex.decodeHex(keyString.toCharArray());
        byte[] secretKeyBytes = Hex.decodeHex(secretKeyHexString.toCharArray());
        SecretKeySpec secretKeySpec = new SecretKeySpec(secretKeyBytes, "AES");
        Cipher cipher = Cipher.getInstance("AES");
        cipher.init(Cipher.UNWRAP_MODE, secretKeySpec);
        SecretKey key = (SecretKey) cipher.unwrap(rawKey, "AES", Cipher.SECRET_KEY);
        return new String(key.getEncoded());
    }

    public byte[] doEncrypt(String srcStr) {
        Cipher cipher = null;
        try {
            cipher = Cipher.getInstance("AES");
            SecretKeySpec key = new SecretKeySpec(Base64.decodeBase64("QeYT66chJxxKkPhQiyO5ZQ=="), "AES");
            cipher.init(Cipher.ENCRYPT_MODE, key);
            return cipher.doFinal(srcStr.getBytes("utf-8"));
        } catch (NoSuchAlgorithmException e) {
            logger.error(e.getMessage(), e);
        } catch (NoSuchPaddingException e) {
            logger.error(e.getMessage(), e);
        } catch (UnsupportedEncodingException e) {
            logger.error(e.getMessage(), e);
        } catch (InvalidKeyException e) {
            logger.error(e.getMessage(), e);
        } catch (BadPaddingException e) {
            logger.error(e.getMessage(), e);
        } catch (IllegalBlockSizeException e) {
            logger.error(e.getMessage(), e);
        }
        return null;
    }

    public byte[] doDecrypt(String srcStr) {
        Cipher cipher = null;
        try {
            cipher = Cipher.getInstance("AES");
            SecretKeySpec key = new SecretKeySpec(Base64.decodeBase64("QeYT66chJxxKkPhQiyO5ZQ=="), "AES");
            cipher.init(Cipher.DECRYPT_MODE, key);
            return cipher.doFinal(Base64.decodeBase64(srcStr));
        } catch (NoSuchAlgorithmException e) {
            logger.error(e.getMessage(), e);
        } catch (NoSuchPaddingException e) {
            logger.error(e.getMessage(), e);
        } catch (InvalidKeyException e) {
            logger.error(e.getMessage(), e);
        } catch (BadPaddingException e) {
            logger.error(e.getMessage(), e);
        } catch (IllegalBlockSizeException e) {
            logger.error(e.getMessage(), e);
        }
        return null;
    }
 
    public static void main(String[] args) throws Exception {
//        String wrapKey = TestAES.SINGLETON.wrap("doge");
//        logger.info(wrapKey);
        logger.info(TestAES.SINGLETON.unwrap("16556ad39dcd597344eb7047859f8b01"));
        byte[] encrypt = TestAES.SINGLETON.doEncrypt("123");
        logger.info("{}", new String(encrypt));
        byte[] decrypt = TestAES.SINGLETON.doDecrypt(Base64.encodeBase64String(encrypt));
        logger.info("{}", new String(decrypt));
    }
}