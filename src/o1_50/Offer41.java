package o1_50;

import java.util.PriorityQueue;

/**
 * 如何得到一个数据流中的中位数？如果从数据流中读出奇数个数值，那么中位数就是所有数值排序之后位于中间的数值。如果从数据流中读出偶数个数值，那么中位数就是所有数值排序之后中间两个数的平均值。
 * <p>例如，
 * [2,3,4] 的中位数是 3
 * [2,3] 的中位数是 (2 + 3) / 2 = 2.5
 * 设计一个支持以下两种操作的数据结构：
 * void addNum(int num) - 从数据流中添加一个整数到数据结构中。
 * double findMedian() - 返回目前所有元素的中位数。
 * <p>示例 1：
 * 输入：
 * ["MedianFinder","addNum","addNum","findMedian","addNum","findMedian"]
 * [[],[1],[2],[],[3],[]]
 * 输出：[null,null,null,1.50000,null,2.00000]
 * <p>示例 2：
 * 输入：
 * ["MedianFinder","addNum","findMedian","addNum","findMedian"]
 * [[],[2],[],[3],[]]
 * 输出：[null,null,2.00000,null,2.50000]
 * <p>限制：
 * 最多会对 addNum、findMedian 进行 50000 次调用。
 *
 * @author hc
 */
public class Offer41 {

    /**
     * 难点在排序, 每次都要排序，时间复杂度 -> 自动排序 优先队列
     * 求中位数 -> 两个优先队列 —> 排序：大根堆【后一半】 + 小根堆【前一半】
     * 用两者容量 相等 或 相差 1 来维护中位数的位置
     */
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
