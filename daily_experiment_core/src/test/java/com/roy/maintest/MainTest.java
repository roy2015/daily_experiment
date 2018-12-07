package com.roy.maintest;

import com.roy.miscellaneous.TestBloomFilter;
import org.testng.annotations.Test;

/**
 * Created by apple on 2018/12/7.
 */
public class MainTest {

    @Test
    public void test1() {
        new TestBloomFilter().bloomFilter();
    }


}
