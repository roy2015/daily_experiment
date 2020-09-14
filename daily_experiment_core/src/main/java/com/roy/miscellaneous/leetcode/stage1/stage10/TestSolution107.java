package com.roy.miscellaneous.leetcode.stage1.stage10;

import com.sun.jmx.remote.internal.ArrayQueue;
import org.slf4j.LoggerFactory;

import java.util.*;

/**
 * @author guojun
 * @date 2020/9/14
 *
 *给定一个二叉树，返回其节点值自底向上的层次遍历。 （即按从叶子节点所在层到根节点所在的层，逐层从左向右遍历）
 *
 * 例如：
 * 给定二叉树 [3,9,20,null,null,15,7],
 *
 *     3
 *    / \
 *   9  20
 *     /  \
 *    15   7
 * 返回其自底向上的层次遍历为：
 *
 * [
 *   [15,7],
 *   [9,20],
 *   [3]
 * ]
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/binary-tree-level-order-traversal-ii
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 */
public class TestSolution107 {
    private static final org.slf4j.Logger logger = LoggerFactory.getLogger(TestSolution107.class);

    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }


    static class Solution {

        /**
         *
         * 广度优先BFS搜索，用到队列，不用递归
         *   简单debug下还是能搞出来的~~
         *
         *
         * 执行结果：
         * 通过
         * 显示详情
         * 执行用时：1 ms, 在所有 Java 提交中击败了98.17%的用户
         * 内存消耗：39.7 MB, 在所有 Java 提交中击败了97.34%的用户
         *
         * @param root
         * @return
         */
        public List<List<Integer>> levelOrderBottom(TreeNode root) {
            if (root == null) {
                return Collections.emptyList();
            }

            ArrayList<List<Integer>> lists = new ArrayList<>();
            Deque<TreeNode> queue = new ArrayDeque<>();
            queue.add(root);//放入root，之后所有操作交给queue
            test(queue, lists);
            //反转
            Collections.reverse(lists);
            return lists;
        }

        public void test(Deque<TreeNode> queue, List<List<Integer>> lists) {
            int curr = 1;
            int next = 0;
            List<Integer> currentList = new ArrayList<>();
            List<Integer> nextList = new ArrayList<>();
            currentList.add(queue.getFirst().val);

            while (!queue.isEmpty()) {
                TreeNode node = queue.poll();
                curr --;
                TreeNode left = node.left;
                TreeNode right = node.right;
                if (left != null) {
                    queue.add(left);
                    nextList.add(left.val);
                    next ++;
                }
                if (right != null) {
                    queue.add(right);
                    nextList.add(right.val);
                    next ++;
                }
                if (curr == 0) {
                    curr = next;
                    next = 0;
                    lists.add(currentList);
                    currentList = nextList;
                    nextList = new ArrayList<>();
                }
            }

        }
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(9);
        root.right = new TreeNode(20);
        root.right.left = new TreeNode(15);
        root.right.right = new TreeNode(7);
        logger.info("{}", new Solution().levelOrderBottom(root));
    }
}
