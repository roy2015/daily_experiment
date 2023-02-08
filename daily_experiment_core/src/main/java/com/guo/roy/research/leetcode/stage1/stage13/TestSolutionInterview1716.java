package com.guo.roy.research.leetcode.stage1.stage13;

import org.slf4j.LoggerFactory;

/**
 *  @author guojun
 *  @date 2020/8/11
 *
 *  面试题 17.16. 按摩师
 *  一个有名的按摩师会收到源源不断的预约请求，每个预约都可以选择接或不接。在每次预约服务之间要有休息时间，因此她不能接受相邻的预约。给定一个预约请求序列，替按摩师找到最优的预约集合（总预约时间最长），返回总的分钟数。
 *
 *  注意：本题相对原题稍作改动
 *
 *
 *
 *  示例 1：
 *
 *  输入： [1,2,3,1]
 *  输出： 4
 *  解释： 选择 1 号预约和 3 号预约，总时长 = 1 + 3 = 4。
 *  示例 2：
 *
 *  输入： [2,7,9,3,1]
 *  输出： 12
 *  解释： 选择 1 号预约、 3 号预约和 5 号预约，总时长 = 2 + 9 + 1 = 12。
 *  示例 3：
 *
 *  输入： [2,1,4,5,3,1,1,3]
 *  输出： 12
 *  解释： 选择 1 号预约、 3 号预约、 5 号预约和 8 号预约，总时长 = 2 + 4 + 3 + 3 = 12。
 *
 *
 *
 *
 *
 */
public class TestSolutionInterview1716 {
    private static final org.slf4j.Logger logger = LoggerFactory.getLogger(TestSolutionInterview1716.class);

    static class Solution {
        /**
         *
         * dp,  比较简单， 每一个（i）至于前一个有关(j)，
         *   不选i的情况 =   Math.max(j选, j没选);
         *   选i的情况 =    j没选 + nums[i]
         *
         * @param nums
         * @return
         */
        public int massage(int[] nums) {
            int selectVal = 0;
            int noSelectVal = 0;

            for (int i = 0; i < nums.length; i++) {
                int curNoSelectVal = Math.max(selectVal, noSelectVal);
                int curSelectVal = noSelectVal + nums[i];
                noSelectVal = curNoSelectVal;
                selectVal = curSelectVal;
            }
            return Math.max(selectVal, noSelectVal);
        }
    }

    public static void main(String[] args) {
        logger.info("{}", new Solution().massage(new int[]{2,1,4,5,3,1,1,3}));//12
    }

}
