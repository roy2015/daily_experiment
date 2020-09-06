package com.roy.miscellaneous.leetcode.stage2.stage20;

import jdk.nashorn.internal.ir.CallNode;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;
import java.util.List;

/**
 * @author guojun
 * @date 2020/9/5
 *
 *       面试题 04.06. 后继者 设计一个算法，找出二叉搜索树中指定节点的“下一个”节点（也即中序后继）。
 *
 *       如果指定节点没有对应的“下一个”节点，则返回null。
 *
 *       示例 1:
 *
 *       输入: root = [2,1,3], p = 1
 *
 *       2 / \ 1 3
 *
 *       输出: 2 示例 2:
 *
 *       输入: root = [5,3,6,2,4,null,null,1], p = 6
 *
 *       5 / \ 3 6 / \ 2 4 / 1
 *
 *       输出: null
 *
 */
public class TestSolutionInterview04_06 {
    private static final org.slf4j.Logger logger = LoggerFactory.getLogger(TestSolutionInterview04_06.class);

    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    static class Solution {

        /**
         *
         * 虽然没过，但还是可圈可点，是直接硬刚的写法
         *
         * 第24个testcase没过，无法重现，数据超级多 树可视化都报错看不到Tree的具体形态也就找不到该算法的bug
         *
         * [41,6,8469,0,22,6336,9177,null,3,15,31,5734,6509,8770,9379,2,4,10,20,28,39,1490,5775,6410,6986,8493,8823,9298,9975,
         * 1,null,null,5,8,12,16,21,26,29,34,40,506,4491,5737,6034,6384,6434,6853,8178,8492,8503,8779,9106,9283,9339,9774,9982,
         * null,null,null,null,7,9,11,13,null,17,null,null,23,27,null,30,32,35,null,null,176,837,3317,5715,5735,5743,5944,6310,
         * 6338,6398,6425,6436,6802,6917,7473,8397,8472,null,8494,8711,8776,8782,9009,9153,9210,9289,9336,9371,9400,9953,9980,
         * 9993,null,null,null,null,null,null,null,14,null,18,null,25,null,null,null,null,null,33,null,36,53,316,739,1409,3011,
         * 3924,4845,5730,null,5736,5741,5754,5807,5968,6056,6329,6337,6345,6387,6400,6420,6428,6435,6467,6575,6814,6911,6970,
         * 7111,7761,8283,8461,8470,8473,null,8496,8674,8722,8773,8778,8780,8803,8924,9078,9111,9172,9185,9270,9285,9296,9307,
         * 9337,9369,9376,9391,9633,9933,9967,9979,9981,9989,9994,null,null,null,19,24,null,null,null,null,37,46,140,199,505,
         * 669,814,1281,1430,1976,3096,3627,3934,4646,5455,5719,5733,null,null,5740,5742,... 1031
         *
         * @param root
         * @param p
         * @return
         */
        public TreeNode inorderSuccessor2(TreeNode root, TreeNode p) {
            // root is null
            if (root == null) {
                return null;
            }

            TreeNode retNode = test2(root, p, false);
            if (retNode == p) {
                return null;
            } else
                return retNode;

            /*TreeNode copyLeft = root.left;
            TreeNode copyRight = root.right;
            
            root.right = null;
            TreeNode res = test1(root, p);
            if (res != null ) {
                root.right = copyRight;
                return res;
            }
            
            root.left = null;
            root.right = copyRight;
            
            res = test1(root, p);
            if (res != null && res != root && res != p) {
                return res;
            }
            root.left = copyLeft;
            return null;*/

        }

        private TreeNode test2(TreeNode currNode, TreeNode p, boolean isFind) {
            if (currNode == null) {
                return null;
            }

            if (currNode == p) {
                if (currNode.right != null) {
                    if (currNode.right.left == null) {
                        return currNode.right;
                    } else {
                        return test2(currNode.right.left, p, true);
                    }
                } else {
                    return currNode;
                }
            } else {
                if (isFind) {
                    test2(currNode.left, p, true);
                    return currNode;
                } else {
                    TreeNode leftRes = test2(currNode.left, p, false);
                    if (leftRes != null) {
                        if (leftRes == p) {
                            return currNode;
                        } else {
                            return leftRes;
                        }
                    }

                    TreeNode rightRes = test2(currNode.right, p, false);
                    if (rightRes != null) {
                        if (rightRes == p) {
                            return rightRes;
                        } else {
                            return rightRes;
                        }
                    }
                    return null;
                }
            }

        }

        /**
         *
         * 开始有思路了，防止不可测试性，这个思路没有模糊地带
         *
         * 先遍历再二分查找 1ms之差就是 38%？
         *
         * 执行结果：通过 显示详情 执行用时：4 ms, 在所有 Java 提交中击败了38.57%的用户 内存消耗：41.2 MB, 在所有 Java 提交中击败了5.38%的用户
         *
         *
         * @param root
         * @param p
         * @return
         */
        public TreeNode inorderSuccessor1(TreeNode root, TreeNode p) {
            List<TreeNode> collNodes = new ArrayList<>();
            getList1(root, collNodes);

            int low, high, mid = 0;
            int size = collNodes.size();
            low = 0;
            high = size - 1;

            while (low <= high) {
                mid = (low + high) / 2;
                int val = collNodes.get(mid).val;
                if (p.val > val) {
                    low = mid + 1;
                } else if (p.val < val) {
                    high = mid - 1;
                } else {
                    break;
                }
            }
            if (mid == size - 1) {
                return null;
            } else
                return collNodes.get(mid + 1);
        }

        public void getList1(TreeNode node, List<TreeNode> nodes) {
            if (node == null) {
                return;
            }
            getList1(node.left, nodes);
            nodes.add(node);
            getList1(node.right, nodes);
            return;
        }

        /**
         *
         * 对上面的优化， 减少了二分查找 总算优化成3ms了， 遍历新增的时候直接判断最后一个是不是p, 貌似用不到二查搜索树的特性~~
         *
         * 执行结果： 通过 显示详情 执行用时：3 ms, 在所有 Java 提交中击败了100.00%的用户 内存消耗：41.1 MB, 在所有 Java 提交中击败了5.38%的用户
         *
         * @param root
         * @param p
         * @return
         */
        public TreeNode inorderSuccessor(TreeNode root, TreeNode p) {
            List<TreeNode> collNodes = new ArrayList<>();
            return getList(root, collNodes, p);

        }

        public TreeNode getList(TreeNode node, List<TreeNode> nodes, TreeNode p) {
            if (node == null) {
                return null;
            }
            TreeNode leftRes = getList(node.left, nodes, p);
            if (leftRes != null) {
                return leftRes;
            }

            if (nodes.size() > 0 && nodes.get(nodes.size() - 1) == p) {
                return node;
            } else {
                nodes.add(node);
            }

            TreeNode rightRes = getList(node.right, nodes, p);
            if (rightRes != null) {
                return rightRes;
            } else
                return null;
        }

    }

    public static void main(String[] args) {

        /**
         * 2 1 3
         *
         *
         */
        TreeNode head = new TreeNode(2);
        TreeNode node1 = new TreeNode(1);
        TreeNode node3 = new TreeNode(3);
        head.left = node1;
        head.right = node3;

        TreeNode successor;
        /*successor = new Solution().inorderSuccessor(head, node1);
        logger.info("{}" , successor.val);//2
        successor = new Solution().inorderSuccessor(head, head);
        logger.info("head {}" , successor == null ? -1 : successor.val);//3
        successor = new Solution().inorderSuccessor(head, node3);
        logger.info("{}" , successor == null ? -1 : successor.val);//-1*/

        /**
         * 5 3 6 2 4 7 1 8
         *
         *
         *
         */
        head = new TreeNode(5);
        node3 = new TreeNode(3);
        TreeNode node6 = new TreeNode(6);
        TreeNode node2 = new TreeNode(2);
        TreeNode node4 = new TreeNode(4);
        TreeNode node7 = new TreeNode(7);
        node1 = new TreeNode(1);
        TreeNode node8 = new TreeNode(8);
        head.left = node3;
        head.right = node6;
        head.left.left = node2;
        head.left.right = node4;
        head.left.left.left = node1;
        head.right.right = node7;
        head.right.right.right = node8;
        successor = new Solution().inorderSuccessor(head, head);
        logger.info("head {}", successor == null ? -1 : successor.val);// 6
        successor = new Solution().inorderSuccessor(head, node1);
        logger.info("1 {}", successor == null ? -1 : successor.val);// 2
        successor = new Solution().inorderSuccessor(head, node2);
        logger.info("2 {}", successor == null ? -1 : successor.val);// 3
        successor = new Solution().inorderSuccessor(head, node3);
        logger.info("3 {}", successor == null ? -1 : successor.val);// 4
        successor = new Solution().inorderSuccessor(head, node4);
        logger.info("4 {}", successor == null ? -1 : successor.val);// 5
        successor = new Solution().inorderSuccessor(head, node6);
        logger.info("6 {}", successor == null ? -1 : successor.val);// 6
        successor = new Solution().inorderSuccessor(head, node7);
        logger.info("7 {}", successor == null ? -1 : successor.val);// 7
        successor = new Solution().inorderSuccessor(head, node8);
        logger.info("8 {}", successor == null ? -1 : successor.val);// -1

    }
}
