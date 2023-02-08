package com.roy.leetcode.stage1.stage10;

import java.util.HashMap;
import java.util.Map;

import org.slf4j.LoggerFactory;

/**
 * Created by apple on 2019/9/22.
 *给定一个整数数组 nums 和一个目标值 target，请你在该数组中找出和为目标值的那 两个 整数，并返回他们的数组下标。

 你可以假设每种输入只会对应一个答案。但是，你不能重复利用这个数组中同样的元素。

 示例:

 给定 nums = [2, 7, 11, 15], target = 9

 因为 nums[0] + nums[1] = 2 + 7 = 9
 所以返回 [0, 1]

 来源：力扣（LeetCode）
 链接：https://leetcode-cn.com/problems/two-sum
 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 */
public class TestSolution1 {
    private static final org.slf4j.Logger logger = LoggerFactory.getLogger(TestSolution1.class);

    /**
     */
    static class Solution {
        public int[] twoSum(int[] nums, int target) {
            Map<Integer, String> map = new HashMap<>();
            int[] ints = new int[2];
            for (int i = 0; i < nums.length; i++) {
                if (map.containsKey(nums[i])) {
                    String s = map.get(nums[i]);
                    s += "," + i;
                    map.put(nums[i], s);
                } else
                    map.put(nums[i], i +"");
            }

            for (int i = 0; i < nums.length; i++) {
                if (map. containsKey(target - nums[i])) {
                    if (target == nums[i] * 2 ) {
                        if (map.get(nums[i]).indexOf(",") > -1) {
                            ints[0] = i;
                            ints[1] = Integer.parseInt(map.get(nums[i]).split(",")[1]);
                            break;
                        }
                    } else {
                        ints[0] = i;
                        ints[1] = Integer.parseInt(map.get(target - nums[i]));
                        break;
                    }
                }
            }
            return ints;
        }
    }

    public static void main(String[] args) {
        logger.info("{}", new Solution().twoSum(new int[]{2,7,11,15}, 9));
    }

}
