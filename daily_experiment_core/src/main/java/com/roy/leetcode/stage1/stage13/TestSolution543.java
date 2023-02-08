package com.roy.leetcode.stage1.stage13;

import org.slf4j.LoggerFactory;

/**
 * @author guojun
 * @date 2020/10/21
 */
public class TestSolution543 {
    private static final org.slf4j.Logger logger = LoggerFactory.getLogger(TestSolution543.class);

    static class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;
      TreeNode(int x) { val = x; }
    }

    static class Solution {
        private int diameter;

        /**
         *
         * 没有头绪有点懵逼， 思路陷阱：想两个叶子节点的距离，或是罗列出每个节点的root到此节点的路径，
         *   然后两两叶子节点计算距离，越想越复杂~~
         *
         * 看了官网的思路，理解如下，然后自行编码
         * 一个node的直径为他的左子树和右子树的深度和 记为leftDept + rightdept
         * 树的直径就是 树的所有node直径的最大值，问题最终简化为求节点的左右节点的深度
         *
         *执行结果：
         * 通过
         * 显示详情
         * 执行用时：
         * 13 ms
         * , 在所有 Java 提交中击败了
         * 10.64%
         * 的用户
         * 内存消耗：
         * 38.6 MB
         * , 在所有 Java 提交中击败了
         * 90.24%的用户
         *
         *
         * @param root
         * @return
         */
        public int diameterOfBinaryTree(TreeNode root) {
            if (root == null) return 0;
            //自己node的直径
            int myDiameter;
            myDiameter = getDeepth(root.left);
            myDiameter += getDeepth(root.right);
            if (myDiameter > this.diameter) {
                this.diameter = myDiameter;
            }
            //下沉到left,right
            diameterOfBinaryTree(root.left);
            diameterOfBinaryTree(root.right);
            return this.diameter;
        }

        /**
         * 求树的深度，最长路径经过的节点数目，由于深度的定义差别，需要减一是自行减去~
         * @param root
         * @return
         */
        public int getDeepth(TreeNode root) {
            if (root == null) {
                return 0;
            }
            int leftDeepth = getDeepth(root.left);
            int rightDeepth = getDeepth(root.right);
            return Math.max(leftDeepth, rightDeepth) +1;
        }
    }

    public static void main(String[] args) {
        TreeNode head = null;
        head = new TreeNode(1);
        head.left = new TreeNode(2);
        head.right = new TreeNode(3);
        head.left.left = new TreeNode(4);
        head.left.right = new TreeNode(5);
        head.left.left.left = new TreeNode(9);
        head.left.right.left = new TreeNode(7);
        head.left.right.right = new TreeNode(6);
        head.left.right.left.left = new TreeNode(8);

        logger.info("{}", new Solution().diameterOfBinaryTree(head));
    }
}
