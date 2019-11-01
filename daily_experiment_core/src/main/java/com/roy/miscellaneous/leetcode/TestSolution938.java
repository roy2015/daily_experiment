package com.roy.miscellaneous.leetcode;

import org.slf4j.LoggerFactory;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by apple on 2019/11/1.
 *给定二叉搜索树的根结点 root，返回 L 和 R（含）之间的所有结点的值的和。

 二叉搜索树保证具有唯一的值。

  

 示例 1：

 输入：root = [10,5,15,3,7,null,18], L = 7, R = 15
 输出：32
 示例 2：

 输入：root = [10,5,15,3,7,13,18,1,null,6], L = 6, R = 10
 输出：23
  

 提示：

 树中的结点数量最多为 10000 个。
 最终的答案保证小于 2^31。

 来源：力扣（LeetCode）
 链接：https://leetcode-cn.com/problems/range-sum-of-bst
 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 */
public class TestSolution938 {
    private static final org.slf4j.Logger logger = LoggerFactory.getLogger(TestSolution938.class);

//    Definition for a binary tree node.
    static public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }

    static class Solution {

        /**
         * 首先遍历BST到数组，再直接查找sum,思路比较清晰
         *
         * 执行用时 :13 ms, 在所有 java 提交中击败了8.66%的用户
         内存消耗 :41.3 MB, 在所有 java 提交中击败了99.59%的用户
         * @param root
         * @param L
         * @param R
         * @return
         */
        public int rangeSumBST(TreeNode root, int L, int R) {
            ArrayList<Integer> list = new ArrayList<>();
            rangeSumBST_Sub(root, list);
            int sum =0;
            boolean flag = false;
            for (Integer i : list) {
                if (i == L) {
                    flag = true;
                }
                if (flag) {
                    sum += i;
                }
                if (i == R) {
                    return sum;
                }

            }
            return 0;
        }

        //遍历BST
        private void rangeSumBST_Sub(TreeNode root, List<Integer> list) {
            if (root == null) {
                return;
            }
            rangeSumBST_Sub(root.left, list);
            list.add(root.val);
            rangeSumBST_Sub(root.right, list);
        }

        /**
         * 方案二
         *思路：
         * 1 .找共同祖先
         * 2. 汇总： 左子树 + 本身 + 右子树
         * 注意： 防止漏节点
         *
         * 执行用时 :1 ms, 在所有 java 提交中击败了96.53%的用户
         内存消耗 :43.7 MB, 在所有 java 提交中击败了92.68%的用户

         * @param root
         * @param L
         * @param R
         * @return
         */
        public int rangeSumBST1(TreeNode root, int L, int R) {
            if (L == R) {
                return L + R;
            }

            //找共同的根
            TreeNode ancestor = findAncestorNode(root, L, R);
            int leftTree ;
            int rightTree;
            if (L == ancestor.val) {
                leftTree = 0;
            } else {
                leftTree = processLeftTree(ancestor, L, ancestor.val);
                leftTree = leftTree - ancestor.val;
            }

            if (R == ancestor.val) {
                rightTree = 0;
            } else {
                rightTree = processRightTree(ancestor, R, ancestor.val);
                rightTree = rightTree - ancestor.val;
            }


            return leftTree + rightTree + ancestor.val;
        }

        /**
         * 左子树
         * @param node
         * @param L
         * @param mid 祖先
         * @return
         */
        private int processLeftTree(TreeNode node, int L, int mid) {
            if (L > node.val) {
                return processLeftTree(node.right, L, mid);
            } else if (L < node.val) {
                if (node.val != mid) {
                    return node.val + sumAllSubTree(node.right) + processLeftTree(node.left, L, mid);
                } else {
                    return node.val + processLeftTree(node.left, L, mid);
                }
            } else {
                return node.val + sumAllSubTree(node.right);
            }
        }

        /**
         * 右子树
         * @param node
         * @param R
         * @param mid  祖先
         * @return
         */
        private int processRightTree(TreeNode node, int R, int mid) {
            if (R > node.val) {
                if (node.val != mid) {
                    return node.val + sumAllSubTree(node.left) + processRightTree(node.right, R ,mid);
                } else {
                    return node.val + processRightTree(node.right, R, mid);

                }
            } else if (R < node.val) {
                return processRightTree(node.left, R, mid);
            } else {
                return node.val + sumAllSubTree(node.left);
            }
        }

        /**
         * 汇总所有子节点
         * @param root
         * @return
         */
        private int sumAllSubTree(TreeNode root) {
            if (root == null) {
                return 0;
            }
            return sumAllSubTree(root.left) + root.val + sumAllSubTree(root.right);
        }

        /**
         *
         * 找祖先
         *
         * @param root
         * @param L
         * @param R
         * @return
         */
        private TreeNode findAncestorNode(TreeNode root, int L, int R) {
            if (root.val > R) {
                return findAncestorNode(root.left, L, R);
            } else if (root.val < L) {
                return findAncestorNode(root.right, L, R);
            } else {
                return root;
            }
        }

    }

    public static void main(String[] args) {
        //test1
        /*TreeNode root = new TreeNode(10);
        root.left = new TreeNode(5);
        root.left.left = new TreeNode(3);
        root.left.right = new TreeNode(7);
        root.right = new TreeNode(15);
        root.right.right = new TreeNode(18);
        logger.info("{}", new Solution().rangeSumBST1(root, 7,15));*/

        //test2
        /*TreeNode root = new TreeNode(10);
        root.left = new TreeNode(5);
        root.left.left = new TreeNode(3);
        root.left.right = new TreeNode(9);
        root.left.left.left = new TreeNode(1);
        root.left.right.left = new TreeNode(6);
        root.left.right.left.right = new TreeNode(7);
        root.right = new TreeNode(15);
        root.right.left = new TreeNode(13);
        root.right.right = new TreeNode(18);
        logger.info("{}", new Solution().rangeSumBST1(root, 6,10));*/

        //test3
        TreeNode root = new TreeNode(25);
        root.left = new TreeNode(16);
        root.right = new TreeNode(34);

        //16
        root.left.left = new TreeNode(13);
        root.left.right = new TreeNode(22);
        //34
        root.right.left = new TreeNode(31);
        root.right.right = new TreeNode(37);

        //13
        root.left.left.left = new TreeNode(10);
        //22
        root.left.right.left = new TreeNode(19);
        //31
        root.right.left.right = new TreeNode(28);
        logger.info("{}", new Solution().rangeSumBST1(root, 22,37));

    }

}
