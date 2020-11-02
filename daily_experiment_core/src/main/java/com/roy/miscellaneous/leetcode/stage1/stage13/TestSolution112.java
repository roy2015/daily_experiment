package com.roy.miscellaneous.leetcode.stage1.stage13;

import org.slf4j.LoggerFactory;

/**
 * @author guojun
 * @date 2020/11/2
 *
 * 112. 路径总和
 * 给定一个二叉树和一个目标和，判断该树中是否存在根节点到叶子节点的路径，这条路径上所有节点值相加等于目标和。
 *
 * 说明: 叶子节点是指没有子节点的节点。
 *
 * 示例:
 * 给定如下二叉树，以及目标和 sum = 22，
 *
 *               5
 *              / \
 *             4   8
 *            /   / \
 *           11  13  4
 *          /  \      \
 *         7    2      1
 * 返回 true, 因为存在目标和为 22 的根节点到叶子节点的路径 5->4->11->2。
 *
 */
public class TestSolution112 {
    private static final org.slf4j.Logger logger = LoggerFactory.getLogger(TestSolution112.class);


//    Definition for a binary tree node.
    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }


    /**
     *
     *
     * 非中序遍历即可
     *
     * 执行结果：通过
     * 显示详情
     * 执行用时：0 ms, 在所有 Java 提交中击败了100.00%的用户
     * 内存消耗：38.6 MB, 在所有 Java 提交中击败了75.39%的用户
     *
     */
    static class Solution {
        private int sum;
        public boolean hasPathSum(TreeNode root, int sum) {
            if (root == null) {
                return false;
            }
            this.sum = sum;
            return hasPathSumSub(root, 0);
        }

        private boolean hasPathSumSub(TreeNode node, int pareSum) {
            int currVal = node.val;
            TreeNode left = node.left;
            TreeNode right = node.right;
            if (left == null && right == null) {
                if (currVal + pareSum == sum) {
                    return true;
                } else return false;
            }

            boolean res = false;
            pareSum += currVal;
            if (left !=null) {
                res = hasPathSumSub(left, pareSum);
                if (res) {
                    return true;
                }
            }
            if (right != null) {
                res = hasPathSumSub(right, pareSum);
                if (res) {
                    return true;
                }
            }
            return res;
        }

    }

    public static void main(String[] args) {

        TreeNode root = new TreeNode(5);
        root.left = new TreeNode(4);
        root.right = new TreeNode(8);

        root.left.left = new TreeNode(11);
        root.right.left = new TreeNode(13);
        root.right.right = new TreeNode(4);

        root.left.left.left = new TreeNode(7);
        root.left.left.right = new TreeNode(2);

        root.right.right.right = new TreeNode(1);

        logger.info("{}", new Solution().hasPathSum(root, 22));
    }
}
