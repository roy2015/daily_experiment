package com.roy.leetcode.stage1.stage10;

import org.slf4j.LoggerFactory;

/**
 * @author guojun
 * @date 2020/11/10
 *
 *
 * 1598. 文件夹操作日志搜集器
 * 每当用户执行变更文件夹操作时，LeetCode 文件系统都会保存一条日志记录。
 *
 * 下面给出对变更操作的说明：
 *
 * "../" ：移动到当前文件夹的父文件夹。如果已经在主文件夹下，则 继续停留在当前文件夹 。
 * "./" ：继续停留在当前文件夹。
 * "x/" ：移动到名为 x 的子文件夹中。题目数据 保证总是存在文件夹 x 。
 * 给你一个字符串列表 logs ，其中 logs[i] 是用户在 ith 步执行的操作。
 *
 * 文件系统启动时位于主文件夹，然后执行 logs 中的操作。
 *
 * 执行完所有变更文件夹操作后，请你找出 返回主文件夹所需的最小步数 。
 *
 *
 *
 * 示例 1：
 *
 *
 *
 * 输入：logs = ["d1/","d2/","../","d21/","./"]
 * 输出：2
 * 解释：执行 "../" 操作变更文件夹 2 次，即可回到主文件夹
 * 示例 2：
 *
 *
 *
 * 输入：logs = ["d1/","d2/","./","d3/","../","d31/"]
 * 输出：3
 * 示例 3：
 *
 * 输入：logs = ["d1/","../","../","../"]
 * 输出：0
 *
 *
 * 提示：
 *
 * 1 <= logs.length <= 103
 * 2 <= logs[i].length <= 10
 * logs[i] 包含小写英文字母，数字，'.' 和 '/'
 * logs[i] 符合语句中描述的格式
 * 文件夹名称由小写英文字母和数字组成
 *
 */
public class TestSolution1598 {
    private static final org.slf4j.Logger logger = LoggerFactory.getLogger(TestSolution1598.class);


    static class Solution {

        /**
         *
         * 一个level变量解决所有
         *
         * 执行结果：
         * 通过
         * 显示详情
         * 执行用时：1 ms, 在所有 Java 提交中击败了99.76%的用户
         * 内存消耗：38.2 MB, 在所有 Java 提交中击败了85.87%的用户
         *
         * @param logs
         * @return
         */
        public int minOperations(String[] logs) {
            /**
             * 前序
             * 能出现的操作：
             * 1 ../
             * 2 ./
             * 3  x/
             * x： 由小写英文字母和数字组成
             */
            int level = 0;
            int size = logs.length;
            for (int i = 0; i < size; i++) {
                String stepVal = logs[i];
                if (level == 0) {
                    if (!"../".equals(stepVal) && !"./".equals(stepVal)) {
                        level++;
                    }
                } else {
                    if ("../".equals(stepVal)) {
                        level--;
                    } else if (!"./".equals(stepVal)) {
                        level++;
                    } else { //do noting}
                    }
                }
            }
            return level;
        }
    }

    public static void main(String[] args) {
        logger.info("{}", new Solution().minOperations(new String[] {"./","../","./"}));//0
        logger.info("{}", new Solution().minOperations(new String[] {"d1/","d2/","../","d21/","./"}));//2
        logger.info("{}", new Solution().minOperations(new String[] {"d1/","d2/","./","d3/","../","d31/"}));//3
        logger.info("{}", new Solution().minOperations(new String[] {"d1/","../","../","../"}));//0
    }
}
