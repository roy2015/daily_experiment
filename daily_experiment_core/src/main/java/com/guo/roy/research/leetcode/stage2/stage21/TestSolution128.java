package com.guo.roy.research.leetcode.stage2.stage21;

import org.slf4j.LoggerFactory;

import java.util.HashMap;
import java.util.Map;

/**
 *
 * 给定一个未排序的整数数组 nums ，找出数字连续的最长序列（不要求序列元素在原数组中连续）的长度。
 *
 * 请你设计并实现时间复杂度为 O(n) 的算法解决此问题。
 *
 *  
 *
 * 示例 1：
 *
 * 输入：nums = [100,4,200,1,3,2]
 * 输出：4
 * 解释：最长数字连续序列是 [1, 2, 3, 4]。它的长度为 4。
 * 示例 2：
 *
 * 输入：nums = [0,3,7,2,5,8,4,6,0,1]
 * 输出：9
 *  
 *
 * 提示：
 *
 * 0 <= nums.length <= 105
 * -109 <= nums[i] <= 109
 *
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode.cn/problems/longest-consecutive-sequence
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @author guojun
 * @date 2021/6/11
 */
public class TestSolution128 {
    private static final org.slf4j.Logger logger = LoggerFactory.getLogger(TestSolution128.class);

    /**
     *
     * 133ms
     * 击败 28.80%使用 Java 的用户
     *
     * 63.31mb
     * 击败 4.99%使用 Java 的用户
     *
     */
    static class Solution {

        /**
         * 并查集
         */
        class UnionFind {
            // 记录每个节点的父节点
            private Map<Integer, Integer> parent;

            public UnionFind(int[] nums) {
                parent = new HashMap<>();
                // 初始化父节点为自身
                for (int num : nums) {
                    parent.put(num, num);
                }
            }

            // 寻找x的代表
            public Integer find(int x) {
                // nums不包含x
                if (!parent.containsKey(x)) {
                    return null;
                }
                // 遍历找到x的父节点
                while (x != parent.get(x)) {
                    // 进行路径压缩，不写下面这行也可以，但是时间会慢些
                    parent.put(x, parent.get(parent.get(x)));
                    x = parent.get(x);
                }
                return x;
            }

            // 合并两个连通分量
            public void union(int x, int y) {
                int rootX = find(x);
                int rootY = find(y);
                if (rootX == rootY) {
                    return;
                }
                parent.put(rootX, rootY);
            }
        }

        public int longestConsecutive(int[] nums) {
            UnionFind unionFind = new UnionFind(nums);
            for (int i = 0; i < nums.length; i++) {
                int iVal = nums[i];
                if (!unionFind.parent.containsKey(iVal +1)) {
                    continue;
                }
                int iValLar = unionFind.find(iVal + 1);
                if (unionFind.find(iVal) != iValLar) {
                    unionFind.union(iVal, iValLar);
                }
            }

            int max =0;
            for (int i = 0; i < nums.length; i++) {
                int iVal = nums[i];
                int right = unionFind.find(iVal);
                max = Math.max(max, right - iVal +1);
            }

            return max;
        }
    }

    public static void main(String[] args) {
        logger.info("{}", new Solution().longestConsecutive(new int[]{100,4,200,1,3,2}));//4
    }
}
