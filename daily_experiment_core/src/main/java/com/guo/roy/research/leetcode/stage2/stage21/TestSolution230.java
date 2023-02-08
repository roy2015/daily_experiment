package com.guo.roy.research.leetcode.stage2.stage21;

import org.slf4j.LoggerFactory;

/**
 *230. 二叉搜索树中第K小的元素
 * 给定一个二叉搜索树的根节点 root ，和一个整数 k ，请你设计一个算法查找其中第 k 个最小元素（从 1 开始计数）。
 *
 *
 *
 * 示例 1：
 *
 *
 * 输入：root = [3,1,4,null,2], k = 1
 * 输出：1
 * 示例 2：
 *
 *
 * 输入：root = [5,3,6,2,4,null,null,1], k = 3
 * 输出：3
 *
 *
 *
 *
 * 提示：
 *
 * 树中的节点数为 n 。
 * 1 <= k <= n <= 104
 * 0 <= Node.val <= 104
 *
 *
 * 进阶：如果二叉搜索树经常被修改（插入/删除操作）并且你需要频繁地查找第 k 小的值，你将如何优化算法？
 *
 *
 * @author guojun
 * @date 2021/6/11
 */
public class TestSolution230 {
    private static final org.slf4j.Logger logger = LoggerFactory.getLogger(TestSolution230.class);



//    Definition for a binary tree node.
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
        private int k ;
        private int reachK;
        private int result;

        /**
         *
         * 定义几个变量就ok了，充分利用二叉搜索树的特效 左<中<右，递归里面判断代码结束避免傻傻的往下走导致stackoverflow
         *
         * 执行结果：通过
         * 显示详情
         * 添加备注
         *
         * 执行用时：
         * 0 ms, 在所有 Java 提交中击败了100.00%的用户
         * 内存消耗：
         * 38.3 MB, 在所有 Java 提交中击败了53.42%的用户
         *
         * @param root
         * @param k
         * @return
         */
        public int kthSmallest(TreeNode root, int k) {
            this.k = k;
            doKthSmallest(root);
            return this.result;
        }

        /**
         *
         * -1 表示停止递归结束
         * 0  正常递归返回
         *
         *
         * @param node
         * @return
         */
        private int doKthSmallest(TreeNode node) {
            TreeNode left = node.left;
            TreeNode right = node.right;
            if (left == null && right == null) {
                reachK ++;
                if (reachK == k) {
                    result = node.val;
                    return -1;
                } else {
                    return 0;
                }
            }

            int retVal;
            if (left != null) {
                retVal = doKthSmallest(left);
                if (retVal == -1) {
                    return -1;
                }
            }
            reachK ++;
            if (reachK == k) {
                result = node.val;
                return -1;
            } else {
            }

            if (right != null) {
                retVal = doKthSmallest(right);
                if (retVal == -1) {
                    return -1;
                }
            }
            return 0;
        }


    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        TreeNode root;
//            root = new TreeNode(5);
//        root.left = new TreeNode(3);
//        root.right = new TreeNode(6);
//
//        root.left.left = new TreeNode(2);
//        root.left.right = new TreeNode(4);
//
//        root.left.left.left = new TreeNode(1);
//
//        logger.info("{}", solution.kthSmallest(root, 3));//3

        root = new TreeNode(3);
        root.left = new TreeNode(1);
        root.right = new TreeNode(4);

        root.left.right = new TreeNode(2);


        logger.info("{}", solution.kthSmallest(root, 1));//1
    }
}
