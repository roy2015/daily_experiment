package com.roy.leetcode.stage1.stage12;

import org.slf4j.LoggerFactory;

/**
 * @author guojun
 * @date 2020/7/24
 *
 *
 * 101. 对称二叉树
 * 给定一个二叉树，检查它是否是镜像对称的。
 *
 *
 *
 * 例如，二叉树 [1,2,2,3,4,4,3] 是对称的。
 *
 *     1
 *    / \
 *   2   2
 *  / \ / \
 * 3  4 4  3
 *
 *
 * 但是下面这个 [1,2,2,null,3,null,3] 则不是镜像对称的:
 *
 *     1
 *    / \
 *   2   2
 *    \   \
 *    3    3
 *
 * todo
 *
 *
 */
public class TestSolution101 {
    private static final org.slf4j.Logger logger = LoggerFactory.getLogger(TestSolution101.class);

    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }


    static class Solution {
        public boolean isSymmetric(TreeNode root) {
            return false;


        }
    }

    public static void main(String[] args) {
        logger.info("{}", new Solution());
    }
}
