package com.guo.roy.research.leetcode.stage1.stage11;

import org.slf4j.LoggerFactory;

/**
 * @author guojun
 * @date 2020/7/30
 *
 * 235. 二叉搜索树的最近公共祖先
 * 给定一个二叉搜索树, 找到该树中两个指定节点的最近公共祖先。
 *
 * 百度百科中最近公共祖先的定义为：“对于有根树 T 的两个结点 p、q，最近公共祖先表示为一个结点 x，满足 x 是 p、q 的祖先且 x 的深度尽可能大（一个节点也可以是它自己的祖先）。”
 *
 * 例如，给定如下二叉搜索树:  root = [6,2,8,0,4,7,9,null,null,3,5]
 *
 *
 *
 *
 *          6
 *       /    \
 *     2       8
 *    / \     / \
 *   0  4    7  9
 *     /  \
 *    3   5
 *
 * 示例 1:
 *
 * 输入: root = [6,2,8,0,4,7,9,null,null,3,5], p = 2, q = 8
 * 输出: 6
 * 解释: 节点 2 和节点 8 的最近公共祖先是 6。
 * 示例 2:
 *
 * 输入: root = [6,2,8,0,4,7,9,null,null,3,5], p = 2, q = 4
 * 输出: 2
 * 解释: 节点 2 和节点 4 的最近公共祖先是 2, 因为根据定义最近公共祖先节点可以为节点本身。
 *
 *
 * 说明:
 *
 * 所有节点的值都是唯一的。
 * p、q 为不同节点且均存在于给定的二叉搜索树中。
 *
 *
 */
public class TestSolution235 {
    private static final org.slf4j.Logger logger = LoggerFactory.getLogger(TestSolution235.class);


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
         * 有意思，充分利用BST的特性，直接root遍历，分道扬镳时即是最近公共祖先，
         * 开始想的还是朴素的解法， 1.分别遍历留下两个路径，路径比对
         * 后来想到这个一起走的算法
         *
         * 执行结果：
         * 通过
         * 显示详情
         * 执行用时：6 ms, 在所有 Java 提交中击败了99.85%的用户
         * 内存消耗：40.5 MB, 在所有 Java 提交中击败了45.24%的用户
         *
         *
         * @param root
         * @param p
         * @param q
         * @return
         */
        public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p,  TreeNode q) {
            if (p.val == q.val) {
                return p;
            }
            return routeOfBstNode(root, p, q);
        }

        private TreeNode routeOfBstNode(TreeNode root, TreeNode p,  TreeNode q) {
            int currVal = root.val;
            int pVal = p.val;
            int qVal = q.val;

            //分道扬镳
            if ( (currVal > pVal) && (currVal < qVal)  ) {
                return root;
            }
            if ( (currVal > qVal) && (currVal < pVal)  ) {
                return root;
            }

            //一起向左向右走
            if (pVal > currVal && (qVal > currVal)) {
                return routeOfBstNode(root.right, p , q);
            }
            if (pVal < currVal && (qVal < currVal)) {
                return routeOfBstNode(root.left, p , q);
            }

            //一个已经到达
            if (pVal == currVal || (qVal == currVal)) {
                return root;
            }
            return null;
        }


    }

    public static void main(String[] args) {


        TreeNode node1 = new TreeNode(6);
        node1.left = new TreeNode(2);
        node1.right = new TreeNode(8);
        node1.left.left = new TreeNode(0);
        node1.left.right = new TreeNode(4);
        node1.right.left = new TreeNode(7);
        node1.right.right = new TreeNode(9);
        node1.left.right.left = new TreeNode(3);
        node1.left.right.right = new TreeNode(5);

        TreeNode node22 = new TreeNode(2);
        TreeNode node88 = new TreeNode(8);
        TreeNode node44 = new TreeNode(4);



        logger.info("{}", new Solution().lowestCommonAncestor(node1, node22, node88).val);//6
        logger.info("{}", new Solution().lowestCommonAncestor(node1, node22, node44).val);//2

    }
}
