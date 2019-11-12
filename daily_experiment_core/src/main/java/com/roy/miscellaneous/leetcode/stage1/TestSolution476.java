package com.roy.miscellaneous.leetcode.stage1;

import org.slf4j.LoggerFactory;

/**
 * Created by apple on 2019/11/11.
 *给定一个正整数，输出它的补数。补数是对该数的二进制表示取反。

 注意:

 给定的整数保证在32位带符号整数的范围内。
 你可以假定二进制数不包含前导零位。
 示例 1:

 输入: 5
 输出: 2
 解释: 5的二进制表示为101（没有前导零位），其补数为010。所以你需要输出2。
 示例 2:

 输入: 1
 输出: 0
 解释: 1的二进制表示为1（没有前导零位），其补数为0。所以你需要输出0。

 来源：力扣（LeetCode）
 链接：https://leetcode-cn.com/problems/number-complement
 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。


 注： 下面三种都是1ms, leetcode的统计数据有问题，拿上面的0ms拿来再次提交也是1ms
 *
 */
public class TestSolution476 {
    private static final org.slf4j.Logger logger = LoggerFactory.getLogger(TestSolution476.class);

    /**
     */
    static class Solution {
        /**
         *
         * 1. 求位数k
         * 2. 无符号右移 32-k得到 000000..001111,再和num进行^异或
         *
         * 执行用时 :1 ms, 在所有 java 提交中击败了78.08%的用户的用户 (有时也是0ms，统计问题有点大呀)
         内存消耗 :33.1 MB, 在所有 java 提交中击败了74.03%的用户
         *
         * @param num
         * @return
         */
        public int findComplement(int num) {
            if (num < 0) {
                return 0;
            }
            int k =1;
            /*int copyNum = num;
            while ( (copyNum = copyNum >> 1) != 0) {
                k ++;
            }*/
            k = Integer.toBinaryString(num).length();
            return (0xffffffff >>> (32-k)) ^ num;
        }


        /**
         *
         *
         * 执行用时 :1 ms, 在所有 java 提交中击败了78.08%的用户
         内存消耗 :33.1 MB, 在所有 java 提交中击败了74.27%的用户
         * @param num
         * @return
         */
        public int findComplement1(int num) {
            int copyNum = num;
            int remainder;
            int radix =1;
            int sum =0;
            do {
                remainder = (copyNum & 1) == 1 ? 0 : 1;
                sum += remainder * radix;
                radix = radix << 1;
                copyNum = copyNum >> 1;
            } while (copyNum != 0);
            return sum;
        }

        /**
         *
         *
         * 执行用时 :1 ms, 在所有 java 提交中击败了78.08%的用户
         内存消耗 :33.1 MB, 在所有 java 提交中击败了74.27%的用户
         * @param num
         * @return
         */
        public int findComplement2(int num) {
            if (num < 0) {
                return 0;
            }
            int copyNum = num;
            int mask = 0;
            while ( copyNum != 0) {
                copyNum >>= 1;
                mask = (mask << 1) +1;
            }
            return mask ^ num;
        }
    }

    public static void main(String[] args) {
        logger.info("{}", new Solution().findComplement2(5));
    }

}
