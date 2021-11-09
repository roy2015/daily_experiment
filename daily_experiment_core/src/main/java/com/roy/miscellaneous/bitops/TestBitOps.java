package com.roy.miscellaneous.bitops;

import org.apache.commons.lang3.StringUtils;
import org.slf4j.LoggerFactory;

/**
 * Created by apple on 2019/1/29.
 *
 * 位运算测试
 *
 */
public class TestBitOps {
    private static final org.slf4j.Logger logger = LoggerFactory.getLogger(TestBitOps.class);

    /**
     * 测试取二进制最后一个1
     */
    public void test2() {
        int k = 1;
        logger.info(Integer.toBinaryString(k));
        logger.info(Integer.toBinaryString(-k));
        logger.info(Integer.toBinaryString(k & -k));
    }

    public void test1() {
        int k =-12;
        int k1 = Integer.parseInt("-1111111111111111111111111110100",2);
        logger.debug(Integer.toBinaryString(-16));
        logger.debug(Integer.toBinaryString(k1));
        logger.debug(Integer.toBinaryString(k1 >>> 1));
        logger.debug(Integer.toBinaryString(k1 >> 1));
        logger.debug(Integer.toBinaryString(k));
        logger.debug(Integer.toBinaryString(k >>> 1));
        logger.debug(Integer.toBinaryString(k >> 1));
        logger.debug(Integer.toBinaryString(k >> 16));
        logger.debug(String.valueOf(Integer.MAX_VALUE));
        logger.debug(Integer.toBinaryString(Integer.MAX_VALUE).length() + "");
        logger.debug(Integer.toBinaryString(Integer.MAX_VALUE));

        int a = 3;
        int b = 10;
        logger.debug(String.format("a=%s\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t %s" , a, StringUtils.leftPad(Integer.toBinaryString(a), 32, "0")));
        logger.debug(String.format("b=%s\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t %s" , b, StringUtils.leftPad(Integer.toBinaryString(b), 32, "0")));
        //抑或运算，相同为0,不同为1
        logger.debug(String.format("抑或运算:  a ^ b=\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t %s" , StringUtils.leftPad(Integer.toBinaryString(a ^ b), 32, "0")));
        //与运算
        logger.debug(String.format("与运算:  a & b=\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t %s" , StringUtils.leftPad(Integer.toBinaryString(a & b), 32, "0")));
        //或运算
        logger.debug(String.format("或运算:  a | b=\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t %s" , StringUtils.leftPad(Integer.toBinaryString(a | b), 32, "0")));
        //取反运算
        logger.debug(String.format("取反运算: ～ b=\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t %s" ,
                StringUtils.leftPad(Integer.toBinaryString( ~b), 32, "0")));

        int h;
        a = Integer.MAX_VALUE /2;
        logger.debug(String.format("a=%s\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t %s" , a,
                StringUtils.leftPad(Integer.toBinaryString(a), 32, "0")));
        logger.debug(String.format("hashMap的hash运算: h >>> 16\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t %s" ,
                StringUtils.leftPad(Integer.toBinaryString( (Integer.valueOf(a).hashCode() >>> 16)), 32, "0")));
        logger.debug(String.format("hashMap的hash运算: (h = Integer.valueOf(a).hashCode()) ^ (h >>> 16))=\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t %s" ,
                StringUtils.leftPad(Integer.toBinaryString( (h = Integer.valueOf(a).hashCode()) ^ (h >>> 16)), 32, "0")));
        logger.debug(Integer.valueOf((h = Integer.valueOf(a).hashCode()) ^ (h >>> 16)).toString());
    }

    public static void main(String[] args) {
//        new TestBitOps().test2();
        logger.debug(Integer.toBinaryString(1 ^ 1));
        logger.debug(Integer.toBinaryString(0 ^ 0));
        logger.debug(Integer.toBinaryString(1 ^ 0));

        logger.debug(Integer.toBinaryString(1 & 1));
        logger.debug(Integer.toBinaryString(1 & 0));

    }
}
