package com.guo.roy.research.interview;

import org.slf4j.LoggerFactory;

import java.util.Arrays;

/**
 *
 * 两个有序数组合并
 * 双指针
 * @author guojun
 * @date 2021/6/11
 */
public class TestMergeTowArray {
    private static final org.slf4j.Logger logger = LoggerFactory.getLogger(TestMergeTowArray.class);


    static class Solution {
        public int[] mergeArray(int[] array1, int[] array2) {
            int length1 = array1.length;
            int length2 = array2.length;

            int[] resutlArray = new int[length1 + length2];

            int p1 = 0,p2= 0;
            int idx = 0;
            while (p1 < length1 && p2 < length2) {
                if (array1[p1] <= array2[p2]) {
                    resutlArray[idx] = array1[p1];
                    p1 ++;
                    idx ++;
                } else {
                    resutlArray[idx] = array2[p2];
                    p2 ++;
                    idx ++;
                }
            }

            if (p1 == length1) {//p1超界，处理p2剩下的
                for (int i = p2; i < length2; i++) {
                    resutlArray[idx++] = array2[i];
                }
            } else if (p2 == length2) {//p1超界，处理p2剩下的
                for (int i = p1; i < length1; i++) {
                    resutlArray[idx++] = array1[i];
                }
            } else {
            }

            return resutlArray;

        }
    }

    public static void main(String[] args) {
        Arrays.stream(new Solution().mergeArray(
                new int[]{1, 5},
                new int[]{2, 4, 7})).forEach(item -> logger.info("{}", item));
    }
}
