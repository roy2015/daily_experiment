package com.guo.roy.research.leetcode.stage1.stage11;

import java.util.Arrays;

import org.slf4j.LoggerFactory;

/**
 * @author guojun
 * @date 2020/5/7 21:08
 *
 * 给你两个整数数组 nums 和 index。你需要按照以下规则创建目标数组：

目标数组 target 最初为空。
按从左到右的顺序依次读取 nums[i] 和 index[i]，在 target 数组中的下标 index[i] 处插入值 nums[i] 。
重复上一步，直到在 nums 和 index 中都没有要读取的元素。
请你返回目标数组。

题目保证数字插入位置总是存在。

 

示例 1：

输入：nums = [0,1,2,3,4], index = [0,1,2,2,1]
输出：[0,4,1,3,2]
解释：
nums       index     target
0            0        [0]
1            1        [0,1]
2            2        [0,1,2]
3            2        [0,1,3,2]
4            1        [0,4,1,3,2]
示例 2：

输入：nums = [1,2,3,4,0], index = [0,1,2,3,0]
输出：[0,1,2,3,4]
解释：
nums       index     target
1            0        [1]
2            1        [1,2]
3            2        [1,2,3]
4            3        [1,2,3,4]
0            0        [0,1,2,3,4]
示例 3：

输入：nums = [1], index = [0]
输出：[1]
 

提示：

1 <= nums.length, index.length <= 100
nums.length == index.length
0 <= nums[i] <= 100
0 <= index[i] <= i

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/create-target-array-in-the-given-order
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class TestSolution1389 {
    private static final org.slf4j.Logger logger = LoggerFactory.getLogger(TestSolution1389.class);


    static class Solution {

        /**
         *
         * 用第三个数组，位置被占用往后挪
         *
         *
         * 执行结果：通过
         * 显示详情
         * 执行用时 :1 ms, 在所有 Java 提交中击败了89.42%的用户
         * 内存消耗 :38.4 MB, 在所有 Java 提交中击败了100.00%的用户
         *
         *
         * @param nums
         * @param index
         * @return
         */
        public int[] createTargetArray(int[] nums, int[] index) {
            int[] retInts = new int[nums.length];
            Arrays.fill(retInts, -1);

            for (int i = 0; i < index.length; i++) {
                if (retInts[index[i]] != -1) {
                    for (int i1 = retInts.length - 1; i1 > index[i]; i1--) {
                        retInts[i1] = retInts[i1 - 1];
                    }
                }
                retInts[index[i]] = nums[i];
            }
            return retInts;
        }
    }

    public static void main(String[] args) {

        logger.info("{}", new TestSolution1389.Solution().
                createTargetArray(new int[]{0,1,2,3,4}, new int[]{0,1,2,2,1}));

        int i =0;
    }
}
