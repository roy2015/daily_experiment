package com.guo.roy.research.testing;

import cn.hutool.core.lang.Assert;
import org.slf4j.LoggerFactory;

import java.math.BigDecimal;
import java.math.RoundingMode;

/**
 * @author guojun
 * @date 2021/6/11
 *
 *  BigDecimal内部实现是转化为long，超过就走膨胀机制
 *
 * 1. 比较大小时候用compareTo,不要用equal 1.00和1不equals（精度不同），但应该相等(用compareTo即可)
 * 2. 除法应该有精度，防止除不尽
 * 3. BigDecimal初始化用string，否则丢失精度
 *
 */
public class TestBigDecimal {
    private static final org.slf4j.Logger logger = LoggerFactory.getLogger(TestBigDecimal.class);


    static class Solution {

        //测试无限小数就会报错异常
        public  void test1() {
            BigDecimal op1 = new BigDecimal("1");
            BigDecimal op2 = new BigDecimal("3");
            try {
                logger.info("result: {}", op1.divide(op2));
            } catch (Exception e) {
                Assert.isInstanceOf( ArithmeticException.class,e, "无限小数就会报错异常");
            }
            Assert.isTrue(op1.divide(op2, 2, RoundingMode.HALF_UP).doubleValue() == 0.33 );

        }

        /**
         * //1.00和1不equals，但应该相等
         */
        public  void test2() {
            BigDecimal op1 = new BigDecimal("1.00");
            BigDecimal op2 = new BigDecimal("1");

            Assert.isFalse(op1.equals(op2) );//1.00和1不equals
            Assert.isTrue(op1.compareTo(op2) == 0 );

        }

        /**
         * 丢失精度
         */
        public  void test3() {
            BigDecimal op1 = new BigDecimal(0.1);
            logger.info("{}",op1);
        }

        /**
         * 去掉小数部分多余的0
         */
        public  void test4() {
            BigDecimal op1 = new BigDecimal("100.1000");
            Assert.isTrue("100.1000".equals(op1.toString()));
            Assert.isTrue("100.1".equals(op1.stripTrailingZeros().toString()));
        }

        /**
         * String toString();     // 有必要时使用科学计数法
         * String toPlainString();   // 不使用科学计数法
         * String toEngineeringString();  // 工程计算中经常使用的记录数字的方法，与科学计数法类似，但要求10的幂必须是3的倍数
         */
        public  void test5() {
            BigDecimal op1 = new BigDecimal("12334535345456700.12345634534534578901");
            String toString = op1.toString();
            String plainString = op1.toPlainString();
            String engineeringString = op1.toEngineeringString();
            logger.info("{}", toString);
            logger.info("{}", plainString);
            logger.info("{}", engineeringString);

        }


    }

    public static void main(String[] args) {
        new Solution().test5();
    }
}
