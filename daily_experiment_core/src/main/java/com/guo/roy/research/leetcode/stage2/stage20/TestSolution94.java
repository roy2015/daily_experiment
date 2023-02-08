package com.guo.roy.research.leetcode.stage2.stage20;

import java.util.*;

import org.slf4j.LoggerFactory;

/**
 * @author guojun
 * @date 2020/11/26
 *
 *
 *
 * 94. 二叉树的中序遍历
 * 给定一个二叉树的根节点 root ，返回它的 中序 遍历。
 *
 *
 *
 * 示例 1：
 *
 *
 * 输入：root = [1,null,2,3]
 * 输出：[1,3,2]
 * 示例 2：
 *
 * 输入：root = []
 * 输出：[]
 * 示例 3：
 *
 * 输入：root = [1]
 * 输出：[1]
 * 示例 4：
 *
 *
 * 输入：root = [1,2]
 * 输出：[2,1]
 * 示例 5：
 *
 *
 * 输入：root = [1,null,2]
 * 输出：[1,2]
 *
 *
 * 提示：
 *
 * 树中节点数目在范围 [0, 100] 内
 * -100 <= Node.val <= 100
 *
 *
 * 进阶: 递归算法很简单，你可以通过迭代算法完成吗？
 *
 *
 *
 *
 */
public class TestSolution94 {
    private static final org.slf4j.Logger logger = LoggerFactory.getLogger(TestSolution94.class);


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
         * 没用递归，走的进阶，"进阶: 递归算法很简单，你可以通过迭代算法完成吗？"，好麻烦，用了两个栈 + hash(记录中间节点)
         * 1ms怎么进0ms,
         *
         * 执行结果：通过
         * 显示详情
         * 执行用时：1 ms, 在所有 Java 提交中击败了43.70%的用户
         * 内存消耗：36.8 MB, 在所有 Java 提交中击败了76.82%的用户
         *
         * @param root
         * @return
         */
        public List<Integer> inorderTraversal(TreeNode root) {
            if (root == null) return Collections.emptyList();

            TreeNode node = root;
            Deque<TreeNode> stack1 = new LinkedList<>();
            Deque<TreeNode> stack2 = new LinkedList<>();
            stack1.push(node);
            Set<TreeNode> set = new HashSet<>();
            LinkedList<Integer> retList = new LinkedList<>();
            while (true) {
                TreeNode stack1Top = stack1.peek();
                //左右均为空且stack2为空
                if (stack2.isEmpty() && stack1Top.left == null && stack1Top.right == null) {
                    break;
                }
                //出栈后入栈的情况
                if (set.contains(stack1Top)) {
                    if (stack1Top.right != null) {
                        stack1.push(stack1Top.right);
                    } else {
                        if (stack2.isEmpty()) {
                            break;
                        } else {
                            stack1.push(stack2.pop());
                        }
                    }
                    continue;
                }
                //正常情况
                if (stack1Top.left != null) {
                    stack1.pop();
                    stack2.push(stack1Top);
                    set.add(stack1Top);
                    stack1.push(stack1Top.left);
                } else if (stack1Top.right != null) {
                    stack1.push(stack1Top.right);
                } else {
                    //左右均没有，stack2里有
                    TreeNode stack2Top = stack2.pop();
                    stack1.push(stack2Top);
                }
            }
            //开始输出
            while (!stack1.isEmpty()) {
                retList.addFirst(stack1.pop().val);
            }
            return retList;
        }

    }

    public static void main(String[] args) {
        TreeNode root;


        root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(6);

        root.left.left = new TreeNode(3);
        root.left.right = new TreeNode(4);

        root.left.right.left = new TreeNode(5);

        logger.info("{}", new Solution().inorderTraversal(root));//213
    }
}
