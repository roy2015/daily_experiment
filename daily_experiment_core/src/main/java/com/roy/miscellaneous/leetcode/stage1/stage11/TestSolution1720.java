package com.roy.miscellaneous.leetcode.stage1.stage11;

import org.slf4j.LoggerFactory;

/**
 * @author guojun
 * @date 2021/4/7
 *
 * 1720. 解码异或后的数组
 * 未知 整数数组 arr 由 n 个非负整数组成。
 *
 * 经编码后变为长度为 n - 1 的另一个整数数组 encoded ，其中 encoded[i] = arr[i] XOR arr[i + 1] 。例如，arr = [1,0,2,1] 经编码后得到 encoded = [1,2,3] 。
 *
 * 给你编码后的数组 encoded 和原数组 arr 的第一个元素 first（arr[0]）。
 *
 * 请解码返回原数组 arr 。可以证明答案存在并且是唯一的。
 *
 *
 *
 * 示例 1：
 *
 * 输入：encoded = [1,2,3], first = 1
 * 输出：[1,0,2,1]
 * 解释：若 arr = [1,0,2,1] ，那么 first = 1 且 encoded = [1 XOR 0, 0 XOR 2, 2 XOR 1] = [1,2,3]
 * 示例 2：
 *
 * 输入：encoded = [6,2,7,3], first = 4
 * 输出：[4,2,0,7,4]
 *
 *
 * 提示：
 *
 * 2 <= n <= 104
 * encoded.length == n - 1
 * 0 <= encoded[i] <= 105
 * 0 <= first <= 105
 *
 *
 */
public class TestSolution1720 {
    private static final org.slf4j.Logger logger = LoggerFactory.getLogger(TestSolution1720.class);


    static class Solution {

        /**
         * 定理：  x xor y = z => z ^ y = x
         *
         * 执行结果：通过
         * 显示详情
         * 执行用时：1 ms, 在所有 Java 提交中击败了100.00%的用户
         * 内存消耗：39.4 MB, 在所有 Java 提交中击败了50.92%的用户
         *
         * @param encoded
         * @param first
         * @return
         */
        public int[] decode(int[] encoded, int first) {
            int encodedLen = encoded.length ;
            int[] srcArray = new int[encodedLen + 1];
            srcArray[0] = first;
            for (int i = 0; i < encodedLen; i++) {
                srcArray[i + 1] = srcArray[i] ^ encoded[i];
            }
            return srcArray;
        }
    }

    public static void main(String[] args) {
        logger.info("{}", new Solution().decode(new int[]{6,2,7,3}, 4));//4,2,0,7,4
        logger.info("{}", new Solution().decode(new int[]{1,2,3}, 1));//1,0,2,1

    }
}
