package com.roy.miscellaneous.leetcode.stage1.stage13;

import org.slf4j.LoggerFactory;

import java.util.*;
import java.util.function.Function;
import java.util.function.ToIntFunction;

/**
 * @author guojun
 * @date 2020/7/2
 *
 *
 * 401. 二进制手表
 * 二进制手表顶部有 4 个 LED 代表 小时（0-11），底部的 6 个 LED 代表 分钟（0-59）。
 *
 * 每个 LED 代表一个 0 或 1，最低位在右侧。
 *
 *
 *
 * 例如，上面的二进制手表读取 “3:25”。
 *
 * 给定一个非负整数 n 代表当前 LED 亮着的数量，返回所有可能的时间。
 *
 *
 *
 * 示例：
 *
 * 输入: n = 1
 * 返回: ["1:00", "2:00", "4:00", "8:00", "0:01", "0:02", "0:04", "0:08", "0:16", "0:32"]
 *
 *
 * 提示：
 *
 * 输出的顺序没有要求。
 * 小时不会以零开头，比如 “01:00” 是不允许的，应为 “1:00”。
 * 分钟必须由两位数组成，可能会以零开头，比如 “10:2” 是无效的，应为 “10:02”。
 * 超过表示范围（小时 0-11，分钟 0-59）的数据将会被舍弃，也就是说不会出现 "13:00", "0:61" 等时间。
 *
 *
 *
 */
public class TestSolution401 {
    private static final org.slf4j.Logger logger = LoggerFactory.getLogger(TestSolution401.class);


    /**
     *
     *         8 4 2 1
     *   32 16 8 4 2 1
     *
     *  tips: 1. 小时最多选3且是下列几种
     *                                 选3: 主要算0的位置 1011（11)只有前两位可以选 C(2,1)=2种  11,7
     *                                 选2: 除开1100（12） C(4,2) -1 = 5
     *                                 选1：C(4,1) = 4
     *                                 选0:
     *        2. 分钟最多选5且是下列几种
     *                                 选5：  主要算0的位置 111011（59)只有前四位可以选 C(4,1)=4种    3 + (14,13,11,7) * 4
     *                                 选4：  除开这种 111100（60） C(6,4) -1 = 14种
     *                                 选3：  C(6,3) = 20种
     *                                 选2：  C(6,2) = 15种
     *                                 选1：  C(6,1) = 6种
     *                                 选0
     */
    static class Solution {
        private Map<Integer, List<Integer>> hourMap = new HashMap<Integer, List<Integer>>();
        private Map<Integer, List<Integer>> minuteMap = new HashMap<Integer, List<Integer>>();

        public void init() {
            hourMap.put(3, Arrays.asList(11,7));
            hourMap.put(2, Arrays.asList(10,9,6,5,3));
            hourMap.put(1, Arrays.asList(8, 4 ,2, 1));
            hourMap.put(0, Arrays.asList(0));

            //3 + (14,13,11,7) * 4
            minuteMap.put(5, Arrays.asList(59, 55 ,47, 31));
            minuteMap.put(4, Arrays.asList(58,57,54,53,51,46,45,43,39,30,29,27,23,15));
            minuteMap.put(3, Arrays.asList(56,52,50,49,44,42,41,38,37,35,28,26,25,22,21,19,14,13,11,7));
            minuteMap.put(2, Arrays.asList(48,40,36,34,33,24,20,18,17,12,10,9,6,5,3));
            minuteMap.put(1, Arrays.asList(32,16,8,4,2,1));
            minuteMap.put(0, Arrays.asList(0));

            StringBuffer sb = new StringBuffer();
            List<List<Integer>> storeList = new ArrayList<>();
//            getCombination(3, 1, Arrays.asList(8,4,2,1), new ArrayList<>(), storeList);
//            getCombination(4, 1, Arrays.asList(32,16,8,4,2,1), new ArrayList<>(), storeList);
//            getCombination(3, 1, Arrays.asList(32,16,8,4,2,1), new ArrayList<>(), storeList);
//            printListList(storeList);
//            storeList = new ArrayList<>();
//            getCombination(2, 1, Arrays.asList(32,16,8,4,2,1), new ArrayList<>(), storeList);
//            printListList(storeList);
//            storeList = new ArrayList<>();
//            getCombination(1, 1, Arrays.asList(32,16,8,4,2,1), new ArrayList<>(), storeList);
            printListList(storeList);
        }

        /**
         *
         * 执行结果：
         * 通过
         * 显示详情
         * 执行用时：
         * 6 ms, 在所有 Java 提交中击败了87.43%的用户
         * 内存消耗：
         * 38.4 MB, 在所有 Java 提交中击败了10.00%的用户
         *
         * @param num
         * @return
         */
        public List<String> readBinaryWatch(int num) {
            init();
            if (num == 0) return Arrays.asList("0:00");
            List<String> retList = new ArrayList<>();
            for (int i = 0; i <= num; i++) {
                int j = num - i;
                if (i > 3 || j > 5) {
                    continue;
                }
                List<Integer> hourList = hourMap.get(i);
                List<Integer> minuteList = minuteMap.get(j);


                for (Integer hour : hourList) {
                    for (Integer minute : minuteList) {
                        if (minute < 10) {
                            retList.add(hour + ":0" + minute);
                        } else {
                            retList.add(hour + ":" + minute);
                        }
                    }
                }

            }
            return retList;
        }

        /**
         *
         *  计算数学中组合(combination)的所有组合详情
         *   example:
         *   List<List<Integer>> storeList = new ArrayList<>();
         *   getCombination(3, 1, Arrays.asList(8,4,2,1), new ArrayList<>(), storeList);
         *   返回的数据在storeList
         *
         * @param k  选几个
         * @param level  传 1
         * @param calList 选择范围
         * @param parentList  new ArrayList<>()
         * @param storeList 接收的storeList
         */
        public void getCombination(int k, int level, List<Integer> calList, List<Integer> parentList, List<List<Integer>> storeList) {
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
                List<Integer> nextCalList = calList.subList(i + 1, size);
                int currentVal = calList.get(i);
                List<Integer> nextParentList = new ArrayList<>(parentList);
                nextParentList.add(currentVal);
                getCombination(k, level + 1, nextCalList, nextParentList, storeList);
            }
        }

        public void printListList(List<List<Integer>> storeList) {
            StringBuffer sb = new StringBuffer();
            for (List<Integer> integers : storeList) {
                int sum = integers.stream().mapToInt(Integer::intValue).sum();
                sb.append(sum);
                sb.append(",");
            }
            logger.info("{}", sb.toString());

        }
    }

    public static void main(String[] args) {
        List<List<Integer>> storeList = new ArrayList<>();
        Solution solution = new Solution();
        solution.getCombination(3, 1, Arrays.asList(8,4,2,1), new ArrayList<>(), storeList);
        storeList = new ArrayList<>();
        solution.getCombination(2, 1, Arrays.asList(8,4,2,1), new ArrayList<>(), storeList);
        logger.info("{}", solution);
        List<String> list = null;
        list = solution.readBinaryWatch(0);
        list = solution.readBinaryWatch(4);
        int k = 1;
    }
}
