package com.roy.miscellaneous.leetcode.stage2.stage20;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.slf4j.LoggerFactory;

/**
 *
 * 873. 最长的斐波那契子序列的长度
 * 如果序列 X_1, X_2, ..., X_n 满足下列条件，就说它是 斐波那契式 的：
 *
 * n >= 3
 * 对于所有 i + 2 <= n，都有 X_i + X_{i+1} = X_{i+2}
 * 给定一个严格递增的正整数数组形成序列 arr ，找到 arr 中最长的斐波那契式的子序列的长度。如果一个不存在，返回  0 。
 *
 * （回想一下，子序列是从原序列 arr 中派生出来的，它从 arr 中删掉任意数量的元素（也可以不删），而不改变其余元素的顺序。例如， [3, 5, 8] 是 [3, 4, 5, 6, 7, 8] 的一个子序列）
 *
 *
 *
 * 示例 1：
 *
 * 输入: arr = [1,2,3,4,5,6,7,8]
 * 输出: 5
 * 解释: 最长的斐波那契式子序列为 [1,2,3,5,8] 。
 * 示例 2：
 *
 * 输入: arr = [1,3,7,11,12,14,18]
 * 输出: 3
 * 解释: 最长的斐波那契式子序列有 [1,11,12]、[3,11,14] 以及 [7,11,18] 。
 *
 *
 * 提示：
 *
 * 3 <= arr.length <= 1000
 * 1 <= arr[i] < arr[i + 1] <= 10^9
 * @author guojun
 * @date 2021/1/21 10:40
 */
public class TestSolution873 {
    private static final org.slf4j.Logger logger = LoggerFactory.getLogger(TestSolution873.class);


    static class Solution {
        private Set<Integer> dic;
        private int maxVal ;
        private int max = 3;

        /**
         *
         * 1.建字典
         * 2.建斐波那契数列的头元素(a, b, a+6)列表，
         * 3.遍历列表
         *
         *
         * 执行结果：通过
         * 显示详情
         * 添加备注         *
         * 执行用时：218 ms, 在所有 Java 提交中击败了21.09%的用户
         * 内存消耗：41.7 MB, 在所有 Java 提交中击败了59.98%的用户
         * 通过测试用例：56 / 56
         *
         * @param arr
         * @return
         */
        public int lenLongestFibSubseq(int[] arr) {
            int length = arr.length;
            maxVal = arr[length-1];
            dic = new HashSet<>();
            for (int i : arr) {
                dic.add(i);
            }

            List<Triple> triples = new ArrayList<>();

            for (int i = 0; i < length -1 ; i++) {
                int iVal = arr[i];
                for (int j = i + 1; j < length ; j++) {
                    int jVal = arr[j];
                    int sumIJ = iVal + jVal;
                    if (dic.contains(sumIJ)) {
                        triples.add(new Triple(iVal, jVal, sumIJ));
                    }
                }
            }
            if (triples.size() == 0) {
                return 0;
            }

            for (Triple triple : triples) {
                doFib(triple.d2, triple.d3);
            }
            return max;
        }

        private void doFib(int a, int b) {
            int k = 3;
            while (true) {
                int c = a + b;
                if (c <= maxVal && dic.contains(c))  {
                    k ++;
                } else {
                    break;
                }
                a = b;
                b = c;
            }
            if (k >= max) {
                max = k;
            }
        }

        class Triple {
            private int d1;
            private int d2;
            private int d3;

            public Triple(int d1, int d2, int d3) {
                this.d1 = d1;
                this.d2 = d2;
                this.d3 = d3;
            }
        }
    }

    public static void main(String[] args) {
        logger.info("{}", new Solution().lenLongestFibSubseq(new int[]{1,2,5}));//0
        logger.info("{}", new Solution().lenLongestFibSubseq(new int[]{1,3,7,11,12,14,18}));//3
        logger.info("{}", new Solution().lenLongestFibSubseq(new int[]{1,2,3,4,5,6,7,8}));//5
    }
}
