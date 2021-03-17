package com.roy.miscellaneous.leetcode.stage1.stage10;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.LoggerFactory;

/**
 * Created by apple on 2019/11/4.
 *判断一个整数是否是回文数。回文数是指正序（从左向右）和倒序（从右向左）读都是一样的整数。

 示例 1:

 输入: 121
 输出: true
 示例 2:

 输入: -121
 输出: false
 解释: 从左向右读, 为 -121 。 从右向左读, 为 121- 。因此它不是一个回文数。
 示例 3:

 输入: 10
 输出: false
 解释: 从右向左读, 为 01 。因此它不是一个回文数。

 来源：力扣（LeetCode）
 链接：https://leetcode-cn.com/problems/palindrome-number
 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 */
public class TestSolution9 {
    private static final org.slf4j.Logger logger = LoggerFactory.getLogger(TestSolution9.class);

    /**
     */
    static class Solution {

        /**
         * 每位数字: x/pow(10, n)%10
         * 个位： x /pow(10,0) %10,
         * 十位： x /pow(10,1) %10,
         * 。。。。。以此类推
         * 先求位数，再算是否回文
         *
         * 执行用时 :18 ms, 在所有 java 提交中击败了34.58%的用户
         内存消耗 :36.3 MB, 在所有 java 提交中击败了96.63%的用户
         * @param x
         * @return
         */
        public boolean isPalindrome(int x) {
            if (x < 0) {
                return false;
            }
            if (x ==0) {
                return true;
            }

            int k =0, copyX =x;//k: 位数 从0开始
            while (copyX /10 !=0) {
                k ++;
                copyX = copyX /10;
            }
            for (int i = 0; i <= k / 2; i++) {
                if (x / (int)Math.pow(10, i) % 10 !=
                        x / (int)Math.pow(10, k - i) % 10 ) {
                    return false;
                }
            }
            return true;
        }

        /**
         * 把每位放到list里，再判断回文
         *
         * 执行用时 :11 ms, 在所有 java 提交中击败了78.06%的用户
         内存消耗 :36.6 MB, 在所有 java 提交中击败了94.05%的用户
         *
         * @param x
         * @return
         */
        public boolean isPalindrome1(int x) {
            if (x < 0) {
                return false;
            }
            if (x ==0) {
                return true;
            }

            List<Integer> list = new ArrayList<>();
            do {
                list.add(x %10);
                x = x/10;
            } while (x != 0);

            int size = list.size();
            for (int i = 0; i < size /2 ; i++) {
                if (list.get(i) != list.get(size - 1 - i)) {
                    return false;
                }
            }
            return true;
        }

    }

    public static void main(String[] args) {
        logger.info("{}", new Solution().isPalindrome1(1));
    }

}
