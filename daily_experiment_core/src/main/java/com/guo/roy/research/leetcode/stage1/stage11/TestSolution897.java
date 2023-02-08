package com.guo.roy.research.leetcode.stage1.stage11;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.LoggerFactory;

/**
 * @author guojun
 * @date 2020/8/4
 *
 *
 * 897. 递增顺序查找树
 * 给你一个树，请你 按中序遍历 重新排列树，使树中最左边的结点现在是树的根，并且每个结点没有左子结点，只有一个右子结点。
 *
 *
 *
 * 示例 ：
 *
 * 输入：[5,3,6,2,4,null,8,1,null,null,null,7,9]
 *
 *        5
 *       / \
 *     3    6
 *    / \    \
 *   2   4    8
 *  /        / \
 * 1        7   9
 *
 * 输出：[1,null,2,null,3,null,4,null,5,null,6,null,7,null,8,null,9]
 *
 *  1
 *   \
 *    2
 *     \
 *      3
 *       \
 *        4
 *         \
 *          5
 *           \
 *            6
 *             \
 *              7
 *               \
 *                8
 *                 \
 *                  9
 *
 *
 * 提示：
 *
 * 给定树中的结点数介于 1 和 100 之间。
 * 每个结点都有一个从 0 到 1000 范围内的唯一整数值。
 *
 *
 *
 */
public class TestSolution897 {
    private static final org.slf4j.Logger logger = LoggerFactory.getLogger(TestSolution897.class);

    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }

    static class Solution {

        /**
         *
         * tree还是比较有趣的~~
         * 先求节点list, 再把节点list link起来
         *
         * 执行结果：
         * 通过
         * 显示详情
         * 执行用时：
         * 0 ms, 在所有 Java 提交中击败了100.00%的用户
         * 内存消耗：
         * 37 MB, 在所有 Java 提交中击败了94.22%的用户
         *
         * @param root
         * @return
         */
        public TreeNode increasingBST(TreeNode root) {
            List<TreeNode> recevieNodeList = new ArrayList<>();
            increasingBSTSub(root, recevieNodeList);
            return buildNewTree(recevieNodeList);
        }

        private void increasingBSTSub(TreeNode node, List<TreeNode> list) {
            if (node == null) {
                return;
            }
            increasingBSTSub(node.left, list);
            list.add(node);
            increasingBSTSub(node.right, list);
        }

        private TreeNode buildNewTree(List<TreeNode> list) {
            int size = list.size();
            for (int i = 0; i < size; i++) {
                TreeNode iNode = list.get(i);
                TreeNode jNode = null;
                if (i +1 < size) {
                    jNode = list.get(i + 1);
                }

                iNode.left = null;
                if (jNode != null) {
                    iNode.right = jNode;
                }
            }
            return list.get(0);
        }

    }

    public static void main(String[] args) {
        TreeNode node1 = new TreeNode(5);
        node1.left = new TreeNode(3);
        node1.right = new TreeNode(6);
        node1.left.left = new TreeNode(2);
        node1.left.right = new TreeNode(4);
        node1.right.right = new TreeNode(8);
        node1.left.left.left = new TreeNode(1);
        node1.right.right.left = new TreeNode(7);
        node1.right.right.right = new TreeNode(9);

        logger.info("{}", new Solution().increasingBST(node1));
    }
}
