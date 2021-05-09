package tip.p201_250;

import java.util.Stack;

/**
 * 请你仅使用两个栈实现先入先出队列。队列应当支持一般队列的支持的所有操作（push、pop、peek、empty）：
 * <p>
 * 实现 MyQueue 类：
 * void push(int x) 将元素 x 推到队列的末尾
 * int pop() 从队列的开头移除并返回元素
 * int peek() 返回队列开头的元素
 * boolean empty() 如果队列为空，返回 true ；否则，返回 false
 *
 * @author hc
 */
public class Demo232 {

    class MyQueue {

        Stack<Integer> stackOne;
        Stack<Integer> stackTwo;

        public MyQueue() {
            stackOne = new Stack<>();
            stackTwo = new Stack<>();
        }

        public void push(int x) {
            while (!stackOne.isEmpty()){
                stackTwo.add(stackOne.pop());
            }
            stackOne.add(x);
            while (!stackTwo.isEmpty()){
                stackOne.add(stackTwo.pop());
            }
        }

        public int pop() {
            return stackOne.pop();
        }

        public int peek() {
            return stackOne.peek();
        }

        public boolean empty() {
            return stackOne.isEmpty();
        }
    }
}
