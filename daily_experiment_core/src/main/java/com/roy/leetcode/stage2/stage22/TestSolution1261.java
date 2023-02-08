package com.roy.leetcode.stage2.stage22;

import java.util.LinkedList;

import org.slf4j.LoggerFactory;

/**
 * @author guojun
 * @date 2020/7/21
 *
 * 1261. 在受污染的二叉树中查找元素
 * 给出一个满足下述规则的二叉树：
 *
 * root.val == 0
 * 如果 treeNode.val == x 且 treeNode.left != null，那么 treeNode.left.val == 2 * x + 1
 * 如果 treeNode.val == x 且 treeNode.right != null，那么 treeNode.right.val == 2 * x + 2
 * 现在这个二叉树受到「污染」，所有的 treeNode.val 都变成了 -1。
 *
 * 请你先还原二叉树，然后实现 FindElements 类：
 *
 * FindElements(TreeNode* root) 用受污染的二叉树初始化对象，你需要先把它还原。
 * bool find(int target) 判断目标值 target 是否存在于还原后的二叉树中并返回结果。
 *
 *
 * 示例 1：
 *
 *
 *
 * 输入：
 * ["FindElements","find","find"]
 * [[[-1,null,-1]],[1],[2]]
 * 输出：
 * [null,false,true]
 * 解释：
 * FindElements findElements = new FindElements([-1,null,-1]);
 * findElements.find(1); // return False
 * findElements.find(2); // return True
 * 示例 2：
 *
 *
 *
 * 输入：
 * ["FindElements","find","find","find"]
 * [[[-1,-1,-1,-1,-1]],[1],[3],[5]]
 * 输出：
 * [null,true,true,false]
 * 解释：
 * FindElements findElements = new FindElements([-1,-1,-1,-1,-1]);
 * findElements.find(1); // return True
 * findElements.find(3); // return True
 * findElements.find(5); // return False
 * 示例 3：
 *
 *
 *
 * 输入：
 * ["FindElements","find","find","find","find"]
 * [[[-1,null,-1,-1,null,-1]],[2],[3],[4],[5]]
 * 输出：
 * [null,true,false,false,true]
 * 解释：
 * FindElements findElements = new FindElements([-1,null,-1,-1,null,-1]);
 * findElements.find(2); // return True
 * findElements.find(3); // return False
 * findElements.find(4); // return False
 * findElements.find(5); // return True
 *
 *
 * 提示：
 *
 * TreeNode.val == -1
 * 二叉树的高度不超过 20
 * 节点的总数在 [1, 10^4] 之间
 * 调用 find() 的总次数在 [1, 10^4] 之间
 * 0 <= target <= 10^6
 *
 *
 *
 *
 */
public class TestSolution1261 {
    private static final org.slf4j.Logger logger = LoggerFactory.getLogger(TestSolution1261.class);

    static class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;
      TreeNode(int x) { val = x; }
    }


    /**
     *
     * linkedList vs stack，性能有差别？
     *
     * 执行结果：
     * 通过
     * 显示详情
     * 执行用时：
     * 30 ms, 在所有 Java 提交中击败了68.78%的用户
     * 内存消耗：
     * 44.8 MB, 在所有 Java 提交中击败了85.71%的用户
     *
     */
    static class FindElements {
        TreeNode root;

        /**
         * 还原"干净"的二叉树
         * @param root
         */
        public FindElements(TreeNode root) {
            this.root = root;
            root.val = 0;
            recursiveFindElements(root);
        }

        /**
         * 递归给node的val赋值
         * @param root
         */
        private void recursiveFindElements(TreeNode root) {
            int rVal = root.val;
            TreeNode leftNode = root.left;
            TreeNode rightNode = root.right;
            if(leftNode != null) {
                leftNode.val = 2 * rVal + 1;
                recursiveFindElements(leftNode);
            }

            if(rightNode != null) {
                rightNode.val = 2 * rVal + 2;
                recursiveFindElements(rightNode);
            }
        }

        /**
         * 倒推出targe的路径放入栈，然后出战验证路径的有无
         * @param target
         * @return
         */
        public boolean find(int target) {
            if (target == 0) {//0 <= target <= 10^6
                return true;
            }

            LinkedList<Integer> stack = new LinkedList<>();
            while (target != 0) {
                stack.addFirst(target);
                target = (target & 0x1) == 1 ? target >>1  : (target -1) >> 1 ;
            }

            /*Stack<Integer> stack = new Stack<>();
            while (target != 0) {
                stack.push(target);
                target = (target & 0x1) == 1 ? target >>1  : (target -1) >> 1 ;
            }*/

            TreeNode calNode = root;
            while (!stack.isEmpty()) {
                Integer pVal = stack.pop();
                TreeNode leftNode = calNode.left;
                TreeNode rightNode = calNode.right;
                if (leftNode != null && leftNode.val == pVal) {
                    calNode = leftNode;
                } else if (rightNode != null && rightNode.val == pVal) {
                    calNode = rightNode;
                } else return false;
            }
            return true;
        }
    }

    public static void main(String[] args) {
//        [-1,null,-1,-1,null,-1]
        TreeNode root = new TreeNode(-1);
        TreeNode node1 = new TreeNode(-1);
        TreeNode node2 = new TreeNode(-1);
        TreeNode node3 = new TreeNode(-1);

        root.right = node1;
        node1.left = node2;
        node2.left = node3;

        FindElements solution = new FindElements(root);
        logger.info("{}", solution.find(2));//t
        logger.info("{}", solution.find(3));//f
        logger.info("{}", solution.find(4));//f
        logger.info("{}", solution.find(5));//t
    }
}
