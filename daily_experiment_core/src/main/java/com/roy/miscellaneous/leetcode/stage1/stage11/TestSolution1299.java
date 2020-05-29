package com.roy.miscellaneous.leetcode.stage1.stage11;

import org.slf4j.LoggerFactory;

/**
 * @author guojun
 * @date 2020/5/13 15:08
 *
 *1299. 将每个元素替换为右侧最大元素
给你一个数组 arr ，请你将每个元素用它右边最大的元素替换，如果是最后一个元素，用 -1 替换。

完成所有替换操作后，请你返回这个数组。



示例：

输入：arr = [17,18,5,4,6,1]
输出：[18,6,6,6,1,-1]


提示：

1 <= arr.length <= 10^4
1 <= arr[i] <= 10^5
 *
 */
public class TestSolution1299 {
    private static final org.slf4j.Logger logger = LoggerFactory.getLogger(TestSolution1299.class);


    static class Solution {

        /**
         * 当上一次的最大数在当前数的右边时直接赋值，避免重新找
         * <p>
         * <p>
         * 执行结果：
         * 通过
         * 显示详情
         * 执行用时 :
         * 1 ms, 在所有 Java 提交中击败了100.00%的用户
         * 内存消耗 :41.2 MB, 在所有 Java 提交中击败了8.33%的用户
         *
         * @param arr
         * @return
         */
        public int[] replaceElements(int[] arr) {
            int len = arr.length;
            int maxIndex = -1;
            for (int i = 0; i < len; i++) {
                int val = arr[i];
                if (i == len - 1) {
                    arr[i] = -1;
                } else {
                    if (maxIndex > i) {
                        arr[i] = arr[maxIndex];
                        continue;
                    }
                    maxIndex = i + 1;
                    for (int j = i + 1; j < len; j++) {
                        if (arr[j] >= arr[maxIndex]) {
                            maxIndex = j;
                        }
                    }
                    arr[i] = arr[maxIndex];
                }
            }
            return arr;
        }
    }

    public static void main(String[] args) {
        logger.info("{}", new Solution().replaceElements(new int[]{1,2,3,4}));
    }
}
