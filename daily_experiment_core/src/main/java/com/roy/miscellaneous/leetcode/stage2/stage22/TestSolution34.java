package com.roy.miscellaneous.leetcode.stage2.stage22;

import org.slf4j.LoggerFactory;

/**
 * @author guojun
 * @date 2020/7/11
 */
public class TestSolution34 {
    private static final org.slf4j.Logger logger = LoggerFactory.getLogger(TestSolution34.class);


    static class Solution {

        /**
         *
         * 感觉自己写的有点繁琐，还能100%？
         *
         * 执行结果：
         * 通过
         * 显示详情
         * 执行用时：
         * 0 ms, 在所有 Java 提交中击败了100.00%的用户
         * 内存消耗：
         * 42.8 MB, 在所有 Java 提交中击败了63.16%的用户
         *
         * @param nums
         * @param target
         * @return
         */
        public int[] searchRange(int[] nums, int target) {
            int low = 0;
            int len = nums.length;
            int high = len -1;
            int idx = -1;
            int[] ret = new int[2];

            while (low <= high) {
                int mid = (low + high) >>> 1;
                int midVal = nums[mid];
                if (target > midVal ) {
                    low = mid +1;
                } else if (target == midVal) {
                    idx = mid;
                    break;
                } else {
                    high = mid - 1;
                }
            }
            if (idx == -1 ) {
                ret[0] = -1;
                ret[1] = -1;
                return ret;
            }

            boolean leastFlag = false;
            boolean mostFlag = false;
            int least;
            int most;
            least = most = idx;
            int start = idx;
            int i = 1;
            while (!leastFlag || !mostFlag) {
                if ( !leastFlag) {
                    if (start -i >= 0) {
                        if (nums[start -i] < target) {
                            leastFlag = true;
                            least = start - i +1;
                        }
                    } else {
                        leastFlag = true;
                        least = 0;
                    }
                }

                if ( !mostFlag) {
                    if (start + i <len) {
                        if (nums[start +i] > target) {
                            mostFlag = true;
                            most = start +i -1;
                        }
                    } else {
                        mostFlag = true;
                        most = len - 1;
                    }
                }
                i ++;
            }
            ret[0] = least;
            ret[1] = most;

            return ret;
        }
    }

    public static void main(String[] args) {
        logger.info("{}", new Solution().searchRange(
                new int[]{8}, 8
        ));

        logger.info("{}", new Solution().searchRange(
                new int[]{8,8}, 8
        ));

        logger.info("{}", new Solution().searchRange(
                new int[]{5,7,7,8,8,10}, 8
        ));

    }
}
