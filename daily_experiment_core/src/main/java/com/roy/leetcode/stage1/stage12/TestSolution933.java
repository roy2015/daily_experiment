package com.roy.leetcode.stage1.stage12;

import java.util.ArrayDeque;
import java.util.BitSet;
import java.util.Deque;

import org.slf4j.LoggerFactory;

/**
 * @author guojun
 * @date 2020/11/4 15:16
 *
 * 933. 最近的请求次数
 * 写一个 RecentCounter 类来计算特定时间范围内最近的请求。
 *
 * 请你实现 RecentCounter 类：
 *
 * RecentCounter() 初始化计数器，请求数为 0 。
 * int ping(int t) 在时间 t 添加一个新请求，其中 t 表示以毫秒为单位的某个时间，并返回过去 3000 毫秒内发生的所有请求数（包括新请求）。确切地说，返回在 [t-3000, t] 内发生的请求数。
 * 保证每次对 ping 的调用都使用比之前更大的 t 值。
 *
 *
 *
 * 示例 1：
 *
 * 输入：
 * ["RecentCounter", "ping", "ping", "ping", "ping"]
 * [[], [1], [100], [3001], [3002]]
 * 输出：
 * [null, 1, 2, 3, 3]
 *
 * 解释：
 * RecentCounter recentCounter = new RecentCounter();
 * recentCounter.ping(1);     // requests = [1]，范围是 [-2999,1]，返回 1
 * recentCounter.ping(100);   // requests = [<u>1</u>, <u>100</u>]，范围是 [-2900,100]，返回 2
 * recentCounter.ping(3001);  // requests = [<u>1</u>, <u>100</u>, <u>3001</u>]，范围是 [1,3001]，返回 3
 * recentCounter.ping(3002);  // requests = [1, <u>100</u>, <u>3001</u>, <u>3002</u>]，范围是 [2,3002]，返回 3
 *
 *
 * 提示：
 *
 * 1 <= t <= 10^4
 * 保证每次对 ping 的调用都使用比之前更大的 t 值
 * 至多调用 ping 方法 10^4 次
 *
 */
public class TestSolution933 {

    private static final org.slf4j.Logger logger = LoggerFactory.getLogger(TestSolution933.class);

    /**
     *
     * 1 <= t <= 10^4
     *
     * 使用滑动窗口实现的，题目明明是1 <= t <= 10^4，测试用例直接上10^10,内存超出限制~~
     *
     * 执行结果：
     * 通过
     * 显示详情
     * 执行用时：1741 ms, 在所有 Java 提交中击败了5.07%的用户
     * 内存消耗：47.6 MB, 在所有 Java 提交中击败了18.61%的用户
     *
     */
    static class RecentCounter {
        private Deque<Integer> window3000;
        private int windowItemSum ;
        private int windowSize = 3000;
        private int lastVal = 0;

        private  void initQueue () {
            window3000.clear();
            window3000 = new ArrayDeque<>(windowSize +1);
            for (int i = 0; i < windowSize +1; i++) {
                window3000.add(0);
            }
            /*for (Integer integer : window3000) {
                integer = Integer.valueOf(0);
            }*/
        }
        public RecentCounter() {
            window3000 = new ArrayDeque<>(windowSize +1);
            for (int i = 0; i < windowSize +1; i++) {
                window3000.add(0);
            }
            windowItemSum = 0;
        }

        public int ping(int t) {
            int gap =0;
            if ((t - lastVal) > windowSize) {
                initQueue();
                window3000.pop();
                window3000.add(t);
                windowItemSum = 1;
                lastVal = t;
                return windowItemSum;
            }

            gap = t - lastVal;
            for (int i = 0; i < gap; i++) {
                Integer popItem = window3000.pop();
                if (!popItem.equals(0)) {
                    windowItemSum--;
                }
            }

            for (int i = 0; i < gap - 1; i++) {
                window3000.add(0);
            }

            window3000.add(t);
            windowItemSum ++;
            lastVal = t;
            return windowItemSum;
        }
    }

    static class RecentCounter1 {


        public RecentCounter1() {
            presentDic = new BitSet();
        }

        private BitSet presentDic;
        private boolean firstInput = true;
        private int firstVal = 0;

        public int ping(int t) {
            int sum = 0;
            if (firstInput) {
                firstInput = false;
                firstVal = t;
                presentDic.set(0, true);
                return sum + 1;
            }

            presentDic.set(t, true);
            if (t < 3000) {
                for (int i = 0; i < t; i++) {
                    sum += presentDic.get(i) ? 1 : 0;
                }
                return sum +1;
            }

            for (int i = t-3000; i < t; i++) {
                sum += presentDic.get(i) ? 1 : 0;
            }
            return sum +1;
        }
    }

    /**
     * Your RecentCounter object will be instantiated and called as such:
     * RecentCounter obj = new RecentCounter();
     * int param_1 = obj.ping(t);
     */
    public static void main(String[] args) {
        RecentCounter obj = new RecentCounter();
        /*logger.info("{}", obj.ping(1));//1     [-2999,1]
        logger.info("{}", obj.ping(100));//2   [-2900,100]
        logger.info("{}", obj.ping(3001));//3  [1,30001]
        logger.info("{}", obj.ping(3002));//3  [2,30002]*/


        /*for (int i = 1; i <= 10000 ; i++) {
            logger.info("{} {}", i , obj.ping(999990000 + i));
        }*/

        logger.info("{} {}", 39187 , obj.ping(39187));
        logger.info("{} {}", 45399 , obj.ping(45399));
        logger.info("{} {}", 50662 , obj.ping(50662));
        logger.info("{} {}", 70693 , obj.ping(70693));
        logger.info("{} {}", 72666 , obj.ping(72666));
        logger.info("{} {}", 84380 , obj.ping(84380));
        logger.info("{} {}", 105653 , obj.ping(105653));
        logger.info("{} {}", 129301 , obj.ping(129301));

        logger.info("{} {}", 156166 , obj.ping(156166));
        logger.info("{} {}", 156423 , obj.ping(156423));
        logger.info("{} {}", 158304 , obj.ping(158304));
    }


}
