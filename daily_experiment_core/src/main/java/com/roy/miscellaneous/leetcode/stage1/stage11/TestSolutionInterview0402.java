package com.roy.miscellaneous.leetcode.stage1.stage11;

import org.slf4j.LoggerFactory;

/**
 * @author guojun
 * @date 2020/9/11
 *
 * 面试题 04.02. 最小高度树
 * 给定一个有序整数数组，元素各不相同且按升序排列，编写一个算法，创建一棵高度最小的二叉搜索树。
 *
 * 示例:
 * 给定有序数组: [-10,-3,0,5,9],
 *
 * 一个可能的答案是：[0,-3,9,-10,null,5]，它可以表示下面这个高度平衡二叉搜索树：
 *
 *           0
 *          / \
 *        -3   9
 *        /   /
 *      -10  5
 *
 */
public class TestSolutionInterview0402 {
    private static final org.slf4j.Logger logger = LoggerFactory.getLogger(TestSolutionInterview0402.class);


    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }

    static class Solution {
        private int length;

        /**
         *
         * 二分+递归 思路没错，但写法比较乱，完全靠debug，总会有考虑不全的地方
         *
         * @param nums
         * @return
         */
        public TreeNode sortedArrayToBST1(int[] nums) {

            int length = nums.length;
            int idxMid = (0+ length -1)/2;
            int midVal = nums[idxMid];
            this.length = length -1;
            TreeNode root = new TreeNode(midVal);
            test(nums, 0, length-1, idxMid, root, true);

            return root;

        }

        /**
         * 参数太多，比较混乱，再加上节点的挂取又在内部而不是返回值
         * @param nums
         * @param low
         * @param high
         * @param current
         * @param parentNode
         * @param from
         */
        public void test(int[] nums, int low, int high, int current, TreeNode parentNode, boolean from   ) {
            //0 4 2
            //二分查找左边 low .. mid-1 mid ..  high
            int mid = (low + current ) /2;
            if (current == low || current == high) {
                return;
            } else {
                if (!from  && (current -1) == low) {

                } else {
                    parentNode.left = new TreeNode(nums[mid]);
                    test(nums, low, current,mid, parentNode.left, true);

                }
            }

            //右边
            mid = (int) (Math.ceil((high + current ) /2.0));
//            parentNode.right = new TreeNode(nums[mid]);
            if (mid == high && this.length != mid) {
                return;
            } else {
                parentNode.right = new TreeNode(nums[mid]);
                test(nums, current , high, mid, parentNode.right, false);
            }
        }


        /**
         *
         * 同上 总结思路，重新整理，现在比较清晰了
         *
         * 执行结果：
         * 通过
         * 显示详情
         * 执行用时：0 ms, 在所有 Java 提交中击败了100.00%的用户
         * 内存消耗：39.4 MB, 在所有 Java 提交中击败了93.34%的用户
         *
         * @param nums
         * @return
         */
        public TreeNode sortedArrayToBST(int[] nums) {
            int len = nums.length;
            //1. 首先排除调1，2，3个元素的情况
            if (len == 0) {
                return null;
            } else if (len == 1) {
                return new TreeNode(nums[0]);
            } else if (len == 2) {
                TreeNode root = new TreeNode(nums[0]);
                root.right = new TreeNode(nums[1]);
                return root;
            } else if (len == 3) {
                TreeNode root = new TreeNode(nums[1]);
                root.left = new TreeNode(nums[0]);
                root.right = new TreeNode(nums[2]);
                return root;
            }

            //2. 正常情况
            int mid = (0 + len-1)/2;
            TreeNode root = new TreeNode(nums[mid]);//拎出root node
            root.left = test1(nums, 0, mid - 1);//左半部
            root.right = test1(nums, mid + 1, len -1);//右半部
            return root;
        }

        public TreeNode test1(int[] nums, int low, int high) {
            //return的逻辑
            if (low == high) {//一个元素
                return new TreeNode(nums[low]);
            } else if (high == low + 1) {//两个元素
                TreeNode node1 = new TreeNode(nums[low]);
                TreeNode node2 = new TreeNode(nums[high]);
                node1.right = node2;
                return node1;
            } else {}

            //3个及以上，可以继续拆
            int mid = (low + high)/2;
            TreeNode node = new TreeNode(nums[mid]);
            node.left = test1(nums, low, mid -1);
            node.right = test1(nums, mid + 1, high);
            return node;
        }


    }

    public static void main(String[] args) {
        logger.info("{}", new Solution().sortedArrayToBST(new int[]{0,1,2,3,4,5}));
    }
}
