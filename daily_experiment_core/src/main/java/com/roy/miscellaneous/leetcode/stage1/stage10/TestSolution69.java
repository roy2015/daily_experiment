package com.roy.miscellaneous.leetcode.stage1.stage10;

import org.slf4j.LoggerFactory;

/**
 * @author guojun
 * @date 2020/10/14
 *
 *
 * 69. x 的平方根
 * 实现 int sqrt(int x) 函数。
 *
 * 计算并返回 x 的平方根，其中 x 是非负整数。
 *
 * 由于返回类型是整数，结果只保留整数的部分，小数部分将被舍去。
 *
 * 示例 1:
 *
 * 输入: 4
 * 输出: 2
 * 示例 2:
 *
 * 输入: 8
 * 输出: 2
 * 说明: 8 的平方根是 2.82842...,
 *      由于返回类型是整数，小数部分将被舍去。
 */
public class TestSolution69 {
    private static final org.slf4j.Logger logger = LoggerFactory.getLogger(TestSolution69.class);


    static class Solution {
        /**
         *
         *
         * 原始思路：i从0开始轮询，知道i * i> k? 或者从k /2开始轮，这种算法感觉都不理想啊
         * 如果K比较大(2147483647)，超出时间限制
         *
         * 官方：
         * 本题是一道常见的面试题，面试官一般会要求面试者不使用 \sqrt{x}，得到 xx 的平方根的整数部分。一般的思路会有以下几种：
         *
         * 1. 方法一：袖珍计算器算法
         * 2. 方法二：二分查找
         * 3. 方法三：牛顿迭代
         *
         *
         *
         * 第一种方法：  用自然对数，对数函数 和指数函数
         * 注意有丢失精度的发生，这个自己写出来了，和官方的也一致~
         *
         * 官方说法：
         * 注意： 由于计算机无法存储浮点数的精确值（浮点数的存储方法可以参考 IEEE 754，这里不再赘述），
         * 而指数函数和对数函数的参数和返回值均为浮点数，因此运算过程中会存在误差。
         * 例如当 x = 2147395600x=2147395600 时，e^{\frac{1}{2} \ln x}e
         * 2
         * 1
         * ​
         *  lnx
         *   的计算结果与正确值 4634046340 相差 10^{-11}10
         * −11
         *  ，这样在对结果取整数部分时，会得到 4633946339 这个错误的结果。
         *
         * 因此在得到结果的整数部分 \textit{ans}ans 后，我们应当找出 \textit{ans}ans 与 \textit{ans} + 1ans+1 中哪一个是真正的答案。
         *
         *
         * 执行结果：
         * 通过
         * 显示详情
         * 执行用时：
         * 1 ms
         * , 在所有 Java 提交中击败了
         * 100.00%
         * 的用户
         * 内存消耗：
         * 35.7 MB
         * , 在所有 Java 提交中击败了
         * 99.22%
         * 的用户
         *
         * @param x
         * @return
         */
        public int mySqrt(int x) {
            if (x == 0) {
                return 0;
            }
            double exp = Math.exp( Math.log(x) * 0.5);
            int ret = (int) exp;
            if ((long)(ret + 1) * (ret + 1) <= Long.valueOf(x)) {
                return (ret + 1);
            } else return ret;
        }

        /**
         *
         * 时间复杂度：O(logx)，此方法是二次收敛的，相较于二分查找更快。
         * 空间复杂度：O(1)O(1)。
         *
         * 牛顿迭代
         * https://leetcode-cn.com/problems/sqrtx/solution/x-de-ping-fang-gen-by-leetcode-solution/
         * 牛顿迭代法是一种可以用来快速求解函数零点的方法。
         * 牛顿迭代法的本质是借助泰勒级数，从初始值开始快速向零点逼近。我们任取一个 x_0x
         * 0
         * ​
         *   作为初始值，在每一步的迭代中，我们找到函数图像上的点 (x_i, f(x_i))(x
         * i
         * ​
         *  ,f(x
         * i
         * ​
         *  ))，过该点作一条斜率为该点导数 f'(x_i)f
         * ′
         *  (x
         * i
         * ​
         *  ) 的直线，与横轴的交点记为 x_{i+1}x
         * i+1
         * ​
         *  。x_{i+1}x
         * i+1
         * ​
         *   相较于 x_ix
         * i
         * ​
         *   而言距离零点更近。在经过多次迭代后，我们就可以得到一个距离零点非常接近的交点。下图给出了从 x_0x
         * 0
         * ​
         *   开始迭代两次，得到 x_1x
         * 1
         * ​
         *   和 x_2x
         * 2
         * ​
         *   的过程。
         *
         * 作者：LeetCode-Solution
         * 链接：https://leetcode-cn.com/problems/sqrtx/solution/x-de-ping-fang-gen-by-leetcode-solution/
         * 来源：力扣（LeetCode）
         * 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
         *
         * 知识点 1.导数（斜率） 2.直线方程
         *
         * 为了叙述方便，我们用 CC 表示待求出平方根的那个整数。显然，CC 的平方根就是函数
         *
         * y = f(x) = x^2 - C
         * y=f(x)=x
         * 2
         *  −C
         *
         *
         * x= 0.5(xi + c/xi)
         *
         *
         * 执行结果：
         * 通过
         * 显示详情
         * 执行用时：
         * 1 ms
         * , 在所有 Java 提交中击败了
         * 100.00%
         * 的用户
         * 内存消耗：
         * 35.7 MB
         * , 在所有 Java 提交中击败了
         * 99.36%
         * 的用户
         *
         * @param x
         * @return
         */
        public int mySqrt1(int x) {
            double x1=x, x2;

            if (x ==0) {
                return 0;
            }

            while (true) {
                x2 = 0.5 * (x1 + x/x1);
                if (Math.abs(x1 - x2) <= 1e-7) {
                    return (int) x1;
                }
                x1 = x2;
            }
        }
    }

    public static void main(String[] args) {
        logger.info("{}", new Solution().mySqrt1(4));//2
        logger.info("{}", new Solution().mySqrt1(8));//2
        logger.info("{}", new Solution().mySqrt1(0));//0
        logger.info("{}", new Solution().mySqrt1(2147483647));//46340
        logger.info("{}", new Solution().mySqrt1(1));//1
        logger.info("{}", new Solution().mySqrt1(2147395600));//46340
    }
}
