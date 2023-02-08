package com.guo.roy.research.leetcode.stage1.stage11;

import org.slf4j.LoggerFactory;

/**
 * @author guojun
 * @date 2020/8/3
 *
 *
 * 1528. 重新排列字符串
 * 给你一个字符串 s 和一个 长度相同 的整数数组 indices 。
 *
 * 请你重新排列字符串 s ，其中第 i 个字符需要移动到 indices[i] 指示的位置。
 *
 * 返回重新排列后的字符串。
 *
 *
 *
 * 示例 1：
 *
 *
 *
 * 输入：s = "codeleet", indices = [4,5,6,7,0,2,1,3]
 * 输出："leetcode"
 * 解释：如图所示，"codeleet" 重新排列后变为 "leetcode" 。
 * 示例 2：
 *
 * 输入：s = "abc", indices = [0,1,2]
 * 输出："abc"
 * 解释：重新排列后，每个字符都还留在原来的位置上。
 * 示例 3：
 *
 * 输入：s = "aiohn", indices = [3,1,4,2,0]
 * 输出："nihao"
 * 示例 4：
 *
 * 输入：s = "aaiougrt", indices = [4,0,2,6,7,3,1,5]
 * 输出："arigatou"
 * 示例 5：
 *
 * 输入：s = "art", indices = [1,0,2]
 * 输出："rat"
 *
 *
 * 提示：
 *
 * s.length == indices.length == n
 * 1 <= n <= 100
 * s 仅包含小写英文字母。
 * 0 <= indices[i] < n
 * indices 的所有的值都是唯一的（也就是说，indices 是整数 0 到 n - 1 形成的一组排列）。
 *
 */
public class TestSolution1528 {
    private static final org.slf4j.Logger logger = LoggerFactory.getLogger(TestSolution1528.class);


    static class Solution {
        /**
         *
         * 空间换时间，原地操作的话会N次交换元素
         *
         *
         * 执行结果：
         * 通过
         * 显示详情
         * 执行用时：
         * 1 ms, 在所有 Java 提交中击败了100.00%的用户
         * 内存消耗：
         * 39.9 MB , 在所有 Java 提交中击败了46.04%的用户
         *
         * @param s
         * @param indices
         * @return
         */
        public String restoreString(String s, int[] indices) {
            char[] srcChars = s.toCharArray();
            int len = srcChars.length;
            char[] targetChars = new char[len];
            for (int i = 0; i < len; i++) {
                targetChars[indices[i]] = srcChars[i];
            }
            return new String(targetChars);
        }
    }

    public static void main(String[] args) {
        logger.info("{}", new Solution().restoreString("codeleet", new int[]{4,5,6,7,0,2,1,3}));//leetcode
        logger.info("{}", new Solution().restoreString("abc", new int[]{0,1,2}));//abc
    }
}
