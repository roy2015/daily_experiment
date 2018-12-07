package com.roy.miscellaneous;

import com.google.common.hash.BloomFilter;
import com.google.common.hash.Funnels;
import org.apache.log4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by apple on 2018/12/7.
 */
public class TestBloomFilter {
    public static int size = 10000000;
    private static final org.slf4j.Logger logger = LoggerFactory.getLogger(TestBloomFilter.class);


    public void bloomFilter() {

        BloomFilter<Integer> bloomFilter = BloomFilter.create(Funnels.integerFunnel(), size, 0.00001);
        for (int i = 0; i< size; i++) {
            bloomFilter.put(i);
        }

        for (int i=0; i< size; i++) {
            if ( ! bloomFilter.mightContain(i) ) {
                logger.debug("有人逃跑");
            }
        }

        List<Integer> list = new ArrayList<Integer>(10000);
        for (int i = size + 100000; i < size + 200000; i++) {
            if (bloomFilter.mightContain(i)) {
                list.add(i);
            }
        }
        logger.debug("有误伤的数量：" + list.size());

    }
}
