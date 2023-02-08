package com.roy.leetcode.stage1.stage11;

import org.slf4j.LoggerFactory;

/**
 * @author guojun
 * @date 2020/6/18
 *
 * 563. 二叉树的坡度
 * 给定一个二叉树，计算整个树的坡度。
 *
 * 一个树的节点的坡度定义即为，该节点左子树的结点之和和右子树结点之和的差的绝对值。空结点的的坡度是0。
 *
 * 整个树的坡度就是其所有节点的坡度之和。
 *
 *
 *
 * 示例：
 *
 * 输入：
 *          1
 *        /   \
 *       2     3
 * 输出：1
 * 解释：
 * 结点 2 的坡度: 0
 * 结点 3 的坡度: 0
 * 结点 1 的坡度: |2-3| = 1
 * 树的坡度 : 0 + 0 + 1 = 1
 *
 *
 * 提示：
 *
 * 任何子树的结点的和不会超过 32 位整数的范围。
 * 坡度的值不会超过 32 位整数的范围。
 * 通过次数12,912提交次数23,333
 *
 */
public class TestSolution563 {
    private static final org.slf4j.Logger logger = LoggerFactory.getLogger(TestSolution563.class);

    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }

    static class Solution {

        /**
         *
         *
         * 注：把节点的下级节点的度的和都记在了node.val里，节省了或者对象，发现传Integer进去没有，老是变且没有setValue方法
         *
         * 执行结果：通过
         * 显示详情
         * 执行用时 :
         * 0 ms, 在所有 Java 提交中击败了100.00%的用户
         * 内存消耗 :
         * 39.9 MB, 在所有 Java 提交中击败了33.33%的用户
         *
         * @param root
         * @return
         */
        public int findTilt(TreeNode root) {
            if (root == null) return 0;


            TreeNode left = root.left;
            TreeNode right = root.right;
            int leftVal = findTilt1(left);
            int rightVal = findTilt1(right);

            return  (root.left == null ? 0 : root.left.val) + (root.right == null ? 0 : root.right.val) + Math.abs(leftVal - rightVal);
        }

        private int findTilt1(TreeNode root) {
            if(root == null) {
                return 0;
            }
            int leftVal = findTilt1(root.left);
            int rightVal = findTilt1(root.right);
            int sum = leftVal + rightVal + root.val;
            root.val = (root.left == null ? 0 : root.left.val) + (root.right == null ? 0 : root.right.val) + Math.abs(leftVal - rightVal);
            return sum;
        }

    }

    public static void main(String[] args) {
        TreeNode node1 = new TreeNode(1);
        TreeNode node2 = new TreeNode(2);
        TreeNode node3 = new TreeNode(3);
        TreeNode node4 = new TreeNode(4);
        TreeNode node5 = new TreeNode(5);

        node1.left = node2;
        node2.left = node3;
        node3.left = node4;
        node4.left = node5;

        logger.info("{}", new Solution().findTilt(node1));//40

        node1 = new TreeNode(1);
        node2 = new TreeNode(2);
        node3 = new TreeNode(3);
        node4 = new TreeNode(4);
        node5 = new TreeNode(5);

        node1.left = node2;
        node1.right = node3;
        node2.left = node4;
        node2.right = node5;
        node3.left = null;
        node3.right = null;
        node4.left = null;
        node4.right = null;
        logger.info("{}", new Solution().findTilt(node1));//9

    }
}
