package com.roy.miscellaneous.leetcode.stage1.stage10;

import org.slf4j.LoggerFactory;

/**
 * Created by apple on 2019/11/12.
 *给你一个按 YYYY-MM-DD 格式表示日期的字符串 date，请你计算并返回该日期是当年的第几天。

 通常情况下，我们认为 1 月 1 日是每年的第 1 天，1 月 2 日是每年的第 2 天，依此类推。每个月的天数与现行公元纪年法（格里高利历）一致。

  

 示例 1：

 输入：date = "2019-01-09"
 输出：9
 示例 2：

 输入：date = "2019-02-10"
 输出：41
 示例 3：

 输入：date = "2003-03-01"
 输出：60
 示例 4：

 输入：date = "2004-03-01"
 输出：61
  

 提示：

 date.length == 10
 date[4] == date[7] == '-'，其他的 date[i] 都是数字。
 date 表示的范围从 1900 年 1 月 1 日至 2019 年 12 月 31 日。

 来源：力扣（LeetCode）
 链接：https://leetcode-cn.com/problems/day-of-the-year
 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 */
public class TestSolution1154 {
    private static final org.slf4j.Logger logger = LoggerFactory.getLogger(TestSolution1154.class);

    /**
     */
    static class Solution {

        /**
         *
         * 总结：正则性能差 String.split,用了之后要3ms，换成直接subString就可以了
         *
         * 执行用时 :1 ms, 在所有 java 提交中击败了100.00%的用户
         内存消耗 :34.3 MB, 在所有 java 提交中击败了100.00%的用户
         *
         * @param date
         * @return
         */
        public int dayOfYear(String date) {
            /*
            String[] strings = date.split("-");
            int year = Integer.parseInt(strings[0]);
            int month = Integer.parseInt(strings[1]);
            int day = Integer.parseInt(strings[2]);
             */

            int year = Integer.parseInt(date.substring(0,4));
            int month = Integer.parseInt(date.substring(5,7));
            int day = Integer.parseInt(date.substring(8,10));

            if (month ==1) {
                return day;
            }
            if (month ==2) {
                return 31 + day;
            }

            boolean isLeapYear = isLeapYear(year);
            int sumDays =0;
            for (int i = 0; i < month; i++) {
                sumDays += getDaysOfMonth( i, isLeapYear);
            }
            return sumDays + day;

        }

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
         * 返回每月的天数
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
        logger.info("{}", new Solution().dayOfYear("2004-03-01"));
    }

}
