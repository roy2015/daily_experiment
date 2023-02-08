package com.roy.leetcode.stage1.stage12;

import org.slf4j.LoggerFactory;

/**
 * @author guojun
 * @date 2020/5/25
 *
 * 888. 公平的糖果交换
爱丽丝和鲍勃有不同大小的糖果棒：A[i] 是爱丽丝拥有的第 i 块糖的大小，B[j] 是鲍勃拥有的第 j 块糖的大小。

因为他们是朋友，所以他们想交换一个糖果棒，这样交换后，他们都有相同的糖果总量。（一个人拥有的糖果总量是他们拥有的糖果棒大小的总和。）

返回一个整数数组 ans，其中 ans[0] 是爱丽丝必须交换的糖果棒的大小，ans[1] 是 Bob 必须交换的糖果棒的大小。

如果有多个答案，你可以返回其中任何一个。保证答案存在。



示例 1：

输入：A = [1,1], B = [2,2]
输出：[1,2]
示例 2：

输入：A = [1,2], B = [2,3]
输出：[1,2]
示例 3：

输入：A = [2], B = [1,3]
输出：[2,3]
示例 4：

输入：A = [1,2,5], B = [2,4]
输出：[5,4]


提示：

1 <= A.length <= 10000
1 <= B.length <= 10000
1 <= A[i] <= 100000
1 <= B[i] <= 100000
保证爱丽丝与鲍勃的糖果总量不同。
答案肯定存在。
 *
 *
 *
 */
public class TestSolution888 {
    private static final org.slf4j.Logger logger = LoggerFactory.getLogger(TestSolution888.class);


    static class Solution {
        /**
         *
         *
         * 执行结果：
         通过
         显示详情
         执行用时 :
         262 ms
         , 在所有 Java 提交中击败了31.69%
         的用户
         内存消耗 :
         41.3 MB
         , 在所有 Java 提交中击败了30.00%
         的用户
         *
         * @param A
         * @param B
         * @return
         */
        public int[] fairCandySwap(int[] A, int[] B) {
            int aSum = 0;
            int bSum = 0;

            int aLen = A.length;
            int bLen = B.length;

            for (int i = 0; i < aLen || i < bLen; i++) {
                if (i < aLen) {
                    aSum += A[i];
                }
                if (i < bLen) {
                    bSum += B[i];
                }
            }

            int swap = (aSum - bSum) /2;
            if (swap > 0) {
                for (int i : A) {
                    for (int i1 : B) {
                        if (i1 == i - swap) {
                            return new int[] {i, i - swap};
                        }
                    }
                }
            } else {//<0
                swap = - swap;
                for (int i : A) {
                    for (int i1 : B) {
                        if (i1 == i + swap) {
                            return new int[] {i, i + swap};
                        }
                    }
                }
            }
            return null;
        }
    }

    public static void main(String[] args) {
        logger.info("{}", new Solution().fairCandySwap(
                new int[]{2},
                new int[]{1,3}));

        logger.info("{}", new Solution().fairCandySwap(
                new int[]{1,1},
                new int[]{2,2}));
    }
}
