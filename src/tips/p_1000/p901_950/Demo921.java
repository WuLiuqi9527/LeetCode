package tips.p_1000.p901_950;

/**
 * 只有满足下面几点之一，括号字符串才是有效的：
 * 它是一个空字符串，或者
 * 它可以被写成 AB （A 与 B 连接）, 其中 A 和 B 都是有效字符串，或者
 * 它可以被写作 (A)，其中 A 是有效字符串。
 * 给定一个括号字符串 s ，移动N次，你就可以在字符串的任何位置插入一个括号。
 * 例如，如果 s = "()))" ，你可以插入一个开始括号为 "(()))" 或结束括号为 "())))" 。
 * 返回 为使结果字符串 s 有效而必须添加的最少括号数。
 * <p>示例 1：
 * 输入：s = "())"
 * 输出：1
 * <p>示例 2：
 * 输入：s = "((("
 * 输出：3
 * <p>提示：
 * 1 <= s.length <= 1000
 * s 只包含 '(' 和 ')' 字符。
 */
public class Demo921 {

    public static int minAddToMakeValid(String s) {
        int score = 0, ans = 0;
        for (char c : s.toCharArray()) {
            score += c == '(' ? 1 : -1;
            if (score < 0) {
                score = 0;
                ans++;
            }
        }
        return score + ans;
    }

    public static void main(String[] args) {
        System.out.println(Demo921.minAddToMakeValid("()))(("));
        System.out.println(Demo921.minAddToMakeValid("())"));
        System.out.println(Demo921.minAddToMakeValid(")))"));
    }
}
