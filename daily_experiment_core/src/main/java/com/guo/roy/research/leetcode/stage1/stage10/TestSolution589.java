package com.guo.roy.research.leetcode.stage1.stage10;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Stack;

import org.slf4j.LoggerFactory;

/**
 * Created by apple on 2019/11/8.
 *给定一个 N 叉树，返回其节点值的前序遍历。

 例如，给定一个 3叉树 :

     1
   3   2  4
  5 6


  

 返回其前序遍历: [1,3,5,6,2,4]。

  

 说明: 递归法很简单，你可以使用迭代法完成此题吗?

 来源：力扣（LeetCode）
 链接：https://leetcode-cn.com/problems/n-ary-tree-preorder-traversal
 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 */
public class TestSolution589 {
    private static final org.slf4j.Logger logger = LoggerFactory.getLogger(TestSolution589.class);

    static class Node {
        public int val;
        public List<Node> children;

        public Node() {}

        public Node(int _val,List<Node> _children) {
            val = _val;
            children = _children;
        }
    }



    static class Solution {
        /**
         *
         * 递归法
         * 但题目说不让用递归，递归简单，性能还行，常规是用这个的 ^_^
         *
         * 执行用时 :2 ms, 在所有 java 提交中击败了77.30%的用户
         内存消耗 :46.1 MB, 在所有 java 提交中击败了97.54%的用户
         *
         * @param root
         * @return
         */
        public List<Integer> preorder0(Node root) {
            if (root == null) {
                return Collections.emptyList();
            }

            ArrayList<Integer> list = new ArrayList<>();
            preorder0_sub(root, list);
            return list;
        }

        private void preorder0_sub(Node node, List<Integer> list) {
            if (node == null) {
                return;
            }
            list.add(node.val);
            List<Node> children = node.children;
            if (children != null && !children.isEmpty()) {
                for (Node child : children) {
                    preorder0_sub(child, list);
                }
            }
            return;
        }


        /**
         * 迭代法
         * 用了栈， 把children逆序放入栈,再出栈
         * <p>
         * 执行用时 :5 ms, 在所有 java 提交中击败了34.91%的用户
         * 内存消耗 :45.8 MB, 在所有 java 提交中击败了98.25%的用户
         */
        public List<Integer> preorder(Node root) {
            if (root == null) {
                return Collections.emptyList();
            }

            Stack<Node> stack = new Stack();
            stack.push(root);
            Node tmpNode;
            List<Node> children;
            List<Integer> ret = new ArrayList();
            while (!stack.isEmpty()) {
                tmpNode = stack.pop();
                ret.add(tmpNode.val);
                children = tmpNode.children;
                if (children != null && !children.isEmpty()) {
                    for (int i = children.size() - 1; i >= 0; i--) {
                        stack.push(children.get(i));
                    }
                }
            }
            return ret;

        }
    }

    public static void main(String[] args) {
        Node node5 = new Node(5,null);
        Node node6 = new Node(6,null);
        List<Node> children = new ArrayList<>();
        children.add(node5);
        children.add(node6);
        Node node3 = new Node(3, children);
        Node node2 = new Node(2,null);
        Node node4 = new Node(4,null);

        children = new ArrayList<>();
        children.add(node3);
        children.add(node2);
        children.add(node4);
        Node node1 = new Node(1,children);
        List<Integer> list = new Solution().preorder(node1);
        logger.info("{}");
    }

}
