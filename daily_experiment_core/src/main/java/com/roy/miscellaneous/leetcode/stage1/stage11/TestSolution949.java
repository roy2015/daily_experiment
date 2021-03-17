package com.roy.miscellaneous.leetcode.stage1.stage11;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import org.slf4j.LoggerFactory;

/**
 * @author guojun
 * @date 2020/8/3
 *
 *949. 给定数字能组成的最大时间
 * 给定一个由 4 位数字组成的数组，返回可以设置的符合 24 小时制的最大时间。
 *
 * 最小的 24 小时制时间是 00:00，而最大的是 23:59。从 00:00 （午夜）开始算起，过得越久，时间越大。
 *
 * 以长度为 5 的字符串返回答案。如果不能确定有效时间，则返回空字符串。
 *
 *
 *
 * 示例 1：
 *
 * 输入：[1,2,3,4]
 * 输出："23:41"
 * 示例 2：
 *
 * 输入：[5,5,5,5]
 * 输出：""
 *
 *
 * 提示：
 *
 * A.length == 4
 * 0 <= A[i] <= 9
 *
 *
 *
 *
 *
 */
public class TestSolution949 {
    private static final org.slf4j.Logger logger = LoggerFactory.getLogger(TestSolution949.class);

    static class Solution {
        //定义一个时间类
        static class MyDateDef {
            private static String ZERO_STR = "0";
            private static String MAO_HAO = ":";

            private int hour;//rang: [0,23]
            private int minutes;//range: [0,59]

            public MyDateDef(int hour, int minutes) {
                this.hour = hour;
                this.minutes = minutes;
            }

            @Override
            public String toString() {
                StringBuilder myDateSb = new StringBuilder();
                if (hour < 10) {
                    myDateSb.append(ZERO_STR);
                }
                myDateSb.append(hour);
                myDateSb.append(MAO_HAO);
                if (minutes < 10) {
                    myDateSb.append(ZERO_STR);
                }
                myDateSb.append(minutes);
                return myDateSb.toString();
            }

            public boolean checkValid () {
                if (hour <= 23 && minutes <= 59) {
                    return true;
                } else return false;
            }
        }

        /**
         *
         * 全排列+最终检验，顺便提供一个方法把排列的全部排列都枚举出来
         *
         *
         * 执行结果：
         * 通过
         * 显示详情
         * 执行用时：
         * 7 ms, 在所有 Java 提交中击败了87.02%的用户
         * 内存消耗：
         * 39.4 MB, 在所有 Java 提交中击败了9.52%的用户
         *
         * @param A
         * @return
         */
        public String largestTimeFromDigits(int[] A) {
            List<MyDateDef> storeList = new ArrayList<>();
            largestTimeFromDigitsSub(4, 1, Arrays.stream(A).boxed().collect(Collectors.toList()), new ArrayList<>(), storeList);

            if (! storeList.isEmpty()) {
                MyDateDef maxMyDateDef = storeList.get(0);
                for (MyDateDef myDateDef : storeList) {
                    if (myDateDef.hour > maxMyDateDef.hour) {
                        maxMyDateDef= myDateDef;
                    } else if (myDateDef.hour == maxMyDateDef.hour && myDateDef.minutes > maxMyDateDef.minutes) {
                        maxMyDateDef= myDateDef;
                    }
                }
                return maxMyDateDef.toString();
            } else {
                return "";
            }
        }


        public void largestTimeFromDigitsSub(int k, int level, List<Integer> calList, List<Integer> parentList, List<MyDateDef> storeList) {
            if (calList == null || calList.isEmpty()) {
                return;
            }

            if (level == k) {
                List<Integer> copyParentList;
                for (Integer calVal : calList) {
                    copyParentList = new ArrayList<>(parentList);
                    copyParentList.add(calVal);
                    int hour = copyParentList.get(0) * 10 + copyParentList.get(1);
                    int minutes = copyParentList.get(2) * 10 + copyParentList.get(3);
                    MyDateDef toAdd = new MyDateDef(hour, minutes);
                    if (toAdd.checkValid()) {
                        storeList.add(toAdd);
                    }
                }
                return;
            }

            int size = calList.size();
            for (int i = 0; i < size; i++) {
                List<Integer> nextCalList = new ArrayList<>(calList);
                nextCalList.remove(i);
                int currentVal = calList.get(i);
                List<Integer> nextParentList = new ArrayList<>(parentList);
                nextParentList.add(currentVal);
                largestTimeFromDigitsSub(k, level + 1, nextCalList, nextParentList, storeList);
            }
        }


        /**
         *
         * example:
         *   List<List<Integer>> storeList = new ArrayList<>();
         *   getPermutation(3, 1, Arrays.asList(8,4,2,1), new ArrayList<>(), storeList);
         * 返回的数据在storeList
         *
         * 排列公式 p(n,k)= n!(n-k)!，返回所有的排列详情
         *  计算数学中排列(permutation and combination)的所有排列
         * @param k  选几个
         * @param level  传 1
         * @param calList 选择范围
         * @param parentList  new ArrayList<>()
         * @param storeList 接收的storeList
         */
        public void getPermutation(int k, int level, List<Integer> calList, List<Integer> parentList, List<List<Integer>> storeList) {
            if (calList == null || calList.isEmpty()) {
                return;
            }

            if (level == k) {
                List<Integer> copyParentList;
                for (Integer calVal : calList) {
                    copyParentList = new ArrayList<>(parentList);
                    copyParentList.add(calVal);
                    storeList.add(copyParentList);
                }
                return;
            }

            int size = calList.size();
            for (int i = 0; i < size; i++) {
                List<Integer> nextCalList = new ArrayList<>(calList);
                nextCalList.remove(i);
                int currentVal = calList.get(i);
                List<Integer> nextParentList = new ArrayList<>(parentList);
                nextParentList.add(currentVal);
                getPermutation(k, level + 1, nextCalList, nextParentList, storeList);
            }
        }
    }

    public static void main(String[] args) {

        /*Solution solution = new Solution();
        List<List<Integer>> storeList = new ArrayList<>();
        solution.getPermutation(4, 1, Arrays.asList(8,4,2,1), new ArrayList<>(), storeList);*/

        logger.info("{}", new Solution().largestTimeFromDigits(new int[]{1,2,3,4}));//23:41
        logger.info("*{}*", new Solution().largestTimeFromDigits(new int[]{5,5,5,5}));
    }
}
