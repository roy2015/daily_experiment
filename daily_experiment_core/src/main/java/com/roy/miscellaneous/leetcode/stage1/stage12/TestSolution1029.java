package com.roy.miscellaneous.leetcode.stage1.stage12;

import org.slf4j.LoggerFactory;

import java.util.*;

/**
 * @author guojun
 * @date 2020/5/25
 *
 *
 * 1029. 两地调度
公司计划面试 2N 人。第 i 人飞往 A 市的费用为 costs[i][0]，飞往 B 市的费用为 costs[i][1]。

返回将每个人都飞到某座城市的最低费用，要求每个城市都有 N 人抵达。



示例：

输入：[[10,20],[30,200],[400,50],[30,20]]
输出：110
解释：
第一个人去 A 市，费用为 10。
第二个人去 A 市，费用为 30。
第三个人去 B 市，费用为 50。
第四个人去 B 市，费用为 20。

最低总费用为 10 + 30 + 50 + 20 = 110，每个城市都有一半的人在面试。


提示：

1 <= costs.length <= 100
costs.length 为偶数
1 <= costs[i][0], costs[i][1] <= 1000
 */
public class TestSolution1029 {
    private static final org.slf4j.Logger logger = LoggerFactory.getLogger(TestSolution1029.class);


    static class Solution {

        /**
         *
         * 思路是参考的，有点不好理解
         *
         * 执行结果：
         通过
         显示详情
         执行用时 :
         4 ms, 在所有 Java 提交中击败了7.35%的用户
         内存消耗 :
         39 MB, 在所有 Java 提交中击败了66.67%的用户
         *
         * @param costs
         * @return
         */
        public int twoCitySchedCost(int[][] costs) {
            List<List<Integer>> lists = new ArrayList<List<Integer>>();
            for (int[] cost : costs) {
                List<Integer> subList = new ArrayList<>();
                subList.add(cost[0]);
                subList.add(cost[1]);
                lists.add(subList);
            }
            Collections.sort(lists, (o1, o2) -> {
                int acostGa1 = o1.get(0) - o1.get(1);
                int acostGap2 = o2.get(0) - o2.get(1);
                return acostGa1 - acostGap2;
            });

            int len = costs.length;
            int cost = 0;
            for (int i = 0; i < len /2; i++) {
                List<Integer> iVal = lists.get(i);
                List<Integer> iLVal = lists.get(i + len /2);

                cost += iVal.get(0) + iLVal.get(1) ;
            }
            return cost;
        }
    }

    public static void main(String[] args) {
        logger.info("{}", new Solution().twoCitySchedCost(new int[][]{
                {10,20},{30,200},{400,50},{30,20}

        }));
    }
}
