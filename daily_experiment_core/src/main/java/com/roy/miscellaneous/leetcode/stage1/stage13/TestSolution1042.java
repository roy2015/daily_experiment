package com.roy.miscellaneous.leetcode.stage1.stage13;

import org.slf4j.LoggerFactory;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author guojun
 * @date 2020/7/8
 *
 *
 * 1042. 不邻接植花
 * 有 N 个花园，按从 1 到 N 标记。在每个花园中，你打算种下四种花之一。
 *
 * paths[i] = [x, y] 描述了花园 x 到花园 y 的双向路径。
 *
 * 另外，没有花园有 3 条以上的路径可以进入或者离开。
 *
 * 你需要为每个花园选择一种花，使得通过路径相连的任何两个花园中的花的种类互不相同。
 *
 * 以数组形式返回选择的方案作为答案 answer，其中 answer[i] 为在第 (i+1) 个花园中种植的花的种类。花的种类用  1, 2, 3, 4 表示。保证存在答案。
 *
 *
 *
 * 示例 1：
 *
 * 输入：N = 3, paths = [[1,2],[2,3],[3,1]]
 * 输出：[1,2,3]
 * 示例 2：
 *
 * 输入：N = 4, paths = [[1,2],[3,4]]
 * 输出：[1,2,1,2]
 * 示例 3：
 *
 * 输入：N = 4, paths = [[1,2],[2,3],[3,4],[4,1],[1,3],[2,4]]
 * 输出：[1,2,3,4]
 *
 *
 * 提示：
 *
 * 1 <= N <= 10000
 * 0 <= paths.size <= 20000
 * 不存在花园有 4 条或者更多路径可以进入或离开。
 * 保证存在答案。
 *
 */
public class TestSolution1042 {
    private static final org.slf4j.Logger logger = LoggerFactory.getLogger(TestSolution1042.class);


    static class Solution {

        /**
         *
         *
         * 图的染色问题 四色问题  邻接表
         *
         * 执行结果：
         * 通过
         * 显示详情
         * 执行用时：
         * 13 ms, 在所有 Java 提交中击败了79.05%的用户
         * 内存消耗：
         * 47.5 MB, 在所有 Java 提交中击败了100.00%
         * 的用户
         * @param N
         * @param paths
         * @return
         */
        public int[] gardenNoAdj(int N, int[][] paths) {
            List<Integer>[] vertexs = new ArrayList[N +1];
            for (int i = 0; i < N +1 ; i++) {
                vertexs[i] = new ArrayList<Integer>();
            }

            //构建邻接表
            for (int i = 0; i < paths.length; i++) {
                int[] path = paths[i];
                vertexs[path[0]].add(path[1]);
                vertexs[path[1]].add(path[0]);
            }

            boolean[] color;
            int[] ret = new int[N];
            for (int i = 1; i < vertexs.length; i++) {
                color = new boolean[5];
                for (Integer linkVertex : vertexs[i]) {
                    if (ret[linkVertex -1] != 0) {
                        color[ret[linkVertex -1]] = true;
                    }
                }
                for (int i1 = 1; i1 < color.length; i1++) {
                    if (!color[i1]) {
                        ret[i-1] = i1;
                        break;
                    }
                }
            }
            return ret;

        }
    }

    public static void main(String[] args) {
        logger.info("{}", new Solution().gardenNoAdj(3, new int[][]
                {{1,2},
                  {2,3},
                   {3,1}
                }));//1, 2,3
        logger.info("{}", new Solution().gardenNoAdj(4, new int[][]
                {{1,2},
                        {3,4}
                }));// 1,2,1,2

        logger.info("{}", new Solution().gardenNoAdj(4, new int[][]
                {
                        {1,2},
                        {2,3},
                        {3,4},
                        {4,1},
                        {1,3},
                        {2,4}
                }));//1,2,3,4


    }
}
