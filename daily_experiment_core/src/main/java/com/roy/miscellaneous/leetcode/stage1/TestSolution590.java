package com.roy.miscellaneous.leetcode.stage1;

import org.slf4j.LoggerFactory;

import java.util.*;

/**
 * Created by apple on 2019/11/14.
 *给定一个 N 叉树，返回其节点值的后序遍历。

 例如，给定一个 3叉树 :

                   1
            3      2     4
         5   6
            8

 返回其后序遍历: [5,8,6,3,2,4,1].

  

 说明: 递归法很简单，你可以使用迭代法完成此题吗?

 来源：力扣（LeetCode）
 链接：https://leetcode-cn.com/problems/n-ary-tree-postorder-traversal
 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 */
public class TestSolution590 {
    private static final org.slf4j.Logger logger = LoggerFactory.getLogger(TestSolution590.class);


    // Definition for a Node.
    static class Node {
        public int val;
        public List<Node> children;

        public Node() {}

        public Node(int _val,List<Node> _children) {
            val = _val;
            children = _children;
        }
    };

    /**
     */
    static class Solution {

        /**
         *
         * 性能可以的，不让用？非要说简单尝试用迭代？？
         *
         * 递归法：
         *
         * 执行用时 :1 ms, 在所有 java 提交中击败了100.00%的用户
         内存消耗 :47.1 MB, 在所有 java 提交中击败了96.62%的用户
         *
         * @param root
         * @return
         */
        public List<Integer> postorder(Node root) {
            if (root == null) {
                return Collections.emptyList();
            }

            List<Integer> list = new ArrayList<>();
            postorderSub(root, list);
            return list;
        }

        private void postorderSub(Node node, List<Integer> list) {
            if (node == null) {
                return;
            }
            List<Node> children = node.children;
            if (children != null && !children.isEmpty()) {
                for (Node child : children) {
                    postorderSub(child, list);
                }
            }
            list.add(node.val);
        }

        /**
         * 迭代法
         *
         * 执行用时 :7 ms, 在所有 java 提交中击败了27.92%的用户
         内存消耗 :47.7 MB, 在所有 java 提交中击败了94.73%的用户
         * @param root
         * @return
         */
        public List<Integer> postorder1(Node root) {
            if (root == null) {
                return Collections.emptyList();
            }
            ArrayList<Integer> retList = new ArrayList<>();
            Stack<Node> valueStack = new Stack<>();
            valueStack.push(root);
            Node prePopNode = null;
            while (!valueStack.isEmpty()) {
                Node topNode = valueStack.peek();
                List<Node> children = topNode.children;
                if (children == null || children.isEmpty()) {
                    valueStack.pop();
                    prePopNode = topNode;
                    retList.add(topNode.val);
                } else {
                    if (prePopNode == null) {
                        for (int i = children.size() - 1; i >= 0; i--) {
                            valueStack.push(children.get(i));
                        }
                    } else {
                        //如果最后一个子节点出栈了，当前节点也应该出栈而不是在加节点
                        if (children.get(children.size() -1 ) == prePopNode)  {
                            valueStack.pop();
                            prePopNode = topNode;
                            retList.add(topNode.val);
                        } else {
                            for (int i = children.size() - 1; i >= 0; i--) {
                                valueStack.push(children.get(i));
                            }
                        }
                    }
                }
            }
            return retList;
        }

    }

    public static void main(String[] args) {
        Node node8 = new Node(8, null);
        List<Node> node6List = new ArrayList<>();
        node6List.add(node8);

        Node node5 = new Node(5, null);
        Node node6 = new Node(6, node6List);
        List<Node> node3List = new ArrayList<>();
        node3List.add(node5);
        node3List.add(node6);
        Node node2 = new Node(2, null);
        Node node4 = new Node(4, null);

        Node node3 = new Node(3, node3List);
        List<Node> node1List = new ArrayList<>();
        node1List.add(node3);
        node1List.add(node2);
        node1List.add(node4);
        Node node1 = new Node(1, node1List);
        List<Integer> integerList = new Solution().postorder1(node1);

        logger.info("{}");
    }

}
