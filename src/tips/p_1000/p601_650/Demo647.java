package tips.p_1000.p601_650;

/**
 * 给定一个字符串，你的任务是计算这个字符串中有多少个回文子串。
 * 具有不同开始位置或结束位置的子串，即使是由相同的字符组成，也会被视作不同的子串。
 * <p>示例 1：
 * 输入："abc"
 * 输出：3
 * 解释：三个回文子串: "a", "b", "c"
 * <p>示例 2：
 * 输入："aaa"
 * 输出：6
 * 解释：6个回文子串: "a", "a", "a", "aa", "aa", "aaa"
 * <p>提示：
 * 输入的字符串长度不会超过 1000 。
 *
 * @author hc
 */
public class Demo647 {

    public int countSubstrings(String s) {
        char[] chars = s.toCharArray();
        int res = 0, len = chars.length;
        for (int i = 0; i < len; i++) {
            // 从一个字母开始扩散寻找
            res += count(chars, i, i);
            // 两个
            res += count(chars, i, i + 1);
        }
        return res;
    }

    private int count(char[] chars, int start, int end) {
        int res = 0;
        while (start >= 0 && end < chars.length && chars[start] == chars[end]) {
            --start;
            ++end;
            ++res;
        }
        return res;
    }
}
