package com.guo.roy.research.leetcode.stage1.stage10;

import java.util.PriorityQueue;

import org.slf4j.LoggerFactory;

/**
 * Created by apple on 2019/9/1.
 *
 * 据流中的第K大元素
 *
 * 最小堆
 *
 * 设计一个找到数据流中第K大元素的类（class）。注意是排序后的第K大元素，不是第K个不同的元素。

 你的 KthLargest 类需要一个同时接收整数 k 和整数数组nums 的构造器，它包含数据流中的初始元素。每次调用 KthLargest.add，返回当前数据流中第K大的元素。

 示例:

 int k = 3;
 int[] arr = [4,5,8,2];
 KthLargest kthLargest = new KthLargest(3, arr);
 kthLargest.add(3);   // returns 4
 kthLargest.add(5);   // returns 5
 kthLargest.add(10);  // returns 5
 kthLargest.add(9);   // returns 8
 kthLargest.add(4);   // returns 8
 说明:
 你可以假设 nums 的长度≥ k-1 且k ≥ 1。

 来源：力扣（LeetCode）
 链接：https://leetcode-cn.com/problems/kth-largest-element-in-a-stream
 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class TestSolution703 {
    private static final org.slf4j.Logger logger = LoggerFactory.getLogger(TestSolution703.class);


    /**
     *
     * 注意：PriorityQueue默认是小顶堆
     *
     * 执行用时 :97 ms, 在所有 java 提交中击败了75.62%的用户
     * 内存消耗 :49.1 MB, 在所有 java 提交中击败了91.14%的用户
     */
    static class KthLargest {
        private PriorityQueue<Integer> priorityQueue;
        private int k;

        public KthLargest(int k, int[] nums) {
            priorityQueue = new PriorityQueue<>(k);
            this.k = k;
            for (int num : nums) {
                add1(num);
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

        /**
         * 改进的算法 20210322
         *
         * 执行结果：通过
         * 显示详情
         * 执行用时：17 ms, 在所有 Java 提交中击败了94.63%的用户
         * 内存消耗：43.8 MB, 在所有 Java 提交中击败了53.13%的用户
         * @param val
         * @return
         */
        public int add1(int val) {
            if (priorityQueue.size() < k) {
                priorityQueue.add(val);
                return priorityQueue.peek();
            }

            int topVal = priorityQueue.peek();
            if (val <= topVal) {
                return topVal;
            } else {
                priorityQueue.add(val);
                priorityQueue.poll();
                return priorityQueue.peek();
            }
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
