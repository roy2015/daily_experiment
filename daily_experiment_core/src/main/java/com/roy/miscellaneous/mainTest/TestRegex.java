package com.roy.miscellaneous.mainTest;


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


    static class Solution {

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
    }

    public static void main(String[] args) throws Exception {
        log.info("=============");
        new Solution().test1();
    }
}
