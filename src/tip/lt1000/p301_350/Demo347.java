package tip.lt1000.p301_350;

import java.util.PriorityQueue;
import java.util.TreeMap;

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
        TreeMap<Integer, Integer> treeMap = new TreeMap<>();
        for (int num : nums) {
            if (treeMap.containsKey(num)) {
                treeMap.put(num, treeMap.get(num) + 1);
            } else {
                treeMap.put(num, 1);
            }
        }

        /* 优先队列 取前k个频率 */
        PriorityQueue<Integer> pq = new PriorityQueue<>((o1, o2) -> treeMap.get(o1) - treeMap.get(o2));
        for (int key:treeMap.keySet()){
            if (pq.size() < k){
                pq.add(key);
            }else if (treeMap.get(key) > treeMap.get(pq.peek())){
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
}
