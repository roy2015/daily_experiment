package com.roy.leetcode.stage1.stage10;

import org.slf4j.LoggerFactory;

/**
 * Created by apple on 2019/11/11.
 *将一个按照升序排列的有序数组，转换为一棵高度平衡二叉搜索树。

 本题中，一个高度平衡二叉树是指一个二叉树每个节点 的左右两个子树的高度差的绝对值不超过 1。

 示例:

 给定有序数组: [-10,-3,0,5,9],

 一个可能的答案是：[0,-3,9,-10,null,5]，它可以表示下面这个高度平衡二叉搜索树：

       0
      / \
    -3   9
   /   /
 -10  5

 来源：力扣（LeetCode）
 链接：https://leetcode-cn.com/problems/convert-sorted-array-to-binary-search-tree
 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 */
public class TestSolution108 {
    private static final org.slf4j.Logger logger = LoggerFactory.getLogger(TestSolution108.class);

    static class TreeNode {
         int val;
         TreeNode left;
         TreeNode right;
         TreeNode(int x) { val = x; }
     }

    /**
     */
    static class Solution {


        /**
         *
         * 用递归用到脑子里能跑递归代码了
         *
         * 执行结果：
         * 通过
         * 显示详情
         * 执行用时：0 ms, 在所有 Java 提交中击败了100.00%的用户
         * 内存消耗：38.7 MB, 在所有 Java 提交中击败了76.39%的用户
         *
         * @param nums
         * @return
         */
        public TreeNode sortedArrayToBST(int[] nums) {
            int startIdx = 0;
            int endIdx = nums.length - 1;

            //特殊情况先排除掉
            int length = nums.length;
            if (length == 0) {
                return null;
            } else if (length ==1) {
                return new TreeNode(nums[0]);
            } else if (length == 2) {
                TreeNode rootNode1 = new TreeNode(nums[0]);
                rootNode1.right = new TreeNode(nums[1]);
                return rootNode1;
            } else {};

            //正常情况,3个元素或以上
            int parentIdx = (startIdx + endIdx) / 2;
            TreeNode rootNode = new TreeNode(nums[parentIdx]);
            int leftParentIdx = (startIdx + parentIdx -1) /2;
            TreeNode leftNode = new TreeNode(nums[leftParentIdx]);
            rootNode.left = leftNode;
            test(nums, leftNode, leftParentIdx, startIdx, parentIdx -1);

            int rightParentIdx = (parentIdx + 1 + endIdx) /2;
            TreeNode rightNode = new TreeNode(nums[rightParentIdx]);
            rootNode.right = rightNode;
            test(nums, rightNode, rightParentIdx, parentIdx + 1, endIdx);
            return rootNode;
        }

        /**
         *
         * @param nums
         * @param parentNode 这段区间的中间节点（已挂到tree上，主要是避免递归里不知道挂到左边还是右边，所以上层调用提前挂好）
         * @param parentIdx 这段区间的中间节点在数组里的index
         * @param startIdx 这段区间的startIdx
         * @param endIdx  这段区间的endIdx
         */
        private void test(int[] nums, TreeNode parentNode, int parentIdx, int startIdx, int endIdx) {
            //区间大小1
            if (startIdx == endIdx) {
                return ;
            }

            //区间大小2， 一边挂一个到parentNode
            if (endIdx == startIdx + 1) {
                parentNode.right = new TreeNode(nums[endIdx]);
                return;
            }

            //区间大小>=3,拆分成两个区间
            int leftParentIdx = (startIdx + parentIdx -1) /2;
            TreeNode leftNode = new TreeNode(nums[leftParentIdx]);
            parentNode.left = leftNode;
            test(nums, leftNode, leftParentIdx, startIdx, parentIdx -1);

            int rightParentIdx = (parentIdx + 1 + endIdx) /2;
            TreeNode rightNode = new TreeNode(nums[rightParentIdx]);
            parentNode.right = rightNode;
            test(nums, rightNode, rightParentIdx, parentIdx + 1, endIdx);

        }

    }

    public static void main(String[] args) {
        TreeNode treeNode;

        treeNode = new Solution().sortedArrayToBST(new int[]{
                0,1,2,3,4,5
        });

        treeNode = new Solution().sortedArrayToBST(new int[]{
                -10,-3,0,5,9
        });

        treeNode = new Solution().sortedArrayToBST(new int[]{
                1,3
        });
        logger.info("{}");
    }

}
