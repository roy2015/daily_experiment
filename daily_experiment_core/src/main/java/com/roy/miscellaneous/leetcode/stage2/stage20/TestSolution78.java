package com.roy.miscellaneous.leetcode.stage2.stage20;

import org.slf4j.LoggerFactory;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * @author guojun
 * @date 2020/10/23
 *
 *
 * 78. 子集
 * 给定一组不含重复元素的整数数组 nums，返回该数组所有可能的子集（幂集）。
 *
 * 说明：解集不能包含重复的子集。
 *
 * 示例:
 *
 * 输入: nums = [1,2,3]
 * 输出:
 * [
 *   [3],
 *   [1],
 *   [2],
 *   [1,2,3],
 *   [1,3],
 *   [2,3],
 *   [1,2],
 *   []
 * ]
 *
 */
public class TestSolution78 {
    private static final org.slf4j.Logger logger = LoggerFactory.getLogger(TestSolution78.class);


    static class Solution {
        private List<List<Integer>> sortListList;
        private int srcLen;

        /**
         *
         * 实际上就是排列组合的应用，回溯算法
         *
         *执行结果：
         * 通过
         * 显示详情
         * 执行用时：4 ms, 在所有 Java 提交中击败了7.08%的用户
         * 内存消耗：38.5 MB, 在所有 Java 提交中击败了98.37%的用户
         *
         *
         * @param nums
         * @return
         */
        public List<List<Integer>> subsets(int[] nums) {
            if (nums.length == 0) {
                this.sortListList = Collections.EMPTY_LIST;
            }
            this.sortListList = new ArrayList<List<Integer>>();
            this.srcLen = nums.length;

            List<Integer> numList = new ArrayList<>();
            for (int num : nums) {
                numList.add(num);
            }

            //0个元素
            this.sortListList.add(Collections.EMPTY_LIST);
            //一个到N个（N为数组长度）
            for (int layer = 1; layer <= srcLen; layer++) {
                subsetsSub(layer, 1, numList, new ArrayList<>());
            }
            return this.sortListList;
        }

        /**
         * 计算数学中组合(combination)的所有组合详情
         *
         * 重写组合详情， 调用方法 subsetsSub(int expectedLayer, int actualLayer, List<Integer> canSelectNumList, List<Integer> prePath);
         *    expectedLayer 选几个 k
         *     actualLayer        传1
         *     canSelectNumList   该子树能选的元素集合
         *     prePath 历史经过的路径 传new ArrayList<>()
         *
         * C(n,k)
         * @param expectedLayer 选几个 k
         * @param actualLayer        第一次传1
         * @param canSelectNumList   该子树能选的元素集合
         * @param prePath 历史经过的路径
         */
        public void subsetsSub(int expectedLayer, int actualLayer, List<Integer> canSelectNumList, List<Integer> prePath) {
            List<Integer> copyPrePath;
            if (actualLayer == expectedLayer) {
                for (int currentNum : canSelectNumList) {
                    copyPrePath = new ArrayList<>();
                    copyPrePath.addAll(prePath);
                    copyPrePath.add(currentNum);
                    this.sortListList.add(copyPrePath);
                }
                return;
            }

            int canSelectSize = canSelectNumList.size();
            for (int i = 0; i < canSelectSize; i++) {
                copyPrePath = new ArrayList<>();
                copyPrePath.addAll(prePath);
                copyPrePath.add(canSelectNumList.get(i));
                //减少不必要的递归， 长度不够expectedLayer直接return
                if (canSelectSize + prePath.size() < expectedLayer) {
                    break;
                }
                //canSelectNumList.subList(i +1, canSelectSize), 为什么i+1,应该横向已经选了一个，在往下递归能选的减-
                subsetsSub(expectedLayer, actualLayer + 1, canSelectNumList.subList(i +1, canSelectSize), copyPrePath );
            }
        }

    }

    public static void main(String[] args) {
        logger.info("{}", new Solution().subsets(new int[]{1,2,3}));
    }
}
