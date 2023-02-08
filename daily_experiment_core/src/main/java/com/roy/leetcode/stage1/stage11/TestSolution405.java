package com.roy.leetcode.stage1.stage11;

import org.slf4j.LoggerFactory;

/**
 * @author guojun
 * @date 2020/8/4
 *
 *
 * 405. 数字转换为十六进制数
 * 给定一个整数，编写一个算法将这个数转换为十六进制数。对于负整数，我们通常使用 补码运算 方法。
 *
 * 注意:
 *
 * 十六进制中所有字母(a-f)都必须是小写。
 * 十六进制字符串中不能包含多余的前导零。如果要转化的数为0，那么以单个字符'0'来表示；对于其他情况，十六进制字符串中的第一个字符将不会是0字符。
 * 给定的数确保在32位有符号整数范围内。
 * 不能使用任何由库提供的将数字直接转换或格式化为十六进制的方法。
 * 示例 1：
 *
 * 输入:
 * 26
 *
 * 输出:
 * "1a"
 * 示例 2：
 *
 * 输入:
 * -1
 *
 * 输出:
 * "ffffffff"
 *
 *
 */
public class TestSolution405 {
    private static final org.slf4j.Logger logger = LoggerFactory.getLogger(TestSolution405.class);


    static class Solution {

        /**
         *
         * 比较简洁的解法， 可以有两种解法，除以16/位运算无符号右移4位， 后面一种比较好
         *
         * 执行结果：
         * 通过
         * 显示详情
         * 执行用时：
         * 0 ms, 在所有 Java 提交中击败了100.00%的用户
         * 内存消耗：
         * 36.8 MB, 在所有 Java 提交中击败了77.65%的用户
         *
         * @param num
         * @return
         */
        public String toHex(int num) {
            char[] dicChars = new char[]{'0','1','2','3','4','5','6','7','8','9','a','b','c','d','e','f'};
            StringBuilder sb = new StringBuilder();
            do{
                int yus = num & 0xf;
                sb.append(dicChars[yus]);
                num = num >>> 4;
            } while(num != 0);
            return sb.reverse().toString();
        }

    }

    public static void main(String[] args) {
        logger.info("{}", new Solution().toHex(-1));
    }
}
