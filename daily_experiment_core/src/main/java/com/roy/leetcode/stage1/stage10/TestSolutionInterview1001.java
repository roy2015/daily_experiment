package com.roy.leetcode.stage1.stage10;

import org.slf4j.LoggerFactory;

/**
 * @author guojun
 * @date 2020/6/24
 * <p>
 * 面试题 10.01. 合并排序的数组
 * 给定两个排序后的数组 A 和 B，其中 A 的末端有足够的缓冲空间容纳 B。 编写一个方法，将 B 合并入 A 并排序。
 * <p>
 * 初始化 A 和 B 的元素数量分别为 m 和 n。
 * <p>
 * 示例:
 * <p>
 * 输入:
 * A = [1,2,3,0,0,0], m = 3
 * B = [2,5,6],       n = 3
 * <p>
 * 输出: [1,2,2,3,5,6]
 * 说明:
 * <p>
 * A.length == n + m
 */
public class TestSolutionInterview1001 {
    private static final org.slf4j.Logger logger = LoggerFactory.getLogger(TestSolutionInterview1001.class);


    static class Solution {
        /**
         * 双指针
         * 总体思路： 双指针依次比较，较大的元素去填充A后面的空挡
         * 里面有两个套路
         * 1）. A,B有一个是空数组怎么处理
         * 2). 只说两个排序数组，没说升序，降序，两个排序是不是相同规则，最后要求的结果又是升序
         * 注： 你要是把两个数组都弄成相同的排序（比如都升序降序），等于是重排序了，肯定复杂度比较高
         *
         *
         * 执行结果：
         * 通过
         * 显示详情
         * 执行用时：
         * 0 ms, 在所有 Java 提交中击败了100.00%的用户
         * 内存消耗：
         * 39.8 MB, 在所有 Java 提交中击败了100.00%的用户
         *
         * @param A
         * @param m
         * @param B
         * @param n
         */
        public void merge(int[] A, int m, int[] B, int n) {
            int aLen = A.length;
            int p;
            int q;

            int pVal = 0, qVal = 0;
            int idx = aLen - 1;

            int totalAsc = 0; //综合
            int aBit = 1;//a递增
            int bBit = 2;//b递增
            if (m > 1 && A[0] <= A[1]) {
                totalAsc |= aBit;
                p = m - 1;
            } else {//只有一个元素或没有元素的当递减
                totalAsc &= ~aBit;
                p = 0;
            }
            if (n > 1 && B[0] <= B[1]) {
                totalAsc |= bBit;
                q = n - 1;
            } else {
                totalAsc &= ~bBit;
                q = 0;
            }

            //处理m,n为空的情况
            if (m == 0 && n == 0) {
                return;
            }

            if (n == 0) {//B为空， A递增则return
                if ((totalAsc & aBit) != 0) {
                    return;
                } else {
                    qVal = A[m - 1] - 1;
                }
            } else {
                qVal = B[q];
            }

            if (m == 0) {//a为空
                if ((totalAsc & bBit) != 0) {//B递增
                    pVal = B[0] - 1;
                } else {
                    pVal = B[n -1] - 1;
                }
            } else {
                pVal = A[p];
            }

            switch (totalAsc) {
                case 3://11 a ↑ b ↑
                    while (idx >= 0) {
                        if (pVal >= qVal) {
                            A[idx--] = pVal;
                            p--;
                            //准备下一个p
                            if (p >= 0) {
                                pVal = A[p];
                            } else if(q < 0) {//耗尽代表结束
                                return;
                            } else {
                                pVal = B[0] -1;
                            }
                        } else {
                            A[idx--] = qVal;
                            q--;
                            //准备下一个q
                            if (q >= 0) {
                                qVal = B[q];
                            } else if(p < 0) {//耗尽代表结束
                                return;
                            } else {
                                qVal = A[0] -1;
                            }
                        }
                    }
                    break;
                case 1: //0 1 a ↑ b  ↓
                    while (idx >= 0) {
                        if (pVal >= qVal) {
                            A[idx--] = pVal;
                            p--;
                            //准备下一个p
                            if (p >= 0) {
                                pVal = A[p];
                            } else if(q ==n)  {//耗尽代表结束
                                return;
                            }  else {
                                pVal = B[n-1] -1;
                            }
                        } else {
                            A[idx--] = qVal;
                            q++;
                            //准备下一个q
                            if (q < n) {
                                qVal = B[q];
                            } else if(p < 0)  {//耗尽代表结束
                                return;
                            } else {
                                qVal = A[0] -1;
                            }
                        }
                    }
                    break;
                case 2: //1 0 a ↓ b ↑
                    while (idx >= 0) {
                        if (pVal >= qVal) {
                            A[idx--] = pVal;
                            p++;
                            //准备下一个p
                            if (p < m) {
                                pVal = A[p];
                            } else if(q < 0)  {//耗尽代表结束
                                return;
                            } else {
                                pVal = B[0] -1;
                            }
                        } else {
                            A[idx--] = qVal;
                            q--;
                            //准备下一个q
                            if (q >= 0) {
                                qVal = B[q];
                            } else if(p ==m) {//耗尽代表结束
                                return;
                            } else {
                                qVal = A[m -1] -1;
                            }
                        }
                    }
                    break;
                case 0: //0 0 a ↓ b  ↓
                    while (idx >= 0) {
                        if (pVal >= qVal) {
                            A[idx--] = pVal;
                            p++;
                            //准备下一个p
                            if (p < m) {
                                pVal = A[p];
                            } else if(q== n)  {
                                return;
                            } else {
                                pVal = B[n-1] -1;
                            }
                        } else {
                            A[idx--] = qVal;
                            q++;
                            //准备下一个q
                            if (q < n) {
                                qVal = B[q];
                            } else if(p == m){//耗尽代表结束
                                return;
                            } else {
                                qVal = A[m-1] -1;
                            }
                        }
                    }
                    break;
            }
            // end
        }
    }

    public static void main(String[] args) {
        int[] A;
        int[] B;

        A = new int[3];
        B = new int[]{1, 2, 3};
        new Solution().merge(A, 0, B, 3);
        logger.info("{}", A);//1 2 3
        A = new int[]{2, 0};
        B = new int[]{1};
        new Solution().merge(A, 1, B, 1);
        logger.info("{}", A);//1,2

        A = new int[]{1, 2, 0, 0, 0};
        B = new int[]{2, 5, 6};
        new Solution().merge(A, 2, B, 3);
        logger.info("{}", A);//1, 2, 2, 5, 6

        A = new int[]{1};
        B = new int[0];
        new Solution().merge(A, 1, B, 0);
        logger.info("{}", A);//1

        A = new int[1];
        B = new int[]{1};
        new Solution().merge(A, 0, B, 1);
        logger.info("{}", A);//1

        A = new int[]{1, 2, 3};
        B = new int[]{};
        new Solution().merge(A, 3, B, 0);
        logger.info("{}", A);//1 2 3


    }
}
