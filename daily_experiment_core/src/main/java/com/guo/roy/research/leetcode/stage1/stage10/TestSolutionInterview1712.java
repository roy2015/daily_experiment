package com.guo.roy.research.leetcode.stage1.stage10;

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

        /**
         *
         *
         *
         * 思路：
         *  1. 每次递归，left sub-tree应该返回最大的节点， right sub-tree应该返回最小的节点， 再挂上当前节点
         *  2. 新的root应该单独计算作为class的field
         *还是比较紊乱
         *
         * @param root
         * @return
         */
        public TreeNode convertBiNode1(TreeNode root) {
            if (root == null) {
                return null;
            }

            TreeNode leftNode = root.left;
            TreeNode rightNode = root.right;

            //降低复杂度，从root开始一次
            if(leftNode != null) {
                TreeNode lefChildRt = funLeft(leftNode, 1, 1);
                lefChildRt.right = root;
                root.left = null;
            }

            if(rightNode != null) {
                TreeNode rightChildRt = funLeft(rightNode, 2,2);
                root.right = rightChildRt;
            }

            //考虑树只有一个节点的情况
            return newHead == null ? root : newHead ;
        }





        public TreeNode funLeft(TreeNode node, int currentFlag, int preFlag) {
            TreeNode left = node.left;
            TreeNode right = node.right;

            TreeNode funRight = null;
            TreeNode funLeft = null;
            TreeNode retNode = node;//默认返回本节点
//            node.left = null;
            if (left == null) {
                if (newHead == null) {
                    newHead = node;
                    newHead.left = null;
                }
            } else {
                funLeft = funLeft(left, 1, preFlag);
                funLeft.left = null;//funLeft can be not-null
                funLeft.right = node;
                node.left = null;
            }

            if (right != null) {
                funRight = funLeft(right, 2, preFlag);
                node.right = funRight;
            } else {}

            if (preFlag == 1 && currentFlag == 1) {
                if (funRight != null) {
                    retNode = funRight;
                }
            } else if (preFlag == 1 && currentFlag == 2) {
                if (funLeft != null) {
                    retNode = funLeft;
                }
            } else if (preFlag == 2 && currentFlag == 1 ) {
                if (funLeft != null) {
                    retNode = funLeft;
                }
            } else {
                if (funLeft != null) {
                    retNode = funLeft;
                }
            }

            return retNode;
        }


        public TreeNode convertBiNode(TreeNode root) {
            TreeNode dummyNode = new TreeNode(-1);
            convertBiNodeSub(root, dummyNode);
            return dummyNode.right;
        }

        /**
         *
         *
         * 参考了题解，用中序遍历并记录上一个节点（层次节点）
         *
         *执行结果：
         * 通过
         * 显示详情
         * 执行用时：
         * 0 ms
         * , 在所有 Java 提交中击败了
         * 100.00%
         * 的用户
         * 内存消耗：
         * 45.7 MB
         * , 在所有 Java 提交中击败了
         * 13.08%
         * 的用户
         *
         * @param calNode
         * @param currentNode
         */
        private TreeNode convertBiNodeSub(TreeNode calNode, TreeNode currentNode) {
            if (calNode == null) {
                return null;
            }
            TreeNode leftRetNode = convertBiNodeSub(calNode.left, currentNode);
            if (leftRetNode != null) {
                currentNode = leftRetNode;
            }

            currentNode.right = calNode;//只想当前节点
            calNode.left = null;//用完失效left
            currentNode = calNode;
            //到右边去
            TreeNode rihgtRetNode = convertBiNodeSub(calNode.right, currentNode);
            if (rihgtRetNode != null) {
                currentNode = rihgtRetNode;
            }
            return currentNode;
        }
    }

    public static void main(String[] args) {


        TreeNode node1 = new TreeNode(4);
        node1.left = new TreeNode(2);
        node1.left.left = new TreeNode(1);
        node1.left.left.left = new TreeNode(0);
        node1.left.right = new TreeNode(3);

        node1.right = new TreeNode(5);
        node1.right.right = new TreeNode(6);
        logger.info("{}", new Solution().convertBiNode(node1));
    }
}
