package com.roy.miscellaneous.arithmetic;

import org.apache.commons.codec.binary.Hex;
 
import javax.crypto.Cipher;
import javax.crypto.KeyGenerator;
import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;
import java.security.SecureRandom;
 
/**
 * @author
 * @version v1.0
 * @description
 * @since 2019/8/15 1:06
 */
public enum Part {
 
	/**
     * SINGLETON
	 */
	SINGLETON;
 
	private static final String PASSWORD = "throwable";
	private String secretKeyHexString ;
 
	private Cipher createCipher() throws Exception {
		return Cipher.getInstance("AES");
	}
 
	public String encrypt(String content) throws Exception {
		Cipher cipher = createCipher();
		KeyGenerator keyGenerator = KeyGenerator.getInstance("AES");
		//因为AES要求密钥的长度为128bits，我们需要固定的密码，因此随机源的种子需要设置为我们的密码数组
		keyGenerator.init(128, new SecureRandom(PASSWORD.getBytes()));
		SecretKey secretKey = keyGenerator.generateKey();
		secretKeyHexString = Hex.encodeHexString(secretKey.getEncoded());
        System.out.println("密钥为：" + secretKeyHexString);
        SecretKeySpec secretKeySpec = new SecretKeySpec(secretKey.getEncoded(), "AES");
		//基于加密模式和密钥初始化Cipher
		cipher.init(Cipher.ENCRYPT_MODE, secretKeySpec);
		byte[] raw = content.getBytes();
		StringBuilder builder = new StringBuilder();
		//[0,9]
		byte[] first = cipher.update(raw, 0, 10);
		builder.append(Hex.encodeHexString(first));
		//[10,19]
		byte[] second = cipher.update(raw, 10, 10);
		builder.append(Hex.encodeHexString(second));
		//[20,25]
		byte[] third = cipher.update(raw, 20, 6);
		builder.append(Hex.encodeHexString(third));
		//多部分加密结束，得到最后一段加密的结果，重置Cipher
		byte[] bytes = cipher.doFinal();
		String last = Hex.encodeHexString(bytes);
		builder.append(last);
		return builder.toString();
	}
 
	public String decrypt(String content) throws Exception {
		byte[] raw = Hex.decodeHex(content.toCharArray());
		Cipher cipher = createCipher();
		SecretKeySpec secretKeySpec = new SecretKeySpec(Hex.decodeHex(secretKeyHexString.toCharArray()), "AES");
		//基于解密模式和密钥初始化Cipher
		cipher.init(Cipher.DECRYPT_MODE, secretKeySpec);
		StringBuilder builder = new StringBuilder();
		//[0,14]
		byte[] first = cipher.update(raw, 0, 15);
		builder.append(new String(first));
		//[15,29]
		byte[] second = cipher.update(raw, 15, 15);
		builder.append(new String(second));
		//[30,31]
		byte[] third = cipher.update(raw, 30, 2);
		builder.append(new String(third));
		//多部分解密结束，得到最后一段解密的结果，重置Cipher
		byte[] bytes = cipher.doFinal();
		builder.append(new String(bytes));
		return builder.toString();
	}
 
	public static void main(String[] args) throws Exception{
		String raw = "abcdefghijklmnopqrstyuwxyz";
		String e = Part.SINGLETON.encrypt(raw);
		System.out.println(e);
		System.out.println(Part.SINGLETON.decrypt(e));
	}
}