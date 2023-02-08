package com.guo.roy.research.leetcode.stage2.stage20;

import org.slf4j.LoggerFactory;

/**
 *
 *剑指 Offer 36. 二叉搜索树与双向链表
 * 输入一棵二叉搜索树，将该二叉搜索树转换成一个排序的循环双向链表。要求不能创建任何新的节点，只能调整树中节点指针的指向。
 *
 *
 *
 * 为了让您更好地理解问题，以下面的二叉搜索树为例：
 *
 *
 *
 *
 *
 *
 *
 * 我们希望将这个二叉搜索树转化为双向循环链表。链表中的每个节点都有一个前驱和后继指针。对于双向循环链表，第一个节点的前驱是最后一个节点，最后一个节点的后继是第一个节点。
 *
 * 下图展示了上面的二叉搜索树转化成的链表。“head” 表示指向链表中有最小元素的节点。
 *
 *
 *
 *
 *
 *
 *
 * 特别地，我们希望可以就地完成转换操作。当转化完成以后，树中节点的左指针需要指向前驱，树中节点的右指针需要指向后继。还需要返回链表中的第一个节点的指针。
 *
 * @author guojun
 * @date 2021/12/20
 */
public class TestSolutionJianzhiOffer36 {
    private static final org.slf4j.Logger logger = LoggerFactory.getLogger(TestSolutionJianzhiOffer36.class);


    // Definition for a Node.
    static class Node {
        public int val;
        public Node left;
        public Node right;

        public Node() {}

        public Node(int _val) {
            val = _val;
        }

        public Node(int _val,Node _left,Node _right) {
            val = _val;
            left = _left;
            right = _right;
        }
    }

    static class Solution {
        private Node newRoot;
        private Node newTail;
        private Node  parentNode;

        /**
         *
         *
         * 执行结果：通过
         * 显示详情
         * 添加备注
         *
         * 执行用时：0 ms, 在所有 Java 提交中击败了100.00%的用户
         * 内存消耗：
         * 37.6 MB, 在所有 Java 提交中击败了76.34%的用户
         * 通过测试用例：
         * 50 / 50
         * @param root
         * @return
         */
        public Node treeToDoublyList(Node root) {
            if (root == null) {
                return null;
            }
            newTail = doTreeToDoublyList(root);
            //挂left指针
            Node kNode = newRoot;
            while (kNode.right != null) {
                kNode.right.left = kNode;
                kNode = kNode.right;
            }
            newRoot.left = newTail;
            newTail.right = newRoot;
            return newRoot;
        }

        /**
         * 先挂right指针，顺便求出head, tail
         * @param node
         * @return
         */
        public Node doTreeToDoublyList(Node node) {
            if (null == node) {
                return null;
            }

            //左子树
            Node retNode = node;
            Node leftBranch = doTreeToDoublyList(node.left);
            if (leftBranch == null) {
                if (newRoot == null) {
                    newRoot = node;
                }
                if (parentNode != null) {
                    parentNode.right = node;
                }
                parentNode = node;
            } else {
                leftBranch.right = node;
                parentNode = node;
            }

            //右子树
            if (parentNode == null) {
                parentNode = node;
            }
            Node rightBranch = doTreeToDoublyList(node.right);
            if (rightBranch != null) {
                retNode = rightBranch;
            }
            return retNode;
        }

    }

    public static void main(String[] args) {

//        Node root = new Node(4);
//        root.left = new Node(2);
//        root.right = new Node(5);
//        root.left.left = new Node(1);
//        root.left.right = new Node(3);


//        Node root = new Node(2);
//        root.left = new Node(1);

//        Node root = new Node(-1);
//        root.right = new Node(1);
//        root.right.right = new Node(9);

        Node root = new Node(28);
        root.left = new Node(-98);
        root.right = new Node(67);

        root.left.right = new Node(-89);
        root.right.left = new Node(62);

        root.left.right.left = new Node(-97);
        root.left.right.right = new Node(-25);
        root.right.left.right = new Node(64);

        root.left.right.right.left = new Node(-72);
        root.left.right.right.right = new Node(-9);

        root.left.right.right.left.left = new Node(-88);
        root.left.right.right.left.right = new Node(-41);

        root.left.right.right.right.right = new Node(-7);

        root.left.right.right.left.left.right = new Node(-78);
        root.left.right.right.left.right.left = new Node(-53);
        root.left.right.right.right.right.right = new Node(2);

        root.left.right.right.left.left.right.left = new Node(-85);
        root.left.right.right.left.left.right.right = new Node(-77);
        root.left.right.right.left.right.left.left = new Node(-69);
        root.left.right.right.left.right.left.right = new Node(-42);
        root.left.right.right.right.right.right.left = new Node(-1);


        Node node = new Solution().treeToDoublyList(root);
        logger.info("");
    }
}
