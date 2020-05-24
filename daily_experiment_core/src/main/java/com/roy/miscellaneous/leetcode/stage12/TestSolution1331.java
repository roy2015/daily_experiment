package com.roy.miscellaneous.leetcode.stage12;

import org.slf4j.LoggerFactory;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.function.BiFunction;
import java.util.function.Function;

/**
 * @author guojun
 * @date 2020/1/24
 */
public class TestSolution1331 {
    private static final org.slf4j.Logger logger = LoggerFactory.getLogger(TestSolution1331.class);


    static class Solution {
        private int rank;


        /**
         *
         * 执行结果：
         通过
         显示详情
         执行用时 :30 ms, 在所有 Java 提交中击败了61.82%
         的用户
         内存消耗 :56 MB, 在所有 Java 提交中击败了100.00%
         的用户
         * @param arr
         * @return
         */
        public int[] arrayRankTransform(int[] arr) {
            int len = arr.length;
            int[] newArr = new int[len];
            int k = 0;
            for (int num : arr) {
                newArr[k++] = num;
            }
            Arrays.sort(newArr);
            Map<Integer, Integer> rankMap = new HashMap<>();
            for (int i : newArr) {
                rankMap.compute(i, (integer, old) -> {
                    if (old == null) {
                        rank++;
                        return rank ;
                    } else {
                        return rank;
                    }
                });
            }

            for (int i = 0; i < len; i++) {
                arr[i] = rankMap.get(arr[i]);
            }
            return arr;
        }
    }

    public static void main(String[] args) {
        logger.info("{}", new Solution().arrayRankTransform(new int[]{40,10,20,30}));
        logger.info("{}", new Solution().arrayRankTransform(new int[]{100,100,100}));
    }
}
