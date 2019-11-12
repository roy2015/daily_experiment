package com.roy.miscellaneous.leetcode.stage1;

import org.slf4j.LoggerFactory;

import java.util.*;

/**
 * Created by apple on 2019/10/24.
 *给定一个非空数组，返回此数组中第三大的数。如果不存在，则返回数组中最大的数。要求算法时间复杂度必须是O(n)。

 示例 1:

 输入: [3, 2, 1]

 输出: 1

 解释: 第三大的数是 1.
 示例 2:

 输入: [1, 2]

 输出: 2

 解释: 第三大的数不存在, 所以返回最大的数 2 .
 示例 3:

 输入: [2, 2, 3, 1]

 输出: 1

 解释: 注意，要求返回第三大的数，是指第三大且唯一出现的数。
 存在两个值为2的数，它们都排第二。

 来源：力扣（LeetCode）
 链接：https://leetcode-cn.com/problems/third-maximum-number
 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 */
public class TestSolution414 {
    private static final org.slf4j.Logger logger = LoggerFactory.getLogger(TestSolution414.class);

    /**
     */
    static class Solution {
        /**
         *
         * 常规的想法
         *
         * 执行用时 :13 ms, 在所有 java 提交中击败了21.54%的用户
         内存消耗 :37.8 MB, 在所有 java 提交中击败了74.04%的用户
         *
         * @param nums
         * @return
         */
        public int thirdMax(int[] nums) {
            TreeSet<Integer> treeSet = new TreeSet<>(new Comparator<Integer>() {
                @Override
                public int compare(Integer o1, Integer o2) {
                    return   0 - o1.compareTo(o2);
                }
            });

            for (int num : nums) {
                treeSet.add(num);
            }

            Object[] objects = treeSet.toArray();
            return (int) (objects.length < 3 ? objects[0] : objects[2]);
        }

        /**
         *
         * 用了三指针
         *
         * 执行用时 :2 ms ms, 在所有 java 提交中击败了75.30%的用户
         内存消耗 :37.9 MB, 在所有 java 提交中击败了71.27%的用户
         *
         * @param nums
         * @return
         */
        public int thirdMax1(int[] nums) {
            if (nums.length ==1) {
                return nums[0];
            }

            int p3 , p2 , p1 ;
            int p1val, p2val, p3val;
            p3 = p2 = p1 = 0;
            for (int i = 1; i < nums.length; i++) {
                int cond = getPointerShape(p1, p2, p3);
                int key = nums[i];

                switch (cond) {
                    case 1:
                        p1val = nums[p1];
                        if (key < p1val) {
                            p1 = i;
                            p2 = i;
                        }

                        if (key > p1val) {
                            p2 = i;
                            p3 = i;
                        }

                        break;
                    case 2:
                        p1val = nums[p1];
                        p3val = nums[p3];
                        if (key < p1val) {
                            p1 = i;
                        }
                        if (key > p1val && key < p3val ) {
                            p2 = i;
                        }
                        if (key > p3val) {
                            p2 = p3;
                            p3 = i;
                        }
                        break;
                    case 3:
                        p1val = nums[p1];
                        p3val = nums[p3];
                        if (key < p1val) {
                            p2 = p1;
                            p1 = i;
                        }
                        if (key > p1val && key < p3val ) {
                            p2 = i;
                        }
                        if (key > p3val) {
                            p3 = i;
                        }
                        break;
                    case 4:
                        p1val = nums[p1];
                        p2val = nums[p2];
                        p3val = nums[p3];
                        if (key > p1val && key < p2val ) {
                            p1 = i;
                        }
                        if (key > p2val && key < p3val ) {
                            p1 = p2;
                            p2 = i;
                        }
                        if (key > p3val) {
                            p1 = p2;
                            p2 = p3;
                            p3 = i;
                        }
                }
            }
            return getPointerShape(p1, p2, p3) == 4 ? nums[p1] : nums[p3];

        }

        /**
         *  aaa 1
         *  aac 2
         *  acc 3
         *  abc 4
         *
         * @param p1 最小
         * @param p2 次之
         * @param p3 最大
         * @return
         */
        private int getPointerShape(int p1, int p2, int p3) {
            if (p1 == p2) {
                if (p2 == p3) {
                    return 1;
                } else {
                    return 2;
                }

            } else{
                if ( p2 == p3) {
                    return 3;
                } else if ( p1 != p3) {
                    return 4;
                }
            }
            return 0;
        }

    }

    public static void main(String[] args) {
        logger.info("{}", new Solution().thirdMax1(new int[]{2,3,4, 5,5}));
    }

}
