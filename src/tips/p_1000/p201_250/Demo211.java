package tips.p_1000.p201_250;

import java.util.TreeMap;

/**
 * 请你设计一个数据结构，支持 添加新单词 和 查找字符串是否与任何先前添加的字符串匹配 。
 * <p>
 * 实现词典类 WordDictionary ：
 * <p>
 * WordDictionary() 初始化词典对象
 * void addWord(word) 将 word 添加到数据结构中，之后可以对它进行匹配
 * bool search(word) 如果数据结构中存在字符串与 word 匹配，则返回 true ；否则，返回 false
 * word 中可能包含一些 '.' ，每个. 都可以表示任何一个字母。
 *
 * @author hc
 */
public class Demo211 {

    class WordDictionary {

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

        public WordDictionary() {
            root = new Node();
        }

        public void addWord(String word) {
            Node cur = root;
            for (int i = 0; i < word.length(); i++) {
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
            return match(root, word, 0);
        }

        private boolean match(Node node, String word, int index) {
            if (index == word.length()) {
                return node.isWord;
            }

            char c = word.charAt(index);
            if (c != '.') {
                if (node.next.get(c) == null) {
                    return false;
                }
                return match(node.next.get(c), word, index + 1);
            } else {
                for (char nextChar : node.next.keySet()) {
                    if (match(node.next.get(nextChar), word, index + 1)) {
                        return true;
                    }
                }
                return false;
            }
        }
    }
}
