package com.roy.miscellaneous.arithmetic;

import org.roaringbitmap.RoaringBitmap;
import org.slf4j.LoggerFactory;

/**
 * @author guojun
 * @date 2021/3/11 上午11:25
 *
 *  测试RoaringBitmap压缩算法
 *
 */
public class TestRoaringBitmap {
    private static final org.slf4j.Logger logger = LoggerFactory.getLogger(TestRoaringBitmap.class);

    public static void main(String[] args) {
        RoaringBitmap rr = RoaringBitmap.bitmapOf(-1,100, 20, 3,1000);
        RoaringBitmap rr2 = new RoaringBitmap();
        rr2.add(4000L,4055L);
        logger.info("{}", rr.select(0)); // 返回第几个
        logger.info("{}", rr.rank(-1)); // 返回排名
        logger.info("{}", rr.contains(1000)); // 是否包含
        logger.info("{}", rr.contains(7)); ;

        RoaringBitmap rror = RoaringBitmap.or(rr, rr2);// new bitmap
        rr.or(rr2); //in-place computation
        boolean equals = rror.equals(rr);// true
        if(!equals) throw new RuntimeException("bug");
        // number of values stored?
        long cardinality = rr.getLongCardinality();
        logger.info("{}", cardinality);
        // a "forEach" is faster than this loop, but a loop is possible:
        for(int i : rr) {
            logger.info("{}", i);
        }
    }
}
