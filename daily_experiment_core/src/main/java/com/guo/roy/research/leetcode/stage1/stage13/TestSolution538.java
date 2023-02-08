package com.guo.roy.research.leetcode.stage1.stage13;

import org.slf4j.LoggerFactory;

/**
 * @author guojun
 * @date 2020/1/21 10:40
 */
public class TestSolution538 {
    private static final org.slf4j.Logger logger = LoggerFactory.getLogger(TestSolution538.class);

    static class TreeNode {
         int val;
         TreeNode left;
         TreeNode right;
         TreeNode(int x) { val = x; }
    }

    static class Solution {
        private int current = 0;

        /**
         *
         * 硬生生的debug出来的, 再去看题解貌似有简单的递归算法，整复杂了，不过锻炼了基本功对tree有更深的理解
         * ，todo 有时间再参考下，先就这样子吧~~
         *
         * 执行结果：
         * 通过
         * 显示详情
         * 执行用时：1 ms, 在所有 Java 提交中击败了97.82%的用户
         * 内存消耗：38.9 MB, 在所有 Java 提交中击败了85.26%的用户
         *
         *
         * @param root
         * @return
         */
        public TreeNode convertBST1(TreeNode root) {
            if (root == null) {
                return null;
            }

            TreeNode left = root.left;
            TreeNode right = root.right;
            int baseVal = root.val;
            if (right != null) {
                int rightVal = test(0, right, 2);
                baseVal += rightVal;
                root.val = baseVal;
            }
            if (left != null) {
                test(baseVal, left, 1);
            }

            return root;
        }


        private int test(int baseVal, TreeNode node, int from) {
            TreeNode left = node.left;
            TreeNode right = node.right;

            if (left == null && right == null) {
                //是左子树 baseVal是父节点的val
                if (from == 1) {
                    node.val = baseVal + node.val;
                } else {//是右子树 baseVal是父节点的baseVal
                    node.val = baseVal + node.val;
                }
                return node.val;
            }

            int retVal = 0;
            //baseVal此时是父节点的baseVal
            if (right  != null) {
                int rightRetVal = test(baseVal, right, 2);
                node.val = rightRetVal + node.val;
                baseVal = node.val;
                retVal = baseVal;
            } else {
                node.val = baseVal + node.val;
                baseVal = node.val;
            }

            if (left  != null) {
                //左子树返回值
                int leftRetVal = test(baseVal, left, 1);
                retVal = leftRetVal;
            }
            return retVal;
        }

        /**
         *
         * 标准的官方解法， 用了类变量
         * 执行用时：
         * 1 ms
         * , 在所有 Java 提交中击败了
         * 98.38%
         * 的用户
         * 内存消耗：
         * 39.3 MB
         * , 在所有 Java 提交中击败了
         * 10.65%
         * 的用户
         *
         * @param root
         * @return
         */
        public TreeNode convertBST(TreeNode root) {
            if (root == null) {
                return null;
            }

            convertBST(root.right);
            root.val = current + root.val;
            current = root.val;
            convertBST(root.left);
            return root;
        }
    }

    public static void main(String[] args) {
        TreeNode root = null;

        /*root = new TreeNode(5);
        root.left = new TreeNode(2);
        root.right = new TreeNode(13);
        root.right.left = new TreeNode(10);*/


        root = new TreeNode(2);
        root.left = new TreeNode(0);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(-4);
        root.left.right = new TreeNode(1);


        /*root = new TreeNode(0);
        root.left = new TreeNode(-1);
        root.right = new TreeNode(2);
        root.left.left = new TreeNode(-3);
        root.right.right = new TreeNode(4);*/

        new Solution().convertBST(root);
        logger.info("{}", new Solution());
    }
}
