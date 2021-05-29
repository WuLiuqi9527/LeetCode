package tips.f_109;

import java.util.Deque;
import java.util.LinkedList;

/**
 * 栈排序。 编写程序，对栈进行排序使最小元素位于栈顶。
 * 最多只能使用一个其他的临时栈存放数据，但不得将元素复制到别的数据结构（如数组）中。
 * 该栈支持如下操作：push、pop、peek 和 isEmpty。当栈为空时，peek 返回 -1。
 * <p>示例1:
 * 输入：
 * ["SortedStack", "push", "push", "peek", "pop", "peek"]
 * [[], [1], [2], [], [], []]
 * 输出：
 * [null,null,null,1,null,2]
 * <p>示例2:
 * 输入：
 * ["SortedStack", "pop", "pop", "push", "pop", "isEmpty"]
 * [[], [], [], [1], [], []]
 * 输出：
 * [null,null,null,null,null,true]
 * <p>说明:
 * 栈中的元素数目在 [0, 5000]范围内。
 *
 * @author hc
 */
public class Face0305 {

    class SortedStack {

        Deque<Integer> stack;
        Deque<Integer> help;

        public SortedStack() {
            stack = new LinkedList<>();
            help = new LinkedList<>();
        }

        public void push(int val) {
            if (stack.isEmpty()) {
                stack.push(val);
            } else {
                if (stack.peek() >= val) {
                    stack.push(val);
                } else {
                    do {
                        help.push(stack.pop());
                    } while (!stack.isEmpty() && stack.peek() < val);
                    stack.push(val);
                    while (!help.isEmpty()) {
                        stack.push(help.pop());
                    }
                }
            }
        }

        public void pop() {
            if (stack.isEmpty()) {
                return;
            }
            stack.pop();
        }

        public int peek() {
            if (stack.isEmpty()) {
                return -1;
            }
            return stack.peek();
        }

        public boolean isEmpty() {
            return stack.isEmpty();
        }
    }

    public static void main(String[] args) {
        Deque<Integer> deque = new LinkedList<>();
        deque.push(1);
        deque.push(3);
        deque.push(5);
        System.out.println(deque.pollFirst());
    }
}
