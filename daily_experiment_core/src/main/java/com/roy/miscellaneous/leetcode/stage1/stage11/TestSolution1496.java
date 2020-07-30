package com.roy.miscellaneous.leetcode.stage1.stage11;

import org.slf4j.LoggerFactory;

/**
 * @author guojun
 * @date 2020/7/29
 *
 * 1496. 判断路径是否相交
 * 给你一个字符串 path，其中 path[i] 的值可以是 'N'、'S'、'E' 或者 'W'，分别表示向北、向南、向东、向西移动一个单位。
 *
 * 机器人从二维平面上的原点 (0, 0) 处开始出发，按 path 所指示的路径行走。
 *
 * 如果路径在任何位置上出现相交的情况，也就是走到之前已经走过的位置，请返回 True ；否则，返回 False 。
 *
 *
 *
 * 示例 1：
 *
 *
 *
 * 输入：path = "NES"
 * 输出：false
 * 解释：该路径没有在任何位置相交。
 * 示例 2：
 *
 *
 *
 * 输入：path = "NESWW"
 * 输出：true
 * 解释：该路径经过原点两次。
 *
 *
 * 提示：
 *
 * 1 <= path.length <= 10^4
 * path 仅由 {'N', 'S', 'E', 'W} 中的字符组成
 *
 */
public class TestSolution1496 {
    private static final org.slf4j.Logger logger = LoggerFactory.getLogger(TestSolution1496.class);


    static class Solution {
        /**
         *
         * 1)构建一张大图，有点慢 可能超出内存限制
         * 2) 把图缩小，减少内存
         *
         * 230M?
         *
         * 执行结果：
         * 通过
         * 显示详情
         * 执行用时：
         * 77 ms, 在所有 Java 提交中击败了5.11%的用户
         * 内存消耗：
         * 230.5 MB, 在所有 Java 提交中击败了100.00%的用户
         * @param path
         * @return
         */
        public boolean isPathCrossing(String path) {
            char[] chars = path.toCharArray();
            int nSize = 0;
            int eSize = 0;
            int sSize = 0;
            int wSize = 0;
            for (char aChar : chars) {
                switch (aChar) {
                    case 'N':
                        nSize ++;
                        break;
                    case 'E':
                        eSize ++;
                        break;
                    case 'S':
                        sSize ++;
                        break;
                    case 'W':
                        wSize ++;
                        break;
                    default:break;
                }
            }
            int neMax = Math.max(nSize, eSize);
            int swMax = Math.max(sSize, wSize);
            int size = Math.max(neMax, swMax);

            int mapSize = size *2 + 1;
            int[][] map = new int[mapSize][mapSize];

            int px = size, py = size;
            //init
            map[px][py] = 1;
            for (char aChar : chars) {
                switch (aChar) {
                    case 'N':
                        px = px - 1;
                        break;
                    case 'E':
                        py = py + 1;
                        break;
                    case 'S':
                        px = px + 1;
                        break;
                    case 'W':
                        py = py - 1;
                        break;
                    default:break;
                }
                if (map[px][py] == 1) {
                    return true;
                }
                map[px][py] = 1;
            }
            return false;
        }

        /**
         *
         *
         * 质变 ^_^
         *
         * 执行结果：
         * 通过
         * 显示详情
         * 执行用时：1 ms, 在所有 Java 提交中击败了97.74%的用户
         * 内存消耗：38.1 MB, 在所有 Java 提交中击败了100.00%的用户
         * @param path
         * @return
         */
        public boolean isPathCrossing1(String path) {
            char[] chars = path.toCharArray();
            int len = chars.length;
            for (int i = 0; i < len; i++) {
                int px = 0;
                int py = 0;
                for (int j = i; j >=0 ; j--) {
                    switch (chars[j]) {
                        case 'N':
                            px = px - 1;
                            break;
                        case 'E':
                            py = py - 1;
                            break;
                        case 'S':
                            px = px + 1;
                            break;
                        case 'W':
                            py = py + 1;
                            break;
                        default:break;
                    }
                    if (px == 0 && py == 0) {
                        return true;
                    }
                }
            }
            return false;
        }

    }

    public static void main(String[] args) {
        logger.info("{}", new Solution().isPathCrossing1("S"));//false
        logger.info("{}", new Solution().isPathCrossing1("NESWW"));//true
        logger.info("{}", new Solution().isPathCrossing1("NES"));//false

    }
}
