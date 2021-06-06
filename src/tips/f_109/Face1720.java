package tips.f_109;

import java.util.PriorityQueue;

/**
 * 随机产生数字并传递给一个方法。你能否完成这个方法，在每次产生新值时，寻找当前所有值的中间值（中位数）并保存。
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
 *
 * @author hc
 */
public class Face1720 {

    /**
     * 用大顶堆+小顶堆方法，可以看作大顶堆是普通班，小顶堆是实验班。数量上时刻保持 大顶-小顶 <=1（两堆相等或者大顶比小顶多一个）。
     * 新学生先入普通班（大顶堆），此时可能会失去平衡了，于是取大顶堆的第一个（班里最好的学生）加入实验班（小顶堆），
     * 判断若数量过多（不是等于或多一个），取第一个（实验班里最差的学生）到普通班（大顶堆）里。
     * 取中位数的时候，若两堆数量相等，则各取堆顶取平均，若大顶比小顶多一，则多的那一个就是中位数。
     */
    class MedianFinder {

        private PriorityQueue<Integer> left, right;
        private boolean isLeft;

        public MedianFinder() {
            left = new PriorityQueue<>((o1, o2) -> o2 - o1);
            right = new PriorityQueue<>();
        }

        public void addNum(int num) {
            left.add(num);
            right.add(left.poll());
            if (left.size() < right.size()) {
                left.add(right.poll());
            }
        }

        public double findMedian() {
            if (left.size() > right.size()) {
                return left.peek();
            }
            return (left.peek() + right.peek()) / 2.0;
        }
    }
}
