package com.roy.leetcode.stage1.stage12;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.LoggerFactory;

/**
 * @author guojun
 * @date 2020/9/8
 *
 *       559. N叉树的最大深度 给定一个 N 叉树，找到其最大深度。
 *
 *       最大深度是指从根节点到最远叶子节点的最长路径上的节点总数。
 *
 *       例如，给定一个 3叉树 :
 *
 *
 *
 *
 *
 *
 *
 *       我们应返回其最大深度，3。
 *
 *       说明:
 *
 *       树的深度不会超过 1000。 树的节点总不会超过 5000。
 *
 *
 */
public class TestSolution559 {
    private static final org.slf4j.Logger logger = LoggerFactory.getLogger(TestSolution559.class);

    // Definition for a Node.
    static class Node {
        public int val;
        public List<Node> children;

        public Node() {
        }

        public Node(int _val, List<Node> _children) {
            val = _val;
            children = _children;
        }
    };

    static class Solution {

        /**
         *
         *
         * 不要被多叉树吓到，实际上无非就是写个循环
         *
         * 执行结果：
         * 通过
         * 显示详情
         * 执行用时：0 ms, 在所有 Java 提交中击败了100.00%的用户
         * 内存消耗：40.2 MB, 在所有 Java 提交中击败了19.04%的用户
         *
         * @param root
         * @return
         */
        public int maxDepth(Node root) {
            if (root == null) {
                return 0;
            }

            int maxDepth = 0;
            List<Node> children = root.children;
            if (children == null) {
                return 1;
            }
            for (Node child : children) {
                int tmpDepth = maxDepth(child);
                if (tmpDepth > maxDepth) {
                    maxDepth = tmpDepth;
                }
            }
            return maxDepth +1;
        }
    }

    public static void main(String[] args) {

        Node node5 = new Node(5, null);
        Node node6 = new Node(6, null);
        List<Node> node3Child = new ArrayList<Node>();
        node3Child.add(node5);
        node3Child.add(node6);
        Node node3 = new Node(3, node3Child);
        Node node2 = new Node(2, null);
        Node node4 = new Node(4, null);
        List<Node> node1Child = new ArrayList<Node>();
        node1Child.add(node3);
        node1Child.add(node2);
        node1Child.add(node4);
        Node node1 = new Node(1, node1Child);
        logger.info("{}", new Solution().maxDepth(node1));
    }
}
