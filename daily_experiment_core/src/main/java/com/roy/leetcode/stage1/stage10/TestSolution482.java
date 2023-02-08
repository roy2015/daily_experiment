package com.roy.leetcode.stage1.stage10;

import java.util.Stack;

import org.slf4j.LoggerFactory;

/**
 * Created by apple on 2019/10/25.
 *
 *
 * 给定一个密钥字符串S，只包含字母，数字以及 '-'（破折号）。N 个 '-' 将字符串分成了 N+1 组。给定一个数字 K，重新格式化字符串，除了第一个分组以外，每个分组要包含 K 个字符，第一个分组至少要包含 1 个字符。两个分组之间用 '-'（破折号）隔开，并且将所有的小写字母转换为大写字母。

 给定非空字符串 S 和数字 K，按照上面描述的规则进行格式化。

 示例 1：

 输入：S = "5F3Z-2e-9-w", K = 4

 输出："5F3Z-2E9W"

 解释：字符串 S 被分成了两个部分，每部分 4 个字符；
      注意，两个额外的破折号需要删掉。
 示例 2：

 输入：S = "2-5g-3-J", K = 2

 输出："2-5G-3J"

 解释：字符串 S 被分成了 3 个部分，按照前面的规则描述，第一部分的字符可以少于给定的数量，其余部分皆为 2 个字符。
  

 提示:

 S 的长度不超过 12,000，K 为正整数
 S 只包含字母数字（a-z，A-Z，0-9）以及破折号'-'
 S 非空
  

 来源：力扣（LeetCode）
 链接：https://leetcode-cn.com/problems/license-key-formatting
 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 */
public class TestSolution482 {
    private static final org.slf4j.Logger logger = LoggerFactory.getLogger(TestSolution482.class);

    /**
     *
     *
     * 两个栈
     *
     * 执行用时 :53 ms, 在所有 java 提交中击败了34.43%的用户
     内存消耗 :38.6 MB, 在所有 java 提交中击败了99.36%的用户
     *
     */
    static class Solution {
        public String licenseKeyFormatting(String S, int K) {
            if (S == null || S.isEmpty()) {
                return "";
            }
            Stack<String> stack = new Stack<String>();
            Stack<String> outStack = new Stack<String>();
            StringBuffer sb = new StringBuffer();
            String s;
            for (int i = 0; i < S.length(); i++) {
                s = S.substring(i, i + 1);
                if (s.equals("-") == false) {
                    stack.push(s);
                }
            }

            int cnt =0;
            while (! stack.isEmpty()) {
                s = stack.pop().toUpperCase();
                if (cnt == K) {
                    outStack.push("-");
                    outStack.push(s);
                    cnt = 1;
                } else {
                    outStack.push(s);
                    cnt ++;
                }
            }

            while (! outStack.isEmpty()) {
                sb.append(outStack.pop());
            }
            return sb.toString();
        }

        /**
         *
         * 执行用时 :23 ms, 在所有 java 提交中击败了68.03%的用户
         内存消耗 :38.3 MB, 在所有 java 提交中击败了99.36%的用户
         *
         * @param S
         * @param K
         * @return
         */
        public String licenseKeyFormatting1(String S, int K) {
            if (S == null || S.isEmpty()) {
                return "";
            }
            String s = S.replaceAll("-", "");
            int firstScan = s.length() % K;
            StringBuffer sb = new StringBuffer();
            if (firstScan != 0) {
                sb.append(s.substring(0,firstScan).toUpperCase());
            }
            for (int i = firstScan ; i< s.length(); i+=K) {
                if (i!= 0) {
                    sb.append("-");
                }
                sb.append(s.substring(i, i+K).toUpperCase());
            }
            return sb.toString();
        }

        /**
         *
         * 同上，但没用jdk的String里的subString方法，subString有性能问题？
         *
         * 执行用时 :10 ms, 在所有 java 提交中击败了98.09%的用户
         内存消耗 :37 MB, 在所有 java 提交中击败了99.36%的用户
         * @param S
         * @param K
         * @return
         */
        public String licenseKeyFormatting2(String S, int K) {
            if (S == null || S.isEmpty()) {
                return "";
            }
            String s = S.replaceAll("-", "");
            char[] charArray = s.toCharArray();
            int start = charArray.length % K;
            int segs = s.length() / K;
            char[] retChars = new char[charArray.length
                    + (segs ==0 ? 0 :
                    (start == 0 ? segs -1 : segs))];

            int cnt =0;
            int index = retChars.length -1;
            for (int i = charArray.length -1; i >=0 ; i--) {
                if (cnt == K) {
                    retChars[index --] = '-';
                    retChars[index --] = charArray[i] >='a' && charArray[i] <='z'
                            ? (char) (charArray[i] - 32) : charArray[i];
                    cnt =1;
                } else {
                    retChars[index --] = charArray[i] >='a' && charArray[i] <='z'
                            ? (char) (charArray[i] - 32) : charArray[i];
                    cnt ++;
                }
            }
            return new String(retChars);
        }

    }

    public static void main(String[] args) {
        String s = "a";
        int k = 2;
        logger.info(s);
        logger.info("{}",
                new Solution().licenseKeyFormatting2(s, k));
    }

}
