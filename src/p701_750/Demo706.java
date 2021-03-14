package p701_750;

import java.util.Arrays;

/**
 * 不使用任何内建的哈希表库设计一个哈希映射（HashMap）。
 * <p>
 * 实现 MyHashMap 类：
 * <p>
 * MyHashMap() 用空映射初始化对象
 * void put(int key, int value) 向 HashMap 插入一个键值对 (key, value) 。如果 key 已经存在于映射中，则更新其对应的值 value 。
 * int get(int key) 返回特定的 key 所映射的 value ；如果映射中不包含 key 的映射，返回 -1 。
 * void remove(key) 如果映射中存在 key 的映射，则移除 key 和它所对应的 value 。
 *
 * @author hc
 */
public class Demo706 {

    class MyHashMap {

        // 数组
        int[] map = new int[1 << 20];

        public MyHashMap() {
            Arrays.fill(map, Integer.MAX_VALUE);
        }

        public void put(int key, int value) {
            map[key] = value;
        }

        public int get(int key) {
            return map[key] == Integer.MAX_VALUE ? -1 : map[key];
        }

        public void remove(int key) {
            map[key] = Integer.MAX_VALUE;
        }
    }
}
