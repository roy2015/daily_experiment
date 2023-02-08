package com.guo.roy.research.leetcode.stage1.stage11;

import java.util.*;

import org.slf4j.LoggerFactory;

/**
 * @author guojun
 * @date 2020/7/22
 *
 *1356. 根据数字二进制下 1 的数目排序
 * 给你一个整数数组 arr 。请你将数组中的元素按照其二进制表示中数字 1 的数目升序排序。
 *
 * 如果存在多个数字二进制中 1 的数目相同，则必须将它们按照数值大小升序排列。
 *
 * 请你返回排序后的数组。
 *
 *
 *
 * 示例 1：
 *
 * 输入：arr = [0,1,2,3,4,5,6,7,8]
 * 输出：[0,1,2,4,8,3,5,6,7]
 * 解释：[0] 是唯一一个有 0 个 1 的数。
 * [1,2,4,8] 都有 1 个 1 。
 * [3,5,6] 有 2 个 1 。
 * [7] 有 3 个 1 。
 * 按照 1 的个数排序得到的结果数组为 [0,1,2,4,8,3,5,6,7]
 * 示例 2：
 *
 * 输入：arr = [1024,512,256,128,64,32,16,8,4,2,1]
 * 输出：[1,2,4,8,16,32,64,128,256,512,1024]
 * 解释：数组中所有整数二进制下都只有 1 个 1 ，所以你需要按照数值大小将它们排序。
 * 示例 3：
 *
 * 输入：arr = [10000,10000]
 * 输出：[10000,10000]
 * 示例 4：
 *
 * 输入：arr = [2,3,5,7,11,13,17,19]
 * 输出：[2,3,5,17,7,11,13,19]
 * 示例 5：
 *
 * 输入：arr = [10,100,1000,10000]
 * 输出：[10,100,10000,1000]
 *
 *
 * 提示：
 *
 * 1 <= arr.length <= 500
 * 0 <= arr[i] <= 10^4
 *
 *
 */
public class TestSolution1356 {
    private static final org.slf4j.Logger logger = LoggerFactory.getLogger(TestSolution1356.class);


    /**
     *
     * //1 <= arr.length <= 500
     * //0 <= arr[i] <= 10^4,  所以最多14个1
     *
     *
     *
     *
     */
    static class Solution {



        /**
         *
         *
         * 执行结果：
         * 通过
         * 显示详情
         * 执行用时：
         * 11 ms, 在所有 Java 提交中击败了45.29%的用户
         * 内存消耗：
         * 40.6 MB, 在所有 Java 提交中击败了100.00%的用户
         *
         * @param arr
         * @return
         */
        public int[] sortByBits(int[] arr) {
            //1出现相同次数的元素要排序，直接先排序掉
            Arrays.sort(arr);
            //引入keyArray是为了减少key排序
            int[] keyArray = new int[15];
            Map<Integer, List<Integer>> map = new HashMap<>();
            for (int i : arr) {
                int numberOf1Bits = getTheNumberOf1Bits(i);
                map.compute(numberOf1Bits, (key, oldVal) -> {
                    if (oldVal == null) {
                        List<Integer> list = new ArrayList<>();
                        keyArray[numberOf1Bits] = 1;
                        list.add(i);
                        return list;
                    } else {
                        oldVal.add(i);
                        return oldVal;
                    }
                });
            }

            int[] retInts = new int[arr.length];
            int i = 0;

            for (int i1 = 0; i1 < keyArray.length; i1++) {
                if (keyArray[i1] != 0) {
                    for (Integer k : map.get(i1)) {
                        retInts[i++] = k;
                    }
                }
            }

            /*List<Integer> keyList = new ArrayList<>(map.keySet());
            Collections.sort(keyList);
            int[] retInts = new int[arr.length];
            int  i = 0;
            for (Integer integer : keyList) {
                for (Integer k : map.get(integer)) {
                    retInts[i++] = k;
                }
            }*/

            return retInts;
        }

        /**
         *
         * 统计十进制数字的二进制的表示里有几个1
         *
         *
         * @param n
         * @return
         */
        private int getTheNumberOf1Bits(int n) {
            int ret = 0;
            do {
                int ys = n & 0x1;
                if (ys == 1) {
                    ret ++;
                }
                n = n >> 1;
            } while (n != 0);
            return ret;
        }
    }

    public static void main(String[] args) {
//        logger.info("{}", new Solution().getTheNumberOf1Bits(0));
//        logger.info("{}", new Solution().getTheNumberOf1Bits(7));
//        logger.info("{}", new Solution().getTheNumberOf1Bits(8));

        logger.info("{}");
        logger.info("{}", new Solution().sortByBits(new int[]{1024,512,256,128,64,32,16,8,4,2,1}));//1,2,4,8,16,32,64,128,256,512,1024
        logger.info("{}", new Solution().sortByBits(new int[]{0,1,2,3,4,5,6,7,8}));//0,1,2,4,8,3,5,6,7

    }
}
