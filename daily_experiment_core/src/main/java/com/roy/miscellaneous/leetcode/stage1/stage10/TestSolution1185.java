package com.roy.miscellaneous.leetcode.stage1.stage10;

import org.slf4j.LoggerFactory;

/**
 * Created by apple on 2019/10/20.
 *
 *
 */
public class TestSolution1185 {
    private static final org.slf4j.Logger logger = LoggerFactory.getLogger(TestSolution1185.class);

    /**
     *
     *
     * 执行用时 :0 ms, 在所有 java 提交中击败了100.00%的用户
     * 内存消耗 :33.8 MB, 在所有 java 提交中击败了100.00%的用户
     *
     * 1971-01-01 星期五
     */
    static class Solution {
        public String dayOfTheWeek(int day, int month, int year) {
            int days = 0;
            String[] daysOfWeek = {"Sunday", "Monday", "Tuesday",
                    "Wednesday", "Thursday", "Friday", "Saturday"};

            //整年的天数
            for (int i = 1971; i < year ; i++) {
                if (isLeapYear(i)) {
                    days += 366;
                } else days += 365;
            }

            //当年的天数
            for (int i =1; i< month; i++ ) {
                days += getDaysOfMonth(i, isLeapYear(year));
            }

            //当月的天数
            days += day -1;
            return daysOfWeek[ (days % 7 + 5) % 7];

        }

        /**
         * 判定是否闰年
         * @param year
         * @return
         */
        private boolean isLeapYear (int year) {
            if (year % 4 !=0) {
                return false;
            } else {
                if (year % 100 == 0 && (year % 400 != 0)) {
                    return false;
                }
                return true;
            }
        }

        private int getDaysOfMonth (int month, boolean isLeepYear) {
            switch (month) {
                case 1: return 31;
                case 2: return isLeepYear ? 29 : 28;
                case 3: return 31;
                case 4: return 30;
                case 5: return 31;
                case 6: return 30;
                case 7: return 31;
                case 8: return 31;
                case 9: return 30;
                case 10:return 31;
                case 11:return 30;
                case 12:return 31;
                default: return 0;
            }
        }
    }

    public static void main(String[] args) {
        logger.info("{}", new Solution().dayOfTheWeek(20, 10, 2019));
    }

}
