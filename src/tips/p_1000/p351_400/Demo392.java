package tips.p_1000.p351_400;

/**
 * 给定字符串 s 和 t ，判断 s 是否为 t 的子序列。
 * 字符串的一个子序列是原始字符串删除一些（也可以不删除）字符而不改变剩余字符相对位置形成的新字符串。
 * 例如，"ace" 是 "abcde" 的一个子序列，而 "aec" 不是。
 *
 * @author hc
 */
public class Demo392 {

    public boolean isSubsequence(String s, String t) {
        int si = 0, ti = 0;
        while (si < s.length() && ti < t.length()) {
            if (s.charAt(si) == t.charAt(ti)) {
                ++si;
            }
            ++ti;
        }
        return si == s.length();
    }

    public boolean isSubsequence2(String s, String t) {
        int index = -1;
        for (char c : s.toCharArray()) {
            if (t.indexOf(c, index + 1) == -1) {
                return false;
            }
            index = t.indexOf(c, index + 1);
        }
        return true;
    }
}
