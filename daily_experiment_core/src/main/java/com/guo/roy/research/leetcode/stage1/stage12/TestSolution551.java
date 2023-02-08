package com.guo.roy.research.leetcode.stage1.stage12;

import org.slf4j.LoggerFactory;

/**
 * @author guojun
 * @date 2020/5/26
 *
 * 551. 学生出勤记录 I
给定一个字符串来代表一个学生的出勤记录，这个记录仅包含以下三个字符：

'A' : Absent，缺勤
'L' : Late，迟到
'P' : Present，到场
如果一个学生的出勤记录中不超过一个'A'(缺勤)并且不超过两个连续的'L'(迟到),那么这个学生会被奖赏。

你需要根据这个学生的出勤记录判断他是否会被奖赏。

示例 1:

输入: "PPALLP"
输出: True
示例 2:

输入: "PPALLL"
输出: False
 *
 */
public class TestSolution551 {
    private static final org.slf4j.Logger logger = LoggerFactory.getLogger(TestSolution551.class);


    static class Solution {

        /**
         *
         * 执行结果：
         通过
         显示详情
         执行用时 :0 ms, 在所有 Java 提交中击败了100.00%的用户
         内存消耗 :38.1 MB, 在所有 Java 提交中击败了7.69%的用户
         *
         * @param s
         * @return
         */
        public boolean checkRecord(String s) {
            if (s.length() == 0) {
                return false;
            }
            int aCheck = 0;
            int lCheck = 0;
            char[] chars = s.toCharArray();
            int len = chars.length;
            for (int i = 0; i < len; i++) {
                char iVal = chars[i];
                if (iVal == 'A') {
                    aCheck ++;
                    lCheck =0;
                } else if (iVal == 'L') {
                    lCheck ++;
                } else {
                    lCheck =0;
                }
                if (aCheck > 1 || lCheck > 2) {
                    return false;
                }
            }
            return true;
        }
    }

    public static void main(String[] args) {
        logger.info("{}", new Solution().checkRecord("LPLPLPLPLPL"));//true
        logger.info("{}", new Solution().checkRecord("LALL"));//true
        logger.info("{}", new Solution().checkRecord(""));//false
        logger.info("{}", new Solution().checkRecord("PPALLP"));//true
        logger.info("{}", new Solution().checkRecord("PPALLL"));//false

    }
}
