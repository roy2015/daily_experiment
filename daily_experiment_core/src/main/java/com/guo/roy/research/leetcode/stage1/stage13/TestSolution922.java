package com.guo.roy.research.leetcode.stage1.stage13;

import org.slf4j.LoggerFactory;

/**
 * @author guojun
 * @date 2020/7/23
 *
 * 922. 按奇偶排序数组 II
 * 给定一个非负整数数组 A， A 中一半整数是奇数，一半整数是偶数。
 *
 * 对数组进行排序，以便当 A[i] 为奇数时，i 也是奇数；当 A[i] 为偶数时， i 也是偶数。
 *
 * 你可以返回任何满足上述条件的数组作为答案。
 *
 *
 *
 * 示例：
 *
 * 输入：[4,2,5,7]
 * 输出：[4,5,2,7]
 * 解释：[4,7,2,5]，[2,5,4,7]，[2,7,4,5] 也会被接受。
 *
 *
 * 提示：
 *
 * 2 <= A.length <= 20000
 * A.length % 2 == 0
 * 0 <= A[i] <= 1000
 *
 *
 * 通过次数32,996提交次数48,720
 *
 *
 */
public class TestSolution922 {
    private static final org.slf4j.Logger logger = LoggerFactory.getLogger(TestSolution922.class);


    static class Solution {
        /**
         *
         * 还是空间换时间吧,不管了
         *
         * 执行结果：
         * 通过
         * 显示详情
         * 执行用时：
         * 2 ms, 在所有 Java 提交中击败了100.00%的用户
         * 内存消耗：
         * 42.6 MB, 在所有 Java 提交中击败了9.09%的用户
         *
         * @param A
         * @return
         */
        public int[] sortArrayByParityII(int[] A) {
            int evenIdx = 0;//偶数
            int oddIdx = 1;//奇数

            int[] retInts = new int[A.length];
            for (int i = 0; i < A.length; i++) {
                int iVal = A[i];
                if ((iVal & 0x1) == 0) {
                    retInts[evenIdx] = iVal;
                    evenIdx += 2;
                } else {
                    retInts[oddIdx] = iVal;
                    oddIdx += 2;
                }
            }
            return retInts;
        }
    }

    public static void main(String[] args) {
        logger.info("{}", new Solution().sortArrayByParityII(new int[]{4,2,5,7}));
    }
}
