package com.guo.roy.research.leetcode.stage1.stage10;

import org.slf4j.LoggerFactory;

/**
 * Created by apple on 2019/11/8
 *给定一个非负整数数组 A，返回一个数组，在该数组中， A 的所有偶数元素之后跟着所有奇数元素。

 你可以返回满足此条件的任何数组作为答案。

  

 示例：

 输入：[3,1,2,4]
 输出：[2,4,3,1]
 输出 [4,2,3,1]，[2,4,1,3] 和 [4,2,1,3] 也会被接受。
  

 提示：

 1 <= A.length <= 5000
 0 <= A[i] <= 5000

 来源：力扣（LeetCode）
 链接：https://leetcode-cn.com/problems/sort-array-by-parity
 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 */
public class TestSolution905 {
    private static final org.slf4j.Logger logger = LoggerFactory.getLogger(TestSolution905.class);

    /**
     */
    static class Solution {

        /**
         *
         * 双指针，首尾各一个
         *
         * 执行用时 :1 ms, 在所有 java 提交中击败了100.00%的用户
         内存消耗 :40.8 MB, 在所有 java 提交中击败了86.72%的用户
         *
         * @param A
         * @return
         */
        public int[] sortArrayByParity(int[] A) {
            int[] ret = new int[A.length];
            int o = 0, j= A.length-1 ;

            for (int i =0; i< A.length; i++) {
                if ((A[i] & 1) == 0) {
                    ret[o++] = A[i];
                } else{
                    ret[j--] = A[i];
                }

            }
            return ret;
        }
    }

    public static void main(String[] args) {
        int[] ints = new Solution().sortArrayByParity(new int[]{
                3,1,2,4
        });
        logger.info("{}");
    }

}
