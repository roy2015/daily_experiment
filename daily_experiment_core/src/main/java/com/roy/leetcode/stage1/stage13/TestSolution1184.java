package com.roy.leetcode.stage1.stage13;

import org.slf4j.LoggerFactory;

/**
 * @author guojun
 * @date 2020/7/9
 *
 * 1184. 公交站间的距离
 * 环形公交路线上有 n 个站，按次序从 0 到 n - 1 进行编号。我们已知每一对相邻公交站之间的距离，distance[i] 表示编号为 i 的车站和编号为 (i + 1) % n 的车站之间的距离。
 *
 * 环线上的公交车都可以按顺时针和逆时针的方向行驶。
 *
 * 返回乘客从出发点 start 到目的地 destination 之间的最短距离。
 *
 *
 *
 * 示例 1：
 *
 *
 *
 * 输入：distance = [1,2,3,4], start = 0, destination = 1
 * 输出：1
 * 解释：公交站 0 和 1 之间的距离是 1 或 9，最小值是 1。
 *
 *
 * 示例 2：
 *
 *
 *
 * 输入：distance = [1,2,3,4], start = 0, destination = 2
 * 输出：3
 * 解释：公交站 0 和 2 之间的距离是 3 或 7，最小值是 3。
 *
 *
 * 示例 3：
 *
 *
 *
 * 输入：distance = [1,2,3,4], start = 0, destination = 3
 * 输出：4
 * 解释：公交站 0 和 3 之间的距离是 6 或 4，最小值是 4。
 *
 *
 * 提示：
 *
 * 1 <= n <= 10^4
 * distance.length == n
 * 0 <= start, destination < n
 * 0 <= distance[i] <= 10^4
 *
 */
public class TestSolution1184 {
    private static final org.slf4j.Logger logger = LoggerFactory.getLogger(TestSolution1184.class);


    static class Solution {
        /**
         *
         * 执行结果：
         * 通过
         * 显示详情
         * 执行用时：0 ms, 在所有 Java 提交中击败了100.00%的用户
         * 内存消耗：39.5 MB, 在所有 Java 提交中击败了100.00%的用户
         *
         * @param distance
         * @param start
         * @param destination
         * @return
         */
        public int distanceBetweenBusStops(int[] distance, int start, int destination) {
            int length = distance.length;
            if (length == 1 || start == destination) {
                return 0;
            }

            //题目中没有说start， destination的大小关系？？
            int srcIdx = Math.min(start, destination);
            int desIdx = Math.max(start, destination);

            int shunshizDis =0;
            //从srcIdx 顺时针
            for (int i = srcIdx; i < desIdx; i++) {
                shunshizDis += distance[i];
            }

            //从srcIdx逆时针
            int nishizDis =0;
            int i = srcIdx;
            //srcIdx .. 0
            for (i = 0; i < srcIdx; i++) {
                nishizDis += distance[i];
            }
            // 0 ... desIdx
            for (i = desIdx; i < length; i++) {
                nishizDis += distance[i];
            }
            return nishizDis < shunshizDis ? nishizDis : shunshizDis;
        }

    }

    public static void main(String[] args) {
        logger.info("{}", new Solution().distanceBetweenBusStops(new int[]{1}, 0, 2));//0
        logger.info("{}", new Solution().distanceBetweenBusStops(new int[]{1, 2, 3, 4}, 0, 0));//0
        logger.info("{}", new Solution().distanceBetweenBusStops(new int[]{1, 2, 3, 4}, 0, 1));//1
        logger.info("{}", new Solution().distanceBetweenBusStops(new int[]{1, 2, 3, 4}, 0, 2));//3
        logger.info("{}", new Solution().distanceBetweenBusStops(new int[]{1, 2, 3, 4}, 0, 3));//4
    }
}
