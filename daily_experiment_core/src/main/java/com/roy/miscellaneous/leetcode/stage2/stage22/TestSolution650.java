package com.roy.miscellaneous.leetcode.stage2.stage22;

import org.slf4j.LoggerFactory;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * @author guojun
 * @date 2020/12/15
 *
 * 650. 只有两个键的键盘
 * 最初在一个记事本上只有一个字符 'A'。你每次可以对这个记事本进行两种操作：
 *
 * Copy All (复制全部) : 你可以复制这个记事本中的所有字符(部分的复制是不允许的)。
 * Paste (粘贴) : 你可以粘贴你上一次复制的字符。
 * 给定一个数字 n 。你需要使用最少的操作次数，在记事本中打印出恰好 n 个 'A'。输出能够打印出 n 个 'A' 的最少操作次数。
 *
 * 示例 1:
 *
 * 输入: 3
 * 输出: 3
 * 解释:
 * 最初, 我们只有一个字符 'A'。
 * 第 1 步, 我们使用 Copy All 操作。
 * 第 2 步, 我们使用 Paste 操作来获得 'AA'。
 * 第 3 步, 我们使用 Paste 操作来获得 'AAA'。
 * 说明:
 *
 * n 的取值范围是 [1, 1000] 。
 *
 */
public class TestSolution650 {
    private static final org.slf4j.Logger logger = LoggerFactory.getLogger(TestSolution650.class);


    static class Solution {

        /**
         * 最后一次肯定是v操作，c vvvvv
         * 1. ctrl+C: node val = parent val
         * 2. ctrl+V:  parent is ctrl+C ? 2* parent val : 递归找到第一个ctrl+C + parent val
         *  广度优先
         *
         * 超出内存限制，但不失为一个正确的解法，使用了二叉树的数组形式计算，答案是正确的，就是内存超出限制，
         * 还有一点，如果大于29质数，会导致需要2^29空间，~~~
         *
         *
         * 类似与暴力破解
         *
         *
         * @param n
         * @return
         */
        public int minSteps(int n) {
            List<Integer> arrays = new ArrayList<>();
            arrays.add(1);
            arrays.add(1);
            arrays.add(1);
            if (n == 1) {
                return 0;
            }

            int i;
            for (i = 3; ; i++) {
                int parentIdx;
                int iVal = 0;
                if ((i & 0x1) == 1) {
                    parentIdx = (i -1) >> 1;
                    iVal = arrays.get(parentIdx);
                } else {
                    parentIdx = (i - 2) >> 1;
                    int ancestorIdx = parentIdx;
                    while ((ancestorIdx & 0x1) == 0 && ancestorIdx != 0 ) {
                        ancestorIdx = (ancestorIdx -2) >> 1;
                    }

                    iVal = arrays.get(parentIdx) + (ancestorIdx == 0 ? 0 : arrays.get(ancestorIdx));
                }
                if (iVal == n) break;
                else arrays.add(iVal);
            }
            //计算在第几层，返回
            i = i + 1;
            int js;
            for (js = 0; i >= (1<<js) ; js++) {
            }
            return js -1;
        }

        /**
         *
         * 官方题解， 质因数之和，也是骚套路,利用了某种认知策略把问题简化了，不如上面暴力破解来的清晰
         * https://leetcode-cn.com/problems/2-keys-keyboard/solution/zhi-you-liang-ge-jian-de-jian-pan-by-leetcode/
         *
         * 执行结果：
         * 通过
         * 显示详情
         * 执行用时：
         * 0 ms
         * , 在所有 Java 提交中击败了
         * 100.00%
         * 的用户
         * 内存消耗：
         * 35.4 MB
         * , 在所有 Java 提交中击败了
         * 57.74%
         * 的用户
         *
         * @param n
         * @return
         */
        public int minSteps1 (int n) {
            //1000以内的质数表
            int[] primeDic  = {2, 3, 5, 7, 11, 13, 17, 19, 23, 29, 31, 37, 41, 43, 47, 53, 59, 61, 67, 71, 73,
                    79, 83, 89, 97, 101, 103, 107, 109, 113, 127, 131, 137, 139, 149, 151, 157, 163, 167, 173, 179,
                    181, 191, 193, 197, 199, 211, 223, 227, 229, 233, 239, 241, 251, 257, 263, 269, 271, 277, 281,
                    283, 293, 307, 311, 313, 317, 331, 337, 347, 349, 353, 359, 367, 373, 379, 383, 389, 397, 401,
                    409, 419, 421, 431, 433, 439, 443, 449, 457, 461, 463, 467, 479, 487, 491, 499, 503, 509, 521,
                    523, 541, 547, 557, 563, 569, 571, 577, 587, 593, 599, 601, 607, 613, 617, 619, 631, 641, 643,
                    647, 653, 659, 661, 673, 677, 683, 691, 701, 709, 719, 727, 733, 739, 743, 751, 757, 761, 769,
                    773, 787, 797, 809, 811, 821, 823, 827, 829, 839, 853, 857, 859, 863, 877, 881, 883, 887, 907,
                    911, 919, 929, 937, 941, 947, 953, 967, 971, 977, 983, 989, 991, 997, 1001};

            if (n == 1) {
                return 0;
            }

            int ret = 0;
            int d = n;

            while (true) {
                for (int i = 0; ; i++) {
                    int temp = d % primeDic[i];
                    //能除尽
                    if (temp == 0) {
                        d = d / primeDic[i];
                        ret += primeDic[i];
                        if (d == 1) {
                            return ret;
                        }
                        break;
                    }
                }
            }
        }

    }

    public static void main(String[] args) {

        logger.info("===========================");
        Solution sou = new Solution();
        for (int i = 1; i <= 1 ; i++) {
            int k = 29;
            logger.info("{}, {}", sou.minSteps1(k), sou.minSteps(k));

        }
        logger.info("===========================");

        logger.info("{}", new Solution().minSteps(1000));//21
        logger.info("{}", new Solution().minSteps1(7));//7
        logger.info("{}", new Solution().minSteps1(13));//13
        logger.info("{}", new Solution().minSteps1(4));//4
        logger.info("{}", new Solution().minSteps1(6));//5
    }
}
