package com.roy.miscellaneous.leetcode.stage1.stage11;

import org.slf4j.LoggerFactory;

import java.util.BitSet;

/**
 * @author guojun
 * @date 2020/5/12 19:25
 *
 * 1337. 方阵中战斗力最弱的 K 行
给你一个大小为 m * n 的方阵 mat，方阵由若干军人和平民组成，分别用 1 和 0 表示。

请你返回方阵中战斗力最弱的 k 行的索引，按从最弱到最强排序。

如果第 i 行的军人数量少于第 j 行，或者两行军人数量相同但 i 小于 j，那么我们认为第 i 行的战斗力比第 j 行弱。

军人 总是 排在一行中的靠前位置，也就是说 1 总是出现在 0 之前。



示例 1：

输入：mat =
[[1,1,0,0,0],
[1,1,1,1,0],
[1,0,0,0,0],
[1,1,0,0,0],
[1,1,1,1,1]],
k = 3
输出：[2,0,3]
解释：
每行中的军人数目：
行 0 -> 2
行 1 -> 4
行 2 -> 1
行 3 -> 2
行 4 -> 5
从最弱到最强对这些行排序后得到 [2,0,3,1,4]
示例 2：

输入：mat =
[[1,0,0,0],
[1,1,1,1],
[1,0,0,0],
[1,0,0,0]],
k = 2
输出：[0,2]
解释：
每行中的军人数目：
行 0 -> 1
行 1 -> 4
行 2 -> 1
行 3 -> 1
从最弱到最强对这些行排序后得到 [0,2,3,1]
 */
public class TestSolution1337 {
    private static final org.slf4j.Logger logger = LoggerFactory.getLogger(TestSolution1337.class);


    static class Solution {

        /**
         *
         * 一列一列的遍历，遇到0就加入弱战斗力的list, 最后处理1
         * 过滤器演变 arrayList -> bitset, 9ms -> 5ms -> 2ms
         * bitset完胜 list
         *
         * 执行结果：通过显示详情
         * 执行用时 :2 ms, 在所有 Java 提交中击败了88.32%的用户
         * 内存消耗 :41.2 MB, 在所有 Java 提交中击败了100.00%的用户
         *
         * @param mat
         * @param k
         * @return
         */
        public int[] kWeakestRows(int[][] mat, int k) {
            int row = mat.length;
            int col = mat[0].length;

            int[] retArr = new int[k];
            int sum =0;
//            List<Integer> filter = new ArrayList();
            BitSet bitSet = new BitSet(k);

            for(int j = 0; j < col; j++) {
                for(int i =0;  i < row; i++) {
                    if (mat[i][j] == 0) {
                        if (!bitSet.get(i)) {
                            bitSet.set(i);
                            retArr[sum ++] = i;
                            if (sum == k) {
                                return retArr;
                            }
                        }
                    }

                }
            }
            //0的全部扫完了，剩下的都是1
            for (int i = 0; i < row; i++) {
                if (!bitSet.get(i)) {
                    retArr[sum ++] = i;
                    if (sum == k) {
                        return retArr;
                    }
                }
            }
            return retArr;
        }
    }

    public static void main(String[] args) {
        logger.info("{}", new Solution().kWeakestRows(new int[][]{
                {1,1,0,0,0},
                {1,1,1,1,0},
                {1,0,0,0,0},
                {1,1,0,0,0},
                {1,1,1,1,1}
        } , 3));//2,0,3

        logger.info("{}", new Solution().kWeakestRows(new int[][]{
                {1,1,0,0,0},
                {1,1,1,1,0},
                {1,0,0,0,0},
                {1,1,0,0,0},
                {1,1,1,1,1}
        } , 3));//2,0,3


        logger.info("{}", new Solution().kWeakestRows(new int[][]{
                {1,0},
                {1,0},
                {1,0},
                {1,1}
        } , 4));//0,1,2,3
    }
}
