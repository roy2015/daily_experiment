package com.guo.roy.research.leetcode.stage2.stage21;

import org.slf4j.LoggerFactory;

/**
 * @author guojun
 * @date 2020/6/17
 *
 * 904. 水果成篮
 * 在一排树中，第 i 棵树产生 tree[i] 型的水果。
 * 你可以从你选择的任何树开始，然后重复执行以下步骤：
 *
 * 把这棵树上的水果放进你的篮子里。如果你做不到，就停下来。
 * 移动到当前树右侧的下一棵树。如果右边没有树，就停下来。
 * 请注意，在选择一颗树后，你没有任何选择：你必须执行步骤 1，然后执行步骤 2，然后返回步骤 1，然后执行步骤 2，依此类推，直至停止。
 *
 * 你有两个篮子，每个篮子可以携带任何数量的水果，但你希望每个篮子只携带一种类型的水果。
 * 用这个程序你能收集的水果总量是多少？
 *
 *
 *
 * 示例 1：
 *
 * 输入：[1,2,1]
 * 输出：3
 * 解释：我们可以收集 [1,2,1]。
 * 示例 2：
 *
 * 输入：[0,1,2,2]
 * 输出：3
 * 解释：我们可以收集 [1,2,2].
 * 如果我们从第一棵树开始，我们将只能收集到 [0, 1]。
 * 示例 3：
 *
 * 输入：[1,2,3,2,2]
 * 输出：4
 * 解释：我们可以收集 [2,3,2,2].
 * 如果我们从第一棵树开始，我们将只能收集到 [1, 2]。
 * 示例 4：
 *
 * 输入：[3,3,3,1,2,1,1,2,3,3,4]
 * 输出：5
 * 解释：我们可以收集 [1,2,1,1,2].
 * 如果我们从第一棵树或第八棵树开始，我们将只能收集到 4 个水果。
 *
 *
 * 提示：
 *
 * 1 <= tree.length <= 40000
 * 0 <= tree[i] < tree.length
 *
 */
public class TestSolution904 {
    private static final org.slf4j.Logger logger = LoggerFactory.getLogger(TestSolution904.class);


    static class Solution {
        /**
         *
         * 关键要理解题意 ，两种情况下都要停下来 1. 篮子放不下去  2. 最后一棵树
         *
         * 执行结果：
         * 通过
         * 显示详情
         * 执行用时 :18 ms, 在所有 Java 提交中击败了54.56%的用户
         * 内存消耗 :47.5 MB, 在所有 Java 提交中击败了100.00%的用户
         *
         * @param tree
         * @return
         */
        public int totalFruit(int[] tree) {

            int total;
            int maxTotal = 1;
            int basket1Val;
            int basket2Val;
            int length = tree.length;

            for (int i = 0; i < length - 1; i++) {
                basket2Val = -1;
                int iVal = tree[i];
                basket1Val = iVal;//直接放到第一个篮子
                total = 1;
                if (i + maxTotal >= length) {//已经无法超越maxTotal, return
                    return maxTotal;
                }
                for (int j = i + 1; j < length ; j++) {
                    int jVal = tree[j];
                    if (basket2Val != -1) {//第二个篮子不空
                        if (jVal == basket1Val || jVal == basket2Val) {
                            total ++;
                        } else {//放不了，break
                            break;
                        }
                    } else {//第二个篮子空
                        if (jVal != basket1Val) {
                            basket2Val = jVal;
                        } else {}
                        total ++;
                    }
                }
                if (total > maxTotal) {
                    maxTotal = total;
                }
            }
            return maxTotal;
        }
    }

    public static void main(String[] args) {
        logger.info("{}", 123);
        logger.info("{}", new Solution().totalFruit(new int[]{1,2,1}));//3
        logger.info("{}", new Solution().totalFruit(new int[]{0,1,2,2}));//3
        logger.info("{}", new Solution().totalFruit(new int[]{1,2,3,2,2}));//4
        logger.info("{}", new Solution().totalFruit(new int[]{3,3,3,1,2,1,1,2,3,3,4}));//5

    }
}
