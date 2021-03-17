package com.roy.miscellaneous.leetcode.stage1.stage13;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.slf4j.LoggerFactory;

/**
 * @author guojun
 * @date 2020/7/13
 *
 * 给定仅有小写字母组成的字符串数组 A，返回列表中的每个字符串中都显示的全部字符（包括重复字符）组成的列表。例如，如果一个字符在每个字符串中出现 3 次，但不是 4 次，则需要在最终答案中包含该字符 3 次。
 *
 * 你可以按任意顺序返回答案。
 *
 *  
 *
 * 示例 1：
 *
 * 输入：["bella","label","roller"]
 * 输出：["e","l","l"]
 * 示例 2：
 *
 * 输入：["cool","lock","cook"]
 * 输出：["c","o"]
 *  
 *
 * 提示：
 *
 * 1 <= A.length <= 100
 * 1 <= A[i].length <= 100
 * A[i][j] 是小写字母
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/find-common-characters
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class TestSolution1002 {
    private static final org.slf4j.Logger logger = LoggerFactory.getLogger(TestSolution1002.class);


    static class Solution {
        /**
         *
         * 执行结果：
         * 通过
         * 显示详情
         * 执行用时：
         * 3 ms, 在所有 Java 提交中击败了96.26%的用户
         * 内存消耗：
         * 39.6 MB, 在所有 Java 提交中击败了25.00%的用户
         *
         * @param A
         * @return
         */
        public List<String> commonChars(String[] A) {
            if (A.length == 1) {
                return null;
            }
            //A.lenght > 1
            int[] retDic = new int[26];
            int[] compareDic = new int[26];
            //build retDic first to compare later
            String s = A[0];
            for (char c : s.toCharArray()) {
                retDic[c - 'a'] ++;
            }
            //compare
            for (int i = 1; i < A.length; i++) {
                Arrays.fill(compareDic , 0);
                String s1 = A[i];
                for (char c : s1.toCharArray()) {
                    compareDic[c - 'a'] ++;
                }
                //compare and collect
                for (int j = 0; j < 26; j++) {
                    if (compareDic[j] < retDic[j]  ) {
                        retDic[j] = compareDic[j];
                    }
                }
            }
            // output
            List<String> retList = new ArrayList<>();
            for (int i = 0; i < retDic.length; i++) {
                int iVal = retDic[i];
                for (int j = 0; j < iVal; j++) {
                    retList.add(String.valueOf((char) (i + 'a')));
                }
            }
            return retList;
        }
    }

    public static void main(String[] args) {
        logger.info("{}", new Solution().commonChars(new String[]{
                "bella"}
        ));//null
        logger.info("{}", new Solution().commonChars(new String[]{
                "bella","label","roller"}
        ));//ell
        logger.info("{}", new Solution().commonChars(new String[]{
                "cool","lock","cook"}
        ));//co
    }
}
