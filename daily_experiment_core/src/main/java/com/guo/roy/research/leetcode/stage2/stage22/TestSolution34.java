package com.guo.roy.research.leetcode.stage2.stage22;

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

        /**
         *
         *
         * 三个二分查找，随便把二分查找最左边相等的和最左边相等的元素的方法拎出来了
         * 执行结果：
         * 通过
         * 显示详情
         * 执行用时：0 ms, 在所有 Java 提交中击败了100.00%的用户
         * 内存消耗：43 MB, 42.9 MB, 在所有 Java 提交中击败了63.16%的用户
         *
         * @param nums
         * @param target
         * @return
         */
        public int[] searchRange1(int[] nums, int target) {
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

            ret[0] = searchRangeFirst(nums, idx, target);
            ret[1] = searchRangeLast(nums, idx, target);
            return ret;
        }

        /**
         *
         * 原生的二分查找（不管targe的出现的次数随机返回）
         *
         * @param nums
         * @param target
         * @return
         */
        public int searchRangeOnly(int[] nums, int target) {
            int low = 0;
            int len = nums.length;
            int high = len -1;

            while (low <= high) {
                int mid = (low + high) >>> 1;
                int midVal = nums[mid];
                if (target > midVal ) {
                    low = mid +1;
                } else if (target == midVal) {
                    return  mid;
                } else {
                    high = mid - 1;
                }
            }
            return -1;
        }


        /**
         * 二分查找第一次(左边)出现的位置(多个相等的情况下)
         * @param nums
         * @param idx 二分查找时候的第一个
         * @param target
         * @return
         */
        public int searchRangeFirst(int[] nums, int idx,int target) {
            int low = 0;
            int high = idx;

            while (low < high) {
                int mid = (low + high) /2;
                int midVal = nums[mid];
                if ( target > midVal) {
                    low = mid + 1;
                } else if (target == midVal) {
                    high = mid;
                }
            }
            //low == high
            return low;
        }


        /**
         *
         * 二分查找最后一次(右边)出现的位置(多个相等的情况下)
         *
         * @param nums
         * @param idx
         * @param target
         * @return
         */
        public int searchRangeLast(int[] nums, int idx,int target) {
            int low = idx;
            int high = nums.length -1;

            while (low < high) {
                int mid = (low + high) / 2;
                int midVal = nums[mid];
                if (target > midVal) {
                    low = mid + 1;
                } else if (target == midVal) {
                    if (mid +1 == high) {
                        if (nums[high] == target) {
                            return high;
                        } else {
                            return mid;
                        }
                    }
                    low = mid;
                } else {
                    high = mid - 1;
                }
            }
            return low;
        }

    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] ints = {5, 7, 8, 8, 8, 8};
        int idx = solution.searchRangeOnly(
                ints, 8);
        logger.info("{}", idx);
        logger.info("left:{}", solution.searchRangeFirst(ints, idx, 8));
        logger.info("right:{}", solution.searchRangeLast(ints, idx, 8));
        logger.info("===============测试结束====================================");

        logger.info("{}", new Solution().searchRange1(
                new int[]{8}, 8
        ));// 0 0

        logger.info("{}", new Solution().searchRange1(
                new int[]{8,8}, 8
        ));// 0 1

        logger.info("{}", new Solution().searchRange1(
                new int[]{5,7,7,8,8,10}, 8
        )); // 3 4

    }
}
