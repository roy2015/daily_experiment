package com.roy.maintest;

import com.roy.miscellaneous.*;
import com.roy.miscellaneous.arithmetic.TestBase64Codec;
import com.roy.miscellaneous.arithmetic.TestInsertiionSort;
import com.roy.miscellaneous.arithmetic.TestMergeSort;
import com.roy.miscellaneous.arithmetic.cipher.TestDES3;
import com.roy.miscellaneous.arithmetic.cipher.TestMac;
import com.roy.miscellaneous.arithmetic.cipher.TestRSAEncrypt;
import com.roy.miscellaneous.arithmetic.cipher.TestRsaSignature;
import com.roy.miscellaneous.executors.TestScheduledThreadPoolExecutor;
import com.roy.miscellaneous.interview.TestInsertionSortWithAyyayList;
import com.roy.miscellaneous.interview.TestJdkIOs;
import com.roy.miscellaneous.io.TestObjectSerializeFile;
import com.roy.miscellaneous.juc.multiThread.TestOddEvenPrint;
import com.roy.miscellaneous.javassist.TestJavassist;
import com.roy.miscellaneous.juc.*;
import com.roy.miscellaneous.pattern.factory.CpuType;
import com.roy.miscellaneous.pattern.factory.MainBoardType;
import com.roy.miscellaneous.pattern.factory.abstractFactory.CaliforniaFactory;
import com.roy.miscellaneous.pattern.factory.ComputerEngineer;
import com.roy.miscellaneous.pattern.factory.abstractFactory.NewYorkFactory;
import com.roy.miscellaneous.pattern.factory.simpleFactory.SimpleFactory;
import com.roy.miscellaneous.spi.TestJdkSpi;
import com.roy.miscellaneous.targetObject.TestString;
import com.roy.miscellaneous.targetObject.UserVO;
import com.roy.miscellaneous.yaml.TestReadYaml;
import org.apache.commons.lang3.StringUtils;
import org.testng.annotations.Test;

import javax.naming.OperationNotSupportedException;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.math.BigDecimal;
import java.math.MathContext;
import java.math.RoundingMode;
import java.security.NoSuchAlgorithmException;
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
        new TestBitOps().test1();
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
    public void testInsertionSortUseArrayListFloat() throws OperationNotSupportedException {
        Float[] floatArrays = new Float[]{41f, 0f, 0f} ;

        TestInsertionSortWithAyyayList<Float> testInsertionSortWithAyyayList = new TestInsertionSortWithAyyayList<>();
        testInsertionSortWithAyyayList.printArray(floatArrays);//元素数据
        testInsertionSortWithAyyayList.testInsertionSortUseArrayList(floatArrays);//process排序
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

    @Test
    /**
     * 抽象工厂
     */
    public void testAbstractFactory() {
        ComputerEngineer engineer = new ComputerEngineer();
        engineer.makeComputer(new CaliforniaFactory());
        engineer.makeComputer(new NewYorkFactory());
    }

    @Test
    /**
     * 简单工厂
     */
    public void testSimpleFactory(){
        ComputerEngineer engineer = new ComputerEngineer();
        engineer.makeComputer(new SimpleFactory(), CpuType.INTEL, MainBoardType.MSI);

    }

    @Test
    /**
     * 测试spi
     */
    public void testJdkSpi() {
        new TestJdkSpi().testJdkSpi();


    }

    @Test
    public void testGenicFastJson() {
        new TestGenicFastJson().testGenicFastJson();
        new TestGenicFastJson().testGenicFastJsonStrToObj();
    }

    @Test
    public void testJavassist(){
        new TestJavassist().testJavassist();
    }

    @Test
    public void testOddEvenPrint () throws IOException {
        new TestOddEvenPrint(10).testOddEvenPrin();
    }

    @Test
    public void testSemaphore () throws IOException {
        TestSemaphore.main(null);
    }

    /**
     * 测试下 LockSupport
     * @throws Exception
     */
    @Test
    public void testLockSupport () throws Exception {
        TestThread.testLockSupport (null);
    }


    @Test
    public void testLockSupportInterrupt () throws Exception {
        TestThread.testLockSupportInterrupt();
    }

    @Test
    public void testLockSleepInterrupt () throws Exception {
        TestThread.testLockSleepInterrupt();
    }

    @Test
    public void testLoopInterrupt () throws Exception {
        TestThread.testLoopInterrupt();
    }

    /**
     * 测试 threadLocal
     * @throws Exception
     */
    @Test
    public void TestThreadLocal() throws Exception {
        TestThreadLocal.testThreadLocal();
    }

    /**
     * 测试yml文件的解析
     * @throws FileNotFoundException
     */
    @Test
    public void testReadYaml() throws FileNotFoundException {
        new TestReadYaml().testReadYaml();
    }

    @Test
    public void testDelayScheduledThreadPoolExecutor() throws InterruptedException {
        new TestScheduledThreadPoolExecutor().testScheduledThreadPoolExecutor_1();
    }

    @Test
    public void testDelayFixRateScheduledThreadPoolExecutor() throws InterruptedException {
        new TestScheduledThreadPoolExecutor().testScheduledThreadPoolExecutor_2();
    }

    @Test
    public void testWithoutUnsafe() throws InterruptedException {
        TestUnsafeCas.testWithoutUnsafe();
    }

    @Test
    public void testUnsafe() throws InterruptedException {
        TestUnsafeCas.testUnsafe();
    }

    /**
     * 测试下testCompareAndSwapInt
     */
    @Test
    public void testCompareAndSwapInt() {
        TestUnsafeCas.testCompareAndSwapInt();
    }

    @Test
    public void testObjRefClass() {
        Object obj = new UserVO();
        System.out.println(obj.getClass());
    }

    /**
     * 测试Base64加解密
     * @throws UnsupportedEncodingException
     */
    @Test
    public void testBase64() throws UnsupportedEncodingException {
        TestBase64Codec.testBase64Encode("123456");
        TestBase64Codec.testBase64Decode("MTIzNDU2");
    }

    /**
     * RSA 非对策加密解密
     * @throws Exception
     */
    @Test
    public void testRSADecryptAndEncrypt() throws Exception {
        TestRSAEncrypt.testRSAEncryptDecrypt("guoj2989");
    }

    /**
     * 测试消息验证码
     * @throws Exception
     */
    @Test
    public void testMac() throws Exception{
        TestMac.testMac("page=1?username=guoj&size=3");;
    }

    /**
     * 测试签名
     * @throws UnsupportedEncodingException
     * @throws NoSuchAlgorithmException
     */
    @Test
    public void testSignature() throws UnsupportedEncodingException, NoSuchAlgorithmException {
        TestRsaSignature.testRsaSignature("123royguojungdy");
    }

    /**
     * 测试对称加密解密
     */
    @Test
    public void testDes3() throws UnsupportedEncodingException {
        TestDES3.testDES3("071366666qwertyuiopasdfghjklzxcvbnm,./1234567890");
    }

    @Test
    public void testJkdIo1() {
        TestJdkIOs.testIO1();
    }

    @Test
    /**
     * 对象序列号到文件
     */
    public void testWriteObjecctToFile() {
        TestObjectSerializeFile.testWriteObjecctToFile();;
    }

    @Test
    /**
     * 从文件读取对象
     */
    public void testReadObjectFromFIle() {
        TestObjectSerializeFile.testReadObjectFromFIle();;
    }

    @Test
    /**
     * 测试BigDecimal的0
     */
    public void testZero() {
        System.out.println(new BigDecimal("0.17").intValue() == 0);
        System.out.println(new BigDecimal("0.17").equals("0"));
        System.out.println(new BigDecimal("0.00").equals("0"));
        System.out.println(new BigDecimal("0.00").compareTo(BigDecimal.ZERO));
    }
}
