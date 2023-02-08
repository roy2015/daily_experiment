package com.guo.roy.research.misc.arithmetic;

import org.slf4j.LoggerFactory;

/**
 * Created by apple on 2019/4/11.
 *
 * 测试插入排序 O(n^2)
 */
public class TestInsertiionSort {
    private static final org.slf4j.Logger logger = LoggerFactory.getLogger(TestInsertiionSort.class);

    public  void print(int[] arry ) {
        for (int i : arry) {
            logger.debug("{}", i);
        }
        logger.debug("==================");
    }

    /**
     *
     * @param arry
     *
     *  3,1,2,9,87,8,10
     * 1,3,2,9,87,8,10
     */
    public void testInsertionSort(int[] arry) {
        int length = arry.length;
        for (int i = 1; i < length; i++) {
            int tmp = arry[i];
            int j ;
            for (j = i - 1; j >= 0; j--) {
                if (arry[i] >= arry[j] ) {
                    break;
                }
            }
            if (j == -1) {//在列表里最小
                for (int k = i ; k > j +1  ; k--) {
                    arry[k] = arry[k -1];
                }
                arry[j + 1] = tmp;
            } else {
                if (i != j + 1) {//非最大 k  = j+2
                    for (int k = i ; k >= j +2 ; k--) {
                        arry[k] = arry[k -1];
                    }
                    arry[j + 1] = tmp;
                }


            }


        }
    }

}
