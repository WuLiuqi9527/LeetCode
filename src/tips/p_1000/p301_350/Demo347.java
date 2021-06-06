package tips.p_1000.p301_350;

import java.util.Comparator;
import java.util.HashMap;
import java.util.PriorityQueue;

/**
 * 给定一个非空的整数数组，返回其中出现频率前 k 高的元素。
 * <p>
 * 输入: nums = [1,1,1,2,2,3], k = 2
 * 输出: [1,2]
 * 输入: nums = [1], k = 1
 * 输出: [1]
 * <p>
 * 提示：
 * 你可以假设给定的 k 总是合理的，且 1 ≤ k ≤ 数组中不相同的元素的个数。
 * 你的算法的时间复杂度必须优于 O(n log n) , n 是数组的大小。
 * 题目数据保证答案唯一，换句话说，数组中前 k 个高频元素的集合是唯一的。
 * 你可以按任意顺序返回答案。
 *
 * @author hc
 */
public class Demo347 {

    public int[] topKFrequent(int[] nums, int k) {
        /* 记录单词的频率 */
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int num : nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }

        /* 优先队列 取前k个频率 */
        PriorityQueue<Integer> pq = new PriorityQueue<>(Comparator.comparingInt(map::get));
        for (int key : map.keySet()) {
            if (pq.size() < k) {
                pq.add(key);
            } else if (map.get(key) > map.get(pq.peek())) {
                pq.remove();
                pq.add(key);
            }
        }

        int[] list = new int[k];
        for (int i = 0; i < k; i++) {
            list[i] = pq.remove();
        }
        return list;
    }

    public static void main(String[] args) {
        new Demo347().topKFrequent(new int[]{1, 1, 1, 2, 2, 3}, 2);
    }
}
