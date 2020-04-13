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
        String password = "qrOviCexREIlr2gvNH3HOU1yA4MVyYyLUzPhRtkR9Xxur70ij6uG53j5g1Z7r/2zwyb5ghyw3wNVSTMzJJVtwA==";
        String publickey = "MFwwDQYJKoZIhvcNAQEBBQADSwAwSAJBALhayAO8fcHUUJ+JM+DmI30U92xQjM2blNG7lJ/et+ZxeK5YwUSVo/fvD9XQv3hTvAT62aBTSZ1pItbXjnd6mp8CAwEAAQ==";
        String s = new Solution().doDecrypt(publickey, password);
        logger.debug(s);
//        new Solution().doEncrypt("Itsme@999");
    }

}
