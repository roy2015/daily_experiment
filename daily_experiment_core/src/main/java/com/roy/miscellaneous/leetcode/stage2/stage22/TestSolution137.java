package com.roy.miscellaneous.leetcode.stage2.stage22;

import org.slf4j.LoggerFactory;

/**
 * @author guojun
 * @date 2020/6/11
 */
public class TestSolution137 {
    private static final org.slf4j.Logger logger = LoggerFactory.getLogger(TestSolution137.class);


    static class Solution {

        /**
         *
         * 借鉴了一点点思路
         * 思路：
         *  1. 分析每一位，统计0，1的次数， 应该都是3（当然可以推广到任意K）的倍数，不是3的倍数的就是要找的数的当前位，
         *     只用管出现1的次数不是K的倍数即可，因为0对于求和无意义
         *  2. 累加（按基数）分析出的每一位
         *  3. 注意负数
         *
         *执行结果：
         * 通过
         * 显示详情
         * 执行用时：4 ms, 在所有 Java 提交中击败了43.63%的用户
         * 内存消耗：39.8 MB, 在所有 Java 提交中击败了16.19%的用户
         *
         * @param nums
         * @return
         */
        public int singleNumber(int[] nums) {
            int k = 3;
            int ret = 0;
            //总共移动32位,考虑到负数，一位都不能少。。。
            for (int i = 0; i < 32 ; i++) {
                int oneCnt = 0;
                for (int num : nums) {
                    //ys:余数
                    int ys = (num >> i) & 0x1;
                    if (ys == 1) {
                        oneCnt ++;
                    }
                }
                if (oneCnt % k != 0) {
                    ret += (1 << i);
                }
            }
            return ret;
        }

    }

    public static void main(String[] args) {

        logger.info("{}", new Solution().singleNumber(new int[]{-2,-2,1,1,-3,1,-3,-3,-4,-2}));
        logger.info("{}", new Solution().singleNumber(new int[]{2,2,3,2}));
        logger.info("{}", new Solution().singleNumber(new int[]{0,1,0,1,0,1,99}));
    }
}
