package com.roy.miscellaneous.leetcode.stage1.stage10;

import org.slf4j.LoggerFactory;

/**
 * @author guojun
 * @date 2020/7/30
 *
 * 110. 平衡二叉树
 * 给定一个二叉树，判断它是否是高度平衡的二叉树。
 *
 * 本题中，一棵高度平衡二叉树定义为：
 *
 * 一个二叉树每个节点 的左右两个子树的高度差的绝对值不超过1。
 *
 * 示例 1:
 *
 * 给定二叉树 [3,9,20,null,null,15,7]
 *
 *     3
 *    / \
 *   9  20
 *     /  \
 *    15   7
 * 返回 true 。
 *
 * 示例 2:
 *
 * 给定二叉树 [1,2,2,3,3,null,null,4,4]
 *
 *        1
 *       / \
 *      2   2
 *     / \
 *    3   3
 *   / \
 *  4   4
 * 返回 false 。
 *
 *
 */
public class TestSolution110 {
    private static final org.slf4j.Logger logger = LoggerFactory.getLogger(TestSolution110.class);


    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }

    static class Solution {

        /**
         *
         * 递归计算每个节点的度，相差大于1直接（递归）返回-1，以后可以复用计算树的高度
         *
         * 执行结果：
         * 通过
         * 显示详情
         * 执行用时：1 ms, 在所有 Java 提交中击败了99.72%的用户
         * 内存消耗：40 MB, 在所有 Java 提交中击败了26.13%的用户
         *
         * @param root
         * @return
         */
        public boolean isBalanced(TreeNode root) {
            int treeDegree = checkBalance(root);
            if (treeDegree == -1) {
                return false;
            }
            return true;
        }

        private int checkBalance(TreeNode node) {
            if (node == null) {
                return 0;
            }
            int leftNodeDegree = checkBalance(node.left);
            int rightNodeDegree = checkBalance(node.right);

            if (leftNodeDegree == -1 || rightNodeDegree == -1) {
                return -1;
            }
            if (Math.abs(leftNodeDegree - rightNodeDegree) > 1) {
                return -1;
            } else {
                return Math.max(leftNodeDegree, rightNodeDegree) +1;
            }
        }

    }

    public static void main(String[] args) {
        TreeNode node1 = new TreeNode(3);
        node1.left = new TreeNode(9);
        node1.right = new TreeNode(20);
        node1.right.left = new TreeNode(15);
        node1.right.right = new TreeNode(7);

        logger.info("{}", new Solution().isBalanced(node1));//true
        node1 = new TreeNode(1);
        node1.left = new TreeNode(2);
        node1.right = new TreeNode(2);
        node1.left.left = new TreeNode(3);
        node1.left.right = new TreeNode(3);
        node1.left.left.left = new TreeNode(4);
        node1.left.left.right = new TreeNode(4);
        logger.info("{}", new Solution().isBalanced(node1));//false

    }
}
