package com.roy.research.yunli.main;

import com.roy.research.yunli.compress.CompressionProcessorFactory;
import org.apache.commons.codec.binary.Base64;
import org.slf4j.LoggerFactory;

import java.nio.charset.StandardCharsets;

/**
 * @author guojun
 * @date 2021/6/11
 */
public class TestSolutionTemplate {
    private static final org.slf4j.Logger logger = LoggerFactory.getLogger(TestSolutionTemplate.class);


    static class Solution {
        public  void testDecodeString() {
            String base64Str = "ASi1L/0gdS0DAEQFeyJwbGFuTmFtZSI6IuWtpueUn+i6q+mrmOagh+etvuS9nOS4mijli7/liqgpIiwicHJvY2Vzc1R5cDEiLCJyZWxUYWdGcmllbmRseWhlaWdodCJ9BQA5MwQtcMQAmpBBqaX2";
            byte[] bytes = Base64.decodeBase64(base64Str);
            String s = new String(CompressionProcessorFactory.get().decompress(bytes), StandardCharsets.UTF_8);
            logger.info("{}", s);
        }
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        solution.testDecodeString();



    }
}
