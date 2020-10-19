package com.roy.miscellaneous.leetcode.stage2.stage20;

import org.slf4j.LoggerFactory;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

/**
 * @author guojun
 * @date 2020/10/19 11:51
 *
 * 56. 合并区间
 * 给出一个区间的集合，请合并所有重叠的区间。
 *
 *
 *
 * 示例 1:
 *
 * 输入: intervals = [[1,3],[2,6],[8,10],[15,18]]
 * 输出: [[1,6],[8,10],[15,18]]
 * 解释: 区间 [1,3] 和 [2,6] 重叠, 将它们合并为 [1,6].
 * 示例 2:
 *
 * 输入: intervals = [[1,4],[4,5]]
 * 输出: [[1,5]]
 * 解释: 区间 [1,4] 和 [4,5] 可被视为重叠区间。
 * 注意：输入类型已于2019年4月15日更改。 请重置默认代码定义以获取新方法签名。
 *
 *
 *
 * 提示：
 *
 * intervals[i][0] <= intervals[i][1]
 */
public class TestSolution56 {
    private static final org.slf4j.Logger logger = LoggerFactory.getLogger(TestSolution56.class);


    static class Solution {

        /**
         * 感觉到了一个未知领域，数学里的集合问题，描述如下
         *  按每个元素的起始idx排序，最后得出列表A1，能合并区间的两个元素必是相邻的
         *
         *  和结果区间A2的最后一个元素比较
         *
         *  合并的情况
         *  1. A2的最后一个元素终止区间扩大
         *  2. 不相交，则新增一个元素
         *
         * 读懂了思路，代码自己写的
         *
         *  执行结果：
         * 通过
         * 显示详情
         * 执行用时：
         * 8 ms
         * , 在所有 Java 提交中击败了
         *
         * 61.07%
         *
         * 的用户
         * 内存消耗：
         * 40.9 MB
         * , 在所有 Java 提交中击败了
         *
         * 98.10%
         *
         * 的用户
         *
         *
         * @param intervals
         * @return
         */
        public int[][] merge(int[][] intervals) {
            if (intervals.length == 0) {
                return new int[][]{};
            }
            Arrays.sort(intervals, (o1, o2) -> o1[0] - o2[0]);

            List<int[]> lists = new ArrayList<>();
            int[] toAddEl =  new int[2];
            toAddEl[0] = intervals[0][0];
            toAddEl[1] = intervals[0][1];
            lists.add(toAddEl);

            int idx = 0;
            int[] last;
            for (int[] interval : intervals) {
                    last = lists.get(lists.size() -1);
                    int last0 = last[0];
                    int last1 = last[1];

                    int curr0 = interval[0];
                    int curr1 = interval[1];
                    if (curr0 <= last1) {
                        last[1] = Math.max(last1, curr1);
                    } else {
                        idx ++;
                        toAddEl =  new int[]{curr0, curr1};
                        lists.add(toAddEl);
                    }
            }

            int retLen = lists.size();
            int[][] retInts = new int[retLen][2];

            for (int i = 0; i < lists.size(); i++) {
                retInts[i] = lists.get(i);
            }
            return retInts;
        }

    }

    public static void main(String[] args) {
        int[][] merge;
        merge = new Solution().merge(new int[][]{
                {8, 10}, {15, 18}, {1, 3}, {2, 6}
        });//[[1,6],[8,10],[15,18]]

        merge = new Solution().merge(new int[][]{
                {1, 4}, {4, 5}
        });//[1,5]

        logger.info("{}");
    }
}
