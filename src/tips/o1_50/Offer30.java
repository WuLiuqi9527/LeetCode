package tips.o1_50;

import java.util.Stack;

/**
 * 定义栈的数据结构，请在该类型中实现一个能够得到栈的最小元素的 min 函数在该栈中，调用 min、push 及 pop 的时间复杂度都是 O(1)。
 * <p>示例:
 * MinStack minStack = new MinStack();
 * minStack.push(-2);
 * minStack.push(0);
 * minStack.push(-3);
 * minStack.min();   --> 返回 -3.
 * minStack.pop();
 * minStack.top();      --> 返回 0.
 * minStack.min();   --> 返回 -2.
 * <p>提示：
 * 各函数的调用总次数不超过 20000 次
 *
 * @author hc
 */
public class Offer30 {

    class MinStack {

        private Stack<Integer> stack;

        public MinStack() {
            stack = new Stack<>();
        }

        public void push(int x) {
            if (stack.isEmpty()) {
                stack.push(x);
                stack.push(x);
            } else {
                int tem = stack.peek();
                stack.push(x);
                if (x < tem) {
                    stack.push(x);
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

        public int min() {
            return stack.peek();
        }
    }
}
