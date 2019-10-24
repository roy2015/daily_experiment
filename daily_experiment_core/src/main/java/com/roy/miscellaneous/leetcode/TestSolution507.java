package com.roy.miscellaneous.leetcode;

import org.slf4j.LoggerFactory;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by apple on 2019/10/24.
 *对于一个 正整数，如果它和除了它自身以外的所有正因子之和相等，我们称它为“完美数”。

 给定一个 整数 n， 如果他是完美数，返回 True，否则返回 False

  

 示例：

 输入: 28
 输出: True
 解释: 28 = 1 + 2 + 4 + 7 + 14
  

 提示：

 输入的数字 n 不会超过 100,000,000. (1e8)

 来源：力扣（LeetCode）
 链接：https://leetcode-cn.com/problems/perfect-number
 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 */
public class TestSolution507 {
    private static final org.slf4j.Logger logger = LoggerFactory.getLogger(TestSolution507.class);

    /**
     */
    static class Solution {

        /**
         *
         * 执行用时 :2 ms, 在所有 java 提交中击败了91.39%的用户
         内存消耗 :33 MB, 在所有 java 提交中击败了77.78%的用户
         *
         * @param num
         * @return
         */
        public boolean checkPerfectNumber(int num) {
            if (num ==1) {
                return false;
            }

            int sum =1;
            int floor = (int) Math.floor(Math.sqrt(num));
            for (int i = 2; i <= floor; i++ ) {
                if (num % i == 0) {
                   sum = sum + i + (num / i) ;
                }
            }
            if (sum == num) {
                return true;
            }
            return false;

        }
    }

    public static void main(String[] args) {
        logger.info("{}", new Solution().checkPerfectNumber(1));
    }

}
