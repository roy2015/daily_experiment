package com.guo.roy.research.leetcode.stage2.stage20;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.LoggerFactory;

/**
 * @author guojun
 * @date 2021/1/4 上午11:34
 *
 * 969. 煎饼排序
 * 给定数组 A，我们可以对其进行煎饼翻转：我们选择一些正整数 k <= A.length，然后反转 A 的前 k 个元素的顺序。我们要执行零次或多次煎饼翻转（按顺序一次接一次地进行）以完成对数组 A 的排序。
 *
 * 返回能使 A 排序的煎饼翻转操作所对应的 k 值序列。任何将数组排序且翻转次数在 10 * A.length 范围内的有效答案都将被判断为正确。
 *
 *
 *
 * 示例 1：
 *
 * 输入：[3,2,4,1]
 * 输出：[4,2,4,3]
 * 解释：
 * 我们执行 4 次煎饼翻转，k 值分别为 4，2，4，和 3。
 * 初始状态 A = [3, 2, 4, 1]
 * 第一次翻转后 (k=4): A = [1, 4, 2, 3]
 * 第二次翻转后 (k=2): A = [4, 1, 2, 3]
 * 第三次翻转后 (k=4): A = [3, 2, 1, 4]
 * 第四次翻转后 (k=3): A = [1, 2, 3, 4]，此时已完成排序。
 * 示例 2：
 *
 * 输入：[1,2,3]
 * 输出：[]
 * 解释：
 * 输入已经排序，因此不需要翻转任何内容。
 * 请注意，其他可能的答案，如[3，3]，也将被接受。
 *
 *
 * 提示：
 *
 * 1 <= A.length <= 100
 * A[i] 是 [1, 2, ..., A.length] 的排列
 *
 */
public class TestSolution969 {

    private static final org.slf4j.Logger logger = LoggerFactory.getLogger(TestSolutionTemplate.class);


    static class Solution {
        /**
         *
         * 摊煎饼，从后往前，每次取最大的翻两次翻到该待的位置，可能不是最优的解法但比较通用
         *
         * 执行结果：
         * 通过
         * 显示详情
         * 执行用时：1 ms, 在所有 Java 提交中击败了100.00%的用户
         * 内存消耗：38.2 MB, 在所有 Java 提交中击败了97.82%的用户
         *
         *
         * @param arr
         * @return
         */
        public List<Integer> pancakeSort(int[] arr) {
            List<Integer> retList = new ArrayList<>();
            int length = arr.length;
            for (int processIdx = length -1; processIdx > 0 ; processIdx--) {
                //找 0 -> i里最大的元素
                int maxIdx = 0;
                int maxVal = arr[maxIdx];
                for (int i = 1; i <= processIdx; i++) {
                    if (arr[i] > maxVal ) {
                        maxIdx = i;
                        maxVal = arr[i];
                    }
                }
                if (maxIdx == processIdx) {
                    continue;
                }
                //翻转两次
                int sum = maxIdx;
                int midIdx = maxIdx /2;
                for (int i = 0; i <= midIdx; i++) {
                    int temp = arr[i];
                    arr[i] = arr[sum - i];
                    arr[sum - i] = temp;
                }
                retList.add (maxIdx + 1);

                sum = processIdx;
                midIdx = processIdx /2;
                for (int i = 0; i <= midIdx; i++) {
                    int temp = arr[i];
                    arr[i] = arr[sum - i];
                    arr[sum - i] = temp;
                }

                retList.add(processIdx + 1);
            }
            return retList;
        }
    }

    public static void main(String[] args) {
        logger.info("{}", new Solution().pancakeSort(new int[]{3,2,4,1}));
    }
}
