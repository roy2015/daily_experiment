package com.roy.leetcode.stage2.stage22;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.LoggerFactory;

/**
 * @author guojun
 * @date 2020/9/16
 *
 * 129. 求根到叶子节点数字之和
 * 给定一个二叉树，它的每个结点都存放一个 0-9 的数字，每条从根到叶子节点的路径都代表一个数字。
 *
 * 例如，从根到叶子节点路径 1->2->3 代表数字 123。
 *
 * 计算从根到叶子节点生成的所有数字之和。
 *
 * 说明: 叶子节点是指没有子节点的节点。
 *
 * 示例 1:
 *
 * 输入: [1,2,3]
 *     1
 *    / \
 *   2   3
 * 输出: 25
 * 解释:
 * 从根到叶子节点路径 1->2 代表数字 12.
 * 从根到叶子节点路径 1->3 代表数字 13.
 * 因此，数字总和 = 12 + 13 = 25.
 * 示例 2:
 *
 * 输入: [4,9,0,5,1]
 *     4
 *    / \
 *   9   0
 *  / \
 * 5   1
 * 输出: 1026
 * 解释:
 * 从根到叶子节点路径 4->9->5 代表数字 495.
 * 从根到叶子节点路径 4->9->1 代表数字 491.
 * 从根到叶子节点路径 4->0 代表数字 40.
 * 因此，数字总和 = 495 + 491 + 40 = 1026.
 *
 *
 */
public class TestSolution129 {
    private static final org.slf4j.Logger logger = LoggerFactory.getLogger(TestSolution129.class);

    static class TreeNode {
         int val;
         TreeNode left;
         TreeNode right;
         TreeNode(int x) { val = x; }
     }

    static class Solution {
        /**
         *
         *
         * 执行结果：
         * 通过
         * 显示详情
         * 执行用时：2 ms, 在所有 Java 提交中击败了16.80%的用户
         * 内存消耗：37.1 MB, 在所有 Java 提交中击败了8.37%的用户
         *
         * @param root
         * @return
         */
        public int sumNumbers(TreeNode root) {
            if (root == null) {
                return 0;
            }
            return test(new ArrayList<>(), root);
        }

        public int test(List<Integer> path, TreeNode node) {
            if (node.left == null && node.right == null) {
                path.add(node.val);
                return calcFromList(path);
            }

            int sum = 0 ;
            List<Integer> copyList;
            path.add(node.val);
            if (node.left != null) {
                //拷贝一个新的list，要不然path会干扰
                copyList = new ArrayList<>();
                copyList.addAll(path);
                sum += test(copyList, node.left);
            }
            if (node.right != null) {
                copyList = new ArrayList<>();
                copyList.addAll(path);
                sum += test(copyList, node.right);
            }
            return sum;
        }

        /**
         *  计算链路上的值 ，比如 9 -》4-》1  = 941
         * @param path
         * @return
         */
        public int calcFromList(List<Integer> path) {
            int size = path.size();
            int sum = 0;;
            for (int i = 0; i < size; i++) {
                Integer currVal = path.get(i);
                sum = sum * 10 + currVal;
            }
            return sum;
        }


    }

    public static void main(String[] args) {
//        logger.info("{}", new Solution().calcFromList(Arrays.asList(9, 4,1)));
        TreeNode node4 = new TreeNode(4);
        node4.left = new TreeNode(9);
        node4.right = new TreeNode(0);
        node4.left.left = new TreeNode(5);
        node4.left.right = new TreeNode(1);
        logger.info("{}", new Solution().sumNumbers(node4));

        TreeNode node1 = new TreeNode(1);
        node1.left = new TreeNode(2);
        node1.right = new TreeNode(3);
        logger.info("{}", new Solution().sumNumbers(node1));
    }
}
