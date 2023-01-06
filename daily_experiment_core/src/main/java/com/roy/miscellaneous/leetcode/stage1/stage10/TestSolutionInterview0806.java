package com.roy.miscellaneous.leetcode.stage1.stage10;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.slf4j.LoggerFactory;

/**
 * @author guojun
 * @date 2020/8/24
 *
 * 面试题 08.06. 汉诺塔问题
 * 在经典汉诺塔问题中，有 3 根柱子及 N 个不同大小的穿孔圆盘，盘子可以滑入任意一根柱子。一开始，所有盘子自上而下按升序依次套在第一根柱子上(即每一个盘子只能放在更大的盘子上面)。移动圆盘时受到以下限制:
 * (1) 每次只能移动一个盘子;
 * (2) 盘子只能从柱子顶端滑出移到下一根柱子;
 * (3) 盘子只能叠在比它大的盘子上。
 *
 * 请编写程序，用栈将所有盘子从第一根柱子移到最后一根柱子。
 *
 * 你需要原地修改栈。
 *
 * 示例1:
 *
 *  输入：A = [2, 1, 0], B = [], C = []
 *  输出：C = [2, 1, 0]
 * 示例2:
 *
 *  输入：A = [1, 0], B = [], C = []
 *  输出：C = [1, 0]
 * 提示:
 *
 * A中盘子的数目不大于14个。
 *
 */
public class TestSolutionInterview0806 {
    private static final org.slf4j.Logger logger = LoggerFactory.getLogger(TestSolutionInterview0806.class);


    static class Solution {

        /**
         *
         * 考虑了几天，理清晰了思路，应该说是思路清晰的汉诺塔解法了~~ ，包括输出挪动的步骤
         *
         * 执行结果：
         * 通过
         * 显示详情
         * 执行用时：
         * 2 ms, 在所有 Java 提交中击败了7.26%的用户
         * 内存消耗：
         * 37.5 MB, 在所有 Java 提交中击败了58.16%的用户
         *
         * @param A
         * @param B
         * @param C
         */
        public void hanota(List<Integer> A, List<Integer> B, List<Integer> C) {
            Map<Integer, List<Integer>> listMap = new HashMap<>();
            listMap.put(1, A);
            listMap.put(2, B);
            listMap.put(3, C);
            DoMoveHanota(listMap, 1, 3, A.size());
        }

        /**
         *
         *
         * @param listMap  三根柱子
         * @param from 从哪根柱子挪
         * @param to   挪到哪根柱子
         * @param num  挪多少个
         */
        public void DoMoveHanota(Map<Integer, List<Integer>> listMap, int from, int to, int num) {
            List<Integer> fromList = listMap.get(from);
            List<Integer> toList = listMap.get(to);
            int size = fromList.size();
            if (num == 1) {
                Integer top = fromList.get(size - 1);
                toList.add(top);
                fromList.remove(size -1);
                System.out.println(String.format("%s -> %s", from, to));
                return;
            }

            int mid = 6 - from - to;
            DoMoveHanota(listMap, from, mid, num -1);
            DoMoveHanota(listMap, from, to, 1);
            DoMoveHanota(listMap, mid, to, num -1);
        }

    }

    static class Solution1 {


        /**
         * a->b 01 a->c 02
         * b->a 10 b->c 12
         * c->a 20 c->b 21
         *
         * 两个
         */
        public void hanota(List<Integer> from, List<Integer> mid, List<Integer> to) {
            doHanota(from, mid, to, 0, 2);
        }

        public void doHanota(List<Integer> from, List<Integer> mid, List<Integer> to, int fromIdx, int toIdx) {
            if (from.size() == 0) {
                return;
            }

            //fromIdx -> thrid
            //from Idx -> to
            //thrid -> to
            int thrid = 0;
            if (fromIdx == 0 && toIdx == 1) {
                thrid = 2;
            } else  if (fromIdx == 0 && toIdx == 2) {
                thrid = 1;
            } else  if (fromIdx == 1 && toIdx == 0) {
                thrid = 2;
            } else  if (fromIdx == 1 && toIdx == 2) {
                thrid = 0;
            } else  if (fromIdx == 2 && toIdx == 0) {
                thrid = 1;
            } else  if (fromIdx == 2 && toIdx == 1) {
                thrid = 0;
            } else {}
            doHanota(from.subList(0, from.size()-1), new ArrayList<>(), new ArrayList<>(), fromIdx, thrid);
            logger.info("{} -> {}", (char)('a' + fromIdx) , (char)('a' + toIdx));
            doHanota(from.subList(0, from.size()-1), new ArrayList<>(), new ArrayList<>(), thrid, toIdx);

        }
    }

    public static void main(String[] args) {
        List<Integer> A = new ArrayList<>();
        int len = 5;
        for (int i = len; i >= 1; i--) {
            A.add(i);
        }

        ArrayList<Integer> recList = new ArrayList<>();
        new Solution().hanota(A, new ArrayList<Integer>(), recList);
//        logger.info("", new Solution());
    }
}
