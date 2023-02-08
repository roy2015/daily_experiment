package com.roy.maintest;

import org.slf4j.LoggerFactory;
import org.testng.annotations.Test;


/**
 * Created by apple on 2018/12/7.
 */
public class TestBitOps {

    private static final org.slf4j.Logger logger = LoggerFactory.getLogger(TestBitOps.class);

    @Test
    public void test2() {
        new com.guo.roy.research.misc.bitops.TestBitOps().test2();
    }
}
