package tips.p_1000.p101_150;

import java.util.*;

/**
 * 运用你所掌握的数据结构，设计和实现一个  LRU (最近最少使用) 缓存机制 。
 * 实现 LRUCache 类：
 * LRUCache(int capacity) 以正整数作为容量 capacity 初始化 LRU 缓存
 * int get(int key) 如果关键字 key 存在于缓存中，则返回关键字的值，否则返回 -1 。
 * void put(int key, int value) 如果关键字已经存在，则变更其数据值；如果关键字不存在，则插入该组「关键字-值」。当缓存容量达到上限时，它应该在写入新数据之前删除最久未使用的数据值，从而为新的数据值留出空间。
 *
 * @author hc
 */
public class Demo146 {

    class LRUCache {

        // HashMap + 双向链表 = 保持插入顺序的 Map
        // 维护一个双向链表来保证迭代顺序
        // LinkedHashMap保存了记录的插入顺序，
        // 在用 Iterator 遍历 LinkedHashMap 时，先得到的记录肯定是先插入的
        int capacity;
        Map<Integer, Integer> map = new LinkedHashMap<>();

        public LRUCache(int capacity) {
            this.capacity = capacity;
        }

        public int get(int key) {
            if (map.keySet().contains(key)) {
                int value = map.get(key);
                map.remove(key);
                map.put(key, value);
                return value;
            }
            return -1;
        }

        public void put(int key, int value) {
            if (map.keySet().contains(key)) {
                map.remove(key);
                map.put(key, value);
            } else if (map.size() == capacity) {
                // 获取 Map<Integer, Integer> 集合的迭代器 用于遍历
                // 迭代器只针对集合类型的数据，所以要用 Entry 转集合
                Iterator<Map.Entry<Integer, Integer>> iterator = map.entrySet().iterator();
                // 越过第一个元素
                iterator.next();
                // remove()将删除上次调用 next()时返回的元素
                iterator.remove();
            }
            map.put(key, value);
        }
    }
}
