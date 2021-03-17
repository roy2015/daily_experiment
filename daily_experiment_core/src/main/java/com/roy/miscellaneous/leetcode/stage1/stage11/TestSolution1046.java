package com.roy.miscellaneous.leetcode.stage1.stage11;

import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Stack;

import org.slf4j.LoggerFactory;

/**
 * @author guojun
 * @date 2020/4/29 15:00
 *
 * 1046. 最后一块石头的重量
 * 有一堆石头，每块石头的重量都是正整数。
 *
 * 每一回合，从中选出两块 最重的 石头，然后将它们一起粉碎。假设石头的重量分别为 x 和 y，且 x <= y。那么粉碎的可能结果如下：
 *
 * 如果 x == y，那么两块石头都会被完全粉碎；
 * 如果 x != y，那么重量为 x 的石头将会完全粉碎，而重量为 y 的石头新重量为 y-x。
 * 最后，最多只会剩下一块石头。返回此石头的重量。如果没有石头剩下，就返回 0。
 *
 *
 *
 * 示例：
 *
 * 输入：[2,7,4,1,8,1]
 * 输出：1
 * 解释：
 * 先选出 7 和 8，得到 1，所以数组转换为 [2,4,1,1,1]，
 * 再选出 2 和 4，得到 2，所以数组转换为 [2,1,1,1]，
 * 接着是 2 和 1，得到 1，所以数组转换为 [1,1,1]，
 * 最后选出 1 和 1，得到 0，最终数组转换为 [1]，这就是最后剩下那块石头的重量。
 *
 *
 * 提示：
 *
 * 1 <= stones.length <= 30
 * 1 <= stones[i] <= 1000
 *
 */
public class TestSolution1046 {
    private static final org.slf4j.Logger logger = LoggerFactory.getLogger(TestSolution1046.class);


    static class Solution {

        /**
         *
         * 用了两个栈
         *
         *
         * 执行结果：
         * 通过
         * 显示详情
         * 执行用时 :5 ms, 在所有 Java 提交中击败了5.30%的用户
         * 内存消耗 :37.2 MB, 在所有 Java 提交中击败了16.67%的用户
         * @param stones
         * @return
         */
        public int lastStoneWeight(int[] stones) {
            if (stones.length ==0) {
                return 0;
            }
            if (stones.length ==2) {
                return Math.abs(stones[0] - stones[1]);
            }
            if (stones.length ==1) {
                return stones[0];
            }

            //排序后放到栈里去
            Arrays.sort(stones);
            Stack<Integer> stack = new Stack<Integer>();
            Stack<Integer> hsStack = new Stack<Integer>();
            for (int stone : stones) {
                stack.push(stone);
            }

            while (true) {
                //取出两个数
                Integer i1 = stack.pop();
                if (stack.empty()) return i1;
                Integer i2 = stack.pop();
                //碰撞
                int destoryedI = Math.abs(i1 - i2);
                if (destoryedI !=0) {
                    //残渣放回去
                    while (!stack.isEmpty()  && stack.peek() > destoryedI) {
                        hsStack.push(stack.pop());
                    }
                    stack.push(destoryedI);
                    while (!hsStack.isEmpty()) {
                        stack.push(hsStack.pop());
                    }
                } else {
                    //没有残渣再判断是否没有
                    if (stack.isEmpty()) return 0;
                }
            }
        }

        /**
         *
         * 使用大顶堆
         *
         * 执行结果：
         * 通过
         * 显示详情
         * 执行用时 :2 ms, 在所有 Java 提交中击败了43.51%的用户
         * 内存消耗 :37.2 MB, 在所有 Java 提交中击败了16.67%的用户
         *
         * @param stones
         * @return
         */
        public int lastStoneWeight1(int[] stones) {
            if (stones.length ==0) {
                return 0;
            }
            if (stones.length ==2) {
                return Math.abs(stones[0] - stones[1]);
            }
            if (stones.length ==1) {
                return stones[0];
            }

            PriorityQueue<Integer> heap = new PriorityQueue<>((o1, o2) -> o2.compareTo(o1));
            for (int stone : stones) {
                heap.add(stone);
            }

            while (true) {
                if (heap.size() == 0 ) {
                    return 0;
                }

                Integer f = 0;
                if (heap.size() ==1 ) {
                    return  heap.poll();
                }
                f= heap.poll();
                Integer s = heap.poll();

                int destoryedI = Math.abs(s - f);
                if (destoryedI != 0) {
                    heap.add(destoryedI);
                }
            }
        }
    }

    public static void main(String[] args) {
//        logger.info("{}", new Solution().lastStoneWeight1(new int[]{2,7,4,1,8,1}));
        logger.info("{}", new Solution().lastStoneWeight1(new int[]{2}));
    }
}
