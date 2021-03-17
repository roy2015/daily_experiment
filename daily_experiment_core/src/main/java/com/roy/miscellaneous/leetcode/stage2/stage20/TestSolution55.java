package com.roy.miscellaneous.leetcode.stage2.stage20;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.LoggerFactory;

/**
 * @author guojun
 * @date 2020/1/20 15:29
 *
 *
 * 数组中的每个元素代表你在该位置可以跳跃的最大长度。
 *
 * 判断你是否能够到达最后一个位置。
 *
 * 示例 1:
 *
 * 输入: [2,3,1,1,4]
 * 输出: true
 * 解释: 我们可以先跳 1 步，从位置 0 到达 位置 1, 然后再从位置 1 跳 3 步到达最后一个位置。
 * 示例 2:
 *
 * 输入: [3,2,1,0,4]
 * 输出: false
 * 解释: 无论怎样，你总会到达索引为 3 的位置。但该位置的最大跳跃长度是 0 ， 所以你永远不可能到达最后一个位置。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/jump-game
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 */
public class TestSolution55 {
    private static final org.slf4j.Logger logger = LoggerFactory.getLogger(TestSolution55.class);


    static class Solution {

        /**
         *
         * 完美解决，只需判断是否可以越过0的点，其它就算一次走一步都可以走完
         *
         * 执行用时 :1 ms, 在所有 Java 提交中击败了100.00%的用户
         * 内存消耗 :40.5 MB, 在所有 Java 提交中击败了37.59%的用户
         * @param nums
         * @return
         */
        public boolean canJump(int[] nums) {
            if (nums.length ==1) {
                return true;
            }
            if (nums[0] == 0) {
                return false;
            }
            boolean canSkip;
            for (int i = 1; i < nums.length -1; i++) {
                canSkip = true;
                if (nums[i] == 0) {
                    canSkip = false;
                    for (int j = i - 1; j >= 0; j--) {
                        if ((i - j) < nums[j]) {
                            canSkip = true;
                            break;
                        }
                    }
                }
                if (!canSkip) {
                    return false;
                }
            }
            return true;
        }

        /**
         * 可以解决路径问题，但当数组数据量大时，会超时，由于是逆推路径，递归造成计算量大
         * @param nums
         * @return
         */
        public boolean canJump1(int[] nums) {
            if (nums.length ==1) {
                return true;
            }
            if (nums[0] == 0) {
                return false;
            }
            List<Integer> indexList = new ArrayList<>();
            List<Integer> todoList = new ArrayList<>();
            int length = nums.length;
            List<Integer> srcList = new ArrayList<>();
            for (int i = 0; i < length; i++) {
                srcList.add(nums[i]);
                if (i < length -1) {
                    todoList.add(i);
                }
                indexList.add(i);
            }
            return subCanJump1(length-1, srcList, todoList, indexList) == 1;
        }

        public int subCanJump1 (int n, List<Integer> srcList,  List<Integer> todoList, List<Integer> indexList) {
            ArrayList<Integer> retList = new ArrayList<>();
            for (int item : todoList) {
                if ((n - item) <= srcList.get(item) ) {//可达
                    if (item == 0) {
                        return 1;
                    }
                    retList.add(item);
                }
            }

            if (!retList.isEmpty()) {//retList里面都是大于0的，否则早就在上个for循环里return了
                for (Integer item : retList) {
                    int ret = subCanJump1(item, srcList, indexList.subList(0, item), indexList);
                    if (ret ==1) return 1;
                }
                return 0;
            } else {
                return 0;
            }
        }
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        logger.info("{}",solution.canJump1(new int[]{1,2,3,4}));//true
        logger.info("{}",solution.canJump1(new int[]{2,3,1,1,4}));//true
        logger.info("{}",solution.canJump1(new int[]{3,2,1,0,4}));//false
//        logger.info("{}", solution.canJump1(new int[]{2,0,6,9,8,4,5,0,8,9,1,2,9,6,8,8,0,6,3,1,2,2,1,2,6,5,3,1,2,2,6,4,2,4,3,0,0,0,3,8,2,4,0,1,2,0,1,4,6,5,8,0,7,9,3,4,6,6,5,8,9,3,4,3,7,0,4,9,0,9,8,4,3,0,7,7,1,9,1,9,4,9,0,1,9,5,7,7,1,5,8,2,8,2,6,8,2,2,7,5,1,7,9,6}));
//        logger.info("{}",solution.canJump(new int[]{3,0,0,0}));//false
    }
}
