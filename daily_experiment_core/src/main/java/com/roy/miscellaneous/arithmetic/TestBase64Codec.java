package com.roy.miscellaneous.arithmetic;

import org.apache.commons.codec.binary.Base64;
import org.slf4j.LoggerFactory;

import java.io.UnsupportedEncodingException;
import java.nio.charset.Charset;

/**
 * Created by apple on 2019/8/6.
 *
 *
 *
 */
public class TestBase64Codec {
    private static final org.slf4j.Logger logger = LoggerFactory.getLogger(TestBase64Codec.class);

    /**
     * 编码
     * @param src
     */
    public static void testBase64Encode(String src) throws UnsupportedEncodingException {
        byte[] bytes = Base64.encodeBase64(src.getBytes("utf-8"));
        logger.info("base64编码前：{}", src);
        logger.info("base64编码后：{}", new String(bytes, "utf-8"));
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

}
