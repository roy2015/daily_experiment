package com.guo.roy.research.leetcode.stage1.stage12;

import java.util.*;

import org.slf4j.LoggerFactory;

/**
 * @author guojun
 * @date 2020/5/25
 *
 * 819. 最常见的单词
给定一个段落 (paragraph) 和一个禁用单词列表 (banned)。返回出现次数最多，同时不在禁用列表中的单词。

题目保证至少有一个词不在禁用列表中，而且答案唯一。

禁用列表中的单词用小写字母表示，不含标点符号。段落中的单词不区分大小写。答案都是小写字母。



示例：

输入:
paragraph = "Bob hit a ball, the hit BALL flew far after it was hit."
banned = ["hit"]
输出: "ball"
解释:
"hit" 出现了3次，但它是一个禁用的单词。
"ball" 出现了2次 (同时没有其他单词出现2次)，所以它是段落里出现次数最多的，且不在禁用列表中的单词。
注意，所有这些单词在段落里不区分大小写，标点符号需要忽略（即使是紧挨着单词也忽略， 比如 "ball,"），
"hit"不是最终的答案，虽然它出现次数更多，但它在禁用单词列表中。


提示：

1 <= 段落长度 <= 1000
0 <= 禁用单词个数 <= 100
1 <= 禁用单词长度 <= 10
答案是唯一的, 且都是小写字母 (即使在 paragraph 里是大写的，即使是一些特定的名词，答案都是小写的。)
paragraph 只包含字母、空格和下列标点符号!?',;.
不存在没有连字符或者带有连字符的单词。
单词里只包含字母，不会出现省略号或者其他标点符号。
 */
public class TestSolution819 {
    private static final org.slf4j.Logger logger = LoggerFactory.getLogger(TestSolution819.class);


    static class Solution {

        /**
         *
         * 不容易呀
         *
         * 执行结果：
         通过
         显示详情
         执行用时 :
         7 ms
         , 在所有 Java 提交中击败了96.74%
         的用户
         内存消耗 :
         39.5 MB
         , 在所有 Java 提交中击败了14.29%
         的用户
         *
         * @param paragraph
         * @param banned
         * @return
         */
        public String mostCommonWord(String paragraph, String[] banned) {
            Set<String> blackList = new HashSet<>();
            //fill blackList
            for (String s : banned) {
                blackList.add(s);
            }
            HashMap<String, Integer> map = new HashMap<>();
            char[] chars = paragraph.toCharArray();
            int len = chars.length;
            int start = 0;
            StringBuilder sb = new StringBuilder();

            while (start < len) {
                //找第一个字母
                while (start < len && !((chars[start] >= 'a' && chars[start] <= 'z') ||
                        (chars[start] >= 'A' && chars[start] <= 'Z'))) {
                    start++;
                }
                if (start == len) {
                    break;
                }
                //找结束的字母
                int end;
                for (end = start + 1; end < len; end++) {
                    if (!((chars[end] >= 'a' && chars[end] <= 'z') ||
                            (chars[end] >= 'A' && chars[end] <= 'Z'))) {
                        break;
                    }
                }
                String s = new String(Arrays.copyOfRange(chars, start, end)).toLowerCase();
                map.compute(s, (key, oldVal) -> {
                    if (oldVal == null) {
                        if (blackList.contains(key)) {
                            return new Integer(0);
                        } else {
                            return new Integer(1);
                        }
                    } else {
                        if (oldVal.compareTo(0) == 0) {
                            return oldVal;
                        } else {
                            return new Integer(++oldVal);
                        }
                    }
                });
                start = end;
            }//end while

            Object[] store = new Object[2];
            store[0] = "-1";
            store[1] = -1;
            for (Map.Entry<String, Integer> entry : map.entrySet()) {
                String key = entry.getKey();
                Integer val = entry.getValue();
                if (store[1].equals(-1)) {
                    store[0] = key;
                    store[1] = val;
                } else if (val.compareTo((Integer) store[1]) > 0) {
                    store[0] = key;
                    store[1] = val;
                } else {
                }
            }
            return (String) store[0];
        }
    }

    public static void main(String[] args) {

        logger.info("{}", new Solution().mostCommonWord(
                "L, P! X! C; u! P? w! P. G, S? l? X? D. w? m? f? v, x? i. z; x' m! U' M! j? V; l. S! j? r, K. O? k? p? " +
                        "p, H! t! z' X! v. u; F, h; s? X? K. y, Y! L; q! y? j, o? D' y? F' Z; E? W; W' W! n! p' U. N; w? V' " +
                        "y! Q; J, o! T? g? o! N' M? X? w! V. w? o' k. W. y, k; o' m! r; i, n. k, w; U? S? t; O' g' z. V. N? z, " +
                        "W? j! m? W! h; t! V' T! Z? R' w, w? y? y; O' w; r? q. G, V. x? n, Y; Q. s? S. G. f, s! U? l. o! i. L; Z' " +
                        "X! u. y, Q. q; Q, D; V. m. q. s? Y, U; p? u! q? h? O. W' y? Z! x! r. E, R, r' X' V, b. z, x! Q; y, g' j; j. " +
                        "q; W; v' X! J' H? i' o? n, Y. X! x? h? u; T? l! o? z. K' z' s; L? p? V' r. L? Y; V! V' S. t? Z' T' Y. s? i? Y! " +
                        "G? r; Y; T! h! K; M. k. U; A! V? R? C' x! X. M; z' V! w. N. T? Y' w? n, Z, Z? Y' R; V' f; V' I; t? X? Z; l? R, Q! Z. " +
                        "R. R, O. S! w; p' T. u? U! n, V, M. p? Q, O? q' t. B, k. u. H' T; T? S; Y! S! i? q! K' z' S! v; L. x; q; W? m? y, Z! x. y. " +
                        "j? N' R' I? r? V! Z; s, O? s; V, I, e? U' w! T? T! u; U! e? w? z; t! C! z? U, p' p! r. x; U! Z; u! j; T! X! N' F? n! P' t, X. s; q'",
                new String[]{"m","i","s","w","y","d","q","l","a","p","n","t","u","b","o","e","f","g","c","x"}));

        logger.info("{}", new Solution().mostCommonWord(
                "Bob hit a ball, the hit BALL flew far after it was hit.",
                new String[]{"hit"}));
    }
}
