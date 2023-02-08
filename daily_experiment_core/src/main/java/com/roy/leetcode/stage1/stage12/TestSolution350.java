package com.roy.leetcode.stage1.stage12;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

import org.slf4j.LoggerFactory;

/**
 * @author guojun
 * @date 2020/5/25
 *
 * 350. 两个数组的交集 II
给定两个数组，编写一个函数来计算它们的交集。

示例 1:

输入: nums1 = [1,2,2,1], nums2 = [2,2]
输出: [2,2]
示例 2:

输入: nums1 = [4,9,5], nums2 = [9,4,9,8,4]
输出: [4,9]
说明：

输出结果中每个元素出现的次数，应与元素在两个数组中出现的次数一致。
我们可以不考虑输出结果的顺序。
 *
 */
public class TestSolution350 {
    private static final org.slf4j.Logger logger = LoggerFactory.getLogger(TestSolution350.class);


    static class Solution {

        /**
         *
         * 执行结果：
         通过
         显示详情
         执行用时 :4 ms, 在所有 Java 提交中击败了62.30%的用户
         内存消耗 :40 MB, 在所有 Java 提交中击败了5.13%的用户
         *
         * @param nums1
         * @param nums2
         * @return
         */
        public int[] intersect(int[] nums1, int[] nums2) {
            int len1 = nums1.length;
            int len2 = nums2.length;


            Map<Integer, Integer> map = new HashMap<>();
            for(int i =0 ; i< len1; i++) {
                int val = nums1[i];
                map.compute(val, (key, oldVal) -> {
                    if (oldVal == null) {
                        oldVal = new Integer(1);
                    } else {
                        oldVal ++;
                    }
                    return oldVal;
                });
            }

            int[] ret =  new int[len2];
            int k =0;
            for(int i =0 ; i< len2; i++) {
                int val = nums2[i] ;
                if (map.containsKey(val)) {
                    Integer count = map.get(val);
                    if (count > 0) {
                        ret[k++] = nums2[i] ;

                        map.put(val,  -- count);
                    }
                }
            }

            return Arrays.copyOfRange(ret, 0, k);
        }

    }

    public static void main(String[] args) {
        logger.info("{}", new Solution().intersect(new int[]{4,9,5}, new int[]{9,4,9,8,4}));
    }
}
