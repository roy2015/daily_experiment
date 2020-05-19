package com.roy.miscellaneous.leetcode.stage12;

import org.slf4j.LoggerFactory;

import java.util.*;
import java.util.function.BiFunction;

/**
 * @author guojun
 * @date 2020/5/19
 *
 * 599. 两个列表的最小索引总和
假设Andy和Doris想在晚餐时选择一家餐厅，并且他们都有一个表示最喜爱餐厅的列表，每个餐厅的名字用字符串表示。

你需要帮助他们用最少的索引和找出他们共同喜爱的餐厅。 如果答案不止一个，则输出所有答案并且不考虑顺序。 你可以假设总是存在一个答案。

示例 1:

输入:
["Shogun", "Tapioca Express", "Burger King", "KFC"]
["Piatti", "The Grill at Torrey Pines", "Hungry Hunter Steakhouse", "Shogun"]
输出: ["Shogun"]
解释: 他们唯一共同喜爱的餐厅是“Shogun”。
示例 2:

输入:
["Shogun", "Tapioca Express", "Burger King", "KFC"]
["KFC", "Shogun", "Burger King"]
输出: ["Shogun"]
解释: 他们共同喜爱且具有最小索引和的餐厅是“Shogun”，它有最小的索引和1(0+1)。
提示:

两个列表的长度范围都在 [1, 1000]内。
两个列表中的字符串的长度将在[1，30]的范围内。
下标从0开始，到列表的长度减1。
两个列表都没有重复的元素。
 *
 */
public class TestSolution599 {
    private static final org.slf4j.Logger logger = LoggerFactory.getLogger(TestSolution599.class);


    static class Solution {

        /**
         *
         *
         * 执行结果：通过显示详情
         执行用时 :10 ms, 在所有 Java 提交中击败了87.67%的用户
         内存消耗 :40.5 MB, 在所有 Java 提交中击败了10.00%的用户
         * @param list1
         * @param list2
         * @return
         */
        public String[] findRestaurant(String[] list1, String[] list2) {
            List<String> retList = new ArrayList<>();
            Map<String, Integer> map1 = new HashMap<>();
            int minSumIdx = 2000;
            for (int i =0 ; i< list1.length; i++) {
                map1.put(list1[i], i);
            }
            for (int i =0 ; i< list2.length; i++) {
                final  int copyI = i;
                String s1 = list2[i];
                if (map1.containsKey(s1)) {
                    int old = map1.get(s1);
                    int sumIdx = old + copyI;
                    if (sumIdx < minSumIdx) {
                        minSumIdx = sumIdx;
                        retList.clear();
                        retList.add(s1);
                    } else if (sumIdx == minSumIdx) {
                        retList.add(s1);
                    }
                }
            }
            String[] retStrings = new String[retList.size()];
            return retList.toArray(retStrings);
        }
    }

    public static void main(String[] args) {
        logger.info("{}", new Solution().findRestaurant(
                new String[]{"Shogun","Tapioca Express","Burger King","KFC"},
                new String[]{"KFC","Shogun","Burger King"}));
    }
}
