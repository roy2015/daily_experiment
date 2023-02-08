package com.guo.roy.research.leetcode.stage1.stage10;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import java.util.TreeSet;

import org.slf4j.LoggerFactory;

/**
 * Created by apple on 2019/11/11.
 *给定一个整数数组，判断是否存在重复元素。

 如果任何值在数组中出现至少两次，函数返回 true。如果数组中每个元素都不相同，则返回 false。

 示例 1:

 输入: [1,2,3,1]
 输出: true
 示例 2:

 输入: [1,2,3,4]
 输出: false
 示例 3:

 输入: [1,1,1,3,3,4,3,2,4,2]
 输出: true

 来源：力扣（LeetCode）
 链接：https://leetcode-cn.com/problems/contains-duplicate
 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 */
public class TestSolution217 {
    private static final org.slf4j.Logger logger = LoggerFactory.getLogger(TestSolution217.class);

    /**
     */
    static class Solution {

        /**
         *
         * 先排序，在循环遍历
         *
         * 执行用时 :5 ms, 在所有 java 提交中击败了96.43%的用户
         内存消耗 :41.4 MB, 在所有 java 提交中击败了95.14%的用户
         *
         * @param nums
         * @return
         */
        public boolean containsDuplicate3(int[] nums) {
            if (nums == null || nums.length == 0) {
                return false;
            }
            Arrays.sort(nums);
            for (int i = 0; i < nums.length -1; i++) {
                if (nums[i] == nums[i + 1]) {
                    return true;
                }
            }
            return false;
        }

        /**
         *
         *
         * 执行用时 :13 ms, 在所有 java 提交中击败了67.37%的用户
         内存消耗 :43.5 MB, 在所有 java 提交中击败了85.30%的用户
         *
         * @param nums
         * @return
         */
        public boolean containsDuplicate(int[] nums) {
            if(nums == null || nums.length==0) {
                return false;
            }
            Set<Integer> set =  new HashSet();
            for(int i =0; i < nums.length; i++ ) {
                if (set.contains(nums[i])) {
                    return true;
                } else {
                    set.add(nums[i]);
                }
            }
            return false;
        }

        /**
         *
         * 类似于冒泡，431ms ??
         *
         *执行用时 :431 ms, 在所有 java 提交中击败了5.05%的用户
         内存消耗 :41.5 MB, 在所有 java 提交中击败了94.76%的用户
         * @param nums
         * @return
         */
        public boolean containsDuplicate1(int[] nums) {
            if(nums == null || nums.length ==0) {
                return false;
            }
            int len = nums.length;
            for (int i = 0; i < len - 1; i++) {
                for (int j = i +1 ; j < len; j++) {
                    if (nums[i] == nums[j]) {
                        return true;
                    }
                }
            }
            return false;
        }

        /**
         *
         * treeSet
         *
         * 执行用时 :26 ms, 在所有 java 提交中击败了28.73%的用户
         内存消耗 :44.2 MB, 在所有 java 提交中击败了83.57%的用户
         *
         * @param nums
         * @return
         */
        public boolean containsDuplicate2(int[] nums) {
            if (nums == null || nums.length == 0) {
                return false;
            }

            TreeSet<Integer> treeSet = new TreeSet<>();
            for (int i = 0; i < nums.length; i++) {
                if (treeSet.contains(nums[i])) {
                    return true;
                } else {
                    treeSet.add(nums[i]);
                }
            }
            return false;
        }


    }

    public static void main(String[] args) {
        logger.info("{}", new Solution().containsDuplicate3(new int[]{
                2,7,11,15,15}));
    }

}
