package com.roy.leetcode.stage2.stage20;

import org.slf4j.LoggerFactory;

/**
 *
 *1641. 统计字典序元音字符串的数目
 * 给你一个整数 n，请返回长度为 n 、仅由元音 (a, e, i, o, u) 组成且按 字典序排列 的字符串数量。
 *
 * 字符串 s 按 字典序排列 需要满足：对于所有有效的 i，s[i] 在字母表中的位置总是与 s[i+1] 相同或在 s[i+1] 之前。
 *
 *
 *
 * 示例 1：
 *
 * 输入：n = 1
 * 输出：5
 * 解释：仅由元音组成的 5 个字典序字符串为 ["a","e","i","o","u"]
 * 示例 2：
 *
 * 输入：n = 2
 * 输出：15
 * 解释：仅由元音组成的 15 个字典序字符串为
 * ["aa","ae","ai","ao","au","ee","ei","eo","eu","ii","io","iu","oo","ou","uu"]
 * 注意，"ea" 不是符合题意的字符串，因为 'e' 在字母表中的位置比 'a' 靠后
 * 示例 3：
 *
 * 输入：n = 33
 * 输出：66045
 *
 *
 * 提示：
 *
 * 1 <= n <= 50
 *
 * @author guojun
 * @date 2022/3/5 10:40
 */
public class TestSolution1641 {
    private static final org.slf4j.Logger logger = LoggerFactory.getLogger(TestSolution1641.class);


    static class Solution {
        /**
         *
         * 方程为： 条件：i<=n , j=0,1,2,3,4
         *   f(i,j)= f(i-1,j) +  ∑  f(i-1,k)
         *                      5>k>j
         * 求    ∑ f[n,i] 即可
         *    0<=i<=4
         *
         * 执行结果：通过
         * 显示详情
         * 添加备注
         *
         * 执行用时：0 ms, 在所有 Java 提交中击败了100.00%的用户
         * 内存消耗：38.2 MB, 在所有 Java 提交中击败了21.91%的用户
         * 通过测试用例：41 / 41
         *
         * @param n
         * @return
         */
        public int countVowelStrings(int n) {
            int result = 0;
            int[] dp ;
            if (n == 1) {
                return 5;
            }
            dp = new int[]{1,1,1,1,1};

            for (int i = 2; i <=n ; i++) {
                for (int j = 0; j < 5; j++) {
                    int sum = 0;
                    for (int k = j +1; k < 5; k++) {
                        sum += dp[k];
                    }
                    dp[j] = dp[j] + sum;
                }
            }
            for (int i : dp) {
                result += i;
            }
            return result;
        }
    }

    public static void main(String[] args) {
        logger.info("{}", new Solution().countVowelStrings(2));//15
        logger.info("{}", new Solution().countVowelStrings(3));//35
        logger.info("{}", new Solution().countVowelStrings(4));//70
        logger.info("{}", new Solution().countVowelStrings(33));//66045
    }
}
