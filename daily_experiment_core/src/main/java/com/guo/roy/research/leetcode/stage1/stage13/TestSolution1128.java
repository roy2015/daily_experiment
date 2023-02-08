package com.guo.roy.research.leetcode.stage1.stage13;

import java.util.HashMap;
import java.util.Map;

import org.slf4j.LoggerFactory;

/**
 * @author guojun
 * @date 2020/7/15
 *
 * 1128. 等价多米诺骨牌对的数量
 * 给你一个由一些多米诺骨牌组成的列表 dominoes。
 *
 * 如果其中某一张多米诺骨牌可以通过旋转 0 度或 180 度得到另一张多米诺骨牌，我们就认为这两张牌是等价的。
 *
 * 形式上，dominoes[i] = [a, b] 和 dominoes[j] = [c, d] 等价的前提是 a==c 且 b==d，或是 a==d 且 b==c。
 *
 * 在 0 <= i < j < dominoes.length 的前提下，找出满足 dominoes[i] 和 dominoes[j] 等价的骨牌对 (i, j) 的数量。
 *
 *
 *
 * 示例：
 *
 * 输入：dominoes = [[1,2],[2,1],[3,4],[5,6]]
 * 输出：1
 *
 *
 * 提示：
 *
 * 1 <= dominoes.length <= 40000
 * 1 <= dominoes[i][j] <= 9
 *
 */
public class TestSolution1128 {
    private static final org.slf4j.Logger logger = LoggerFactory.getLogger(TestSolution1128.class);


    /**
     * 有个前提条件可以用：  1 <= dominoes[i][j] <= 9
     */
    static class Solution {
        /**
         *
         * 用了数学中排列组合公式, todo 还可以优化吧
         *
         * 执行结果：
         * 通过
         * 显示详情
         * 执行用时：
         * 11 ms, 在所有 Java 提交中击败了28.21%的用户
         * 内存消耗：
         * 48.9 MB, 在所有 Java 提交中击败了100.00%的用户
         *
         *
         * @param dominoes
         * @return
         */
        public int numEquivDominoPairs(int[][] dominoes) {
            Map<Integer, Integer> map = new HashMap<>();

            for (int[] dominoe : dominoes) {
                int val0 = dominoe[0];
                int val1 = dominoe[1];

                int frontVal = val0 * 10 + val1;
                int reverseVal = val1 * 10 + val0;

                /*Integer front = map.get(frontVal);
                if (front == null) {
                    Integer reverse = map.get(reverseVal);
                    if (reverse == null) {
                        map.put(frontVal , new Integer(1));
                    } else {
                        map.put(reverseVal , reverse.intValue() +1);
                    }
                } else {
                    map.put(frontVal , front.intValue() + 1);
                }*/

                map.compute(frontVal, (key, oldVal) -> {
                    if (oldVal == null) {
                        Integer reverse = map.get(reverseVal);
                        if (reverse != null) {
                            map.put(reverseVal,new Integer(reverse.intValue() +1) );
                            return null;
                        } else {
                            return new Integer(1);
                        }
                    } else {
                        return new Integer(oldVal.intValue() +1);
                    }
                });
            }


            int retPairs = 0;
            for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
                Integer value = entry.getValue();
                if (value > 1) {
                    retPairs += calCombination(value, 2) ;
                }
            }
            return retPairs;
        }

        /**
         * 组合（combination）公式  C(n, k) =  n!/((n-k)!k!)
         * 只计算值没有详情
         *
         * @param n
         * @param k
         * @return
         */
        public int calCombination(int n ,int k) {
            int a = 1, b =1;
            int i1 = n - k + 1;
            //p(n,k)
            for (int i = n; i >= i1 ; i--) {
                a *= i;
            }
            // p(k,k)
            for (int i = k; i >=1 ; i--) {
                b *= i;
            }
            return a /b;

        }

    }

    public static void main(String[] args) {
        //测试下排列组合公式
        logger.info("{}", new Solution().calCombination(5, 3));//10
        logger.info("{}", new Solution().numEquivDominoPairs(new int[][]{
                {1,2},{2,1},{3,4},{5,6}}));//1
    }
}
