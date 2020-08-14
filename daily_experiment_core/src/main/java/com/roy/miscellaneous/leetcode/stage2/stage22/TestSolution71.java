package com.roy.miscellaneous.leetcode.stage2.stage22;

import org.slf4j.LoggerFactory;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * @author guojun
 * @date 2020/8/14
 *
 *
 * 71. 简化路径
 * 以 Unix 风格给出一个文件的绝对路径，你需要简化它。或者换句话说，将其转换为规范路径。
 *
 * 在 Unix 风格的文件系统中，一个点（.）表示当前目录本身；此外，两个点 （..） 表示将目录切换到上一级（指向父目录）；两者都可以是复杂相对路径的组成部分。更多信息请参阅：Linux / Unix中的绝对路径 vs 相对路径
 *
 * 请注意，返回的规范路径必须始终以斜杠 / 开头，并且两个目录名之间必须只有一个斜杠 /。最后一个目录名（如果存在）不能以 / 结尾。此外，规范路径必须是表示绝对路径的最短字符串。
 *
 *
 *
 * 示例 1：
 *
 * 输入："/home/"
 * 输出："/home"
 * 解释：注意，最后一个目录名后面没有斜杠。
 * 示例 2：
 *
 * 输入："/../"
 * 输出："/"
 * 解释：从根目录向上一级是不可行的，因为根是你可以到达的最高级。
 * 示例 3：
 *
 * 输入："/home//foo/"
 * 输出："/home/foo"
 * 解释：在规范路径中，多个连续斜杠需要用一个斜杠替换。
 * 示例 4：
 *
 * 输入："/a/./b/../../c/"
 * 输出："/c"
 * 示例 5：
 *
 * 输入："/a/../../b/../c//.//"
 * 输出："/c"
 * 示例 6：
 *
 * 输入："/a//b////c/d//././/.."
 * 输出："/a/b/c"
 *
 *
 *
 *
 */
public class TestSolution71 {
    private static final org.slf4j.Logger logger = LoggerFactory.getLogger(TestSolution71.class);


    static class Solution {
        /**
         *
         *一次过，可以，主要是队列和栈要熟练
         *
         * 执行结果：
         * 通过
         * 显示详情
         * 执行用时：3 ms, 在所有 Java 提交中击败了99.06%的用户
         * 内存消耗：39.6 MB, 在所有 Java 提交中击败了89.07%的用户
         *
         * @param path
         * @return
         */
        public String simplifyPath(String path) {
            char slash = '/';
            String dian = ".";
            String dianDian = "..";
            StringBuilder retSb = new StringBuilder();
            char[] chars = path.toCharArray();
            int len = chars.length;
            //假设path是以"/"开头
            Deque<String> queue = new ArrayDeque<>();
            int start = 0;
            int end;
            while (start < len ) {
                //找下一个"/"
                end = start + 1;
                while (end < len && chars[end] != slash) {
                    end ++;
                }
                if (end - start > 1) {
                    String newStr = new String(chars, start + 1, end - start -1);
                    if (queue.isEmpty()) {
                        if (!newStr.equals(dian) && !newStr.equals(dianDian)) {
                            queue.add(newStr);
                        } else {}
                    } else {
                        if (newStr.equals(dianDian)) {
                            queue.pollLast();
                        } else if (newStr.equals(dian)){
                            //do nothing
                        } else {
                            queue.add(newStr);
                        }
                    }
                }
                start = end;
            }

            if (queue.isEmpty()) {
                retSb.append(slash);
            }
            while (!queue.isEmpty()) {
                retSb.append(slash).append(queue.pop());
            }
            return retSb.toString();
        }
    }

    public static void main(String[] args) {
        logger.info("{}", new Solution().simplifyPath("/a//b////c/d//././/.."));//  /a/b/c
        logger.info("{}", new Solution().simplifyPath("/../"));// /
        logger.info("{}", new Solution().simplifyPath("/home/"));// /home
        logger.info("{}", new Solution().simplifyPath("/home//foo/"));// /home/foo
        logger.info("{}", new Solution().simplifyPath("/a/./b/../../c/"));// /c
        logger.info("{}", new Solution().simplifyPath("/a/../../b/../c//.//"));//  /c

    }
}
