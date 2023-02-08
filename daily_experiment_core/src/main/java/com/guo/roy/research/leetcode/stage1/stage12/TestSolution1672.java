package com.guo.roy.research.leetcode.stage1.stage12;

import org.slf4j.LoggerFactory;

/**
 * @author guojun
 * @date 2020/12/02
 *
 *
 * 1672. 最富有客户的资产总量
 * 给你一个 m x n 的整数网格 accounts ，其中 accounts[i][j] 是第 i​​​​​​​​​​​​ 位客户在第 j 家银行托管的资产数量。返回最富有客户所拥有的 资产总量 。
 *
 * 客户的 资产总量 就是他们在各家银行托管的资产数量之和。最富有客户就是 资产总量 最大的客户。
 *
 *
 *
 * 示例 1：
 *
 * 输入：accounts = [[1,2,3],[3,2,1]]
 * 输出：6
 * 解释：
 * 第 1 位客户的资产总量 = 1 + 2 + 3 = 6
 * 第 2 位客户的资产总量 = 3 + 2 + 1 = 6
 * 两位客户都是最富有的，资产总量都是 6 ，所以返回 6 。
 * 示例 2：
 *
 * 输入：accounts = [[1,5],[7,3],[3,5]]
 * 输出：10
 * 解释：
 * 第 1 位客户的资产总量 = 6
 * 第 2 位客户的资产总量 = 10
 * 第 3 位客户的资产总量 = 8
 * 第 2 位客户是最富有的，资产总量是 10
 * 示例 3：
 *
 * 输入：accounts = [[2,8,7],[7,1,3],[1,9,5]]
 * 输出：17
 *
 *
 * 提示：
 *
 * m == accounts.length
 * n == accounts[i].length
 * 1 <= m, n <= 50
 * 1 <= accounts[i][j] <= 100
 *
 *
 */
public class TestSolution1672 {
    private static final org.slf4j.Logger logger = LoggerFactory.getLogger(TestSolution1672.class);


    static class Solution {
        /**
         *
         * O(n^2)都能100%？
         *
         * 执行结果：
         * 通过
         * 显示详情
         * 执行用时：0 ms, 在所有 Java 提交中击败了100.00%的用户
         * 内存消耗：38.4 MB, 在所有 Java 提交中击败了15.60%的用户
         *
         *
         * @param accounts
         * @return
         */
        public int maximumWealth(int[][] accounts) {
            int row = accounts.length;
            int col = accounts[0].length;
            int retMax = 0;
            int rowMax = 0;
            for (int i = 0; i < row; i++) {
                rowMax = 0;
                for (int j = 0; j < col; j++) {
                    rowMax += accounts[i][j];
                }
                if (rowMax > retMax) {
                    retMax = rowMax;
                }
            }
            return retMax;

            /*for (int[] account : accounts) {
                rowMax = Arrays.stream(account).reduce( 0, (a,b) -> a + b );
                if (rowMax > retMax) {
                    retMax = rowMax;
                }
            }
            return retMax;*/

        }
    }

    public static void main(String[] args) {
        logger.info("{}", new Solution().maximumWealth(new int[][]{
                {2,8,7},{7,1,3},{1,9,5}
        }));//17
    }
}
