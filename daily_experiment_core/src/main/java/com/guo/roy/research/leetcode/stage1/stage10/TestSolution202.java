package com.guo.roy.research.leetcode.stage1.stage10;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.LoggerFactory;

/**
 * 快乐数
 * Created by apple on 2019/9/28.
 *
 *
 *
 *
 */
public class TestSolution202 {
    private static final org.slf4j.Logger logger = LoggerFactory.getLogger(TestSolution202.class);


    static class Solution {
        public boolean isHappy(int n) {
            String k = n + "";
            String happySub;
            List<String> sb = new ArrayList<>();
            while (true) {
                 happySub = isHappySub(k);
                 if (happySub.equalsIgnoreCase("1")) {
                     return true;
                 } else if(sb.contains(happySub)) {
                     return false;
                 } else {
                     k = happySub;
                 }
                 sb.add(happySub);
            }
        }

        public String isHappySub(String n) {
            char[] chars = n.toCharArray();
            int sum =0 ;
            for (int i = 0; i < chars.length; i++) {
                sum += (chars[i] - '0') * (chars[i] - '0');
            }
            if (sum !=1) {
                return sum + "";
            }
            return "1";
        }
    }

    /**
     * @param args
     */
    public static void main(String[] args) {


        logger.info("{}", new TestSolution202.Solution().isHappy(101));
    }

}
