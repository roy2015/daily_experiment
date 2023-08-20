package com.guo.roy.research.misc.cryptography.cipher;

import org.apache.commons.codec.binary.Base64;
import org.apache.commons.codec.binary.Hex;
import org.slf4j.LoggerFactory;

import javax.crypto.Mac;
import javax.crypto.spec.SecretKeySpec;
import java.io.UnsupportedEncodingException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.security.Security;
import java.util.Set;

/**
 * Created by apple on 2019/8/6.
 *
 *
 * 消息认证码
 * MAC，全称 Message Authentication Code，也称为消息认证码（带密钥的Hash函数），
 * 通信实体双方使用的一种验证机制，保证消息数据完整性的一种工具
 * HMACMD5/HMACSHA256
 */
public class TestMac {

    private static final org.slf4j.Logger logger = LoggerFactory.getLogger(TestRSAEncrypt.class);
    private static String SECRET_KEY = "tlnvzhbGN08G4pAGVbTLoPxxkY/1H1xX++L5q2ekU+RK3eXw==";

    private static final String KEY_ALGORITHM = "DESede";

    /**
     *
     * @param algorithm jdk支持的算法
     * @param data  元数据
     * @return
     * @throws NoSuchAlgorithmException
     * @throws UnsupportedEncodingException
     * @throws InvalidKeyException
     */
    public static byte[] mac(String algorithm, byte[] data) throws NoSuchAlgorithmException,
            UnsupportedEncodingException, InvalidKeyException {
        Mac mac = Mac.getInstance(algorithm);
//        SecretKeySpec key = new SecretKeySpec(SECRET_KEY.getBytes("utf-8"), "");
        SecretKeySpec key = new SecretKeySpec(SECRET_KEY.getBytes("utf-8"), KEY_ALGORITHM);
        mac.init(key);///这里是关键，需要一个key（这里就是和普通的消息摘要的区别点）
        byte[] result = mac.doFinal(data);
        return result;
    }

    /**
     *
     * @param srcStr
     * @throws UnsupportedEncodingException
     */
    public static void testMac(String srcStr) throws UnsupportedEncodingException, InvalidKeyException,
            NoSuchAlgorithmException {
        Set<String> mac = Security.getAlgorithms("Mac");
        logger.info("支持的MAC算法列表：");
        for (String s : mac) {
            logger.info(s);
        }

        byte[] bytes = srcStr.getBytes("utf-8");
        //把摘要后的结果转换成十六进制的字符串（也可以使用Base64进行编码）
        String hmacmd5 = Hex.encodeHexString(mac("HMACMD5", bytes));
        String hmacsha1 = Hex.encodeHexString(mac("HMACSHA256", bytes));
        //把摘要后的结果用Base64进行编码
        String encodeBase64 = new String(Base64.encodeBase64(mac("HMACMD5", bytes)),"utf-8");

        logger.info("mac {}:  {}", "HMACMD5", hmacmd5);
        logger.info("mac {}:  {}", "HMACSHA1", hmacsha1);
        logger.info("mac {}:   base64Encode {}", "HMACMD5", encodeBase64);
    }

}
