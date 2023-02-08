package com.guo.roy.research.leetcode.stage1.stage10;

import org.slf4j.LoggerFactory;

/**
 * Created by apple on 2019/9/22.
 *给你一个整数数组 nums，请你返回其中位数为 偶数 的数字的个数。

  

 示例 1：

 输入：nums = [12,345,2,6,7896]
 输出：2
 解释：
 12 是 2 位数字（位数为偶数） 
 345 是 3 位数字（位数为奇数）  
 2 是 1 位数字（位数为奇数） 
 6 是 1 位数字 位数为奇数） 
 7896 是 4 位数字（位数为偶数）  
 因此只有 12 和 7896 是位数为偶数的数字
 示例 2：

 输入：nums = [555,901,482,1771]
 输出：1
 解释：
 只有 1771 是位数为偶数的数字。
  

 提示：

 1 <= nums.length <= 500
 1 <= nums[i] <= 10^5

 来源：力扣（LeetCode）
 链接：https://leetcode-cn.com/problems/find-numbers-with-even-number-of-digits
 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 */
public class TestSolution1295 {
    private static final org.slf4j.Logger logger = LoggerFactory.getLogger(TestSolution1295.class);

    /**
     * 执行用时 :1 ms, 在所有 Java 提交中击败了99.85%的用户
     * 内存消耗 :39.8 MB, 在所有 Java 提交中击败了5.13%的用户
     *
     */
    static class Solution {
        public int findNumbers(int[] nums) {
            int cnt =0;
            int len = nums.length;
            for(int i=0; i< len ;i++) {
                if (checkNum(nums[i])) {
                    cnt ++;
                }
            }
            return cnt;
        }

        /**
         * 判断每个数字的可用性
         * @param n
         * @return
         */
        private boolean checkNum(int n) {
            boolean rest = true;
            do{
                n = n /10;
                rest =  !rest;
            }while(n != 0);
            return rest;
        }
    }

    public static void main(String[] args) {
        logger.info("{}", new Solution().findNumbers(new int[]{12,345,2,6,7896}));
    }

}
