package com.roy.leetcode.stage2.stage20;

import java.util.HashMap;
import java.util.Map;

import org.slf4j.LoggerFactory;

/**
 *
 * 447. 回旋镖的数量
 * 给定平面上 n 对 互不相同 的点 points ，其中 points[i] = [xi, yi] 。回旋镖 是由点 (i, j, k) 表示的元组 ，其中 i 和 j 之间的距离和 i 和 k 之间的距离相等（需要考虑元组的顺序）。
 *
 * 返回平面上所有回旋镖的数量。
 *
 *
 * 示例 1：
 *
 * 输入：points = [[0,0],[1,0],[2,0]]
 * 输出：2
 * 解释：两个回旋镖为 [[1,0],[0,0],[2,0]] 和 [[1,0],[2,0],[0,0]]
 * 示例 2：
 *
 * 输入：points = [[1,1],[2,2],[3,3]]
 * 输出：2
 * 示例 3：
 *
 * 输入：points = [[1,1]]
 * 输出：0
 *
 *
 * 提示：
 *
 * n == points.length
 * 1 <= n <= 500
 * points[i].length == 2
 * -104 <= xi, yi <= 104
 * 所有点都 互不相同
 *
 * @author guojun
 * @date 2021/1/21 10:40
 */
public class TestSolution447 {
    private static final org.slf4j.Logger logger = LoggerFactory.getLogger(TestSolution447.class);


    static class Solution {
        /**
         * 把问题想复杂了，以为要动态规划，实际上直接hash就可以了，理解也错误了，  元组
         *
         *
         * 执行结果：
         * 通过
         * 显示详情
         * 添加备注
         *
         * 执行用时：
         * 159 ms
         * , 在所有 Java 提交中击败了
         * 34.43%
         * 的用户
         * 内存消耗：
         * 38.5 MB
         * , 在所有 Java 提交中击败了
         * 20.76%
         * 的用户
         * 通过测试用例：
         * 32 / 32
         *
         * @param points
         * @return
         */
        public int numberOfBoomerangs(int[][] points) {
            int pointCnt = points.length;
            if (pointCnt == 1) return 0;
            int result = 0;
            Map<Integer, Integer> map;
            for (int i = 0; i < pointCnt; i++) {
                int[] iPoint = points[i];
                int ipointX = iPoint[0];
                int ipointY = iPoint[1];
                map = new HashMap<>();
                for (int j = 0; j < pointCnt; j++) {
                    if (i == j) continue;;
                    int[] jPoint = points[j];
                    int disX = Math.abs(ipointX - jPoint[0]);
                    int disY = Math.abs(ipointY - jPoint[1]);
                    int dis = disX * disX + disY * disY;
                    map.compute(dis, (key, oldVal) -> {
                        if (oldVal == null) return 1;
                        return oldVal.intValue() + 1;
                    });
                }
                result += map.values().stream().reduce(0, (a,b) -> a + b * (b-1));
            }
            return result;
        }
    }

    public static void main(String[] args) {
//        logger.info("{}", new Solution().numberOfBoomerangs(new int[][]{
//            {0,0},{1,0},{2,0}
//        }));//2
//
//        logger.info("{}", new Solution().numberOfBoomerangs(new int[][]{
//            {1,1}
//        }));//0

        logger.info("{}", new Solution().numberOfBoomerangs(new int[][]{
            {1,1},{2,2},{3,3},{4,4},{5,5},{6,6},{7,7},{8,8}
        }));//24
    }
}
