package com.roy.miscellaneous.leetcode.stage1.stage12;

import org.slf4j.LoggerFactory;

/**
 * @author guojun
 * @date 2020/1/21 10:40
 */
public class TestSolution1010 {
    private static final org.slf4j.Logger logger = LoggerFactory.getLogger(TestSolution1010.class);


    static class Solution {

        /**
         * 6W多个数字后 超出时间限制 o(n^2)
         *
         * @param time
         * @return
         */
        public int numPairsDivisibleBy60(int[] time) {
            int len = time.length;
            int k = 60;
            int pairs = 0;
            for (int i = 0; i < len - 1; i++) {
                int j = i + 1;
                for (; j < len; j++) {
                    if ((time[i] + time[j]) % k == 0) {
                        pairs++;
                    }

                }
            }
            return pairs;
        }

        /**
         *
         * 思考之后的算法 复杂度 o(n)
         *
         * 生成一个60的余数桶，存每个余数的个数， 然后统计每次选两个数凑成60
         *
         * 执行结果：通过
         *显示详情执行用时 :2 ms, 在所有 Java 提交中击败了100.00%的用户
         * 内存消耗 :45.5 MB, 在所有 Java 提交中击败了20.00%的用户
         *
         * @param time
         * @return
         */
        public int numPairsDivisibleBy601(int[] time) {
            int k = 60;
            int[] remainders = new int[k];
            for (int i : time) {
                remainders[i % k] ++;
            }

            //0
            int remainder0s = remainders[0];
            int pairs = (remainder0s * (remainder0s -1)) /2;
            int targetIdx = k /2 ;
            //1..29   59..31
            for (int i = 1; i <= targetIdx -1; i++) {
                pairs += remainders[i] * remainders[k -i];
            }
            int remainder30s = remainders[targetIdx];
            //30
            pairs += (remainder30s * (remainder30s -1)) /2;
            return pairs;
        }

    }

    public static void main(String[] args) {
        logger.info("{}", new Solution().numPairsDivisibleBy601(new int[]{
                15, 321, 76, 463, 150, 93, 56, 475, 162, 340, 345, 227, 306, 343, 211, 369, 476, 63, 202, 320, 393, 302,
                275, 432, 460, 237, 136, 19, 339, 200, 240, 121, 493, 25, 117, 193, 278, 320, 313, 142, 95, 12, 97, 347, 407, 69, 181, 499, 59, 21, 142, 278, 426, 395, 306, 230, 50, 115, 424, 447, 193, 500, 161, 272, 381, 444, 284, 475, 141, 120, 363, 393, 345, 277, 60, 207, 130, 200, 257, 130, 412, 102, 132, 308, 466, 341, 8, 485, 73, 353, 178, 451, 138, 204
        }));

        logger.info("{}", new Solution().numPairsDivisibleBy601(new int[]{30,20,150,100,40}));

    }
}
