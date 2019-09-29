package com.roy.miscellaneous.arithmetic.cipher;

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
 * Created by apple on 2019/8/6.
 * 对称加密
 * AES、3DES
 *
 * 三重des算法（DESede）
 *
 * SecretKeySpec key可以指定但必须是24位，也可以走KeyGenerator生成, initSecretKey就是后面一种
 */
public class TestDES3 {
    private static final org.slf4j.Logger logger = LoggerFactory.getLogger(TestDES3.class);
    //SECRET_KEY: 对称秘钥  DESede必须是24位字节数组, AES必须是16位字节数组，这里被编码成String了!!注意下
    private static String SECRET_KEY = "ZgYRBq5D1MArTx9cU/n4Ig/pQCz/LkCvc9cEj9NNHLQ=" ;

    private static final String KEY_ALGORITHM = "DESede";//key 算法  AES or DESede
    private static final String DEFAULT_CIPHER_ALGORITHM = "DESede/ECB/PKCS5Padding";// 默认的加密算法 含义：算法/工作模式/填充

    private SecretKeySpec key ;

    private  void initSecretKey(String keyStr) {
        //返回生成指定算法密钥生成器的KeyGenerator 对象
        KeyGenerator kg = null;
        try {
            kg = KeyGenerator.getInstance(KEY_ALGORITHM);
            kg.init(new SecureRandom(keyStr.getBytes("utf-8")));
            //生成一个密钥
            SecretKey secretKey = kg.generateKey();
            SECRET_KEY = Base64.encodeBase64String (secretKey.getEncoded());
            logger.info("对称秘钥:{}", SECRET_KEY);
//             转换为DESede专用密钥
        } catch (NoSuchAlgorithmException e) {
            logger.error(e.getMessage(), e);
        } catch (UnsupportedEncodingException e) {
            logger.error(e.getMessage(), e);
        }
    }

    /**
     *  加密
     * @param srcStr 需要加密的字符串
     * @return
     */
    public byte[] doEncrypt(String srcStr) {
        Cipher cipher = null;
        try {
            cipher = Cipher.getInstance(DEFAULT_CIPHER_ALGORITHM);
            SecretKeySpec key = new SecretKeySpec(Base64.decodeBase64(SECRET_KEY) , KEY_ALGORITHM);
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

    public String doDecrypt(byte[] srcbytes) {
        Cipher cipher = null;
        try {
            cipher = Cipher.getInstance(DEFAULT_CIPHER_ALGORITHM);
            SecretKeySpec key = new SecretKeySpec(Base64.decodeBase64(SECRET_KEY), KEY_ALGORITHM);
            cipher.init(Cipher.DECRYPT_MODE, key);
            byte[] bytes = cipher.doFinal(srcbytes);
            return new String(bytes, "utf-8");
        } catch (NoSuchAlgorithmException e) {
            logger.error(e.getMessage(), e);
        } catch (NoSuchPaddingException e) {
            logger.error(e.getMessage(), e);
        } catch (BadPaddingException e) {
            logger.error(e.getMessage(), e);
        } catch (UnsupportedEncodingException e) {
            logger.error(e.getMessage(), e);
        } catch (IllegalBlockSizeException e) {
            logger.error(e.getMessage(), e);
        } catch (InvalidKeyException e) {
            logger.error(e.getMessage(), e);
        }
        return null;
    }

    public static void testDES3(String srcStr) throws UnsupportedEncodingException {
        logger.info("源字符串为：{} ", srcStr );
        TestDES3 des3 = new TestDES3();
//        des3.initSecretKey("bg244210");

        byte[] encryptBytes = des3.doEncrypt(srcStr);
        logger.info("加密后：{} ", new String(encryptBytes, "utf-8") );
        String encodeBase64String = Base64.encodeBase64String(encryptBytes);
        logger.info("加密后base64Encode：{} ", encodeBase64String);
        String encodeHexString = Hex.encodeHexString(encryptBytes);
        logger.info("加密后HexEncode：{} ", encodeHexString);
        logger.info("加密后：{} ", new String(Base64.decodeBase64(encodeBase64String), "UTF-8") );
        logger.info("解密 {}", des3.doDecrypt(encryptBytes));


    }



}
