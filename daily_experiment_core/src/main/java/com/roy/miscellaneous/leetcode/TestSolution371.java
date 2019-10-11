package com.roy.miscellaneous.leetcode;

import org.slf4j.LoggerFactory;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by apple on 2019/10/11.
 *
 *
 *不使用运算符 + 和 - ​​​​​​​，计算两整数 ​​​​​​​a 、b ​​​​​​​之和。

 示例 1:

 输入: a = 1, b = 2
 输出: 3
 示例 2:

 输入: a = -2, b = 3
 输出: 1

 来源：力扣（LeetCode）
 链接：https://leetcode-cn.com/problems/sum-of-two-integers
 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 */
public class TestSolution371 {
    private static final org.slf4j.Logger logger = LoggerFactory.getLogger(TestSolution371.class);

    /**
     *
     * 执行用时 :0 ms, 在所有 Java 提交中击败了100.00%的用户
       内存消耗 :33 MB, 在所有 Java 提交中击败了20.81%的用户
     *
     * a^b : 白带进位的加法
     * a&b: 进位 (a&b) <<1
     *
     * 直到进位为0递归跳出
     *
     */
    static class Solution {
        public int getSum(int a, int b) {
            if (b==0) {
                return a;
            } else {
                return getSum(a^b, (a&b) <<1);
            }

        }
    }

    public static void main(String[] args) {
        logger.info("{}", new Solution().getSum (1,2));
    }

}
