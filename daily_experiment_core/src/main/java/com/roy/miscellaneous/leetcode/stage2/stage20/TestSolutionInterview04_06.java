package com.roy.miscellaneous.leetcode.stage2.stage20;

import jdk.nashorn.internal.ir.CallNode;
import org.slf4j.LoggerFactory;

/**
 * @author guojun
 * @date 2020/9/5
 *
 * 面试题 04.06. 后继者
 * 设计一个算法，找出二叉搜索树中指定节点的“下一个”节点（也即中序后继）。
 *
 * 如果指定节点没有对应的“下一个”节点，则返回null。
 *
 * 示例 1:
 *
 * 输入: root = [2,1,3], p = 1
 *
 *   2
 *  / \
 * 1   3
 *
 * 输出: 2
 * 示例 2:
 *
 * 输入: root = [5,3,6,2,4,null,null,1], p = 6
 *
 *       5
 *      / \
 *     3   6
 *    / \
 *   2   4
 *  /
 * 1
 *
 * 输出: null
 *
 */
public class TestSolutionInterview04_06 {
    private static final org.slf4j.Logger logger = LoggerFactory.getLogger(TestSolutionInterview04_06.class);

    static  class TreeNode {
         int val;
         TreeNode left;
         TreeNode right;
         TreeNode(int x) { val = x; }
     }

    static class Solution {
        public TreeNode inorderSuccessor(TreeNode root, TreeNode p) {
            //root is null
            if (root == null) {
                return null;
            }

            TreeNode retNode = test2(root, p, false);
            if (retNode == p) {
                return null;
            } else return retNode;

            /*TreeNode copyLeft = root.left;
            TreeNode copyRight = root.right;

            root.right = null;
            TreeNode res = test1(root, p);
            if (res != null ) {
                root.right = copyRight;
                return res;
            }

            root.left = null;
            root.right = copyRight;

            res = test1(root, p);
            if (res != null && res != root && res != p) {
                return res;
            }
            root.left = copyLeft;
            return null;*/

        }


        private TreeNode test2(TreeNode currNode,  TreeNode p, boolean isFind) {
            if (currNode == null) {
                return null;
            }

            if (currNode == p ) {
                if (currNode.right != null) {
                    if (currNode.right.left == null) {
                        return currNode.right;
                    } else {
                        return test2(currNode.right.left, p, true);
                    }
                } else {
                    return currNode;
                }
            } else {
                if (isFind) {
                    test2(currNode.left, p, true);
                    return currNode;
                } else {
                    TreeNode leftRes = test2(currNode.left, p, false);
                    if (leftRes != null) {
                        if (leftRes == p) {
                            return currNode;
                        } else {
                            return leftRes;
                        }
                    }

                    TreeNode rightRes = test2(currNode.right, p, false);
                    if (rightRes != null) {
                        if (rightRes == p) {
                            return rightRes;
                        } else {
                            return rightRes;
                        }
                    }
                    return null;
                }
            }

        }
    }

    public static void main(String[] args) {

        /**
         *    2
         *  1  3
         *
         *
         */
        TreeNode head = new TreeNode(2);
        TreeNode node1 = new TreeNode(1);
        TreeNode node3 = new TreeNode(3);
        head.left = node1;
        head.right = node3;

        TreeNode successor;
        successor = new Solution().inorderSuccessor(head, node1);
        logger.info("{}" , successor.val);//2
        successor = new Solution().inorderSuccessor(head, head);
        logger.info("head {}" , successor == null ? -1 : successor.val);//3
        successor = new Solution().inorderSuccessor(head, node3);
        logger.info("{}" , successor == null ? -1 : successor.val);//-1

        /**
         *               5
         *           3      6
         *        2   4       7
         *      1               8
         *
         *
         *
         */
        head = new TreeNode(5);
        node3 = new TreeNode(3);
        TreeNode node6 = new TreeNode(6);
        TreeNode node2 = new TreeNode(2);
        TreeNode node4 = new TreeNode(4);
        TreeNode node7 = new TreeNode(7);
        node1 = new TreeNode(1);
        TreeNode node8 = new TreeNode(8);
        head.left = node3;
        head.right = node6;
        head.left.left = node2;
        head.left.right = node4;
        head.left.left.left = node1;
        head.right.right = node7;
        head.right.right.right = node8;
        successor = new Solution().inorderSuccessor(head, head);
        logger.info("head {}" , successor == null ? -1 : successor.val);//6
        successor = new Solution().inorderSuccessor(head, node1);
        logger.info("1 {}" , successor == null ? -1 : successor.val);//2
        successor = new Solution().inorderSuccessor(head, node2);
        logger.info("2 {}" , successor == null ? -1 : successor.val);//3
        successor = new Solution().inorderSuccessor(head, node3);
        logger.info("3 {}" , successor == null ? -1 : successor.val);//4
        successor = new Solution().inorderSuccessor(head, node4);
        logger.info("4 {}" , successor == null ? -1 : successor.val);//5
        successor = new Solution().inorderSuccessor(head, node6);
        logger.info("6 {}" , successor == null ? -1 : successor.val);//6
        successor = new Solution().inorderSuccessor(head, node7);
        logger.info("7 {}" , successor == null ? -1 : successor.val);//7
        successor = new Solution().inorderSuccessor(head, node8);
        logger.info("8 {}" , successor == null ? -1 : successor.val);//-1

    }
}
