package com.roy.miscellaneous.leetcode.stage1.stage11;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.LoggerFactory;

/**
 * @author guojun
 * @date 2020/5/8 11:15
 *
 * 1313. 解压缩编码列表
给你一个以行程长度编码压缩的整数列表 nums 。

考虑每对相邻的两个元素 [freq, val] = [nums[2*i], nums[2*i+1]] （其中 i >= 0 ），每一对都表示解压后子列表中有 freq 个值为 val 的元素，你需要从左到右连接所有子列表以生成解压后的列表。

请你返回解压后的列表。



示例：

输入：nums = [1,2,3,4]
输出：[2,4,4,4]
解释：第一对 [1,2] 代表着 2 的出现频次为 1，所以生成数组 [2]。
第二对 [3,4] 代表着 4 的出现频次为 3，所以生成数组 [4,4,4]。
最后将它们串联到一起 [2] + [4,4,4] = [2,4,4,4]。
示例 2：

输入：nums = [1,1,2,3]
输出：[1,3,3]


提示：

2 <= nums.length <= 100
nums.length % 2 == 0
1 <= nums[i] <= 100
 */
public class TestSolution1313 {
    private static final org.slf4j.Logger logger = LoggerFactory.getLogger(TestSolution1313.class);


    static class Solution {
        /**
         *
         * 耗时主要是在list转int[]
         *
         * @param nums
         * @return
         *
         * 执行结果：通过显示详情
         *  执行用时 :6 ms, 在所有 Java 提交中击败了33.38%的用户
         *  内存消耗 :40.6 MB, 在所有 Java 提交中击败了100.00%的用户
         */
        public int[] decompressRLElist(int[] nums) {
            List<Integer> retList = new ArrayList<>();
            int len = nums.length / 2;
            for (int i =0; i< len; i++) {
                int freq = nums[ 2*i + 0];
                int val = nums[ 2*i + 1];

                for (int j = 0; j < freq; j++) {
                    retList.add(val);
                }
            }

            int[] ints = new int[retList.size()];
            int k =0;
            for (Integer integer : retList) {
                ints[k ++] = integer;
            }
            return ints;
        }

        /**
         *
         * 优化改进，直接计算需要的数组长度，数组直接赋值，不需要list了
         *
         * 执行结果：通过显示详情
         执行用时 :1 ms, 在所有 Java 提交中击败了98.98%的用户
         内存消耗 :40.6 MB, 在所有 Java 提交中击败了100.00%的用户
         * @param nums
         * @return
         */
        public int[] decompressRLElist_1(int[] nums) {
            int len = nums.length / 2;
            int retLen = 0;
            //数组长度计算
            for (int i =0; i< len; i++) {
                retLen += nums[ 2*i + 0];
            }

            int[] ints = new int[retLen];
            int k =0;
            for (int i =0; i< len; i++) {
                //频率, 值
                int freq = nums[ 2*i + 0];
                int val = nums[ 2*i + 1];

                for (int j = 0; j < freq; j++) {
                    ints[k ++] = val;
                }
            }
            return ints;
        }
    }

    public static void main(String[] args) {
        logger.info("{}", new TestSolution1313.Solution().decompressRLElist(new int[]{1,1,2,3}));
        logger.info("{}", new TestSolution1313.Solution().decompressRLElist_1(new int[]{1,1,2,3}));
    }
}
