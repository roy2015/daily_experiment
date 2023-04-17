package com.guo.roy.research.interview;

import org.slf4j.LoggerFactory;

import java.util.Arrays;
import java.util.Random;

/**
 * @author guojun
 * @date 2021/6/11
 *
 * 直播时抢京东豆， 不超过500的京东豆，分成20份，每份10-50不等随机，请编程实现
 *
 */
public class TestSolution4JDBean {
    private static final org.slf4j.Logger logger = LoggerFactory.getLogger(TestSolution4JDBean.class);


    static class Solution {
        public int[] grabJdBean() {
            int[] results = new int[20];
            //预分配10保底，这样还剩不超过500-20*10=300
            Arrays.fill(results, 10);
            int total = 500;
            int part = 20;
            int min = 10;
            int max = 50;
            int remain = total - min* part;//剩余
            int result;//每次随机的结果
            max = max - min;//预分配了每次最大额

            //随机0-40，直到无剩余
            Random random = new Random();
            for (int i = 0; i < part; i++) {
                if (remain ==0) {
                    break;
                }
                result = random.nextInt(max);
                if (result > remain ) {
                    results[i] += remain;
                    remain = 0;
                } else {
                    remain -= result;
                    results[i] += result;
                }
            }
            return results;
        }

        /**
         * 检验结果
         * @param data
         */
        public void checkRs(int[] data) {
            int sum = Arrays.stream(data).sum();
            logger.debug("总和：{}", sum);
            Arrays.stream(data).forEach(x-> logger.debug("{}",x));
            logger.debug("是否每个满足区间[10, 50]：{}", Arrays.stream(data).allMatch(k-> k>=10 && k<=50));
        }

    }

    public static void main(String[] args) {
        Solution so = new Solution();
        int[] ints = so.grabJdBean();
        so.checkRs(ints);
    }
}
