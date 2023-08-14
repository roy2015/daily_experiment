package com.guo.roy.research.leetcode.stage1.stage10;


import org.slf4j.LoggerFactory;

/**
 * Created by apple on 2019/8/28.
 *
 * a b c d null     d c b a null
 * 面试题 链表 A B C D 转换成 逆序 链表  D C B A
 *
 * 反转一个单链表。链表逆序输出

 示例:

 输入: 1->2->3->4->5->NULL
 输出: 5->4->3->2->1->NULL
 进阶:
 你可以迭代或递归地反转链表。你能否用两种方法解决这道题

 来源：力扣（LeetCode）
 链接：https://leetcode-cn.com/problems/reverse-linked-list
 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class TestSolution206 {
    private static final org.slf4j.Logger logger = LoggerFactory.getLogger(TestSolution206.class);
    static  class Node {
        private String value;
        private Node next;

        public Node(String value) {
            this.value = value;
        }
    }

    static class Solution {
        /**
         * 执行用时 :0 ms, 在所有 java 提交中击败了100.00%的用户
         内存消耗 :36.9 MB, 在所有 java 提交中击败了49.97%的用户
         * @param head
         * @return
         */
        public Node reverseList(Node head) {
            if (head == null || head.next == null ) {
                return head;
            }

            Node pre = null, cur = head;
            while (cur != null) {
                Node temp = cur.next;
                cur.next = pre;
                pre = cur;
                cur = temp;
            }

            return pre;
        }

        /**
         * 练习  2021/03/08
         * @param head
         * @return
         */
        public Node reverseList1(Node head) {
            Node current = head;
            Node pre = null;
            Node temp;

            while(current != null) {
                temp = current.next;
                current.next = pre;
                pre = current;
                current = temp;
            }
            return pre;

        }

        public static void print (Node node) {
            while (node != null) {
                logger.info("node: [{}]", node.value);
                node = node.next;
            }
        }
    }

    static class Solution1 {
        /**
         *  关键点：保存b的next，易错点！！！
         * @param head
         * @return
         */
        public Node reverseList(Node head) {
            Node nodeA, nodeB, tmp;
            // null 'A', 就不用考虑空链表
            nodeA = null;
            nodeB = head;

            while (nodeB != null) {
                //保存b的next
                tmp = nodeB.next;
                nodeB.next= nodeA;
                nodeA = nodeB;
                nodeB = tmp;
            }
            return nodeA;
        }

        public static void print (Node node) {
            while (node != null) {
                logger.info("node: [{}]", node.value);
                node = node.next;
            }
        }
    }



    public static void main(String[] args) {
        Node nodeA = new Node("A");
        Node nodeB = new Node("b");
        Node nodeC = new Node("c");
        Node nodeD = new Node("d");

        nodeD.next = null;
        nodeC.next = nodeD;
        nodeB.next = nodeC;
        nodeA.next = nodeB;

        logger.info("逆序前==============================");
        new Solution1().print(nodeA);

        logger.info("逆序后==============================");
        Node node = new Solution1().reverseList (nodeA);
        new Solution().print(node);

    }


}
