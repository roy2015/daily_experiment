package com.roy.miscellaneous.leetcode.stage1;

import org.slf4j.LoggerFactory;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by apple on 2019/11/13.
 *如果数组是单调递增或单调递减的，那么它是单调的。

 如果对于所有 i <= j，A[i] <= A[j]，那么数组 A 是单调递增的。 如果对于所有 i <= j，A[i]> = A[j]，那么数组 A 是单调递减的。

 当给定的数组 A 是单调数组时返回 true，否则返回 false。

  

 示例 1：

 输入：[1,2,2,3]
 输出：true
 示例 2：

 输入：[6,5,4,4]
 输出：true
 示例 3：

 输入：[1,3,2]
 输出：false
 示例 4：

 输入：[1,2,4,5]
 输出：true
 示例 5：

 输入：[1,1,1]
 输出：true
  

 提示：

 1 <= A.length <= 50000
 -100000 <= A[i] <= 100000

 来源：力扣（LeetCode）
 链接：https://leetcode-cn.com/problems/monotonic-array
 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 */
public class TestSolution896 {
    private static final org.slf4j.Logger logger = LoggerFactory.getLogger(TestSolution896.class);

    /**
     */
    static class Solution {
        /**
         * 步骤：
         * 1. 找第一个折线下标
         * 2. 判断是否递增递减
         *
         * 执行用时 :2 ms, 在所有 java 提交中击败了99.00%的用户
         内存消耗 :49.7 MB, 在所有 java 提交中击败了92.58%的用户
         *
         * @param A
         * @return
         */
        public boolean isMonotonic(int[] A) {
            if (A == null || A.length ==1 || A.length == 0) {
                return true;
            }
            int i = 0, len = A.length;
            for (; i < len -1; i++) {
                if (A[i] != A[i + 1]) {
                    break;
                }
            }
            //全部相等
            if (i == len - 1) {
                return true;
            }

            int p = i;
            boolean increased = false;
            if (A[p + 1] > A[p]) {
                increased = true;
            }

            for (i = p + 1; i < len -1; i++) {
                if (increased && A[i + 1] < A[i]) {
                    return false;
                }
                if (!increased && A[i + 1] > A[i]) {
                    return false;
                }
            }
            return true;
        }
    }

    public static void main(String[] args) {
        logger.info("{}", new Solution().isMonotonic(new int[]{
                2,2,2,2
        }));
    }

}
