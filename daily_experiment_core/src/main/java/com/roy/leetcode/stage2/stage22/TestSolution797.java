package com.roy.leetcode.stage2.stage22;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.LoggerFactory;

/**
 * @author guojun
 * @date 2020/10/21
 *
 * 797. 所有可能的路径
 * 给一个有 n 个结点的有向无环图，找到所有从 0 到 n-1 的路径并输出（不要求按顺序）
 *
 * 二维数组的第 i 个数组中的单元都表示有向图中 i 号结点所能到达的下一些结点（译者注：有向图是有方向的，即规定了 a→b 你就不能从 b→a ）空就是没有下一个结点了。
 *
 *
 *
 * 示例 1：
 *
 *
 *
 * 输入：graph = [[1,2],[3],[3],[]]
 * 输出：[[0,1,3],[0,2,3]]
 * 解释：有两条路径 0 -> 1 -> 3 和 0 -> 2 -> 3
 * 示例 2：
 *
 *
 *
 * 输入：graph = [[4,3,1],[3,2,4],[3],[4],[]]
 * 输出：[[0,4],[0,3,4],[0,1,3,4],[0,1,2,3,4],[0,1,4]]
 * 示例 3：
 *
 * 输入：graph = [[1],[]]
 * 输出：[[0,1]]
 * 示例 4：
 *
 * 输入：graph = [[1,2,3],[2],[3],[]]
 * 输出：[[0,1,2,3],[0,2,3],[0,3]]
 * 示例 5：
 *
 * 输入：graph = [[1,3],[2],[3],[]]
 * 输出：[[0,1,2,3],[0,3]]
 *
 *
 * 提示：
 *
 * 结点的数量会在范围 [2, 15] 内。
 * 你可以把路径以任意顺序输出，但在路径内的结点的顺序必须保证。
 *
 */
public class TestSolution797 {
    private static final org.slf4j.Logger logger = LoggerFactory.getLogger(TestSolution797.class);



    static class Solution {
        private List<List<Integer>> allPaths = new ArrayList<>();
        private int target;

        /**
         *
         * 经典的回溯问题  走每一步到下一步要留下这一步的其他选项，即checkpoint，一次提交通过~
         *
         * 执行结果：通过
         * 显示详情
         * 执行用时：2 ms, 在所有 Java 提交中击败了100.00%的用户
         * 内存消耗：40.7 MB, 在所有 Java 提交中击败了28.04%的用户
         *
         *
         * @param graph
         * @return
         */
        public List<List<Integer>> allPathsSourceTarget(int[][] graph) {
            //target的index
            target = graph.length -1;

            //第一步能走的路径
            int[] routes = graph[0];
            //递归走起
            List<Integer> path = new ArrayList<>();
            path.add(0);
            allPathsSourceTargetSub(graph, 0, path );
            return this.allPaths;
        }

        /**
         *
         * @param graph 地图
         * @param nodeIdx 当前点
         * @param hisPath 已走过的点
         */
        public void allPathsSourceTargetSub(int[][] graph, int nodeIdx, List<Integer> hisPath) {
            List<Integer> copyHisPath;
            //可达路径
            int[] routes = graph[nodeIdx];
            for (int route : routes) {
                copyHisPath = new ArrayList<>();
                copyHisPath.addAll(hisPath);
                if (route == target) {
                    copyHisPath.add(route);
                    this.allPaths.add(copyHisPath);
                    continue;
                } else {
                    copyHisPath.add(route);
                    allPathsSourceTargetSub(graph, route, copyHisPath);
                }
            }
        }


    }

    public static void main(String[] args) {
        logger.info("{}", new Solution().allPathsSourceTarget(new int[][]{
                {1,2},{3},{3},{}
        }));//[[0,1,3],[0,2,3]]

        logger.info("{}", new Solution().allPathsSourceTarget(new int[][]{
                {4,3,1},{3,2,4},{3},{4},{}
        }));//[[0,4],[0,3,4],[0,1,3,4],[0,1,2,3,4],[0,1,4]]

        logger.info("{}", new Solution().allPathsSourceTarget(new int[][]{
                {1},{}
        }));//[[0,1]]
    }
}
