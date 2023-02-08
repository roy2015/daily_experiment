package com.guo.roy.research.leetcode.stage1.stage10;

import org.slf4j.LoggerFactory;

/**
 * @author guojun
 * @date 2020/7/30
 *
 * 404. 左叶子之和
 * 计算给定二叉树的所有左叶子之和。
 *
 * 示例：
 *
 *     3
 *    / \
 *   9  20
 *     /  \
 *    15   7
 *
 * 在这个二叉树中，有两个左叶子，分别是 9 和 15，所以返回 24
 *
 *
 */
public class TestSolution404 {
    private static final org.slf4j.Logger logger = LoggerFactory.getLogger(TestSolution404.class);


    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }

    static class Solution {

        /**
         * 这个递归有点绕，关键是理解题目，什么才是左叶子
         *
         * 执行结果：
         * 通过
         * 显示详情
         * 执行用时：
         * 0 ms, 在所有 Java 提交中击败了100.00%的用户
         * 内存消耗：
         * 37.8 MB, 在所有 Java 提交中击败了33.33%的用户
         *
         * @param root
         * @return
         */
        public int sumOfLeftLeaves(TreeNode root) {
            //防止一开始进来就是null，导致后面left,riht node nullpointException
            if (root == null) {
                return 0;
            }
            TreeNode leftNode = root.left;
            TreeNode rightNode = root.right;
            int ret = 0;
            //left node
            if (leftNode != null) {
                //是否叶子节点
                if (leftNode.left == null &&  leftNode.right == null) {
                    ret += leftNode.val;
                }
                ret += sumOfLeftLeaves(leftNode);
            }
            //right node
            if (rightNode != null) {
                ret += sumOfLeftLeaves(rightNode);
            }
            return ret;
        }
    }

    public static void main(String[] args) {
        logger.info("{}", new Solution().sumOfLeftLeaves(null));//0 空节点

        TreeNode node2 = new TreeNode(1);
        node2.left = new TreeNode(2);
        node2.right = new TreeNode(3);
        node2.left.left = new TreeNode(4);
        node2.left.right = new TreeNode(5);
        logger.info("{}", new Solution().sumOfLeftLeaves(node2));//4

        TreeNode node1 = new TreeNode(3);
        node1.left = new TreeNode(9);
        node1.right = new TreeNode(20);
        node1.right.left = new TreeNode(15);
        node1.right.right = new TreeNode(7);
        logger.info("{}", new Solution().sumOfLeftLeaves(node1));//24

        TreeNode node3 = new TreeNode(0);
        node3.left = new TreeNode(2);
        node3.right = new TreeNode(4);
        node3.left.left = new TreeNode(1);
        node3.right.left = new TreeNode(3);
        node3.right.right = new TreeNode(-1);
        node3.left.left.left = new TreeNode(5);
        node3.left.left.right = new TreeNode(1);
        node3.right.left.right = new TreeNode(6);
        node3.right.right.right = new TreeNode(8);
        logger.info("{}", new Solution().sumOfLeftLeaves(node3));//24





    }
}
