package com.guo.roy.research.leetcode.stage1.stage10;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.LoggerFactory;

/**
 * Created by apple on 2019/11/14.
 *给定一个非负整数 numRows，生成杨辉三角的前 numRows 行。
 * 在杨辉三角中，每个数是它左上方和右上方的数的和。

 示例:

 输入: 5
 输出:
 [
     [1],
    [1,1],
   [1,2,1],
  [1,3,3,1],
 [1,4,6,4,1]
 ]

 来源：力扣（LeetCode）
 链接：https://leetcode-cn.com/problems/pascals-triangle
 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 */
public class TestSolution118 {
    private static final org.slf4j.Logger logger = LoggerFactory.getLogger(TestSolution118.class);

    /**
     */
    static class Solution {
        /**
         *
         * 执行用时 :1 ms, 在所有 java 提交中击败了98.55%的用户
         内存消耗 :34.1 MB, 在所有 java 提交中击败了25.94%的用户
         *
         * @param numRows
         * @return
         */
        public List<List<Integer>> generate(int numRows) {
            List<List<Integer>> lists = new ArrayList(numRows);
            for(int i = 1;i <= numRows; i++) {
                List<Integer> list = new ArrayList(i);
                if (i == 1) {
                    list.add(1);
                } else {
                    List<Integer> tmpList = lists.get(i -2);
                    for(int j = 0;j < i; j++) {
                        int left = (j == 0)? 0: tmpList.get(j-1);
                        int right = (j == (i -1))? 0: tmpList.get(j);
                        list.add(left + right);
                    }
                }
                lists.add(list);
            }
            return lists;
        }
    }

    public static void main(String[] args) {
        List<List<Integer>> generate = new Solution().generate(5);
        logger.info("{}");
    }

}
