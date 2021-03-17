package com.roy.miscellaneous.leetcode.stage1.stage10;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.slf4j.LoggerFactory;

/**
 * @author guojun
 * @date 2020/9/16
 *
 * 970. 强整数
 * 给定两个正整数 x 和 y，如果某一整数等于 x^i + y^j，其中整数 i >= 0 且 j >= 0，那么我们认为该整数是一个强整数。
 *
 * 返回值小于或等于 bound 的所有强整数组成的列表。
 *
 * 你可以按任何顺序返回答案。在你的回答中，每个值最多出现一次。
 *
 *
 *
 * 示例 1：
 *
 * 输入：x = 2, y = 3, bound = 10
 * 输出：[2,3,4,5,7,9,10]
 * 解释：
 * 2 = 2^0 + 3^0
 * 3 = 2^1 + 3^0
 * 4 = 2^0 + 3^1
 * 5 = 2^1 + 3^1
 * 7 = 2^2 + 3^1
 * 9 = 2^3 + 3^0
 * 10 = 2^0 + 3^2
 * 示例 2：
 *
 * 输入：x = 3, y = 5, bound = 15
 * 输出：[2,4,6,8,10,14]
 *
 *
 * 提示：
 *
 * 1 <= x <= 100
 * 1 <= y <= 100
 * 0 <= bound <= 10^6
 *
 *
 */
public class TestSolution970 {
    private static final org.slf4j.Logger logger = LoggerFactory.getLogger(TestSolution970.class);


    static class Solution {

        /**
         *
         * 这都能100% ~~
         *
         * 执行结果：
         * 通过
         * 显示详情
         * 执行用时：1 ms, 在所有 Java 提交中击败了100.00%的用户
         * 内存消耗：36.2 MB, 在所有 Java 提交中击败了88.60%的用户
         *
         * @param x
         * @param y
         * @param bound
         * @return
         */
        public List<Integer> powerfulIntegers(int x, int y, int bound) {
            if (bound < 2) {
                return Collections.emptyList();
            }

            List<Integer> xList = new ArrayList<>();
            List<Integer> yList = new ArrayList<>();

            int xVal = 1;
            do {
                xList.add(xVal);
                xVal *= x;
            } while (xVal != 1 && xVal <= bound);

            int yVal = 1;
            do {
                yList.add(yVal);
                yVal *= y;
            } while ( yVal != 1 && yVal <= bound);

            int xSize = xList.size();
            int ySize = yList.size();

            List<Integer> retList = new ArrayList<>();
            for (int i = 0; i < xSize; i++) {
                xVal = xList.get(i);
                int i1;
                for (i1 = 0; i1 < ySize; i1++) {
                    yVal = yList.get(i1);
                    if (xVal + yVal > bound) {
                        break;
                    }
                    if (!retList.contains(xVal + yVal)) {
                        retList.add(xVal + yVal);
                    }
                }
            }
            return retList;
        }
    }

    public static void main(String[] args) {

        logger.info("{}", new Solution().powerfulIntegers(2, 1, 10));

        logger.info("{}", new Solution().powerfulIntegers(2, 3, 10));//2,3,4,5,7,9,10

        logger.info("{}", new Solution().powerfulIntegers(3, 5, 15));//2,4,6,8,10,14
    }
}
