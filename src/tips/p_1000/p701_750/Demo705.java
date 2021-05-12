package tips.p_1000.p701_750;

/**
 *不使用任何内建的哈希表库设计一个哈希集合（HashSet）。
 *
 * 实现 MyHashSet 类：
 *
 * void add(key) 向哈希集合中插入值 key 。
 * bool contains(key) 返回哈希集合中是否存在这个值 key 。
 * void remove(key) 将给定值 key 从哈希集合中删除。如果哈希集合中没有这个值，什么也不做。
 *
 * @author hc
 */
public class Demo705 {

    class MyHashSet {

        boolean[] arr;
        /** Initialize your data structure here. */
        public MyHashSet() {
            arr = new boolean[1<<20];
        }

        public void add(int key) {
            arr[key] = true;
        }

        public void remove(int key) {
            arr[key] = false;
        }

        /** Returns true if this set contains the specified element */
        public boolean contains(int key) {
            return arr[key];
        }
    }
}
