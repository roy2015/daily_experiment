package com.roy.miscellaneous.leetcode.stage1;

import org.slf4j.LoggerFactory;

/**
 * @author guojun
 * @date 2020/4/27 17:40
 *
 *
 * 给定一个整数，将其转化为7进制，并以字符串形式输出。
 *
 * 示例 1:
 *
 * 输入: 100
 * 输出: "202"
 * 示例 2:
 *
 * 输入: -7
 * 输出: "-10"
 * 注意: 输入范围是 [-1e7, 1e7] 。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/base-7
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 */
public class TestSolution504 {
    private static final org.slf4j.Logger logger = LoggerFactory.getLogger(TestSolution504.class);


    static class Solution {

        /**
         *
         * 执行结果：
         * 通过
         * 显示详情
         * 执行用时 :1 ms, 在所有 Java 提交中击败了99.73%的用户
         * 内存消耗 :37.5 MB, 在所有 Java 提交中击败了7.14%的用户
         *
         * @param num
         * @return
         */
        public String convertToBase7(int num) {
            boolean negtive = num < 0 ? true : false;
            num = Math.abs(num);

            int yushu =0;
            StringBuffer sb = new StringBuffer();
            do {
                yushu = num % 7;
                sb.append(yushu);
                num = num / 7;

            } while(num !=0);
            if (negtive) {
                sb.append("-");
            }
            return sb.reverse().toString();
        }
    }

    public static void main(String[] args) {
        logger.info("{}", new Solution().convertToBase7(100));
        logger.info("{}", new Solution().convertToBase7(-7));
        logger.info("{}", new Solution().convertToBase7(-1));
    }
}
