package com.guo.roy.research.leetcode.stage1.stage13;

import java.util.HashMap;
import java.util.Map;

import org.slf4j.LoggerFactory;

/**
 * @author guojun
 * @date 2020/7/23
 *
 * 1507. 转变日期格式
 * 给你一个字符串 date ，它的格式为 Day Month Year ，其中：
 *
 * Day 是集合 {"1st", "2nd", "3rd", "4th", ..., "30th", "31st"} 中的一个元素。
 * Month 是集合 {"Jan", "Feb", "Mar", "Apr", "May", "Jun", "Jul", "Aug", "Sep", "Oct", "Nov", "Dec"} 中的一个元素。
 * Year 的范围在 ​[1900, 2100] 之间。
 * 请你将字符串转变为 YYYY-MM-DD 的格式，其中：
 *
 * YYYY 表示 4 位的年份。
 * MM 表示 2 位的月份。
 * DD 表示 2 位的天数。
 *
 *
 * 示例 1：
 *
 * 输入：date = "20th Oct 2052"
 * 输出："2052-10-20"
 * 示例 2：
 *
 * 输入：date = "6th Jun 1933"
 * 输出："1933-06-06"
 * 示例 3：
 *
 * 输入：date = "26th May 1960"
 * 输出："1960-05-26"
 *
 *
 * 提示：
 *
 * 给定日期保证是合法的，所以不需要处理异常输入。
 *
 *
 *
 */
public class TestSolution1507 {
    private static final org.slf4j.Logger logger = LoggerFactory.getLogger(TestSolution1507.class);


    static class Solution {

        /**
         *
         *执行结果：
         * 通过
         * 显示详情
         * 执行用时：
         * 7 ms, 在所有 Java 提交中击败了69.64%的用户
         * 内存消耗：
         * 38.3 MB, 在所有 Java 提交中击败了100.00%的用户
         *
         *
         * @param date
         * @return
         */
        public String reformatDate(String date) {
            Map<String, String> dayMap = new HashMap<>();
            dayMap.put("1st", "01");
            dayMap.put("2nd", "02");
            dayMap.put("3rd", "03");
            dayMap.put("4th", "04");
            dayMap.put("5th", "05");
            dayMap.put("6th", "06");
            dayMap.put("7th", "07");
            dayMap.put("8th", "08");
            dayMap.put("9th", "09");
            dayMap.put("10th", "10");
            dayMap.put("11th", "11");
            dayMap.put("12th", "12");
            dayMap.put("13th", "13");
            dayMap.put("14th", "14");
            dayMap.put("15th", "15");
            dayMap.put("16th", "16");
            dayMap.put("17th", "17");
            dayMap.put("18th", "18");
            dayMap.put("19th", "19");
            dayMap.put("20th", "20");
            dayMap.put("21st", "21");
            dayMap.put("22nd", "22");
            dayMap.put("23rd", "23");
            dayMap.put("24th", "24");
            dayMap.put("25th", "25");
            dayMap.put("26th", "26");
            dayMap.put("27th", "27");
            dayMap.put("28th", "28");
            dayMap.put("29th", "29");
            dayMap.put("30th", "30");
            dayMap.put("31st", "31");

            Map<String, String> monthMap = new HashMap<>();
            monthMap.put("Jan","01");
            monthMap.put("Feb","02");
            monthMap.put("Mar","03");
            monthMap.put("Apr","04");
            monthMap.put("May","05");
            monthMap.put("Jun","06");
            monthMap.put("Jul","07");
            monthMap.put("Aug","08");
            monthMap.put("Sep","09");
            monthMap.put("Oct","10");
            monthMap.put("Nov","11");
            monthMap.put("Dec","12");

            //20th Oct 2052 -> 2052-10-20
//            String[] dateStrs = date.split(" ");
//            String[] dateStrs = split(date);
            String[] dateStrs = split1(date);

            return dateStrs[2] + "-" + monthMap.get(dateStrs[1]) + "-" + dayMap.get(dateStrs[0]);
        }

        private String[] split(String dateStr) {
            String[] retStr = new String[3];
            int p = 0, q =1;
            int endIdx;
            char[] chars = dateStr.toCharArray();
            while (chars[q] != ' ') {
                q ++;
            }
            endIdx = q;
            retStr[0] = new String(chars, p, endIdx - p);

            //loop blank
            while (chars[q] == ' ') {
                q++;
            }
            p = q;
            while (chars[q] != ' ') {
                q ++;
            }
            endIdx = q;
            retStr[1] = new String(chars, p, endIdx - p);

            //loop blank
            while (chars[q] == ' ') {
                q++;
            }
            p = q;
            endIdx = chars.length;
            retStr[2] = new String(chars, p, endIdx - p);

            return retStr;
        }

        private String[] split1(String dateStr) {
            String[] retStr = new String[3];
            char[] chars = dateStr.toCharArray();
            int len = chars.length;
            retStr[0] = dateStr.substring(0,len - 9);
            retStr[1] = dateStr.substring(len - 8, len - 5);
            retStr[2] = dateStr.substring(len-4,len);
            return retStr;
        }

    }

    public static void main(String[] args) {
        logger.info("{}", new Solution().reformatDate("20th Oct 2052"));//2052-10-20
        logger.info("{}", new Solution().reformatDate("6th Jun 1933"));//1933-06-06
        logger.info("{}", new Solution().reformatDate("22nd Apr 2023"));//2023-04-22
        logger.info("{}", new Solution().reformatDate("12th Jan 2018"));//2018-01-12
    }
}
