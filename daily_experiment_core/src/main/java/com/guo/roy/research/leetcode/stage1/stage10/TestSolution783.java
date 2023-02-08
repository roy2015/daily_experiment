package com.guo.roy.research.leetcode.stage1.stage10;

import org.slf4j.LoggerFactory;

/**
 * @author guojun
 * @date 2020/8/3
 *
 *
 *783. 二叉搜索树节点最小距离
 * 给定一个二叉搜索树的根节点 root，返回树中任意两节点的差的最小值。
 *
 *
 *
 * 示例：
 *
 * 输入: root = [4,2,6,1,3,null,null]
 * 输出: 1
 * 解释:
 * 注意，root是树节点对象(TreeNode object)，而不是数组。
 *
 * 给定的树 [4,2,6,1,3,null,null] 可表示为下图:
 *
 *           4
 *         /   \
 *       2      6
 *      / \
 *     1   3
 *
 * 最小的差值是 1, 它是节点1和节点2的差值, 也是节点3和节点2的差值。
 *
 *
 * 注意：
 *
 * 二叉树的大小范围在 2 到 100。
 * 二叉树总是有效的，每个节点的值都是整数，且不重复。
 * 本题与 530：https://leetcode-cn.com/problems/minimum-absolute-difference-in-bst/ 相同
 * 通过次数15,451提交次数28,963
 *
 *
 */
public class TestSolution783 {
    private static final org.slf4j.Logger logger = LoggerFactory.getLogger(TestSolution783.class);


    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }

    static class Solution {

        /**
         *
         * 貌似BST没输过，
         *
         * 需要不断试才能完善
         * 关键点是有认知错误"根据BST特性，最小值肯定存在于父子节点，不会是兄弟节点？？"，
         * 其实当前node可能和node.left.right.right.right...right或者
         * node.rihgt.left.left.left...left差值更小， 把这两种情况考虑进去就ok了
         *
         * 执行结果：
         * 通过
         * 显示详情
         * 执行用时：
         * 0 ms, 在所有 Java 提交中击败了100.00%的用户
         * 内存消耗：
         * 37.4 MB, 在所有 Java 提交中击败了40.57%的用户
         *
         *
         * @param root
         * @return
         */
        public int minDiffInBST(TreeNode root) {
            //根据BST特性，最小值肯定存在于父子节点，不会是兄弟节点？？
            return minDiffInBSTSub(root, Integer.MAX_VALUE);
        }

        public int minDiffInBSTSub(TreeNode node, int minGap) {
            TreeNode leftNode = node.left;
            TreeNode rightNode = node.right;

            int nodeVal = node.val;
            if (leftNode != null) {
                //子node
                minGap = Math.min(nodeVal - leftNode.val, minGap);
                //左->右->右->右->右->右->右->右->右...->右
                TreeNode tmpRightNode = leftNode.right;
                while (tmpRightNode != null) {
                    minGap = Math.min(minGap,  nodeVal - tmpRightNode.val);
                    tmpRightNode = tmpRightNode.right;
                }

                if (leftNode.right != null) {
                    minGap = Math.min(minGap,  nodeVal - leftNode.right.val);
                }
                //递归
                minGap = minDiffInBSTSub(leftNode, minGap);
            }

            if (rightNode != null) {
                //子node
                minGap = Math.min(rightNode.val - nodeVal, minGap);
                //右->左->左->左->左->左->左->左->左...->左
                TreeNode tmpLeftNode = rightNode.left;
                while (tmpLeftNode != null) {
                    minGap = Math.min(minGap, tmpLeftNode.val - nodeVal);
                    tmpLeftNode = tmpLeftNode.left;
                }
                minGap = minDiffInBSTSub(rightNode, minGap);
            }
            return minGap;
        }

    }

    public static void main(String[] args) {
        TreeNode node3 = new TreeNode(956);
        node3.left = new TreeNode(267);
        node3.right = new TreeNode(961);
        node3.left.left = new TreeNode(7);
        node3.left.right = new TreeNode(296);
        node3.right.right = new TreeNode(981);
        node3.left.left.right = new TreeNode(138);
        node3.left.right.right = new TreeNode(496);
        node3.left.left.right.right = new TreeNode(263);
        node3.left.right.right.left = new TreeNode(362);
        node3.left.right.right.right = new TreeNode(638);
        logger.info("{}", new Solution().minDiffInBST(node3));//4



        TreeNode node2 = new TreeNode(90);
        node2.left = new TreeNode(69);
        node2.left.left = new TreeNode(49);
        node2.left.right = new TreeNode(89);
        node2.left.left.right = new TreeNode(52);
        logger.info("{}", new Solution().minDiffInBST(node2));//1

        TreeNode node1 = new TreeNode(4);
        node1.left = new TreeNode(2);
        node1.right = new TreeNode(6);
        node1.left.left = new TreeNode(1);
        node1.left.right = new TreeNode(3);
        logger.info("{}", new Solution().minDiffInBST(node1));//1



    }
}
