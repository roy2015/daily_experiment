package com.guo.roy.research.leetcode.stage1.stage10;

import org.slf4j.LoggerFactory;

/**
 * Created by apple on 2019/11/5.
 *假设你正在爬楼梯。需要 n 阶你才能到达楼顶。

 每次你可以爬 1 或 2 个台阶。你有多少种不同的方法可以爬到楼顶呢？

 注意：给定 n 是一个正整数。

 示例 1：

 输入： 2
 输出： 2
 解释： 有两种方法可以爬到楼顶。
 1.  1 阶 + 1 阶
 2.  2 阶
 示例 2：

 输入： 3
 输出： 3
 解释： 有三种方法可以爬到楼顶。
 1.  1 阶 + 1 阶 + 1 阶
 2.  1 阶 + 2 阶
 3.  2 阶 + 1 阶

 来源：力扣（LeetCode）
 链接：https://leetcode-cn.com/problems/climbing-stairs
 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 */
public class TestSolution70 {
    private static final org.slf4j.Logger logger = LoggerFactory.getLogger(TestSolution70.class);

    /**
     *
     *
     *
     */
    static class Solution {
        /**
         *
         * 实际上就是个斐波那契数列二叉树结构
         *
         * 执行用时 :0 ms, 在所有 java 提交中击败了100.00%的用户
         内存消耗 :33.1 MB, 在所有 java 提交中击败了71.44%的用户
         *
         *
         * @param n
         * @return
         */
        public int climbStairs(int n) {
            if (n ==1) {
                return 1;
            }
            if (n==2) {
                return 2;
            }

            int first = 1, second =2,k=0;
            for(int i =3; i<=n;i ++) {
                k = first + second;
                first = second;
                second = k;
            }
            return k;
            //return climbStairs(n-1) + climbStairs(n-2);
        }
    }

    public static void main(String[] args) {
        logger.info("{}", new Solution().climbStairs(10));
    }

}
