package com.guo.roy.research.interview;

import org.slf4j.LoggerFactory;

import java.util.Arrays;

/**
 *
 * 纬创java面试题
 *
 * @author guojun
 * @date 2022/5/5
 */
public class Test20230505 {
    private static final org.slf4j.Logger logger = LoggerFactory.getLogger(Test20230505.class);

    String str = new String ("Wicresoft");
    char[] ch = {'S', 'O', 'A'};


    public void exchange(String str, char[] ch) {
        str="wicrecend";
        ch[1]='S';
    }

    public static void main(String[] args) {
        Test20230505 test20230505 = new Test20230505();
        test20230505.exchange(test20230505.str, test20230505.ch);
        logger.info("{} anb {}", test20230505.str, Arrays.toString(test20230505.ch));//Wicresoft anb [S, S, A]
    }
}
