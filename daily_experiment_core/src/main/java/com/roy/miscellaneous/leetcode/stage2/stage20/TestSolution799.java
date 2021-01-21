package com.roy.miscellaneous.leetcode.stage2.stage20;

import org.slf4j.LoggerFactory;

/**
 * @author guojun
 * @date 2020/1/21 10:40
 *
 *
 * 799. 香槟塔
 * 我们把玻璃杯摆成金字塔的形状，其中第一层有1个玻璃杯，第二层有2个，依次类推到第100层，每个玻璃杯(250ml)将盛有香槟。
 *
 * 从顶层的第一个玻璃杯开始倾倒一些香槟，当顶层的杯子满了，任何溢出的香槟都会立刻等流量的流向左右两侧的玻璃杯。当左右两边的杯子也满了，就会等流量的流向它们左右两边的杯子，依次类推。（当最底层的玻璃杯满了，香槟会流到地板上）
 *
 * 例如，在倾倒一杯香槟后，最顶层的玻璃杯满了。倾倒了两杯香槟后，第二层的两个玻璃杯各自盛放一半的香槟。在倒三杯香槟后，第二层的香槟满了 - 此时总共有三个满的玻璃杯。在倒第四杯后，第三层中间的玻璃杯盛放了一半的香槟，他两边的玻璃杯各自盛放了四分之一的香槟，如下图所示。
 *
 *
 *
 * 现在当倾倒了非负整数杯香槟后，返回第 i 行 j 个玻璃杯所盛放的香槟占玻璃杯容积的比例（i 和 j都从0开始）。
 *
 *
 *
 * 示例 1:
 * 输入: poured(倾倒香槟总杯数) = 1, query_glass(杯子的位置数) = 1, query_row(行数) = 1
 * 输出: 0.0
 * 解释: 我们在顶层（下标是（0，0））倒了一杯香槟后，没有溢出，因此所有在顶层以下的玻璃杯都是空的。
 *
 * 示例 2:
 * 输入: poured(倾倒香槟总杯数) = 2, query_glass(杯子的位置数) = 1, query_row(行数) = 1
 * 输出: 0.5
 * 解释: 我们在顶层（下标是（0，0）倒了两杯香槟后，有一杯量的香槟将从顶层溢出，位于（1，0）的玻璃杯和（1，1）的玻璃杯平分了这一杯香槟，所以每个玻璃杯有一半的香槟。
 * 注意:
 *
 * poured 的范围[0, 10 ^ 9]。
 * query_glass 和query_row 的范围 [0, 99]。
 *
 *
 */
public class TestSolution799 {
    private static final org.slf4j.Logger logger = LoggerFactory.getLogger(TestSolution799.class);


    static class Solution {

        /**
         *
         * 香槟塔问题，半个月没思路，今天看了官方的思路，秒懂立马写出来了，很奇妙，要逆向思维，把香槟全倒了算流量， 一杯杯的倒只会走入死胡同出不来,
         * 时间复杂度，空间复杂度
         * 求第 i 行 j 个玻璃杯所盛放的香槟占玻璃杯容积的比例远比求每个杯子的情况复杂，从设计角度来讲
         *
         * 执行结果：
         * 通过
         * 显示详情
         * 执行用时：
         * 2 ms
         * , 在所有 Java 提交中击败了98.77%
         * 的用户
         * 内存消耗：
         * 35.9 MB
         * , 在所有 Java 提交中击败了94.81%
         * 的用户
         *
         * @param poured
         * @param query_row
         * @param query_glass
         * @return
         */
        public double champagneTower(int poured, int query_row, int query_glass) {
            if (poured == 0) {
                return 0;
            }
            double overFlowChampagne = 0;
            /**
             * query_row从 0 开始
             *
             * 第0层  1个杯子
             * 第1层  2个杯子
             * 第query_row层  query_row+1个杯子
             */
            double[] glassArray = new double[query_row + 1];
            glassArray[0] = poured;//把水全倒入到第一个杯子
            //记录当层有无溢出
            int res = 1;
            for (int i = 0; i < query_row; i++) {
                if (res == 0) {
                    return 0d;
                }
                //第一层比较特殊，直接计算
                if (i == 0) {
                    glassArray[1] = glassArray[0] = (glassArray[0] -1.0 )/2;
                    continue;
                }
                //中转流量
                double transferFlow = 0;
                //第i层对i+1层浇水
                res = 0;
                for (int j = 0; j <= i; j++) {
                    overFlowChampagne = glassArray[j] -1.0;
                    //判断正负，要不然算出来负数
                    double avg = overFlowChampagne > 0 ? overFlowChampagne / 2 : 0;
                    if (j ==0) {//最左
                        glassArray[0] = avg;
                        transferFlow = avg;
                        if (glassArray[0] > 1 || transferFlow > 1) {
                            res |= 1;
                        }
                    } else if(j == i) {//最右
                        glassArray[j] = transferFlow + avg;
                        glassArray[j+1] = avg;
                        if (glassArray[j] > 1 || glassArray[j+1] > 1) {
                            res |= 1;
                        }
                    }  else {
                        glassArray[j] = transferFlow + avg;
                        transferFlow = avg;
                        if (glassArray[j] > 1 || transferFlow > 1) {
                            res |= 1;
                        }
                    }
                }
            }
            return glassArray[query_glass]> 1d ? 1 : glassArray[query_glass];
        }
    }

    public static void main(String[] args) {
        logger.info("{}", new Solution().champagneTower(25, 6,1));//0.1875
        logger.info("{}", new Solution().champagneTower(4, 2,2));//0.5
        logger.info("{}", new Solution().champagneTower(4, 2,1));//0.5
        logger.info("{}", new Solution().champagneTower(4, 2,0));//0.25
        logger.info("{}", new Solution().champagneTower(2, 1,1));//0.5
        logger.info("{}", new Solution().champagneTower(1, 0,0));//1
    }
}
