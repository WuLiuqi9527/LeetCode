package tips.f_109.f_10;

import java.util.Deque;
import java.util.LinkedList;

/**
 * 实现一个 MyQueue 类，该类用两个栈来实现一个队列。
 * <p>说明：
 * 你只能使用标准的栈操作 -- 也就是只有 push to top, peek/pop from top, size 和 is empty 操作是合法的。
 * 你所使用的语言也许不支持栈。你可以使用 list 或者 deque（双端队列）来模拟一个栈，只要是标准的栈操作即可。
 * 假设所有操作都是有效的 （例如，一个空的队列不会调用 pop 或者 peek 操作）。
 *
 * @author hc
 */
public class Face0304 {

    class MyQueue {

        private Deque<Integer> stack1;
        private Deque<Integer> stack2;

        public MyQueue() {
            stack1 = new LinkedList<>();
            stack2 = new LinkedList<>();
        }

        public void push(int x) {
            while (!stack2.isEmpty()) {
                stack1.push(stack2.pop());
            }
            stack2.push(x);
            while (!stack1.isEmpty()) {
                stack2.push(stack1.pop());
            }
        }

        public int pop() {
            return stack2.pop();
        }

        public int peek() {
            return stack2.peek();
        }

        public boolean empty() {
            return stack2.isEmpty();
        }
    }

}
