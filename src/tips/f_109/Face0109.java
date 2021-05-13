package tips.f_109;

/**
 * 字符串轮转。给定两个字符串s1和s2，请编写代码检查s2是否为s1旋转而成
 * （比如，waterbottle是erbottlewat旋转后的字符串）。
 * <p>示例1:
 * 输入：s1 = "waterbottle", s2 = "erbottlewat"
 * 输出：True
 * <p>示例2:
 * 输入：s1 = "aa", s2 = "aba"
 * 输出：False
 * <p>提示：
 * 字符串长度在[0, 100000]范围内。
 * 说明:
 * 你能只调用一次检查子串的方法吗？
 *
 * @author hc
 */
public class Face0109 {

    public boolean isFlipedString(String s1, String s2) {
        if (s1.length() == 0 && s2.length() == 0) {
            return true;
        }
        if (s1.length() != s2.length()) {
            return false;
        }
        int len = s1.length();
        for (int i = 0; i < len; i++) {
            String tem = s1.substring(i) + s1.substring(0, i);
            if (tem.equals(s2)) {
                return true;
            }
        }
        return false;
    }

    public boolean isFlipedString2(String s1, String s2) {
        if (s1.length() != s2.length()) {
            return false;
        }
        String ss = s2 + s2;
        return ss.contains(s1);
    }

        public static void main(String[] args) {
        System.out.println(new Face0109().isFlipedString("waterbottle", "erbottlewat"));
    }
}
