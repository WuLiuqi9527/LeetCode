package tips.p_1000.p151_200;

import java.util.Stack;

/**
 * 设计一个支持 push ，pop ，top 操作，并能在常数时间内检索到最小元素的栈。
 * <p>
 * push(x) —— 将元素 x 推入栈中。
 * pop() —— 删除栈顶的元素。
 * top() —— 获取栈顶元素。
 * getMin() —— 检索栈中的最小元素。
 *
 * @author hc
 */
public class Demo155 {

    /**
     * 常数时间 -> 必然需要空间换时间 -> 两个栈
     */
    class MinStack {

        Stack<Integer> stack, stackAss;

        public MinStack() {
            stack = new Stack<>();
            stackAss = new Stack<>();
        }

        public void push(int val) {
            stack.push(val);
            if (stackAss.isEmpty() || (!stackAss.isEmpty() && val <= stackAss.peek())) {
                stackAss.push(val);
            }
        }

        public void pop() {
            int tem = stack.pop();
            if (tem == stackAss.peek()) {
                stackAss.pop();
            }
        }

        public int top() {
            return stack.peek();
        }

        public int getMin() {
            return stackAss.peek();
        }
    }

    /**
     * 每次入栈 2 个元素，一个是入栈的元素本身，一个是当前栈元素的最小值
     * 两个栈合为一个，但空间消耗一样
     */
    class MinStack2 {

        Stack<Integer> stack;

        public MinStack2() {
            stack = new Stack<>();
        }

        public void push(int val) {
            if (stack.isEmpty()) {
                stack.push(val);
                stack.push(val);
            } else {
                int tem = stack.peek();
                stack.push(val);
                if (val <= tem) {
                    stack.push(val);
                } else {
                    stack.push(tem);
                }
            }
        }

        public void pop() {
            stack.pop();
            stack.pop();
        }

        public int top() {
            return stack.get(stack.size() - 2);
        }

        public int getMin() {
            return stack.peek();
        }
    }

    /**
     * 利用链表实现
     */
    class MinStack3 {

        private class Node {
            int val;
            int min;
            Node next;

            private Node(int val, int min) {
                this(val, min, null);
            }

            private Node(int val, int min, Node next) {
                this.val = val;
                this.min = min;
                this.next = next;
            }
        }

        private Node head;

        public MinStack3() {
        }

        public void push(int val) {
            if (head == null) {
                head = new Node(val, val);
            } else {
                head = new Node(val, Math.min(val, head.min), head);
            }
        }

        public void pop() {
            head = head.next;
        }

        public int top() {
            return head.val;
        }

        public int getMin() {
            return head.min;
        }
    }
}
