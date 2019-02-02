package com.roy.maintest;

import com.roy.miscellaneous.TestBloomFilter;
import com.roy.miscellaneous.TestHashFunc;
import com.roy.miscellaneous.TestSessionIdGenarate;
import com.roy.miscellaneous.targetObject.SessionIdUtil;
import org.testng.annotations.Test;

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
    public void testSessionIdGenerate() {
        for (int i = 0; i < 5; i++) {
            new TestSessionIdGenarate().test();
        }
    }


}
