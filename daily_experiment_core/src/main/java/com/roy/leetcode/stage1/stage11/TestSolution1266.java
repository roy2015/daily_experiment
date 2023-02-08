package com.roy.leetcode.stage1.stage11;

import org.slf4j.LoggerFactory;

/**
 * @author guojun
 * @date 2020/5/26
 *
 * 1266. 访问所有点的最小时间
平面上有 n 个点，点的位置用整数坐标表示 points[i] = [xi, yi]。请你计算访问所有这些点需要的最小时间（以秒为单位）。

你可以按照下面的规则在平面上移动：

每一秒沿水平或者竖直方向移动一个单位长度，或者跨过对角线（可以看作在一秒内向水平和竖直方向各移动一个单位长度）。
必须按照数组中出现的顺序来访问这些点。


示例 1：



输入：points = [[1,1],[3,4],[-1,0]]
输出：7
解释：一条最佳的访问路径是： [1,1] -> [2,2] -> [3,3] -> [3,4] -> [2,3] -> [1,2] -> [0,1] -> [-1,0]
从 [1,1] 到 [3,4] 需要 3 秒
从 [3,4] 到 [-1,0] 需要 4 秒
一共需要 7 秒
示例 2：

输入：points = [[3,2],[-2,2]]
输出：5


提示：

points.length == n
1 <= n <= 100
points[i].length == 2
-1000 <= points[i][0], points[i][1] <= 1000
 *
 */
public class TestSolution1266 {
    private static final org.slf4j.Logger logger = LoggerFactory.getLogger(TestSolution1266.class);


    static class Solution {

        /**
         *
         *
         * 执行结果：
         通过
         显示详情
         执行用时 :1 ms, 在所有 Java 提交中击败了97.01%的用户
         内存消耗 :39.4 MB, 在所有 Java 提交中击败了100.00%的用户
         *
         * @param points
         * @return
         */
        public int minTimeToVisitAllPoints(int[][] points) {
            int costTime = 0;

            for(int i =1; i < points.length; i++) {
                int[] p0 = points[i-1];
                int[] p1 = points[i];
                int pxDis = Math.abs(p1[0]-p0[0]);
                int pyDis = Math.abs(p1[1]-p0[1]);
                int currCostTime = Math.max(pxDis, pyDis);
                costTime += currCostTime;
            }
            return costTime;

        }
    }

    public static void main(String[] args) {
        logger.info("{}", new Solution().minTimeToVisitAllPoints(new int[][]{{1,1},{3,4},{-1,0}}));//7
        logger.info("{}", new Solution().minTimeToVisitAllPoints(new int[][]{{3,2},{-2,2}}));//5
    }
}
