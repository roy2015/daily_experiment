package com.roy.miscellaneous.leetcode.stage1.stage13;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import org.slf4j.LoggerFactory;

/**
 * @author guojun
 * @date 2020/8/4
 *
 *
 * 1441. 用栈操作构建数组
 * 给你一个目标数组 target 和一个整数 n。每次迭代，需要从  list = {1,2,3..., n} 中依序读取一个数字。
 *
 * 请使用下述操作来构建目标数组 target ：
 *
 * Push：从 list 中读取一个新元素， 并将其推入数组中。
 * Pop：删除数组中的最后一个元素。
 * 如果目标数组构建完成，就停止读取更多元素。
 * 题目数据保证目标数组严格递增，并且只包含 1 到 n 之间的数字。
 *
 * 请返回构建目标数组所用的操作序列。
 *
 * 题目数据保证答案是唯一的。
 *
 *
 *
 * 示例 1：
 *
 * 输入：target = [1,3], n = 3
 * 输出：["Push","Push","Pop","Push"]
 * 解释：
 * 读取 1 并自动推入数组 -> [1]
 * 读取 2 并自动推入数组，然后删除它 -> [1]
 * 读取 3 并自动推入数组 -> [1,3]
 * 示例 2：
 *
 * 输入：target = [1,2,3], n = 3
 * 输出：["Push","Push","Push"]
 * 示例 3：
 *
 * 输入：target = [1,2], n = 4
 * 输出：["Push","Push"]
 * 解释：只需要读取前 2 个数字就可以停止。
 * 示例 4：
 *
 * 输入：target = [2,3,4], n = 4
 * 输出：["Push","Pop","Push","Push","Push"]
 *
 *
 * 提示：
 *
 * 1 <= target.length <= 100
 * 1 <= target[i] <= 100
 * 1 <= n <= 100
 * target 是严格递增的
 *
 *
 */
public class TestSolution1441 {
    private static final org.slf4j.Logger logger = LoggerFactory.getLogger(TestSolution1441.class);


    static class Solution {
        private static String PUSH = "Push";
        private static String POP = "Pop";


        /**
         *
         * 1ms上不去了？ 应该别标签误导了以为要用栈，见优化方法
         *
         * 执行结果：
         * 通过
         * 显示详情
         * 执行用时：
         * 1 ms, 在所有 Java 提交中击败了12.93%的用户
         * 内存消耗：
         * 40.3 MB, 在所有 Java 提交中击败了6.10%的用户
         *
         * @param target
         * @param n
         * @return
         */
        public List<String> buildArray(int[] target, int n) {
            List<String> retList = new ArrayList<>();

            //进队列
            LinkedList<Integer> data = new LinkedList<>();
            for (int i = 1; i <= n; i++) {
                data.add(i);
            }

            for (int i : target) {
                Integer peekVal = data.peek();
                if (peekVal.intValue() == i) {
                    data.pop();
                    retList.add(PUSH);
                } else {
                    int gap = i - peekVal;
                    for (int i1 = 0; i1 < gap; i1++) {
                        data.pop();
                        retList.add(PUSH);
                        retList.add(POP);
                    }
                    data.pop();
                    retList.add(PUSH);
                }
            }
            return retList;
        }

        /**
         * 不用队列和栈的version
         *
         *
         * 执行结果：
         * 通过
         * 显示详情
         * 执行用时：
         * 0 ms, 在所有 Java 提交中击败了100.00%的用户
         * 内存消耗：
         * 40 MB, 在所有 Java 提交中击败了31.71%的用户
         *
         * @param target
         * @param n
         * @return
         */
        public List<String> buildArray1(int[] target, int n) {
            List<String> retList = new ArrayList<>();
            int idx = 1;
            for (int i : target) {
                if (idx == i) {
                    idx ++;
                    retList.add(PUSH);
                } else {
                    int gap = i - idx;
                    for (int i1 = 0; i1 < gap; i1++) {
                        retList.add(PUSH);
                        retList.add(POP);
                        idx++;
                    }
                    idx ++;
                    retList.add(PUSH);
                }
            }
            return retList;
        }
    }

    public static void main(String[] args) {
        logger.info("{}", new Solution().buildArray1(new int[]{2,3,4}, 4));//["Push","Pop","Push","Push","Push"]
        logger.info("{}", new Solution().buildArray1(new int[]{1,2,3}, 3));//["Push","Push","Push"]
        logger.info("{}", new Solution().buildArray1(new int[]{1,2}, 4));//[Push Push]
        logger.info("{}", new Solution().buildArray1(new int[]{1,3}, 3));//["Push","Push","Pop","Push"]
    }
}
