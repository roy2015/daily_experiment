package com.roy.miscellaneous.leetcode.stage1.stage11;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.slf4j.LoggerFactory;

/**
 * @author guojun
 * @date 2020/5/5 21:34
 *
 * 1436. 旅行终点站
 * 给你一份旅游线路图，该线路图中的旅行线路用数组 paths 表示，其中 paths[i] = [cityAi, cityBi] 表示该线路将会从 cityAi 直接前往 cityBi 。请你找出这次旅行的终点站，即没有任何可以通往其他城市的线路的城市。
 *
 * 题目数据保证线路图会形成一条不存在循环的线路，因此只会有一个旅行终点站。
 *
 *
 *
 * 示例 1：
 *
 * 输入：paths = [["London","New York"],["New York","Lima"],["Lima","Sao Paulo"]]
 * 输出："Sao Paulo"
 * 解释：从 "London" 出发，最后抵达终点站 "Sao Paulo" 。本次旅行的路线是 "London" -> "New York" -> "Lima" -> "Sao Paulo" 。
 * 示例 2：
 *
 * 输入：paths = [["B","C"],["D","B"],["C","A"]]
 * 输出："A"
 * 解释：所有可能的线路是：
 * "D" -> "B" -> "C" -> "A".
 * "B" -> "C" -> "A".
 * "C" -> "A".
 * "A".
 * 显然，旅行终点站是 "A" 。
 * 示例 3：
 *
 * 输入：paths = [["A","Z"]]
 * 输出："Z"
 *
 *
 * 提示：
 *
 * 1 <= paths.length <= 100
 * paths[i].length == 2
 * 1 <= cityAi.length, cityBi.length <= 10
 * cityAi != cityBi
 * 所有字符串均由大小写英文字母和空格字符组成。
 */
public class TestSolution1436 {
    private static final org.slf4j.Logger logger = LoggerFactory.getLogger(TestSolution1436.class);


    static class Solution {
        /**
         *
         * 用的map映射 每条路线
         *
         * 执行结果：
         * 通过
         * 显示详情
         * 执行用时 :3 ms, 在所有 Java 提交中击败了100.00%的用户
         * 内存消耗 :39.7 MB, 在所有 Java 提交中击败了100.00%的用户
         * @param paths
         * @return
         */
        public String destCity(List<List<String>> paths) {
            Map<String, String> map = new HashMap();
            int len = paths.size();
            for(int i =0; i< len ; i++) {
                map.put(paths.get(i).get(0),paths.get(i).get(1));
            }

            String key = paths.get(0).get(0);
            String val = paths.get(0).get(1);
            while (val != null) {
                key = val;
                val = map.get(key);
            }

            return key;

        }
    }

    public static void main(String[] args) {
        List<List<String>> lists = new ArrayList<>();
        List<String> list1 = new ArrayList<>();
        List<String> list2 = new ArrayList<>();
        List<String> list3 = new ArrayList<>();

        list1.add("London");
        list1.add("New York");
        list2.add("New York");
        list2.add("Lima");
        list3.add("Lima");
        list3.add("Sao Paulo");

        lists.add(list1);
        lists.add(list2);
        lists.add(list3);

        logger.info("{}", new Solution().destCity(lists));
    }
}
