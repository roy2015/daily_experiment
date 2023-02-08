package com.roy.leetcode.stage1.stage10;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

import org.slf4j.LoggerFactory;

/**
 * Created by apple on 2019/10/28.
 *给定一个整数数组和一个整数 k, 你需要在数组里找到不同的 k-diff 数对。这里将 k-diff 数对定义为一个整数对 (i, j), 其中 i 和 j 都是数组中的数字，且两数之差的绝对值是 k.

 示例 1:

 输入: [3, 1, 4, 1, 5], k = 2
 输出: 2
 解释: 数组中有两个 2-diff 数对, (1, 3) 和 (3, 5)。
 尽管数组中有两个1，但我们只应返回不同的数对的数量。
 示例 2:

 输入:[1, 2, 3, 4, 5], k = 1
 输出: 4
 解释: 数组中有四个 1-diff 数对, (1, 2), (2, 3), (3, 4) 和 (4, 5)。
 示例 3:

 输入: [1, 3, 1, 5, 4], k = 0
 输出: 1
 解释: 数组中只有一个 0-diff 数对，(1, 1)。
 注意:

 数对 (i, j) 和数对 (j, i) 被算作同一数对。
 数组的长度不超过10,000。
 所有输入的整数的范围在 [-1e7, 1e7]。

 来源：力扣（LeetCode）
 链接：https://leetcode-cn.com/problems/k-diff-pairs-in-an-array
 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 */
public class TestSolution532 {
    private static final org.slf4j.Logger logger = LoggerFactory.getLogger(TestSolution532.class);

    /**
     *
     *
     *
     */
    static class Solution {

        /**
         *
         * 执行用时 :304 ms, 在所有 java 提交中击败了11.25%的用户
         内存消耗 :39.2 MB, 在所有 java 提交中击败了93.86%的用户
         *
         * @param nums
         * @param k
         * @return
         */
        public int findPairs(int[] nums, int k) {
            if (k < 0 || nums == null || nums.length < 2) {//长度小于2的也不考虑
                return 0;
            }
            Arrays.sort(nums);
            int len = nums.length;
            if ( k > Math.abs(nums[0] - nums[len -1]) ) {
                return 0;
            }

            /*if ( k < Math.abs(nums[0] - nums[1]) ) {
                return 0;
            }*/

            Map<Integer, Integer> map = new HashMap<>();
            for (int i = 0; i < nums.length ; i++) {
                int index = Arrays.binarySearch(nums, nums[i] + k);
                if (index >= len || index < 0) {
                    continue;
                }
                if (index != i  )  {
                    if (k != 0) {
                        if (!map.containsKey(nums[i]) &&
                                (!map.containsValue(nums[i]) || !map.containsKey(nums[i]+k) ) ) {
                            map.put(nums[i], nums[i] +k);
                        }
                    } else {
                        if (!map.containsKey(nums[i])) {
                            map.put(nums[i], nums[i]);
                        }
                    }
                }
            }
            return map.size();
        }

        /**
         * 执行用时 :472 ms, 在所有 java 提交中击败了8.56%的用户
         内存消耗 :38.7 MB, 在所有 java 提交中击败了94.95%的用户
         * @param nums
         * @param k
         * @return
         */
        public int findPairs1(int[] nums, int k) {
            if (k < 0 || nums == null || nums.length < 2) {//长度小于2的也不考虑
                return 0;
            }
            Arrays.sort(nums);
            int len = nums.length;
            if (k > Math.abs(nums[0] - nums[len - 1])) {
                return 0;
            }

            Map<Integer, Integer> map = new HashMap<>();
            for (int i = 0; i < nums.length -1; i++) {
                for (int j = i +1; j < nums.length; j++) {
                    if (Math.abs(nums[i] - nums[j]) == k) {
                        if (k != 0) {
                            if (!map.containsKey(nums[i]) &&
                                    (!map.containsValue(nums[i]) || !map.containsKey(nums[j]) ) ) {
                                map.put(nums[i], nums[j]);
                            }
                        } else {
                            if (!map.containsKey(nums[i])) {
                                map.put(nums[i], nums[i]);
                            }
                        }
                        continue;
                    }
                }

            }
            return  map.size();
        }

        /**
         * 执行用时 :335 ms, 在所有 java 提交中击败了10.77%的用户
         内存消耗 :39.4 MB, 在所有 java 提交中击败了93.14%的用户
         * @param nums
         * @param k
         * @return
         */
        public int findPairs2(int[] nums, int k) {
            if (k < 0 || nums == null || nums.length < 2) {//长度小于2的也不考虑
                return 0;
            }

            Arrays.sort(nums);
            int len = nums.length;
            if (k > Math.abs(nums[0] - nums[len - 1])) {
                return 0;
            }

            Map<Integer, Integer> map = new HashMap<>();
            int ret = 0;
            if (k == 0) {
                for (int num : nums) {
                    if (map.containsKey(num) && map.get(num).equals(1)) {
                        map.put(num, 2);
                        ret += 1;
                    } else if (!map.containsKey(num)) {
                        map.put(num, 1);
                    }
                }
                return ret;
            }

            //k != 0的情况

            for (int i = 0; i < len - 1; i++) {
                int target = nums[i] + k;
                int j = i + 1;
                while (j < len && nums[j] < target) {
                    j++;
                }
                if ( j == len || nums[j] > target) {
                    continue;
                } else {
                    if (!map.containsKey(nums[i]) &&
                            (!map.containsValue(nums[i]) || !map.containsKey(nums[j]))) {
                        map.put(nums[i], nums[j]);
                    }
                }
            }
            return map.size();
        }

        /**
         * 参考官方的算法，很神奇，不好想
         *
         *
         * 执行用时 :14 ms, 在所有 java 提交中击败了86.69%的用户
         内存消耗 :39.7 MB, 在所有 java 提交中击败了92.78%的用户
         * @param nums
         * @param k
         * @return
         */
        public int findPairs3(int[] nums, int k) {
            if (k < 0 || nums == null || nums.length < 2) {//长度小于2的也不考虑
                return 0;
            }
            HashSet<Integer> usedSet = new HashSet<>();
            HashSet<Integer> retSet = new HashSet<>();
            for (int num : nums) {
                if (usedSet.contains(num + k)) {
                    retSet.add(num);
                }
                if (usedSet.contains(num - k)) {
                    retSet.add(num - k);
                }
                usedSet.add(num);
            }
            return retSet.size();
        }
    }

    public static void main(String[] args) {
        logger.info("{}", new Solution().findPairs3(new int[]{1,1,1,2,1} , 1));
    }

}
