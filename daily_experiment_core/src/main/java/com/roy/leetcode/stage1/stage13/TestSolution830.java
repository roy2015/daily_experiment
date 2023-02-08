package com.roy.leetcode.stage1.stage13;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.slf4j.LoggerFactory;

/**
 * @author guojun
 * @date 2020/7/16
 *
 *
 * 830. 较大分组的位置
 * 在一个由小写字母构成的字符串 S 中，包含由一些连续的相同字符所构成的分组。
 *
 * 例如，在字符串 S = "abbxxxxzyy" 中，就含有 "a", "bb", "xxxx", "z" 和 "yy" 这样的一些分组。
 *
 * 我们称所有包含大于或等于三个连续字符的分组为较大分组。找到每一个较大分组的起始和终止位置。
 *
 * 最终结果按照字典顺序输出。
 *
 * 示例 1:
 *
 * 输入: "abbxxxxzzy"
 * 输出: [[3,6]]
 * 解释: "xxxx" 是一个起始于 3 且终止于 6 的较大分组。
 * 示例 2:
 *
 * 输入: "abc"
 * 输出: []
 * 解释: "a","b" 和 "c" 均不是符合要求的较大分组。
 * 示例 3:
 *
 * 输入: "abcdddeeeeaabbbcd"
 * 输出: [[3,5],[6,9],[12,14]]
 * 说明:  1 <= S.length <= 1000
 *
 *
 *
 */
public class TestSolution830 {
    private static final org.slf4j.Logger logger = LoggerFactory.getLogger(TestSolution830.class);


    /**
     *
     * 1 <= S.length <= 1000
     *
     */
    static class Solution {

        /**
         *
         * 双指针 10分钟就写完
         *
         * 执行结果：
         * 通过
         * 显示详情
         * 执行用时：
         * 1 ms, 在所有 Java 提交中击败了100.00%的用户
         * 内存消耗：
         * 39.9 MB, 在所有 Java 提交中击败了16.67%的用户
         *
         * @param S
         * @return
         */
        public List<List<Integer>> largeGroupPositions(String S) {
            List<List<Integer>> retList = new ArrayList<List<Integer>>();
            char[] chars = S.toCharArray();
            int length = chars.length;
            int p = 0;
            int q = 0;
            while (p < length) {
                q = p + 1;
                char pVal = chars[p];
                int cnt = 1;
                while (q < length && chars[q] == pVal) {
                    cnt ++;
                    q ++;
                }
                if (cnt >= 3) {
                    retList.add(Arrays.asList(p, q -1));
                }
                if (q == length) {
                    break;
                }
                p = q;
            }
            return retList;
        }

    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        List<List<Integer>> lists = solution.largeGroupPositions("abbxxxxzzy");//[[3,6]]
        lists = solution.largeGroupPositions("abc");//[]
        lists = solution.largeGroupPositions("abcdddeeeeaabbbcd");//[]
        logger.info("{}", lists);
    }
}
