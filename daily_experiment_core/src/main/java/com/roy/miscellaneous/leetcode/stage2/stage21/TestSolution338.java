package com.roy.miscellaneous.leetcode.stage2.stage21;

import org.slf4j.LoggerFactory;

/**
 * @author guojun
 * @date 2020/12/22
 *
 *
 * 338. 比特位计数
 * 给定一个非负整数 num。对于 0 ≤ i ≤ num 范围中的每个数字 i ，计算其二进制数中的 1 的数目并将它们作为数组返回。
 *
 * 示例 1:
 *
 * 输入: 2
 * 输出: [0,1,1]
 * 示例 2:
 *
 * 输入: 5
 * 输出: [0,1,1,2,1,2]
 * 进阶:
 *
 * 给出时间复杂度为O(n*sizeof(integer))的解答非常容易。但你可以在线性时间O(n)内用一趟扫描做到吗？
 * 要求算法的空间复杂度为O(n)。
 * 你能进一步完善解法吗？要求在C++或任何其他语言中不使用任何内置函数（如 C++ 中的 __builtin_popcount）来执行此操作。
 *
 */
public class TestSolution338 {
    private static final org.slf4j.Logger logger = LoggerFactory.getLogger(TestSolution338.class);


    static class Solution {
        /**
         * 从隐藏提示中得到灵感，找出规律 ，看一下这个表格就知道了，算原创吧
         * 划分区域 1， 2-3，4-7，8-15，本段元素个数是上一端的两倍，本段前半段是把上一段copy一份，
         * 后半段是前半段依次+1
         * //0  (1) ,(2-3) , (4-7), (8-15)    16-31
         * //0  1     12      1223  12232334 1223233423343445
         *
         *
         * 执行结果：通过
         * 显示详情
         * 执行用时：2 ms, 在所有 Java 提交中击败了67.91%的用户
         * 内存消耗：42.4 MB, 在所有 Java 提交中击败了86.28%的用户
         *
         *
         * @param num
         * @return
         */
        public int[] countBits(int num) {
//  (1) ,(2-3) , (4-7), (8-15)    16-31
//0 1     12      1223  12232334 1223233423343445
            if (num == 0) {
                return new int[]{0};
            }
            int[] ret = new int[num +1];
            ret[0] = 0;
            ret[1] = 1;

            int preCount = 1;
            int currCount = preCount << 1;
            int i = 2;
            while (i <= num ) {
                int half = preCount + currCount;
                if (i < half) {
                    ret[i] = ret[i - preCount];
                } else {
                    ret[i] = ret[i - preCount] + 1;
                }
                i++;
                if (i == currCount << 1) {
                    preCount = currCount;
                    currCount <<= 1;
                }
            }

            return ret;
        }

    }

    public static void main(String[] args) {
        logger.info("{}", new Solution().countBits(13));
    }
}
