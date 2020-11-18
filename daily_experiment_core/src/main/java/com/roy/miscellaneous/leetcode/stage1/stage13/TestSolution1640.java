package com.roy.miscellaneous.leetcode.stage1.stage13;

import org.slf4j.LoggerFactory;

/**
 * @author guojun
 * @date 2020/11/18
 *
 *
 * 1640. 能否连接形成数组
 * 给你一个整数数组 arr ，数组中的每个整数 互不相同 。另有一个由整数数组构成的数组 pieces，其中的整数也 互不相同 。请你以 任意顺序 连接 pieces 中的数组以形成 arr 。但是，不允许 对每个数组 pieces[i] 中的整数重新排序。
 *
 * 如果可以连接 pieces 中的数组形成 arr ，返回 true ；否则，返回 false 。
 *
 *
 *
 * 示例 1：
 *
 * 输入：arr = [85], pieces = [[85]]
 * 输出：true
 * 示例 2：
 *
 * 输入：arr = [15,88], pieces = [[88],[15]]
 * 输出：true
 * 解释：依次连接 [15] 和 [88]
 * 示例 3：
 *
 * 输入：arr = [49,18,16], pieces = [[16,18,49]]
 * 输出：false
 * 解释：即便数字相符，也不能重新排列 pieces[0]
 * 示例 4：
 *
 * 输入：arr = [91,4,64,78], pieces = [[78],[4,64],[91]]
 * 输出：true
 * 解释：依次连接 [91]、[4,64] 和 [78]
 * 示例 5：
 *
 * 输入：arr = [1,3,5,7], pieces = [[2,4,6,8]]
 * 输出：false
 *
 *
 * 提示：
 *
 * 1 <= pieces.length <= arr.length <= 100
 * sum(pieces[i].length) == arr.length
 * 1 <= pieces[i].length <= arr.length
 * 1 <= arr[i], pieces[i][j] <= 100
 * arr 中的整数 互不相同
 * pieces 中的整数 互不相同（也就是说，如果将 pieces 扁平化成一维数组，数组中的所有整数互不相同）
 *
 *
 */
public class TestSolution1640 {
    private static final org.slf4j.Logger logger = LoggerFactory.getLogger(TestSolution1640.class);


    static class Solution {

        /**
         *
         * 思路比较重要  计算每一段的存在且相邻
         *
         * 执行结果：
         * 通过
         * 显示详情
         * 执行用时：0 ms, 在所有 Java 提交中击败了100.00%的用户
         * 内存消耗：38 MB, 在所有 Java 提交中击败了13.44%的用户
         *
         * @param arr
         * @param pieces
         * @return
         */
        public boolean canFormArray(int[] arr, int[][] pieces) {
            int[] dic = new int[101];
            for (int i = 0; i < arr.length; i++) {
                dic[arr[i]] = i + 1;
            }
            int row = pieces.length;
            for (int i = 0; i < row; i++) {
                int[] piece = pieces[i];
                for (int j = 0; j < piece.length  ; j++) {
                    int jVal = piece[j];
                    if (j == piece.length -1) {
                        if (dic[jVal] == 0) {
                            return false;
                        }
                    } else {
                        int jPostVal = piece[j + 1];
                        if (dic[jPostVal] == 0 || dic[jVal] == 0 || dic[jPostVal] - 1 != dic[jVal]) {
                            return false;
                        }
                    }
                }
            }
            return true;
        }
    }

    public static void main(String[] args) {
        logger.info("{}", new Solution().canFormArray(new int[]{12}, new int[][]{
                {1}
        }));//false

        logger.info("{}", new Solution().canFormArray(new int[]{37,69,3,74,46}, new int[][]{
                {37,69,3,74,46}
        }));//true

        logger.info("{}", new Solution().canFormArray(new int[]{91,4,64,78}, new int[][]{
                {78},{4,64},{91}
        }));//true

        logger.info("{}", new Solution().canFormArray(
                new int[]{49,18,16},
                new int[][]{
                {16,18,49}
        }));//false

        logger.info("{}", new Solution().canFormArray(
                new int[]{1,3,5,7},
                new int[][]{
                        {2,4,6,8}
        }));//false
    }
}
