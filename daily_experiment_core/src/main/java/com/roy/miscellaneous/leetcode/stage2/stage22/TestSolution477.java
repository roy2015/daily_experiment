package com.roy.miscellaneous.leetcode.stage2.stage22;

import com.roy.miscellaneous.leetcode.CommonUtils;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author guojun
 * @date 2020/10/10
 *
 *
 * 477. 汉明距离总和
 * 两个整数的 汉明距离 指的是这两个数字的二进制数对应位不同的数量。
 *
 * 计算一个数组中，任意两个数之间汉明距离的总和。
 *
 * 示例:
 *
 * 输入: 4, 14, 2
 *
 * 输出: 6
 *
 * 解释: 在二进制表示中，4表示为0100，14表示为1110，2表示为0010。（这样表示是为了体现后四位之间关系）
 * 所以答案为：
 * HammingDistance(4, 14) + HammingDistance(4, 2) + HammingDistance(14, 2) = 2 + 2 + 2 = 6.
 * 注意:
 *
 * 数组中元素的范围为从 0到 10^9。
 * 数组的长度不超过 10^4。
 *
 */
public class TestSolution477 {
    private static final org.slf4j.Logger logger = LoggerFactory.getLogger(TestSolution477.class);


    static class Solution {

        /**
         *
         * 常规思路
         * 1.求出所有两两组合的pair
         * 2.求每个pair的汉明距离，累计
         * 超出时间限制，组合太多5000W
         *
         * @param nums
         * @return
         */
        public int totalHammingDistance(int[] nums) {

            List<List<Integer>> storeList = new ArrayList<>();

            List<Integer> toSelectedList = new ArrayList<>();
            for (int num : nums) {
                toSelectedList.add(num);
            }
            CommonUtils.getCombination(2, 1, toSelectedList, new ArrayList<>(), storeList);
            int hammingDisSum = 0;
            for (List<Integer> pair : storeList) {
                hammingDisSum += hammingDistance(pair.get(0), pair.get(1));
            }

            return hammingDisSum;
        }






        /**
         * 求汉明距离，
         * @param x  0<=x<=10^9
         * @param y  0<=x<=10^9
         * @return
         */
        public int hammingDistance(int x, int y) {
            int toCal = x ^ y;
            int distance = 0;

            //两种求二进制表示中1的个数,  2循环次数少一些
            //1
            /*int base ;
            for (int i = 0; i < 32; i++) {
                base = 0x1 << i;
                if ((toCal & base) == base) {
                    distance ++;
                }
            }*/

            //2
            do {
                //是否个位为1
                if ((toCal & 0x1) == 1) {
                    distance ++;
                }
                toCal = toCal >> 1;
            } while (toCal != 0);

            return distance;
        }


        /**
         * 参考思路
         *  横向转纵向，一对一对的数 -> 所有数的每个bit 每列表示所有的bit, 每列的汉明距离 a0* a1, a0:0的个数  a1:1的个数 ; 累加每列的汉明距离
         *
         *  总结： 一批1，0的异或运算实际上是1的个数*0的个数
         *
         *
         *
         *执行结果：
         * 通过
         * 显示详情
         * 执行用时：18 ms, 在所有 Java 提交中击败了41.78%的用户
         * 内存消耗：39.8 MB, 在所有 Java 提交中击败了91.64%的用户
         *
         * @param nums
         * @return
         */
        public int totalHammingDistance1(int[] nums) {
            int length = nums.length;
            int totalHammingDis = 0;
//            int everyBitHammingDis ;
            for (int i = 0; i < 31; i++) {
                int bit0Cnt = 0;
                for (int num : nums) {
                    if (((num >> i) & 0x1) == 0) {
                        bit0Cnt ++;
                    }
                }
                totalHammingDis += bit0Cnt * (length - bit0Cnt);
            }
            return totalHammingDis;
        }

    }

    public static void main(String[] args) {
        /*logger.info("{}", new Solution().hammingDistance(14,4));//2
        logger.info("{}", new Solution().hammingDistance(2,4));//2
        logger.info("{}", new Solution().hammingDistance(2,14));//2*/


//        logger.info("{}", CommonUtils.calCombination(10000, 2));
        logger.info("{}", new Solution().totalHammingDistance1(new int[]{4, 14, 2}));//6




    }
}
