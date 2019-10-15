package com.roy.miscellaneous.leetcode;

import com.sun.jmx.remote.internal.ArrayQueue;
import org.slf4j.LoggerFactory;

import java.util.ArrayDeque;
import java.util.LinkedList;
import java.util.Queue;
import java.util.concurrent.LinkedBlockingQueue;

/**
 * Created by apple on 2019/9/10.
 * 给定一个二叉树，找出其最大深度。

 二叉树的深度为根节点到最远叶子节点的最长路径上的节点数。

 说明: 叶子节点是指没有子节点的节点。

 示例：
 给定二叉树 [3,9,20,null,null,15,7]，

   3
  /  \
 9   20
     / \
   15  7
        \
         8
 返回它的最大深度 4 。

 来源：力扣（LeetCode）
 链接：https://leetcode-cn.com/problems/maximum-depth-of-binary-tree
 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 *
 */
public class TestSolution104 {
    private static final org.slf4j.Logger logger = LoggerFactory.getLogger(TestSolution104.class);

    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }

    static class Solution {
        /**
         * 深度优先搜索 DFS
         * @param root
         * @return
         */
        public int maxDepth(TreeNode root) {
            if(root == null) {
                return 0;
            }
            return Math.max(root.left == null ? 1: maxDepth(root.left) +1,
                    root.right == null ? 1: maxDepth(root.right) +1);
        }

        /**
         * 广度优先搜索 BFS
         * @param root
         * @return
         */
        public int maxDepth_1(TreeNode root) {
            Queue queue = new LinkedList<Integer>();
            int depth =0, curI =0, nextI=0;
            queue.offer(root);
            curI =1;

            while (queue.peek() != null) {//3  9(3) 20(3)  15(20) 7(20) 8(7)
                TreeNode treeNode = (TreeNode) queue.poll();
                curI --;

                if (treeNode.left != null) {
                    queue.offer(treeNode.left);
                    nextI ++;
                }
                if (treeNode.right != null) {
                    queue.offer(treeNode.right);
                    nextI ++;
                }

                if (curI == 0) {
                    depth++;
                    curI = nextI;
                    nextI =0;
                }
            }


            return depth;
        }

    }

    public static void main(String[] args) {
        TreeNode rootNode = new TreeNode(3);
        rootNode.left = new TreeNode(9);
        rootNode.right = new TreeNode(20);
        rootNode.right.left = new TreeNode(15);
        rootNode.right.right = new TreeNode(7);
        rootNode.right.right.right = new TreeNode(8);
        int i = new Solution().maxDepth_1(rootNode);
        logger.info("{}", i);
    }

}
