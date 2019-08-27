package com.roy.miscellaneous.interview;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import org.slf4j.LoggerFactory;

import java.io.*;
import java.util.HashMap;

/**
 * Created by apple on 2019/8/16.
 *   jdk IO 分 字节流 inputStream/outputStream 和字符流  reader/writer
 *   字节流转字符流， 典型场景是httpClient的读取httpEntity： inputStreamReader outputStreamWriter
 *
 *
 */
public class TestJdkIOs {
    private static final org.slf4j.Logger logger = LoggerFactory.getLogger(TestJdkIOs.class);


    public static void testIO1 () {
        try {
            //两种写法，第一种传的字节流， 第二种传的字符流
//            BufferedReader bufferedReader = new BufferedReader(new FileReader("/Users/apple/guojun/docker相关.txt"));
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(new FileInputStream("/Users/apple/guojun/docker相关.txt")));
            String str;
            //lamda写法
            /*bufferedReader.lines().forEach( x -> {
                logger.info(x);
            } );*/

            //常规写法
            while ( (str = bufferedReader.readLine()) != null ) {
                logger.info(str);
            }

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
