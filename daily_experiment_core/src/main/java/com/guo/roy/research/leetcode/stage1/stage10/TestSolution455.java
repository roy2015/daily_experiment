package com.guo.roy.research.leetcode.stage1.stage10;

import java.util.Arrays;

import org.slf4j.LoggerFactory;

/**
 * @author guojun
 * @date 2020/4/27 17:40
 *
 *
 * 455. 分发饼干
 * 假设你是一位很棒的家长，想要给你的孩子们一些小饼干。但是，每个孩子最多只能给一块饼干。对每个孩子 i ，都有一个胃口值 gi ，这是能让孩子们满足胃口的饼干的最小尺寸；并且每块饼干 j ，都有一个尺寸 sj 。如果 sj >= gi ，我们可以将这个饼干 j 分配给孩子 i ，这个孩子会得到满足。你的目标是尽可能满足越多数量的孩子，并输出这个最大数值。
 *
 * 注意：
 *
 * 你可以假设胃口值为正。
 * 一个小朋友最多只能拥有一块饼干。
 *
 * 示例 1:
 *
 * 输入: [1,2,3], [1,1]
 *
 * 输出: 1
 *
 * 解释:
 * 你有三个孩子和两块小饼干，3个孩子的胃口值分别是：1,2,3。
 * 虽然你有两块小饼干，由于他们的尺寸都是1，你只能让胃口值是1的孩子满足。
 * 所以你应该输出1。
 * 示例 2:
 *
 * 输入: [1,2], [1,2,3]
 *
 * 输出: 2
 *
 * 解释:
 * 你有两个孩子和三块小饼干，2个孩子的胃口值分别是1,2。
 * 你拥有的饼干数量和尺寸都足以让所有孩子满足。
 * 所以你应该输出2.
 *
 */
public class TestSolution455 {
    private static final org.slf4j.Logger logger = LoggerFactory.getLogger(TestSolution455.class);


    static class Solution {

        /**
         *
         * 思路，两个排序数组 + 双指针
         *
         * 执行结果：
         * 通过
         * 显示详情
         * 执行用时 :8 ms, 在所有 Java 提交中击败了96.43%的用户
         * 内存消耗 :40.8 MB, 在所有 Java 提交中击败了9.52%的用户
         *
         * @param g 孩子们的满足值
         * @param s 饼干的size
         * @return
         */
        public int findContentChildren(int[] g, int[] s) {
            Arrays.sort(g);
            Arrays.sort(s);

            //定义双指针
            int gp;
            int sp;
            int gLen = g.length;
            int sLen = s.length;

            int gChildrenNum = 0;
            for (gp =0, sp=0 ; gp < gLen && sp < sLen;) {
                if (s[sp] >= g[gp]) {
                    gp ++;
                    sp ++;
                    gChildrenNum ++;
                } else {
                    sp ++;
                }
            }
            return gChildrenNum;
        }
    }

    public static void main(String[] args) {
        logger.info("{}", new Solution().findContentChildren(new int[]{1,2}, new int[]{1,2,3}));
    }
}
