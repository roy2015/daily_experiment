package com.roy.leetcode.stage1.stage11;

import org.slf4j.LoggerFactory;

/**
 * @author guojun
 * @date 2020/7/30
 *
 * 111. 二叉树的最小深度
 * 给定一个二叉树，找出其最小深度。
 *
 * 最小深度是从根节点到最近叶子节点的最短路径上的节点数量。
 *
 * 说明: 叶子节点是指没有子节点的节点。
 *
 * 示例:
 *
 * 给定二叉树 [3,9,20,null,null,15,7],
 *
 *     3
 *    / \
 *   9  20
 *     /  \
 *    15   7
 * 返回它的最小深度  2.
 *
 *
 */
public class TestSolution111 {
    private static final org.slf4j.Logger logger = LoggerFactory.getLogger(TestSolution111.class);


    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }

    static class Solution {

        /**
         *
         * 折腾出来了，递归里面写判断考虑的东西比较多，场景考虑完善就要加更多的判断 Integer.MAX_VALUE的使用
         *
         *
         *
         * 执行结果：
         * 通过
         * 显示详情
         * 执行用时：
         * 0 ms, 在所有 Java 提交中击败了100.00%的用户
         * 内存消耗：
         * 39.9 MB, 在所有 Java 提交中击败了31.17%的用户
         *
         * @param root
         * @return
         */
        public int minDepth(TreeNode root) {
            //空树
            if (root == null) {
                return 0;
            }

            TreeNode leftNode = root.left;
            TreeNode rightNode = root.right;
            //tree 只有一个节点的情况
            if (leftNode == null && rightNode == null) {
                return 1;
            }

            //左节点是叶子
            if (leftNode != null && leftNode.left == null && leftNode.right == null) {
                return 2;
            }

            //右节点是叶子
            if (rightNode != null && rightNode.left == null && rightNode.right == null) {
                return 2;
            }

            //左右都不是叶子节点，包括（null, 非叶子节点）， null记为Integer.MAX_VALUE
            int leftDegree = Integer.MAX_VALUE;
            int rightDegree = Integer.MAX_VALUE;
            if (leftNode != null) {
                leftDegree = minDepth(leftNode) +1;
            }
            if (rightNode != null) {
                rightDegree = minDepth(rightNode) +1;
            }

            return Math.min(leftDegree, rightDegree);
        }

    }

    public static void main(String[] args) {
        //一个节点
        TreeNode node4 = new TreeNode(0);
        logger.info("{}", new Solution().minDepth(node4));//1

        //单边树
        TreeNode node5 = new TreeNode(1);
        node5.left = new TreeNode(2);
        node5.left.left = new TreeNode(3);
        node5.left.left.left = new TreeNode(4);
        node5.left.left.left.left = new TreeNode(5);
        logger.info("{}", new Solution().minDepth(node5));//5


        TreeNode node3 = new TreeNode(1);
        node3.left = new TreeNode(2);
        node3.right = new TreeNode(3);
        node3.left.left = new TreeNode(4);
        node3.right.right = new TreeNode(5);

        logger.info("{}", new Solution().minDepth(node3));//3

        TreeNode node1 = new TreeNode(3);
        node1.left = new TreeNode(9);
        node1.right = new TreeNode(20);
        node1.right.left = new TreeNode(15);
        node1.right.right = new TreeNode(7);

        logger.info("{}", new Solution().minDepth(node1));//2

        TreeNode node2 = new TreeNode(1);
        node2.left = new TreeNode(2);
        logger.info("{}", new Solution().minDepth(node2));//2



    }
}
