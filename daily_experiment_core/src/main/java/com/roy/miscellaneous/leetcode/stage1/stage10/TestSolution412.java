package com.roy.miscellaneous.leetcode.stage1.stage10;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.LoggerFactory;

/**
 * Created by apple on 2019/10/2.
 *
 *写一个程序，输出从 1 到 n 数字的字符串表示。

 1. 如果 n 是3的倍数，输出“Fizz”；

 2. 如果 n 是5的倍数，输出“Buzz”；

 3.如果 n 同时是3和5的倍数，输出 “FizzBuzz”。

 示例：

 n = 15,

 返回:
 [
 "1",
 "2",
 "Fizz",
 "4",
 "Buzz",
 "Fizz",
 "7",
 "8",
 "Fizz",
 "Buzz",
 "11",
 "Fizz",
 "13",
 "14",
 "FizzBuzz"
 ]

 来源：力扣（LeetCode）
 链接：https://leetcode-cn.com/problems/fizz-buzz
 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class TestSolution412 {
    private static final org.slf4j.Logger logger = LoggerFactory.getLogger(TestSolution412.class);

    /**
     */
    static class Solution {
        public List<String> fizzBuzz(int n) {
            ArrayList<String> list = new ArrayList<>(n);
            for (int i = 1; i <= n; i++) {
                if (i %3 ==0 && i %5 ==0) {
                    list.add("FizzBuzz");
                } else if (i %3 ==0) {
                    list.add("Fizz");
                } else if (i %5 ==0) {
                    list.add("Buzz");
                } else {
                    list.add( i + "");
                }
            }
            return list;
        }
    }

    public static void main(String[] args) {
        List<String> list = new Solution().fizzBuzz(15);
        for (String s : list) {
            logger.info("{}", s);
        }


    }

}
