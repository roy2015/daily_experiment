package com.guo.roy.research.leetcode.stage3;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.slf4j.LoggerFactory;

/**
 *
 *42. 接雨水
 * 给定 n 个非负整数表示每个宽度为 1 的柱子的高度图，计算按此排列的柱子，下雨之后能接多少雨水。
 *
 *
 *
 * 示例 1：
 *
 *
 *
 * 输入：height = [0,1,0,2,1,0,1,3,2,1,2,1]
 * 输出：6
 * 解释：上面是由数组 [0,1,0,2,1,0,1,3,2,1,2,1] 表示的高度图，在这种情况下，可以接 6 个单位的雨水（蓝色部分表示雨水）。
 * 示例 2：
 *
 * 输入：height = [4,2,0,3,2,5]
 * 输出：9
 *
 *
 * 提示：
 *
 * n == height.length
 * 1 <= n <= 2 * 104
 * 0 <= height[i] <= 105
 * 通过次数401,762提交次数673,047
 *
 * @author guojun
 * @date 2022/2/25
 */
public class TestSolution42 {
    private static final org.slf4j.Logger logger = LoggerFactory.getLogger(TestSolution42.class);


    static class Solution {
        private int actLen;
        private int[] newHeightArray;
        private int[] heightArray;
        private int water = 0;

        /**
         *
         * 执行结果：通过
         * 显示详情
         * 添加备注
         *
         * 执行用时：13 ms, 在所有 Java 提交中击败了13.08%的用户
         * 内存消耗：45.8 MB, 在所有 Java 提交中击败了5.00%的用户
         *
         * @param height
         * @return
         */
        public int trap(int[] height) {
            this.heightArray = height;
            int length = this.heightArray.length;
            if (length < 3) {
                return 0;
            }

            Map<Integer, List<Integer>> value2IdxListMap = new HashMap<>();
            for (int i = 0; i < length; i++) {
                int val = this.heightArray[i];
                final  int copyI = i;
                value2IdxListMap.compute(val, (key, oldVal) -> {
                    if (val ==0) return null;
                    if (oldVal == null) {
                        List<Integer> newVal = new ArrayList<>();
                        newVal.add(copyI);
                        actLen++;
                        return newVal;
                    } else  {
                        oldVal.add(copyI);
                        actLen++;
                        return oldVal;
                    }});
            }
            if (actLen < 2) {
                return 0;
            }
            List<Integer> valueList = new ArrayList<>(value2IdxListMap.keySet());
            Collections.sort(valueList, Comparator.reverseOrder());
            newHeightArray = new int[actLen];
            int k = 0;
            for (Integer value : valueList) {
                List<Integer> idxList = value2IdxListMap.get(value);
                for (Integer idx: idxList) {
                    newHeightArray[k++] = idx;
                }
            };


            int first = newHeightArray[0];
            int sec = newHeightArray[1];
            int rightIdx , leftIdx;
            if (first > sec) {
                leftIdx = 1;
                rightIdx =  0;
            } else {
                leftIdx = 0;
                rightIdx =  1;
            }

            int cal = Math.min(this.heightArray[first], this.heightArray[sec]);
            for (int i = newHeightArray[leftIdx] +1; i < newHeightArray[rightIdx]; i++) {
                water += (cal - this.heightArray[i]);
            }

            leftTrap(leftIdx);
            rightTrap(rightIdx);

            return water;
        }

        private  void rightTrap(int start) {
            int startVal = newHeightArray[start];
            int flag = 0;
            int i;
            for (i = start + 1; i < actLen; i++) {
                if (newHeightArray[i] >  startVal) {
                    flag = 1;
                    break;
                }
            }
            if (flag == 0) {
                return;
            }
            int lowIdx = newHeightArray[i];
            int cal = this.heightArray[lowIdx];
            for (int j = startVal +1; j < lowIdx; j++) {
                water += (cal - this.heightArray[j]);
            }
            rightTrap(i);
        }

        private  void leftTrap(int start) {
            int startVal = newHeightArray[start];
            int flag = 0;
            int i;
            for (i = start + 1; i < actLen; i++) {
                if (newHeightArray[i] <  startVal) {
                    flag = 1;
                    break;
                }
            }
            if (flag == 0) {
                return;
            }
            int lowIdx = newHeightArray[i];
            int cal = this.heightArray[lowIdx];
            for (int j = lowIdx +1; j < startVal; j++) {
                water += (cal - this.heightArray[j]);
            }
            leftTrap(i);
        }

        public int trap1(int[] height) {
            if (height.length < 3) {
                return 0;
            }
            int maxLayer = Arrays.stream(height).max().getAsInt();
            int len = height.length;
            int trap = 0;

            for (int layer = 0; layer < maxLayer; layer++) {
                int pre = 0;
                for (int idx = 0; idx < len; idx++) {
                    //peak 是否是墙
                    int peak = height[idx] - layer;
                    if (idx == 0) {
                       if (peak > 0) {
                           pre = 2;
                       } else {
                           pre = 0;
                       }
                       continue;
                    }

                    if (peak > 0) {//当前是墙，直接continue
                        pre =2;
                        continue;
                    }
                    if (pre == 0) {//前一个不可以接水
                        continue;
                    } else if (pre ==1) {//前一个可以接水
                        trap ++;
                    } else {//前一个是墙
                        for (int j = idx + 1; j < len; j++) {
                            if ((height[j] - layer) > 0) {
                                trap ++;
                                pre = 1;
                                break;
                            }
                        }
                        if (pre != 1) {
                            pre = 0;
                        }
                    }
                }
            }
            return trap;
        }

        /**
         *
         * 当前列能接水数 =  min(左边最大高度，右边最大高度)-当前高度，  迭代所有列
         *
         * @param height
         * @return
         */
        public int trap2(int[] height) {
            int len = height.length;
            if (len < 3) {
                return 0;
            }
            int[] leftArray = new int[len];
            int[] rightArray = new int[len];
            leftArray[0] = 0;
            rightArray[len -1] = 0;
            for (int i = 1; i <= len - 1; i++) {
                if (height[i-1] > leftArray[i-1]) {
                    leftArray[i] = height[i-1];
                } else {
                    leftArray[i] = leftArray[i-1];
                }
                int j = len -1 - i;
                if (height[j+1] > rightArray[j+1]) {
                    rightArray[j] = height[j+1];
                } else {
                    rightArray[j] = rightArray[j+1];
                }
            }
            int water = 0;
            for (int i = 0; i < len ; i++) {
                int min = Math.min(leftArray[i], rightArray[i]);
                if (min > height[i])
                water += min - height[i];
            }
            return water;
        }

        public int trap3(int[] height) {
            int len = height.length;
            if (len < 3) {
                return 0;
            }
            int[] leftArray = new int[len];
            int[] rightArray = new int[len];
            leftArray[0] = 0;
            rightArray[len -1] = 0;

            int low = 1, hight = len -2;
            while (low < hight) {
                int low1Val = height[low - 1];
                int low11Val = leftArray[low-1];
                if (low1Val > low11Val) {
                    leftArray[low] = low1Val;
                } else {
                    leftArray[low] = low11Val;
                }

                int hight1Val = height[hight + 1];
                int hight11Val = rightArray[hight + 1];
                if (hight1Val > hight11Val) {
                    rightArray[hight] = hight1Val;
                } else {
                    rightArray[hight] = hight11Val;
                }
                low ++;
                hight--;
            }

            int water = 0;
            while (low < len -1) {
                int hight1Val = height[hight + 1];
                int hight11Val = rightArray[hight + 1];
                if (hight1Val > hight11Val) {
                    rightArray[hight] = hight1Val;
                } else {
                    rightArray[hight] = hight11Val;
                }
                int min = Math.min(leftArray[hight], rightArray[hight]);
                if (min > height[hight]) {
                    water += min - height[hight];
                }

                int low1Val = height[low - 1];
                int low11Val = leftArray[low-1];
                if (low1Val > low11Val) {
                    leftArray[low] = low1Val;
                } else {
                    leftArray[low] = low11Val;
                }

                min = Math.min(leftArray[low], rightArray[low]);
                if (min > height[low]) {
                    water += min - height[low];
                }
                hight --;
                low ++;
            }
            return water;
        }
    }

    public static void main(String[] args) {

        logger.info("{}", new Solution().trap3(new int[] {10527,740,9013,1300,29680,4898,13993,15213,18182,24254,3966,24378,11522,9190,6389,32067,21464,7115,7760,3925,31608,16047,20117,239,14254,3647,11664,27710,2374,23076,5655,9035,4725,13013,12690,22900,27252,32431,2234,281,21614,25927,4512,12695,23964,1279,24305,10618,9903,9943,21625,16622,23662,25734,1255,24695,9120,29898,7376,20450,31788,4604,32502,29052,24447,12007,30153,15745,7726,28122,7726,4567,16604,3580,28544,10748,28767,17120,1236,21310,10526,10841,2946,12586,15805,21648,31457,9798,27901,4691,31057,13571,3805,32176,4735,27885,7430,28867,8932,14373,6757,24268,7311,7441,7706,17284,2341,18514,1425,7346,27942,29430,4590,8697,28785,30959,29871,12020,28683,13252,3980,4997,23836,28039,27554,15977,3386,7,11217,30224,24554,29766,32355,5036,23908,13870,20974,29833,12951,12415,20859,5532,11885,25868,27623,3422,9296,21799,27274,22491,22509,20058,23319,10501,22072,28504,20675,14671,24496,31026,16554,16503,18404,16590,32110,4771,28214,21654,5665,5040,13279,10861,7269,29895,4915,27111,5585,28721,15398,9913,7319,30572,23056,8046,29540,1918,26285,21596,4232,6025,11880,2775,25687,21920,27097,4260,24271,9689,4236,21424,30843,6051,18692,8706,17046,17754,6655,9711,17012,21017,16636,29325,7198,31184,20987,13418,20541,26518,1156,23165,4409,17984,20970,19292,29601,16178,18641,31408,32206,23413,14830,29414,23235,31498,8718,10024,13400,22142,30042,8588,30872,16063,12249,24971,3687,3886,20278,32436,15720,1525,6596,25505,19741,30363,22207,13611,8016,2774,23509,14810,18866,1440,5092,21919,29379,15500,25350,28102,30193,15195,3019,18726,4868,17866,31173,16539,11449,11183,5450,21430,23213,9028,1141,30130,21117,7619,32110,9898,27692,18995,3563,11530,17861,14977,31735,836,19009,24274,9203,19908,8106,19224,30682,27941,16513,31459,969,165,17502,1915,7102,27862,7126,1067,5791,14999,17313,29919,14975,25155,13052,4850,15902,22312,2381,21569,942,26427,16134,26756,28893,17161,24011,8414,2063,16881}));//0
        logger.info("{}", new Solution().trap3(new int[] {0,1,0,2,1,0,1,3,2,1,2,1}));//6
        logger.info("{}", new Solution().trap3(new int[] {4,2,0,3,2,5}));//9
        logger.info("{}", new Solution().trap3(new int[] {0,2,0}));//0
        logger.info("{}", new Solution().trap3(new int[] {0,4,0,3,1,0,1,4,2,1,2,1}));//16

    }
}
