package com.guo.roy.research.leetcode.stage1.stage12;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.LoggerFactory;

/**
 * @author guojun
 * @date 2020/5/18
 * 1018. 可被 5 整除的二进制前缀
给定由若干 0 和 1 组成的数组 A。我们定义 N_i：从 A[0] 到 A[i] 的第 i 个子数组被解释为一个二进制数（从最高有效位到最低有效位）。

返回布尔值列表 answer，只有当 N_i 可以被 5 整除时，答案 answer[i] 为 true，否则为 false。



示例 1：

输入：[0,1,1]
输出：[true,false,false]
解释：
输入数字为 0, 01, 011；也就是十进制中的 0, 1, 3 。只有第一个数可以被 5 整除，因此 answer[0] 为真。
示例 2：

输入：[1,1,1]
输出：[false,false,false]
示例 3：

输入：[0,1,1,1,1,1]
输出：[true,false,false,false,true,false]
示例 4：

输入：[1,1,1,0,1]
输出：[false,false,false,false,false]


提示：

1 <= A.length <= 30000
A[i] 为 0 或 1
 *
 *
 */
public class TestSolution1018 {
    private static final org.slf4j.Logger logger = LoggerFactory.getLogger(TestSolution1018.class);


    static class Solution {

        /**
         *
         * 不是一道好题，数字容易超界， 3w个1
         *
         * 执行结果：
         通过
         显示详情
         执行用时 :5 ms, 在所有 Java 提交中击败了73.40%的用户
         内存消耗 :40.3 MB, 在所有 Java 提交中击败了50.00%的用户
         *
         * @param A
         * @return
         */
        public List<Boolean> prefixesDivBy5(int[] A) {
            int len = A.length;
            List<Boolean> retList = new ArrayList<Boolean>();
            int num =0;
            for (int i = 0; i < len; i++) {
                num = (num << 1) + A[i];
                //最后一位数字
                num = num % 10;

                if (num % 5 ==0) {
                    retList.add(true);
                } else retList.add(false);
            }
            return retList;
        }
    }

    public static void main(String[] args) {
        logger.info("{}", new Solution().prefixesDivBy5(new int[]{1,0,0,1,0,1,0,0,1,0,1,1,1,1,1,1,1,1,1,1,0,0,0,0,1,0,1,0,0,0,0,1,1,0,1,0,0,0,1}));
//        logger.info("{}", new Solution().prefixesDivBy5(new int[]{0,1,1,1,1,1}));
//        logger.info("{}", new Solution().prefixesDivBy5(new int[]{0,1,1}));
//        logger.info("{}", new Solution().prefixesDivBy5(new int[]{1,1,1}));

    }
}
