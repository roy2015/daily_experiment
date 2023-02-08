package com.roy.leetcode.stage2.stage22;

import org.slf4j.LoggerFactory;

/**
 * @author guojun
 * @date 2020/12/24
 *
 *
 * 337. 打家劫舍 III
 * 在上次打劫完一条街道之后和一圈房屋后，小偷又发现了一个新的可行窃的地区。这个地区只有一个入口，我们称之为“根”。 除了“根”之外，每栋房子有且只有一个“父“房子与之相连。一番侦察之后，聪明的小偷意识到“这个地方的所有房屋的排列类似于一棵二叉树”。 如果两个直接相连的房子在同一天晚上被打劫，房屋将自动报警。
 *
 * 计算在不触动警报的情况下，小偷一晚能够盗取的最高金额。
 *
 * 示例 1:
 *
 * 输入: [3,2,3,null,3,null,1]
 *
 *      3()
 *     / \
 *    2   3
 *     \   \
 *      3() 1()
 *
 * 输出: 7
 * 解释: 小偷一晚能够盗取的最高金额 = 3 + 3 + 1 = 7.
 * 示例 2:
 *
 * 输入: [3,4,5,1,3,null,1]
 *
 *      3
 *     / \
 *    4   5
 *   / \   \
 *  1   3   1
 *
 * 输出: 9
 * 解释: 小偷一晚能够盗取的最高金额 = 4 + 5 = 9.
 *
 */
public class TestSolution337 {
    private static final org.slf4j.Logger logger = LoggerFactory.getLogger(TestSolution337.class);


    static  class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }


    static class Solution {
        /**
         *
         *
         *
         * 偷二叉树，相连的节点不能都偷
         *
         * 计算当前节点偷和不偷的子树（包括自己）最大值
         *
         *  1. 当前节点不偷，计算：(左子节点偷时的左子树最大值，左子节点不偷时的左子树最大值,
         *                     右子节点偷时的右子树最大值，右子节点不偷时的右子树最大值 => 交叉四种情况的最大值)
         *  2. 当前节点偷，计算：(左子节不偷时的左子树，右子节点不偷时的右子树， 两者相加)
         *  3. 递归，然后回溯，到root
         *
         * 执行结果：通过
         * 显示详情
         * 执行用时：846 ms, 在所有 Java 提交中击败了22.15%的用户
         * 内存消耗：38.3 MB, 在所有 Java 提交中击败了45.97%的用户
         *
         * @param root
         * @return
         */
        public int rob(TreeNode root) {
            if (root == null) {
                return 0;
            }

            int robMax = subRob(root, true);
            int noRobMax = subRob(root, false);
            return Math.max(robMax, noRobMax);
        }

        /**
         * 当前节点偷或者不偷的子树（含本节点）能偷的最大值
         * @param node
         * @param rob 是否偷当前节点
         * @return
         */
        public int subRob(TreeNode node, boolean rob) {
            TreeNode left = node.left;
            TreeNode right = node.right;

            //不偷，两个子节点共会出现四种情况,压缩成两个即可
            if (!rob) {
                int leftRob =0 ;
                int leftNoRob = 0;
                int rightRob = 0;
                int rightNoRob = 0;
                if (left != null) {
                    leftRob = subRob(left, true);
                    leftNoRob = subRob(left, false);
                }
                if (right != null) {
                    rightRob = subRob(right, true);
                    rightNoRob = subRob(right, false);
                }
                //四种组合的最大值
                int leftMax = Math.max(leftNoRob, leftRob);
                int rightMax = Math.max(rightNoRob, rightRob);
               return leftMax + rightMax;
            }
            //偷，两个子节点共会出现两种情况
            int leftNoRob = 0;
            int rightNoRob = 0;
            if (left != null) {
                leftNoRob = subRob(left, false);
            }
            if (right != null) {
                rightNoRob = subRob(right, false);
            }

            return node.val + leftNoRob + rightNoRob;
        }
    }

    public static void main(String[] args) {
        TreeNode head ;
        head = new TreeNode(3);
        head.left= new TreeNode(2);
        head.right= new TreeNode(3);
        head.left.right= new TreeNode(3);
        head.right.right= new TreeNode(1);
        logger.info("{}", new Solution().rob(head));//7

        head = new TreeNode(3);
        head.left= new TreeNode(4);
        head.right= new TreeNode(5);
        head.left.left= new TreeNode(1);
        head.left.right= new TreeNode(3);
        head.right.right= new TreeNode(1);
        logger.info("{}", new Solution().rob(head));//9

    }
}
