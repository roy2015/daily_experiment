package com.roy.miscellaneous.leetcode;

import org.slf4j.LoggerFactory;

import java.util.PriorityQueue;

/**
 * Created by apple on 2019/9/1.
 *
 * 据流中的第K大元素
 *
 * 最小堆
 *
 * https://leetcode-cn.com/problems/kth-largest-element-in-a-stream
 */
public class TestKthLargest {
    private static final org.slf4j.Logger logger = LoggerFactory.getLogger(TestKthLargest.class);

    static class KthLargest {
        private PriorityQueue<Integer> priorityQueue;
        private int k;

        public KthLargest(int k, int[] nums) {
            priorityQueue = new PriorityQueue<>(k);
            this.k = k;
            for (int num : nums) {
                add(num);
            }
        }

        public int add(int val) {
            if (priorityQueue.size() < k) {
                priorityQueue.add(val);
            } else {
                priorityQueue.add(val);
                priorityQueue.poll();
            }
            return priorityQueue.peek();
        }
    }

    public static void main(String[] args) {
        int k = 3;
        int[] arr = new int[]{4,5,8,2};
        KthLargest kthLargest = new KthLargest(3, arr);
        int result ;
        result = kthLargest.add(3);// returns 4
        logger.info("{}",result);
        result = kthLargest.add(5);// returns 5
        logger.info("{}",result);
        result = kthLargest.add(10);// returns 5
        logger.info("{}",result);
        result = kthLargest.add(9);// returns 8
        logger.info("{}",result);
        result = kthLargest.add(4);// returns 8
        logger.info("{}",result);

    }
}
