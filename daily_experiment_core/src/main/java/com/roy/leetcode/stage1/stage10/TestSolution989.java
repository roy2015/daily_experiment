package com.roy.leetcode.stage1.stage10;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

import org.slf4j.LoggerFactory;

/**
 * @author guojun
 * @date 2020/4/27 14:52
 *
 * 989. 数组形式的整数加法
 * 对于非负整数 X 而言，X 的数组形式是每位数字按从左到右的顺序形成的数组。例如，如果 X = 1231，那么其数组形式为 [1,2,3,1]。
 *
 * 给定非负整数 X 的数组形式 A，返回整数 X+K 的数组形式。
 *
 *
 *
 * 示例 1：
 *
 * 输入：A = [1,2,0,0], K = 34
 * 输出：[1,2,3,4]
 * 解释：1200 + 34 = 1234
 * 示例 2：
 *
 * 输入：A = [2,7,4], K = 181
 * 输出：[4,5,5]
 * 解释：274 + 181 = 455
 * 示例 3：
 *
 * 输入：A = [2,1,5], K = 806
 * 输出：[1,0,2,1]
 * 解释：215 + 806 = 1021
 * 示例 4：
 *
 * 输入：A = [9,9,9,9,9,9,9,9,9,9], K = 1
 * 输出：[1,0,0,0,0,0,0,0,0,0,0]
 * 解释：9999999999 + 1 = 10000000000
 *
 *
 * 提示：
 *
 * 1 <= A.length <= 10000
 * 0 <= A[i] <= 9
 * 0 <= K <= 10000
 * 如果 A.length > 1，那么 A[0] != 0
 *
 * 持续优化，三种解法
 */
public class TestSolution989 {
    private static final org.slf4j.Logger logger = LoggerFactory.getLogger(TestSolution989.class);


    static class Solution {

        /**
         *
         * 强写代码，没用之前的 67， 415的
         * 使用了stack
         *
         * 执行结果：
         * 通过
         * 显示详情
         * 执行用时 :7 ms, 在所有 Java 提交中击败了46.98%的用户
         * 内存消耗 :41.6 MB, 在所有 Java 提交中击败了100.00%的用户
         *
         * @param A
         * @param K
         * @return
         */
        public List<Integer> addToArrayForm(int[] A, int K) {
            Stack<Integer> stack = new Stack<>();
            int i = A.length -1;

            int yushu, carry =0;
            int everySum = 0;
            do {
                yushu = K % 10;
                int x = A[i];
                everySum = yushu + x + carry;
                if (everySum > 9) {
                    stack.push(everySum - 10);
                    carry = 1;
                } else {
                    stack.push(everySum);
                    carry =0;
                }
                K = K /10;
                i --;
            } while (K != 0 && i >= 0);

            if (K == 0) {//i >= 0
                if (i >= 0) {
                    for (int j = i; j >= 0; j--) {
                        everySum = A[j] + carry;
                        if (everySum > 9) {
                            stack.push(everySum - 10);
                            carry = 1;
                        } else {
                            stack.push(everySum);
                            carry = 0;
                        }
                    }
                }
            } else {// k !=0
                do {
                    yushu = K % 10;
                    everySum = yushu + carry;
                    if (everySum > 9) {
                        stack.push(everySum - 10);
                        carry = 1;
                    } else {
                        stack.push(everySum);
                        carry =0;
                    }
                    K = K /10;
                } while (K != 0);
            }

            if (carry == 1) {
                stack.push(1);
            }

            List<Integer> retList = new ArrayList<>();
            while (!stack.empty()) {
                retList.add(stack.pop());
            }
            return retList;
        }

        /**
         * 执行结果：
         * 通过
         * 显示详情
         * 执行用时 :9 ms, 在所有 Java 提交中击败了28.89%的用户
         * 内存消耗 :41.9 MB, 在所有 Java 提交中击败了100.00%的用户
         * @param A
         * @param K
         * @return
         */
        public List<Integer> addToArrayForm1(int[] A, int K) {
            StringBuffer retSb = new StringBuffer();
            ArrayList<Integer> kList = new ArrayList<>();
            ArrayList<Integer> aList = new ArrayList<>();
            //准备两个list
            for (int i = A.length - 1; i >= 0; i--) {
                aList.add(A[i]);
            }
            do {
                kList.add( K % 10);
                K = K /10;
            } while (K != 0);

            int aLen = A.length;
            int kLen = kList.size();

            int maxLen = aLen > kLen ? aLen : kLen ;
            int carry =0;
            for (int i = 0; i < maxLen; i++) {
                int aInt = 0, bInt = 0;
                //取两个加数aInt, bInt
                if (i > aLen -1 || i > kLen -1 ) {
                    if (i > aLen -1) {
                        aInt = 0;
                        bInt = kList.get(i);
                    } else {
                        aInt = aList.get(i);
                        bInt = 0;
                    }
                } else {
                    aInt = aList.get(i);
                    bInt = kList.get(i);
                }
                int sub = aInt + bInt + carry;
                //处理相加和进位
                if (sub >= 10) {
                    sub = sub - 10;
                    carry =1;
                    retSb.append(sub);
                    if (i == maxLen - 1) {
                        retSb.append("1");
                    }
                } else {
                    retSb.append(sub);
                    carry = 0;
                }
            }

            List<Integer> retList = new ArrayList<>();
            for (char c : retSb.reverse().toString().toCharArray()) {
                retList.add(c - '0');
            }
            return retList;
        }

        /**
         *
         * 和1差不多，没使用栈， 因为使用栈，最后也是要翻转的，还不如不使用
         *
         * 执行结果：
         * 通过
         * 显示详情
         * 执行用时 :3 ms, 在所有 Java 提交中击败了99.77%的用户
         * 内存消耗 :
         * 41.1 MB, 在所有 Java 提交中击败了100.00%的用户
         *
         * @param A
         * @param K
         * @return
         */
        public List<Integer> addToArrayForm2(int[] A, int K) {
            List<Integer> retList = new ArrayList<>();
            int i = A.length -1;

            int yushu, carry =0;
            int everySum = 0;
            do {
                yushu = K % 10;
                int x = A[i];
                everySum = yushu + x + carry;
                if (everySum > 9) {
                    retList.add(everySum - 10);
                    carry = 1;
                } else {
                    retList.add(everySum);
                    carry =0;
                }
                K = K /10;
                i --;
            } while (K != 0 && i >= 0);

            if (K == 0) {//i >= 0
                if (i >= 0) {
                    for (int j = i; j >= 0; j--) {
                        everySum = A[j] + carry;
                        if (everySum > 9) {
                            retList.add(everySum - 10);
                            carry = 1;
                        } else {
                            retList.add(everySum);
                            carry = 0;
                        }
                    }
                }
            } else {// k !=0
                do {
                    yushu = K % 10;
                    everySum = yushu + carry;
                    if (everySum > 9) {
                        retList.add(everySum - 10);
                        carry = 1;
                    } else {
                        retList.add(everySum);
                        carry =0;
                    }
                    K = K /10;
                } while (K != 0);
            }

            if (carry == 1) {
                retList.add(1);
            }

            ArrayList<Integer> finList = new ArrayList<>();
            for (i = retList.size() -1 ; i>= 0 ; i--) {
                finList.add(retList.get(i));
            }
            return finList;
        }
    }

    public static void main(String[] args) {
        logger.info("{}", new Solution().addToArrayForm2(new int[]{9,9,9,9,9,9,9,9,9,9}, 1));//[1,0,0,0,0,0,0,0,0,0,0]
        logger.info("{}", new Solution().addToArrayForm2(new int[]{1,2,0,0}, 34));//1234
        logger.info("{}", new Solution().addToArrayForm2(new int[]{2,7,4}, 181));//455
        logger.info("{}", new Solution().addToArrayForm2(new int[]{2,1,5}, 806));//1021

        int i = 0;
    }
}
