package com.roy.miscellaneous.leetcode.stage1.stage10;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.LoggerFactory;

/**
 * @author guojun
 * @date 2020/4/27 18:30
 *
 *
 * 682. 棒球比赛
 * 你现在是棒球比赛记录员。
 * 给定一个字符串列表，每个字符串可以是以下四种类型之一：
 * 1.整数（一轮的得分）：直接表示您在本轮中获得的积分数。
 * 2. "+"（一轮的得分）：表示本轮获得的得分是前两轮有效 回合得分的总和。
 * 3. "D"（一轮的得分）：表示本轮获得的得分是前一轮有效 回合得分的两倍。
 * 4. "C"（一个操作，这不是一个回合的分数）：表示您获得的最后一个有效 回合的分数是无效的，应该被移除。
 *
 * 每一轮的操作都是永久性的，可能会对前一轮和后一轮产生影响。
 * 你需要返回你在所有回合中得分的总和。
 *
 * 示例 1:
 *
 * 输入: ["5","2","C","D","+"]
 * 输出: 30
 * 解释:
 * 第1轮：你可以得到5分。总和是：5。
 * 第2轮：你可以得到2分。总和是：7。
 * 操作1：第2轮的数据无效。总和是：5。
 * 第3轮：你可以得到10分（第2轮的数据已被删除）。总数是：15。
 * 第4轮：你可以得到5 + 10 = 15分。总数是：30。
 * 示例 2:
 *
 * 输入: ["5","-2","4","C","D","9","+","+"]
 * 输出: 27
 * 解释:
 * 第1轮：你可以得到5分。总和是：5。
 * 第2轮：你可以得到-2分。总数是：3。
 * 第3轮：你可以得到4分。总和是：7。
 * 操作1：第3轮的数据无效。总数是：3。
 * 第4轮：你可以得到-4分（第三轮的数据已被删除）。总和是：-1。
 * 第5轮：你可以得到9分。总数是：8。
 * 第6轮：你可以得到-4 + 9 = 5分。总数是13。
 * 第7轮：你可以得到9 + 5 = 14分。总数是27。
 * 注意：
 *
 * 输入列表的大小将介于1和1000之间。
 * 列表中的每个整数都将介于-30000和30000之间。
 *
 */
public class TestSolution682 {
    private static final org.slf4j.Logger logger = LoggerFactory.getLogger(TestSolution682.class);


    static class Solution {

        /**
         *
         * what? 5.49%
         * 排除了Cancel, remove造成了许多复杂度，并且太多的parseInt
         * 基于以上 两点，思考出calPoints1, 不用排除Cancel, parseInt只会在一种情况下使用
         *
         * 执行结果：
         * 通过
         * 显示详情
         * 执行用时 :11 ms, 在所有 Java 提交中击败了5.49%的用户
         * 内存消耗 :38.9 MB, 在所有 Java 提交中击败了25.00%的用户
         * @param ops
         * @return
         */
        public int calPoints(String[] ops) {
            List<String> opsList = new ArrayList<>();
            for (String op : ops) {
                if ("C".equalsIgnoreCase(op)) {
                    opsList.remove(opsList.size() -1);
                } else {
                    opsList.add(op);
                }
            }

            String[] filterOpsArray = new String[opsList.size()];
            opsList.toArray (filterOpsArray);
            int sumPoints =0;
            int roundPoints = 0;
            for (int i = 0; i < filterOpsArray.length; i++) {
                String op = filterOpsArray[i];
                if ("+".equalsIgnoreCase(op)) {
                    roundPoints = Integer.parseInt(filterOpsArray[i -2])
                            + Integer.parseInt(filterOpsArray[i - 1]);
                    filterOpsArray[i] = roundPoints + "";
                } else if ("D".equalsIgnoreCase(op)) {
                    roundPoints = Integer.parseInt(filterOpsArray[i -1 ]) * 2;
                    filterOpsArray[i] = roundPoints + "";
                } else {
                    roundPoints = Integer.parseInt(filterOpsArray[i ]);
                }
                sumPoints += roundPoints;
            }
            return sumPoints;
        }

        /**
         *
         *  用了一个辅助数组， o(n)复杂度
         * 执行结果：
         * 通过
         * 显示详情
         * 执行用时 :2 ms, 在所有 Java 提交中击败了95.45%的用户
         * 内存消耗 :37.9 MB, 在所有 Java 提交中击败了25.00%的用户
         * @param ops
         * @return
         */
        public int calPoints1(String[] ops) {
            int sumPoints =0;
            int roundPoints = 0;

            int [] retInts =  new int[ops.length];
            int k =0;

            for (int i = 0; i < ops.length; i++) {
                String op = ops[i];
                if ("C".equalsIgnoreCase(op)) {
                    k --;
                    sumPoints -= retInts[k];
                } else if ("D".equalsIgnoreCase(op)) {
                    roundPoints = retInts[k -1 ] * 2;
                    retInts[k] = roundPoints;
                    sumPoints += roundPoints;
                    k ++;
                } else if ("+".equalsIgnoreCase(op)) {
                    roundPoints = retInts[k -1 ] + retInts[k -2 ];
                    retInts[k] = roundPoints;
                    sumPoints += roundPoints;
                    k ++;
                } else {
                    roundPoints = Integer.parseInt(ops[i ]);
                    retInts[k ++ ] = roundPoints;
                    sumPoints += roundPoints;
                }
            }
            return sumPoints;
        }
    }

    public static void main(String[] args) {
        logger.info("{}" , new Solution().calPoints1(new String[]{"5","-2","4","C","D","9","+","+"}));
    }
}
