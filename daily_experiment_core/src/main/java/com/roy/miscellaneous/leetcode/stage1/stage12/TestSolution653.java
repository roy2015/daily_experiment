package com.roy.miscellaneous.leetcode.stage1.stage12;

import org.slf4j.LoggerFactory;

/**
 * @author guojun
 * @date 2020/8/4
 *
 *
 * 653. 两数之和 IV - 输入 BST
 * 给定一个二叉搜索树和一个目标结果，如果 BST 中存在两个元素且它们的和等于给定的目标结果，则返回 true。
 *
 * 案例 1:
 *
 * 输入:
 *     5
 *    / \
 *   3   6
 *  / \   \
 * 2   4   7
 *
 * Target = 9
 *
 * 输出: True
 *
 *
 * 案例 2:
 *
 * 输入:
 *     5
 *    / \
 *   3   6
 *  / \   \
 * 2   4   7
 *
 * Target = 28
 *
 * 输出: False
 *
 *
 */
public class TestSolution653 {
    private static final org.slf4j.Logger logger = LoggerFactory.getLogger(TestSolution653.class);

    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) {
            val = x;
        }
    }


    static class Solution {
        /**
         *
         *
         * ~~ 要注意细节，一个元素不用重复使用
         *
         * 执行结果：
         * 通过
         * 显示详情
         * 执行用时：
         * 1 ms, 在所有 Java 提交中击败了100.00%的用户
         * 内存消耗：
         * 40.4 MB, 在所有 Java 提交中击败了56.62%的用户
         *
         * @param root
         * @param k
         * @return
         */
        public boolean findTarget(TreeNode root, int k) {
            return findTargetSub(root, root, k);
        }


        public boolean findTargetSub(TreeNode root, TreeNode currNode, int k) {
            if (currNode == null) {
                return false;
            }

            boolean ret = false;
            //以当前元素作为第一个元素是加另一个元素是否满足要求
            int k1 = k - currNode.val;
            //相同元素的处理
            if (k1 == currNode.val) {
                if (currNode.left != null && currNode.left.val == k1) {
                    return true;
                }
                if (currNode.right != null && currNode.right.val == k1) {
                    return true;
                }
            } else {
                ret = searchBSTEl(root, k1);
                if (ret) {
                    return true;
                }
            }
            ret = findTargetSub(root, currNode.left, k);
            if (ret) {
                return true;
            }
            return findTargetSub(root, currNode.right, k);
        }

        /**
         * BST 查找元素
         * @param root
         * @param val
         * @return
         */
        public boolean searchBSTEl (TreeNode root, int val) {
            if (root == null) {
                return false;
            }

            if (root.val == val) {
                return true;
            } else if (val < root.val) {
                boolean leftRes = searchBSTEl(root.left, val);
                return leftRes;
            } else {
                boolean rightRes = searchBSTEl(root.right, val);
                return rightRes;
            }
        }
    }

    public static void main(String[] args) {

        TreeNode node3 = new TreeNode(2);
        node3.left = new TreeNode(1);
        node3.right = new TreeNode(3);
        logger.info("{}", new Solution().findTarget(node3, 4));//true

        TreeNode node1 = new TreeNode(5);
        node1.left = new TreeNode(3);
        node1.right = new TreeNode(6);
        node1.left.left = new TreeNode(2);
        node1.left.right = new TreeNode(4);
        node1.right.right = new TreeNode(7);
//        logger.info("{}", new Solution().searchBSTEl(node1,7));
//        logger.info("{}", new Solution().searchBSTEl(node1,5));
        logger.info("{}", new Solution().findTarget(node1, 9));//true

        logger.info("{}", new Solution().findTarget(node1, 28));//false

        TreeNode node2 = new TreeNode(1);
        logger.info("{}", new Solution().findTarget(node2, 2));//false
    }
}
