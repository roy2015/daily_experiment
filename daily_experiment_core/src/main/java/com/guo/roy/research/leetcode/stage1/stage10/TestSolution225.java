package com.guo.roy.research.leetcode.stage1.stage10;

import java.util.LinkedList;

import org.slf4j.LoggerFactory;

/**
 * Created by apple on 2019/11/3.
 *使用队列实现栈的下列操作：

 push(x) -- 元素 x 入栈
 pop() -- 移除栈顶元素
 top() -- 获取栈顶元素
 empty() -- 返回栈是否为空
 注意:

 你只能使用队列的基本操作-- 也就是 push to back, peek/pop from front, size, 和 is empty 这些操作是合法的。
 你所使用的语言也许不支持队列。 你可以使用 list 或者 deque（双端队列）来模拟一个队列 , 只要是标准的队列操作即可。
 你可以假设所有操作都是有效的（例如, 对一个空的栈不会调用 pop 或者 top 操作）。

 来源：力扣（LeetCode）
 链接：https://leetcode-cn.com/problems/implement-stack-using-queues
 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 */
public class TestSolution225 {
    private static final org.slf4j.Logger logger = LoggerFactory.getLogger(TestSolution225.class);

    /**
     *
     * 直接用 LinkedList， 是一个双端队列，可以用popLast, peekLast
     *
     * 执行用时 :52 ms, 在所有 java 提交中击败了98.32%的用户
     内存消耗 :34 MB, 在所有 java 提交中击败了71.31%的用户
     */
    static class MyStack {

        private LinkedList<Integer> storeQueue;
        /** Initialize your data structure here. */
        public MyStack() {
            storeQueue = new LinkedList<>();
        }

        /** Push element x onto stack. */
        public void push(int x) {
            storeQueue.addLast(x);
        }

        /** Removes the element on top of the stack and returns that element. */
        public int pop() {
            if (storeQueue.isEmpty()) {
                return 0;
            }
            return storeQueue.pollLast();
        }

        /** Get the top element. */
        public int top() {
            if (storeQueue.isEmpty()) {
                return 0;
            }

            return storeQueue.peekLast();
        }

        /** Returns whether the stack is empty. */
        public boolean empty() {
            return storeQueue.isEmpty();
        }
    }

    public static void main(String[] args) {
/*["MyStack","push","push","top","pop","empty"]
        [[],[1],[2],[],[],[]]*/
        MyStack myStack = new MyStack();
        myStack.push(1);
        myStack.push(2);
        int top = myStack.top();
        int pop = myStack.pop();
        boolean empty = myStack.empty();

        logger.info("{}");
    }

}
