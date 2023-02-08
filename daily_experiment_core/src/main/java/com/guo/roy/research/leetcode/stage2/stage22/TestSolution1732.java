package com.guo.roy.research.leetcode.stage2.stage22;

import org.slf4j.LoggerFactory;

/**
 * @author guojun
 * @date 2021/4/1
 *
 *
 * 1732. 找到最高海拔
有一个自行车手打算进行一场公路骑行，这条路线总共由 n + 1 个不同海拔的点组成。自行车手从海拔为 0 的点 0 开始骑行。

给你一个长度为 n 的整数数组 gain ，其中 gain[i] 是点 i 和点 i + 1 的 净海拔高度差（0 <= i < n）。请你返回 最高点的海拔 。



示例 1：

输入：gain = [-5,1,5,0,-7]
输出：1
解释：海拔高度依次为 [0,-5,-4,1,1,-6] 。最高海拔为 1 。
示例 2：

输入：gain = [-4,-3,-2,-1,4,3,2]
输出：0
解释：海拔高度依次为 [0,-4,-7,-9,-10,-6,-3,-1] 。最高海拔为 0 。


提示：

n == gai n.length
1 <= n <= 100
-100 <= gain[i] <= 100
通过次数7,213提交次数8,961
 *
 *
 */
public class TestSolution1732 {
    private static final org.slf4j.Logger logger = LoggerFactory.getLogger(TestSolution1732.class);


    static class Solution {
        public int largestAltitude(int[] gain) {
            int larAiti = 0;
            int length = gain.length;
            int before = 0;
            for (int i = 0; i < length; i++) {
                before = before + gain[i];
                if (before > larAiti) {
                    larAiti = before;
                }
            }
            return larAiti;
        }
    }

    public static void main(String[] args) {
        logger.info("{}", new Solution().largestAltitude(new int[]{-5,1,5,0,-7}));
        logger.info("{}", new Solution().largestAltitude(new int[]{-4,-3,-2,-1,4,3,2}));

    }
}
