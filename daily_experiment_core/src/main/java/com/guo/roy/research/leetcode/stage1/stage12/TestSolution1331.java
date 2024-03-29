package com.guo.roy.research.leetcode.stage1.stage12;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

import org.slf4j.LoggerFactory;

/**
 * @author guojun
 * @date 2020/1/24
 *
 * 给你一个整数数组 arr ，请你将数组中的每个元素替换为它们排序后的序号。

序号代表了一个元素有多大。序号编号的规则如下：

序号从 1 开始编号。
一个元素越大，那么序号越大。如果两个元素相等，那么它们的序号相同。
每个数字的序号都应该尽可能地小。
 

示例 1：

输入：arr = [40,10,20,30]
输出：[4,1,2,3]
解释：40 是最大的元素。 10 是最小的元素。 20 是第二小的数字。 30 是第三小的数字。
示例 2：

输入：arr = [100,100,100]
输出：[1,1,1]
解释：所有元素有相同的序号。
示例 3：

输入：arr = [37,12,28,9,100,56,80,5,12]
输出：[5,3,4,2,8,6,7,1,3]
 

提示：

0 <= arr.length <= 105
-109 <= arr[i] <= 109

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/rank-transform-of-an-array
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class TestSolution1331 {
    private static final org.slf4j.Logger logger = LoggerFactory.getLogger(TestSolution1331.class);


    static class Solution {
        private int rank;


        /**
         *
         * 执行结果：
         通过
         显示详情
         执行用时 :30 ms, 在所有 Java 提交中击败了61.82%
         的用户
         内存消耗 :56 MB, 在所有 Java 提交中击败了100.00%
         的用户
         * @param arr
         * @return
         */
        public int[] arrayRankTransform(int[] arr) {
            int len = arr.length;
            int[] newArr = new int[len];
            int k = 0;
            for (int num : arr) {
                newArr[k++] = num;
            }
            Arrays.sort(newArr);
            Map<Integer, Integer> rankMap = new HashMap<>();
            for (int i : newArr) {
                rankMap.compute(i, (integer, old) -> {
                    if (old == null) {
                        rank++;
                        return rank ;
                    } else {
                        return rank;
                    }
                });
            }

            for (int i = 0; i < len; i++) {
                arr[i] = rankMap.get(arr[i]);
            }
            return arr;
        }
    }

    public static void main(String[] args) {
        logger.info("{}", new Solution().arrayRankTransform(new int[]{40,10,20,30}));
        logger.info("{}", new Solution().arrayRankTransform(new int[]{100,100,100}));
    }
}
