package com.roy.miscellaneous.leetcode.stage1.stage13;

import java.util.ArrayList;
import java.util.List;

import apple.laf.JRSUIUtils;
import org.slf4j.LoggerFactory;

/**
 *
 * @author guojun
 * @date 2020/9/5
 *
 *
 *面试题 04.04. 检查平衡性
 * 实现一个函数，检查二叉树是否平衡。在这个问题中，平衡树的定义如下：任意一个节点，其两棵子树的高度差不超过 1。
 *
 *
 * 示例 1:
 * 给定二叉树 [3,9,20,null,null,15,7]
 *     3
 *    / \
 *   9  20
 *     /  \
 *    15   7
 * 返回 true 。
 * 示例 2:
 * 给定二叉树 [1,2,2,3,3,null,null,4,4]
 *       1
 *      / \
 *     2   2
 *    / \
 *   3   3
 *  / \
 * 4   4
 * 返回 false 。
 *
 *
 */
public class TestSolutionInterview0404 {
    private static final org.slf4j.Logger logger = LoggerFactory.getLogger(TestSolutionInterview0404.class);

    static  class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    static class Solution {

        /**
         * 问题分解，1. 判断树的高度（单独写一个方法）2. 判断子树(左右)高度差
         *
         * 执行结果：通过
         * 显示详情
         * 执行用时：1 ms, 在所有 Java 提交中击败了100.00%的用户
         * 内存消耗：39.7 MB, 在所有 Java 提交中击败了66.28%的用户
         *
         *
         * @param root
         * @return
         */
        public boolean isBalanced(TreeNode root) {
            if (root == null) {
                return true;
            }

            if (Math.abs(getTreeDepth(root.right) - getTreeDepth(root.left)) > 1) {
                return false;
            }
            boolean isBalanced = isBalanced(root.left) && isBalanced(root.right);
            return isBalanced;
        }

        public int getTreeDepth(TreeNode node) {
            if (node == null) {
                return 1;
            }
            return Math.max(getTreeDepth(node.left), getTreeDepth(node.right)) + 1;
        }
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(2);
        root.left.left = new TreeNode(3);
        root.left.right = new TreeNode(3);
        root.left.left.left = new TreeNode(4);
        root.left.left.right = new TreeNode(4);
        logger.info("{}", new Solution().isBalanced(root));

        root = new TreeNode(3);
        root.left = new TreeNode(9);
        root.right = new TreeNode(20);
        root.right.left = new TreeNode(15);
        root.right.right = new TreeNode(7);

//        logger.info("{}", new Solution().getTreeDepth(root));
        logger.info("{}", new Solution().isBalanced(root));


    }

}
