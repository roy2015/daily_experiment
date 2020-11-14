package com.roy.miscellaneous.leetcode.stage2.stage21;

import org.slf4j.LoggerFactory;

/**
 *
 * 654. 最大二叉树
 * 给定一个不含重复元素的整数数组。一个以此数组构建的最大二叉树定义如下：
 *
 * 二叉树的根是数组中的最大元素。
 * 左子树是通过数组中最大值左边部分构造出的最大二叉树。
 * 右子树是通过数组中最大值右边部分构造出的最大二叉树。
 * 通过给定的数组构建最大二叉树，并且输出这个树的根节点。
 *
 *
 *
 * 示例 ：
 *
 * 输入：[3,2,1,6,0,5]
 * 输出：返回下面这棵树的根节点：
 *
 *       6
 *     /   \
 *    3     5
 *     \    /
 *      2  0
 *        \
 *         1
 *
 *
 * 提示：
 *
 * 给定的数组的大小在 [1, 1000] 之间。
 *
 * @author guojun
 * @date 2020/11/14 17:18
 */
public class TestSolution654 {

    private static final org.slf4j.Logger logger = LoggerFactory.getLogger(TestSolution654.class);

    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }

    /**
     *
     * 二叉树没输过~~， 向左向右问题
     *
     * 显示详情
     * 执行用时：2 ms, 在所有 Java 提交中击败了100.00%的用户
     * 内存消耗：38.6 MB, 在所有 Java 提交中击败了89.37%的用户
     *
     */
    static class Solution {
        private int[] nums;
        private TreeNode root;


        public TreeNode constructMaximumBinaryTree(int[] nums) {
            this.nums = nums;
            test(null, 0, nums.length -1, 0);
            return root;
        }

        private void test(TreeNode node, int startIdx, int endIdx, int leftOrRight) {
            if (startIdx > endIdx) {
                return ;
            }

            //step1 找出range内最大的元素
            int maxIdx = startIdx;
            for (int i = startIdx + 1 ; i <= endIdx; i++) {
                if (nums[i] > nums[maxIdx]) {
                    maxIdx = i;
                }
            }
            //挂root
            TreeNode processNode = new TreeNode(nums[maxIdx]);
            if (root == null) {
                root = processNode;
            } else {
                if (leftOrRight == 1) {
                    node.left = processNode;
                } else {
                    node.right = processNode;
                }
            }

            //向左
            test(processNode, startIdx, maxIdx-1, 1);
            //向右
            test(processNode, maxIdx + 1, endIdx, 2);
        }

    }

    public static void main(String[] args) {
        TreeNode treeNode = new Solution().constructMaximumBinaryTree(new int[]{3,2,1,6,0,5});
        logger.info("{}");
    }
}
