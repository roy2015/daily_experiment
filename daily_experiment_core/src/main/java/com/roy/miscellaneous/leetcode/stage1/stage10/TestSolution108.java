package com.roy.miscellaneous.leetcode.stage1.stage10;

import org.slf4j.LoggerFactory;

/**
 * Created by apple on 2019/11/11.
 *将一个按照升序排列的有序数组，转换为一棵高度平衡二叉搜索树。

 本题中，一个高度平衡二叉树是指一个二叉树每个节点 的左右两个子树的高度差的绝对值不超过 1。

 示例:

 给定有序数组: [-10,-3,0,5,9],

 一个可能的答案是：[0,-3,9,-10,null,5]，它可以表示下面这个高度平衡二叉搜索树：

       0
      / \
    -3   9
   /   /
 -10  5

 来源：力扣（LeetCode）
 链接：https://leetcode-cn.com/problems/convert-sorted-array-to-binary-search-tree
 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 */
public class TestSolution108 {
    private static final org.slf4j.Logger logger = LoggerFactory.getLogger(TestSolution108.class);

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
         * todo: 解答错误，平衡二叉树怎么构建？？
         *
         * @param nums
         * @return
         */
        public TreeNode sortedArrayToBST(int[] nums) {
            if (nums == null || nums.length == 0) {
                return null;
            }

            int length = nums.length;
            int mid = (length -1)/2;
            TreeNode root = new TreeNode(nums[mid]);
            int left = mid -1;
            int right = mid +1;
            boolean rightShift = true;
            while (left >=0 || right < length) {
                if (left >=0 && !rightShift) {
                    insertNode(root, nums[left]);
                    rightShift = true;
                    left --;
                }
                if (right < length && rightShift) {
                    insertNode(root, nums[right]);
                    rightShift = false;
                    right ++;
                }
            }
            return root;
        }

        /**
         * 找插入节点
         * @param node
         * @param val
         * @return
         */
        public void insertNode(TreeNode node, int val) {
            if (val < node.val) {
                if (node.left == null) {
                    node.left = new TreeNode(val);
                    return;
                } else {
                    insertNode(node.left, val);
                }
            } else {
                if (node.right == null) {
                    node.right = new TreeNode(val);
                    return ;
                } else {
                    insertNode(node.right, val);
                }
            }
        }
    }

    public static void main(String[] args) {
        TreeNode treeNode = new Solution().sortedArrayToBST(new int[]{
                1,3
        });
        logger.info("{}");
    }

}
