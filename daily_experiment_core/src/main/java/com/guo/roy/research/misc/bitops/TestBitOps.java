package com.guo.roy.research.misc.bitops;

import org.apache.commons.lang3.StringUtils;
import org.redisson.Redisson;
import org.slf4j.LoggerFactory;

/**
 * Created by apple on 2019/1/29.
 *
 * 位运算测试
 * java位运算有：
 *
 * 与运算（&）：对两个操作数的每一位执行与操作，结果中的每一位都是两个操作数对应位的与结果。
 * 示例：int result = num1 & num2;
 *
 * 或运算（|）：对两个操作数的每一位执行或操作，结果中的每一位都是两个操作数对应位的或结果。
 * 示例：int result = num1 | num2;
 *
 * 异或运算（^）：对两个操作数的每一位执行异或操作，结果中的每一位都是两个操作数对应位的异或结果。
 * 示例：int result = num1 ^ num2;
 *
 * 取反运算（~）：对操作数的每一位执行取反操作，即0变成1，1变成0。
 * 示例：int result = ~num;
 *
 * 左移运算（<<）：将操作数的二进制表示向左移动指定的位数，空位用0填充。
 * 示例：int result = num << 2;
 *
 * 右移运算（>>）：将操作数的二进制表示向右移动指定的位数，正数高位用0填充，负数高位用1填充。
 * 示例：int result = num >> 2;
 *
 * 无符号右移运算（>>>）：将操作数的二进制表示向右移动指定的位数，高位用0填充。
 * 示例：int result = num >>> 2;
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

    public void test3() {
        //抑或
        logger.debug(Integer.toBinaryString(1 ^ 1));
        logger.debug(Integer.toBinaryString(0 ^ 0));
        logger.debug(Integer.toBinaryString(1 ^ 0));
        //与
        logger.debug(Integer.toBinaryString(1 & 1));
        logger.debug(Integer.toBinaryString(1 & 0));
    }

    public void test4() {
        String negativeOne = Integer.toBinaryString(-1);
        logger.debug("len: {}, {}", negativeOne.length(), negativeOne);
        String shiftLeft = Integer.toBinaryString(-1 << 3);
        logger.debug("len: {}, {}", shiftLeft.length(), shiftLeft);
        shiftLeft = Integer.toBinaryString(~(-1 << 3));
        logger.debug("len: {}, {}", shiftLeft.length(), shiftLeft);
    }


    public void test5() {
        int[] array= new int[]{2,3,2,2};
        int res = array[0];
        for (int i = 1; i < array.length; i++) {
            res = res ^ array[i];
        }
        logger.info("{}", res);

    }

    /**
     * 无符号右移
     */
    public void test6() {
        int h;
        Integer a = 3;
        logger.debug(String.format("hashMap的hash运算: (h = Integer.valueOf(a).hashCode()) ^ (h >>> 16))=\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t %s" ,
                StringUtils.leftPad(Integer.toBinaryString( (h = Integer.valueOf(a).hashCode()) ^ (h >>> 16)), 32, "0")));

        logger.debug(" MIN_VALUE:{}", getPrettyBinaryString(Integer.MIN_VALUE));
        logger.debug("-3:        {}", getPrettyBinaryString(-3));
        logger.debug("-3 >>> 16: {}", getPrettyBinaryString((-3) >>> 16));
    }

    /**
     * 给定int的二进制pretty表示
     * @param origin
     * @return
     */
    public String getPrettyBinaryString(int origin) {
        return StringUtils.leftPad( Integer.toBinaryString(origin), 32, "0");
    }

    public static void main(String[] args) {
//      new TestBitOps().test3();
//        new TestBitOps().test4();
        new TestBitOps().test6();

    }
}
