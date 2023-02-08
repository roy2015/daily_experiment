package com.guo.roy.research.leetcode.stage1.stage13;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

import org.slf4j.LoggerFactory;

/**
 *
 * 935. 骑士拨号器
 * 象棋骑士有一个独特的移动方式，它可以垂直移动两个方格，水平移动一个方格，或者水平移动两个方格，垂直移动一个方格(两者都形成一个 L 的形状)。
 *
 * 象棋骑士可能的移动方式如下图所示:
 *
 *
 *
 * 我们有一个象棋骑士和一个电话垫，如下所示，骑士只能站在一个数字单元格上(即蓝色单元格)。
 *
 *
 *
 * 给定一个整数 n，返回我们可以拨多少个长度为 n 的不同电话号码。
 *
 * 你可以将骑士放置在任何数字单元格上，然后你应该执行 n - 1 次移动来获得长度为 n 的号码。所有的跳跃应该是有效的骑士跳跃。
 *
 * 因为答案可能很大，所以输出答案模 109 + 7.
 *
 *
 *
 * 示例 1：
 *
 * 输入：n = 1
 * 输出：10
 * 解释：我们需要拨一个长度为1的数字，所以把骑士放在10个单元格中的任何一个数字单元格上都能满足条件。
 * 示例 2：
 *
 * 输入：n = 2
 * 输出：20
 * 解释：我们可以拨打的所有有效号码为[04, 06, 16, 18, 27, 29, 34, 38, 40, 43, 49, 60, 61, 67, 72, 76, 81, 83, 92, 94]
 * 示例 3：
 *
 * 输入：n = 3131
 * 输出：136006598
 * 解释：注意取模
 *
 *
 * 提示：
 *
 * 1 <= n <= 5000
 *
 * @author guojun
 * @date 2022/1/22 13:44
 */
public class TestSolution935 {
    private static final org.slf4j.Logger logger = LoggerFactory.getLogger(TestSolution935.class);


    static class Solution {

        public int knightDialer(int n) {
            if (n == 1) {
                return 10;
            }
            //构建映射
            HashMap<Integer, List<Integer>> dicMap = new HashMap<>();
            dicMap.put(0, Arrays.asList(4, 6));
            dicMap.put(1, Arrays.asList(6, 8));
            dicMap.put(2, Arrays.asList(7, 9));
            dicMap.put(3, Arrays.asList(4, 8));
            dicMap.put(4, Arrays.asList(3, 0, 9));
            dicMap.put(6, Arrays.asList(1, 0, 7));
            dicMap.put(7, Arrays.asList(2, 6));
            dicMap.put(8, Arrays.asList(1, 3));
            dicMap.put(9, Arrays.asList(2, 4));

            int[] store = new int[10];
            Arrays.fill(store, 1);
            store[5] = 0;
            int[] nextStore;
            int sum = 0;
            for (int i = 1; i < n; i++) {
                sum = 0;
                nextStore = new int[10];
                for (int oldIdx = 0; oldIdx < store.length; oldIdx++) {
                    if (oldIdx == 5) {
                        continue;
                    }
                    int times = store[oldIdx];
                    for (Integer dicItem : dicMap.get(oldIdx)) {
                        nextStore[dicItem] += times;
                        sum += times;
                        nextStore[dicItem] %= (1E+9 + 7);
                        sum %= (1E+9 + 7);
                    }
                }
                store = nextStore;
            }
            return sum;
        }
    }

    public static void main(String[] args) {
        logger.info("{}", new Solution().knightDialer(1));//10
        logger.info("{}", new Solution().knightDialer(2));//20
        logger.info("{}", new Solution().knightDialer(3));//46
        logger.info("{}", new Solution().knightDialer(4));//104
        logger.info("{}", new Solution().knightDialer(20));//58689536
        logger.info("{}", new Solution().knightDialer(50));//267287516
    }
}
