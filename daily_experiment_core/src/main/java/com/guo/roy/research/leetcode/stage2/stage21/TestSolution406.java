package com.guo.roy.research.leetcode.stage2.stage21;

import java.util.Arrays;
import java.util.LinkedList;

import org.slf4j.LoggerFactory;

/**
 * @author guojun
 * @date 2021/3/9
 *
 *
 * 406. 根据身高重建队列
 * 假设有打乱顺序的一群人站成一个队列，数组 people 表示队列中一些人的属性（不一定按顺序）。每个 people[i] = [hi, ki] 表示第 i 个人的身高为 hi ，前面 正好 有 ki 个身高大于或等于 hi 的人。
 *
 * 请你重新构造并返回输入数组 people 所表示的队列。返回的队列应该格式化为数组 queue ，其中 queue[j] = [hj, kj] 是队列中第 j 个人的属性（queue[0] 是排在队列前面的人）。
 *
 *
 *
 * 示例 1：
 *
 * 输入：people = [[7,0],[4,4],[7,1],[5,0],[6,1],[5,2]]
 * 输出：[[5,0],[7,0],[5,2],[6,1],[4,4],[7,1]]
 * 解释：
 * 编号为 0 的人身高为 5 ，没有身高更高或者相同的人排在他前面。
 * 编号为 1 的人身高为 7 ，没有身高更高或者相同的人排在他前面。
 * 编号为 2 的人身高为 5 ，有 2 个身高更高或者相同的人排在他前面，即编号为 0 和 1 的人。
 * 编号为 3 的人身高为 6 ，有 1 个身高更高或者相同的人排在他前面，即编号为 1 的人。
 * 编号为 4 的人身高为 4 ，有 4 个身高更高或者相同的人排在他前面，即编号为 0、1、2、3 的人。
 * 编号为 5 的人身高为 7 ，有 1 个身高更高或者相同的人排在他前面，即编号为 1 的人。
 * 因此 [[5,0],[7,0],[5,2],[6,1],[4,4],[7,1]] 是重新构造后的队列。
 * 示例 2：
 *
 * 输入：people = [[6,0],[5,0],[4,0],[3,2],[2,2],[1,4]]
 * 输出：[[4,0],[5,0],[2,2],[3,2],[1,4],[6,0]]
 *
 *
 * 提示：
 *
 * 1 <= people.length <= 2000
 * 0 <= hi <= 106
 * 0 <= ki < people.length
 * 题目数据确保队列可以被重建
 *
 *
 *
 */
public class TestSolution406 {
    private static final org.slf4j.Logger logger = LoggerFactory.getLogger(TestSolution406.class);


    static class Solution {
        /**
         *
         * 参考的思路
         *
         * 执行结果：
         * 通过
         * 显示详情
         * 执行用时：
         * 526 ms
         * , 在所有 Java 提交中击败了
         * 5.25%
         * 的用户
         * 内存消耗：
         * 38.9 MB
         * , 在所有 Java 提交中击败了
         * 99.53%
         * 的用户
         * @param people
         * @return
         */
        public int[][] reconstructQueue(int[][] people) {
            LinkedList<int[]> res = new LinkedList<>();
            Arrays.sort(people, (o1, o2) -> o1[0] == o2[0] ? o1[1] - o2[1] : o2[0] - o1[0]);
            for (int[] person : people) {
                int height = person[0];
                int beforeHas = person[1];

                int size = res.size();
                if (size == 0) {
                    res.addFirst(person);
                    continue;
                }

                int k = 0;
                int i = 0;
                for ( ; k < beforeHas; i++) {
                    if(res.get(i)[0] >= height ) {
                        k ++;
                    }
                }
                res.add(i, person);
            }
            int[][] resInts = new int[people.length][];
            int k = 0;
            for (int[] re : res) {
                resInts[k++] = re;
            }
            return resInts;
        }
    }

    public static void main(String[] args) {

        int[][] ints = new Solution().reconstructQueue(new int[][]{
                {7, 0}, {4, 4}, {7, 1}, {5, 0}, {6, 1}, {5, 2}
        });

        logger.info("{}", ints);//[5,0],[7,0],[5,2],[6,1],[4,4],[7,1]
    }
}
