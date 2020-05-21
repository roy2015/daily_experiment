package com.roy.miscellaneous.leetcode.stage12;

import org.slf4j.LoggerFactory;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * @author guojun
 * @date 2020/5/20
 *
 * 面试题40. 最小的k个数
输入整数数组 arr ，找出其中最小的 k 个数。例如，输入4、5、1、6、2、7、3、8这8个数字，则最小的4个数字是1、2、3、4。



示例 1：

输入：arr = [3,2,1], k = 2
输出：[1,2] 或者 [2,1]
示例 2：

输入：arr = [0,1,2,1], k = 1
输出：[0]


限制：

0 <= k <= arr.length <= 10000
0 <= arr[i] <= 10000
 *
 */
public class TestSolutionInterview40 {
    private static final org.slf4j.Logger logger = LoggerFactory.getLogger(TestSolutionInterview40.class);


    static class Solution {

        /**
         *
         * 小顶堆
         *
         * 执行用时：20 ms
         内存消耗：41.5 MB
         *
         * @param arr
         * @param k
         * @return
         */
        public int[] getLeastNumbers(int[] arr, int k) {
            int len  = arr.length;
            PriorityQueue<Integer> heap = new PriorityQueue(len);

            for(int i = 0; i< len; i++) {
                heap.add(arr[i]);
            }
            int[] retArry = new int[k];
            int n = 0;
            for (int i = 0; i < k; i++) {
                retArry[n ++] = heap.poll();
            }
            return  retArry;
        }


        /**
         *
         * 大顶堆
         *
         * 执行结果：通过
         显示详情执行用时 :27 ms, 在所有 Java 提交中击败了22.29%的用户
         内存消耗 :41.1 MB, 在所有 Java 提交中击败了100.00%的用户

         * @param arr
         * @param k
         * @return
         */
        public int[] getLeastNumbers1(int[] arr, int k) {
            if (k ==0) {
                return new int[]{};
            }
            int len  = arr.length;
            //大顶堆
            PriorityQueue<Integer> heap = new PriorityQueue<Integer>((o1, o2) -> - o1.compareTo(o2));

            for(int i = 0; i< len; i++) {
                if (heap.size() < k) {
                    heap.add(arr[i]);
                    continue;
                }
                if (arr[i] < heap.peek()) {
                    heap.add(arr[i]);
                    heap.poll();
                }
            }
            int[] retArry = new int[k];
            int n = 0;
            for (int i = 0; i < k; i++) {
                retArry[n ++] = heap.poll();
            }
            return  retArry;
        }


        /**
         *
         * 直接选择排序， 321ms?
         *
         * 执行结果：
         通过
         显示详情
         执行用时 :321 ms, 在所有 Java 提交中击败了9.04%的用户
         内存消耗 :41.3 MB, 在所有 Java 提交中击败了100.00%的用户
         * @param arr
         * @param k
         * @return
         */
        public int[] getLeastNumbers2(int[] arr, int k) {
            if (k ==0) {
                return new int[]{};
            }
            int[] retArry = new int[k];
            int n = 0;
            for (int i =0 ; i < k; i++) {
                int minIdx = i;
                for (int j = i +1; j < arr.length; j++) {
                    if (arr[j] < arr[minIdx]) {
                        minIdx = j;
                    }
                }
                int tmp = arr[i];
                arr[i] = arr[minIdx];
                arr[minIdx] = tmp;
                retArry[n ++] = arr[i];
            }
            return retArry;
        }


        /**
         * 执行结果：通过
         显示详情
         执行用时 :8 ms, 在所有 Java 提交中击败了63.84%的用户
         内存消耗 :41.1 MB, 在所有 Java 提交中击败了100.00%的用户
         * @param arr
         * @param k
         * @return
         */
        public int[] getLeastNumbers3(int[] arr, int k) {
            if (k == 0) {
                return new int[]{};
            }
            Arrays.sort(arr);

            int[] retArry = new int[k];
            for (int i = 0; i < k; i++) {
                retArry[i] = arr[i];
            }
            return retArry;
        }

    }

    public static void main(String[] args) {
        logger.info("{}", new Solution().getLeastNumbers2(new int[]{3,2,1} ,2 ));// 1,2
        logger.info("{}", new Solution().getLeastNumbers2(new int[]{0,1,2,1} ,1 ));// 0

    }
}
