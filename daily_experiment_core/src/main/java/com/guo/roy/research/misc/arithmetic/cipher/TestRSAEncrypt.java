package com.guo.roy.research.misc.arithmetic.cipher;

import org.apache.commons.codec.binary.Base64;
import org.slf4j.LoggerFactory;

import javax.crypto.Cipher;
import java.security.KeyFactory;
import java.security.KeyPair;
import java.security.KeyPairGenerator;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.security.interfaces.RSAPrivateKey;
import java.security.interfaces.RSAPublicKey;
import java.security.spec.PKCS8EncodedKeySpec;
import java.security.spec.X509EncodedKeySpec;

/**
 *
 * 非对称加密
 *
 * 非对称加密用于加解密的密钥不一样，有2个密钥，公钥和私钥，公钥可以公开，私钥妥善保管。
 * RSA、ECC（椭圆曲线加密算法）、DH（密钥交换算法）这些都是非对称加密
 *
 *
 * RSA 密钥交换算法,  非对称
 * 非对称加密算法用私钥加密，用公钥解密，或者用公钥加密，用私钥解密
 *  私钥加密 <-> 公钥解密，或者 公钥加密 <-> 私钥解密
 */
public class TestRSAEncrypt {
    private static final org.slf4j.Logger logger = LoggerFactory.getLogger(TestRSAEncrypt.class);

    private String publicKeyString;//公钥
    private String privateKeyString;//私钥

    public String getPublicKeyString() {
        return publicKeyString;
    }

    public String getPrivateKeyString() {
        return privateKeyString;
    }

    /**
	 * 随机生成密钥对 
	 * @throws NoSuchAlgorithmException 
	 */  
	public  void genKeyPair() throws NoSuchAlgorithmException {
		// KeyPairGenerator类用于生成公钥和私钥对，基于RSA算法生成对象  
		KeyPairGenerator keyPairGen = KeyPairGenerator.getInstance("RSA");  
		// 初始化密钥对生成器，密钥大小为512-1024位
		keyPairGen.initialize(512, new SecureRandom());
		// 生成一个密钥对，保存在keyPair中  
		KeyPair keyPair = keyPairGen.generateKeyPair();  
		RSAPrivateKey privateKey = (RSAPrivateKey) keyPair.getPrivate();   // 得到私钥  
		RSAPublicKey publicKey = (RSAPublicKey) keyPair.getPublic();  // 得到公钥  
		publicKeyString = new String(Base64.encodeBase64(publicKey.getEncoded()));//进行Base64编码
		// 得到私钥字符串  
		privateKeyString = new String(Base64.encodeBase64((privateKey.getEncoded())));//进行Base64编码
	}

	/** 
	 * RSA公钥加密 
	 *  
	 * @param str 
	 *            加密字符串
	 * @param publicKey 
	 *            公钥 
	 * @return 密文 
	 * @throws Exception 
	 *             加密过程中的异常信息 
	 */  
	public  String encryptWithPublicKey(String str, String publicKey ) throws Exception{
		//base64编码的公钥
		byte[] decoded = Base64.decodeBase64(publicKey);
		RSAPublicKey pubKey = (RSAPublicKey) KeyFactory.getInstance("RSA").
                generatePublic(new X509EncodedKeySpec(decoded));
		//RSA加密
		Cipher cipher = Cipher.getInstance("RSA");
		cipher.init(Cipher.ENCRYPT_MODE, pubKey);
		String outStr = Base64.encodeBase64String(cipher.doFinal(str.getBytes("UTF-8")));
		return outStr;
	}

    /**
     * RSA 私钥加密
     *
     * @param str
     *            加密字符串
     * @param privateKey
     *            私钥
     * @return 密文
     * @throws Exception
     *             加密过程中的异常信息
     */
    public  String encryptWithPrivateKey(String str, String privateKey ) throws Exception{
        //base64编码的公钥
        byte[] decoded = Base64.decodeBase64(privateKey);
        RSAPrivateKey priKey = (RSAPrivateKey)
                KeyFactory.
                getInstance("RSA").
                generatePrivate(new PKCS8EncodedKeySpec(decoded));
        //RSA加密
        Cipher cipher = Cipher.getInstance("RSA");
        cipher.init(Cipher.ENCRYPT_MODE, priKey);
        String outStr = Base64.encodeBase64String(cipher.doFinal(str.getBytes("UTF-8")));
        return outStr;
    }

	/** 
	 * RSA 私钥解密
	 *  
	 * @param str 
	 *            加密字符串
	 * @param privateKey 
	 *            私钥 
	 * @return 铭文
	 * @throws Exception 
	 *             解密过程中的异常信息 
	 */  
	public  String decryptWithPrivateKey(String str, String privateKey) throws Exception{
		//64位解码加密后的字符串
		byte[] inputByte = Base64.decodeBase64(str.getBytes("UTF-8"));
		//base64编码的私钥
		byte[] decoded = Base64.decodeBase64(privateKey);  
        RSAPrivateKey priKey = (RSAPrivateKey) KeyFactory.getInstance("RSA").
                generatePrivate(new PKCS8EncodedKeySpec(decoded));
		//RSA解密
		Cipher cipher = Cipher.getInstance("RSA");
		cipher.init(Cipher.DECRYPT_MODE, priKey);
		String outStr = new String(cipher.doFinal(inputByte));
		return outStr;
	}

    /**
     * RSA 公钥解密
     *
     * @param str
     *            加密字符串
     * @param publicKey
     *            私钥
     * @return 铭文
     * @throws Exception
     *             解密过程中的异常信息
     */
    public  String decryptWithPubliceKey(String str, String publicKey) throws Exception{
        //64位解码加密后的字符串
        byte[] inputByte = Base64.decodeBase64(str.getBytes("UTF-8"));
        //base64编码的私钥
        byte[] decoded = Base64.decodeBase64(publicKey);
        RSAPublicKey pubKey = (RSAPublicKey) KeyFactory.getInstance("RSA").
                generatePublic(new X509EncodedKeySpec(decoded));
        //RSA解密
        Cipher cipher = Cipher.getInstance("RSA");
        cipher.init(Cipher.DECRYPT_MODE, pubKey);
        String outStr = new String(cipher.doFinal(inputByte));
        return outStr;
    }

	public static void testRSAEncryptDecrypt(String srcStr) throws Exception {
        TestRSAEncrypt rsaEncrypt = new TestRSAEncrypt();
        //生成公钥和私钥
        rsaEncrypt.genKeyPair();
		//加密字符串
        logger.info("随机生成的公钥为: {}" , rsaEncrypt.getPublicKeyString());
        logger.info("随机生成的私钥为: {}" , rsaEncrypt.getPrivateKeyString());

		String messageEn = rsaEncrypt.encryptWithPublicKey(srcStr, rsaEncrypt.getPublicKeyString());
        logger.info( "{}, 公钥加密后的字符串为: {}" , srcStr , messageEn);
		String messageDe = rsaEncrypt.decryptWithPrivateKey(messageEn, rsaEncrypt.getPrivateKeyString());
        logger.info("私钥解密后的字符串为: {}" , messageDe);

        messageEn = rsaEncrypt.encryptWithPrivateKey(srcStr, rsaEncrypt.getPrivateKeyString());
        logger.info( "{}, 私钥加密后的字符串为: {}" , srcStr , messageEn);
        messageDe = rsaEncrypt.decryptWithPubliceKey(messageEn, rsaEncrypt.getPublicKeyString());
        logger.info("公钥解密后的字符串为: {}" , messageDe);
	}
}