package com.guo.roy.research.leetcode.stage1.stage12;

import java.util.HashMap;
import java.util.Map;

import org.slf4j.LoggerFactory;

/**
 * @author guojun
 * @date 2020/5/19
 *
 * 575. 分糖果
给定一个偶数长度的数组，其中不同的数字代表着不同种类的糖果，每一个数字代表一个糖果。你需要把这些糖果平均分给一个弟弟和一个妹妹。返回妹妹可以获得的最大糖果的种类数。

示例 1:

输入: candies = [1,1,2,2,3,3]
输出: 3
解析: 一共有三种种类的糖果，每一种都有两个。
最优分配方案：妹妹获得[1,2,3],弟弟也获得[1,2,3]。这样使妹妹获得糖果的种类数最多。
示例 2 :

输入: candies = [1,1,2,3]
输出: 2
解析: 妹妹获得糖果[2,3],弟弟获得糖果[1,1]，妹妹有两种不同的糖果，弟弟只有一种。这样使得妹妹可以获得的糖果种类数最多。
注意:

数组的长度为[2, 10,000]，并且确定为偶数。
数组中数字的大小在范围[-100,000, 100,000]内。
 */
public class TestSolution575 {
    private static final org.slf4j.Logger logger = LoggerFactory.getLogger(TestSolution575.class);


    /**
     * 数组的长度为[2, 10,000]，并且确定为偶数。
     */
    static class Solution {
        /**
         *
         *
         * 用了jdk map的compute方法和lamda表达式，使代码更简洁
         *
         * 执行结果：通过显示详情
         执行用时 :33 ms, 在所有 Java 提交中击败了87.69%的用户
         内存消耗 :42 MB, 在所有 Java 提交中击败了50.00%的用户
         * @param candies
         * @return
         */
        public int distributeCandies(int[] candies) {
            int len = candies.length;
            int disLen = len / 2;
            int count =0;
            Map<Integer, Integer> map = new HashMap<>();
            for (int candy : candies) {
                count += map.compute(candy, (key, old) -> {
                    int ret =0 ;
                    if (old == null) {
                        ret = 1;
                    } else if (old.equals(1) || old.equals(0)) {
                        ret = 0;
                    } else {};
                    return ret;
                });
                if (count == disLen) {
                    return disLen;
                }
            }
            return count;
        }

    }

    public static void main(String[] args) {
        logger.info("{}", new Solution().distributeCandies(new int[]{2,2,2,2,2,2}));
    }
}
