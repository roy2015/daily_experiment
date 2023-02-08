package com.guo.roy.research.leetcode.stage2.stage20;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import org.slf4j.LoggerFactory;

/**
 * @author guojun
 * @date 2020/6/23
 *
 *
 * 15. 三数之和
 * 给你一个包含 n 个整数的数组 nums，判断 nums 中是否存在三个元素 a，b，c ，使得 a + b + c = 0 ？请你找出所有满足条件且不重复的三元组。
 *
 * 注意：答案中不可以包含重复的三元组。
 *
 *
 *
 * 示例：
 *
 * 给定数组 nums = [-1, 0, 1, 2, -1, -4]，
 *
 * 满足要求的三元组集合为：
 * [
 *   [-1, 0, 1],
 *   [-1, -1, 2]
 * ]
 *
 */
public class TestSolution15 {
    private static final org.slf4j.Logger logger = LoggerFactory.getLogger(TestSolution15.class);


    static class Solution {
        /**
         *
         * 先排序，再三指针，时间复杂度好像不怎么理想
         *
         * 执行结果：
         * 通过
         * 显示详情
         * 执行用时：
         * 26 ms, 在所有 Java 提交中击败了54.27%的用户
         * 内存消耗：
         * 44.1 MB, 在所有 Java 提交中击败了97.48%的用户
         *
         * @param nums
         * @return
         */
        public List<List<Integer>> threeSum(int[] nums) {
            List<List<Integer>> retLists =  new ArrayList();
            if(nums.length==0 || nums.length==1 || nums.length==2) return Collections.emptyList();
            Arrays.sort(nums);
            int len = nums.length;
            if (nums[0] > 0 ||  nums[len-1] < 0) {
                return Collections.emptyList();
            }

            int preIVal = nums[0] -1;//记录上一个i
            for(int i=0; i <= len -3; i ++) {
                int iVal = nums[i];
                if (iVal == preIVal) {
                    continue;
                }
                preIVal = iVal;

                int q = len -1;
                int p = i +1;
                int expectLastTowElSum = -iVal;
                boolean flag = false;//是否找到第一个合适的p
                int prePVal = -1;
                while(p != q) {
                    int pVal = nums[p];
                    int qVal = nums[q];
                    int sumPQ = pVal + qVal;
                    if (sumPQ == expectLastTowElSum) {
                        if (!flag) {//从没有找到
                            List<Integer> addList =  new ArrayList();
                            addList.add(iVal);
                            addList.add(nums[p]);
                            addList.add(nums[q]);
                            retLists.add(addList);
                            prePVal = pVal;
                            flag = true;
                            p++;
                        } else {//有过
                            if (pVal == prePVal) {//和p重复
                                p ++;
                                continue;
                            } else {
                                List<Integer> addList =  new ArrayList();
                                addList.add(iVal);
                                addList.add(pVal);
                                addList.add(qVal);
                                retLists.add(addList);
                                prePVal = pVal;
                                p++;
                            }
                        }

                    } else if(sumPQ < expectLastTowElSum) {
                        p ++;
                    } else{
                        q --;
                    }
                }
            }

            return retLists;
        }

    }

    public static void main(String[] args) {
        List<List<Integer>> lists = new Solution().threeSum(new int[]{-1, 0, 1, 2, -1, -4});//[-1, 0, 1], [-1, -1, 2]
        logger.info("{}", lists);
    }
}
