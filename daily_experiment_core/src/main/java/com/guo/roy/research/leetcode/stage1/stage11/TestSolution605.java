package com.guo.roy.research.leetcode.stage1.stage11;

import org.slf4j.LoggerFactory;

/**
 * @author guojun
 * @date 2020/5/11 13:40
 *
 * 假设你有一个很长的花坛，一部分地块种植了花，另一部分却没有。可是，花卉不能种植在相邻的地块上，它们会争夺水源，两者都会死去。

给定一个花坛（表示为一个数组包含0和1，其中0表示没种植花，1表示种植了花），和一个数 n 。能否在不打破种植规则的情况下种入 n 朵花？能则返回True，不能则返回False。

示例 1:

输入: flowerbed = [1,0,0,0,1], n = 1
输出: True
示例 2:

输入: flowerbed = [1,0,0,0,1], n = 2
输出: False
注意:

数组内已种好的花不会违反种植规则。
输入的数组长度范围为 [1, 20000]。
n 是非负整数，且不会超过输入数组的大小。

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/can-place-flowers
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class TestSolution605 {
    private static final org.slf4j.Logger logger = LoggerFactory.getLogger(TestSolution605.class);


    static class Solution {
        /**
         *
         * 执行结果：通过显示详情
         执行用时 :1 ms, 在所有 Java 提交中击败了100.00%的用户
         内存消耗 :41.5 MB, 在所有 Java 提交中击败了8.33%的用户
         *
         * @param flowerbed
         * @param n
         * @return
         */
        public boolean canPlaceFlowers(int[] flowerbed, int n) {
            //n是非负数先验证0
            if (n ==0 ) {
                return true;
            }
            int len = flowerbed.length;
            boolean prePlace = false;
            int maxCanPlace =0;
            for(int i =0; i< len; i += 2) {
                if (i + 1 == len) {
                    if (flowerbed[i] == 0  && !prePlace) {
                        maxCanPlace ++;
                    }
                    break;
                } else {
                    if(flowerbed[i] == 0 && flowerbed[i +1] == 0 ) {
                        if (!prePlace || i == len -2) {
                            maxCanPlace ++;
                        }
                    }
                    prePlace = flowerbed[i +1] == 0 ? false : true;
                }
            }
            if (n <= maxCanPlace) {
                return true;
            } else return false;
        }
    }

    public static void main(String[] args) {
        logger.info("{}", new Solution().canPlaceFlowers(new int[]{1,0,0,0,1}, 1));//true
    }
}
