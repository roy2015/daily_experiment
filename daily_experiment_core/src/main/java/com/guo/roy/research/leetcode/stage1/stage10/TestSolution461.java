package com.guo.roy.research.leetcode.stage1.stage10;

import org.slf4j.LoggerFactory;

/**
 * Created by apple on 2019/9/20.
 *两个整数之间的汉明距离指的是这两个数字对应二进制位不同的位置的数目。

 给出两个整数 x 和 y，计算它们之间的汉明距离。

 注意：
 0 ≤ x, y < 231.

 示例:

 输入: x = 1, y = 4

 输出: 2

 解释:
 1   (0 0 0 1)
 4   (0 1 0 0)
 ↑   ↑

 上面的箭头指出了对应二进制位不同的位置。

 来源：力扣（LeetCode）
 链接：https://leetcode-cn.com/problems/hamming-distance
 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 */
public class TestSolution461 {
    private static final org.slf4j.Logger logger = LoggerFactory.getLogger(TestSolution461.class);

    static class Solution {
        /**
         * 执行用时 :1 ms, 在所有 Java 提交中击败了89.71%的用户
         内存消耗 :33.3 MB, 在所有 Java 提交中击败了77.38%的用户
         * @param x
         * @param y
         * @return
         */
        public int hammingDistance(int x, int y) {
            int k = x ^y;
            String s = Integer.toBinaryString(k);
            int i =0;
            for (char c : s.toCharArray()) {
                if ( c == '1' ) {
                    i ++;
                }
            }

            return i;
        }

        /**
         * 执行用时 :0 ms, 在所有 Java 提交中击败了100.00%的用户
         内存消耗 :33.1 MB, 在所有 Java 提交中击败了77.77%的用户
         * @param x
         * @param y
         * @return
         */
        public int hammingDistance1(int x, int y) {
            int z = x^y;
            int count =0;
            while(z != 0) {
                if ((z &1) !=0) {
                    count++;
                }
                z = z >>1;
            }
            return count;
        }
    }

    public static void main(String[] args) {
        logger.info("{}", new Solution().hammingDistance(1, 4));


    }

}
