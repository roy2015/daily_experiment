package com.roy.miscellaneous.leetcode;

import org.slf4j.LoggerFactory;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

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
    }

    public static void main(String[] args) {
        logger.info("{}", new Solution().hammingDistance(1, 4));


    }

}
