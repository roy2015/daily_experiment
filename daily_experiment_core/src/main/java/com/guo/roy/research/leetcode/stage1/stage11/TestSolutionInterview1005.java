package com.guo.roy.research.leetcode.stage1.stage11;

import org.slf4j.LoggerFactory;

/**
 * @author guojun
 * @date 2020/8/20
 *
 *面试题 10.05. 稀疏数组搜索
 * 稀疏数组搜索。有个排好序的字符串数组，其中散布着一些空字符串，编写一种方法，找出给定字符串的位置。
 *
 * 示例1:
 *
 *  输入: words = ["at", "", "", "", "ball", "", "", "car", "", "","dad", "", ""], s = "ta"
 *  输出：-1
 *  说明: 不存在返回-1。
 * 示例2:
 *
 *  输入：words = ["at", "", "", "", "ball", "", "", "car", "", "","dad", "", ""], s = "ball"
 *  输出：4
 * 提示:
 *
 * words的长度在[1, 1000000]之间
 *
 */
public class TestSolutionInterview1005 {
    private static final org.slf4j.Logger logger = LoggerFactory.getLogger(TestSolutionInterview1005.class);




    static class Solution {
        /**
         * 思路：
         *  1. 把空字符串过滤掉，换成无空值的递增数值，然后走正常的二分查找 -------- 不可取，是逃避问题
         *  2.  强行二分查找 --- 可取，不过要额外处理空字符串
         *
         *
         * 执行结果：
         * 通过
         * 显示详情
         * 执行用时：0 ms, 在所有 Java 提交中击败了100.00%的用户
         * 内存消耗：39.7 MB, 在所有 Java 提交中击败了43.55%的用户
         *
         * @param words
         * @param s
         * @return
         */
        public int findString(String[] words, String s) {
            int len = words.length;
            int low = 0;
            int high = len -1;
            int mid;
            while (low <= high) {
                mid = (low + high) >>>1;
                //向左找最近非空的字符串
                int copyMid = mid;
                /*写了个大坑 s == "" 应该走equals() */
                while (words[copyMid]/*==""*/.equals("") && copyMid >= low ) {
                    copyMid --;
                }
                if (copyMid < low) {//全部是空串
                    low = mid +1;
                } else {
                    if (words[copyMid].compareTo(s) == 0) {
                        return copyMid;
                    } else if (words[copyMid].compareTo(s) > 0) {
                        high = copyMid -1;
                    } else {
                        low = mid + 1;
                    }
                }
            }
            return -1;
        }

    }

    public static void main(String[] args) {

        logger.info("{}", new Solution().findString(new String[]
                        {"at", "", "", "", "ball", "", "", "car", "", "", "dad", "", ""},
                "at"));//0


        logger.info("{}", new Solution().findString(new String[]
                {"at", "", "", "", "ball", "", "", "car", "", "","dad", "", ""},
                "ball"));//4

    }
}
