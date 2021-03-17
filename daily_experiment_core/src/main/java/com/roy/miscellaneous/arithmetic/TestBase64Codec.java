package com.roy.miscellaneous.arithmetic;

import org.apache.commons.codec.binary.Base64;
import org.slf4j.LoggerFactory;

import java.io.UnsupportedEncodingException;
import java.nio.charset.Charset;

/**
 * Created by apple on 2019/8/6.
 *
 *  Base64编码要求把3个8位字节（3*8=24）转化为4个6位的字节（4*6=24），之后在6位的前面补两个0，形成8位一个字节的形式。
 *  如果剩下的字符不足3个字节，则用0填充，输出字符使用'='，因此编码后输出的文本末尾可能会出现1或2个'='。
 *  Base64编码后的长度不固定，如果原文是3n byte(不足3补)(3*8*n bit => 4*6*n bit => 4*8*n bit, 4n个字节/字符), 3n个字节=》4n个字节
 *  原文线性增长三分之一,
 *  举例：比如Base64编码MD5后的byte[] a, a是16byte, 16约等于18, 18+18*(1/3)=24
 *
 *  总结： 3的整数个字符BASE64后不会出现=
 *
 */
public class TestBase64Codec {
    private static final org.slf4j.Logger logger = LoggerFactory.getLogger(TestBase64Codec.class);

    /**
     * 编码
     * @param src
     */
    public static void testBase64Encode(String src) throws UnsupportedEncodingException {
        byte[] srcBytes = src.getBytes(Charset.forName("UTF-8"));
        byte[] encodeBytes = Base64.encodeBase64(srcBytes);
        logger.info("base64编码前 ：{}, length:{}", src, srcBytes.length);
        logger.info("base64编码后：{}, length:{}",new String(encodeBytes, "utf-8"), encodeBytes.length);
    }

    /**
     * 解码
     * @param src
     */
    public static void testBase64Decode(String src) throws UnsupportedEncodingException {
        logger.info("base64解码前：{}", src);
        byte[] bytes = Base64.decodeBase64(src);
        logger.info("base64解码后：{}", new String(bytes, "utf-8"));
    }

    public static void main(String[] args) throws Exception {
        testBase64Encode("01234567890000");
        testBase64Decode("MTIzNDU2");
    }

}
