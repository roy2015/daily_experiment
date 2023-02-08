package com.roy.leetcode.stage2.stage21;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.LoggerFactory;

/**
 * @author guojun
 * @date 2020/12/04
 *
 * 1382. 将二叉搜索树变平衡
 * 给你一棵二叉搜索树，请你返回一棵 平衡后 的二叉搜索树，新生成的树应该与原来的树有着相同的节点值。
 *
 * 如果一棵二叉搜索树中，每个节点的两棵子树高度差不超过 1 ，我们就称这棵二叉搜索树是 平衡的 。
 *
 * 如果有多种构造方法，请你返回任意一种。
 *
 *
 *
 * 示例：
 *
 *
 *
 * 输入：root = [1,null,2,null,3,null,4,null,null]
 * 输出：[2,1,3,null,null,null,4]
 * 解释：这不是唯一的正确答案，[3,1,4,null,2,null,null] 也是一个可行的构造方案。
 *
 *
 * 提示：
 *
 * 树节点的数目在 1 到 10^4 之间。
 * 树节点的值互不相同，且在 1 到 10^5 之间。
 *
 */
public class TestSolution1382 {
    private static final org.slf4j.Logger logger = LoggerFactory.getLogger(TestSolution1382.class);

    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }

    static class Solution {
        private List<TreeNode> nodeList = new ArrayList<>();

        /**
         * BST(二叉搜索树)没输过， 树的平衡
         * 解决思路 树的数组形式，用二分的思路，拎中间节点出来， 以此为界分成左右区间，中间节点返回，依次递归
         *
         *执行结果：
         * 通过
         * 显示详情
         * 执行用时：3 ms, 在所有 Java 提交中击败了91.23%的用户
         * 内存消耗：40.6 MB, 在所有 Java 提交中击败了96.95%的用户
         *
         */
        public TreeNode balanceBST(TreeNode root) {
            if (root == null) {
                return null;
            }
            covertToArray(root);
            return doBalanceBST(0, nodeList.size() -1);
        }

        private void covertToArray(TreeNode node) {
            if (node == null) {
                return;
            }
            covertToArray(node.left);
            nodeList.add(node);
            covertToArray(node.right);
        }

        /**
         * 传入一个数组，拎中间节点出来， 以此为界分成左右区间，中间节点返回，依次递归
         */
        private TreeNode doBalanceBST(int startIdx, int endIdx) {
            int midIdx = (startIdx + endIdx) / 2;
            int leftStartIdx = startIdx;
            int leftEndIdx = midIdx - 1;
            TreeNode retNode = nodeList.get(midIdx);
            retNode.left = null;
            retNode.right = null;
            if (leftStartIdx <= leftEndIdx) {
                retNode.left = doBalanceBST(leftStartIdx, leftEndIdx);
            }
            int rightStartIdx = midIdx + 1;
            int rightEndIdx = endIdx;

            if (rightStartIdx <= rightEndIdx) {
                retNode.right = doBalanceBST(rightStartIdx, rightEndIdx);
            }
            return retNode;
        }
    }

    public static void main(String[] args) {
        TreeNode root;
        TreeNode procRoot;

        root = new TreeNode(1);
        root.right = new TreeNode(2);
        root.right.right = new TreeNode(3);
        root.right.right.right = new TreeNode(4);

        Solution solution = new Solution();
        procRoot = solution.balanceBST(root);
        logger.info("{}", procRoot);
    }
}
