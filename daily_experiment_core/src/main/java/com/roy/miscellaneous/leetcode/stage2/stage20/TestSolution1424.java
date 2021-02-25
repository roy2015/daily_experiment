package com.roy.miscellaneous.leetcode.stage2.stage20;

import org.slf4j.LoggerFactory;

import java.lang.reflect.Array;
import java.util.*;

/**
 * @author guojun
 * @date 2021/2/22
 *
 * 1424. 对角线遍历 II
 * 给你一个列表 nums ，里面每一个元素都是一个整数列表。请你依照下面各图的规则，按顺序返回 nums 中对角线上的整数。
 *
 *
 *
 * 示例 1：
 *
 *
 *
 * 输入：nums = [[1,2,3],[4,5,6],[7,8,9]]
 * 输出：[1,4,2,7,5,3,8,6,9]
 * 示例 2：
 *
 *
 *
 * 输入：nums = [[1,2,3,4,5],[6,7],[8],[9,10,11],[12,13,14,15,16]]
 * 输出：[1,6,2,8,7,3,9,4,12,10,5,13,11,14,15,16]
 * 示例 3：
 *
 * 输入：nums = [[1,2,3],[4],[5,6,7],[8],[9,10,11]]
 * 输出：[1,4,2,5,3,8,6,9,7,10,11]
 * 示例 4：
 *
 * 输入：nums = [[1,2,3,4,5,6]]
 * 输出：[1,2,3,4,5,6]
 *
 *
 * 提示：
 *
 * 1 <= nums.length <= 10^5
 * 1 <= nums[i].length <= 10^5
 * 1 <= nums[i][j] <= 10^9
 * nums 中最多有 10^5 个数字。
 *
 *
 */
public class TestSolution1424 {
    private static final org.slf4j.Logger logger = LoggerFactory.getLogger(TestSolution1424.class);


    static class Solution {
        /**
         * 虽然超时了，但思路和后续的优化努力是值得肯定的，见骚操作 @see #findDiagonalOrder2
         *
         * 超出时间限制了？？继续找出性能问题点优化
         * @see #findDiagonalOrder2
         * @param nums
         * @return
         */
        public int[] findDiagonalOrder(List<List<Integer>> nums) {
            int globalRowSize = nums.size();
            List<Integer> retList = new ArrayList<>();
            int maxCol = nums.get(0).size();
            //phase1 （0,0） -> （max,0）
            for (int i = 0; i < globalRowSize; i++) {
                int row = i;
                int col = 0;
                int iRowColLength = nums.get(row).size();
                if (iRowColLength > maxCol) {
                    maxCol = iRowColLength;
                }
                while (row >=0 ) {
                    iRowColLength = nums.get(row).size();
                    //当列缺数据时continue
                    if (col < iRowColLength) {
                        retList.add(nums.get(row).get(col));
                    }
                    row --;
                    col ++;
                }
            }
            //phase2 （max,1）-> （max,max）
            for (int i = 1; i < maxCol; i++) {
                int row = globalRowSize -1;
//                int calculateSum = maxCol + globalRowSize -2;
                int col = i;
                int iRowColLength;
                while (col < maxCol && row >= 0) {
                    iRowColLength = nums.get(row).size();
                    //当列缺数据时continue
                    if (col < iRowColLength) {
                        retList.add(nums.get(row).get(col));
                    }
                    row --;
                    col ++;
                }
            }
            int retSize = retList.size();
            int[] retInts = new int[retSize];
            for (int i = 0; i < retSize; i++) {
                retInts[i] = retList.get(i);
            }
            return retInts;
        }

        /**
         *
         * 优化之后，还是超出时间限制
         *
         *
         * @param nums
         * @return
         */
        public int[] findDiagonalOrder1(List<List<Integer>> nums) {
            int globalRowSize = nums.size();
            List<Integer> retList = new ArrayList<>();
            int maxCol = nums.get(0).size();
            int[] rowColLengthArray = new int[globalRowSize];
            BitSet barrier = new BitSet();
            for (int i = 0; i < globalRowSize; i++) {
                int currentRowSize = nums.get(i).size();
                if (currentRowSize > maxCol) {
                    maxCol = currentRowSize;
                }
                rowColLengthArray[i] = currentRowSize;
            }
            //phase1 （0,0） -> （max,0）
            for (int i = 0; i < globalRowSize; i++) {
                retList.addAll(test1(i, 0, nums, rowColLengthArray, barrier));
            }
            //phase2 （max,1）-> （max,max）
            int row = globalRowSize -1;
            for (int i = 1; i < maxCol; i++) {
                retList.addAll(test1(row, i, nums, rowColLengthArray, barrier));

            }
            int retSize = retList.size();
            int[] retInts = new int[retSize];
            for (int i = 0; i < retSize; i++) {
                retInts[i] = retList.get(i);
            }
            return retInts;
        }

        /**
         *
         * 返回一条对角线上的数字
         *
         * @param rowIdx
         * @param colIdx
         * @param nums
         * @param rowColLengthArray
         * @return
         */
        public List<Integer> test1(int rowIdx, int colIdx, List<List<Integer>> nums, int[] rowColLengthArray, BitSet barrier) {
            List<Integer> retList = new ArrayList<>();
            int sumIdx = rowIdx + colIdx;
            for (int i = rowIdx; i >= 0 ; i--) {
                int j = sumIdx - i;
                if (barrier.get(i)) {
                    continue;
                }
                if (j < rowColLengthArray[i]) {
                    retList.add(nums.get(i).get(j));
                } else {
                    barrier.set(i, true);
                }
            }
            return retList;
        }

        /**
         *
         * 参考扣友的思路，大一统思路，相同的和归集到map,再遍历，必须要用LinkedHashMap, hashMap是不行的
         *
         * 执行结果：
         * 通过
         * 显示详情
         * 执行用时：
         * 42 ms
         * , 在所有 Java 提交中击败了
         * 50.18%
         * 的用户
         * 内存消耗：
         * 66.8 MB
         * , 在所有 Java 提交中击败了
         * 44.65%
         * 的用户
         * @param nums
         * @return
         */
        public int[] findDiagonalOrder2(List<List<Integer>> nums) {
            Map<Integer, List<Integer>> map = new LinkedHashMap<>();
            int length = 0;
            for (int i = 0; i < nums.size(); i++) {
                List<Integer> num = nums.get(i);
                for (int i1 = 0; i1 < num.size(); i1++) {
                    int sumIdx = i + i1;
                    Integer val = num.get(i1);
                    map.compute(sumIdx, (key, oldVal) -> {
                        if (oldVal == null) {
                            oldVal = new ArrayList<>();
                            oldVal.add(val);
                        } else {
                            oldVal.add(val);
                        }
                        return oldVal;
                    });
                    length ++;
                }
            }

            int[] retInts = new int[length];
            int k = 0;
            for (Map.Entry<Integer, List<Integer>> listEntry : map.entrySet()) {
                List<Integer> list = listEntry.getValue();
                for (int i = list.size() - 1; i >= 0; i--) {
                    retInts[k ++] = list.get(i);
                }
            }
            return retInts;
        }

    }

    public static void main(String[] args) {
        List<List<Integer>> lists;
        //test1
        lists = new ArrayList<>();
        lists.add(Arrays.asList(1, 2, 3, 4, 5, 6));
        logger.info("{}", new Solution().findDiagonalOrder1(lists));//1,2,3,4,5,6

        //test2
        lists = new ArrayList<>();
        lists.add(Arrays.asList(1, 2, 3, 4, 5));
        lists.add(Arrays.asList(6,7));
        lists.add(Arrays.asList(8));
        lists.add(Arrays.asList(9,10,11));
        lists.add(Arrays.asList(12,13,14,15,16));
        logger.info("{}", new Solution().findDiagonalOrder2(lists));//1,6,2,8,7,3,9,4,12,10,5,13,11,14,15,16
    }
}
