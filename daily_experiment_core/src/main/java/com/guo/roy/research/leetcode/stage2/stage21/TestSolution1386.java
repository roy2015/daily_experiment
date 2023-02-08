package com.guo.roy.research.leetcode.stage2.stage21;

import java.util.*;

import org.slf4j.LoggerFactory;

/**
 *
 *
 *
 * @author guojun
 * @date 2020/6/11
 *
 *
 * 1386. 安排电影院座位
 *
 *
 * 如上图所示，电影院的观影厅中有 n 行座位，行编号从 1 到 n ，且每一行内总共有 10 个座位，列编号从 1 到 10 。
 *
 * 给你数组 reservedSeats ，包含所有已经被预约了的座位。比如说，researvedSeats[i]=[3,8] ，它表示第 3 行第 8 个座位被预约了。
 *
 * 请你返回 最多能安排多少个 4 人家庭 。4 人家庭要占据 同一行内连续 的 4 个座位。隔着过道的座位（比方说 [3,3] 和 [3,4]）不是连续的座位，但是如果你可以将 4 人家庭拆成过道两边各坐 2 人，这样子是允许的。
 *
 *
 *
 * 示例 1：
 *
 *
 *
 * 输入：n = 3, reservedSeats = [[1,2],[1,3],[1,8],[2,6],[3,1],[3,10]]
 * 输出：4
 * 解释：上图所示是最优的安排方案，总共可以安排 4 个家庭。蓝色的叉表示被预约的座位，橙色的连续座位表示一个 4 人家庭。
 * 示例 2：
 *
 * 输入：n = 2, reservedSeats = [[2,1],[1,8],[2,6]]
 * 输出：2
 * 示例 3：
 *
 * 输入：n = 4, reservedSeats = [[4,3],[1,4],[4,6],[1,7]]
 * 输出：4
 *
 *
 * 提示：
 *
 * 1 <= n <= 10^9
 * 1 <= reservedSeats.length <= min(10*n, 10^4)
 * reservedSeats[i].length == 2
 * 1 <= reservedSeats[i][0] <= n
 * 1 <= reservedSeats[i][1] <= 10
 * 所有 reservedSeats[i] 都是互不相同的。
 *
 */
public class TestSolution1386 {
    private static final org.slf4j.Logger logger = LoggerFactory.getLogger(TestSolution1386.class);


    /**
     *
     * 方法三是最优解，从一到三 其实就是一个迭代的过程
     *
     */
    static class Solution {

        /**
         *
         *  m * n超界
         *
         * 显示详情
         * @param n
         * @param reservedSeats
         * @return
         */
        public int maxNumberOfFamilies(int n, int[][] reservedSeats) {
            int m = 8;
            int[] result = new int[ m * n];
            Arrays.fill(result, 1);

            int ret = 0;
            for (int i = 0; i < reservedSeats.length; i++) {
                int row = reservedSeats[i][0];
                int col = reservedSeats[i][1];

                if (col <=9 && col >= 2) {
                    result[ (row -1) * m + col -2 ] = 0;
                }
            }

            for (int i = 0; i < result.length; i += m) {
                int k = 0;
                for (int i1 = 0; i1 < m; i1++) {
                    k += result[i + i1] << i1;
                }
                if (k == 0xff) {
                    ret += 2;
                } else if ((k & 0xf0) == 0xf0 || (k & 0b00111100) == 0b00111100 || (k & 0x0f) == 0x0f ) {
                    ret += 1;
                }
            }
            return ret;
        }

        /**
         *
         * 超出内存限制
         * 显示详情
         * @param n
         * @param reservedSeats
         * @return
         */
        public int maxNumberOfFamilies1(int n, int[][] reservedSeats) {
            int m = 8;
            int[][] result = new int[ n][m];
            for (int i = 0; i < result.length; i++) {
//                result[i] = new int[];
                Arrays.fill(result[i], 1);
            }

            int ret = 0;
            for (int i = 0; i < reservedSeats.length; i++) {
                int row = reservedSeats[i][0];
                int col = reservedSeats[i][1];

                if (col <=9 && col >= 2) {
                    result[ (row -1)][ col -2 ] = 0;
                }
            }

            for (int i = 0; i < result.length; i++) {
                int k = 0;
                for (int i1 = 0; i1 < m; i1++) {
                    k += result[i][i1] << i1;
                }
                if (k == 0xff) {
                    ret += 2;
                } else if ((k & 0xf0) == 0xf0 || (k & 0b00111100) == 0b00111100 || (k & 0x0f) == 0x0f ) {
                    ret += 1;
                }
            }
            return ret;
        }


        /**
         * 以上都超出内存限制，，主要是n 最大到 10^10 只能从reservedSeats着手了，
         * 因为reservedSeats最大仅仅10000
         *
         * 对上述进行优化，不能"打表"，打表就超界，只能假设都能坐，2*N,在排除法删选
         *
         *
         * 执行结果：
         * 通过
         * 显示详情
         * 执行用时：23 ms, 在所有 Java 提交中击败了62.77%的用户
         * 内存消耗：44.8 MB, 在所有 Java 提交中击败了89.03%的用户
         * @param n
         * @param reservedSeats
         * @return
         */
        public int maxNumberOfFamilies2(int n, int[][] reservedSeats) {

            int m = 8 + 1;
            Map<Integer, List<Integer>> listHashMap = new HashMap<>();
            for (int[] clip : reservedSeats) {
                listHashMap.compute(clip[0], (key, oldVal) -> {
                    if (oldVal == null) {
                        List<Integer> newVal = new ArrayList<Integer>();
                        newVal.add(clip[1]);
                        return newVal;
                    } else {
                        oldVal.add(clip[1]);
                        return oldVal;
                    }
                });
            }

            int ret = 2 * n;
            for (Map.Entry<Integer, List<Integer>> entry : listHashMap.entrySet()) {
                List<Integer> valList = entry.getValue();
                int k = 0x00;
                for (Integer item : valList) {
                    k |= 1 << (m- item);
                }
                //最后八位 0:被占 1：未占
                k = ~k & 0xff;
                if (k == 0xff) {
                    //pass
                } else if ((k & 0xf0) == 0xf0 || (k & 0b00111100) == 0b00111100 || (k & 0x0f) == 0x0f ) {
                    ret -= 1;
                } else {
                    ret -= 2;
                }
            }
            return ret;

        }
    }

    public static void main(String[] args) {
        logger.info("{}", new Solution().maxNumberOfFamilies2(4,
                new int[][]{{4,3},{1,4},{4,6},{1,7}}));//4

        logger.info("{}", new Solution().maxNumberOfFamilies2(3,
                new int[][]{{1,2},{1,3},{1,8},{2,6},{3,1},{3,10}}));//4

        logger.info("{}", new Solution().maxNumberOfFamilies2(3,
                new int[][]{{2,3}}));                               //5

        logger.info("{}", new Solution().maxNumberOfFamilies2(2,
                new int[][]{{2,1},{1,8},{2,6}}));                   //2



    }
}
