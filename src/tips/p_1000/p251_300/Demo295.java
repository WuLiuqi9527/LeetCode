package tips.p_1000.p251_300;

import java.util.PriorityQueue;

/**
 * 中位数是有序列表中间的数。如果列表长度是偶数，中位数则是中间两个数的平均值。
 * <p>例如，
 * [2,3,4] 的中位数是 3
 * [2,3] 的中位数是 (2 + 3) / 2 = 2.5
 * 设计一个支持以下两种操作的数据结构：
 * void addNum(int num) - 从数据流中添加一个整数到数据结构中。
 * double findMedian() - 返回目前所有元素的中位数。
 * <p>示例：
 * addNum(1)
 * addNum(2)
 * findMedian() -> 1.5
 * addNum(3)
 * findMedian() -> 2
 * <p>进阶：
 * 如果数据流中所有整数都在 0 到 100 范围内，你将如何优化你的算法？
 * 如果数据流中 99% 的整数都在 0 到 100 范围内，你将如何优化你的算法？
 *
 * @author hc
 */
public class Demo295 {

    class MedianFinder {

        PriorityQueue<Integer> large;
        PriorityQueue<Integer> small;

        public MedianFinder() {
            large = new PriorityQueue<>((o1, o2) -> o1 - o2);
            small = new PriorityQueue<>((o1, o2) -> o2 - o1);
        }

        public void addNum(int num) {
            large.add(num);
            small.add(large.poll());
            if (large.size() + 1 < small.size()) {
                large.add(small.poll());
            }
        }

        public double findMedian() {
            if (small.size() > large.size()) {
                return small.peek();
            }
            return (double) (large.peek() + small.peek()) / 2;
        }
    }
}
