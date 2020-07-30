package com.roy.miscellaneous.leetcode.stage1.stage10;

import org.slf4j.LoggerFactory;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * @author guojun
 * @date 2020/7/30
 *
 * 257. 二叉树的所有路径
 * 给定一个二叉树，返回所有从根节点到叶子节点的路径。
 *
 * 说明: 叶子节点是指没有子节点的节点。
 *
 * 示例:
 *
 * 输入:
 *
 *    1
 *  /   \
 * 2     3
 *  \
 *   5
 *
 * 输出: ["1->2->5", "1->3"]
 *
 * 解释: 所有根节点到叶子节点的路径为: 1->2->5, 1->3
 *
 *
 */
public class TestSolution257 {
    private static final org.slf4j.Logger logger = LoggerFactory.getLogger(TestSolution257.class);


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
         * 一样的套路。mark下，树里面递归用的挺多的
         *
         * 执行结果：
         * 通过
         * 显示详情
         * 执行用时：
         * 1 ms, 在所有 Java 提交中击败了100.00%的用户
         * 内存消耗：
         * 39.7 MB, 在所有 Java 提交中击败了80.65%的用户
         *
         *
         * @param root
         * @return
         */
        public List<String> binaryTreePaths(TreeNode root) {
            //空树和只有一个节点的要考虑的，leetcode的testcase里有的
            //空树
            if (root == null) {
                return Collections.emptyList();
            }

            //只有一个节点
            if (root.left == null && root.right == null) {
                return Arrays.asList(String.valueOf(root.val));
            }

            ArrayList<String> ret = new ArrayList<>();
            binaryTreePathsSub(root, "" ,ret);
            return ret;
        }

        private void binaryTreePathsSub(TreeNode node, String parentStr ,List<String> routes) {
            TreeNode leftNode = node.left;
            TreeNode rightNode = node.right;
            StringBuilder currentSb = new StringBuilder();
            if (parentStr == "") {
                currentSb.append((node.val));
            } else {
                currentSb.append(parentStr).append("->").append((node.val));
            }

            String currentStr = currentSb.toString();

            //leftNode
            if (leftNode != null) {
                //叶子节点
                if ((leftNode.left == null) && (leftNode.right == null)) {

                    routes.add(new StringBuilder().append(currentStr).append("->").append(leftNode.val).toString());
                } else {
                    binaryTreePathsSub(leftNode, currentStr, routes);
                }
            }
            //rightNode
            if (rightNode != null) {
                //叶子节点
                if ((rightNode.left == null) && (rightNode.right == null)) {
                    routes.add(new StringBuilder().append(currentStr).append("->").append(rightNode.val).toString());
                } else {
                    binaryTreePathsSub(rightNode, currentStr, routes);
                }
            }
        }
    }

    public static void main(String[] args) {
        TreeNode node3 = new TreeNode(1);
        node3.left = new TreeNode(2);
        node3.right = new TreeNode(3);
        logger.info("{}", new Solution().binaryTreePaths(node3));//1->2  1->3

        TreeNode node1 = new TreeNode(1);
        node1.left = new TreeNode(2);
        node1.right = new TreeNode(3);
        node1.left.right = new TreeNode(5);
        logger.info("{}", new Solution().binaryTreePaths(node1));//1->2->5 1->3

        TreeNode node2 = new TreeNode(1);
        logger.info("{}", new Solution().binaryTreePaths(node2));//1



    }
}
