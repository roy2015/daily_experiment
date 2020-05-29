package com.roy.miscellaneous.leetcode.stage1.stage10;

import org.slf4j.LoggerFactory;

/**
 * Created by apple on 2019/11/9.
 *在一个小镇里，按从 1 到 N 标记了 N 个人。传言称，这些人中有一个是小镇上的秘密法官。

 如果小镇的法官真的存在，那么：

 小镇的法官不相信任何人。
 每个人（除了小镇法官外）都信任小镇的法官。
 只有一个人同时满足属性 1 和属性 2 。
 给定数组 trust，该数组由信任对 trust[i] = [a, b] 组成，表示标记为 a 的人信任标记为 b 的人。

 如果小镇存在秘密法官并且可以确定他的身份，请返回该法官的标记。否则，返回 -1。

  

 示例 1：

 输入：N = 2, trust = [[1,2]]
 输出：2
 示例 2：

 输入：N = 3, trust = [[1,3],[2,3]]
 输出：3
 示例 3：

 输入：N = 3, trust = [[1,3],[2,3],[3,1]]
 输出：-1
 示例 4：

 输入：N = 3, trust = [[1,2],[2,3]]
 输出：-1
 示例 5：

 输入：N = 4, trust = [[1,3],[1,4],[2,3],[2,4],[4,3]]
 输出：3
  

 提示：

 1 <= N <= 1000
 trust.length <= 10000
 trust[i] 是完全不同的
 trust[i][0] != trust[i][1]
 1 <= trust[i][0], trust[i][1] <= N

 来源：力扣（LeetCode）
 链接：https://leetcode-cn.com/problems/find-the-town-judge
 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 */
public class TestSolution997 {
    private static final org.slf4j.Logger logger = LoggerFactory.getLogger(TestSolution997.class);

    /**
     */
    static class Solution {

        /**
         *
         * 得票数为n-1 && 不在黑名单（不信任别人trust[i][0] != key）里, N表示法官  O(n)时间复杂度
         *
         * 注：开始blackList用的是hashset，性能比较差，要12ms,直接用数组就是3ms
         *
         * 执行用时 :3 ms, 在所有 java 提交中击败了93.88%的用户
         内存消耗 :57.9 MB, 在所有 java 提交中击败了97.44%的用户
         *
         * @param N
         * @param trust
         * @return
         */
        public int findJudge(int N, int[][] trust) {
//            HashSet<Integer> blackList = new HashSet<>();
            int[] blackList = new int[N];
            int[] result = new int[N];
            for (int i = 0; i < trust.length; i++) {
                result[trust[i][1] -1] ++;
                blackList[trust[i][0] -1] =1;
            }
            /*if (blackList.size() == N) {
                return -1;
            }*/

            for (int i = 0; i < result.length; i++) {
                if (result[i] == N -1 && blackList[i] ==0) {
                    return i +1;
                }
            }
            return -1;
        }

        /**
         *
         * 矩阵法，类似于比赛对阵胜负表 (X/O)
         *
         * 执行用时 :6 ms, 在所有 java 提交中击败了57.57%的用户
         内存消耗 :64.2 MB, 在所有 java 提交中击败了78.20%的用户
         *
         * @param N
         * @param trust
         * @return
         */
        public int findJudge1(int N, int[][] trust) {
            int[][] store = new int[N][N];
            for (int i = 0; i < trust.length; i++) {
                int s1 = trust[i][0];
                int s2 = trust[i][1];
                store[s1 -1][s2 -1] = 1;
            }
            int row = store.length;
            int col = store[0].length;

            for (int i = 0; i < col; i++) {
                int j ;
                int iLen =store[i].length;
                for (j = 0; j < row; j++) {
                    if (store[j][i] ==0 && i != j) {
                        break;
                    }
                }
                //验证候选
                if (j == iLen) {
                    int k;
                    for (k = 0; k < col; k++) {
                        if (store[i][k] == 1) {
                            break;
                        }
                    }
                    if (k == col) {
                        return i +1;
                    }
                }
            }
            return -1;
        }


        /**
         *
         * 同上, 简化了判断而已
         *
         * 执行用时 :8 ms, 在所有 java 提交中击败了38.72%的用户
         内存消耗 :64.5 MB, 在所有 java 提交中击败了78.20%的用户
         *
         * @param N
         * @param trust
         * @return
         */
        public int findJudge2(int N, int[][] trust) {
            int[][] store = new int[N][N];
            for (int i = 0; i < trust.length; i++) {
                int s1 = trust[i][0];
                int s2 = trust[i][1];
                store[s1 -1][s2 -1] = 1;
            }
            int len = store.length;
            for (int i = 0; i < len; i++) {
                int j;
                for (j = 0; j < len; j++) {
                    if ( i != j && (store[j][i] == 0 || store[i][j] == 1 )) {
                        break;
                    }
                }
                if (j == len) {
                    return i + 1;
                }
            }
            return -1;
        }
    }

    public static void main(String[] args) {
        logger.info("{}", new Solution().findJudge(4, new int[][]{
                {1,3},{1,4},{2,3},{2,4},{4,3}}));
    }

}
