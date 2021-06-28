package summary.DisjointSet;

import java.util.HashMap;
import java.util.List;
import java.util.Stack;

/**
 * @author hc
 */
public class UnionFind {

    public static class Node<V> {
        V value;

        public Node(V v) {
            value = v;
        }
    }

    public static class UnionSet<V> {
        public HashMap<V, Node<V>> nodes;

        public HashMap<Node<V>, Node<V>> parents;

        public HashMap<Node<V>, Integer> sizeMap;

        public UnionSet(List<V> values) {
            for (V v : values) {
                Node<V> node = new Node<>(v);
                nodes.put(v, node);
                parents.put(node, node);
                sizeMap.put(node, 1);
            }
        }

        public Node<V> findFather(Node<V> cur) {
            Stack<Node<V>> path = new Stack<>();
            while (cur != parents.get(cur)) {
                path.push(cur);
                cur = parents.get(cur);
            }

            // 链扁平化
            // 1、并查集瓶颈集中在 findFather往上找的过程
            // 2、小 -> 大 小挂大 减少遍历链的高度
            while (!path.isEmpty()) {
                parents.put(path.pop(), cur);
            }
            return cur;
        }

        public boolean isSameSet(V a, V b) {
            if (!nodes.containsKey(a) || !nodes.containsKey(b)) {
                return false;
            }
            return findFather(nodes.get(a)) == findFather(nodes.get(b));
        }

        public void union(V a, V b) {
            if (!nodes.containsKey(a) || !nodes.containsKey(b)) {
                return;
            }
            Node<V> aHead = findFather(nodes.get(a));
            Node<V> bHead = findFather(nodes.get(b));
            if (aHead != bHead) {
                int aSetSize = sizeMap.get(aHead);
                int bSetSize = sizeMap.get(bHead);
                Node<V> big = aSetSize >= bSetSize ? aHead : bHead;
                Node<V> small = big == aHead ? bHead : aHead;
                parents.put(small, big);
                sizeMap.put(big, aSetSize + bSetSize);
                sizeMap.remove(small);
            }
        }
    }
}
