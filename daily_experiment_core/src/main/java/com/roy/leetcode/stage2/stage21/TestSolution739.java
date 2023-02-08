package com.roy.leetcode.stage2.stage21;

import java.util.Deque;
import java.util.LinkedList;
import java.util.Stack;

import org.slf4j.LoggerFactory;

/**
 * @author guojun
 * @date 2020/6/11
 *
 * 739. 每日温度
 * 请根据每日 气温 列表，重新生成一个列表。对应位置的输出为：要想观测到更高的气温，至少需要等待的天数。如果气温在这之后都不会升高，请在该位置用 0 来代替。
 *
 * 例如，给定一个列表 temperatures = [73, 74, 75, 71, 69, 72, 76, 73]，你的输出应该是 [1, 1, 4, 2, 1, 1, 0, 0]。
 *
 * 提示：气温 列表长度的范围是 [1, 30000]。每个气温的值的均为华氏度，都是在 [30, 100] 范围内的整数。
 */
public class TestSolution739 {
    private static final org.slf4j.Logger logger = LoggerFactory.getLogger(TestSolution739.class);


    /**
     * 题意： 找比当前大的下一个元素
     */
    static class Solution {
        /**
         *
         *
         * O(n^2) 肯定不是最优解
         *
         * 执行结果：
         * 通过
         * 显示详情
         * 执行用时 :708 ms, 在所有 Java 提交中击败了23.59%
         * 的用户
         * 内存消耗 :48.6 MB, 在所有 Java 提交中击败了6.45%
         * 的用户
         *
         * @param T
         * @return
         */
        public int[] dailyTemperatures(int[] T) {
            int len = T.length;
            for(int i = 0;i < len -1; i++) {
                int j = i +1;
                int iVal = T[i];
                for(;j< len ; j++) {
                    if (T[j] > iVal) {
                        break;
                    }
                }
                if (j== len) {
                    T[i] = 0;
                } else{
                    T[i] = j -i;
                }
            }
            T[len-1] = 0;
            return T;
        }

        /**
         *
         *
         * 下面两种方法都是用的单调栈 （ 底->顶 递减， ）
         *
         *
         * stack用的是LinkedList类
         *
         * 行结果：
         * 通过
         * 显示详情
         * 执行用时 :18 ms, 在所有 Java 提交中击败了84.45%的用户
         * 内存消耗 :47 MB, 在所有 Java 提交中击败了6.45%的用户
         *
         * @param T
         * @return
         */
        public int[] dailyTemperatures1(int[] T) {
            int len = T.length;
            int[] ret = new int[len];
            Deque<Integer> stack = new LinkedList<>();
            for (int i = 0; i < len; i++) {
                int iVal = T[i];
                if (stack.isEmpty()) {//空栈
                    stack.push(i);
                } else {
                    while (stack.isEmpty() == false) {
                        Integer peek = stack.peek();
                        if (iVal > T[peek]) {//栈顶比数组元素i小
                            Integer pop = stack.pop();
                            ret[pop] = i - pop;
                        } else {
                            stack.push(i);
                            break;
                        }
                    }
                    if (stack.isEmpty()) {//栈里全部比数组元素i小而跳出while
                        stack.push(i);
                    }
                }
            }
            return ret;
        }


        /**
         *
         * 和上面一样的代码，只不过的stack用的是stack类
         *
         *
         *
         * 执行结果：
         * 通过
         * 显示详情
         * 执行用时 :
         * 24 ms, 在所有 Java 提交中击败了55.31%的用户
         * 内存消耗 :
         * 47.4 MB, 在所有 Java 提交中击败了6.45%
         * 的用户
         *
         * @param T
         * @return
         */
        public int[] dailyTemperatures2(int[] T) {
            int len = T.length;
            int[] ret = new int[len];
            Stack<Integer> stack = new Stack<>();
            for (int i = 0; i < len; i++) {
                int iVal = T[i];
                if (stack.isEmpty()) {//空栈
                    stack.push(i);
                } else {
                    while (stack.isEmpty() == false) {
                        Integer peek = stack.peek();
                        if (iVal > T[peek]) {//栈顶比数组元素i小
                            Integer pop = stack.pop();
                            ret[pop] = i - pop;
                        } else {
                            stack.push(i);
                            break;
                        }
                    }
                    if (stack.isEmpty()) {//栈里全部比数组元素i小而跳出while
                        stack.push(i);
                    }
                }
            }
            return ret;
        }
    }

    public static void main(String[] args) {
        logger.info("123");
        logger.info("{}", new Solution().dailyTemperatures(new int[]{73,74,75,75,71,69,72,76,73}));
        logger.info("123");
        logger.info("{}", new Solution().dailyTemperatures1(new int[]{73,74,75,75,71,69,72,76,73}));
        logger.info("123");
        logger.info("{}", new Solution().dailyTemperatures2(new int[]{73,74,75,75,71,69,72,76,73}));
    }
}
