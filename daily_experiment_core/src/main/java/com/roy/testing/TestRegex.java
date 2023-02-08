package com.roy.testing;


import java.text.MessageFormat;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import lombok.extern.slf4j.Slf4j;

/**
 *
 * 测试正则表达式
 * @author guojun
 * @date 2021/6/11
 */
@Slf4j
public class TestRegex {


    public static class Solution {

        /**
         * 提取参数的值
         */
        public  void test1() {
//            String str = "rtsp://192.166.1.238:8554/play?gbId=222ab_222&ignore=yes";
            String str =  "rtmp://192.168.1.105:1938/guoqiang/push002?"
                + "gbId=V5VQbIqkVfk331GWHsqmIfbBT1i2VT0tbyCEnGnAnA%2FiBQZ3fyI13re7OY8DLYqvpeSmBFsqbmd64IpOTfTHlVlnw4KmyaFdwp3mCGcj9f1lKHX2xNLOQoo2%2F9X%2B9gdkrTAv70H02x7D0h1g7CXnjPFEvWm3r6wfuOQkap8NQWk%3D"
                +"&ignore=";
            log.info("{}", extractParamValue(str, "12"));
        }

        /**
         * 提取url参数的值
         * @param paraName
         * @return
         */
        private String extractParamValue(String url, String paraName) {
            String regexStr = "[?&]" + paraName + "=([^&]+).*$";
            Pattern compile = Pattern.compile(regexStr);
            Matcher matcher = compile.matcher(url);
            matcher.find();
            return matcher.group(1);
        }


        public   void testRegex() {
            String str = "RECORD_STREAM_END_TRIGGER_{0}_{1}_{2}_{3}";
            String formatStr = MessageFormat.format(str, "11", "22", "33", "44");
            log.debug("formatStr: {}", formatStr);
            String[] split = formatStr.split("_");
            log.debug("{}", split.length);

            Pattern bitrant_regex = Pattern.compile("(?:\\S+)_(\\S+)_(\\S+)_(\\S+)_(\\S+)$");
            Matcher matcher = bitrant_regex.matcher(formatStr);
            matcher.find();
            log.info("{}", matcher.group(4));
            log.debug("{}", Pattern.matches("(\\S+)_(\\S+)_(\\S+)_(\\S+)$", formatStr));

            log.info("11111111111111111111");

            String[] s = "RECORD_STREAM_END_TRIGGER_10000001_1_rtp_11010000002000000163_34020000001310000163".split("_", 8);
            log.error("{}", s[4]);
            log.error("{}", s[5]);
            log.debug("{}", Pattern.matches("^.+@((2[0-4]\\d|25[0-5]|[01]?\\d\\d?)\\.){3}(2[0-4]\\d|25[0-5]|[01]?\\d\\d?)(:\\d+).*$",
                "1@192.168.21.90:8080"));
        }

        public void testRegex1() {
            log.info("{}", Pattern.matches("^[\\u4e00-\\u9fa5A-Za-z\\d][\\u4e00-\\u9fa5A-Za-z\\d_\\-\\s]{0,19}$", "郭"));

            //中英文最多20位
            log.info("{}", Pattern.matches("^[a-zA-Z0-9]{0,20}$" ,"40401111222101"));
            log.info("{}", Pattern.matches("^[0-9]{10}200[0-9]{7}$", "40401111222101234532"));

            String[] split = "ap-123-svc-3417884030140417-cc-plate-module".split("\\-[0-9]+\\-", 3);
            log.info(" {}", split);
            log.info("{}", "ap-svc-3417884030140417-cc-plate-module-9-".replaceFirst("\\-[0-9]+\\-", "-4-"));


//        logger.info("{}", Pattern.matches("^[0-9]+$", "01"));
            //ip
//        logger.info("{}", Pattern.matches("(25[0-5]|2[0-4]\\d|1\\d\\d|\\d\\d|\\d)\\.(25[0-5]|2[0-4]\\d|1\\d\\d|\\d\\d|\\d)\\.(25[0-5]|2[0-4]\\d|1\\d\\d|\\d\\d|\\d)\\.(25[0-5]|2[0-4]\\d|1\\d\\d|\\d\\d|\\d)(:(\\d\\d\\d\\d|\\d\\d\\d|\\d\\d|\\d))",
//            "192.168.1.104:9011"));
//        logger.info("{}", "sample/10.jpeg".contains("/."));
//        logger.info("{}", "__MACOSX/sample/._47.jpeg".startsWith("__MACOSX"));
//        logger.info("{}", "__MACOSX/sample/._47.jpeg".startsWith("."));

            Pattern bitrant_regex = Pattern.compile("(\\d+(?:\\.\\d+)?)kbits/s");
            Matcher matcher = bitrant_regex.matcher("123.1kbits/s");
            matcher.find();
            log.info(matcher.group(1));
            log.info("{}",matcher.groupCount());
        }
    }

    public static void main(String[] args) throws Exception {
        log.info("=============");
        new Solution().test1();
    }
}
