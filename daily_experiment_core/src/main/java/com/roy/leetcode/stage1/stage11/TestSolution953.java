package com.roy.leetcode.stage1.stage11;

import org.slf4j.LoggerFactory;

/**
 * @author guojun
 * @date 2020/7/30
 *
 *
 * 953. 验证外星语词典
 * 某种外星语也使用英文小写字母，但可能顺序 order 不同。字母表的顺序（order）是一些小写字母的排列。
 *
 * 给定一组用外星语书写的单词 words，以及其字母表的顺序 order，只有当给定的单词在这种外星语中按字典序排列时，返回 true；否则，返回 false。
 *
 *
 *
 * 示例 1：
 *
 * 输入：words = ["hello","leetcode"], order = "hlabcdefgijkmnopqrstuvwxyz"
 * 输出：true
 * 解释：在该语言的字母表中，'h' 位于 'l' 之前，所以单词序列是按字典序排列的。
 * 示例 2：
 *
 * 输入：words = ["word","world","row"], order = "worldabcefghijkmnpqstuvxyz"
 * 输出：false
 * 解释：在该语言的字母表中，'d' 位于 'l' 之后，那么 words[0] > words[1]，因此单词序列不是按字典序排列的。
 * 示例 3：
 *
 * 输入：words = ["apple","app"], order = "abcdefghijklmnopqrstuvwxyz"
 * 输出：false
 * 解释：当前三个字符 "app" 匹配时，第二个字符串相对短一些，然后根据词典编纂规则 "apple" > "app"，因为 'l' > '∅'，其中 '∅' 是空白字符，定义为比任何其他字符都小（更多信息）。
 *
 *
 * 提示：
 *
 * 1 <= words.length <= 100
 * 1 <= words[i].length <= 20
 * order.length == 26
 * 在 words[i] 和 order 中的所有字符都是英文小写字母。
 */
public class TestSolution953 {
    private static final org.slf4j.Logger logger = LoggerFactory.getLogger(TestSolution953.class);


    static class Solution {
        /**
         *
         * 调试了一小时，看来是小看了string的compare,以为挺简单的自己写还是bug比较多
         *
         * 执行结果：
         * 通过
         * 显示详情
         * 执行用时：
         * 0 ms, 在所有 Java 提交中击败了100.00%的用户
         * 内存消耗：
         * 38.5 MB, 在所有 Java 提交中击败了33.33%的用户
         *
         * @param words
         * @param order
         * @return
         */
        public boolean isAlienSorted(String[] words, String order) {
            char[] ordeChars = order.toCharArray();
            int[] revertMap = new int[26];
            for (int i = 0; i < ordeChars.length; i++) {
                revertMap[ordeChars[i] - 'a'] = i;
            }

            //1 <= words.length <= 100
            int len = words.length;
            for (int i = 0; i < len - 1; i++) {
                char[] iChars = words[i].toCharArray();
                char[] jChars = words[i + 1].toCharArray();
                int idx = 0;
                int iLen = iChars.length;
                int jLen = jChars.length;
                int compareRes = -1;
                while (idx < iLen && idx < jLen) {
                    int tmepIVal = revertMap[iChars[idx]- 'a'];
                    int tmepJVal = revertMap[jChars[idx]- 'a'];
                    if (tmepIVal < tmepJVal ) {//遇到满足的 true
                        compareRes =  1;
                        break;
                    } else if (tmepIVal > tmepJVal) {//非递增的
                        compareRes = 0;
                        break;
                    } else {}
                    idx ++;
                }

                if (compareRes == 0) {//不满足直接跳出
                    return false;
                } else if (compareRes == -1) {
                    if (idx == jLen) {//j 长度不够
                        return false;
                    }
                } else {}
            }
            return true;
        }
    }

    public static void main(String[] args) {
        logger.info("{}", new Solution().isAlienSorted(
                new String[]{"word","world","row"}, "worldabcefghijkmnpqstuvxyz"

        ));//false
        logger.info("{}", new Solution().isAlienSorted(
                new String[]{"hello","leetcode"}, "hlabcdefgijkmnopqrstuvwxyz"


        ));//true


        logger.info("{}", new Solution().isAlienSorted(
                new String[]{"apple","app"}, "abcdefghijklmnopqrstuvwxyz"

        ));//false
    }
}
