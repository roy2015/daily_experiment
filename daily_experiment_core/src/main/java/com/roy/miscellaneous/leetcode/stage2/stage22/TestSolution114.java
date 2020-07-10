package com.roy.miscellaneous.leetcode.stage2.stage22;

import org.slf4j.LoggerFactory;

/**
 * @author guojun
 * @date 2020/7/10
 *
 * 114. 二叉树展开为链表
 * 给定一个二叉树，原地将它展开为一个单链表。
 *
 *
 *
 * 例如，给定二叉树
 *
 *     1
 *    / \
 *   2   5
 *  / \   \
 * 3   4   6
 * 将其展开为：
 *
 * 1
 *  \
 *   2
 *    \
 *     3
 *      \
 *       4
 *        \
 *         5
 *          \
 *           6
 *
 *
 */
public class TestSolution114 {
    private static final org.slf4j.Logger logger = LoggerFactory.getLogger(TestSolution114.class);

    /**
     *
     * Definition for a binary tree node.
     *
     */
    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode() {}
        TreeNode(int val) { this.val = val; }
        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }


    static class Solution {
        /**
         *
         * 稀里糊涂就写出来了
         *
         * 执行结果：
         * 通过
         * 显示详情
         * 执行用时：
         * 0 ms, 在所有 Java 提交中击败了100.00%的用户
         * 内存消耗：
         * 39.5 MB, 在所有 Java 提交中击败了6.67%的用户
         *
         * @param root
         */
        public void flatten(TreeNode root) {
            flattenSub(root);
        }

        public TreeNode flattenSub(TreeNode root) {
            if (root == null) {
                return null;
            }

            TreeNode retNode = root;//本次递归需要返回的node
            TreeNode leftNode = root.left;
            TreeNode rightNode = root.right;

            TreeNode leftNodeRet = flattenSub(leftNode);//左子树返回的node
            if (leftNodeRet != null) {
                root.right = leftNode;
                leftNodeRet.right = rightNode;
                root.left = null;//左边挂null节点
                retNode = leftNodeRet;
            }

            TreeNode rightNodeRet = flattenSub(rightNode);
            if (rightNodeRet != null) {
                retNode = rightNodeRet;
            }

            return  retNode;
        }
    }

    public static void main(String[] args) {
        TreeNode node1 = new TreeNode(1);
        TreeNode node2 = new TreeNode(2);
        TreeNode node3 = new TreeNode(3);
        TreeNode node4 = new TreeNode(4);
        TreeNode node5 = new TreeNode(5);
        TreeNode node6 = new TreeNode(6);
        node1.left = node2;
        node1.right = node5;
        node2.left = node3;
        node2.right = node4;
        node5.right = node6;

        new Solution().flatten(node1);
        logger.info("{}", new Solution());
    }
}
