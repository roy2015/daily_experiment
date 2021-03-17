package com.roy.miscellaneous.leetcode.stage1.stage10;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import org.slf4j.LoggerFactory;

/**
 * Created by apple on 2019/10/18.
 *
 *
 * 给你个整数数组 arr，其中每个元素都 不相同。
 请你找到所有具有最小绝对差的元素对，并且按升序的顺序返回。

  

 示例 1：

 输入：arr = [4,2,1,3]
 输出：[[1,2],[2,3],[3,4]]
 示例 2：

 输入：arr = [1,3,6,10,15]
 输出：[[1,3]]
 示例 3：

 输入：arr = [3,8,-10,23,19,-4,-14,27]
 输出：[[-14,-10],[19,23],[23,27]]
  

 提示：

 2 <= arr.length <= 10^5
 -10^6 <= arr[i] <= 10^6

 来源：力扣（LeetCode）
 链接：https://leetcode-cn.com/problems/minimum-absolute-difference
 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 */
public class TestSolution1200 {
    private static final org.slf4j.Logger logger = LoggerFactory.getLogger(TestSolution1200.class);

    /**
     *
     *
     * 执行用时 :25 ms, 在所有 java 提交中击败了94.62%的用户
     内存消耗 :51.2 MB, 在所有 java 提交中击败了100.00%的用户

     * 先排序再算空挡大小，不停的add就可以了
     */
    static class Solution {
        public List<List<Integer>> minimumAbsDifference(int[] arr) {
            if (arr == null || arr.length < 2) {
                return Collections.emptyList();
            }
            Arrays.sort(arr);
            List<List<Integer>> retLists = new ArrayList<>();
            List<Integer> candidateList =  new ArrayList<>();
            candidateList.add(arr[0]);
            candidateList.add(arr[1]);
            retLists.add(candidateList);

            int gap = arr[1] - arr[0];
            int tmpGap;
            for (int i = 1; i < arr.length - 1 ; i++) {
                tmpGap = arr[i+1] - arr[i];
                if ( tmpGap <= gap ) {
                    if (tmpGap < gap) {
                        retLists.clear();
                        candidateList = null;// help gc
                        gap = tmpGap;
                    }
                    candidateList =  new ArrayList<>();
                    candidateList.add(arr[i]);
                    candidateList.add(arr[i + 1]);
                    retLists.add(candidateList);

                } else {}
            }
            return retLists;

        }
    }

    public static void main(String[] args) {
        List<List<Integer>> lists = new Solution().minimumAbsDifference(new int[]{40,11,26,27,-20});
        logger.info("{}");
    }

}
