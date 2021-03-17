package com.roy.miscellaneous.leetcode.stage1.stage12;

import java.util.HashMap;
import java.util.Map;

import org.slf4j.LoggerFactory;

/**
 * @author guojun
 * @date 2020/12/18
 *
 * 1678. 设计 Goal 解析器
 * 请你设计一个可以解释字符串 command 的 Goal 解析器 。command 由 "G"、"()" 和/或 "(al)" 按某种顺序组成。Goal 解析器会将 "G" 解释为字符串 "G"、"()" 解释为字符串 "o" ，"(al)" 解释为字符串 "al" 。然后，按原顺序将经解释得到的字符串连接成一个字符串。
 *
 * 给你字符串 command ，返回 Goal 解析器 对 command 的解释结果。
 *
 *
 *
 * 示例 1：
 *
 * 输入：command = "G()(al)"
 * 输出："Goal"
 * 解释：Goal 解析器解释命令的步骤如下所示：
 * G -> G
 * () -> o
 * (al) -> al
 * 最后连接得到的结果是 "Goal"
 * 示例 2：
 *
 * 输入：command = "G()()()()(al)"
 * 输出："Gooooal"
 * 示例 3：
 *
 * 输入：command = "(al)G(al)()()G"
 * 输出："alGalooG"
 *
 *
 * 提示：
 *
 * 1 <= command.length <= 100
 * command 由 "G"、"()" 和/或 "(al)" 按某种顺序组成
 *
 *
 */
public class TestSolution1678 {
    private static final org.slf4j.Logger logger = LoggerFactory.getLogger(TestSolution1678.class);


    static class Solution {
        private char[] commandChars;
        private int length;
        private char[][] keyChars;



        /**
         *
         *  初始版本
         *
         * 执行结果：通过
         * 显示详情
         * 执行用时：1 ms, 在所有 Java 提交中击败了65.58%的用户
         * 内存消耗：37 MB, 在所有 Java 提交中击败了17.27%的用户
         *
         *
         * @param command
         * @return
         */
        public String interpret(String command) {
            //init
            commandChars = command.toCharArray();
            length = commandChars.length;
            int k = 4;
            keyChars = new char[k][];
            keyChars[0] = new char[]{'G'};
            keyChars[1] = new char[]{'(',')'};
            keyChars[2] = new char[]{'/'};
            keyChars[3] = new char[]{'(','a','l',')'};
            Map<Integer, String> convertMap = new HashMap<>();
            convertMap.put(0, "G");
            convertMap.put(1, "o");
            convertMap.put(2, "/");
            convertMap.put(3, "al");
            //init end

            int i = 0;
            StringBuffer retSb = new StringBuffer();
            while (i < length) {
                for (int j = 0; j < k; j++) {
                    int i1 = checkMatch(i, j);
                    if (i1 != -1) {
                        retSb.append(convertMap.get(j));
                        i = i + i1;
                        break;
                    }
                }
            }
            return retSb.toString();
        }

        /**
         *
         *
         *  可维护性和
         * 不断优化代码，增强可维护性，只出现一个map，没有出现其他常量, 扩展时只需要该map即可
         *
         * 看来，需要在可维护性和效率之前妥协了
         *
         * 执行结果：通过
         * 显示详情
         * 执行用时：2 ms, 在所有 Java 提交中击败了18.34%的用户
         * 内存消耗：36.7 MB, 在所有 Java 提交中击败了56.04%的用户
         *
         *
         * @param command
         * @return
         */
        public String interpret1(String command) {
            //init
            commandChars = command.toCharArray();
            length = commandChars.length;
            Map<String, String> convertMap = new HashMap<>();
            convertMap.put("G", "G");
            convertMap.put("()", "o");
            convertMap.put("/", "/");
            convertMap.put("(al)", "al");
            String[] keyStrs =  convertMap.keySet().toArray(new String[0]);
            int k = keyStrs.length;
            keyChars = new char[k][];
            //index-based map 基于下标的映射表
            Map<Integer, String> indexedMap = new HashMap<>();
            for (int i = 0; i < keyStrs.length; i++) {
                String s = keyStrs[i];
                keyChars[i] = s.toCharArray();
                indexedMap.put(i, convertMap.get(s));
            }
            //init end

            int i = 0;
            StringBuffer retSb = new StringBuffer();
            while (i < length) {
                for (int j = 0; j < k; j++) {
                    int i1 = checkMatch(i, j);
                    if (i1 != -1) {
                        retSb.append(indexedMap.get(j));
                        i = i + i1;
                        break;
                    }
                }
            }
            return retSb.toString();
        }

        /**
         * 验证是否匹配成功
         * @param startIdx
         * @param i
         * @return  匹配成功对应字典行长度，匹配失败返回-1
         */
        private int checkMatch (int startIdx, int i) {
            char[] iStr = keyChars[i];
            int iLen = iStr.length;
            int j = 0;
            while ( startIdx < this.length && j < iLen  && commandChars[startIdx] == iStr[j]) {
                startIdx ++;
                j ++;
            }
            //模板走完说明匹配完成
            if (j == iLen) {
                return iLen;
            }
            return -1;
        }


    }

    public static void main(String[] args) {
        logger.info("{}", new Solution().interpret("G()(al)"));//Goal
        logger.info("{}", new Solution().interpret("G()()()()(al)"));//Gooooal
        logger.info("{}", new Solution().interpret("(al)G(al)()()G"));//alGalooG
        logger.info("{}", new Solution().interpret("G()//(al)"));//Go//al





    }
}
