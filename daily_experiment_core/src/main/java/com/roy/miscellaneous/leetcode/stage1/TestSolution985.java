package com.roy.miscellaneous.leetcode.stage1;

import org.slf4j.LoggerFactory;

import java.util.HashSet;

/**
 * Created by apple on 2019/10/22.
 *给出一个整数数组 A 和一个查询数组 queries。

 对于第 i 次查询，有 val = queries[i][0], index = queries[i][1]，我们会把 val 加到 A[index] 上。然后，第 i 次查询的答案是 A 中偶数值的和。

 （此处给定的 index = queries[i][1] 是从 0 开始的索引，每次查询都会永久修改数组 A。）

 返回所有查询的答案。你的答案应当以数组 answer 给出，answer[i] 为第 i 次查询的答案。

  

 示例：

 输入：A = [1,2,3,4], queries = [[1,0],[-3,1],[-4,0],[2,3]]
 输出：[8,6,2,4]
 解释：
 开始时，数组为 [1,2,3,4]。
 将 1 加到 A[0] 上之后，数组为 [2,2,3,4]，偶数值之和为 2 + 2 + 4 = 8。
 将 -3 加到 A[1] 上之后，数组为 [2,-1,3,4]，偶数值之和为 2 + 4 = 6。
 将 -4 加到 A[0] 上之后，数组为 [-2,-1,3,4]，偶数值之和为 -2 + 4 = 2。
 将 2 加到 A[3] 上之后，数组为 [-2,-1,3,6]，偶数值之和为 -2 + 6 = 4。
  

 提示：

 1 <= A.length <= 10000
 -10000 <= A[i] <= 10000
 1 <= queries.length <= 10000
 -10000 <= queries[i][0] <= 10000
 0 <= queries[i][1] < A.length

 来源：力扣（LeetCode）
 链接：https://leetcode-cn.com/problems/sum-of-even-numbers-after-queries
 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 *
 * 心得： 判断奇数要考虑负数  x % 2 == 1是不对的， 应该 x % 2 != 0或者用 x & 1 != 0
 */
public class TestSolution985 {
    private static final org.slf4j.Logger logger = LoggerFactory.getLogger(TestSolution985.class);


    static class Solution {
        /**
         *
         * 正常思维下
         * 1492ms???
         * 执行用时 :1492 ms, 在所有 java 提交中击败了5.11%的用户
         内存消耗 :61.5 MB, 在所有 java 提交中击败了79.58%的用户
         *
         */
        public int[] sumEvenAfterQueries(int[] A, int[][] queries) {
            int[] retArray = new int[queries.length];
            for (int i = 0; i < queries.length; i++) {
                A[queries[i][1]] += queries[i][0];
                retArray[i] = getSumOfEvenNum(A);
            }
            return retArray;
        }

        private int getSumOfEvenNum(int [] arry) {
            int sum =0;
            for (int i : arry) {
                if (i % 2 == 0) {
                    sum += i;
                }
            }
            return sum;
        }

        /**
         *
         * 对前者优化，用了hashSet存已经存在的偶数
         * 16ms，性能还是比较差
         *
         * 执行用时 :16 ms, 在所有 java 提交中击败了15.55%的用
         内存消耗 :59.4 MB, 在所有 java 提交中击败了85.90%的用户
         *
         * @param A
         * @param queries
         * @return
         */
        public int[] sumEvenAfterQueries1(int[] A, int[][] queries) {
            int[] retArray = new int[queries.length];
            int sum = 0;
            HashSet<Object> set = new HashSet<>(queries.length);

            for (int i = 0; i < A.length; i++) {
                if (A[i] % 2 ==0) {
                    sum += A[i];
                    set.add(i);
                }
            }

            for (int i = 0; i < queries.length; i++) {
                if (set.contains(queries[i][1]) == false) {
                    if (queries[i][0] % 2 != 0) {
                        sum += (A[queries[i][1]] + queries[i][0]);
                        set.add(queries[i][1]);
                    }
                } else {//包含
                    if (queries[i][0] % 2 !=0) {//奇 + 偶 = 奇
                        sum -= A[queries[i][1]];
                        set.remove(queries[i][1]);
                    } else {
                        sum += queries[i][0];
                    }

                }
                retArray[i] = sum;
                A[queries[i][1]] += queries[i][0];
            }

            return retArray;
        }

        /**
         *继续优化，去掉 set，其实不需要。 因为 A[index] % 2 == 0 就可以断定index是不是在set里
         *
         *
         * 执行用时 :5 ms, 在所有 java 提交中击败了98.84%的用户
         内存消耗 :59.1 MB, 在所有 java 提交中击败了87.58%的用户
         * @param A
         * @param queries
         * @return
         */
        public int[] sumEvenAfterQueries2(int[] A, int[][] queries) {
            int sum = 0;
            int[] retArray = new int[queries.length];

            for (int i = 0; i < A.length; i++) {
                if (A[i] % 2 ==0) {
                    sum += A[i];
                }
            }

            for (int i = 0; i < queries.length; i++) {
                int index =  queries[i][1];
                int val = queries[i][0];

                if (A[index] % 2 != 0) {//奇
                    if (val % 2 != 0) {//奇
                        sum += (A[index] + val);
                    }
                } else {//偶
                    if (val % 2 !=0) {//奇
                        sum -= A[index];
                    } else {
                        sum += val;
                    }

                }
                retArray[i] = sum;
                A[index] += val;
            }
            return retArray;


        }

        /**
         *
         * 继续优化 ，优化点： 1）把求余运算用 & 代替
         *
         * 执行用时 :4 ms, 在所有 java 提交中击败了100.00%的用户
         内存消耗 :59.5 MB, 在所有 java 提交中击败了85.48%的用户
         *
         * @param A
         * @param queries
         * @return
         */
        public int[] sumEvenAfterQueries3(int[] A, int[][] queries) {
            int sum = 0;
            int[] retArray = new int[queries.length];

            for (int i = 0; i < A.length; i++) {
                if ((A[i] & 1) ==0) {
                    sum += A[i];
                }
            }

            for (int i = 0; i < queries.length; i++) {
                int index =  queries[i][1];
                int val = queries[i][0];

                if ((A[index] & 1) != 0) {//奇
                    if ((val & 1) != 0) {//奇
                        sum += (A[index] + val);
                    }
                } else {//偶
                    if ((val & 1) !=0) {//奇
                        sum -= A[index];
                    } else {
                        sum += val;
                    }

                }
                retArray[i] = sum;
                A[index] += val;
            }
            return retArray;


        }
    }

    public static void main(String[] args) {

        int[] ints = new Solution().sumEvenAfterQueries3(new int[]{1,2,3,4}, new int[][]{{1,0},{-3,1},{-4,0},{2,3}});
        logger.info("{}");
    }

}
