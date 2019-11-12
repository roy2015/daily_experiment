package com.roy.miscellaneous.leetcode.stage1;

import org.slf4j.LoggerFactory;

import java.util.Arrays;
import java.util.BitSet;

/**
 * Created by apple on 2019/11/12.
 *在大小为 2N 的数组 A 中有 N+1 个不同的元素，其中有一个元素重复了 N 次。

 返回重复了 N 次的那个元素。

  

 示例 1：

 输入：[1,2,3,3]
 输出：3
 示例 2：

 输入：[2,1,2,5,3,2]
 输出：2
 示例 3：

 输入：[5,1,5,2,5,3,5,4]
 输出：5
  

 提示：

 4 <= A.length <= 10000
 0 <= A[i] < 10000
 A.length 为偶数

 来源：力扣（LeetCode）
 链接：https://leetcode-cn.com/problems/n-repeated-element-in-size-2n-array
 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 */
public class TestSolution961 {
    private static final org.slf4j.Logger logger = LoggerFactory.getLogger(TestSolution961.class);

    /**
     */
    static class Solution {
        /**
         *
         * 排序找中间点
         *
         * 执行用时 :8 ms, 在所有 java 提交中击败了40.48%的用户
         内存消耗 :38.5 MB, 在所有 java 提交中击败了95.14%的用户
         * @param A
         * @return
         */
        public int repeatedNTimes(int[] A) {
            Arrays.sort(A);
            int k = A.length /2;
            return A[k] == A[k + 1] ? A[k]  : A[k-1] ;
        }

        /**
         *
         * 思路：只有一个元素出现2次数以上，其它都是出现一次
         *
         * 使用bitset记录是否出现， 长度10000，也可以使用HashSet，但大数据量时还是使用bitset，节省空间
         *
         * 执行用时 :1 ms, 在所有 java 提交中击败了94.55%的用户
         内存消耗 :38 MB, 在所有 java 提交中击败了96.16%的用户
         *
         * @param A
         * @return
         */
        public int repeatedNTimes1(int[] A) {
            BitSet bitSet = new BitSet(10000);
            for (int i : A) {
                if (bitSet.get(i)) {
                    return i;
                } else {
                    bitSet.set(i, true);
                }
            }
            return 0;
        }
    }

    public static void main(String[] args) {
        logger.info("{}", new Solution().repeatedNTimes1(new int[]{
                5,1,5,2,5,3,5,4
        }));
    }

}
