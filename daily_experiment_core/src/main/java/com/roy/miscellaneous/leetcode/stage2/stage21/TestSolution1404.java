package com.roy.miscellaneous.leetcode.stage2.stage21;

import org.slf4j.LoggerFactory;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * @author guojun
 * @date 2020/9/9
 *
 *
 * 1404. 将二进制表示减到 1 的步骤数
 * 给你一个以二进制形式表示的数字 s 。请你返回按下述规则将其减少到 1 所需要的步骤数：
 *
 * 如果当前数字为偶数，则将其除以 2 。
 *
 * 如果当前数字为奇数，则将其加上 1 。
 *
 * 题目保证你总是可以按上述规则将测试用例变为 1 。
 *
 *
 *
 * 示例 1：
 *
 * 输入：s = "1101"
 * 输出：6
 * 解释："1101" 表示十进制数 13 。
 * Step 1) 13 是奇数，加 1 得到 14
 * Step 2) 14 是偶数，除 2 得到 7
 * Step 3) 7  是奇数，加 1 得到 8
 * Step 4) 8  是偶数，除 2 得到 4
 * Step 5) 4  是偶数，除 2 得到 2
 * Step 6) 2  是偶数，除 2 得到 1
 * 示例 2：
 *
 * 输入：s = "10"
 * 输出：1
 * 解释："10" 表示十进制数 2 。
 * Step 1) 2 是偶数，除 2 得到 1
 * 示例 3：
 *
 * 输入：s = "1"
 * 输出：0
 *
 *
 * 提示：
 *
 * 1 <= s.length <= 500
 * s 由字符 '0' 或 '1' 组成。
 * s[0] == '1'
 */
public class TestSolution1404 {
    private static final org.slf4j.Logger logger = LoggerFactory.getLogger(TestSolution1404.class);


    static class Solution {
        /**
         * 1 <= s.length <= 500，开始想500长度，怎么转二进？？没有这么大的数字，Long都不够用，
         * 而且被这个"位运算"的tag误导了，一直想会不会又有什么奇技淫巧？？
         * 看了一点点官方的思路，说可以用字符串模拟，想到可以用字符栈模拟，就可以无限位了
         *
         * 字符栈模拟二进制+1和移位操作, 貌似堆栈的操作比较耗时，再改进
         *
         *
         * 执行结果：
         * 通过
         * 显示详情
         * 执行用时：5 ms, 在所有 Java 提交中击败了19.55%的用户
         * 内存消耗：37.9 MB, 在所有 Java 提交中击败了18.89%的用户
         *
         *
         *
         * @param s
         * @return
         */
        public int numSteps(String s) {
            if (s == null || s.length() == 0) {
                return 0;
            }

            char[] chars = s.toCharArray();
            Deque<Character> stack = new ArrayDeque<>();
            //可能有bug,不是1开头的情况
            for (char aChar : chars) {
                stack.addLast(aChar);
            }
            int times = 0;
            char last;
            while (true) {
                last = stack.getLast();
                //里面只有一个'1'
                if (last == '1' && stack.size() == 1) {
                    return times;
                }

                if (last == '0') {//减0操作
                    stack.pollLast();
                } else {//加1操作
                    stack.pollLast();
                    int js = 1;
                    while (!stack.isEmpty() && stack.peekLast() == '1') {
                        stack.pollLast();
                        js ++;
                    }
                    if (stack.isEmpty()) {
                        stack.addLast('1');
                    } else {
                        stack.pollLast();
                        stack.addLast('1');
                    }
                    for (int i = 0; i < js; i++) {
                        stack.addLast('0');
                    }
                }
                times ++;
            }

        }

        /**
         *
         *
         * 同上，不过去掉了栈，直接在数组里模拟/2和+1操作
         *
         * 执行结果：
         * 通过
         * 显示详情
         * 执行用时：1 ms, 在所有 Java 提交中击败了68.42%的用户
         * 内存消耗：37.7 MB, 在所有 Java 提交中击败了31.11%的用户
         *
         * @param s
         * @return
         */
        public int numSteps1(String s) {
            char[] chars = s.toCharArray();
            int length = chars.length;
            int times = 0;
            for (int i = length -1; i >= 0; ) {
                //==0时消0
                if (chars[i] == '0') {
                    i--;
                    times ++;
                } else {//==1时
                    int j = i;
                    //往左数1的个数
                    while (j >= 0 && chars[j] == '1') {
                        chars[j] = '0';
                        j --;
                    }
                    if (j < 0) {
                        return i == 0 ? times : (times +1 ) + (i -j);
                    } else {
                        chars[j] = '1';
                    }
                    times ++;
                }//end else
            }//end for
            return times;


        }
    }

    public static void main(String[] args) {
        logger.info("{}", new Solution().numSteps1("10"));//1
        logger.info("{}", new Solution().numSteps1("1"));//0
        logger.info("{}", new Solution().numSteps1("1101"));//6
    }
}
