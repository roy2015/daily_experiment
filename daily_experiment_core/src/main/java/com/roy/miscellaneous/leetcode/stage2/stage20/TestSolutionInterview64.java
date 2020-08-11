package com.roy.miscellaneous.leetcode.stage2.stage20;

import org.slf4j.LoggerFactory;

/**
 * @author guojun
 * @date 2020/4/25 21:56
 *
 * 面试题64. 求1+2+…+n
求 1+2+...+n ，要求不能使用乘除法、for、while、if、else、switch、case等关键字及条件判断语句（A?B:C）。



示例 1：

输入: n = 3
输出: 6
示例 2：

输入: n = 9
输出: 45


限制：

1 <= n <= 10000
 *
 */
public class TestSolutionInterview64 {
    private static final org.slf4j.Logger logger = LoggerFactory.getLogger(TestSolutionInterview64.class);


    static class Solution {
        private int sum =0;

        /**
         * 执行结果：通过显示详情
         * 执行用时 :1 ms, 在所有 Java 提交中击败了61.27%的用户
         * 内存消耗 :37.3 MB, 在所有 Java 提交中击败了100.00%的用户
         *
         * 题目限制用if, esle,switch,for,while,三元判断，
         *  意义不大，纯粹是锻炼思路
         *
         * 参考了题解， 感觉这种思路就是耍流氓
         * 1. 为了避免if，用了短路语句，还用了无用的boolean变量
         * 2. 声明了全局变量（类成员变量）存累计结果， f(x)递归f(x-1)无非是去把
         *    x-1累加到全局变量后返回再累加x
         * @param n
         * @return
         */
        public int sumNums(int n) {
            boolean a = (n > 1) && sumNums(n -1) > 1;
            sum += n;
            return sum;
        }
    }

    public static void main(String[] args) {
        logger.info("{}",new Solution().sumNums(3));
    }
}
