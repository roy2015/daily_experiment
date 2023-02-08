package com.guo.roy.research.leetcode.stage1.stage13;

import org.slf4j.LoggerFactory;

/**
 * @author guojun
 * @date 2020/7/23
 *
 * 1022. 从根到叶的二进制数之和
 * 给出一棵二叉树，其上每个结点的值都是 0 或 1 。每一条从根到叶的路径都代表一个从最高有效位开始的二进制数。例如，如果路径为 0 -> 1 -> 1 -> 0 -> 1，那么它表示二进制数 01101，也就是 13 。
 *
 * 对树上的每一片叶子，我们都要找出从根到该叶子的路径所表示的数字。
 *
 * 以 10^9 + 7 为模，返回这些数字之和。
 *
 *
 *
 * 示例：
 *
 *
 *
 * 输入：[1,0,1,0,1,0,1]
 * 输出：22
 * 解释：(100) + (101) + (110) + (111) = 4 + 5 + 6 + 7 = 22
 *
 *
 * 提示：
 *
 * 树中的结点数介于 1 和 1000 之间。
 * node.val 为 0 或 1 。
 *
 */
public class TestSolution1022 {
    private static final org.slf4j.Logger logger = LoggerFactory.getLogger(TestSolution1022.class);


    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }

    static class Solution {

        /**
         *
         * 执行结果：
         * 通过
         * 显示详情
         * 执行用时：
         * 0 ms, 在所有 Java 提交中击败了100.00%的用户
         * 内存消耗：
         * 38.4 MB, 在所有 Java 提交中击败了16.67%的用户
         *
         * @param root
         * @return
         */
        public int sumRootToLeaf(TreeNode root) {
            int sumRootToLeafSub = sumRootToLeafSub(root, 0);
            return sumRootToLeafSub  ;
        }

        /**
         *
         * @param node
         * @param parentRadix 基数
         * @return
         */
        private int sumRootToLeafSub(TreeNode node, int parentRadix) {
            /*if (node == null) {
                return parentRadix;
            }*/

            //基数，比如第二层 << 1
            int nextParentRadix = parentRadix << 1;
            nextParentRadix += node.val;

            TreeNode left = node.left;
            TreeNode right = node.right;
            if (left == null && right == null) {
                return nextParentRadix;
            }

            int sum = 0;
            if (left != null) {
                sum += sumRootToLeafSub(left, nextParentRadix);
            }

            if (right != null) {
                sum += sumRootToLeafSub(right, nextParentRadix);
            }
            return sum;
        }
    }

    public static void main(String[] args) {
        //test1
        TreeNode node1 = new TreeNode(1);
        TreeNode node2 = new TreeNode(0);
        TreeNode node3 = new TreeNode(1);
        TreeNode node4 = new TreeNode(0);
        TreeNode node5 = new TreeNode(1);
        TreeNode node6 = new TreeNode(0);
        TreeNode node7 = new TreeNode(1);
        TreeNode node8;

        node1.left = node2;
        node1.right = node3;
        node1.left.left = node4;
        node1.left.right = node5;
        node1.right.left = node6;
        node1.right.right = node7;

        logger.info("{}", new Solution());
        logger.info("{}", new Solution().sumRootToLeaf(node1));//22

        //test2
        node1 = new TreeNode(0);
        node2 = new TreeNode(1);
        node3 = new TreeNode(0);
        node4 = new TreeNode(0);
        node5 = new TreeNode(0);
        node6 = new TreeNode(0);
        node7 = new TreeNode(1);
        node8 = new TreeNode(1);
        node1.left = node2;
        node1.left.left = node4;
        node1.right = node3;
        node1.right.left = node5;
        node1.right.right = node6;

        node1.right.left.right = node7;
        node1.right.left.right.right = node8;

        logger.info("{}", new Solution().sumRootToLeaf(node1));//5
    }
}
