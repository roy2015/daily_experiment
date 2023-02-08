package com.roy.leetcode.stage1.stage10;

import org.slf4j.LoggerFactory;

import java.util.ArrayList;
import java.util.List;

/**
 * @author guojun
 * @date 2021/3/25
 *
 * 872. 叶子相似的树
 * 请考虑一棵二叉树上所有的叶子，这些叶子的值按从左到右的顺序排列形成一个 叶值序列 。
 *
 *
 *
 * 举个例子，如上图所示，给定一棵叶值序列为 (6, 7, 4, 9, 8) 的树。
 *
 * 如果有两棵二叉树的叶值序列是相同，那么我们就认为它们是 叶相似 的。
 *
 * 如果给定的两个头结点分别为 root1 和 root2 的树是叶相似的，则返回 true；否则返回 false 。
 *
 *
 *
 * 示例 1：
 *
 *
 *
 * 输入：root1 = [3,5,1,6,2,9,8,null,null,7,4], root2 = [3,5,1,6,7,4,2,null,null,null,null,null,null,9,8]
 * 输出：true
 * 示例 2：
 *
 * 输入：root1 = [1], root2 = [1]
 * 输出：true
 * 示例 3：
 *
 * 输入：root1 = [1], root2 = [2]
 * 输出：false
 * 示例 4：
 *
 * 输入：root1 = [1,2], root2 = [2,2]
 * 输出：true
 * 示例 5：
 *
 *
 *
 * 输入：root1 = [1,2,3], root2 = [1,3,2]
 * 输出：false
 *
 *
 * 提示：
 *
 * 给定的两棵树可能会有 1 到 200 个结点。
 * 给定的两棵树上的值介于 0 到 200 之间。
 */
public class TestSolution872 {
    private static final org.slf4j.Logger logger = LoggerFactory.getLogger(TestSolution872.class);

    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }

    static class Solution {

        /**
         *
         * 执行结果：通过
         * 显示详情
         * 执行用时：0 ms, 在所有 Java 提交中击败了100.00%的用户
         * 内存消耗：36.2 MB, 在所有 Java 提交中击败了49.14%的用户
         *
         * @param root1
         * @param root2
         * @return
         */
        public boolean leafSimilar(TreeNode root1, TreeNode root2) {
            List<Integer> leafList1 = new ArrayList<>();
            List<Integer> leafList2 = new ArrayList<>();
            findLeaf(root1, leafList1);
            findLeaf(root2, leafList2);

            if (leafList1.size() != leafList2.size()) {
                return false;
            }

            int size = leafList1.size();
            for (int i = 0; i < size; i++) {
                if (!leafList1.get(i).equals(leafList2.get(i))) {
                    return false;
                }
            }

            return true;
        }

        /**
         * 找叶子
         * @param node
         * @param leafList
         */
        public void findLeaf(TreeNode node, List<Integer> leafList) {
            if (node.left == null && node.right == null) {
                leafList.add(node.val);
                return;
            }

            if (node.left != null) {
                findLeaf(node.left, leafList);
            }

            if (node.right != null) {
                findLeaf(node.right, leafList);
            }
        }

    }

    public static void main(String[] args) {
        TreeNode root1, root2;

//        root1 = new TreeNode(1);
//        root1.left = new TreeNode(2);
//        root1.right = new TreeNode(3);
//
//        root2 = new TreeNode(1);
//        root2.left = new TreeNode(3);
//        root2.right = new TreeNode(2);

        root1 = new TreeNode(3);
        root1.left = new TreeNode(5);
        root1.right = new TreeNode(1);
        root1.left.left = new TreeNode(6);
        root1.left.right = new TreeNode(2);
        root1.left.right.left = new TreeNode(7);
        root1.left.right.right = new TreeNode(4);
        root1.right.left = new TreeNode(9);
        root1.right.right = new TreeNode(8);

        root2 = new TreeNode(3);
        root2.left = new TreeNode(5);
        root2.right = new TreeNode(1);
        root2.left.left = new TreeNode(6);
        root2.left.right = new TreeNode(7);
        root2.right.left = new TreeNode(4);
        root2.right.right = new TreeNode(2);
        root2.right.right.left = new TreeNode(9);
        root2.right.right.right = new TreeNode(8);


        logger.info("{}", new Solution().leafSimilar(root1, root2));
    }
}
