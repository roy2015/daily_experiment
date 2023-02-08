package com.guo.roy.research.leetcode.stage1.stage10;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

import org.slf4j.LoggerFactory;

/**
 * Created by apple on 2019/10/13.
 * 给定一个二叉树，判断其是否是一个有效的二叉搜索树。
 * <p>
 * 假设一个二叉搜索树具有如下特征：
 * <p>
 * 节点的左子树只包含小于当前节点的数。
 * 节点的右子树只包含大于当前节点的数。
 * 所有左子树和右子树自身必须也是二叉搜索树。
 * 示例 1:
 * <p>
 * 输入:
 * 2
 * / \
 * 1   3
 * 输出: true
 * 示例 2:
 * <p>
 * 输入:
 * 5
 * / \
 * 1    4
 *      / \
 *     3   6
 * 输出: false
 * 解释: 输入为: [5,1,4,null,null,3,6]。
 *      根节点的值为 5 ，但是其右子节点值为 4 。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/validate-binary-search-tree
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class TestSolution98 {
    private static final org.slf4j.Logger logger = LoggerFactory.getLogger(TestSolution98.class);

    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    /**
     */
    static class Solution {
        public boolean checkIsAllNull(LinkedList<TreeNode> linkedList) {
            for (int i = 0; i < linkedList.size(); i++) {
                TreeNode node = linkedList.get(i);
                int val = node == null ? -999999 : node.val;
                if (node != null) {
                    return false;
                }
            }
            return true;
        }

        public void addToBST(TreeNode node, Integer val) {
            if (val == null) {
                return;
            }
            if (val.compareTo(node.val) < 0) {
                if (node.left == null) {
                    node.left = new TreeNode(val);
                } else {
                    addToBST(node.left, val);
                }
            } else if ((val.compareTo(node.val) > 0)) {
                if (node.right == null) {
                    node.right = new TreeNode(val);
                } else {
                    addToBST(node.right, val);
                }
            } else {
                return;
            }
        }


        /**
         * 数组转树
         * @param list
         * @return
         */
        public TreeNode transformToBST(List<Integer> list) {
            TreeNode root = null;
            root = new TreeNode(list.get(0));
            for (int i = 1; i < list.size(); i++) {
                addToBST(root, list.get(i));
            }
            return root;
        }


        /**
         * 树转数组表示
         * @param root
         * @return
         */
        public List<Integer> transformToList(TreeNode root) {
            if (root == null) {
                return null;
            }

            LinkedList<TreeNode> queue = new LinkedList<>();
            queue.add(root);
            ArrayList<Integer> retList = new ArrayList<>();


            while (!checkIsAllNull(queue)) {
                TreeNode node = queue.poll();
                if (node != null) {
                    retList.add(node.val);
                    queue.offer(node.left);
                    queue.offer(node.right);
                } else {
                    retList.add(null);
                }
            }
            return retList;
        }

        /**
         * 用了最复杂的方法，利用了BST的数组表示形式的唯一性
         * <p>
         * 执行用时 :24 ms, 在所有 java 提交中击败了5.86%的用户
         * 内存消耗 :40.5 MB, 在所有 java 提交中击败了7.92%的用户
         *
         * @param root
         * @return
         */
        public boolean isValidBST(TreeNode root) {
            if (root == null) {
                return true;
            }

            List<Integer> srcList = transformToList(root);
            //不能有val相等的节点
            Integer tmp = null;
            for (Integer val : srcList) {
                if (val != null && tmp != null) {
                    if (val.compareTo(tmp) == 0) {
                        return false;
                    }
                }

                if (tmp == null && val != null) {
                    tmp = val;
                }
            }

            List<Integer> expectList = transformToList(transformToBST(srcList));

            int srcSize = srcList.size();
            int expectSize = expectList.size();
            for (int i = 0; i < Math.min(srcSize, expectSize); i++) {

                if (srcList.get(i) == null && expectList.get(i) == null) {
                    continue;
                }
                if (srcList.get(i) != null && expectList.get(i) != null) {
                    if (srcList.get(i).equals(expectList.get(i))) {
                        continue;
                    }
                }

                return false;
            }

            return true;
        }

        /**
         * 上界下界法
         *执行用时 :1 ms, 在所有 java 提交中击败了99.41%的用户
         * @param root
         * @return
         */
        public boolean isValidBST1(TreeNode root) {
            if (root == null) {
                return true;
            }

            return isValidBST1_sub(root, null, null);
        }

        /**
         * @param root
         * @param ceiling
         * @param floor
         * @return
         */
        public boolean isValidBST1_sub(TreeNode root, Integer ceiling, Integer floor) {
            if (root.left != null && root.left.val >= root.val) {
                return false;
            }

            if (root.left != null) {
                if (!isValidBST1_sub(root.left, root.val, floor)) {
                    return false;
                }
            }

            if (root.right != null && root.right.val <= root.val) {
                return false;
            }

            if (root.right != null) {
                if (!isValidBST1_sub(root.right, ceiling, root.val)) {
                    return false;
                }
            }

            //高出天花板 || 低出地板
            if ((ceiling != null && root.val >= ceiling) || (floor != null && root.val <= floor)) {
                return false;
            }
            return true;

        }


        /**
         * 遍历法
         * 执行用时 :2 ms, 在所有 java 提交中击败了68.97%的用户
         * @param root
         * @return
         */
        public boolean isValidBST2(TreeNode root) {
            if (root == null) {
                return true;
            }
            return isValidBST2_sub(root, new Stack<Integer>());
        }

        private boolean isValidBST2_sub (TreeNode node, Stack<Integer> stack) {
            if (node.left != null) {
                if (!isValidBST2_sub(node.left, stack) ) {
                    return false;
                }
            }

            if (stack.size() != 0 && stack.peek().compareTo(node.val) >= 0) {
                return false;
            }
            stack.push(node.val);

            if (node.right != null) {
                if (!isValidBST2_sub(node.right, stack) ) {
                    return false;
                }
            }
            return true;
        }
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(2147483647);
        /*root.left = new TreeNode(5);
        root.right = new TreeNode(15);
        root.right.left = new TreeNode(6);
        root.right.right = new TreeNode(20);*/

//        List list = new Solution().transformToList(root);
//        TreeNode node = new Solution().transformToBST(list);

        /*List<Integer> list = Arrays.asList(98, 97, null, 88, null, 84, null, 79, 87, 64, null, null, null, 63, 69, 62, null, null, null, 30, null, 27, 59, 9, null, null, null, 3, null, 0, null, -4, null, -16, null, -18,
                -7, -19, null, null, null, -23, null, -34, null, -42, null, -59, null, -63, null, -64, null, -69, null, -75, null, -81);

        root = new Solution().transformToBST(list);*/

        boolean validBST = new Solution().isValidBST2(root);

        logger.info("{}", validBST);
    }

}
