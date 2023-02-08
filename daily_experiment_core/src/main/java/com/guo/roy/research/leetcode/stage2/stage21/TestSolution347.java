package com.guo.roy.research.leetcode.stage2.stage21;

import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

import org.slf4j.LoggerFactory;

/**
 * @author guojun
 * @date 2020/6/16
 *
 * 347. 前 K 个高频元素
 * 给定一个非空的整数数组，返回其中出现频率前 k 高的元素。
 *
 *
 *
 * 示例 1:
 *
 * 输入: nums = [1,1,1,2,2,3], k = 2
 * 输出: [1,2]
 * 示例 2:
 *
 * 输入: nums = [1], k = 1
 * 输出: [1]
 *
 *
 * 提示：
 *
 * 你可以假设给定的 k 总是合理的，且 1 ≤ k ≤ 数组中不相同的元素的个数。
 * 你的算法的时间复杂度必须优于 O(n log n) , n 是数组的大小。
 * 题目数据保证答案唯一，换句话说，数组中前 k 个高频元素的集合是唯一的。
 * 你可以按任意顺序返回答案。
 */
public class TestSolution347 {
    private static final org.slf4j.Logger logger = LoggerFactory.getLogger(TestSolution347.class);


    static class Solution {

        static class Pair {
            private int key;
            private int times;
             Pair(int key, int times) {
                 this.key = key;
                 this.times = times;
             }
            public void setTimes(int times) {
                this.times = times;
            }
        }


        /**
         *
         *   最小堆 + hash        PriorityQueue是最小堆
         *
         * 执行结果：
         * 通过
         * 显示详情
         * 执行用时 :12 ms, 在所有 Java 提交中击败了98.23%的用户
         * 内存消耗 :42.5 MB, 在所有 Java 提交中击败了6.67%的用户
         *
         * @param nums
         * @param k
         * @return
         */
        public int[] topKFrequent(int[] nums, int k) {
            int length = nums.length;
            if (length == 1) {
                return new int[]{1};
            }

            Map<Integer, Pair> timesMap = new HashMap<>();
            for (int num : nums) {
                timesMap.compute(num, (key, oldVal) -> {
                    Pair newVal = null ;
                    if (oldVal == null) {
                        newVal = new Pair(key, 1);
                    } else {
                        oldVal.times = oldVal.times + 1;
                        newVal = oldVal;
                    }
                    return newVal;
                });
            }

            PriorityQueue<Pair> heap = new PriorityQueue<>(Comparator.comparingInt(o -> o.times));
            for (Map.Entry<Integer, Pair> entry : timesMap.entrySet()) {
                Integer key = entry.getKey();
                Pair val = entry.getValue();
                if (heap.size() < k) {
                    heap.add(val);
                    continue;
                }

                //已满
                Pair peek = heap.peek();
                if (val.times > peek.times) {
                    heap.poll();
                    heap.add(val);
                }
            }
            int[] ret = new int[k];
            for (int i = k-1; i >= 0; i--) {
                ret[i] = heap.poll().key;
            }
            return ret;
        }
    }

    public static void main(String[] args) {
        logger.info("{}", new Solution().topKFrequent(new int[]{1,1,1,2,2,3,3,3}, 2));

        PriorityQueue<Integer> priorityQueue = new PriorityQueue<>(2);
        priorityQueue.add(1);
        priorityQueue.add(0);
        priorityQueue.add(3);
        int k =0 ;
    }
}
