package tips.p_1000.p651_700;

/**
 * 给定一个只包含三种字符的字符串：（ ，） 和 *，
 * 写一个函数来检验这个字符串是否为有效字符串。有效字符串具有如下规则：
 * 任何左括号 ( 必须有相应的右括号 )。
 * 任何右括号 ) 必须有相应的左括号 ( 。
 * 左括号 ( 必须在对应的右括号之前 )。
 * * 可以被视为单个右括号 ) ，或单个左括号 ( ，或一个空字符串。
 * 一个空字符串也被视为有效字符串。
 * <p>示例 1:
 * 输入: "()"
 * 输出: True
 * <p>示例 2:
 * 输入: "(*)"
 * 输出: True
 * <p>示例 3:
 * 输入: "(*))"
 * 输出: True
 * 注意:
 * <p>字符串大小将在 [1，100] 范围内。
 *
 * @author hc
 */
public class Demo678 {

    public boolean checkValidString(String s) {
        int l = 0, r = 0;
        int n = s.length();
        for (int i = 0; i < n; ++i) {
            l += s.charAt(i) == ')' ? -1 : 1;
            r += s.charAt(n - 1 - i) == '(' ? -1 : 1;
            if (l < 0 || r < 0) {
                return false;
            }
        }
        return true;
    }

    public boolean checkValidString2(String s) {
        int l = 0, r = 0;
        for (char c : s.toCharArray()) {
            if (c == '(') {
                ++l;++r;
            }else if (c == ')') {
                --l;--r;
            }else {
                --l;++r;
            }
            l = Math.max(l, 0);
            if (l > r) {
                return false;
            }
        }
        return l == 0;
    }

    public static void main(String[] args) {
        System.out.println(new Demo678().checkValidString("()"));
        System.out.println(new Demo678().checkValidString("(*)"));
        System.out.println(new Demo678().checkValidString("(*))"));
    }
}
