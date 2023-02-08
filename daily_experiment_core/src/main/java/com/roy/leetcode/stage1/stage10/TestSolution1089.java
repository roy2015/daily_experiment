package com.roy.leetcode.stage1.stage10;

import org.slf4j.LoggerFactory;

/**
 * Created by apple on 2019/9/6.
 *
 *给你一个长度固定的整数数组 arr，请你将该数组中出现的每个零都复写一遍，并将其余的元素向右平移。

 注意：请不要在超过该数组长度的位置写入元素。

 要求：请对输入的数组 就地 进行上述修改，不要从函数返回任何东西。

  

 示例 1：

 输入：[1,0,2,3,0,4,5,0]
 输出：null
 解释：调用函数后，输入的数组将被修改为：[1,0,0,2,3,0,0,4]
 示例 2：

 输入：[1,2,3]
 输出：null
 解释：调用函数后，输入的数组将被修改为：[1,2,3]
  

 提示：

 1 <= arr.length <= 10000
 0 <= arr[i] <= 9

 来源：力扣（LeetCode）
 链接：https://leetcode-cn.com/problems/duplicate-zeros
 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class TestSolution1089 {
    private static final org.slf4j.Logger logger = LoggerFactory.getLogger(TestSolution1089.class);

    /**
     */
    static class Solution {
        /**
         * 执行用时 :19 ms, 在所有 java 提交中击败了32.21%的用户
         * 内存消耗 :37.4 MB, 在所有 java 提交中击败了100.00%的用户
         *
         * @param arr
         */
        public void duplicateZeros(int[] arr) {
            int i = 0;
            while (i < arr.length) {
                if (arr[i] == 0 && i != arr.length -1) {
                    for (int j = arr.length-1 ; j > i ; j--) {
                        arr[j] = arr[j-1];
                    }
                    arr[i + 1] =0;
                    i += 2;
                } else {
                    i ++;
                }
            }
        }
    }

    public static void main(String[] args) {
//        int[] arrys = {1,0,2,3,0,4,5,0};
        int[] arrys = {1,2,3};

        new Solution().duplicateZeros(arrys);
        int i=0;
    }

}
