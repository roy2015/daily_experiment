package com.roy.miscellaneous.leetcode.stage1;

import org.slf4j.LoggerFactory;

/**
 * Created by apple on 2019/10/24.
 *给定一个整数，写一个函数来判断它是否是 3 的幂次方。

 示例 1:

 输入: 27
 输出: true
 示例 2:

 输入: 0
 输出: false
 示例 3:

 输入: 9
 输出: true
 示例 4:

 输入: 45
 输出: false
 进阶：
 你能不使用循环或者递归来完成本题吗？

 来源：力扣（LeetCode）
 链接：https://leetcode-cn.com/problems/power-of-three
 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 */
public class TestSolution326 {
    private static final org.slf4j.Logger logger = LoggerFactory.getLogger(TestSolution326.class);

    /**
     *
     *
     * 执行用时 :20 ms, 在所有 java 提交中击败了52.91%的用户
     内存消耗 :36.7 MB, 在所有 java 提交中击败了86.13%的用户
     */
    static class Solution {
        public boolean isPowerOfThree(int n) {
            if (n == 0) {
                return false;
            }
            try{
                String representStr = Integer.toString(n,3);
                if (representStr.indexOf("2") != -1)  {
                    return false;
                }

                int k = Integer.valueOf(representStr, 2);
                return (k & (k-1)) == 0;
            }catch (Exception e) {
                return false;
            }
        }

        /**
         * 流氓写法
         *
         *执行用时 :15 ms, 在所有 java 提交中击败了93.53%的用户
         内存消耗 :35.9 MB, 在所有 java 提交中击败了86.35%的用户
         * @param n
         * @return
         */
        public boolean isPowerOfThree1(int n) {
            return n > 0 && 1162261467 % n == 0;
        }

    }



    public static void main(String[] args) {
        logger.info("{}", new Solution().isPowerOfThree(45));
    }

}
