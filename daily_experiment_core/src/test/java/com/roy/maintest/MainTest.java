package com.roy.maintest;

import cn.hutool.captcha.CaptchaUtil;
import cn.hutool.captcha.LineCaptcha;
import cn.hutool.core.date.DateUtil;
import com.roy.miscellaneous.*;
import com.roy.miscellaneous.arithmetic.TestBase64Codec;
import com.roy.miscellaneous.arithmetic.TestInsertiionSort;
import com.roy.miscellaneous.arithmetic.TestMergeSort;
import com.roy.miscellaneous.arithmetic.cipher.TestDES3;
import com.roy.miscellaneous.arithmetic.cipher.TestMac;
import com.roy.miscellaneous.arithmetic.cipher.TestRSAEncrypt;
import com.roy.miscellaneous.arithmetic.cipher.TestRsaSignature;
import com.roy.miscellaneous.bitops.TestBitOps;
import com.roy.miscellaneous.executors.TestScheduledThreadPoolExecutor;
import com.roy.miscellaneous.interview.TestInsertionSortWithAyyayList;
import com.roy.miscellaneous.io.TestJdkIOs;
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
import com.roy.miscellaneous.targetObject.TestVO;
import com.roy.miscellaneous.targetObject.UserVO;
import com.roy.miscellaneous.yaml.TestReadYaml;
import com.sun.image.codec.jpeg.JPEGCodec;
import com.sun.image.codec.jpeg.JPEGImageEncoder;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.LoggerFactory;
import org.testng.annotations.Test;

import javax.naming.OperationNotSupportedException;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.math.BigDecimal;
import java.math.MathContext;
import java.math.RoundingMode;
import java.security.NoSuchAlgorithmException;
import java.text.MessageFormat;
import java.util.*;
import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static java.lang.Math.*;

/**
 * Created by apple on 2018/12/7.
 */
public class MainTest {

    private static final org.slf4j.Logger logger = LoggerFactory.getLogger(MainTest.class);

    // 公式中的经纬度均用弧度表示，计算两点距离
    double algorithm(double longitude1, double latitude1, double longitude2, double latitude2) {
        double Lat1 = rad(latitude1); // 纬度
        double Lat2 = rad(latitude2);
        double a = Lat1 - Lat2;// 两点纬度之差
        double b = rad(longitude1) - rad(longitude2); // 经度之差
        // double s = 2 * Math.asin(Math
        // .sqrt(Math.pow(Math.sin(a / 2), 2) + Math.cos(Lat1) * Math.cos(Lat2) * Math.pow(Math.sin(b / 2), 2)));//计算两点距离的公式
        double s = 2 * asin(sqrt(pow(sin(a / 2), 2) + cos(Lat1) * cos(Lat2) * pow(sin(b / 2), 2)));// 计算两点距离的公式
        s = s * 6378137.0;// 弧长乘地球半径（半径为米）
        // s = round(s * 10000) / 10000;//精确距离的数值
        return s;
    }

    double rad(double d) {
        return d * PI / 180.00; // 角度转换成弧度
    }

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
        int len = 8;
        int[] initArra = new int[len];
        for (int i = 0; i < len; i++) {
            initArra[i] = new Random().nextInt(100);
        }

        int[] ints = new TestMergeSort().mergeSort(initArra);
        // int[] ints = new TestMergeSort().mergeSort(new int[]{76, 91, 68});
        System.out.println("数据长度: " + ints.length);
        for (int i = 0; i < ints.length; i++) {
            System.out.println(StringUtils.leftPad(i + "", 8, " ") + "\t" + StringUtils.leftPad(ints[i] + "", 8, " "));
        }
    }

    @Test
    // 插入排序
    public void testInsertionSort() {
        int len = 10;
        int[] initArra = new int[len];
        for (int i = 0; i < len; i++) {
            initArra[i] = new Random().nextInt(100);
        }
        // int[] initArra = new int[]{41, 0, 0} ;
        new TestInsertiionSort().print(initArra);
        new TestInsertiionSort().testInsertionSort(initArra);

        new TestInsertiionSort().print(initArra);
    }

    @Test
    // 面试提，依次add 4,6,1到 arrayList，arrayList是 1，4，6， 用到是是add(index, value)，插入排序
    public void testInsertionSortUseArrayList() throws OperationNotSupportedException {
        int len = 7;
        Long[] longArra = new Long[len];
        for (int i = 0; i < len; i++) {
            longArra[i] = Long.valueOf(new Random().nextInt(100));
        }
        // 写死的数组，上面是随机数数组
        // Long[] longArra = new Long[]{41l, 0l, 0l} ;

        TestInsertionSortWithAyyayList<Long> testInsertionSortWithAyyayList = new TestInsertionSortWithAyyayList<>();
        testInsertionSortWithAyyayList.printArray(longArra);// 元素数据
        testInsertionSortWithAyyayList.testInsertionSortUseArrayList(longArra);// process排序
        testInsertionSortWithAyyayList.printList(testInsertionSortWithAyyayList.getList());// 排序后
    }

    @Test
    // 同上，不过用的是Double
    public void testInsertionSortUseArrayListDouble() throws OperationNotSupportedException {
        int len = 7;
        Double[] doubleArra = new Double[len];
        for (int i = 0; i < len; i++) {
            doubleArra[i] = new BigDecimal(new Random().nextDouble()).multiply(new BigDecimal(100d), new MathContext(5, RoundingMode.HALF_UP)).doubleValue();
        }

        TestInsertionSortWithAyyayList<Double> testInsertionSortWithAyyayList = new TestInsertionSortWithAyyayList<>();
        testInsertionSortWithAyyayList.printArray(doubleArra);// 元素数据
        testInsertionSortWithAyyayList.testInsertionSortUseArrayList(doubleArra);// process排序
        testInsertionSortWithAyyayList.printList(testInsertionSortWithAyyayList.getList());// 排序后
    }

    @Test
    public void testInsertionSortUseArrayListFloat() throws OperationNotSupportedException {
        Float[] floatArrays = new Float[] { 41f, 0f, 0f };

        TestInsertionSortWithAyyayList<Float> testInsertionSortWithAyyayList = new TestInsertionSortWithAyyayList<>();
        testInsertionSortWithAyyayList.printArray(floatArrays);// 元素数据
        testInsertionSortWithAyyayList.testInsertionSortUseArrayList(floatArrays);// process排序
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
    public void testSimpleFactory() {
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
    public void testJavassist() {
        new TestJavassist().testJavassist();
    }

    @Test
    public void testOddEvenPrint() throws IOException {
        new TestOddEvenPrint(10).testOddEvenPrin();
    }

    @Test
    public void testSemaphore() throws IOException {
        TestSemaphore.main(null);
    }

    /**
     * 测试下 LockSupport
     *
     * @throws Exception
     */
    @Test
    public void testLockSupport() throws Exception {
        TestThread.testLockSupport(null);
    }

    @Test
    public void testLockSupportInterrupt() throws Exception {
        TestThread.testLockSupportInterrupt();
    }

    @Test
    public void testLockSleepInterrupt() throws Exception {
        TestThread.testLockSleepInterrupt();
    }

    @Test
    public void testLoopInterrupt() throws Exception {
        TestThread.testLoopInterrupt();
    }

    /**
     * 测试 threadLocal
     *
     * @throws Exception
     */
    @Test
    public void TestThreadLocal() throws Exception {
        TestThreadLocal.testThreadLocal();
    }

    /**
     * 测试yml文件的解析
     *
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
     *
     * @throws UnsupportedEncodingException
     */
    @Test
    public void testBase64() throws UnsupportedEncodingException {
        TestBase64Codec.testBase64Encode("123456");
        TestBase64Codec.testBase64Decode("MTIzNDU2");
    }

    /**
     * RSA 非对策加密解密
     *
     * @throws Exception
     */
    @Test
    public void testRSADecryptAndEncrypt() throws Exception {
        TestRSAEncrypt.testRSAEncryptDecrypt("guoj2989");
    }

    /**
     * 测试消息验证码
     *
     * @throws Exception
     */
    @Test
    public void testMac() throws Exception {
        TestMac.testMac("page=1?username=guoj&size=3");
        ;
    }

    /**
     * 测试签名
     *
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

    /**
     *
     * 字节流转字符流
     */
    @Test
    public void testInputStreamReader() {
        TestJdkIOs.testInputStreamReader();
    }

    /**
     *
     * 字节流转字符流
     */
    @Test
    public void testInputStreamReader1() {
        TestJdkIOs.testInputStreamReader1();
    }

    @Test
    /**
     * 对象序列号到文件
     */
    public void testWriteObjecctToFile() {
        TestObjectSerializeFile.testWriteObjecctToFile();
        ;
    }

    @Test
    /**
     * 从文件读取对象
     */
    public void testReadObjectFromFIle() {
        TestObjectSerializeFile.testReadObjectFromFIle();
        ;
    }

    /**
     * 测试BigDecimal的 刻度（scale），精度(有效数据长度 precision  MathContext)
     */
    @Test
    public void testBigDecimalScalePrecision() {
        logger.info("5/3, 保留小数点后5位, scale {}", new BigDecimal("5").divide(new BigDecimal("3"), 5, RoundingMode.HALF_UP));
        logger.info("5/3, 保留有效数据5位, MathContext {}", new BigDecimal("5").divide(new BigDecimal("3"), new MathContext(5, RoundingMode.HALF_UP)));
        String example = "8.23";
        logger.info("{} scale {}",example, new BigDecimal(example).scale());
        logger.info("{} precision {}",example, new BigDecimal(example).precision());
        logger.info("new BigDecimal(\"8.2352\", new MathContext(3, RoundingMode.HALF_UP)    {}",
                new BigDecimal("8.2352", new MathContext(3, RoundingMode.HALF_UP)));
    }

    /**
     * double丢失精度，改成bigDecimal
     */
    @Test
    public void testDoubleLoss() {
        double a = 1;
        double b = 20.2;
        double c = 300.02;
        double result = a+b+c;
        logger.info("double丢失精度 {}, {} , {}, {}", a, b, c, result);

        BigDecimal bdA = new BigDecimal(String.valueOf(a));
        BigDecimal bdB = new BigDecimal(String.valueOf(b));
        BigDecimal bdC = new BigDecimal(String.valueOf(c));
        logger.info("改成bigDecimal后 {}, {} , {}, {}", bdA, bdB, bdC, bdA.add(bdB).add(bdC));
    }

    /**
     * 测试BigDecimal的scale =0
     */
    @Test
    public void testBigDecimal() {
        System.out.println(new BigDecimal("8").divide(new BigDecimal("3"), 0, BigDecimal.ROUND_HALF_UP));
    }

    @Test
    /**
     * 测试BigDecimal的0是否相等
     */
    public void testZero() {
        System.out.println(new BigDecimal("0.17").intValue() == 0);
        System.out.println(new BigDecimal("0.17").equals("0"));
        System.out.println(new BigDecimal("0.00").equals("0"));
        System.out.println(new BigDecimal("0.00").compareTo(BigDecimal.ZERO));
    }

    @Test
    public void testFlatMap() {
        UserVO userVO1 = new UserVO(1, "guo1,guo2", "f");
        UserVO userVO2 = new UserVO(2, "guo2", "f");
        UserVO userVO3 = new UserVO(3, "guo1,guoj3", "f");

        List<UserVO> userVOS = new ArrayList<>();
        userVOS.add(userVO1);
        userVOS.add(userVO2);
        userVOS.add(userVO3);

        List<String> names = userVOS.stream().flatMap((Function<UserVO, Stream<String>>) userVO -> {
            String userName = userVO.getUserName();
            String[] name = userName.split(",");
            List<String> nameList = Arrays.asList(name);
            return nameList.stream();
        }).collect(Collectors.toList());

        System.out.println(names);
        int k = 3;

    }



    /**
     * Collectors.toMap 不能处理重复key
     */
    @Test(expectedExceptions = { java.lang.NullPointerException.class })
    public void testCollectorToMapThrow() {
        UserVO userVO1 = new UserVO(1, "guo", "f");
        UserVO userVO2 = new UserVO(2, "g", "f");
        UserVO userVO3 = new UserVO(2, "j", "f");
        UserVO userVO4 = new UserVO(3, "guo", "f");

        List<UserVO> userVOS = new ArrayList<>();
        userVOS.add(userVO1);
        userVOS.add(userVO2);
        userVOS.add(userVO3);
        userVOS.add(userVO4);

        // 抛异常，map.merge（）的 value不为空
        Map<Integer, String> userMap = userVOS.stream().collect(Collectors.toMap(userVO -> userVO.getUserId(),
                userVO -> userVO.getUserName()));
        int k = 3;

    }

    /**
     * 测试jdk8 stream toMap 能处理重复key, 但不能处理value null ,merger时，异常
     */
    @Test
    public void testCollectorToMap2() {
        UserVO userVO1 = new UserVO(1, "guo", "f");
        UserVO userVO2 = new UserVO(2, "g", "f");
        UserVO userVO3 = new UserVO(2, "j", "f");
        UserVO userVO4 = new UserVO(3, "guo", "f");
        UserVO userVO5 = new UserVO(4, null, "f");

        List<UserVO> userVOS = new ArrayList<>();
        userVOS.add(userVO1);
        userVOS.add(userVO2);
        userVOS.add(userVO3);
        userVOS.add(userVO4);
        userVOS.add(userVO5);
        Map<Integer, String> map = userVOS.stream().collect(Collectors.toMap(UserVO::getUserId, item -> item.getUserName(), (v1, v2) -> v2));
        logger.info("{}", map);
    }


    /**
     * 测试jdk8 stream toMap  唯一正确写法
     */
    @Test
    public void testCollectorToMap() {
        UserVO userVO1 = new UserVO(1, "guo", "f");
        UserVO userVO2 = new UserVO(2, "guo", "f");
        UserVO userVO3 = new UserVO(2, null, "f");
        UserVO userVO4 = new UserVO(3, "guo", "f");

        List<UserVO> userVOS = new ArrayList<>();
        userVOS.add(userVO1);
        userVOS.add(userVO2);
        userVOS.add(userVO3);
        userVOS.add(userVO4);

        Map<Integer, String> userMap1 = userVOS.stream().collect(
                HashMap::new,
                (map, userVO) -> map.put(userVO.getUserId(), userVO.getUserName()),
                HashMap::putAll);
        int i = 0;

    }




    /**
     * 测试jdk的groupingBy
     */
    @Test
    public void testGroupingby() {
        List<TestVO> testVOS = new ArrayList<>();
        TestVO testVO1 = new TestVO("1", "2", "3");
        TestVO testVO2 = new TestVO("1", "2", "4");
        TestVO testVO3 = new TestVO("1", "2", "3");
        testVOS.add(testVO1);
        testVOS.add(testVO2);
        testVOS.add(testVO3);

        Map<String, List<TestVO>> map1 = testVOS.stream().collect(Collectors.groupingBy(x -> x.getField1() + "-" + x.getField2() + "-" + x.getField3()));
        logger.info("");

        logger.info("{}", MessageFormat.format("{0}-{1}", 123,456));

    }

    @Test
    public void testMapNullKey() {
        HashMap<String, String> map = new HashMap<>();
        String s = map.get(null);
        logger.info("");
    }

    @Test
    // 测试hutool的验证码
    public void testHutool() {
        LineCaptcha captcha = CaptchaUtil.createLineCaptcha(250, 250, 4, 2000);
        Image image = captcha.createImage("2345");
        try (FileOutputStream fos = new FileOutputStream("/Users/apple/logs/img.jpg")) {
            JPEGImageEncoder encoder = JPEGCodec.createJPEGEncoder(fos);
            encoder.encode((BufferedImage) image);
        } catch (IOException e) {
            e.printStackTrace();
        }

        System.out.println(123);
    }

    @Test
    public void testjwd() {
        System.out.println(algorithm(30.51347276318229d, 114.41989512786928d, 30.19368660754606d, 120.19886377719692d));
    }

    @Test
    public void testHutoolUtil() {
        System.out.println(DateUtil.endOfDay(new Date()));
    }




    /**
     *
     * 洗牌算法
     * Fisher–Yates随机置乱算法也被称做高纳德置乱算法 费雪耶兹置乱算法
     *
     */
    @Test
    public void testGetRandomSeed() {
        //10000 * 40
        int[] cards = new int[]{1,2,3,4,5,6,7,8,9,10};
        int size = cards.length;

        StringBuffer outStr = new StringBuffer();
        for (int idx = size; idx >0; idx--) {
            int tempIdx = new Random().nextInt(idx);
            int temp = cards[idx -1];
            cards[idx-1] = cards[tempIdx];
            cards[tempIdx] = temp;
            logger.info("{} {}", cards, cards[idx-1]);
        }
        logger.info(cards.toString());
    }

    /**
     * 测试array copy
     */
    @Test
    public void testCopyArray() {
        int[] oldCards = {1,2,3,4,5};
        int removeIdx = 4;

        int oldCardLen = oldCards.length;
        int newCardLen = oldCardLen - 1 ;
        int[] newCards = new int[newCardLen];
//        if (removeIdx > 0) {
            System.arraycopy(oldCards, 0, newCards, 0, removeIdx);
//        }
//        if (removeIdx < newCardLen) {
            System.arraycopy(oldCards, removeIdx + 1, newCards, removeIdx, newCardLen - removeIdx);
//        }
        int i = 0;
    }
}
