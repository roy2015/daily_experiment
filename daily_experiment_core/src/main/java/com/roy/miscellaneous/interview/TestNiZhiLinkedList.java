package com.roy.miscellaneous.interview;

import org.slf4j.LoggerFactory;

/**
 * Created by apple on 2019/8/27.
 *
 * 面试题 链表 A B C D 转换成 逆序 链表  D C B A
 *
 */
public class TestNiZhiLinkedList {
    private static final org.slf4j.Logger logger = LoggerFactory.getLogger(TestNiZhiLinkedList.class);

    static  class Node {
        private String value;
        private Node next;
        private Node head;

        public Node(String value) {
            this.value = value;
        }
    }

    /**
     * 逆序 处理 node.next属性  A -> B -> C -> D -> null   <=>   null <- A <- B <- C <- D
     * @param node
     * @return
     */
    public static  Node resolveNextOfNode(Node node) {
        if (node.next == null) {
            node.head = node;
            return node;
        } else {
            Node nextNode = resolveNextOfNode(node.next);
            nextNode.next = node;
            node.next = null;
            node.head = nextNode.head;
            return node;
        }
    }

    public static  Node niZhiLinkedList(Node head) {
        Node node = resolveNextOfNode(head);
        return node.head;
    }

    public static void print (Node node) {
        while (node != null) {
            logger.info("node: [{}]", node.value);
            node = node.next;
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
        print(nodeA);

        logger.info("逆序后==============================");
        Node node = TestNiZhiLinkedList.niZhiLinkedList(nodeA);
        print(node);

    }

}
