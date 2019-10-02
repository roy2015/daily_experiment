package com.roy.miscellaneous.leetcode;

import org.slf4j.LoggerFactory;

import java.util.*;

/**
 * Created by apple on 2019/10/1.
 *给定一个没有重复数字的序列，返回其所有可能的全排列。

 示例:

 输入: [1,2,3]
 输出:
 [
 [1,2,3],
 [1,3,2],
 [2,1,3],
 [2,3,1],
 [3,1,2],
 [3,2,1]
 ]

 来源：力扣（LeetCode）
 链接：https://leetcode-cn.com/problems/permutations
 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 */
public class TestSolution46 {
    private static final org.slf4j.Logger logger = LoggerFactory.getLogger(TestSolution46.class);

    /**
     */
    static class Solution {
        public List<List<Integer>> permute(int[] nums) {
            List<Integer> numsList = new ArrayList<>(nums.length);
            for (int num : nums) {
                numsList.add(num);
            }

            return subPermute(numsList, 0, nums.length);
        }

        public List<List<Integer>> subPermute(List<Integer> nums, int first, int len) {
            List<List<Integer>> retList = new ArrayList<>();
            if (first == len -1) {
                retList.add(nums);
                return retList;
            }
            for (int i = first; i < len; i++) {
                List<Integer> numsCopy = new ArrayList<>();
                numsCopy.addAll(nums);
                Integer tmp=  numsCopy.get(first);
                Integer iVal = numsCopy.get(i);
                numsCopy.set(first, iVal);
                numsCopy.set(i, tmp);
                List<List<Integer>> subPermute = subPermute(numsCopy, first +1, len);
                retList.addAll(subPermute);
            }
            return retList;
        }

    }

    public static void main(String[] args) {
        List<List<Integer>> list = new Solution().permute(new int[]{1, 2, 3,4});
        list.forEach( x-> logger.info("{}",x) );
    }

}
