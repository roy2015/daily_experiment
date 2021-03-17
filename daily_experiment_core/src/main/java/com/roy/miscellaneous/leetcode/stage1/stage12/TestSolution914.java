package com.roy.miscellaneous.leetcode.stage1.stage12;

import java.util.Arrays;

import org.slf4j.LoggerFactory;

/**
 * @author guojun
 * @date 2020/5/21
 *
 * 914. 卡牌分组
给定一副牌，每张牌上都写着一个整数。

此时，你需要选定一个数字 X，使我们可以将整副牌按下述规则分成 1 组或更多组：

每组都有 X 张牌。
组内所有的牌上都写着相同的整数。
仅当你可选的 X >= 2 时返回 true。



示例 1：

输入：[1,2,3,4,4,3,2,1]
输出：true
解释：可行的分组是 [1,1]，[2,2]，[3,3]，[4,4]
示例 2：

输入：[1,1,1,2,2,2,3,3]
输出：false
解释：没有满足要求的分组。
示例 3：

输入：[1]
输出：false
解释：没有满足要求的分组。
示例 4：

输入：[1,1]
输出：true
解释：可行的分组是 [1,1]
示例 5：

输入：[1,1,2,2,2,2]
输出：true
解释：可行的分组是 [1,1]，[2,2]，[2,2]

提示：

1 <= deck.length <= 10000
0 <= deck[i] < 10000
 */
public class TestSolution914 {
    private static final org.slf4j.Logger logger = LoggerFactory.getLogger(TestSolution914.class);


    static class Solution {

        /**
         *
         * 11 22 22 和 11 11 22 比较恶心，还能大拆小， 还要用到最大公约数
         *
         *
         * 执行结果：
         通过
         显示详情
         执行用时 :3 ms, 在所有 Java 提交中击败了94.24%的用户
         内存消耗 :40.3 MB, 在所有 Java 提交中击败了33.33%的用户
         *
         * @param deck
         * @return
         */
        public boolean hasGroupsSizeX(int[] deck) {
            int length = deck.length;
            if (length == 1) {
                return false;
            }
            Arrays.sort(deck);
            //start
            int baseNum = 0;//基准数量
            int p =0 ;
            int onceNum;
            while (p < length) {
                onceNum = 1;
                int onceBaseVal = deck[p];
                int q;
                for (q = p + 1 ; q < length; q++) {
                    if (deck[q] != onceBaseVal  ) {
                        break;
                    } else {
                        onceNum ++;
                        /*if (baseNum !=0 && onceNum > baseNum) {
                            return false;
                        }*/
                    }
                }
                if (baseNum == 0) {//第一次
                    baseNum = q - p;
                }
                if (baseNum == 1 ) {
                    return false;
                } else if (baseNum != onceNum) {
                    int gys = getGYS(baseNum, onceNum);
                    if (gys == 1) {
                        return false;
                    } else {
                        baseNum = gys;
                    }
                }
                p = q;
            }//end while
            return baseNum < 2 ? false: true;
        }

        /**
         *
         * 枚举法求最大公约数
         *
         * 求最大公约数, a,b 均大于1
         * @param a
         * @param b
         * @return
         */
        private int getGYS(int a, int b) {
            int ret = 1;

            int min = Math.min(a, b);
            for (int i = 2; i<= min; i ++) {
               if (a % i == 0 && b % i == 0) {
                    ret = i;
               }
            }
            return ret;
        }

        /**
         * 辗转相除法求最大公约数 （网上copy的, 比上面手写的效率高）
         * @param num1
         * @param num2
         * @return
         */
        private int getGYS1(int num1, int num2) {
            // 先获得绝对值，保证负数也可以求
            num1 = Math.abs(num1);
            num2 = Math.abs(num2);
            // 先求余数，假定第一个数较大；如果第二个较大，在第二轮调用时会颠倒过来
            int remainder = num1 % num2;
            // 如果为 0，则直接得出
            if (remainder == 0) {
                return num2;
            }
            // 递归调用
            return getGYS1(num2, remainder);
        }
    }

    public static void main(String[] args) {
        logger.info("{}", new Solution().hasGroupsSizeX(new int[]{1,1,1,1,2,2,2,2,2,2}));// true
        logger.info("{}", new Solution().hasGroupsSizeX(new int[]{1,1,2,2,2,2}));//  true
        logger.info("{}", new Solution().hasGroupsSizeX(new int[]{1,2,3,4,4,3,2,1}));//11 22 33 44  true
        logger.info("{}", new Solution().hasGroupsSizeX(new int[]{1}));//false
        logger.info("{}", new Solution().hasGroupsSizeX(new int[]{1,2,3}));//false
        logger.info("{}", new Solution().hasGroupsSizeX(new int[]{1,1,1,2,2,2,3,3}));//false
        logger.info("{}", new Solution().hasGroupsSizeX(new int[]{1,1}));//true
        logger.info("{}", new Solution().hasGroupsSizeX(new int[]{2,2,2,2,1,1}));//true


    }
}
