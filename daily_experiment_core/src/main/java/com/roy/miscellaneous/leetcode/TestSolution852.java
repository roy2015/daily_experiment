package com.roy.miscellaneous.leetcode;

import org.slf4j.LoggerFactory;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by apple on 2019/9/29.
 *
 *
 * peakIndexInMountainArrayNew
 * 执行结果：
 通过 显示详情
 执行用时 : 0 ms, 在所有 Java 提交中击败了 100.00%的用户
 内存消耗 :38.1 MB, 在所有 Java 提交中击败了95.64%的用户
 *
 *
 *
 * 我们把符合下列属性的数组 A 称作山脉：

 A.length >= 3
 存在 0 < i < A.length - 1 使得A[0] < A[1] < ... A[i-1] < A[i] > A[i+1] > ... > A[A.length - 1]
 给定一个确定为山脉的数组，返回任何满足 A[0] < A[1] < ... A[i-1] < A[i] > A[i+1] > ... > A[A.length - 1] 的 i 的值。

  

 示例 1：

 输入：[0,1,0]
 输出：1
 示例 2：

 输入：[0,2,1,0]
 输出：1

 来源：力扣（LeetCode）
 链接：https://leetcode-cn.com/problems/peak-index-in-a-mountain-array
 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 */
public class TestSolution852 {
    private static final org.slf4j.Logger logger = LoggerFactory.getLogger(TestSolution852.class);

    /**
     */
    static class Solution {
        public int peakIndexInMountainArray(int[] A) {
            for(int i=0;i< A.length-1 ; i++) {
                if (A[i] > A[i+1]) {
                    return i;
                }
            }
            return -1;

        }

        /**
         * 用二分查找的方法， <code>Arrays.binarySearch0</code>从JDK里抄的一段，哈哈
         * @param A
         * @return
         */
        public int peakIndexInMountainArrayNew(int[] A) {
            int low = 0;
            int high = A.length - 1;

            while (low <= high) {
                int mid = (low + high) >>> 1;
                int midVal = A[mid];

                if (midVal > A[mid-1] && midVal < A[mid+1])
                    low = mid + 1;
                else if(midVal < A[mid-1] && midVal > A[mid+1]) {
                    high = mid - 1;
                } else
                    return mid;
            }
            return -1;

        }
    }

    public static void main(String[] args) {
        logger.info("{}", new Solution().peakIndexInMountainArrayNew(new int[]{0,2,1,0}));
    }

}
