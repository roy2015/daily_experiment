package com.roy.leetcode.stage1.stage11;

import org.slf4j.LoggerFactory;

/**
 * @author guojun
 * @date 2020/10/13
 *
 * 101. 对称二叉树
 * 给定一个二叉树，检查它是否是镜像对称的。
 *
 *
 *
 * 例如，二叉树 [1,2,2,3,4,4,3] 是对称的。
 *
 *     1
 *    / \
 *   2   2
 *  / \ / \
 * 3  4 4  3
 *
 *
 * 但是下面这个 [1,2,2,null,3,null,3] 则不是镜像对称的:
 *
 *     1
 *    / \
 *   2   2
 *    \   \
 *    3    3
 *
 *
 * 进阶：
 *
 * 你可以运用递归和迭代两种方法解决这个问题吗？
 *
 */
public class TestSolution101 {
    private static final org.slf4j.Logger logger = LoggerFactory.getLogger(TestSolution101.class);

    //Definition for a binary tree node.
    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }

    static class Solution {

        /**
         *
         * 以前没头绪，现在一想挺简单的：
         *  传root的left node和right node, 递归检查"左的右和右的左， 左的左和右的右边是否相等"，发现一个false直接跳出
         *
         * 执行结果：
         * 通过
         * 显示详情
         * 执行用时：0 ms, 在所有 Java 提交中击败了100.00%的用户
         * 内存消耗：37.3 MB, 在所有 Java 提交中击败了29.04%的用户
         *
         *
         * @param root
         * @return
         */
        public boolean isSymmetric(TreeNode root) {
            if (root == null) return true;
            return isSymmetricSub(root.left, root.right);
        }

        private boolean isSymmetricSub(TreeNode nodeA, TreeNode nodeB) {
            //一个为空一个不为空
            if ((nodeA == null) ^ (nodeB == null)) {
                return false;
            }
            //两个都为空,因为是空，所以不用往子节点走，return
            if ((nodeA == null) & (nodeB == null)) {
                return true;
            }

            //两个节点都不为空
            //值不等
            if (nodeA.val != nodeB.val) {
                return false;
            }

            //当前节点相等，到子节点去
            //false直接跳出，true继续往下
            if ( !isSymmetricSub(nodeA.left, nodeB.right)) {
                return false;
            }

            if ( !isSymmetricSub(nodeA.right, nodeB.left)) {
                return false;
            }
            return true;
        }
    }

    public static void main(String[] args) {
        TreeNode head;
        head = new TreeNode(1);
        head.left = new TreeNode(2);
        head.right = new TreeNode(2);
        head.left.left = new TreeNode(3);
        head.left.right = new TreeNode(4);
        head.right.left = new TreeNode(4);
        head.right.right = new TreeNode(3);
        logger.info("{}", new Solution().isSymmetric(head));//true

        head = new TreeNode(1);
        head.left = new TreeNode(2);
        head.right = new TreeNode(2);
        head.left.right = new TreeNode(3);
        head.right.right = new TreeNode(3);
        logger.info("{}", new Solution().isSymmetric(head));//false
    }
}
