package com.roy.miscellaneous.leetcode.stage3;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.LoggerFactory;

/**
 * @author guojun
 * @date 2021/3/1
 *
 *
 * 1206. 设计跳表
 * 不使用任何库函数，设计一个跳表。
 *
 * 跳表是在 O(log(n)) 时间内完成增加、删除、搜索操作的数据结构。跳表相比于树堆与红黑树，其功能与性能相当，并且跳表的代码长度相较下更短，其设计思想与链表相似。
 *
 * 例如，一个跳表包含 [30, 40, 50, 60, 70, 90]，然后增加 80、45 到跳表中，以下图的方式操作：
 *
 *
 * Artyom Kalinin [CC BY-SA 3.0], via Wikimedia Commons
 *
 * 跳表中有很多层，每一层是一个短的链表。在第一层的作用下，增加、删除和搜索操作的时间复杂度不超过 O(n)。跳表的每一个操作的平均时间复杂度是 O(log(n))，空间复杂度是 O(n)。
 *
 * 在本题中，你的设计应该要包含这些函数：
 *
 * bool search(int target) : 返回target是否存在于跳表中。
 * void add(int num): 插入一个元素到跳表。
 * bool erase(int num): 在跳表中删除一个值，如果 num 不存在，直接返回false. 如果存在多个 num ，删除其中任意一个即可。
 * 了解更多 : https://en.wikipedia.org/wiki/Skip_list
 *
 * 注意，跳表中可能存在多个相同的值，你的代码需要处理这种情况。
 *
 * 样例:
 *
 * Skiplist skiplist = new Skiplist();
 *
 * skiplist.add(1);
 * skiplist.add(2);
 * skiplist.add(3);
 * skiplist.search(0);   // 返回 false
 * skiplist.add(4);
 * skiplist.search(1);   // 返回 true
 * skiplist.erase(0);    // 返回 false，0 不在跳表中
 * skiplist.erase(1);    // 返回 true
 * skiplist.search(1);   // 返回 false，1 已被擦除
 * 约束条件:
 *
 * 0 <= num, target <= 20000
 * 最多调用 50000 次 search, add, 以及 erase操作。
 *
 *
 */
public class TestSolution1206 {
    private static final org.slf4j.Logger logger = LoggerFactory.getLogger(TestSolution1206.class);


    static class ListNode {
        Integer val;
        ListNode down;//向下的指针
        ListNode right;//向右的指针

        ListNode() {}
        ListNode(Integer x) { val = x; }
    }

    /**
     *
     * 执行结果：
     * 通过
     * 显示详情
     * 执行用时：688 ms, 在所有 Java 提交中击败了6.11%的用户
     * 内存消耗：46.6 MB, 在所有 Java 提交中击败了18.21%的用户
     *
     *
     */
    static class Skiplist {
        /**
         * 头的最上层节点
         */
        ListNode headersTopNode;
        /**
         * head的所有节点 从上往下
         */
        List<ListNode> headList = new ArrayList<>();
        /**
         * 层数
         */
        int level;

        public Skiplist() {
            headersTopNode = new ListNode();
//            headList.add(headersTopNode);
            this.level = 1;
        }

        public void add(int num) {
            //没有元素
            if (headersTopNode.right == null) {
                ListNode procHeadNode ;
                int tollLevel = tossCoin(num);
                int buildLevel = 1;

                //下到header的最下面节点
                procHeadNode = headersTopNode;
                while (procHeadNode.down != null) {
                    procHeadNode = procHeadNode.down;
                }

                ListNode newAddNodeDownNode = null, procHeadNodeDownNode = null;
                ListNode newAddNode = new ListNode(num);
                procHeadNode.right = newAddNode;
                newAddNode.right = null;
                newAddNode.down = newAddNodeDownNode;
                newAddNodeDownNode = newAddNode;
                procHeadNodeDownNode = procHeadNode;

                while (buildLevel < tollLevel) {
                    newAddNode = new ListNode(num);
                    newAddNode.down = newAddNodeDownNode;
                    //right不管都是null
                    procHeadNode = new ListNode();
                    headersTopNode = procHeadNode;
                    procHeadNode.down = procHeadNodeDownNode;
                    newAddNode.right = null;
                    procHeadNode.right = newAddNode;
                    procHeadNodeDownNode = procHeadNode;
                    buildLevel ++;
                    this.level++;
                }

                headList = buildNodeListChain(headersTopNode);
                return;
            }

//            boolean exist = search(num);
//            if (exist) {
//                return;
//            }

            //处理新增
            int tollLevel = tossCoin(num);
            ListNode toContinueHeadNode = null , toContinueAddNode = null;
            ListNode commonHeadNode = headersTopNode;
            //新层创建,从上往下
            if (tollLevel > this.level) {
                int toAddLevel = tollLevel - level -1 ;
                ListNode headUpNode, newHeadNode, addNodeUpNode , addNode;

                //最高层
                newHeadNode = new ListNode();
                headUpNode = newHeadNode;
                addNode = new ListNode(num);
                addNodeUpNode = addNode;
                newHeadNode.right = addNode;
                headersTopNode = newHeadNode;

                for (int i = 0; i < toAddLevel; i++) {
                    newHeadNode = new ListNode();
                    headUpNode.down = newHeadNode;
                    addNode = new ListNode(num);
                    addNodeUpNode.down = addNode;
                    newHeadNode.right = addNode;
                    headUpNode = newHeadNode;
                    addNodeUpNode = addNode;
                }

                toContinueHeadNode = headUpNode;
                toContinueAddNode = addNodeUpNode;
            } else {
                //共用层新增节点
                commonHeadNode = headList.get(level - tollLevel);
            }
            //处理共用层
            List<ListNode> commonLevelHeadNodeList = buildNodeListChain(commonHeadNode);
            List<ListNode> commonLevelAddNodeList = buildNodeListChain(level, num);
            for (int i = 0; i < commonLevelHeadNodeList.size(); i++) {
                ListNode preNode = commonLevelHeadNodeList.get(i), currentNode = preNode.right;
                while (currentNode != null && num > currentNode.val ) {
                    preNode = currentNode;
                    currentNode = currentNode.right;
                }
                ListNode addNode = commonLevelAddNodeList.get(i);
                addNode.right = currentNode;
                preNode.right = addNode;
            }

            //超出层的处理
            if (toContinueHeadNode != null) {
                toContinueHeadNode.down = commonLevelHeadNodeList.get(0);
                toContinueAddNode.down = commonLevelAddNodeList.get(0);
                level = tollLevel;
            }
            headList = buildNodeListChain(headersTopNode);
        }

        public List<ListNode> buildNodeListChain(ListNode node) {
            ListNode procNode = node;
            List<ListNode> retList = new ArrayList<>();
            while(procNode != null) {
                retList.add(procNode);
                procNode = procNode.down;
            }
            return retList;
        }

        public List<ListNode> buildNodeListChain(int level, int val) {
            ListNode upNode = null;
            List<ListNode> retList = new ArrayList<>();
            for (int i = 0; i < level; i++) {
                ListNode addNode = new ListNode(val);
                if (upNode != null) {
                    upNode.down = addNode;
                }
                upNode = addNode;
                retList.add(addNode);
            }
            return retList;
        }

        public boolean search(int target) {
            ListNode currentNode = headersTopNode;
            //头结点的right为空说明无节点，排除出这种情况，简化后面的逻辑
            if (currentNode.right == null) {
                return false;
            }

            while (true ) {
                //循环跳出的依据，都是down到底造成的null
                if (currentNode == null) {
                    return false;
                }
                //右节点/下节点
                ListNode rightNode = currentNode.right;
                ListNode downNode = currentNode.down;

                //currentNode 在head时的情况
                if (currentNode.val == null) {
                    if (target == rightNode.val) {
                        return true;
                    } else if (target < rightNode.val) {
                        currentNode = downNode;
                    } else {
                        currentNode = rightNode;
                    }
                    continue;
                }
                //currentNode 不在head时的情况
//                if (target == currentNode.val) {
//                    return true;
//                }

                //right node
                if (rightNode == null) {
                    currentNode = downNode;
                } else if (target == rightNode.val) {
                    return true;
                } else if (target > rightNode.val) {
                    currentNode = rightNode;
                } else {
                    currentNode = downNode;
                }
            }
        }

        public boolean erase(int num) {
            boolean exist = search(num);
            if (!exist) {
                return false;
            }

            List<ListNode> headList = buildNodeListChain(headersTopNode);
            for (int i = 0; i < headList.size(); i++) {
                ListNode preNode = headList.get(i), currentNode = preNode.right;
                while (currentNode != null && num != currentNode.val ) {
                    preNode = currentNode;
                    currentNode = currentNode.right;
                }
                if (currentNode != null) {
                    preNode.right = currentNode.right;
                }
            }

            while (headersTopNode.right == null && level > 1) {
                headersTopNode = headersTopNode.down;
                level --;
                headList.remove(0);
            }
            this.headList = headList;
            return true;
        }

        /**
         * 猜硬币, 返回直到硬币为反面需要投掷的次数， 作为随机层数
         * @return
         */
        public int tossCoin(int num) {
//            Random random = new Random();
//            int level = 1;
//            while (! random.nextBoolean()) {
//                level ++;
//            }

            int level = 0;
            switch (num) {
                case 1:
                    level = 2;
                    break;
                case 2:
                    level = 3;
                    break;
                case 3:
                    level = 1;
                    break;
                case 4:
                    level = 2;
                    break;
                case 5:
                    level = 1;
                    break;
                case 6:
                    level = 1;
                    break;
                case 9:
                    level = 1;
                    break;
                default:
                    level = 1;
                    break;
            }

//            logger.info("num {}, 随机值 {}", num, level);
            return level;


        }
    }



    public static void main(String[] args) {
        Skiplist skiplist = new Skiplist();
//          test1
//        logger.info("{}", skiplist.search(2));
//        skiplist.add(2);
//        logger.info("{}", skiplist.search(2));
//        logger.info("{}", skiplist.erase(3));

//        ListNode head = new ListNode(2);
//        head.down = new ListNode(3);
//        head.down.down = new ListNode(4);
//        List<ListNode> listNodes = skiplist.buildNodeListChain(head);
//        logger.info("{}");

//        //test2
//        skiplist.add(1);
//        skiplist.add(2);
//        skiplist.add(3);
////        logger.info("{}", skiplist.search(0));   // 返回 false
//        skiplist.add(4);
//        logger.info("{}", skiplist.search(1));   // 返回 true
//        logger.info("{}", skiplist.erase(0));    // 返回 false，0 不在跳表中
//        logger.info("{}", skiplist.erase(1));    // 返回 true
//        logger.info("{}", skiplist.search(1));   // 返回 false，1 已被擦除
//        skiplist.erase(4);
//        logger.info("");

        //test3
        skiplist.add(9);//9], [4],   [5],[ 6],   [9],
        skiplist.add(4);
        skiplist.add(5);
        skiplist.add(6);
        skiplist.add(9);
        logger.info("{}", skiplist.erase(2));//false
        logger.info("{}", skiplist.erase(1));//false
        skiplist.add(2);
        logger.info("{}", skiplist.search(7));//false
        logger.info("{}", skiplist.search(4));//true
        skiplist.add(5);
        logger.info("{}", skiplist.erase(6));//true






    }
}
