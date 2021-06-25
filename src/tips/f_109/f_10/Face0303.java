package tips.f_109.f_10;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * 堆盘子。设想有一堆盘子，堆太高可能会倒下来。
 * 因此，在现实生活中，盘子堆到一定高度时，我们就会另外堆一堆盘子。
 * 请实现数据结构 SetOfStacks，模拟这种行为。
 * SetOfStacks应该由多个栈组成，并且在前一个栈填满时新建一个栈。
 * 此外，SetOfStacks.push()和 SetOfStacks.pop()应该与普通栈的操作方法相同
 * （也就是说，pop()返回的值，应该跟只有一个栈时的情况一样）。
 * 进阶：实现一个 popAt(int index)方法，根据指定的子栈，执行 pop 操作。
 * 当某个栈为空时，应当删除该栈。当栈中没有元素或不存在该栈时，pop，popAt 应返回 -1.
 * <p>示例 1:
 * 输入：
 * ["StackOfPlates", "push", "push", "popAt", "pop", "pop"]
 * [[1], [1], [2], [1], [], []]
 * 输出：
 * [null, null, null, 2, 1, -1]
 * <p>示例 2:
 * 输入：
 * ["StackOfPlates", "push", "push", "push", "popAt", "popAt", "popAt"]
 * [[2], [1], [2], [3], [0], [0], [0]]
 * 输出：
 * [null, null, null, null, 2, 1, 3]
 *
 * @author hc
 */
public class Face0303 {

    class StackOfPlates {

        private List<List<Integer>> stacks;
        private int cap;

        public StackOfPlates(int cap) {
            // LinkedList 便于增删
            this.stacks = new LinkedList<>();
            this.cap = cap;
        }

        public void push(int val) {
            if (cap <= 0) {
                return;
            }

            if (stacks.isEmpty()) {
                // ArrayList 便于索引查询
                List<Integer> stack = new ArrayList<>();
                stack.add(val);
                stacks.add(stack);
            } else {
                List<Integer> last = stacks.get(stacks.size() - 1);
                if (last.size() == cap) {
                    List<Integer> stack = new ArrayList<>();
                    stack.add(val);
                    stacks.add(stack);
                } else {
                    last.add(val);
                }
            }
        }

        public int pop() {
            if (stacks.size() == 0) {
                return -1;
            }

            List<Integer> last = stacks.get(stacks.size() - 1);
            int res = last.get(last.size() - 1);
            last.remove(last.size() - 1);
            if (last.size() == 0) {
                stacks.remove(last);
            }
            return res;
        }

        public int popAt(int index) {
            if (stacks.size() == 0 || index >= stacks.size()) {
                return -1;
            }

            List<Integer> indexStack = stacks.get(index);
            int res = indexStack.get(indexStack.size() - 1);
            indexStack.remove(indexStack.size() - 1);
            if (indexStack.size() == 0) {
                stacks.remove(indexStack);
            }
            return res;
        }
    }
}
