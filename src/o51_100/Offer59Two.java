package o51_100;

import java.util.*;

/**
 * 请定义一个队列并实现函数 max_value 得到队列里的最大值，
 * 要求函数 max_value、push_back 和 pop_front 的均摊时间复杂度都是 O(1)。
 * 若队列为空，pop_front 和 max_value 需要返回 -1
 * <p>示例 1：
 * 输入:
 * ["MaxQueue","push_back","push_back","max_value","pop_front","max_value"]
 * [[],[1],[2],[],[],[]]
 * 输出: [null,null,null,2,1,2]
 * <p>示例 2：
 * 输入:
 * ["MaxQueue","pop_front","max_value"]
 * [[],[],[]]
 * 输出: [null,-1,-1]
 * <p>限制：
 * 1 <= push_back,pop_front,max_value的总操作数 <= 10000
 * 1 <= value <= 10^5
 *
 * @author hc
 */
public class Offer59Two {

    class MaxQueue {

        private Deque<Integer> queue;
        private Deque<Integer> help;

        public MaxQueue() {
            queue = new ArrayDeque<>();
            help = new ArrayDeque<>();
        }

        public int max_value() {
            return queue.isEmpty() ? -1 : help.peek();
        }

        public void push_back(int value) {
            queue.add(value);
            /**
             * 本算法基于问题的一个重要性质：当一个元素进入队列的时候，它前面所有比它小的元素就不会再对答案产生影响。
             * 举个例子，如果我们向队列中插入数字序列 1 1 1 1 2，
             * -----------------
             *    1 1 1 1 2
             * -----------------
             *    2
             * -----------------
             * 那么在第一个数字 2 被插入后，数字 2 前面的所有数字 1 将不会对结果产生影响。
             * 因为按照队列的取出顺序，数字 2 只能在所有的数字 1 被取出之后才能被取出，
             * 因此如果数字 1 如果在队列中，那么数字 2 必然也在队列中，使得数字 1 对结果没有影响
             */
            while (!help.isEmpty() && value > help.peekLast()) {
                help.pollLast();
            }
            help.add(value);
        }

        public int pop_front() {
            if (queue.isEmpty()) {
                return -1;
            }
            int pop = queue.pop();
            if (help.peek() == pop) {
                help.pop();
            }
            return pop;
        }
    }
}
