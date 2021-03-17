package com.roy.miscellaneous.leetcode.stage1.stage10;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

import org.slf4j.LoggerFactory;

/**
 * Created by apple on 2019/9/16.
 *
 *给定一个按非递减顺序排序的整数数组 A，返回每个数字的平方组成的新数组，要求也按非递减顺序排序。

  

 示例 1：

 输入：[-4,-1,0,3,10]
 输出：[0,1,9,16,100]
 示例 2：

 输入：[-7,-3,2,3,11]
 输出：[4,9,9,49,121]

 来源：力扣（LeetCode）
 链接：https://leetcode-cn.com/problems/squares-of-a-sorted-array
 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。

 思路：
  写了三个算法，第一个性能最佳
 执行用时 :
 3 ms
 , 在所有 Java 提交中击败了
 97.93%
 的用户
 内存消耗 :
 40.7 MB
 , 在所有 Java 提交中击败了
 96.07%
 的用户

   1. 二分，双指针

 */
public class TestSolution977 {
    private static final org.slf4j.Logger logger = LoggerFactory.getLogger(TestSolution977.class);

    /**
     */
    static class Solution {

        public int[] sortedSquares(int[] A) {
            int[] retA = new int[A.length];
            if (A[A.length - 1] <= 0) {//全是非正数
                for (int i = 0; i < A.length / 2; i++) {
                    int tmp = A[i];
                    A[i] = A[A.length - 1 - i];
                    A[A.length - 1 - i] = tmp;
                }
                for (int i = 0; i < A.length; i++) {
                    A[i] = A[i] * A[i];
                }
                return A;
            } else if (A[0] >= 0) {//全是非负数
                for (int i = 0; i < A.length; i++) {
                    A[i] = A[i] * A[i];
                }
                return A;
            } else {//有正有负
                int negative = 0;//最后一个负数
                for (int i = 0; i < A.length; i++) {
                    if (A[i] >= 0 ) {
                        negative = i -1;
                        break;
                    }
                }
                int lIndex = negative;
                int rIndex = negative +1;
                int k =0;
                while (lIndex >= 0 || rIndex < A.length) {
                    if ( rIndex >= A.length || (lIndex >= 0 && (Math.abs(A[lIndex]) <= Math.abs(A[rIndex])))) {
                        retA[k++] = A[lIndex];
                        lIndex --;
                    } else {
                        retA[k++] = A[rIndex];
                        rIndex ++;
                    }
                }
                for (int i = 0; i < A.length; i++) {
                    A[i] = retA[i] * retA[i];
                }
                return A;

            }

        }

        public int[] sortedSquares1(int[] A) {
            for (int j = A.length -2; j >= 0; j--) {
                for (int i = 0; i <= j ; i++) {
                    if (Math.abs(A[i]) > Math.abs(A[i + 1])) {
                        int tmp = A[i];
                        A[i] = A[i + 1];
                        A[i + 1] = tmp;
                    }
                }
            }
            for (int i = 0; i < A.length; i++) {
                A[i] = A[i] * A[i];
            }
            return A;

        }

        public int[] sortedSquares2(int[] A) {
            List<Integer> list = new ArrayList<>(A.length);
            for (int i : A) {
                list.add(i);
            }

            list.sort(new Comparator<Integer>() {
                @Override
                public int compare(Integer o1, Integer o2) {
                    return  Math.abs(o1) - Math.abs(o2);

                }
            });

            for (int i = 0; i < A.length; i++) {
                A[i] = list.get(i) * list.get(i);
            }
            return A;
        }

    }

    public static void main(String[] args) {
        logger.info("{}", new Solution().sortedSquares(new int[]{-3,-3,-2,1}));
    }

}
