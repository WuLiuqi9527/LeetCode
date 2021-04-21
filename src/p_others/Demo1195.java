package p_others;

import java.util.concurrent.Semaphore;
import java.util.function.IntConsumer;

/**
 * 编写一个可以从 1 到 n 输出代表这个数字的字符串的程序，但是：
 * 如果这个数字可以被 3 整除，输出 "fizz"。
 * 如果这个数字可以被 5 整除，输出 "buzz"。
 * 如果这个数字可以同时被 3 和 5 整除，输出 "fizzbuzz"。
 * 例如，当 n = 15，输出： 1, 2, fizz, 4, buzz, fizz, 7, 8, fizz, buzz, 11, fizz, 13, 14, fizzbuzz。
 * 请你实现一个有 四个线程 的多线程版 FizzBuzz， 同一个 FizzBuzz 实例会被如下四个线程使用：
 * <p>
 * 线程 A 将调用 fizz() 来判断是否能被 3 整除，如果可以，则输出 fizz。
 * 线程 B 将调用 buzz() 来判断是否能被 5 整除，如果可以，则输出 buzz。
 * 线程 C 将调用 fizzbuzz() 来判断是否同时能被 3 和 5 整除，如果可以，则输出 fizzbuzz。
 * 线程 D 将调用 number() 来实现输出既不能被 3 整除也不能被 5 整除的数字。
 *
 * @author hc
 */
public class Demo1195 {

    class FizzBuzz {
        private int n;

        private Semaphore number = new Semaphore(1);
        private Semaphore fizz = new Semaphore(0);
        private Semaphore buzz = new Semaphore(0);
        private Semaphore fizzbuzz = new Semaphore(0);

        public FizzBuzz(int n) {
            this.n = n;
        }

        public void fizz(Runnable printFizz) throws InterruptedException {
            for (int i = 3; i <= n; i += 3) {
                if (i % 5 != 0) {
                    fizz.acquire();
                    printFizz.run();
                    number.release();
                }
            }
        }

        public void buzz(Runnable printBuzz) throws InterruptedException {
            for (int i = 5; i <= n; i += 5) {
                if (i % 3 != 0) {
                    buzz.acquire();
                    printBuzz.run();
                    number.release();
                }
            }
        }

        public void fizzbuzz(Runnable printFizzBuzz) throws InterruptedException {
            for (int i = 15; i <= n; i += 15) {
                fizzbuzz.acquire();
                printFizzBuzz.run();
                number.release();
            }
        }

        public void number(IntConsumer printNumber) throws InterruptedException {

            for (int i = 1; i <= n; i++) {
                number.acquire();
                if (i % 3 == 0 && i % 5 == 0) {
                    fizzbuzz.release();
                } else if (i % 3 == 0) {
                    fizz.release();
                } else if (i % 5 == 0) {
                    buzz.release();
                }else {
                    printNumber.accept(i);
                    number.release();
                }
            }
        }
    }
}
