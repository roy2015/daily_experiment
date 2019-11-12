package com.roy.miscellaneous.leetcode.stage1;

import org.slf4j.LoggerFactory;

import java.util.BitSet;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

/**
 * Created by apple on 2019/11/6.
 *给你一个整数数组 arr，请你帮忙统计数组中每个数的出现次数。

 如果每个数的出现次数都是独一无二的，就返回 true；否则返回 false。

  

 示例 1：

 输入：arr = [1,2,2,1,1,3]
 输出：true
 解释：在该数组中，1 出现了 3 次，2 出现了 2 次，3 只出现了 1 次。没有两个数的出现次数相同。
 示例 2：

 输入：arr = [1,2]
 输出：false
 示例 3：

 输入：arr = [-3,0,1,-3,1,1,1,-3,10,0]
 输出：true
  

 提示：

 1 <= arr.length <= 1000
 -1000 <= arr[i] <= 1000

 来源：力扣（LeetCode）
 链接：https://leetcode-cn.com/problems/unique-number-of-occurrences
 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 */
public class TestSolution1207 {
    private static final org.slf4j.Logger logger = LoggerFactory.getLogger(TestSolution1207.class);

    /**
     *
     * 执行用时 :3 ms, 在所有 java 提交中击败了79.50%的用户
     内存消耗 :35.9 MB, 在所有 java 提交中击败了100.00%的用户
     *
     */
    static class Solution {
        public boolean uniqueOccurrences(int[] arr) {
            if (arr == null || arr.length ==0) {
                return false;
            }
            //map映射key出现次数
            Map<Integer, Integer> map = new HashMap<>();
            for (int a : arr) {
                if (!map.containsKey(a)) {
                    map.put(a, 1);
                } else {
                    map.put(a, map.get(a) +1);
                }
            }
            //bitset记录出现
            BitSet bitSet = new BitSet(map.size() +1);
            for (Integer a : map.values()) {
                if(bitSet.get(a)) {
                    return false;
                } else {
                    bitSet.set(a, true);
                }
            }
            return true;
        }

        /**
         *
         * 和上面差不多，没走bitset用的set
         *
         * 执行用时 :3 ms, 在所有 java 提交中击败了79.50%的用户
         内存消耗 :35.7 MB, 在所有 java 提交中击败了100.00%的用户
         * @param arr
         * @return
         */
        public boolean uniqueOccurrences1(int[] arr) {
            if (arr == null || arr.length ==0) {
                return false;
            }
            //map映射key出现次数
            Map<Integer, Integer> map = new HashMap<>();
            for (int a : arr) {
                if (!map.containsKey(a)) {
                    map.put(a, 1);
                } else {
                    map.put(a, map.get(a) +1);
                }
            }
            //走set
            HashSet<Integer> set = new HashSet<>();
            for (Integer a : map.values()) {
                if (set.contains(a)) {
                    return false;
                } else {
                    set.add(a);
                }
            }
            return true;
        }
    }



    public static void main(String[] args) {
        logger.info("{}", new Solution().uniqueOccurrences1(
                new int[]{1,2}
        ));
    }

}
