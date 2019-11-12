package com.roy.miscellaneous.leetcode.stage1;

import org.slf4j.LoggerFactory;

/**
 * Created by apple on 2019/9/4.
 *
 * 合并二叉树
 *     1              2                       3
 *   3  2           1   3         ->        4   5
 * 5                 4   7                 5 4    7
 */
public class TestSolution617 {
    private static final org.slf4j.Logger logger = LoggerFactory.getLogger(TestSolution617.class);

    /**
     * Definition for a binary tree node.
     * public class TreeNode {
     * int val;
     * TreeNode left;
     * TreeNode right;
     * TreeNode(int x) { val = x; }
     * }
     */
    static class Solution {

        /**
         * 执行用时 :2 ms, 在所有 java 提交中击败了59.72%的用户
         内存消耗 :38.8 MB, 在所有 java 提交中击败了97.45%的用户
         *
         * @param t1
         * @param t2
         * @return
         */
        public TreeNode mergeTrees(TreeNode t1, TreeNode t2) {
            TreeNode node = new TreeNode(0);
            int val = 0;
            val = (t1 != null ? t1.val : 0) + (t2 != null ? t2.val : 0);
            node.val = val;

            TreeNode leftNode, rightNode;
            if (t1 == null && t2 == null) {
                return null;
            } else {
                leftNode = mergeTrees(t1 != null ? t1.left : null, t2 != null ? t2.left : null);
            }
            node.left = leftNode;
            rightNode = mergeTrees(t1 != null ? t1.right : null, t2 != null ? t2.right : null);
            node.right = rightNode;

            return node;
        }
    }

    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    public static void main(String[] args) {
        TreeNode leftNode = new TreeNode(1);
        leftNode.left = new TreeNode(3);
        leftNode.right = new TreeNode(2);
        leftNode.left.left = new TreeNode(5);

        TreeNode rightNode = new TreeNode(2);
        rightNode.left = new TreeNode(1);
        rightNode.right = new TreeNode(3);
        rightNode.left.right = new TreeNode(4);
        rightNode.right.right = new TreeNode(7);

        TreeNode node = new Solution().mergeTrees(leftNode, rightNode);
        logger.info("{}",node);

    }


}
