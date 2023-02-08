package com.roy.research;

import org.slf4j.LoggerFactory;

import java.util.BitSet;

/**
 * Created by apple on 2019/9/2.
 *
 * 十亿个单词表中查找某个单词是否出现
 */
public class TestMyBloomFilter {
    private static final org.slf4j.Logger logger = LoggerFactory.getLogger(TestMyBloomFilter.class);


    static class MyBloomFilter {
        //2 ^25 表示67108864个比特位, 最后bitSet里word long[] 长度是 67108864/2^6=1048576,
        // 因为long是2的6次方
        private static int DEFAULT_SIZE = 2 << 25;
        private int[] seeds = new int[]{3, 5,7 ,11,13,19,23,27};
        private SimpleHash[] func = new SimpleHash[seeds.length];
        private BitSet bitSet;

        public MyBloomFilter() {
            for (int i = 0; i < seeds.length; i++) {
                func[i] = new SimpleHash(DEFAULT_SIZE, seeds[i]);
            }
            bitSet = new BitSet(DEFAULT_SIZE);
        }

        //记录到bitSets
        public void add (String val) {
            for (int i = 0; i < func.length; i++) {
                int hash = func[i].hash(val);
                bitSet.set(hash);
            }
        }

        public boolean contains(String val) {
            boolean result = true;
            for (int i = 0; i < func.length; i++) {
                int hash = func[i].hash(val);
                //有一个false就返回，表示不存在
                result = bitSet.get(hash) && result;
                if (!result) {
                    return result;
                }
            }
            return result;
        }
    }

    static class SimpleHash {
        private int cap;//模
        private int seed;

        public SimpleHash(int cap, int seed) {
            this.cap = cap;
            this.seed = seed;
        }

        public int hash (String value) {
            int result =0;
            for (int i = 0; i < value.length(); i++) {
                result = seed * result + value.charAt(i);
            }
            //求余，因为是2的指数可以用与运算
            return (cap -1) & result ;
        }
    }

    public static void main(String[] args) {
        MyBloomFilter myBloomFilter = new MyBloomFilter();
        boolean contains = myBloomFilter.contains("www.baidu.com");
        logger.info("{}", contains);
        myBloomFilter.add("www.baidu.com");
        contains = myBloomFilter.contains("www.baidu.com");
        logger.info("{}", contains);
    }

}
