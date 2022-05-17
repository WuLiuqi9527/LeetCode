package tips.p_1000.p951_1000;

import java.util.HashMap;
import java.util.Map;

/**
 * 某种外星语也使用英文小写字母，但可能顺序 order 不同。字母表的顺序（order）是一些小写字母的排列。
 * 给定一组用外星语书写的单词 words，以及其字母表的顺序 order，只有当给定的单词在这种外星语中按字典序排列时，返回 true；否则，返回 false。
 * <p>示例 1：
 * 输入：words = ["hello","leetcode"], order = "hlabcdefgijkmnopqrstuvwxyz"
 * 输出：true
 * 解释：在该语言的字母表中，'h' 位于 'l' 之前，所以单词序列是按字典序排列的。
 * <p>示例 2：
 * 输入：words = ["word","world","row"], order = "worldabcefghijkmnpqstuvxyz"
 * 输出：false
 * 解释：在该语言的字母表中，'d' 位于 'l' 之后，那么 words[0] > words[1]，因此单词序列不是按字典序排列的。
 * <p>示例 3：
 * 输入：words = ["apple","app"], order = "abcdefghijklmnopqrstuvwxyz"
 * 输出：false
 * 解释：当前三个字符 "app" 匹配时，第二个字符串相对短一些，然后根据词典编纂规则 "apple" > "app"，因为 'l' > '∅'，其中 '∅' 是空白字符，定义为比任何其他字符都小（更多信息）。
 * <p>提示：
 * 1 <= words.length <= 100
 * 1 <= words[i].length <= 20
 * order.length == 26
 * 在 words[i] 和 order 中的所有字符都是英文小写字母。
 *
 * @author hc
 */
public class Demo953 {

    public static boolean isAlienSorted(String[] words, String order) {
        int[] map = new int[26];
        for (int i = 0; i < 26; i++) {
            map[order.charAt(i) - 'a'] = i;
        }
        int len = words.length;
        String[] transWords = new String[len];
        for (int i = 0; i < len; i++) {
            StringBuilder sb = new StringBuilder();
            for (char c : words[i].toCharArray()) {
                sb.append((char) ('a' + map[c - 'a']));
            }
            transWords[i] = sb.toString();
        }
        for (int i = 1; i < len; i++) {
            if (transWords[i - 1].compareTo(transWords[i]) > 0) {
                return false;
            }
        }
        return true;
    }

    public static boolean isAlienSorted2(String[] words, String order) {
        int len = words.length;
        if (len <= 1) {
            return true;
        }
        int[] map = new int[26];
        for (int i = 0; i < 26; i++) {
            map[order.charAt(i) - 'a'] = i;
        }
        for (int i = 1; i < len; i++) {
            if (compareTo(map, words[i - 1], words[i]) > 0) {
                return false;
            }
        }
        return true;
    }

    private static int compareTo(int[] map, String s1, String s2) {
        int n1 = s1.length(), n2 = s2.length();
        int min = Math.min(n1, n2);
        for (int i = 0; i < min; i++) {
            char c1 = s1.charAt(i);
            char c2 = s2.charAt(i);
            if (c1 != c2) {
                return map[c1 - 'a'] - map[c2 - 'a'];
            }
        }
        return n1 - n2;
    }

    public static void main(String[] args) {
        System.out.println(isAlienSorted(new String[]{"hello", "leetcode"}, "hlabcdefgijkmnopqrstuvwxyz"));
        System.out.println(isAlienSorted(new String[]{"word", "world", "row"}, "worldabcefghijkmnpqstuvxyz"));
        System.out.println(isAlienSorted(new String[]{"apple", "app"}, "abcdefghijklmnopqrstuvwxyz"));
    }
}
