package tips.p_1000.p201_250;

import java.util.TreeMap;

/**
 * @author hc
 */
public class Demo208 {

    class Trie {

        private class Node {

            public boolean isWord;
            public TreeMap<Character, Node> next;

            public Node(boolean isWord) {
                this.isWord = isWord;
                next = new TreeMap<>();
            }

            public Node() {
                this(false);
            }
        }

        private Node root;

        public Trie() {
            root = new Node();
        }

        public void insert(String word) {
            Node cur = root;
            int wordLen = word.length();
            for (int i = 0; i < wordLen; i++) {
                char c = word.charAt(i);
                if (cur.next.get(c) == null) {
                    cur.next.put(c, new Node());
                }
                cur = cur.next.get(c);
            }
            if (!cur.isWord) {
                cur.isWord = true;
            }
        }

        public boolean search(String word) {
            Node cur = root;
            int wordLen = word.length();
            for (int i = 0; i < wordLen; i++) {
                char c = word.charAt(i);
                if (cur.next.get(c) == null) {
                    return false;
                }
                cur = cur.next.get(c);
            }
            return cur.isWord;
        }

        public boolean startsWith(String prefix) {
            Node cur = root;
            int preLen = prefix.length();
            for (int i = 0; i < preLen; i++) {
                char c = prefix.charAt(i);
                if (cur.next.get(c) == null) {
                    return false;
                }
                cur = cur.next.get(c);
            }

            return true;
        }
    }
}
