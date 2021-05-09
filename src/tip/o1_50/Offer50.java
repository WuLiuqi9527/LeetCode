package tip.o1_50;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 在字符串 s 中找出第一个只出现一次的字符。如果没有，返回一个单空格。 s 只包含小写字母。
 * <p>示例:
 * s = "abaccdeff"
 * 返回 "b"
 * <p>s = ""
 * 返回 " "
 * <p>限制：
 * 0 <= s 的长度 <= 50000
 *
 * @author hc
 */
public class Offer50 {

    public char firstUniqChar(String s) {

        if (s == null || s.length() == 0) {
            return ' ';
        }
        boolean[] used = new boolean[26];
        Queue<Character> queue = new LinkedList<>();
        int len = s.length();
        for (int i = 0; i < len; i++) {
            char ch = s.charAt(i);
            if (!used[ch - 'a']) {
                if (queue.contains(ch)) {
                    queue.remove(ch);
                    used[ch - 'a'] = true;
                } else {
                    queue.add(ch);
                }
            }
        }
        if (queue.isEmpty()) {
            return ' ';
        }
        return queue.poll();
    }
}
