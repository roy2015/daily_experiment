package com.guo.roy.research.leetcode.stage1.stage10;

import org.slf4j.LoggerFactory;

/**
 * @author guojun
 * @date 2020/10/29
 *
 * 788. 旋转数字
 * 我们称一个数 X 为好数, 如果它的每位数字逐个地被旋转 180 度后，我们仍可以得到一个有效的，且和 X 不同的数。要求每位数字都要被旋转。
 *
 * 如果一个数的每位数字被旋转以后仍然还是一个数字， 则这个数是有效的。0, 1, 和 8 被旋转后仍然是它们自己；2 和 5 可以互相旋转成对方（在这种情况下，它们以不同的方向旋转，换句话说，2 和 5 互为镜像）；6 和 9 同理，除了这些以外其他的数字旋转以后都不再是有效的数字。
 *
 * 现在我们有一个正整数 N, 计算从 1 到 N 中有多少个数 X 是好数？
 *
 *
 *
 * 示例：
 *
 * 输入: 10
 * 输出: 4
 * 解释:
 * 在[1, 10]中有四个好数： 2, 5, 6, 9。
 * 注意 1 和 10 不是好数, 因为他们在旋转之后不变。
 *
 *
 * 提示：
 *
 * N 的取值范围是 [1, 10000]。
 *
 */
public class TestSolution788 {
    private static final org.slf4j.Logger logger = LoggerFactory.getLogger(TestSolution788.class);


    static class Solution {

        /**
         * 题目意思是每位上的数字旋转180度，而不是这个数字旋转180度，如果是后者就复杂了
         *1025698
         * 好数条件：
         * 1.不是纯108
         * 2.只出现1025698，而不是3,4,7
         *
         *
         * 执行结果：
         * 通过
         * 显示详情
         * 执行用时：12 ms, 在所有 Java 提交中击败了30.42%的用户
         * 内存消耗：38.2 MB, 在所有 Java 提交中击败了29.53%的用户
         *
         *
         * @param N
         * @return
         */
        public int rotatedDigits(int N) {
            //判断一个数是不是好数 没有3，4，7 -> 至少有2569其中一个
            int sum = 0;

            for (int i = 2; i <= N; i++) {
                //判断i是否好数
                String iStr = String.valueOf(i);
                if (iStr.indexOf("3") != -1 || iStr.indexOf("4") != -1
                    || iStr.indexOf("7") != -1) {
                    continue;
                } else if (iStr.indexOf("2") != -1 || iStr.indexOf("5") != -1
                        || iStr.indexOf("6") != -1 || iStr.indexOf("9") != -1) {
                    sum ++;
                } else {
                    //pass
                }
            }
            return sum;
        }
    }

    public static void main(String[] args) {
        logger.info("{}", new Solution().rotatedDigits(20));//9
        logger.info("{}", new Solution().rotatedDigits(10));//4
        logger.info("{}", new Solution().rotatedDigits(10000));
    }
}
