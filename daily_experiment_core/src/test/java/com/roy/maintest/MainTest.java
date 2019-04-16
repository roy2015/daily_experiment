package com.roy.maintest;

import com.roy.miscellaneous.*;
import com.roy.miscellaneous.arithmetic.TestInsertiionSort;
import com.roy.miscellaneous.arithmetic.TestMergeSort;
import com.roy.miscellaneous.interview.TestInsertionSortWithAyyayList;
import com.roy.miscellaneous.targetObject.TestString;
import org.apache.commons.lang3.StringUtils;
import org.testng.annotations.Test;

import javax.naming.OperationNotSupportedException;
import java.math.BigDecimal;
import java.math.MathContext;
import java.math.RoundingMode;
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
    //插入排序
    public void testInsertionSort() {
        int len =10;
        int[] initArra = new int[len] ;
        for (int i = 0; i < len; i++) {
            initArra[i] = new Random().nextInt(100);
        }
//        int[] initArra = new int[]{41, 0, 0} ;
        new TestInsertiionSort().print(initArra);
        new TestInsertiionSort().testInsertionSort(initArra);

        new TestInsertiionSort().print(initArra);
    }

    @Test
    //面试提，依次add 4,6,1到 arrayList，arrayList是 1，4，6， 用到是是add(index, value)，插入排序
    public void testInsertionSortUseArrayList() throws OperationNotSupportedException {
        int len =7;
        Long[] longArra = new Long[len] ;
        for (int i = 0; i < len; i++) {
            longArra[i] = Long.valueOf(new Random().nextInt(100));
        }
        //写死的数组，上面是随机数数组
//        Long[] longArra = new Long[]{41l, 0l, 0l} ;

        TestInsertionSortWithAyyayList<Long> testInsertionSortWithAyyayList = new TestInsertionSortWithAyyayList<>();
        testInsertionSortWithAyyayList.printArray(longArra);//元素数据
        testInsertionSortWithAyyayList.testInsertionSortUseArrayList(longArra);//process排序
        testInsertionSortWithAyyayList.printList(testInsertionSortWithAyyayList.getList());//排序后
    }

    @Test
    //同上，不过用的是Double
    public void testInsertionSortUseArrayListDouble() throws OperationNotSupportedException {
        int len =7;
        Double[] doubleArra = new Double[len] ;
        for (int i = 0; i < len; i++) {
            doubleArra[i] = new BigDecimal( new Random().nextDouble()).
                    multiply(new BigDecimal(100d), new MathContext(5, RoundingMode.HALF_UP)).doubleValue();
        }

        TestInsertionSortWithAyyayList<Double> testInsertionSortWithAyyayList = new TestInsertionSortWithAyyayList<>();
        testInsertionSortWithAyyayList.printArray(doubleArra);//元素数据
        testInsertionSortWithAyyayList.testInsertionSortUseArrayList(doubleArra);//process排序
        testInsertionSortWithAyyayList.printList(testInsertionSortWithAyyayList.getList());//排序后
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
