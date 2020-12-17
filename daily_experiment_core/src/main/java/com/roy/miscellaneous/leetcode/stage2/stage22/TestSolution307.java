package com.roy.miscellaneous.leetcode.stage2.stage22;

import org.slf4j.LoggerFactory;

/**
 * @author guojun
 * @date 2020/12/07
 *
 *307. 区域和检索 - 数组可修改
 * 给定一个整数数组  nums，求出数组从索引 i 到 j  (i ≤ j) 范围内元素的总和，包含 i,  j 两点。
 *
 * update(i, val) 函数可以通过将下标为 i 的数值更新为 val，从而对数列进行修改。
 *
 * 示例:
 *
 * Given nums = [1, 3, 5]
 *
 * sumRange(0, 2) -> 9
 * update(1, 2)
 * sumRange(0, 2) -> 8
 * 说明:
 *
 * 数组仅可以在 update 函数下进行修改。
 * 你可以假设 update 函数与 sumRange 函数的调用次数是均匀分布的。
 *
 *
 */
public class TestSolution307 {
    private static final org.slf4j.Logger logger = LoggerFactory.getLogger(TestSolution307.class);


    /**
     *
     * 树状数组 @link{ https://blog.csdn.net/bestsort/article/details/80796531 }
     * ， O(logn)的更新和求区间和，前缀和, 求前缀喝也是O(logn)
     *
     * 之所以能实现O(logn)的关键： j & (-j) 求末尾1
     *
     * 执行结果：
     * 通过
     * 显示详情
     * 执行用时：14 ms, 在所有 Java 提交中击败了81.06%的用户
     * 内存消耗：44.6 MB, 在所有 Java 提交中击败了43.27%的用户
     *
     */
    static class NumArray {
        private int[] c;
        private int[] origin;

        public NumArray(int[] nums) {
            int len = nums.length;
            c = new int[len + 1];
            origin = nums;

            //构建初始树状数组,不能走通用#update，因为update要更新原来数组
            for (int i = 1; i <= len; i++) {
                int iVal = origin[i - 1];
                for (int j = i; j <= origin.length ; j += j & (-j)) {
                    c[j] +=  iVal;
                }
            }
        }

        public void update(int i, int val) {
            i = i + 1;
            int gap = val - origin[i -1];
            for (int j = i; j <= origin.length ; j += j & (-j)) {
                c[j] +=  gap;
            }
            //update with new Value
            origin[i -1] = val;
        }

        /**
         * 两个前缀和相减即可，如果一味想求区间将比较苦恼
         * @param i
         * @param j
         * @return
         */
        public int sumRange(int i, int j) {
            j++;
            int retVal;

            int sum1 = 0;
            int sum2 = 0;

            for (int k = j; k > 0 ; k -= k & (-k)) {
                sum1 += c[k];
            }

            for (int k = i; k > 0 ; k -= k & (-k)) {
                sum2 += c[k];
            }

            retVal = sum1 - sum2;
            return retVal;
        }
    }

    public static void main(String[] args) {
        NumArray obj;
        obj = new NumArray(new int[]{7, 2, 7, 2 , 0});
        obj.update(4,6);
        obj.update(0,2);
        obj.update(0,9);
        obj.update(3,8);
        logger.info("{}", obj.sumRange(0,4));//32


        obj = new NumArray(new int[]{9, -8});
        obj.update(0,3);
        logger.info("{}", obj.sumRange(1,1));//-8

        obj = new NumArray(new int[]{-1});
        logger.info("{}", obj.sumRange(0,0));//-1
        obj.update(0,1);
        logger.info("{}", obj.sumRange(0,0));//1


        obj = new NumArray(new int[]{1,3,5});
        logger.info("{}", obj.sumRange(0,2));//9
        obj.update(1,2);
        logger.info("{}", obj.sumRange(2,2));//5


    }
}
