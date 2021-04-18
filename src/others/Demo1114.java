package others;

import java.util.concurrent.Semaphore;

/**
 * 三个不同的线程 A、B、C 将会共用一个 Foo 实例。
 * 一个将会调用 first() 方法
 * 一个将会调用 second() 方法
 * 还有一个将会调用 third() 方法
 * 请设计修改程序，以确保 second() 方法在 first() 方法之后被执行，third() 方法在 second() 方法之后被执行。
 * <p>示例 1:
 * 输入: [1,2,3]
 * 输出: "firstsecondthird"
 * 解释:
 * 有三个线程会被异步启动。
 * 输入 [1,2,3] 表示线程 A 将会调用 first() 方法，线程 B 将会调用 second() 方法，线程 C 将会调用 third() 方法。
 * 正确的输出是 "firstsecondthird"。
 *
 * @author hc
 */
public class Demo1114 {

    class Foo {

        private Semaphore semaphoreFirst = new Semaphore(0);
        private Semaphore semaphoreSecond = new Semaphore(0);

        public Foo() {

        }

        public void first(Runnable printFirst) throws InterruptedException {
            printFirst.run();
            semaphoreFirst.release();
        }

        public void second(Runnable printSecond) throws InterruptedException {
            semaphoreFirst.acquire();
            printSecond.run();
            semaphoreSecond.release();
        }

        public void third(Runnable printThird) throws InterruptedException {
            semaphoreSecond.acquire();
            printThird.run();
        }
    }
}
