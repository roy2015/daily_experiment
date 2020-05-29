package com.roy.miscellaneous.leetcode.stage1.stage10;

import org.slf4j.LoggerFactory;

/**
 * Created by apple on 2019/10/15.
 *
 *给定两个二叉树，编写一个函数来检验它们是否相同。

 如果两个树在结构上相同，并且节点具有相同的值，则认为它们是相同的。

 示例 1:

 输入:       1         1
 / \       / \
 2   3     2   3

 [1,2,3],   [1,2,3]

 输出: true
 示例 2:

 输入:      1          1
 /           \
 2             2

 [1,2],     [1,null,2]

 输出: false
 示例 3:

 输入:       1         1
 / \       / \
 2   1     1   2

 [1,2,1],   [1,1,2]

 输出: false

 来源：力扣（LeetCode）
 链接：https://leetcode-cn.com/problems/same-tree
 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 */
public class TestSolution100 {
    private static final org.slf4j.Logger logger = LoggerFactory.getLogger(TestSolution100.class);

    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }

    /**
     * 执行用时 :0 ms, 在所有 java 提交中击败了100.00%的用户
     内存消耗 :34.4 MB, 在所有 java 提交中击败了82.60%的用户
     */
    static class Solution {
        public boolean isSameTree(TreeNode p, TreeNode q) {
            if (p== null && q== null) {
                return true;
            }
            if ( p!= null && q!= null && p.val == q.val) {
                //do noting, just for if
            } else{
                return false;
            }

            boolean k = isSameTree(p.left, q.left) ;
            if (k== false) {
                return false;
            }
            k = isSameTree(p.right, q.right) ;
            if (k== false) {
                return false;
            }
            return true;

        }
    }

    public static void main(String[] args) {
        TreeNode rootNode1 = new TreeNode(1);
        rootNode1.left = new TreeNode(2);
        TreeNode rootNode2 = new TreeNode(1);
        rootNode2.right = new TreeNode(2);
        logger.info("{}", new Solution().isSameTree(rootNode1, rootNode2));
    }

}
