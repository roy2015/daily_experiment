package com.roy.miscellaneous.leetcode.stage1;

import org.slf4j.LoggerFactory;

/**
 * Created by apple on 2019/10/10.
 *
 *
 * 给定一个整数，编写一个函数来判断它是否是 2 的幂次方。

 示例 1:

 输入: 1
 输出: true
 解释: 20 = 1
 示例 2:

 输入: 16
 输出: true
 解释: 24 = 16
 示例 3:

 输入: 218
 输出: false

 来源：力扣（LeetCode）
 链接：https://leetcode-cn.com/problems/power-of-two
 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 */
public class TestSolution231 {
    private static final org.slf4j.Logger logger = LoggerFactory.getLogger(TestSolution231.class);

    /**
     *
     * 执行用时 :1 ms, 在所有 Java 提交中击败了100.00%的用户
     内存消耗 :33.4 MB, 在所有 Java 提交中击败了15.45%的用户
     */
    static class Solution {
        public boolean isPowerOfTwo(int n) {
            if (n <=0) {
                return false;
            }

            int k=n ;
            while (true) {
                if ((k & 1) == 0) {
                    k = k >> 1;
                } else {
                    if (k ==1) {
                        return true;
                    } else {
                        return false;
                    }
                }
            }
        }

        /**
         * 最简单的方法
         * @param n
         * @return
         */
        public boolean isPowerOfTwo1(int n) {
            if (n <=0) {
                return false;
            }

            return (n & (n-1)) == 0;
        }
    }

    public static void main(String[] args) {
        logger.info("{}", new Solution().isPowerOfTwo1(1));


    }

}
