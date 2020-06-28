package com.roy.miscellaneous.leetcode.stage2.stage21;

import org.slf4j.LoggerFactory;

import java.util.ArrayDeque;
import java.util.HashMap;
import java.util.Map;
import java.util.function.BiFunction;

/**
 * @author guojun
 * @date 2020/6/28
 *
 *
 * 911. 在线选举
 * 在选举中，第 i 张票是在时间为 times[i] 时投给 persons[i] 的。
 *
 * 现在，我们想要实现下面的查询函数： TopVotedCandidate.q(int t) 将返回在 t 时刻主导选举的候选人的编号。
 *
 * 在 t 时刻投出的选票也将被计入我们的查询之中。在平局的情况下，最近获得投票的候选人将会获胜。
 *
 * 示例：
 *
 * 输入：["TopVotedCandidate","q","q","q","q","q","q"], [[[0,1,1,0,0,1,0],[0,5,10,15,20,25,30]],[3],[12],[25],[15],[24],[8]]
 * 输出：[null,0,1,1,0,0,1]
 * 解释：
 * 时间为 3，票数分布情况是 [0]，编号为 0 的候选人领先。
 * 时间为 12，票数分布情况是 [0,1,1]，编号为 1 的候选人领先。
 * 时间为 25，票数分布情况是 [0,1,1,0,0,1]，编号为 1 的候选人领先（因为最近的投票结果是平局）。
 * 在时间 15、24 和 8 处继续执行 3 个查询。
 *
 *
 * 提示：
 *
 * 1 <= persons.length = times.length <= 5000
 * 0 <= persons[i] <= persons.length
 * times 是严格递增的数组，所有元素都在 [0, 10^9] 范围中。
 * 每个测试用例最多调用 10000 次 TopVotedCandidate.q。
 * TopVotedCandidate.q(int t) 被调用时总是满足 t >= times[0]。
 *
 *
 *
 *
 *
 *  Your TopVotedCandidate object will be instantiated and called as such:
 *  TopVotedCandidate obj = new TopVotedCandidate(persons, times);
 *  int param_1 = obj.q(t);
 *
 *
 *
 *
 */
public class TestSolution911 {
    private static final org.slf4j.Logger logger = LoggerFactory.getLogger(TestSolution911.class);

    /**
     *
     * mark下，06.28发布上线时间，做了这题
     *
     * 执行结果：
     * 通过
     * 显示详情
     * 执行用时：94 ms, 在所有 Java 提交中击败了77.34%的用户
     * 内存消耗：49 MB, 在所有 Java 提交中击败了100.00%的用户
     *
     */
    static class TopVotedCandidate {
        private int[] persons;
        private int[] times;
        private Map<Integer, Integer> currentPerson2vote;//当前候选人得票
        private int[] timeIdxWinner;


        public TopVotedCandidate(int[] persons, int[] times) {
            int idx = 0;

            int len = persons.length;
            this.persons = persons;
            this.times = times;
            timeIdxWinner = new int[len];
            currentPerson2vote = new HashMap<>();
            int maxVotePerson =0 ;

            //统计时间点时的个候选人得票和当时的获胜候选者
            int person;
            for (int i = 0; i < times.length; i++) {
                person = persons[i];
                if (i == 0) {
                    currentPerson2vote.put(person, 1);
                    maxVotePerson = person;
                    timeIdxWinner[idx ++] = maxVotePerson;
                } else {
                    Integer iVal = currentPerson2vote.compute(person, (key, oldVal) -> {
                        Integer newVal;
                        if (oldVal == null) {
                            newVal = new Integer(1);
                        } else {
                            newVal = new Integer(oldVal.intValue() + 1);
                        }
                        return newVal;
                    });

                    if (person != maxVotePerson && iVal >= currentPerson2vote.get(maxVotePerson)) {
                        maxVotePerson =  person;
                    }
                    timeIdxWinner[idx ++] = maxVotePerson;
                }
            }
        }

        /**
         *
         * 二分查找即可
         *
         * @param t
         * @return
         */
        public int q(int t) {
            int low = 0; int high = timeIdxWinner.length -1;
            while (low < high) {
                int mid = (low + high) /2;
                int midVal = times[mid];
                if (midVal == t) {
                    return timeIdxWinner[mid];
                } else if (t < midVal) {
                    high = mid - 1;
                } else {
                    low = mid + 1;
                }
            }
            if (t < times[low]) {
                return timeIdxWinner[low - 1];
            } else {
                return timeIdxWinner[low];
            }
        }
    }

    public static void main(String[] args) {
        TopVotedCandidate topVotedCandidate = new TopVotedCandidate(new int[]{0,1,1,0,0,1,0}, new int[]{0,5,10,15,20,25,30});
        logger.info("{}", topVotedCandidate.q(3));
        logger.info("{}", topVotedCandidate.q(12));
        logger.info("{}", topVotedCandidate.q(25));
        logger.info("{}", topVotedCandidate.q(15));
        logger.info("{}", topVotedCandidate.q(24));
        logger.info("{}", topVotedCandidate.q(8));
    }
}
