package com.roy.miscellaneous.leetcode.stage1;

import org.slf4j.LoggerFactory;

/**
 * Created by apple on 2019/11/4.
 *如果二叉树每个节点都具有相同的值，那么该二叉树就是单值二叉树。

 只有给定的树是单值二叉树时，才返回 true；否则返回 false。

  

 示例 1：



 输入：[1,1,1,1,1,null,1]
 输出：true
 示例 2：



 输入：[2,2,2,5,2]
 输出：false
  

 提示：

 给定树的节点数范围是 [1, 100]。
 每个节点的值都是整数，范围为 [0, 99] 。

 来源：力扣（LeetCode）
 链接：https://leetcode-cn.com/problems/univalued-binary-tree
 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 */
public class TestSolution965 {
    private static final org.slf4j.Logger logger = LoggerFactory.getLogger(TestSolution965.class);

    /**
     * Definition for a binary tree node.
     * */
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
         *
         * 直接递归
         *
         * 执行用时 :0 ms, 在所有 java 提交中击败了100.00%的用户
         内存消耗 :34.5 MB, 在所有 java 提交中击败了79.32%的用户
         *
         * @param root
         * @return
         */
        public boolean isUnivalTree(TreeNode root) {
            if (root == null) {
                return true;
            }

            if (root.left != null) {
                if(root.left.val != root.val ) {
                    return false;
                }
            }

            if (root.right != null) {
                if(root.right.val != root.val ) {
                    return false;
                }
            }

            if (root.left != null) {
                if (!isUnivalTree( root.left)) {
                    return false;
                }
            }

            if (root.right != null) {
                if (!isUnivalTree( root.right)) {
                    return false;
                }
            }

            return true;


        }
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(2);
        root.left = new TreeNode(2);
        root.right = new TreeNode(2);

        root.left.left = new TreeNode(2);
        root.left.right= new TreeNode(2);


        logger.info("{}", new Solution().isUnivalTree(root));
    }

}
