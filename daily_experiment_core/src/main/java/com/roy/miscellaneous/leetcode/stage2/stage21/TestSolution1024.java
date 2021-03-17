package com.roy.miscellaneous.leetcode.stage2.stage21;

import java.util.*;

import org.slf4j.LoggerFactory;

/**
 * @author guojun
 * @date 2020/9/25
 *
 *
 *       1024. 视频拼接 你将会获得一系列视频片段，这些片段来自于一项持续时长为 T 秒的体育赛事。这些片段可能有所重叠，也可能长度不一。
 *
 *       视频片段 clips[i] 都用区间进行表示：开始于 clips[i][0] 并于 clips[i][1] 结束。我们甚至可以对这些片段自由地再剪辑，例如片段 [0, 7] 可以剪切成 [0, 1] + [1, 3] + [3, 7] 三部分。
 *
 *       我们需要将这些片段进行再剪辑，并将剪辑后的内容拼接成覆盖整个运动过程的片段（[0, T]）。返回所需片段的最小数目，如果无法完成该任务，则返回 -1 。
 *
 *
 *
 *       示例 1：
 *
 *       输入：clips = [[0,2],[4,6],[8,10],[1,9],[1,5],[5,9]], T = 10 输出：3 解释： 我们选中 [0,2], [8,10], [1,9] 这三个片段。 然后，按下面的方案重制比赛片段： 将 [1,9] 再剪辑为 [1,2] + [2,8] + [8,9] 。 现在我们手上有 [0,2] +
 *       [2,8] + [8,10]，而这些涵盖了整场比赛 [0, 10]。 示例 2：
 *
 *       输入：clips = [[0,1],[1,2]], T = 5 输出：-1 解释： 我们无法只用 [0,1] 和 [1,2] 覆盖 [0,5] 的整个过程。 示例 3：
 *
 *       输入：clips = [[0,1],[6,8],[0,2],[5,6],[0,4],[0,3],[6,7],[1,3],[4,7],[1,4],[2,5],[2,6],[3,4],[4,5],[5,7],[6,9]], T = 9 输出：3 解释： 我们选取片段 [0,4], [4,7] 和 [6,9] 。 示例 4：
 *
 *       输入：clips = [[0,4],[2,8]], T = 5 输出：2 解释： 注意，你可能录制超过比赛结束时间的视频。
 *
 *
 *       提示：
 *
 *       1 <= clips.length <= 100 0 <= clips[i][0] <= clips[i][1] <= 100 0 <= T <= 100
 */
public class TestSolution1024 {
    private static final org.slf4j.Logger logger = LoggerFactory.getLogger(TestSolution1024.class);

    static class Solution {
        public void sortClips(int[][] clips) {
            int len = clips.length;

            Map<Integer, List<Integer>> listHashMap = new HashMap<>();
            for (int[] clip : clips) {
                listHashMap.compute(clip[0], (key, oldVal) -> {
                    if (oldVal == null) {
                        List<Integer> newVal = new ArrayList<Integer>();
                        newVal.add(clip[1]);
                        return newVal;
                    } else {
                        oldVal.add(clip[1]);
                        return oldVal;
                    }
                });
            }

            List<Integer> keyList = new ArrayList(listHashMap.keySet());
            Collections.sort(keyList);
            int[][] retInts = clips;
            int k = 0;
            for (Integer key : keyList) {
                List<Integer> integers = listHashMap.get(key);
                for (Integer integer : integers) {
                    retInts[k][0] = key;
                    retInts[k++][1] = integer;
                }
            }
            return;
        }

        /**
         *
         * 学习下贪心算法， debug出来的，思路是借鉴了点
         *
         * 执行结果： 通过 显示详情 执行用时： 3 ms , 在所有 Java 提交中击败了 7.97% 的用户 内存消耗： 37 MB , 在所有 Java 提交中击败了 5.07% 的用户
         *
         * @param clips
         * @param T
         * @return
         */
        public int videoStitching(int[][] clips, int T) {
            int len = clips.length;
            sortClips(clips);
            if (clips[0][0] > 0) {
                return -1;
            }

            int p = 0;// 第几块剪辑
            int useClips = 0;
            boolean multipleZero = false;
            while (p < len && clips[p][1] < T) {

                int q = p + 1;
                int maxQ = p;
                // 从当前点能到达的下一个最远的点
                while (q < len && clips[q][0] <= clips[p][1]) {
                    if (clips[q][1] > clips[maxQ][1]) {
                        maxQ = q;
                    }
                    q++;
                }
                if (maxQ != p) {
                    if (p == 0 && clips[maxQ][0] == 0) {// 多个0区间（以0开始的区间），且最大的不是 第一个
                        useClips = 1;
                    } else if (p == 0 && clips[maxQ][0] != 0) {// 只有一个0区间, maxQ已经到非0区间
                        useClips = 2;
                    } else {
                        useClips++;
                    }
                    p = maxQ;
                } else {// maxQ没变过
                    if (p == 0) {// 第一个区间是0区间是最大的
                        if (clips[q][0] > clips[p][1]) {
                            return -1;
                        } else {
                            useClips = 1;
                            p++;
                        }
                    } else
                        return -1;
                }
            }
            return useClips == 0 ? 1 : useClips;
        }

        /**
         *
         * 同上， 抽出来了0区间的计算, 思路清晰了不少
         *
         *
         * 执行结果：
         * 通过
         * 显示详情
         * 执行用时：
         * 3 ms
         * , 在所有 Java 提交中击败了
         * 7.97%
         * 的用户
         * 内存消耗：
         * 36.9 MB
         * , 在所有 Java 提交中击败了
         * 5.07%
         * 的用户
         *
         * @param clips
         * @param T
         * @return
         */
        public int videoStitching1(int[][] clips, int T) {
            int len = clips.length;
            sortClips(clips);
            if (clips[0][0] > 0) {
                return -1;
            }

            // 为理清思路，0区间单独计算
            int i = 1, maxZero = 0;
            while (clips[i][0] == 0) {
                if (clips[i][1] > clips[maxZero][1]) {
                    maxZero = i;
                }
                i++;
            }

            int p = maxZero;// 第几块剪辑
            int useClips = 1;
            while (p < len && clips[p][1] < T) {

                int q = p + 1;
                int maxQ = p;
                // 从当前点能到达的下一个最远的点
                while (q < len && clips[q][0] <= clips[p][1]) {
                    if (clips[q][1] > clips[maxQ][1]) {
                        maxQ = q;
                    }
                    q++;
                }
                if (maxQ != p) {
                    useClips++;
                    p = maxQ;
                } else {
                    return -1;
                }
            }
            return useClips;
        }
    }

    public static void main(String[] args) {
        int[][] clips;

        clips = new int[][] { { 3, 6 }, { 3, 6 }, { 0, 4 }, { 6, 6 }, { 8, 10 }, { 6, 10 }, { 0, 1 }, { 6, 9 } };
        new Solution().sortClips(clips);
        logger.info("{}", new Solution().videoStitching1(clips, 2));// 1

        clips = new int[][] { { 0, 2 }, { 4, 8 } };
        new Solution().sortClips(clips);
        logger.info("{}", new Solution().videoStitching1(clips, 5));// -1

        clips = new int[][] { { 0, 2 }, { 4, 6 }, { 8, 10 }, { 1, 9 }, { 1, 5 }, { 5, 9 } };
        new Solution().sortClips(clips);
        logger.info("{}", new Solution().videoStitching1(clips, 10));// 3

        clips = new int[][] { { 0, 1 }, { 6, 8 }, { 0, 2 }, { 5, 6 }, { 0, 4 }, { 0, 3 }, { 6, 7 }, { 1, 3 }, { 4, 7 }, { 1, 4 }, { 2, 5 }, { 2, 6 }, { 3, 4 }, { 4, 5 }, { 5, 7 },
                { 6, 9 } };
        logger.info("{}", new Solution().videoStitching1(clips, 9));// 3
    }
}
