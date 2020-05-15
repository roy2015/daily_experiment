package com.roy.miscellaneous.leetcode.stage11;

import org.slf4j.LoggerFactory;

/**
 * @author guojun
 * @date 2020/1/21 10:40
 *
 * 492. 构造矩形
作为一位web开发者， 懂得怎样去规划一个页面的尺寸是很重要的。 现给定一个具体的矩形页面面积，你的任务是设计一个长度为 L 和宽度为 W 且满足以下要求的矩形的页面。要求：

1. 你设计的矩形页面必须等于给定的目标面积。

2. 宽度 W 不应大于长度 L，换言之，要求 L >= W 。

3. 长度 L 和宽度 W 之间的差距应当尽可能小。
你需要按顺序输出你设计的页面的长度 L 和宽度 W。

示例：

输入: 4
输出: [2, 2]
解释: 目标面积是 4， 所有可能的构造方案有 [1,4], [2,2], [4,1]。
但是根据要求2，[1,4] 不符合要求; 根据要求3，[2,2] 比 [4,1] 更能符合要求. 所以输出长度 L 为 2， 宽度 W 为 2。
 */
public class TestSolution492 {
    private static final org.slf4j.Logger logger = LoggerFactory.getLogger(TestSolution492.class);


    static class Solution {
        /**
         *
         *
         * what?双指针22ms?
         *
         * 执行结果：通过显示详情
         执行用时 :22 ms, 在所有 Java 提交中击败了29.92%的用户
         内存消耗 :37.1 MB, 在所有 Java 提交中击败了14.29%的用户
         * @param area
         * @return
         */
        public int[] constructRectangle(int area) {
            int base = (int) Math.sqrt(area);
            int p,q;
            p = q = base;
            while ( p > 0 && q <= area) {
                int mul = p * q;
                if (mul == area) {
                    return new int[]{q,p};
                } else if (mul < area) {
                    q ++;
                } else p --;
            }
            return new int[]{0};
        }
    }

    public static void main(String[] args) {
        logger.info("{}", new Solution().constructRectangle(5));
        logger.info("{}", new Solution().constructRectangle(30));
    }
}
