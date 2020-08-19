package com.roy.miscellaneous.leetcode.stage1.stage10;

import org.slf4j.LoggerFactory;

/**
 * @author guojun
 * @date 2020/8/14
 *
 *
 * 面试题 17.12. BiNode
 * 二叉树数据结构TreeNode可用来表示单向链表（其中left置空，right为下一个链表节点）。实现一个方法，把二叉搜索树转换为单向链表，要求依然符合二叉搜索树的性质，转换操作应是原址的，也就是在原始的二叉搜索树上直接修改。
 *
 * 返回转换后的单向链表的头节点。
 *
 * 注意：本题相对原题稍作改动
 *
 *
 *
 * 示例：
 *
 * 输入： [4,2,5,1,3,null,6,0]
 * 输出： [0,null,1,null,2,null,3,null,4,null,5,null,6]
 * 提示：
 *
 * 节点数量不会超过 100000。
 *
 *
 *
 */
public class TestSolutionInterview1712 {
    private static final org.slf4j.Logger logger = LoggerFactory.getLogger(TestSolutionInterview1712.class);


    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }

    static class Solution {
        private TreeNode newHead ;

        public TreeNode convertBiNode(TreeNode root) {
            TreeNode retNode = root;
            TreeNode leftNode = root.left;
            TreeNode rightNode = root.right;

            if(leftNode != null) {
                TreeNode lefChildRt = fun(leftNode);
                retNode = lefChildRt;
                retNode.right = root;
            }

            if(rightNode != null) {
                TreeNode rightChildRt = fun(rightNode);
                root.right = rightChildRt;
            }
            return retNode;
        }

        public TreeNode fun(TreeNode node) {
            TreeNode left = node.left;
            TreeNode right = node.right;

            TreeNode retNode = node;
            node.left = null;
            if (left == null) {
                if (newHead == null) {
                    newHead = node;
                    newHead.left = null;
                }
            } else {
                TreeNode funLeft = fun(left);
                funLeft.left = null;//funLeft should not-null
                funLeft.right = node;
            }

            if (right != null) {
                TreeNode funRight = fun(right);
                node.right = node;
                retNode = funRight;
            }
            return retNode;
        }
    }

    public static void main(String[] args) {
        logger.info("{}", new Solution());
    }
}
