package com.roy.miscellaneous.arithmetic;

import com.alibaba.druid.filter.config.ConfigTools;
import com.roy.miscellaneous.TestDigitalArithmetic;
import org.slf4j.LoggerFactory;

import java.security.NoSuchAlgorithmException;

/**
 * @author guojun
 * @date 2019-12-06
 *
 * 测试druid加解密
 *
 */
public class TestDruidDeEncrypt {
    private static final org.slf4j.Logger logger = LoggerFactory.getLogger(TestDigitalArithmetic.class);

    static class Solution {
        /**
         *
         * 返回解密的密码
         *
         * @param publicKey  公钥
         * @param password   密码密文
         * @return
         */
        public String doDecrypt(String publicKey, String password) {
            try {
                String retStr = ConfigTools.decrypt(publicKey, password);
                return retStr;
            } catch (Exception e) {
                logger.error(e.getMessage(), e);
                return null;
            }
        }

        /**
         * 加密，打印私钥公钥
         * @param password
         */
        public void doEncrypt (String password) {
            try {
                String[] keyPair = ConfigTools.genKeyPair(512);

                logger.info("私钥：{}", keyPair[0]);
                logger.info("公钥：{}", keyPair[1]);
                logger.info("密码：{}", ConfigTools.encrypt(keyPair[0], password));

            } catch (NoSuchAlgorithmException e) {
                logger.error(e.getMessage(), e);
            } catch (Exception e) {
                logger.error(e.getMessage(), e);
            }
        }


    }


    public static void main(String[] args) {
        String publickey = "MFwwDQYJKoZIhvcNAQEBBQADSwAwSAJBAJ4fbYqIqnCOZsBFBgIMDR1RRXJlHAYToucBnp0IUX7sVW1w9xnuBSgj68VJN0wpQxy+y820RTwQ52rr8TJJY5MCAwEAAQ==";
        String password = "KfpvDsK1EO3JZdPNCh16Rn9UaQeiWkcf9hOv6zmIRBPuy7IvvqDZTIdPNur8yP2/iHuaIwP3SVgkxPmY//MHmA==";
        String s = new Solution().doDecrypt(publickey, password);
        logger.debug(s);
        new Solution().doEncrypt("Itsme@999");
    }

}
