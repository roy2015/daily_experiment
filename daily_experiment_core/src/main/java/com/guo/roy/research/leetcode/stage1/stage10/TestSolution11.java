package com.guo.roy.research.leetcode.stage1.stage10;

import org.slf4j.LoggerFactory;

/**
 * Created by apple on 2019/9/10.
 * <p>
 * 给定 n 个非负整数 a1，a2，...，an，每个数代表坐标中的一个点 (i, ai) 。在坐标内画 n 条垂直线，垂直线 i 的两个端点分别为 (i, ai) 和 (i, 0)。找出其中的两条线，使得它们与 x 轴共同构成的容器可以容纳最多的水。
 * <p>
 * 说明：你不能倾斜容器，且 n 的值至少为 2。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/container-with-most-water
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class TestSolution11 {

    private static final org.slf4j.Logger logger = LoggerFactory.getLogger(TestSolution11.class);

    static class Solution {
        /**
         * 执行用时 :221 ms, 在所有 java 提交中击败了37.12%的用户
         内存消耗 :40 MB, 在所有 java 提交中击败了92.33%的用户
         *
         * @param height
         * @return
         */
        public int maxArea(int[] height) {
            int maxArea = 0, tmpArea;
            for (int i = 0; i < height.length - 1; i++) {
                for (int j = i + 1; j < height.length; j++) {
                    tmpArea = Math.abs(j - i) * Math.min(height[i], height[j]);
                    if (tmpArea > maxArea) {
                        maxArea = tmpArea;
                    }
                }
            }
            return maxArea;
        }

    }


    public static void main(String[] args) {
        Solution solution = new Solution();
        int i = solution.maxArea(new int[]{1, 8, 6, 2, 5, 4, 8, 3, 7});
        logger.info("{}", i);
    }

}
