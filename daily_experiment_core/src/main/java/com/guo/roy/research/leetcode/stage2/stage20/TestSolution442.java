package com.guo.roy.research.leetcode.stage2.stage20;

import org.slf4j.LoggerFactory;

import java.util.ArrayList;
import java.util.List;

/**
 * 442. 数组中重复的数据
 给定一个整数数组 a，其中1 ≤ a[i] ≤ n （n为数组长度）, 其中有些元素出现两次而其他元素出现一次。

 找到所有出现两次的元素。

 你可以不用到任何额外空间并在O(n)时间复杂度内解决这个问题吗？

 示例：

 输入:
 [4,3,2,7,8,2,3,1]

 输出:
 [2,3]
 *
 * @author guojun
 * @date 2021/10/31 21:49
 */
public class TestSolution442 {
    private static final org.slf4j.Logger logger = LoggerFactory.getLogger(TestSolution442.class);


    static class Solution {

        /**
         * 加模，取模，充分利用最多出现两次，大于模的就是两次的，ok.
         *
         * 执行结果：通过
         * 执行用时：5 ms, 在所有 Java 提交中击败了71.29%的用户
         * 内存消耗：47.4 MB, 在所有 Java 提交中击败了30.95%的用户
         * @param nums
         * @return
         */
        public List<Integer> findDuplicates(int[] nums) {
            int length = nums.length;
            List<Integer> retList = new ArrayList<>();
            if (length == 1) {
                return retList;
            }
            for (int i = 0; i < length; i++) {
                int iVal = (nums[i] -1) % length;
                if ((nums[iVal] - 1) >= length) {
                    retList.add(iVal + 1);
                } else {}
                nums[iVal] += length;
            }
            return retList;
        }
    }

    public static void main(String[] args) {
        logger.info("{}", new Solution().findDuplicates(new int[]{2,2}));//2
        logger.info("{}", new Solution().findDuplicates(new int[]{4,3,2,7,8,2,3,1}));//2,3
    }
}
