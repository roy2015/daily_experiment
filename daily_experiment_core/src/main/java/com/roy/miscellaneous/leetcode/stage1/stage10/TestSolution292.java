package com.roy.miscellaneous.leetcode.stage1.stage10;

import org.slf4j.LoggerFactory;

/**
 * Created by apple on 2019/11/4.
 *你和你的朋友，两个人一起玩 Nim 游戏：桌子上有一堆石头，每次你们轮流拿掉 1 - 3 块石头。 拿掉最后一块石头的人就是获胜者。你作为先手。

 你们是聪明人，每一步都是最优解。 编写一个函数，来判断你是否可以在给定石头数量的情况下赢得游戏。

 示例:

 输入: 4
 输出: false
 解释: 如果堆中有 4 块石头，那么你永远不会赢得比赛；
      因为无论你拿走 1 块、2 块 还是 3 块石头，最后一块石头总是会被你的朋友拿走。

 来源：力扣（LeetCode）
 链接：https://leetcode-cn.com/problems/nim-game
 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 */
public class TestSolution292 {
    private static final org.slf4j.Logger logger = LoggerFactory.getLogger(TestSolution292.class);

    /**
     *
     * 执行用时 :0 ms, 在所有 java 提交中击败了100.00%的用户
     内存消耗 :32.8 MB, 在所有 java 提交中击败了14.57%的用户
     */
    static class Solution {
        public boolean canWinNim(int n) {
            return n % 4 == 0 ? false : true ;
        }
    }

    public static void main(String[] args) {
        logger.info("{}", new Solution().canWinNim(4));
    }

}
