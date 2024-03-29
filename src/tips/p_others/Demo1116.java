package tips.p_others;

import java.util.concurrent.Semaphore;
import java.util.function.IntConsumer;

/**
 * 相同的一个 ZeroEvenOdd 类实例将会传递给三个不同的线程：
 * 线程 A 将调用 zero()，它只输出 0 。
 * 线程 B 将调用 even()，它只输出偶数。
 * 线程 C 将调用 odd()，它只输出奇数。
 * 每个线程都有一个 printNumber 方法来输出一个整数。
 * 请修改给出的代码以输出整数序列 010203040506... ，其中序列的长度必须为 2n。
 * <p>示例 1：
 * 输入：n = 2
 * 输出："0102"
 * 说明：三条线程异步执行，其中一个调用 zero()，另一个线程调用 even()，最后一个线程调用odd()。
 * 正确的输出为 "0102"。
 * <p>示例 2：
 * 输入：n = 5
 * 输出："0102030405"
 *
 * @author hc
 */
public class Demo1116 {

    class ZeroEvenOdd {
        private int n;

        private Semaphore zero = new Semaphore(1);
        private Semaphore even = new Semaphore(0);
        private Semaphore odd = new Semaphore(0);

        public ZeroEvenOdd(int n) {
            this.n = n;
        }

        // printNumber.accept(x) outputs "x", where x is an integer.
        public void zero(IntConsumer printNumber) throws InterruptedException {

            for (int i = 1; i <= n; i++) {
                zero.acquire();
                printNumber.accept(0);
                if ((i & 1) == 0) {
                    even.release();
                } else {
                    odd.release();
                }
            }
        }

        public void even(IntConsumer printNumber) throws InterruptedException {

            for (int i = 2; i <= n; i += 2) {
                even.acquire();
                printNumber.accept(i);
                zero.release();
            }
        }

        public void odd(IntConsumer printNumber) throws InterruptedException {

            for (int i = 1; i <= n; i += 2) {
                odd.acquire();
                printNumber.accept(i);
                zero.release();
            }
        }
    }
}
