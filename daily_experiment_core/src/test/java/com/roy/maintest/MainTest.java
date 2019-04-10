package com.roy.maintest;

import com.roy.miscellaneous.*;
import com.roy.miscellaneous.arithmetic.TestMergeSort;
import com.roy.miscellaneous.targetObject.TestString;
import org.apache.commons.lang3.StringUtils;
import org.testng.annotations.Test;

import java.util.Random;

/**
 * Created by apple on 2018/12/7.
 */
public class MainTest {

    @Test
    public void test1() {
        new TestBloomFilter().bloomFilter();
    }

    @Test
    public void test2() {
        new TestHashFunc().test1();
    }

    @Test
    public void test3() {
        int len =8;
        int[] initArra = new int[len] ;
        for (int i = 0; i < len; i++) {
            initArra[i] = new Random().nextInt(100);
        }

        int[] ints = new TestMergeSort().mergeSort(initArra);
//        int[] ints = new TestMergeSort().mergeSort(new int[]{76, 91, 68});
        System.out.println("数据长度: " + ints.length);
        for (int i = 0; i < ints.length; i++) {
            System.out.println(StringUtils.leftPad(i+"", 8, " ") + "\t" + StringUtils.leftPad(ints[i] +"" ,8," "));
        }
    }

    @Test
    public void testSessionIdGenerate() {
        for (int i = 0; i < 5; i++) {
            new TestSessionIdGenarate().test();
        }
    }

    @Test
    public void testsUnsafe() throws Exception {
        new TestUnSafe().testUnsafe();
    }

    @Test
    public void testStringEqual() {
        new TestString().testStringEqual();
    }

    @Test
    public void testDouble() {
        new TestDigitalArithmetic().testDouble();
    }

    @Test
    public void testBigdecimal() {
        new TestDigitalArithmetic().testBigDecimal();
    }


}
