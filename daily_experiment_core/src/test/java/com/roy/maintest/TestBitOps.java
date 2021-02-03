package com.roy.maintest;

import static java.lang.Math.*;

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

import javax.naming.OperationNotSupportedException;

import org.apache.commons.lang3.StringUtils;
import org.slf4j.LoggerFactory;
import org.testng.annotations.Test;

import com.roy.miscellaneous.TestBloomFilter;
import com.roy.miscellaneous.TestDigitalArithmetic;
import com.roy.miscellaneous.TestGenicFastJson;
import com.roy.miscellaneous.TestSessionIdGenarate;
import com.roy.miscellaneous.arithmetic.TestBase64Codec;
import com.roy.miscellaneous.arithmetic.TestInsertiionSort;
import com.roy.miscellaneous.arithmetic.TestMergeSort;
import com.roy.miscellaneous.arithmetic.cipher.TestDES3;
import com.roy.miscellaneous.arithmetic.cipher.TestMac;
import com.roy.miscellaneous.arithmetic.cipher.TestRSAEncrypt;
import com.roy.miscellaneous.arithmetic.cipher.TestRsaSignature;
import com.roy.miscellaneous.executors.TestScheduledThreadPoolExecutor;
import com.roy.miscellaneous.interview.TestInsertionSortWithAyyayList;
import com.roy.miscellaneous.io.TestJdkIOs;
import com.roy.miscellaneous.io.TestObjectSerializeFile;
import com.roy.miscellaneous.javassist.TestJavassist;
import com.roy.miscellaneous.juc.*;
import com.roy.miscellaneous.juc.multiThread.TestOddEvenPrint;
import com.roy.miscellaneous.pattern.factory.ComputerEngineer;
import com.roy.miscellaneous.pattern.factory.CpuType;
import com.roy.miscellaneous.pattern.factory.MainBoardType;
import com.roy.miscellaneous.pattern.factory.abstractFactory.CaliforniaFactory;
import com.roy.miscellaneous.pattern.factory.abstractFactory.NewYorkFactory;
import com.roy.miscellaneous.pattern.factory.simpleFactory.SimpleFactory;
import com.roy.miscellaneous.spi.TestJdkSpi;
import com.roy.miscellaneous.targetObject.TestString;
import com.roy.miscellaneous.targetObject.TestVO;
import com.roy.miscellaneous.targetObject.UserVO;
import com.roy.miscellaneous.yaml.TestReadYaml;
import com.sun.image.codec.jpeg.JPEGCodec;
import com.sun.image.codec.jpeg.JPEGImageEncoder;

import cn.hutool.captcha.CaptchaUtil;
import cn.hutool.captcha.LineCaptcha;
import cn.hutool.core.date.DateUtil;

/**
 * Created by apple on 2018/12/7.
 */
public class TestBitOps {

    private static final org.slf4j.Logger logger = LoggerFactory.getLogger(TestBitOps.class);

    @Test
    public void test2() {
        new com.roy.miscellaneous.bitops.TestBitOps().test2();
    }
}
