package com.guo.roy.research.leetcode.stage1.stage10;

import java.util.Arrays;
import java.util.HashMap;

import org.slf4j.LoggerFactory;

/**
 * @author guojun
 * @date 2020/4/12 20:52
 *
 * 1365. 有多少小于当前数字的数字
给你一个数组 nums，对于其中每个元素 nums[i]，请你统计数组中比它小的所有数字的数目。

换而言之，对于每个 nums[i] 你必须计算出有效的 j 的数量，其中 j 满足 j != i 且 nums[j] < nums[i] 。

以数组形式返回答案。



示例 1：

输入：nums = [8,1,2,2,3]
输出：[4,0,1,1,3]
解释：
对于 nums[0]=8 存在四个比它小的数字：（1，2，2 和 3）。
对于 nums[1]=1 不存在比它小的数字。
对于 nums[2]=2 存在一个比它小的数字：（1）。
对于 nums[3]=2 存在一个比它小的数字：（1）。
对于 nums[4]=3 存在三个比它小的数字：（1，2 和 2）。
示例 2：

输入：nums = [6,5,4,8]
输出：[2,1,0,3]
示例 3：

输入：nums = [7,7,7,7]
输出：[0,0,0,0]


提示：

2 <= nums.length <= 500
0 <= nums[i] <= 100
 */
public class TestSolution1365 {
    private static final org.slf4j.Logger logger = LoggerFactory.getLogger(TestSolution1365.class);


    static class Solution {
        /**
         * 先排序，hash存下标，原序找下标
         *
         * 执行用时 :
         * 4 ms, 在所有 Java 提交中击败了86.21%的用户
         * 内存消耗 :
         * 40.1 MB, 在所有 Java 提交中击败了100.00%的用户
         * @param nums
         * @return
         */
        public int[] smallerNumbersThanCurrent(int[] nums) {
            // 8,1,2,2,3
            // 1 2 2 3 8   O(nlogn + n +n)  vs  O(n^2)
            int[] copyOfNums = Arrays.copyOf(nums, nums.length);
            Arrays.sort(copyOfNums);
            HashMap<Integer, Integer> hashMap = new HashMap<>();
            int compareNum = copyOfNums[0];
            for (int i = 0; i < copyOfNums.length; i++) {
                if (i ==0) {
                    hashMap.put(copyOfNums[i], 0);
                } else if (copyOfNums[i] != compareNum) {
                    hashMap.put(copyOfNums[i], i);
                    compareNum = copyOfNums[i];
                } else {}
            }

            for (int i = 0; i < nums.length; i++) {
                int tmp = nums[i];
                nums[i] = hashMap.get(tmp);
            }
            return nums;

        }

        /**
         * 执行用时 :
         5 ms, 在所有 Java 提交中击败了82.17%的用户
         内存消耗 :
         39.9 MB, 在所有 Java 提交中击败了100.00%的用户
         * @param nums
         * @return
         */
        public int[] smallerNumbersThanCurrent_1(int[] nums) {
            int[] copyOfNums = Arrays.copyOf(nums, nums.length);
            Arrays.sort(copyOfNums);
            for (int i = 0; i < nums.length; i++) {
                int temp = nums[i];
                for (int j = 0; j < copyOfNums.length; j++) {
                    if (copyOfNums[j] == temp) {
                        nums[i] = j;
                        break;
                    }
                }
            }
            return nums;
        }

        public void print(int[] nums) {
            StringBuffer sb = new StringBuffer();

            for (int num : nums) {
                sb.append("  ").append(num);
            }
            logger.info(sb.toString());
        }
    }

    public static void main(String[] args) {
        int[] ints;
        ints = new Solution().smallerNumbersThanCurrent_1(new int[]{8, 1, 2, 2, 3});
        new Solution().print(ints);

        ints = new Solution().smallerNumbersThanCurrent_1(new int[]{6,5,4,8});
        new Solution().print(ints);

        ints = new Solution().smallerNumbersThanCurrent_1(new int[]{7,7,7,7});
        new Solution().print(ints);

    }
}
