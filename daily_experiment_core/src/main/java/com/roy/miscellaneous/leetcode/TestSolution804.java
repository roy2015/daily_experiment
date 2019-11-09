package com.roy.miscellaneous.leetcode;

import org.slf4j.LoggerFactory;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;


/**
 * Created by apple on 2019/11/9.
 *国际摩尔斯密码定义一种标准编码方式，将每个字母对应于一个由一系列点和短线组成的字符串， 比如: "a" 对应 ".-", "b" 对应 "-...", "c" 对应 "-.-.", 等等。

 为了方便，所有26个英文字母对应摩尔斯密码表如下：

 [".-","-...","-.-.","-..",".","..-.","--.","....","..",".---","-.-",".-..","--","-.","---",".--.","--.-",".-.","...","-","..-","...-",".--","-..-","-.--","--.."]
 给定一个单词列表，每个单词可以写成每个字母对应摩尔斯密码的组合。例如，"cab" 可以写成 "-.-..--..."，(即 "-.-." + "-..." + ".-"字符串的结合)。我们将这样一个连接过程称作单词翻译。

 返回我们可以获得所有词不同单词翻译的数量。

 例如:
 输入: words = ["gin", "zen", "gig", "msg"]
 输出: 2
 解释:
 各单词翻译如下:
 "gin" -> "--...-."
 "zen" -> "--...-."
 "gig" -> "--...--."
 "msg" -> "--...--."

 共有 2 种不同翻译, "--...-." 和 "--...--.".
  

 注意:

 单词列表words 的长度不会超过 100。
 每个单词 words[i]的长度范围为 [1, 12]。
 每个单词 words[i]只包含小写字母。

 来源：力扣（LeetCode）
 链接：https://leetcode-cn.com/problems/unique-morse-code-words
 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 */
public class TestSolution804 {
    private static final org.slf4j.Logger logger = LoggerFactory.getLogger(TestSolution804.class);

    /**
     *
     *
     */
    static class Solution {
        //密码本
        private static String[] cipherBook = {".-","-...","-.-.","-..",".","..-.","--.","....","..",
                ".---","-.-",".-..","--","-.","---",".--.",
                "--.-",".-.","...","-","..-","...-",".--","-..-","-.--","--.."};


        /**
         *
         * 执行用时 :2 ms, 在所有 java 提交中击败了99.94%的用户
         内存消耗 :35.5 MB, 在所有 java 提交中击败了83.71%的用户
         *
         * @param words
         * @return
         */
        public int uniqueMorseRepresentations(String[] words) {
            if (words == null || words.length == 0) {
                return 0;
            }
            Set<String> set = new HashSet<String>();
            for (String word : words) {
                set.add(processSingleWord(word));
            }
            return set.size();
        }

        private String processSingleWord(String word) {
            StringBuffer sb = new StringBuffer();
            char[] chars = word.toCharArray();
            for (char aChar : chars) {
                sb.append(cipherBook[aChar - 'a']);
            }
            return sb.toString();
        }
    }

    public static void main(String[] args) {
        logger.info("{}", new Solution().uniqueMorseRepresentations
                (new String[]{"gin", "zen", "gig", "msg"}));
    }

}
