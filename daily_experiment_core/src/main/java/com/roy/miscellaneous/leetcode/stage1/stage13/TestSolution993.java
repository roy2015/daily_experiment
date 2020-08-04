package com.roy.miscellaneous.leetcode.stage1.stage13;

import org.slf4j.LoggerFactory;

/**
 * @author guojun
 * @date 2020/8/4
 *
 *
 * 993. 二叉树的堂兄弟节点
 * 在二叉树中，根节点位于深度 0 处，每个深度为 k 的节点的子节点位于深度 k+1 处。
 *
 * 如果二叉树的两个节点深度相同，但父节点不同，则它们是一对堂兄弟节点。
 *
 * 我们给出了具有唯一值的二叉树的根节点 root，以及树中两个不同节点的值 x 和 y。
 *
 * 只有与值 x 和 y 对应的节点是堂兄弟节点时，才返回 true。否则，返回 false。
 *
 *
 *
 * 示例 1：
 *
 *
 * 输入：root = [1,2,3,4], x = 4, y = 3
 * 输出：false
 * 示例 2：
 *
 *
 * 输入：root = [1,2,3,null,4,null,5], x = 5, y = 4
 * 输出：true
 * 示例 3：
 *
 *
 *
 * 输入：root = [1,2,3,null,4], x = 2, y = 3
 * 输出：false
 *
 *
 * 提示：
 *
 * 二叉树的节点数介于 2 到 100 之间。
 * 每个节点的值都是唯一的、范围为 1 到 100 的整数。
 *
 *
 */
public class TestSolution993 {
    private static final org.slf4j.Logger logger = LoggerFactory.getLogger(TestSolution993.class);

    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode() {
        }
        TreeNode(int val) {
            this.val = val;
        }
        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

    static class Solution {


        /**
         *
         *
         * 二叉树貌似没输过
         *  可能存在不足： 两次遍历了节点查询key, 返回了节点的信息(值，深度，父节点)， 但感觉都是必要的~~
         *
         * 执行结果：
         * 通过
         * 显示详情
         * 执行用时：
         * 0 ms, 在所有 Java 提交中击败了100.00%的用户
         * 内存消耗：
         * 37.4 MB, 在所有 Java 提交中击败了95.45%的用户
         *
         * @param root
         * @param x
         * @param y
         * @return
         */
        public boolean isCousins(TreeNode root, int x, int y) {
            NodeInfo xNodeInfo = getNodeInfo(root, 0, -1, x);
            NodeInfo yNodeInfo = getNodeInfo(root, 0, -1, y);

            return (xNodeInfo.depth == yNodeInfo.depth) && (xNodeInfo.val != yNodeInfo.val) && (xNodeInfo.parentVal != yNodeInfo.parentVal)
                    ? true : false;
        }

        public NodeInfo getNodeInfo(TreeNode node, int depth, int parentVal, int key) {
            if (node == null) {
                return null;
            }

            int curNodeVal = node.val;
            if (curNodeVal == key) {
                return new NodeInfo(curNodeVal, depth, parentVal);
            }

            NodeInfo leftNodeInfo = getNodeInfo(node.left, depth + 1 , curNodeVal, key);
            if (leftNodeInfo != null) {
                return leftNodeInfo;
            }

            NodeInfo rightNodeInfo = getNodeInfo(node.right, depth + 1, curNodeVal, key);
            if (rightNodeInfo != null) {
                return rightNodeInfo;
            }
            return null;
        }


        static class NodeInfo {
            private int val;
            private int depth;
            private int parentVal;

            public NodeInfo(int val, int depth, int parentVal) {
                this.val = val;
                this.depth = depth;
                this.parentVal = parentVal;
            }
        }
    }

    public static void main(String[] args) {
        TreeNode node2 = new TreeNode(1);
        node2.left = new TreeNode(2);
        node2.right = new TreeNode(3);
        node2.left.right = new TreeNode(4);
        node2.right.right = new TreeNode(5);
        logger.info("{}", new Solution().isCousins(node2, 4, 5));//true

        TreeNode node1 = new TreeNode(1);
        node1.left = new TreeNode(2);
        node1.right = new TreeNode(3);
        node1.left.left = new TreeNode(4);
        logger.info("{}", new Solution().isCousins(node1, 4, 3));//false
        logger.info("{}", new Solution().isCousins(node1, 2, 3));//false

    }
}
