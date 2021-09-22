package com.roy.miscellaneous.leetcode.stage3;

import java.util.Arrays;
import java.util.OptionalInt;
import java.util.PriorityQueue;

import org.slf4j.LoggerFactory;

import com.roy.miscellaneous.leetcode.stage1.stage13.TestSolution278.Solution;

/**
 * 354. 俄罗斯套娃信封问题
 * 给你一个二维整数数组 envelopes ，其中 envelopes[i] = [wi, hi] ，表示第 i 个信封的宽度和高度。
 *
 * 当另一个信封的宽度和高度都比这个信封大的时候，这个信封就可以放进另一个信封里，如同俄罗斯套娃一样。
 *
 * 请计算 最多能有多少个 信封能组成一组“俄罗斯套娃”信封（即可以把一个信封放到另一个信封里面）。
 *
 * 注意：不允许旋转信封。
 *
 *
 * 示例 1：
 *
 * 输入：envelopes = [[5,4],[6,4],[6,7],[2,3]]
 * 输出：3
 * 解释：最多信封的个数为 3, 组合为: [2,3] => [5,4] => [6,7]。
 * 示例 2：
 *
 * 输入：envelopes = [[1,1],[1,1],[1,1]]
 * 输出：1
 *
 *
 * 提示：
 *
 * 1 <= envelopes.length <= 5000
 * envelopes[i].length == 2
 * 1 <= wi, hi <= 104

 来源：力扣（LeetCode）
 链接：https://leetcode-cn.com/problems/merge-k-sorted-lists
 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class TestSolution354 {
    private static final org.slf4j.Logger logger = LoggerFactory.getLogger(TestSolution354.class);

    static class Solution {

        /**
         *
         * 执行结果：
         * 通过
         * 显示详情
         * 添加备注
         *
         * 执行用时：
         * 154 ms
         * , 在所有 Java 提交中击败了
         * 76.41%
         * 的用户
         * 内存消耗：
         * 39.5 MB
         * , 在所有 Java 提交中击败了
         * 16.59%
         * 的用户
         * 通过测试用例：
         * 84 / 84
         *
         * @param envelopes
         * @return
         */
        public int maxEnvelopes(int[][] envelopes) {
            //w递增排序,相同则按h递减
            Arrays.sort(envelopes, (x1, x2) -> {
                if (x1[0] > x2[0]) {
                    return 1;
                } else if (x1[0] == x2[0]) {
                    if (x1[1] > x2[1]) {
                        return -1;
                    } else if (x1[1] < x2[1]) {
                        return 1;
                    } else {
                        return 0;
                    }
                } else
                    return -1;
            });

            //提取h
            int length = envelopes.length;
            int[] heightArray = new int[length];
            for (int i = 0; i < envelopes.length; i++) {
                heightArray[i] = envelopes[i][1];
            }

            return lengthOfLIS(heightArray);
        }

        /**
         *
         * 最长递增子窜
         * @param nums
         * @return
         * @see #TestSolution300
         */
        public int lengthOfLIS(int[] nums) {
            int length = nums.length;
            if (length == 1)
                return 1;

            int[] dp = new int[length];
            for (int i = 0; i < length; i++) {
                int max = 0;
                for (int j = i - 1; j >= 0; j--) {
                    if (nums[j] < nums[i]) {
                        if (dp[j] > max) {
                            max = dp[j];
                        }
                    }
                }
                dp[i] = max + 1;
            }
            int asInt = Arrays.stream(dp).max().getAsInt();
            return asInt;
        }
    }

    public static void main(String[] args) {
//        logger.info("{}" ,new Solution().lengthOfLIS(new int[]{10,9,2,5,3,7,101,18}));
        logger.info("{}" ,new Solution().maxEnvelopes(new int[][]{
            {5,4},{6,4},{6,7},{2,3},{3,5},{4,4}
        }));

    }


}
