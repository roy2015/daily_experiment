package com.roy.miscellaneous.arithmetic.cipher;

import org.apache.commons.codec.binary.Base64;
import org.slf4j.LoggerFactory;

import java.math.BigInteger;
import java.security.*;
import java.security.spec.*;
import javax.crypto.KeyAgreement;

/**
 * Created by leo on 2019/09/29.
 *
 * ECC:椭圆曲线
 * 椭圆曲线加密算法(ECC) 是基于椭圆曲线数学的一种公钥加密的算法,随着分解大整数方法的进步以及完善、计算机计算速度的提高以及网络的发展，
 * RSA的使用率越来越高.但是为了安全。其密钥的长度一直保守诟病，于是ECC这种新算法逐步走上了现在加密算法的这个大舞台，
 * 其使用率和重要性都在逐年上升,那么今天我们就通过这篇文章来介绍一下椭圆曲线加密算法的初认识之数学基础。
 *
 * 秘钥交换
 */
public class ECCKeyAgreement {
    private static final org.slf4j.Logger logger = LoggerFactory.getLogger(ECCKeyAgreement.class);

    public static void main(String[] args) throws Exception {
        KeyPairGenerator kpg;
        kpg = KeyPairGenerator.getInstance("EC","SunEC");
        ECGenParameterSpec ecsp;

        ecsp = new ECGenParameterSpec("secp128r2");//生成的最终秘钥是16位
//        ecsp = new ECGenParameterSpec("secp192k1");//素域椭圆曲线secp192k1 生成的最终秘钥是24位
//        ecsp = new ECGenParameterSpec("secp256k1");//素域椭圆曲线secp256k1 生成的最终秘钥是32位
        kpg.initialize(ecsp);

        KeyPair kpU = kpg.genKeyPair();
        PrivateKey privKeyU = kpU.getPrivate();
        PublicKey pubKeyU = kpU.getPublic();
        logger.info("User U privKeyU(Base64): {}" , Base64.encodeBase64String(privKeyU.getEncoded()));
        logger.info("User U pubKeyU(Base64): {}" , Base64.encodeBase64String(pubKeyU .getEncoded()));

        KeyPair kpV = kpg.genKeyPair();
        PrivateKey privKeyV = kpV.getPrivate();
        PublicKey pubKeyV = kpV.getPublic();
        logger.info("User V privKeyV(Base64): {}" , Base64.encodeBase64String(privKeyV.getEncoded()) );
        logger.info("User V pubKeyV(Base64): {}" , Base64.encodeBase64String(pubKeyV .getEncoded()));

        KeyAgreement ecdhU = KeyAgreement.getInstance("ECDH");
        ecdhU.init(privKeyU);
        ecdhU.doPhase(pubKeyV,true);

        KeyAgreement ecdhV = KeyAgreement.getInstance("ECDH");
        ecdhV.init(privKeyV);
        ecdhV.doPhase(pubKeyU,true);

        byte[] bytes = ecdhU.generateSecret();

        logger.info("Secret computed by U(Base64): {}" ,
                Base64.encodeBase64String(ecdhU.generateSecret()));
        logger.info("Secret computed by V(Base64): {}" ,
                Base64.encodeBase64String(ecdhV.generateSecret()));
    }
}