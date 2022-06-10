package com.roy.miscellaneous.leetcode.stage2.stage20;

import org.slf4j.LoggerFactory;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.BiFunction;

/**
 * 1743. 从相邻元素对还原数组
 * 存在一个由 n 个不同元素组成的整数数组 nums ，但你已经记不清具体内容。好在你还记得 nums 中的每一对相邻元素。
 *
 * 给你一个二维整数数组 adjacentPairs ，大小为 n - 1 ，其中每个 adjacentPairs[i] = [ui, vi] 表示元素 ui 和 vi 在 nums 中相邻。
 *
 * 题目数据保证所有由元素 nums[i] 和 nums[i+1] 组成的相邻元素对都存在于 adjacentPairs 中，存在形式可能是 [nums[i], nums[i+1]] ，也可能是 [nums[i+1], nums[i]] 。这些相邻元素对可以 按任意顺序 出现。
 *
 * 返回 原始数组 nums 。如果存在多种解答，返回 其中任意一个 即可。
 *
 *
 *
 * 示例 1：
 *
 * 输入：adjacentPairs = [[2,1],[3,4],[3,2]]
 * 输出：[1,2,3,4]
 * 解释：数组的所有相邻元素对都在 adjacentPairs 中。
 * 特别要注意的是，adjacentPairs[i] 只表示两个元素相邻，并不保证其 左-右 顺序。
 * 示例 2：
 *
 * 输入：adjacentPairs = [[4,-2],[1,4],[-3,1]]
 * 输出：[-2,4,1,-3]
 * 解释：数组中可能存在负数。
 * 另一种解答是 [-3,1,4,-2] ，也会被视作正确答案。
 * 示例 3：
 *
 * 输入：adjacentPairs = [[100000,-100000]]
 * 输出：[100000,-100000]
 *
 *
 * 提示：
 *
 * nums.length == n
 * adjacentPairs.length == n - 1
 * adjacentPairs[i].length == 2
 * 2 <= n <= 105
 * -105 <= nums[i], ui, vi <= 105
 * 题目数据保证存在一些以 adjacentPairs 作为元素对的数组 nums
 *
 * @author guojun
 * @date 2021/1/21 10:40
 */
public class TestSolution1743 {
    private static final org.slf4j.Logger logger = LoggerFactory.getLogger(TestSolution1743.class);


    static class Solution {

        /**
         * 执行结果：
         * 通过
         * 显示详情
         * 添加备注
         *
         * 执行用时：187 ms, 在所有 Java 提交中击败了8.13%的用户
         * 内存消耗：84.9 MB, 在所有 Java 提交中击败了63.13%的用户
         * 通过测试用例：
         * 46 / 46
         *
         *
         * 读懂题目比较关键 ，"n 个不同元素组成的整数数组" => 得出，只会有两个元素出现次数为1作为首尾， 其他元素都是出现两次，
         * 所以答案数组只会有两种，基于上述思考
         * @param adjacentPairs
         * @return
         */
        public int[] restoreArray(int[][] adjacentPairs) {
            Map<Integer, Integer> key2AmountMap = new HashMap<>();
            int[] res = new int[adjacentPairs.length + 1];
            int len = adjacentPairs.length + 1;
            Map<Integer, List<Integer>> key2ObjMap = new HashMap<>();
            for (int[] adjacentPair : adjacentPairs) {
                int key1 = adjacentPair[0];
                int key2 = adjacentPair[1];
                key2AmountMap.compute(key1, (key, oldVal) -> {
                    if (null == oldVal) {
                        return 1;
                    } else {
                        oldVal ++;
                        return oldVal;
                    }
                });
                key2AmountMap.compute(key2, (key, oldVal) -> {
                    if (null == oldVal) {
                        return 1;
                    } else {
                        oldVal ++;
                        return oldVal;
                    }
                });

                key2ObjMap.compute(key1, (key, oldVal) -> {
                    if (null == oldVal) {
                        List<Integer> list = new ArrayList<Integer>();
                        list.add(key2);
                        return list;
                    }
                    oldVal.add(key2);
                    return oldVal;
                });
                key2ObjMap.compute(key2, (key, oldVal) -> {
                    if (null == oldVal) {
                        List<Integer> list = new ArrayList<Integer>();
                        list.add(key1);
                        return list;
                    }
                    oldVal.add(key1);
                    return oldVal;
                });
            }//end prepare

            //start
            int startKey = 0;
            for (Map.Entry<Integer, Integer> integerIntegerEntry : key2AmountMap.entrySet()) {
                if (integerIntegerEntry.getValue() ==1) {
                    startKey = integerIntegerEntry.getKey();
                    break;
                }
            }
            int k = 0;
            res[k++] = startKey;
            res[k++] = key2ObjMap.get(startKey).get(0);
            int preKey = startKey;
            int doKey = res[1];
            while (k < len) {
                final int finalPreKey = preKey;
                Integer currKey = key2ObjMap.get(doKey).stream().filter(val -> val != finalPreKey).findFirst().get();
                res[k++] = currKey;
                preKey = doKey;
                doKey = currKey;
            }
            return res;
        }



    }

    public static void main(String[] args) {
        logger.info("{}", new Solution().restoreArray(new int[][]{
                {2,1},{3,4},{3,2}
        }));//1,2,3,4
        logger.info("{}", new Solution().restoreArray(new int[][]{
                {100000,-100000}
        }));//100000,-100000
    }
}
