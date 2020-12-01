package com.roy.miscellaneous.arithmetic;

import cn.hutool.crypto.digest.MD5;

import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/**
 * MD5信息摘要算法（英语：MD5 Message-Digest Algorithm），一种被广泛使用的密码散列函数，可以产生出一个128位（16字节）
 * 的散列值（hash value），用于确保信息传输完整一致。MD5由美国密码学家罗纳德·李维斯特（Ronald Linn Rivest）设计，
 * 于1992年公开，用以取代MD4算法。这套算法的程序在 RFC 1321 标准中被加以规范。1996年后该算法被证实存在弱点，
 * 可以被加以破解，对于需要高度安全性的数据，专家一般建议改用其他算法，如SHA-2。2004年，证实MD5算法
 * 无法防止碰撞（collision），因此不适用于安全性认证，如SSL公开密钥认证或是数字签名等用途。
 *
 */
public class MD5Util {
    /**
     *
     *
     *
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
     * 同上，末尾加盐
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
	    String passW = "TMS";
	    String salt = "郭";
        //不加盐
	    String mdStr = md5(passW);
        String mdHutoolStr = new MD5().digestHex(passW);
        //末尾加盐
        String mdSaltStr = md5(passW, salt);
        //hutool自带， 末尾加盐，一次摘要
        String mdHutoolSaltStr = new MD5(salt.getBytes(), passW.getBytes().length, 1).digestHex(passW);
        String md1Str = md5_1(passW);
        String md2Str = md5_2(passW);
        System.out.println(String.format("mdStr: %s ,mdStr.length(): %s", mdStr, mdStr.length()));
        System.out.println(String.format("mdHutoolStr: %s ,mdHutoolStr.length(): %s", mdHutoolStr, mdHutoolStr.length()));
        System.out.println(String.format("mdStrSalt: %s ,mdSaltStr.length(): %s", mdSaltStr, mdSaltStr.length()));
        System.out.println(String.format("mdHutoolSaltStr: %s ,mdHutoolSaltStr.length(): %s", mdHutoolSaltStr, mdHutoolSaltStr.length()));
        System.out.println(String.format("md1Str: %s ,md1Str.length(): %s", md1Str, md1Str.length()));
        System.out.println(String.format("md2Str: %s ,md2Str.length(): %s", md2Str, md2Str.length()));

        System.out.println(String.format("3%s3", new String(new byte[]{-32})));

	}
}