package com.roy.miscellaneous.leetcode.stage2.stage22;

import org.slf4j.LoggerFactory;

import java.util.*;

/**
 *
 * 236. 二叉树的最近公共祖先
 * 给定一个二叉树, 找到该树中两个指定节点的最近公共祖先。
 *
 * 百度百科中最近公共祖先的定义为：“对于有根树 T 的两个结点 p、q，最近公共祖先表示为一个结点 x，满足 x 是 p、q 的祖先且 x 的深度尽可能大（一个节点也可以是它自己的祖先）。”
 *
 * 例如，给定如下二叉树:  root = [3,5,1,6,2,0,8,null,null,7,4]
 *
 *
 *
 *
 *
 * 示例 1:
 *
 * 输入: root = [3,5,1,6,2,0,8,null,null,7,4], p = 5, q = 1
 * 输出: 3
 * 解释: 节点 5 和节点 1 的最近公共祖先是节点 3。
 * 示例 2:
 *
 * 输入: root = [3,5,1,6,2,0,8,null,null,7,4], p = 5, q = 4
 * 输出: 5
 * 解释: 节点 5 和节点 4 的最近公共祖先是节点 5。因为根据定义最近公共祖先节点可以为节点本身。
 *
 *
 * 说明:
 *
 * 所有节点的值都是唯一的。
 * p、q 为不同节点且均存在于给定的二叉树中。
 *
 * @author guojun
 * @date 2020/10/26
 */
public class TestSolution236 {
    private static final org.slf4j.Logger logger = LoggerFactory.getLogger(TestSolution236.class);

    /**
     * Definition for a binary tree node.
     *
     **/
     static class TreeNode {
         int val;
         TreeNode left;
         TreeNode right;
         TreeNode(int x) { val = x; }
     }


    static class Solution {

         private TreeNode retNode;//用于lowestCommonAncestor3

         private  int treeDepth;
         private TreeNodeExt pNode;
         private TreeNodeExt qNode;

        /**
         *
         * 1. 转化为完全二叉树是可以解决的，BFS算出长度，但引出另一个问题，当10000个非空节点的单边树，完全二叉树的数组表示 长度为2^10000,无穷大~~
         * 2. 还是用BFS数组的形式的，考虑其他思路吧
         *
         * @param root
         * @param p
         * @param q
         * @return
         */
        public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
            coverTreeToArray(root);
            TreeNode[] processNodes = coverTreeToFullTreeArray(this.treeDepth - 1, root);

            int pIdx = -1, qIdx = -1;
            for (int i = 0; i < processNodes.length && (qIdx == -1 || pIdx == -1); i++) {
                TreeNode iNode = processNodes[i];
                if (iNode != null) {
                    if (p.val == iNode.val){
                        pIdx = i;
                    }
                    if (q.val == iNode.val){
                        qIdx = i;
                    }
                }
            }

            //记录p到root的路径
            TreeSet<Integer> pPath = new TreeSet<>();
            while (pIdx >= 0) {
                pPath.add(pIdx);
                if ((pIdx & 0x1) == 0) {
                    pIdx = (pIdx -2)/2;
                } else {
                    pIdx = (pIdx -1)/2;
                }
            }

            //q向上找
            while (qIdx >= 0) {
                if (pPath.contains(qIdx)) {
                    return processNodes[qIdx];
                }
                if ((qIdx & 0x1) == 0) {
                    qIdx = (qIdx -2)/2;
                } else {
                    qIdx = (qIdx -1)/2;
                }
            }
            return null;
        }

        public TreeNode[] coverTreeToFullTreeArray (int depth, TreeNode root) {
            int nodeSize = (1 << depth) - 1;
            int endIdx = (1 << (depth - 1)) -1;
            TreeNode[] retNodes = new TreeNode[nodeSize];
            retNodes[0] = root;
            for (int i = 0; i < endIdx; i++) {
                TreeNode iNode = retNodes[i];
                if (iNode != null) {
                    retNodes[2 * i + 1] = iNode.left;
                    retNodes[2 * i + 2] = iNode.right;
                }
            }
            return retNodes;
        }

        /**
         * DFS tree转成数组的形式，为了性能考虑，多余的NULL可以保留
         * @param node
         * @return
         */
        public List<TreeNode> coverTreeToArray(TreeNode node) {
            Queue<TreeNode> queue = new LinkedList<>();
            queue.add(node);
            List<TreeNode> retList = new ArrayList<TreeNode>();

            int currLevelCnt = 1, nextLevelCnt = 0;
            while (!queue.isEmpty()) {
                TreeNode queueFirstNode = queue.poll();
                retList.add(queueFirstNode);
                currLevelCnt --;
                if (queueFirstNode != null) {
                    queue.add(queueFirstNode.left);
                    nextLevelCnt ++;
                    queue.add(queueFirstNode.right);
                    nextLevelCnt ++;
                }
                if (currLevelCnt == 0) {
                    this.treeDepth ++;
                    currLevelCnt = nextLevelCnt;
                    nextLevelCnt = 0;
                }
            }

            //去掉多余的NULL，也可以不去掉
            /*while (true) {
                int size = retList.size();
                if (retList.get(size -1) == null) {
                    retList.remove(size -1);
                } else break;
            }*/

            return retList;
        }

        static class TreeNodeExt extends TreeNode {
            TreeNode target;
            TreeNodeExt parent;
            TreeNodeExt leftExt;
            TreeNodeExt rightExt;

            TreeNodeExt(int x) {
                super(x);
            }

            TreeNodeExt(TreeNode node) {
                super(node.val);
                this.target = node;
                this.left = node.left;
                this.right = node.right;
            }
        }

        /**
         * stack overflow
         * @param root
         * @param p
         * @param q
         * @return
         */
        public TreeNode lowestCommonAncestor2(TreeNode root, TreeNode p, TreeNode q) {
            traverseTree(new TreeNodeExt(root));
            return null;
        }

        /**
         *
         * 扩展TreeNode类TreeNodeExt，加了parent属性，BFS 轮询渲染TreeNodeExt，最后直接向上循环查询出公共节点
         *
         * 采用DFS来做会是另外一片开阔地 {@link #lowestCommonAncestor3}
         *
         * 执行结果：
         * 通过
         * 显示详情
         * 执行用时：16 ms, 在所有 Java 提交中击败了6.33%的用户
         * 内存消耗：39.3 MB, 在所有 Java 提交中击败了99.36%的用户
         *
         * @param root
         * @param p
         * @param q
         * @return
         */
        public TreeNode lowestCommonAncestor1(TreeNode root, TreeNode p, TreeNode q) {
            List<TreeNodeExt> treeNodes = test1(root, p, q);
            TreeNodeExt tmp = this.pNode;
            List<TreeNodeExt> pPathNodes = new ArrayList<>();
            while (tmp != null) {
                pPathNodes.add(tmp);
                tmp = tmp.parent;
            }

            tmp = this.qNode;
            while (! pPathNodes.contains(tmp)) {
                tmp = tmp.parent;
            }


            return tmp;
        }

        private List<TreeNodeExt> test1(TreeNode node, TreeNode p, TreeNode q) {
            Queue<TreeNodeExt> queue = new LinkedList<>();
            queue.add(new TreeNodeExt(node));
            List<TreeNodeExt> retList = new ArrayList<TreeNodeExt>();

            int currLevelCnt = 1, nextLevelCnt = 0;
            while (!queue.isEmpty()) {
                TreeNodeExt queueFirstNode = queue.poll();
                retList.add(queueFirstNode);
                currLevelCnt --;
                if (queueFirstNode != null) {
                    if (queueFirstNode.target == p) {
                        this.pNode = queueFirstNode;
                    }
                    if (queueFirstNode.target == q) {
                        this.qNode = queueFirstNode;
                    }

                    TreeNode leftNode = queueFirstNode.left;
                    TreeNode rightNode = queueFirstNode.right;
                    TreeNodeExt leftExt = null;
                    TreeNodeExt rightExt = null;

                    if (leftNode != null) {
                        leftExt = new TreeNodeExt(leftNode);
                        leftExt.parent = queueFirstNode;
                    }

                    if (rightNode != null) {
                        rightExt = new TreeNodeExt(rightNode);
                        rightExt.parent = queueFirstNode;
                    }

                    queue.add(leftExt);
                    nextLevelCnt ++;
                    queue.add(rightExt);
                    nextLevelCnt ++;
                }
                if (currLevelCnt == 0) {
                    this.treeDepth ++;
                    currLevelCnt = nextLevelCnt;
                    nextLevelCnt = 0;
                }
            }

            //去掉多余的NULL，也可以不去掉
            /*while (true) {
                int size = retList.size();
                if (retList.get(size -1) == null) {
                    retList.remove(size -1);
                } else break;
            }*/

            return retList;
        }

        private void traverseTree(TreeNodeExt node) {
            if (node == null ) {
                return;
            }

            TreeNode leftNode = node.left;
            TreeNode rightNode = node.right;
            TreeNodeExt leftExt = null;
            TreeNodeExt rightExt = null;

            if (leftNode != null) {
                leftExt = new TreeNodeExt(leftNode);
                node.leftExt = leftExt;
                leftExt.parent = node;
            } else {
                node.leftExt = null;
            }
            traverseTree(leftExt);

            if (rightNode != null) {
                rightExt = new TreeNodeExt(rightNode);
                node.rightExt = rightExt;
                rightExt.parent = node;
            } else {
                node.rightExt = null;
            }
            traverseTree(rightExt);
        }


        /**
         *
         * 借鉴了点提示 用 DFS, 代码实现自己写的，就用了几个类变量，时刻检测是否找点pq  ，99，91%
         * pq分居左右子树 返回current node
         * 左右子树里只有p,q里面一个，另一个在current node 返回current node
         *
         * 执行结果：
         * 通过
         * 显示详情
         * 执行用时：
         * 7 ms
         * , 在所有 Java 提交中击败了
         * 99.91%的用户
         * 内存消耗：40.8 MB,
         * 在所有 Java 提交中击败了
         * 78.72%的用户
         *
         * @param root
         * @param p
         * @param q
         * @return
         */
        public TreeNode lowestCommonAncestor3(TreeNode root, TreeNode p, TreeNode q) {

            lowestCommonAncestorSub(root, p, q);
            return this.retNode;
        }

        private int lowestCommonAncestorSub(TreeNode node, TreeNode p, TreeNode q) {
            if (node == null) {
                return 0;
            }

            int retFlag = 0;
            if (node == p) {
                retFlag =1;
            } else if (node == q) {
                retFlag =2;
            } else {}

            int leftRet = lowestCommonAncestorSub(node.left, p, q);
            if (retNode != null) {
                return 0;
            }
            retFlag |= leftRet;
            if (retFlag == 0x3) {
                this.retNode = node;
                return 3;
            }

            int rightRet = lowestCommonAncestorSub(node.right, p, q);
            if (retNode != null) {
                return 0;
            }
            retFlag |= rightRet;
            if (retFlag == 0x3) {
                this.retNode = node;
                return 3;
            }

            return retFlag;
        }



        public static void printArray (List<TreeNode> nodes) {
            StringBuffer sb = new StringBuffer();
            for (TreeNode node : nodes) {
                if (node == null) {
                    sb.append(" null>> ");
                } else sb.append(node.val).append(" >>");

            }
            logger.info("{}", sb.toString());
        }
    }

    public static void main(String[] args) {
        TreeNode head = null;
        TreeNode node ;

        //测试2
        head = new TreeNode(-1);
        head.left = new TreeNode(-2);
        head.left.left = new TreeNode(-3);
        head.left.left.left = new TreeNode(-4);
        head.left.left.left.left = new TreeNode(-5);

        node = new Solution().lowestCommonAncestor3(head, head.left.left.left,  head.left.left.left.left);//-4
        logger.info("{}", node.val);

        //测试1 1000个点的单边树
        head = new TreeNode(-1);
        node = head;
        TreeNode node9998 = null, node9999 = null;
        for (int i = 0; i < 5000; i++) {
            node.left = new TreeNode(i);
            if (i== 4998) node9998 = node.left;
            if (i== 4999) node9999 = node.left;
            node = node.left;
        }
        node = new Solution().lowestCommonAncestor3(head, node9998,  node9999);//9998
        logger.info("{}", node.val);



        //测试3
        head = new TreeNode(3);
        head.left = new TreeNode(5);
        head.right = new TreeNode(1);

        head.left.left = new TreeNode(6);
        head.left.right = new TreeNode(2);

        head.right.left = new TreeNode(0);
        head.right.right = new TreeNode(8);

        head.left.right.left = new TreeNode(7);
        head.left.right.right = new TreeNode(4);

        node = new Solution().lowestCommonAncestor1(head, head.right.right,  head.left.right.left);
        logger.info("{}", node.val);//3
        node = new Solution().lowestCommonAncestor1(head, head,  head);
        logger.info("{}", node.val);//3
        node = new Solution().lowestCommonAncestor1(head, head.left.left,  head.left.right.left);
        logger.info("{}", node.val);//5
        node = new Solution().lowestCommonAncestor1(head, head.left,  head.left.right.right);
        logger.info("{}", node.val);//5
        node = new Solution().lowestCommonAncestor1(head, head.left,  head.right);//3
        logger.info("{}", node.val);


         //测试4
         head = new TreeNode(37);
        head.left = new TreeNode(-34);
        head.right = new TreeNode(-48);

        head.left.right = new TreeNode(-100);

        head.right.left = new TreeNode(-101);
        head.right.right = new TreeNode(48);

        head.right.right.left = new TreeNode(-54);

        head.right.right.left.left = new TreeNode(-71);
        head.right.right.left.right = new TreeNode(-22);

        head.right.right.left.right.right = new TreeNode(8);

        node = new Solution().lowestCommonAncestor1(head, head.right.right.left.left,  head.right.right.left.right.right);//-54
        logger.info("{}", node.val);

//        List<TreeNode> treeNodes = new Solution().coverTreeToArray(head);
//        Solution.printArray(treeNodes);

    }
}
