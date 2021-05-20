package tips.p_1000.p651_700;

import java.util.*;

/**
 * 给一非空的单词列表，返回前 k 个出现次数最多的单词。
 * 返回的答案应该按单词出现频率由高到低排序。
 * 如果不同的单词有相同出现频率，按字母顺序排序。
 * <p>示例 1：
 * 输入: ["i", "love", "leetcode", "i", "love", "coding"], k = 2
 * 输出: ["i", "love"]
 * 解析: "i" 和 "love" 为出现次数最多的两个单词，均为2次。
 * 注意，按字母顺序 "i" 在 "love" 之前。
 * <p>示例 2：
 * 输入: ["the", "day", "is", "sunny", "the", "the", "the", "sunny", "is", "is"], k = 4
 * 输出: ["the", "is", "sunny", "day"]
 * 解析: "the", "is", "sunny" 和 "day" 是出现次数最多的四个单词，
 * 出现次数依次为 4, 3, 2 和 1 次。
 * <p>注意：
 * 假定 k 总为有效值， 1 ≤ k ≤ 集合元素数。
 * 输入的单词均由小写字母组成。
 * <p>扩展练习：
 * 尝试以 O(n log k) 时间复杂度和 O(n) 空间复杂度解决。
 *
 * @author hc
 */
public class Demo692 {

    public List<String> topKFrequent(String[] words, int k) {

        Map<String, Integer> map = new HashMap<>(words.length);
        for (String w : words) {
            map.put(w, map.getOrDefault(w, 0) + 1);
        }

        PriorityQueue<String> queue = new PriorityQueue<>((o1, o2) ->
                map.get(o1).equals(map.get(o2)) ? o2.compareTo(o1) : map.get(o1) - map.get(o2));
        for (String w : map.keySet()) {
            queue.offer(w);
            if (queue.size() > k) {
                queue.poll();
            }
        }

        LinkedList<String> res = new LinkedList<>();
        while (!queue.isEmpty()) {
            res.push(queue.poll());
        }
        return res;
    }

    public static void main(String[] args) {
        new Demo692().topKFrequent(new String[]{"i", "love", "leetcode", "i", "love", "coding"}, 2);
    }
}
