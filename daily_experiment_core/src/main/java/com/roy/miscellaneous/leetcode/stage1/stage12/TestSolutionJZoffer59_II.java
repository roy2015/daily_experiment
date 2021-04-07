package com.roy.miscellaneous.leetcode.stage1.stage12;

import org.slf4j.LoggerFactory;

import java.util.Deque;
import java.util.LinkedList;

/**
 * @author guojun
 * @date 2021/3/30
 *
 * 剑指 Offer 59 - II. 队列的最大值
 * 请定义一个队列并实现函数 max_value 得到队列里的最大值，要求函数max_value、push_back 和 pop_front 的均摊时间复杂度都是O(1)。
 *
 * 若队列为空，pop_front 和 max_value 需要返回 -1
 *
 * 示例 1：
 *
 * 输入:
 * ["MaxQueue","push_back","push_back","max_value","pop_front","max_value"]
 * [[],[1],[2],[],[],[]]
 * 输出: [null,null,null,2,1,2]
 * 示例 2：
 *
 * 输入:
 * ["MaxQueue","pop_front","max_value"]
 * [[],[],[]]
 * 输出: [null,-1,-1]
 *
 *
 * 限制：
 *
 * 1 <= push_back,pop_front,max_value的总操作数 <= 10000
 * 1 <= value <= 10^5
 *
 */
public class TestSolutionJZoffer59_II {
    private static final org.slf4j.Logger logger = LoggerFactory.getLogger(TestSolutionJZoffer59_II.class);


    /**
     *
     * 借鉴的思路，维护一个递减队列 https://leetcode-cn.com/problems/dui-lie-de-zui-da-zhi-lcof/solution/mian-shi-ti-59-ii-dui-lie-de-zui-da-zhi-by-leetcod/
     *
     * 执行结果：
     * 通过
     * 显示详情
     * 执行用时：
     * 39 ms
     * , 在所有 Java 提交中击败了
     * 89.97%
     * 的用户
     * 内存消耗：
     * 46.3 MB
     * , 在所有 Java 提交中击败了
     * 64.06%
     * 的用户
     *
     */
    static class MaxQueue {
        private Deque<Integer> dataQueue;
        private Deque<Integer> maxQueue;

        public MaxQueue() {
            maxQueue = new LinkedList<>();
            dataQueue = new LinkedList<>();
        }

        public int max_value() {
            if (maxQueue.isEmpty()) {
                return -1;
            }
            return maxQueue.peek();
        }

        public void push_back(int value) {
            dataQueue.add(value);
            while (!maxQueue.isEmpty() && maxQueue.peekLast() < value) {
                maxQueue.pollLast();
            }
            maxQueue.add(value);
        }

        public int pop_front() {
            if (dataQueue.isEmpty()) {
                return -1;
            }
            Integer firstData = dataQueue.poll();
            if (firstData.intValue() == maxQueue.peek()) {
                maxQueue.poll();
            }
            return firstData;
        }
    }




    public static void main(String[] args) {
        MaxQueue maxQueue = null;

        /**
         *  2    3    3      3
         *  pu2 pu3  pu1    po2（31）
         *
         *  2    3   31
         *
         *  2   23   231    31
         */
        maxQueue = new MaxQueue();

        maxQueue.push_back(2);
        logger.info("{}", maxQueue.max_value());//2
        maxQueue.push_back(3);
        logger.info("{}", maxQueue.max_value());//3
        maxQueue.push_back(1);
        logger.info("{}", maxQueue.max_value());//3
        maxQueue.pop_front();
        logger.info("{}", maxQueue.max_value());//3
        maxQueue.pop_front();
        logger.info("{}", maxQueue.max_value());//2
    }
}
