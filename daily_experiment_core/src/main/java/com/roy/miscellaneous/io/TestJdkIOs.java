package com.roy.miscellaneous.io;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.LoggerFactory;

import java.io.*;
import java.util.HashMap;

/**
 * Created by apple on 2019/8/16.
 *   jdk IO 分 字节流 inputStream/outputStream 和
 *             字符流  reader/writer
 *   字节流转字符流， 典型场景是httpClient的读取httpEntity： inputStreamReader outputStreamWriter
 *
 *
 */

@Slf4j
public class TestJdkIOs {

    /**
     * 一行一行的读数据
     */
    public static void testInputStreamReader() {
        try {
            //两种写法，第一种字符流->字符流， 第二种字节流-》字符流
//            BufferedReader bufferedReader = new BufferedReader(new FileReader("/Users/apple/guojun/test/docker相关.txt"));
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(new FileInputStream("/Users/apple/guojun/test/docker相关.txt")));
            String str;
            while ( (str = bufferedReader.readLine()) != null ) {
                log.info(str);
            }

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * 缓冲读取
     */
    public static void testInputStreamReader1() {
        int maxReadSize = 4096;
        try (InputStreamReader inputStreamReader = new InputStreamReader(new FileInputStream("/Users/apple/guojun/test/docker相关.txt"))) {
            //缓冲区
            char[] buffer = new char[maxReadSize];

            int readSize ;
            StringBuffer sb = new StringBuffer();
            while ((readSize = inputStreamReader.read(buffer)) != -1) {//不能inputStreamReader.read(buffer)) == 0
                sb.append(buffer, 0, readSize);
            }
            log.info(sb.toString());
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


}
