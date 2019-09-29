package com.roy.miscellaneous.arithmetic.cipher;

import org.apache.commons.codec.binary.Base64;
import org.apache.commons.codec.binary.Hex;
import org.slf4j.LoggerFactory;

import java.io.UnsupportedEncodingException;
import java.security.*;
import java.security.interfaces.RSAPrivateKey;
import java.security.interfaces.RSAPublicKey;
import java.security.spec.InvalidKeySpecException;
import java.security.spec.PKCS8EncodedKeySpec;
import java.security.spec.X509EncodedKeySpec;

/**
 * Created by apple on 2019/8/6.
 *
 * 数字签名:带有密钥（公钥、私钥）的消息摘要算法（使用私钥进行签名，使用公钥进行验证）
 * 数字签名算法：RSA、DSA、ECDSA
 * 数字签名特性：
 *   验证数据完整性
 *   认证数据来源
 *   抗否认性
 * 经典算法
 * MD、SHA两类
 *
 *  https://www.cnblogs.com/chengxuyuanzhilu/p/5194306.html
 *
 *
 *
 * RSA 签名  私钥签名，公钥验签
 */
public class TestRsaSignature {
    private static final org.slf4j.Logger logger = LoggerFactory.getLogger(TestRsaSignature.class);

    private String publicKeyString;//公钥
    private String privateKeyString;//私钥

    /**
     * 随机生成密钥对
     * @throws NoSuchAlgorithmException
     */
    public  void genKeyPair() throws NoSuchAlgorithmException {
        // KeyPairGenerator类用于生成公钥和私钥对，基于RSA算法生成对象
        KeyPairGenerator keyPairGen = KeyPairGenerator.getInstance("RSA");
        // 初始化密钥对生成器，密钥大小为512-1024位
        keyPairGen.initialize(512,new SecureRandom());
        // 生成一个密钥对，保存在keyPair中
        KeyPair keyPair = keyPairGen.generateKeyPair();
        RSAPrivateKey privateKey = (RSAPrivateKey) keyPair.getPrivate();   // 得到私钥
        RSAPublicKey publicKey = (RSAPublicKey) keyPair.getPublic();  // 得到公钥
        publicKeyString = new String(Base64.encodeBase64(publicKey.getEncoded()));//进行Base64编码
        // 得到私钥字符串
        privateKeyString = new String(Base64.encodeBase64((privateKey.getEncoded())));//进行Base64编码
    }

    /**
     * 私钥签名
     * @param srcStr
     */
    public byte[] doSignature(String srcStr)  {
        //base64编码的私钥
        byte[] decodedPrivKeyStr = Base64.decodeBase64(privateKeyString);
        RSAPrivateKey priKey = null;
        try {
            priKey = (RSAPrivateKey) KeyFactory.getInstance("RSA").
                    generatePrivate(new PKCS8EncodedKeySpec(decodedPrivKeyStr));
            Signature signature = Signature.getInstance("MD5withRSA");
            signature.initSign(priKey);
            signature.update(srcStr.getBytes("utf-8"));
            return signature.sign();
        } catch (InvalidKeySpecException e) {
            logger.error(e.getMessage(), e);
        } catch (NoSuchAlgorithmException e) {
            logger.error(e.getMessage(), e);
        } catch (UnsupportedEncodingException e) {
            logger.error(e.getMessage(), e);
        } catch (SignatureException e) {
            logger.error(e.getMessage(), e);
        } catch (InvalidKeyException e) {
            logger.error(e.getMessage(), e);
        }
        return null;
    }

    /**
     * 公钥验签名
     * @param srcStr 源字符串
     * @param signatureBytes 签名
     */
    public boolean doVerifySignature(String srcStr, byte[] signatureBytes)  {
        boolean verify = false;
        //base64编码的公钥
        byte[] decodedPublicKeyStr = Base64.decodeBase64(publicKeyString);
        RSAPublicKey pubKey = null;
        try {
            pubKey = (RSAPublicKey) KeyFactory.getInstance("RSA").
                    generatePublic(new X509EncodedKeySpec(decodedPublicKeyStr));
            Signature signature = Signature.getInstance("MD5withRSA");
            signature.initVerify(pubKey);
            signature.update(srcStr.getBytes("utf-8"));
            verify = signature.verify(signatureBytes);
        } catch (InvalidKeySpecException e) {
            logger.error(e.getMessage(), e);
        } catch (NoSuchAlgorithmException e) {
            logger.error(e.getMessage(), e);
        } catch (UnsupportedEncodingException e) {
            logger.error(e.getMessage(), e);
        } catch (SignatureException e) {
            logger.error(e.getMessage(), e);
        } catch (InvalidKeyException e) {
            logger.error(e.getMessage(), e);
        }
        return verify;
    }


    public static void testRsaSignature(String str) throws UnsupportedEncodingException, NoSuchAlgorithmException {
        TestRsaSignature testRsaSignature = new TestRsaSignature();
        try {
            testRsaSignature.genKeyPair();
        } catch (NoSuchAlgorithmException e) {
            logger.error("算法不存在");
            throw e;
        }
        logger.info("随机生成的公钥为: {}" , testRsaSignature.getPublicKeyString());
        logger.info("随机生成的私钥为: {}" , testRsaSignature.getPrivateKeyString());
        byte[] bytesSig = testRsaSignature.doSignature(str);//签名

        logger.info("签名： {}", new String(bytesSig, "utf-8"));
        String base64String = Base64.encodeBase64String(bytesSig);
        logger.info("签名base64： {}", base64String);
        String hexString = Hex.encodeHexString(bytesSig);
        logger.info("签名HEX： {}", hexString);
        logger.info("验证签名: 结果 {}", testRsaSignature.doVerifySignature(str, "1234567890123456789012345678901234567890123456789012345678901234".getBytes()));
        logger.info("验证签名: 结果 {}", testRsaSignature.doVerifySignature(str, bytesSig));
    }

    public String getPublicKeyString() {
        return publicKeyString;
    }

    public String getPrivateKeyString() {
        return privateKeyString;
    }
}



