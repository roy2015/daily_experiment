package com.guo.roy.research.leetcode.stage1.stage10;

import org.slf4j.LoggerFactory;

/**
 * Created by apple on 2019/10/18.
 *
 * 编写一个函数，输入是一个无符号整数，返回其二进制表达式中数字位数为 ‘1’ 的个数（也被称为汉明重量）。

  

 示例 1：

 输入：00000000000000000000000000001011
 输出：3
 解释：输入的二进制串 00000000000000000000000000001011 中，共有三位为 '1'。
 示例 2：

 输入：00000000000000000000000010000000
 输出：1
 解释：输入的二进制串 00000000000000000000000010000000 中，共有一位为 '1'。
 示例 3：

 输入：11111111111111111111111111111101
 输出：31
 解释：输入的二进制串 11111111111111111111111111111101 中，共有 31 位为 '1'。
  

 提示：

 请注意，在某些语言（如 Java）中，没有无符号整数类型。在这种情况下，输入和输出都将被指定为有符号整数类型，并且不应影响您的实现，因为无论整数是有符号的还是无符号的，其内部的二进制表示形式都是相同的。
 在 Java 中，编译器使用二进制补码记法来表示有符号整数。因此，在上面的 示例 3 中，输入表示有符号整数 -3。

 来源：力扣（LeetCode）
 链接：https://leetcode-cn.com/problems/number-of-1-bits
 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 */
public class TestSolution191 {
    private static final org.slf4j.Logger logger = LoggerFactory.getLogger(TestSolution191.class);

    /**
     *
     *
     * 执行用时 :1 ms, 在所有 java 提交中击败了99.83%的用户
     * 内存消耗 :33.2 MB, 在所有 java 提交中击败了22.62%的用户
     */
    static class Solution {
        // you need to treat n as an unsigned value
        public int hammingWeight(int n) {
            int k =0;
            for(int i=0; i<32;i++) {
                if(((n >> i) & 0x1) == 1) {
                    k++;
                }
            }
            return k;
        }
    }

    public static void main(String[] args) {
        logger.info("{}", new Solution().hammingWeight(-3));
    }

}
