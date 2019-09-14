package com.roy.miscellaneous.leetcode;

import org.slf4j.LoggerFactory;

/**
 * Created by apple on 2019/9/14.
 *
 * 翻转一棵二叉树。

 示例：

 输入：

   4
 /   \
 2     7
 / \   / \
 1   3 6   9
 输出：

   4
 /   \
  7      2
 / \   / \
 9   6 3   1

 来源：力扣（LeetCode）
 链接：https://leetcode-cn.com/problems/invert-binary-tree
 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 */
public class TestSolution226 {
    private static final org.slf4j.Logger logger = LoggerFactory.getLogger(TestSolution226.class);


    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }

    static class Solution {
        public TreeNode invertTree(TreeNode root) {
            if ( root == null ) {
                return null;
            }
            else {
                TreeNode leftNode = invertTree(root.left);
                TreeNode rightNode = invertTree(root.right);
                root.left = rightNode;
                root.right = leftNode;
                return root;
            }
        }
    }

    public static void main(String[] args) {
        TreeNode rootNode = new TreeNode(4);
        rootNode.left = new TreeNode(2);
        rootNode.right = new TreeNode(7);
        rootNode.left.left = new TreeNode(1);
        rootNode.left.right = new TreeNode(3);
        rootNode.right.left = new TreeNode(6);
        rootNode.right.right = new TreeNode(9);
        TreeNode treeNode = new Solution().invertTree(rootNode);
        logger.info("123");
    }


}
