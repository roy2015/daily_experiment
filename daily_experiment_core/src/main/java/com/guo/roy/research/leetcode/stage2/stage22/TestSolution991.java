package com.guo.roy.research.leetcode.stage2.stage22;

import java.util.LinkedList;
import java.util.Queue;

import org.slf4j.LoggerFactory;

/**
 * @author guojun
 * @date 2020/7/14
 * 991. 坏了的计算器
 * 在显示着数字的坏计算器上，我们可以执行以下两种操作：
 *
 * 双倍（Double）：将显示屏上的数字乘 2；
 * 递减（Decrement）：将显示屏上的数字减 1 。
 * 最初，计算器显示数字 X。
 *
 * 返回显示数字 Y 所需的最小操作数。
 *
 *
 *
 * 示例 1：
 *
 * 输入：X = 2, Y = 3
 * 输出：2
 * 解释：先进行双倍运算，然后再进行递减运算 {2 -> 4 -> 3}.
 * 示例 2：
 *
 * 输入：X = 5, Y = 8
 * 输出：2
 * 解释：先递减，再双倍 {5 -> 4 -> 8}.
 * 示例 3：
 *
 * 输入：X = 3, Y = 10
 * 输出：3
 * 解释：先双倍，然后递减，再双倍 {3 -> 6 -> 5 -> 10}.
 * 示例 4：
 *
 * 输入：X = 1024, Y = 1
 * 输出：1023
 * 解释：执行递减运算 1023 次
 *
 *
 * 提示：
 *
 * 1 <= X <= 10^9
 * 1 <= Y <= 10^9
 */
public class TestSolution991 {
    private static final org.slf4j.Logger logger = LoggerFactory.getLogger(TestSolution991.class);


    static class Solution {
        /**
         *
         * 超出时间限制，好像答案是对的~~，用的是广度优先
         * 显示详情
         *
         * @param x
         * @param y
         * @return
         */
        public int brokenCalc(int x, int y) {
            if (y < x) {
                return x -y;
            }

            int level = 1;
            int currentCnt = 1;
            int nextCnt = 0;
            Queue<Integer> queue = new LinkedList<Integer>();
            queue.add(y);
            while (true) {
                int yVal = queue.poll();
                if (yVal == x) {
                    return level;
                }
                currentCnt--;
                int dbVal = -1 ;
                if (yVal % 2 == 0) {
                    dbVal = yVal / 2;
                    queue.add(dbVal);
                    nextCnt ++;
                }
                int decVal = yVal + 1;
                queue.add(decVal);
                nextCnt += 1;
                if(dbVal == x  || decVal == x) {
                    return level ;
                }
                if(currentCnt == 0) {
                    currentCnt = nextCnt;
                    nextCnt = 0;
                    level ++;
                }
            }

        }


        /**
         * 官方的题解，比较神奇不好想
         *
         * 方法：逆向思维
         * 思路
         *
         * 除了对 X 执行乘 2 或 减 1 操作之外，我们也可以对 Y 执行除 2（当 Y 是偶数时）或者加 1 操作。
         *
         * 这样做的动机是我们可以总是贪心地执行除 2 操作：
         *
         * 当 Y 是偶数，如果先执行 2 次加法操作，再执行 1 次除法操作，我们可以通过先执行 1 次除法操作，再执行 1 次加法操作以使用更少的操作次数得到相同的结果 [(Y+2) / 2 vs Y/2 + 1]。
         *
         * 当 Y 是奇数，如果先执行 3 次加法操作，再执行 1 次除法操作，我们可以将其替代为顺次执行加法、除法、加法操作以使用更少的操作次数得到相同的结果 [(Y+3) / 2 vs (Y+1) / 2 + 1]。
         *
         * 算法
         *
         * 当 Y 大于 X 时，如果它是奇数，我们执行加法操作，否则执行除法操作。之后，我们需要执行 X - Y 次加法操作以得到 X。
         *
         * 作者：LeetCode
         * 链接：https://leetcode-cn.com/problems/broken-calculator/solution/pi-liao-de-ji-suan-qi-by-leetcode/
         * 来源：力扣（LeetCode）
         * 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
         *
         * 执行用时：
         * 0 ms, 在所有 Java 提交中击败了的用户
         * 内存消耗：
         * 36.4 MB, 在所有 Java 提交中击败了100.00%的用户
         * @param x
         * @param y
         * @return
         */
        public int brokenCalc1(int x, int y) {
            int count = 0;
            while (y > x) {
                count ++;
                if (y % 2 == 0) {
                    y = y / 2;
                } else {
                    y = y + 1;
                }
            }
            return x - y + count;


        }
    }

    public static void main(String[] args) {
        logger.info("{}", new Solution().brokenCalc(5,8));//2
        logger.info("{}", new Solution().brokenCalc(1024,1));//1023
        logger.info("{}", new Solution().brokenCalc1(1,1000000000));//39
        logger.info("{}", new Solution().brokenCalc(2,3));//2
        logger.info("{}", new Solution().brokenCalc(3,10));//3
    }

}
