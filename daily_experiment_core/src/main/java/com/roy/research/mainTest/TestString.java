package com.roy.research.mainTest;

import org.slf4j.LoggerFactory;

/**
 * @author guojun
 * @date 2022/12/8 09:44
 */
public class TestString {
    private static final org.slf4j.Logger logger = LoggerFactory.getLogger(
            TestLocalDateTime.class);

    static class Solution {
        public void testSplit(String str) {
            String[] res = str.split(",");
            printArray(res);
        }

        private void printArray(String[] strArray) {
            StringBuffer sb = new StringBuffer("`");
            for (String s : strArray) {
                sb.append(s);
                sb.append("->");
            }
            if (sb.toString().endsWith("->")) {
                sb.delete(sb.length()-2, sb.length());
            }
            sb.append("`");
            logger.debug("{}",sb.toString());
        }

        public void main() {
            testSplit("123,");
            testSplit("123,123");
            testSplit(",123");
        }
    }

    public static void main(String[] args) {
        new Solution().main();
    }
}
