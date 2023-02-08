package com.roy.leetcode.stage1.stage12;

import org.slf4j.LoggerFactory;

/**
 * @author guojun
 * @date 2020/5/15
 * 860. 柠檬水找零
在柠檬水摊上，每一杯柠檬水的售价为 5 美元。

顾客排队购买你的产品，（按账单 bills 支付的顺序）一次购买一杯。

每位顾客只买一杯柠檬水，然后向你付 5 美元、10 美元或 20 美元。你必须给每个顾客正确找零，也就是说净交易是每位顾客向你支付 5 美元。

注意，一开始你手头没有任何零钱。

如果你能给每位顾客正确找零，返回 true ，否则返回 false 。

示例 1：

输入：[5,5,5,10,20]
输出：true
解释：
前 3 位顾客那里，我们按顺序收取 3 张 5 美元的钞票。
第 4 位顾客那里，我们收取一张 10 美元的钞票，并返还 5 美元。
第 5 位顾客那里，我们找还一张 10 美元的钞票和一张 5 美元的钞票。
由于所有客户都得到了正确的找零，所以我们输出 true。
示例 2：

输入：[5,5,10]
输出：true
示例 3：

输入：[10,10]
输出：false
示例 4：

输入：[5,5,10,10,20]
输出：false
解释：
前 2 位顾客那里，我们按顺序收取 2 张 5 美元的钞票。
对于接下来的 2 位顾客，我们收取一张 10 美元的钞票，然后返还 5 美元。
对于最后一位顾客，我们无法退回 15 美元，因为我们现在只有两张 10 美元的钞票。
由于不是每位顾客都得到了正确的找零，所以答案是 false。


提示：

0 <= bills.length <= 10000
bills[i] 不是 5 就是 10 或是 20
 */
public class TestSolution860 {
    private static final org.slf4j.Logger logger = LoggerFactory.getLogger(TestSolution860.class);


    static class Solution {

        /**
         *
         * 执行结果：通过
         * 显示详情
         执行用时 :3 ms, 在所有 Java 提交中击败了37.84%的用户
         内存消耗 :40.6 MB, 在所有 Java 提交中击败了16.67%的用户
         * @param bills
         * @return
         */
        public boolean lemonadeChange(int[] bills) {
            int[] buckets = new int[2];
            buckets[0] = 0;//5元桶
            buckets[1] = 0;//10元桶
            int price = 5;

            //bills[i] 不是 5 就是 10 或是 20
            for (int bill : bills) {
                int change = bill - price;//0, 5, 15
                switch (change) {
                    case 0://不找钱
                        buckets[0] ++;
                        break;
                    case 5://找5块收10块
                        if (buckets[0] >=1) {//一张5元
                            buckets[1] ++;
                            buckets[0] --;
                        } else {
                            return false;
                        }
                        break;
                    case 15://收20找15
                        if (buckets[1] >=1 && buckets[0] >=1) {//一张10元 + 一张5元
                            buckets[1] --;
                            buckets[0] --;
                        } else if (buckets[0] >=3 ) {//三张5元
                            buckets[0] = buckets[0] -3;
                        } else return false;
                        break;
                }
            }
            return true;
        }

        /**
         *
         * 同上，思路一模一样，除了不用数组，为什么要用数组，下标检索不需要时间么？？!，两个变量不就ok了？？
         *
         * 执行结果：
         通过
         显示详情执行用时 :2 ms, 在所有 Java 提交中击败了99.95%的用户
         内存消耗 :40.9 MB, 在所有 Java 提交中击败了8.33%的用户
         *
         * @param bills
         * @return
         */
        public boolean lemonadeChange1(int[] bills) {
            int five = 0;//5元桶
            int ten = 0;//10元桶
            int price = 5;

            //bills[i] 不是 5 就是 10 或是 20
            for (int bill : bills) {
                int change = bill - price;//0, 5, 15
                switch (change) {
                    case 0://不找钱
                        five ++;
                        break;
                    case 5://找5块收10块
                        if (five >=1) {//一张5元
                            ten ++;
                            five --;
                        } else {
                            return false;
                        }
                        break;
                    case 15://收20找15
                        if (ten >=1 && five >=1) {//一张10元 + 一张5元
                            ten --;
                            five --;
                        } else if (five >=3 ) {//三张5元
                            five = five -3;
                        } else return false;
                        break;
                }
            }
            return true;
        }




    }

    public static void main(String[] args) {
        logger.info("{}", new Solution().lemonadeChange1(new int[]{5,5,10}));//true
        logger.info("{}", new Solution().lemonadeChange1(new int[]{5,5,5,10,20}));//true
        logger.info("{}", new Solution().lemonadeChange1(new int[]{10,10}));//false
        logger.info("{}", new Solution().lemonadeChange1(new int[]{5,5,10,10,20}));//false
    }
}
