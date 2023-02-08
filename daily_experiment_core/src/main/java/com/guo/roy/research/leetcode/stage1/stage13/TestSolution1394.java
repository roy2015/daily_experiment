package com.guo.roy.research.leetcode.stage1.stage13;

import java.util.HashMap;
import java.util.Map;

import org.slf4j.LoggerFactory;

/**
 * @author guojun
 * @date 2020/7/17
 *
 * 1394. 找出数组中的幸运数
 * 在整数数组中，如果一个整数的出现频次和它的数值大小相等，我们就称这个整数为「幸运数」。
 *
 * 给你一个整数数组 arr，请你从中找出并返回一个幸运数。
 *
 * 如果数组中存在多个幸运数，只需返回 最大 的那个。
 * 如果数组中不含幸运数，则返回 -1 。
 *
 *
 * 示例 1：
 *
 * 输入：arr = [2,2,3,4]
 * 输出：2
 * 解释：数组中唯一的幸运数是 2 ，因为数值 2 的出现频次也是 2 。
 * 示例 2：
 *
 * 输入：arr = [1,2,2,3,3,3]
 * 输出：3
 * 解释：1、2 以及 3 都是幸运数，只需要返回其中最大的 3 。
 * 示例 3：
 *
 * 输入：arr = [2,2,2,3,3]
 * 输出：-1
 * 解释：数组中不存在幸运数。
 * 示例 4：
 *
 * 输入：arr = [5]
 * 输出：-1
 * 示例 5：
 *
 * 输入：arr = [7,7,7,7,7,7,7]
 * 输出：7
 *
 *
 * 提示：
 *
 * 1 <= arr.length <= 500
 * 1 <= arr[i] <= 500
 *
 */
public class TestSolution1394 {
    private static final org.slf4j.Logger logger = LoggerFactory.getLogger(TestSolution1394.class);


    static class Solution {
        /**
         *
         * 执行结果：
         * 通过
         * 显示详情
         * 执行用时：
         * 4 ms, 在所有 Java 提交中击败了48.80%的用户
         * 内存消耗：
         * 39 MB, 在所有 Java 提交中击败了100.00%的用户
         *
         * @param arr
         * @return
         */
        public int findLucky(int[] arr) {
            Map<Integer, Integer> map = new HashMap<>();
            for (int i : arr) {
                map.compute(i, (key, oldVal) -> {
                    if (oldVal == null) {
                        return Integer.valueOf(1);
                    } else {
                        //这段不能要，因为删完可能又会加上去
                        /*if (oldVal.compareTo(key) == 0)  {
                            return null;// indicate to delete node
                        } else */{
                            return Integer.valueOf(oldVal.intValue() + 1);
                        }
                    }
                });
            }
            //second stage

            //not supported by leecode's jdk, maybe jdk version 1.7 or lower?
            /*Set<Integer> keys = map.keySet();
            OptionalInt max = keys.stream().mapToInt(
                    value -> {
                        if (map.get(value) != value) {
                            return -1;
                        } else {
                            return value;
                        }
                    }).max();
            int ret = max.orElse(-1);*/

            int ret =-1;
            for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
                Integer key = entry.getKey();
                Integer value = entry.getValue();
                if (key == value && key > ret) {
                    ret = key;
                }
            }
            return ret;
        }
    }

    public static void main(String[] args) {
        logger.info("{}", new Solution().findLucky(new int[]{10,1,17,18,19,12,14,7,10,6,20,15,20,18,14,1,8,
                11,11,1,17,5,9,5,11,2,4,7,3,6,3,16,17,7,3,10,1,16,13,7,10,5,8,6,13,7,10,13,14,16,12,15,13,
                12,14,20,13,11,11,20,6,13,6,4,14,1,4,11,16,17,12,4,11,1,10,2,18,5,6,3,9,2,14,9,18,13,14,
                5,11,6,9,1,5,12,4,8,7,7,17,1,19,16,12,10,16,4,8,18,3,15,2,20,15,14,16,20,16,3,18,
                8,16,20,7,12,5,14,11,7,3,11,19,12,20,12,3,20,8,15,20,19,2,3,14,17}));//-1
        logger.info("{}", new Solution().findLucky(new int[]{1,2,2,3,3,3}));//3
        logger.info("{}", new Solution().findLucky(new int[]{2,2,2,3,3}));//-1
        logger.info("{}", new Solution().findLucky(new int[]{5}));//-1
        logger.info("{}", new Solution().findLucky(new int[]{7,7,7,7,7,7,7}));//7



    }
}
