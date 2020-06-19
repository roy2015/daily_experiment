package com.roy.miscellaneous.leetcode.stage2.stage21;

import org.slf4j.LoggerFactory;

import java.util.LinkedList;
import java.util.TreeSet;

/**
 * @author guojun
 * @date 2020/6/19
 *
 * 855. 考场就座
 * 在考场里，一排有 N 个座位，分别编号为 0, 1, 2, ..., N-1 。
 *
 * 当学生进入考场后，他必须坐在能够使他与离他最近的人之间的距离达到最大化的座位上。如果有多个这样的座位，他会坐在编号最小的座位上。(另外，如果考场里没有人，那么学生就坐在 0 号座位上。)
 *
 * 返回 ExamRoom(int N) 类，它有两个公开的函数：其中，函数 ExamRoom.seat() 会返回一个 int （整型数据），代表学生坐的位置；函数 ExamRoom.leave(int p) 代表坐在座位 p 上的学生现在离开了考场。每次调用 ExamRoom.leave(p) 时都保证有学生坐在座位 p 上。
 *
 *
 *
 * 示例：
 *
 * 输入：["ExamRoom","seat","seat","seat","seat","leave","seat"], [[10],[],[],[],[],[4],[]]
 * 输出：[null,0,9,4,2,null,5]
 * 解释：
 * ExamRoom(10) -> null
 * seat() -> 0，没有人在考场里，那么学生坐在 0 号座位上。
 * seat() -> 9，学生最后坐在 9 号座位上。
 * seat() -> 4，学生最后坐在 4 号座位上。
 * seat() -> 2，学生最后坐在 2 号座位上。
 * leave(4) -> null
 * seat() -> 5，学生最后坐在 5 号座位上。
 *
 *
 * 提示：
 *
 * 1 <= N <= 10^9
 * 在所有的测试样例中 ExamRoom.seat() 和 ExamRoom.leave() 最多被调用 10^4 次。
 * 保证在调用 ExamRoom.leave(p) 时有学生正坐在座位 p 上。
 *
 */
public class TestSolution855 {
    private static final org.slf4j.Logger logger = LoggerFactory.getLogger(TestSolution855.class);


    /**
     *
     * 用了 红黑树，执行用时不怎么理想哈
     *
     * 执行结果：
     * 通过
     * 显示详情
     * 执行用时：
     * 218 ms, 在所有 Java 提交中击败了7.11%的用户
     * 内存消耗：
     * 40.1 MB, 在所有 Java 提交中击败了75.00%的用户
     *
     */
    static class ExamRoom {
        private int maxIdx;
        private int length;
        private TreeSet<Integer> idxMap;

        public ExamRoom(int N) {
            maxIdx = N -1;
            length = N;
            idxMap = new TreeSet<>();
        }

        public int seat() {
            //满员
            /*if (idxMap.size() == length) {
                return -1;
            }*/

            //没有位置被占，直接占第一个位置
            if (idxMap.isEmpty()) {
                idxMap.add(0);
                return 0;
            }
            //有一个位置被占，和头尾比较,占头尾
            int firstIdx = idxMap.first();
            if (idxMap.size() == 1) {
                int toSeatIdx;
                if (firstIdx < (maxIdx - firstIdx)) {//(0,idx) < (idx, length), place length-1
                    toSeatIdx = maxIdx;
                } else {//else place 0
                    toSeatIdx = 0;
                }
                idxMap.add(toSeatIdx);
                return toSeatIdx;
            }

            //有两个(含)以上位置被占
            int candidateIdx;
            int candidateGap;
            int lastIdx = idxMap.last();

            boolean firstIdxHold = false, lastIdxHold = false;

            if (firstIdx == 0) {
                firstIdxHold = true;
            }
            if (lastIdx == maxIdx) {
                lastIdxHold = true;
            }

            if (!firstIdxHold) {//0位没被占用
                candidateIdx = 0;
                candidateGap = firstIdx - 0;
            } else {
                candidateIdx = 0;
                candidateGap = 0;
            }

            for (Integer idx : idxMap) {
                int idxInt = idx;
                if (candidateGap >= maxIdx - idxInt) {//已经不可能超越candidateGap
                    break;
                }

                Integer nextIdx = idxMap.higher(idx);
                int nextIdxInt;
                int tmpGap;
                int tmpInx;
                if (null == nextIdx) {//最后一个被占用的座位
                    if (!lastIdxHold) {//最后一个被占用的座位不是最后一个座位
                        tmpGap = maxIdx - lastIdx;
                        tmpInx = maxIdx;
                    } else { continue; }
                } else {
                    nextIdxInt = nextIdx;
                    /*if (nextIdx - idx == 1) {//下一个位置被占，坐不了
                        continue;
                    }*/
                    tmpInx = (nextIdxInt + idxInt) / 2;
                    tmpGap = tmpInx - idxInt;
                }
                if (tmpGap > candidateGap) {
                    candidateIdx = tmpInx;
                    candidateGap = tmpGap;
                }
            }
            idxMap.add(candidateIdx);
            return candidateIdx;
        }

        /**
         * 离开座位
         * @param p
         */
        public void leave(int p) {
            idxMap.remove(p);
        }
    }

    public static void main(String[] args) {
        ExamRoom examRoom = new ExamRoom(10);
        logger.info("{}", examRoom.seat());
        logger.info("{}", examRoom.seat());
        logger.info("{}", examRoom.seat());
        logger.info("{}", examRoom.seat());
        examRoom.leave(4); logger.info("");

        logger.info("{}", examRoom.seat());
    }
}
