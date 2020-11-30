package com.roy.miscellaneous.arithmetic;

import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class MD5Util {
    /**
     * 来自stackoverflow的MD5计算方法，调用了MessageDigest库函数，并把byte数组结果转换成16进制
     *
     * 输出32位字符串， 字符范围16进制的字符"0-9 a-f"
     * @param src
     * @return  输出32位字符串,可以更加需要
     */
	public static String md5(String src) {
		if (src == null)
			throw new IllegalArgumentException("Password can NOT be null");
		
		try {
			MessageDigest md = MessageDigest.getInstance("MD5");
			//16个byte， 128bit
			byte[] array = md.digest(src.getBytes());
			StringBuffer sb = new StringBuffer();
			for (int i = 0; i < array.length; ++i) {
				sb.append(Integer.toHexString((array[i] & 0xFF) | 0x100)
						.substring(1, 3));
			}
			return sb.toString();
		} catch (NoSuchAlgorithmException e) {}
		return null;
	}

    /**
     * 同上，加盐
     * @param src
     * @param salt
     * @return
     */
    public static String md5(String src, String salt) {
        String completeStr = src.concat(salt);
        return md5(completeStr);
    }

    /**
     * 基线版 强行转str，出现乱码的 比如：�ب�@�M�?u�N��4
     * @param src
     * @return  输出长度不固定
     */
	public static String md5_1(String src) {
		if (src == null)
			throw new IllegalArgumentException("Password can NOT be null");

		try {
			MessageDigest md = MessageDigest.getInstance("MD5");
			byte[] array = md.digest(src.getBytes());
			return new String(array, "utf-8");

		} catch (Exception e) {}
		return null;
	}

    /**
     * 基线版本， 强行hexString,最后输出长度不固定，因为md.digest输出为16字节，有正负数，
     * 按补码计算长度肯定不固定
     * @param src
     * @return 输出长度不固定
     */
	public static String md5_2(String src) {
        if (src == null)
            throw new IllegalArgumentException("Password can NOT be null");
        
        try {
            MessageDigest md = MessageDigest.getInstance("MD5");
            byte[] array = md.digest(src.getBytes());
            StringBuffer sb = new StringBuffer();
            for (int i = 0; i < array.length; ++i) {
                sb.append(Integer.toHexString((array[i])));
            }
            return sb.toString();
        } catch (NoSuchAlgorithmException e) {}
        return null;
    }
	
	public static void main(String[] args) {
		System.out.println(Integer.toHexString(123));
        String mdStr = md5("123");
        String mdSaltStr = md5("123", "a");
        String md1Str = md5_1("123124guoj1");
        String md2Str = md5_2("1234");
        System.out.println(String.format("mdStr: %s ,mdStr.length(): %s", mdStr, mdStr.length()));
        System.out.println(String.format("mdStrSalt: %s ,mdSaltStr.length(): %s", mdSaltStr, mdSaltStr.length()));
        System.out.println(String.format("md1Str: %s ,md1Str.length(): %s", md1Str, md1Str.length()));
        System.out.println(String.format("md2Str: %s ,md2Str.length(): %s", md2Str, md2Str.length()));

        System.out.println(String.format("3%s3", new String(new byte[]{-32})));

	}
}