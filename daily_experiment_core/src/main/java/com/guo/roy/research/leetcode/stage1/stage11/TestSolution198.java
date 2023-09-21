package com.guo.roy.research.leetcode.stage1.stage11;

import org.slf4j.LoggerFactory;

/**
 * @author guojun
 * @date 2020/5/29
 *
 *
 * 198. 打家劫舍
你是一个专业的小偷，计划偷窃沿街的房屋。每间房内都藏有一定的现金，影响你偷窃的唯一制约因素就是相邻的房屋装有相互连通的防盗系统，如果两间相邻的房屋在同一晚上被小偷闯入，系统会自动报警。

给定一个代表每个房屋存放金额的非负整数数组，计算你 不触动警报装置的情况下 ，一夜之内能够偷窃到的最高金额。

示例 1:

输入: [1,2,3,1]
输出: 4
解释: 偷窃 1 号房屋 (金额 = 1) ，然后偷窃 3 号房屋 (金额 = 3)。
偷窃到的最高金额 = 1 + 3 = 4 。
示例 2:

输入: [2,7,9,3,1]
输出: 12
解释: 偷窃 1 号房屋 (金额 = 2), 偷窃 3 号房屋 (金额 = 9)，接着偷窃 5 号房屋 (金额 = 1)。
偷窃到的最高金额 = 2 + 9 + 1 = 12 。
 *
 *
 */
public class TestSolution198 {
    private static final org.slf4j.Logger logger = LoggerFactory.getLogger(TestSolution198.class);


    /**
     *
     */
    static class Solution {
        /**
         *
         * 典型的动态规划，参考
         * https://leetcode-cn.com/problems/house-robber/solution/dong-tai-gui-hua-jie-ti-si-lu-javascript-by-liusho/
         *
         *  F(n) = Max( F(n-2) + nums[n],  F(n-1) )
         * @param nums
         * @return
         *
         * 执行结果：
        通过
        显示详情
        执行用时 :0 ms, 在所有 Java 提交中击败了100.00%的用户
        内存消耗 :37.2 MB
        , 在所有 Java 提交中击败了6.52%的用户
         *
         */
        public int rob(int[] nums) {
            int length = nums.length;
            int f1 , f2 = 0, fn = 0;
            f1 = nums[0];
            if (length == 1) {
                return nums[0];
            } else  if (length >=2) {
                f2 = Math.max(nums[0], nums[1]);
                if (length == 2) {
                    return f2;
                }
            } else {}

            //长度>2
            for (int i = 2; i < length; i++) {
                int iVal = nums[i];
                fn = Math.max(f1 + iVal, f2);
                f1 = f2;
                f2 = fn;
            }
            return fn;
        }

        public int rob20120109(int[] nums) {
            //noRob:不偷  rob:偷
            int lastNoRob = 0;
            int lastRob =0;

            int currNoRob = 0;
            int currRob =0;

            for (int num : nums) {
                currNoRob = Math.max(lastNoRob, lastRob);
                currRob = lastNoRob + num;

                lastNoRob = currNoRob;
                lastRob = currRob;
            }
            return Math.max(lastNoRob, lastRob);

        }

        public int rob20230921(int[] nums) {
            int lastRobbedNum = 0;
            int lastNoRobbedNum = 0;
            int noRobbedNum = 0;
            int robbedNum = 0;

            for (int num : nums) {
                noRobbedNum = Math.max(lastNoRobbedNum, lastRobbedNum);
                robbedNum = lastNoRobbedNum + num;
                lastNoRobbedNum = noRobbedNum;
                lastRobbedNum = robbedNum;
            }

            return Math.max(noRobbedNum, robbedNum);

        }

    }

    public static void main(String[] args) {
        logger.info("{}", new Solution().rob20230921(new int[]{2}));//2
        logger.info("{}", new Solution().rob20230921(new int[]{1,2}));//2
        logger.info("{}", new Solution().rob20230921(new int[]{2,1,1,2}));//4
        logger.info("{}", new Solution().rob20230921(new int[]{1,2,3,1}));//4
        logger.info("{}", new Solution().rob20230921(new int[]{2,7,9,3,1}));//12
    }
}
