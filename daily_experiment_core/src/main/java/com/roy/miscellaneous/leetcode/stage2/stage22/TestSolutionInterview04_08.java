package com.roy.miscellaneous.leetcode.stage2.stage22;

import org.slf4j.LoggerFactory;

/**
 * @author guojun
 * @date 2020/9/4
 *
 * 面试题 04.08. 首个共同祖先
 * 设计并实现一个算法，找出二叉树中某两个节点的第一个共同祖先。不得将其他的节点存储在另外的数据结构中。注意：这不一定是二叉搜索树。
 *
 * 例如，给定如下二叉树: root = [3,5,1,6,2,0,8,null,null,7,4]
 *
 *     3
 *    / \
 *   5   1
 *  / \ / \
 * 6  2 0  8
 *   / \
 *  7   4
 * 示例 1:
 *
 * 输入: root = [3,5,1,6,2,0,8,null,null,7,4], p = 5, q = 1
 * 输出: 3
 * 解释: 节点 5 和节点 1 的最近公共祖先是节点 3。
 * 示例 2:
 *
 * 输入: root = [3,5,1,6,2,0,8,null,null,7,4], p = 5, q = 4
 * 输出: 5
 * 解释: 节点 5 和节点 4 的最近公共祖先是节点 5。因为根据定义最近公共祖先节点可以为节点本身。
 * 说明:
 *
 * 所有节点的值都是唯一的。
 * p、q 为不同节点且均存在于给定的二叉树中。
 *
 */
public class TestSolutionInterview04_08 {
    private static final org.slf4j.Logger logger = LoggerFactory.getLogger(TestSolutionInterview04_08.class);


    static class TreeNode {
         int val;
         TreeNode left;
         TreeNode right;
         TreeNode(int x) { val = x; }
     }


    static class Solution {
        /**
         *
         * 思路清晰，完美解决
         *
         * 执行结果：
         * 通过
         * 显示详情
         * 执行用时：7 ms, 在所有 Java 提交中击败了100.00%的用户
         * 内存消耗：41.9 MB, 在所有 Java 提交中击败了75.59%的用户
         *
         *
         * @param root
         * @param p
         * @param q
         * @return
         */
        public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
            if (root.val == p.val || root.val == q.val) {
                return root;
            }

            if (root.left == null) {
                return lowestCommonAncestor(root.right, p, q);
            }
            if (root.right == null) {
                return lowestCommonAncestor(root.left, p, q);
            }

            boolean pLeftRes, qLeftRes, pRightRes, qRightRes;
            pLeftRes =  test1(root.left, p.val);//p在左
            pRightRes =  !pLeftRes;//p在左就不在右边
            qLeftRes =  test1(root.left, q.val);//同理
            qRightRes =  !qLeftRes;

            if (pLeftRes && qLeftRes) {//走left
                return lowestCommonAncestor(root.left, p, q);
            } else if (pRightRes && qRightRes) {//走right
                return lowestCommonAncestor(root.right, p, q);
            } else {//"分道扬镳"
                return root;
            }
        }

        /**
         *
         * 判断 pnode在不在 parentNode下
         * @param parentNode
         * @param val
         * @return
         */
        private boolean test1(TreeNode parentNode, int val) {
            if (parentNode == null) {
                return false;
            } else if (parentNode.val == val) {
                return true;
            } else {
                return test1(parentNode.left, val) || test1(parentNode.right, val);
            }
        }
    }

    public static void main(String[] args) {
        //以下的测试用例写的6可以持续扩展
        TreeNode node3 = new TreeNode(3);
        TreeNode node5 = new TreeNode(5);
        TreeNode node1 = new TreeNode(1);
        TreeNode node6 = new TreeNode(6);
        TreeNode node4 = new TreeNode(4);
        TreeNode node8 = new TreeNode(8);

        TreeNode root = node3;
        root.left = node5;
        root.right = node1;
        root.left.left = node6;
        root.left.right = new TreeNode(2);
        root.right.left = new TreeNode(0);
        root.right.right = new TreeNode(8);
        root.left.right.left = new TreeNode(7);
        root.left.right.right = node4;

        TreeNode node = new Solution().lowestCommonAncestor(root, node6, node4);
        logger.info("{}", node.val);//5
        node = new Solution().lowestCommonAncestor(root, node5, node4);
        logger.info("{}", node.val);//5
        node = new Solution().lowestCommonAncestor(root, node5, node1);
        logger.info("{}", node.val);//3
        node = new Solution().lowestCommonAncestor(root, node3, node8);
        logger.info("{}", node.val);//3

    }
}
