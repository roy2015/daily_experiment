package com.guo.roy.research.leetcode.stage1.stage12;

import org.slf4j.LoggerFactory;

/**
 * @author guojun
 * @date 2020/5/25
 *
 *1360. 日期之间隔几天
请你编写一个程序来计算两个日期之间隔了多少天。

日期以字符串形式给出，格式为 YYYY-MM-DD，如示例所示。



示例 1：

输入：date1 = "2019-06-29", date2 = "2019-06-30"
输出：1
示例 2：

输入：date1 = "2020-01-15", date2 = "2019-12-31"
输出：15


提示：

给定的日期是 1971 年到 2100 年之间的有效日期。
 */
public class TestSolution1360 {
    private static final org.slf4j.Logger logger = LoggerFactory.getLogger(TestSolution1360.class);


    static class Solution {
        /**
         *
         *直接用jdk只带的，性能比较差
         *
         * 执行结果：
         通过
         显示详情
         执行用时 :33 ms
         , 在所有 Java 提交中击败了8.68%的用户
         内存消耗 :42 MB
         , 在所有 Java 提交中击败了
         100.00%的用户
         *
         * @param date1
         * @param date2
         * @return
         */
        public int daysBetweenDates(String date1, String date2) {
            java.text.SimpleDateFormat sdf = new java.text.SimpleDateFormat("yyyy-MM-dd");
            try {
                return (int) Math.abs((sdf.parse(date1).getTime() - sdf.parse(date2).getTime()) / (1000 * 3600 * 24));
            } catch (java.text.ParseException  e) {
                System.out.println(e.getMessage());
                return 0;
            }
        }

        /**
         *
         *
         * 纯手写
         *
         * 执行结果：
         通过
         显示详情
         执行用时 :1 ms, 在所有 Java 提交中击败了99.56%的用户
         内存消耗 :37.9 MB, 在所有 Java 提交中击败了100.00%的用户
         *
         * @param date1
         * @param date2
         * @return
         */
        public int daysBetweenDates1(String date1, String date2) {
            int year1,month1, day1;
            int year2, month2, day2;
            year1 = Integer.parseInt(date1.substring(0,4));
            year2 = Integer.parseInt(date2.substring(0,4));
            month1 = Integer.parseInt(date1.substring(5,7));
            month2 = Integer.parseInt(date2.substring(5,7));
            day1 = Integer.parseInt(date1.substring(8));
            day2 = Integer.parseInt(date2.substring(8));

            int yearGap = year1 - year2;
            int monthGap = month1 - month2;

            int bigYear;
            int smallYear;
            int bigMonth;
            int smallMonth;
            int bigDay;
            int smallDay;
            int days;

            if (yearGap == 0 && monthGap == 0) {//年月相同
                return Math.abs(day1 - day2);
            } else if (yearGap == 0 && monthGap != 0) {//年同月不同
                if (monthGap > 0) {
                    bigMonth = month1;
                    smallMonth = month2;
                    bigDay = day1;
                    smallDay = day2;
                } else {
                    bigMonth = month2;
                    smallMonth = month1;
                    bigDay = day2;
                    smallDay = day1;
                }
                boolean leapYear = isLeapYear(year1);
                //当月
                days = getDaysOfMonth( smallMonth,leapYear) - smallDay;
                //中间跨的月
                for (int i = smallMonth +1; i < bigMonth; i++) {
                    days += getDaysOfMonth( i,leapYear);
                }
                //大数的月
                days += bigDay;
            } else {//年不同
                if (yearGap > 0) {
                    bigYear = year1;
                    smallYear = year2;
                    bigMonth = month1;
                    smallMonth = month2;
                    bigDay = day1;
                    smallDay = day2;
                } else {
                    bigYear = year2;
                    smallYear = year1;
                    bigMonth = month2;
                    smallMonth = month1;
                    bigDay = day2;
                    smallDay = day1;
                }

                //先算小数的年剩余
                boolean leapYear = isLeapYear(smallYear);
                days = getDaysOfMonth( smallMonth,leapYear) - smallDay;
                for (int i = smallMonth + 1; i < 13; i++) {
                    days += getDaysOfMonth( i,leapYear);
                }
                //中间隔的年份
                for (int i = smallYear +1; i < bigYear; i ++) {
                    leapYear = isLeapYear(i);
                    days += getDaysOfYear(leapYear);
                }
                //大数当年的天数
                leapYear = isLeapYear(bigYear);
                for (int i = 1; i< bigMonth; i++ ) {
                    days += getDaysOfMonth(i, leapYear);
                }
                days += bigDay;
            }
            return days;
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

        /**
         * 返回年的天数
         * @param isLeepYear
         * @return
         */
        private int getDaysOfYear (boolean isLeepYear) {
            return isLeepYear ? 366 : 365;
        }

        /**
         * 计算当月的天数
         * @param month
         * @param isLeepYear
         * @return
         */
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
        logger.info("{}", new Solution().daysBetweenDates1("2020-01-15", "2019-12-31"));
        logger.info("{}", new Solution().daysBetweenDates1("2019-06-29", "2019-06-30"));
    }
}
