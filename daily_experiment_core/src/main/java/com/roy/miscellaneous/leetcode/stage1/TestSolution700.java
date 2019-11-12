package com.roy.miscellaneous.leetcode.stage1;

import org.slf4j.LoggerFactory;

/**
 * Created by apple on 2019/11/11.
 *给定二叉搜索树（BST）的根节点和一个值。 你需要在BST中找到节点值等于给定值的节点。 返回以该节点为根的子树。 如果节点不存在，则返回 NULL。

 例如，

 给定二叉搜索树:

      4
    /  \
   2   7
  / \
 1   3

 和值: 2
 你应该返回如下子树:

   2
  / \
 1   3
 在上述示例中，如果要找的值是 5，但因为没有节点值为 5，我们应该返回 NULL。

 来源：力扣（LeetCode）
 链接：https://leetcode-cn.com/problems/search-in-a-binary-search-tree
 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 */
public class TestSolution700 {
    private static final org.slf4j.Logger logger = LoggerFactory.getLogger(TestSolution700.class);

    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }

    /**
     */
    static class Solution {

        /**
         * 直接递归遍历即可
         *
         * 执行用时 :0 ms, 在所有 java 提交中击败了100.00%的用户
         内存消耗 :37.9 MB, 在所有 java 提交中击败了95.22%的用户
         *
         * @param root
         * @param val
         * @return
         */
        public TreeNode searchBST(TreeNode root, int val) {
            if (root == null) {
                return null;
            }
            if (root.val == val) {
                return root;
            } else if (val < root.val) {
                return searchBST(root.left, val);
            } else {
                return searchBST(root.right, val);
            }
        }
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(4);
        root.left = new TreeNode(2);
        root.right = new TreeNode(7);
        root.left.left = new TreeNode(1);
        root.left.right = new TreeNode(3);
        TreeNode treeNode = new Solution().searchBST(root, 2);
        logger.info("{}");
    }

}
