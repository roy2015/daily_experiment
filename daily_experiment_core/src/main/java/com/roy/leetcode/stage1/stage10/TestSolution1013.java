package com.roy.leetcode.stage1.stage10;

import org.slf4j.LoggerFactory;

/**
 * Created by apple on 2019/10/17.
 * <p>
 * 给定一个整数数组 A，只有我们可以将其划分为三个和相等的非空部分时才返回 true，否则返回 false。
 * <p>
 * 形式上，如果我们可以找出索引 i+1 < j 且满足 (A[0] + A[1] + ... + A[i] == A[i+1] + A[i+2] + ... + A[j-1] == A[j] + A[j-1] + ... + A[A.length - 1]) 就可以将数组三等分。
 * <p>
 *  
 * <p>
 * 示例 1：
 * <p>
 * 输出：[0,2,1,-6,6,-7,9,1,2,0,1]
 * 输出：true
 * 解释：0 + 2 + 1 = -6 + 6 - 7 + 9 + 1 = 2 + 0 + 1
 * 示例 2：
 * <p>
 * 输入：[0,2,1,-6,6,7,9,-1,2,0,1]
 * 输出：false
 * 示例 3：
 * <p>
 * 输入：[3,3,6,5,-2,2,5,1,-9,4]
 * 输出：true
 * 解释：3 + 3 = 6 = 5 - 2 + 2 + 5 + 1 - 9 + 4
 *  
 * <p>
 * 提示：
 * <p>
 * 3 <= A.length <= 50000
 * -10000 <= A[i] <= 10000
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/partition-array-into-three-parts-with-equal-sum
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class TestSolution1013 {
    private static final org.slf4j.Logger logger = LoggerFactory.getLogger(TestSolution1013.class);

    /**
     *
     * 执行用时 :2 ms, 在所有 java 提交中击败了99.41%的用户
     * 内存消耗 :50.4 MB, 在所有 java 提交中击败了94.03%的用户
     *
     * i < A.length-2
     * j < A.length-1
     */
    static class Solution {
        public boolean canThreePartsEqualSum(int[] A) {
            if (A == null || A.length < 3) {
                return false;
            }
            int sum = 0, cnt = 0;
            for (int i = 0; i < A.length; i++) {
                sum += A[i];
            }
            if (sum % 3 != 0) {
                return false;
            }
            cnt = sum / 3;
            sum = 0;
            for (int i = 0; i < A.length - 2; i++) {
                sum += A[i];
                if (sum == cnt) {
                    sum = 0;
                    for (int j = i + 1; j < A.length - 1; j++) {
                        sum += A[j];
                        if (sum == cnt) {
                            return true;
                        }
                    }
                    return false;
                }
            }
            return false;
        }
    }

    public static void main(String[] args) {
        logger.info("{}", new Solution().canThreePartsEqualSum(new int[]{3,3,6,5,-2,2,5,1,-9,4}));
    }

}
