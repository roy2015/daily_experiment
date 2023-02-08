package com.roy.leetcode.stage2.stage21;

import org.slf4j.LoggerFactory;

/**
 * @author guojun
 * @date 2020/9/30
 *
 *
 * 701. 二叉搜索树中的插入操作
 * 给定二叉搜索树（BST）的根节点和要插入树中的值，将值插入二叉搜索树。 返回插入后二叉搜索树的根节点。 输入数据保证，新值和原始二叉搜索树中的任意节点值都不同。
 *
 * 注意，可能存在多种有效的插入方式，只要树在插入后仍保持为二叉搜索树即可。 你可以返回任意有效的结果。
 *
 *
 *
 * 例如,
 *
 * 给定二叉搜索树:
 *
 *         4
 *        / \
 *       2   7
 *      / \
 *     1   3
 *
 * 和 插入的值: 5
 * 你可以返回这个二叉搜索树:
 *
 *          4
 *        /   \
 *       2     7
 *      / \   /
 *     1   3 5
 * 或者这个树也是有效的:
 *
 *          5
 *        /   \
 *       2     7
 *      / \
 *     1   3
 *          \
 *           4
 *
 *
 * 提示：
 *
 * 给定的树上的节点数介于 0 和 10^4 之间
 * 每个节点都有一个唯一整数值，取值范围从 0 到 10^8
 * -10^8 <= val <= 10^8
 * 新值和原始二叉搜索树中的任意节点值都不同
 *
 */
public class TestSolution701 {
    private static final org.slf4j.Logger logger = LoggerFactory.getLogger(TestSolution701.class);


    static class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;
      TreeNode() {}
      TreeNode(int val) { this.val = val; }
      TreeNode(int val, TreeNode left, TreeNode right) {
          this.val = val;
          this.left = left;
          this.right = right;
      }
  }

    static class Solution {
        public TreeNode insertIntoBST(TreeNode root, int val) {
            if (root == null) {
                return new TreeNode(5);
            }

            TreeNode left = root.left;
            TreeNode right = root.right;

            if (val < root.val) {
                if (left == null) {
                    root.left = new TreeNode(val);
                } else {
                    insertIntoBST(left, val);
                }

            } else{
                if (right == null) {
                    root.right = new TreeNode(val);
                } else {
                    insertIntoBST(right, val);
                }
            }
            return root;
        }
    }

    public static void main(String[] args) {
        TreeNode node4 = new TreeNode(4);
        node4.left = new TreeNode(2);
        node4.right = new TreeNode(7);
        node4.left.left = new TreeNode(1);
        node4.left.right = new TreeNode(3);

        new Solution().insertIntoBST(node4, 5);
        logger.info("{}", new Solution());
    }
}
