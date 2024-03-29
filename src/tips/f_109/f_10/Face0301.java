package tips.f_109.f_10;

/**
 * 三合一。描述如何只用一个数组来实现三个栈。
 * 你应该实现push(stackNum, value)、pop(stackNum)、isEmpty(stackNum)、peek(stackNum)方法。
 * stackNum表示栈下标，value表示压入的值。
 * 构造函数会传入一个stackSize参数，代表每个栈的大小。
 * <p>示例1:
 * 输入：
 * ["TripleInOne", "push", "push", "pop", "pop", "pop", "isEmpty"]
 * [[1], [0, 1], [0, 2], [0], [0], [0], [0]]
 * 输出：
 * [null, null, null, 1, -1, -1, true]
 * 说明：当栈为空时`pop, peek`返回-1，当栈满时`push`不压入元素。
 * <p>示例2:
 * 输入：
 * ["TripleInOne", "push", "push", "push", "pop", "pop", "pop", "peek"]
 * [[2], [0, 1], [0, 2], [0, 3], [0], [0], [0], [0]]
 * 输出：
 * [null, null, null, null, 2, 1, -1, -1]
 *
 * @author hc
 */
public class Face0301 {

    class TripleInOne {

        private int[] arr;
        private int[] size;
        private int stackSize;

        public TripleInOne(int stackSize) {
            this.arr = new int[3 * stackSize];
            this.size = new int[]{0, 0, 0};
            this.stackSize = stackSize;
        }

        public void push(int stackNum, int value) {
            int index = size[stackNum];
            if (index < stackSize) {
                arr[stackNum * stackSize + index] = value;
                ++size[stackNum];
            }
        }

        public int pop(int stackNum) {
            int topVal = peek(stackNum);
            if (size[stackNum] > 0) {
                --size[stackNum];
            }
            return topVal;
        }

        public int peek(int stackNum) {
            if (size[stackNum] == 0) {
                return -1;
            } else {
                return arr[stackNum * stackSize + size[stackNum] - 1];
            }
        }

        public boolean isEmpty(int stackNum) {
            return size[stackNum] == 0;
        }
    }
}
