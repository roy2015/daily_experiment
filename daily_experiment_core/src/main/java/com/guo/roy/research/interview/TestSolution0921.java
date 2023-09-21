package com.guo.roy.research.interview;

import org.slf4j.LoggerFactory;

/**
 *
 *
 * 20230921面试题目
 *
 * @author guojun
 * @date 2021/6/11
 */
public class TestSolution0921 {
    private static final org.slf4j.Logger logger = LoggerFactory.getLogger(TestSolution0921.class);


    static class Solution {
        private Byte x;

        public Byte getX() {
            return x;
        }

        public int test(int[] nums, int val) {
            int k = 0;
            for (int i = 0; i < nums.length; i++) {
                if (nums[i] == val) {
                    k++;
                }
            }

            for (int i = 0; i < nums.length; i++) {
                if (nums[i] == val) {
                    for (int j = i+1; j < nums.length; j++) {
                        nums[j-1] = nums[j];
                    }
                }
            }
            return nums.length -k;
        }

        public Byte setVal(Byte val) {
            val = 42;
            return val;
        }

        public static void   test2() {
            Solution solution = new Solution();
            System.out.println(solution.getX() + "");
            System.out.println(solution.setVal(solution.getX()));
            System.out.println(solution.getX() + "");

        }

    }

    public static void main(String[] args) {
//        Solution solution = new Solution();
//        logger.info("{}", solution.test(new int[]{3,2,2, 3,2,9,7}, 3));

        Solution.test2();
    }
}
