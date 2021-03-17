package com.roy.miscellaneous.leetcode.stage1.stage10;

import java.util.Stack;

import org.slf4j.LoggerFactory;

/**
 * Created by apple on 2019/11/02.
 *使用栈实现队列的下列操作：

 push(x) -- 将一个元素放入队列的尾部。
 pop() -- 从队列首部移除元素。
 peek() -- 返回队列首部的元素。
 empty() -- 返回队列是否为空。
 示例:

 MyQueue queue = new MyQueue();

 queue.push(1);
 queue.push(2);
 queue.peek();  // 返回 1
 queue.pop();   // 返回 1
 queue.empty(); // 返回 false
 说明:

 你只能使用标准的栈操作 -- 也就是只有 push to top, peek/pop from top, size, 和 is empty 操作是合法的。
 你所使用的语言也许不支持栈。你可以使用 list 或者 deque（双端队列）来模拟一个栈，只要是标准的栈操作即可。
 假设所有操作都是有效的 （例如，一个空的队列不会调用 pop 或者 peek 操作）。

 来源：力扣（LeetCode）
 链接：https://leetcode-cn.com/problems/implement-queue-using-stacks
 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 */
public class TestSolution232 {
    private static final org.slf4j.Logger logger = LoggerFactory.getLogger(TestSolution232.class);

    /**
     *
     *
     * 执行用时 :54 ms, 在所有 java 提交中击败了87.91%的用户
     内存消耗 :33.6 MB, 在所有 java 提交中击败了80.31%的用户
     */
    static class MyQueue {
        private Stack<Integer> storeStack;

        /** Initialize your data structure here. */
        public MyQueue() {
            storeStack = new Stack<>();
        }

        /** Push element x to the back of queue. */
        public void push(int x) {
            if (storeStack.isEmpty()) {
                storeStack.push(x);
                return;
            }

            Stack<Integer> assistStack = new Stack<>();
            while (!storeStack.isEmpty()) {
                assistStack.push(storeStack.pop());
            }
            assistStack.push(x);
            while (!assistStack.isEmpty()) {
                storeStack.push(assistStack.pop());
            }
        }

        /** Removes the element from in front of queue and returns that element. */
        public int pop() {
            if (storeStack.isEmpty()) {
                return 0;
            }
            return storeStack.pop();
        }

        /** Get the front element. */
        public int peek() {
            if (storeStack.isEmpty()) {
                return 0;
            }
            return storeStack.peek();
        }

        /** Returns whether the queue is empty. */
        public boolean empty() {
            return storeStack.isEmpty();
        }
    }

    /**
     * 相比与1，把辅助栈换成了数组
     *
     * 执行用时 :53 ms, 在所有 java 提交中击败了95.03%的用户
     内存消耗 :33.8 MB, 在所有 java 提交中击败了71.80%的用户
     */
    static class MyQueue1 {
        private Stack<Integer> storeStack;

        /** Initialize your data structure here. */
        public MyQueue1() {
            storeStack = new Stack<>();
        }

        /** Push element x to the back of queue. */
        public void push(int x) {
            if (storeStack.isEmpty()) {
                storeStack.push(x);
                return;
            }

            int[] ints = new int[storeStack.size()];
            int i =0;
            while (!storeStack.isEmpty()) {
                ints[i++] = storeStack.pop();
            }
            storeStack.push(x);
            for (int i1 = ints.length - 1; i1 >= 0; i1--) {
                storeStack.push(ints[i1]);

            }
        }

        /** Removes the element from in front of queue and returns that element. */
        public int pop() {
            if (storeStack.isEmpty()) {
                return 0;
            }
            return storeStack.pop();
        }

        /** Get the front element. */
        public int peek() {
            if (storeStack.isEmpty()) {
                return 0;
            }
            return storeStack.peek();
        }

        /** Returns whether the queue is empty. */
        public boolean empty() {
            return storeStack.isEmpty();
        }
    }

    /**
     *
     * 不同于以上的， 数据重排分散到pop, peak里， 提高了push的性能，但牺牲了pop,peak性能
     *
     * 执行用时 :53 ms, 在所有 java 提交中击败了95.03%的用户
     内存消耗 :33.8 MB, 在所有 java 提交中击败了67.78%的用户
     *
     *
     */
    static class MyQueue2 {
        private Stack<Integer> storeStack;

        /** Initialize your data structure here. */
        public MyQueue2() {
            storeStack = new Stack<>();
        }

        /** Push element x to the back of queue. */
        public void push(int x) {
            storeStack.push(x);
        }

        /** Removes the element from in front of queue and returns that element. */
        public int pop() {
            if (storeStack.isEmpty()) {
                return 0;
            }

            Stack<Integer> assistStack = new Stack<>();
            while (!storeStack.isEmpty()) {
                assistStack.push(storeStack.pop());
            }
            int oppo = assistStack.pop();

            while (!assistStack.isEmpty()) {
                storeStack.push(assistStack.pop());
            }
            return oppo;
        }

        /** Get the front element. */
        public int peek() {
            if (storeStack.isEmpty()) {
                return 0;
            }

            Stack<Integer> assistStack = new Stack<>();
            while (!storeStack.isEmpty()) {
                assistStack.push(storeStack.pop());
            }
            int opeek = assistStack.peek();

            while (!assistStack.isEmpty()) {
                storeStack.push(assistStack.pop());
            }
            return opeek;
        }

        /** Returns whether the queue is empty. */
        public boolean empty() {
            return storeStack.isEmpty();
        }
    }



    /**
     * Your MyQueue object will be instantiated and called as such:
     * MyQueue obj = new MyQueue();
     * obj.push(x);
     * int param_2 = obj.pop();
     * int param_3 = obj.peek();
     * boolean param_4 = obj.empty();
     */

    public static void main(String[] args) {
        MyQueue2 obj = new MyQueue2();
        obj.push(3);
        obj.push(4);
        obj.push(5);
        int param_2 = obj.pop();

        int param_3 = obj.peek();
        int param_4 = obj.peek();
        boolean param_5 = obj.empty();

        logger.info("{}");
    }

}
