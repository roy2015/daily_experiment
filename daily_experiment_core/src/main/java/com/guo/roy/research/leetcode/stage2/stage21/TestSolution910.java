package com.guo.roy.research.leetcode.stage2.stage21;

import java.util.Arrays;

import org.slf4j.LoggerFactory;

/**
 * @author guojun
 * @date 2020/6/8
 *
 *
 * 910. 最小差值 II
给定一个整数数组 A，对于每个整数 A[i]，我们可以选择 x = -K 或是 x = K，并将 x 加到 A[i] 中。

在此过程之后，我们得到一些数组 B。

返回 B 的最大值和 B 的最小值之间可能存在的最小差值。



示例 1：

输入：A = [1], K = 0
输出：0
解释：B = [1]
示例 2：

输入：A = [0,10], K = 2
输出：6
解释：B = [2,8]
示例 3：

输入：A = [1,3,6], K = 3
输出：3
解释：B = [4,6,3]


提示：

1 <= A.length <= 10000
0 <= A[i] <= 10000
0 <= K <= 10000
 *
 */
public class TestSolution910 {
    private static final org.slf4j.Logger logger = LoggerFactory.getLogger(TestSolution910.class);


    static class Solution {

        /**
         *
         * 执行结果：
         通过
         显示详情
         执行用时 :10 ms
         , 在所有 Java 提交中击败了96.50%
         的用户
         内存消耗 :
         40.4 MB
         , 在所有 Java 提交中击败了
         100.00%
         的用户
         *
         * @param A
         * @param K
         * @return
         */
        public int smallestRangeII(int[] A, int K) {
            int length = A.length;
            Arrays.sort(A);
            int ans;
            ans = A[length -1] -  A[0];
            for (int i = 0; i< length-1; i ++) {
                int max = Math.max(A[i] + K, A[length -1] - K);
                int min = Math.min(A[0] + K, A[i +1] - K);
                ans = Math.min(max - min, ans);
            }
            return ans;
        }
    }

    public static void main(String[] args) {
        logger.info("{}", new Solution().smallestRangeII(new int[]{1,3 ,6}, 3));
    }
}
