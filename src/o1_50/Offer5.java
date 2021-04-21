package o1_50;

/**
 * 请实现一个函数，把字符串 s 中的每个空格替换成"%20"。
 * <p>示例 1：
 * 输入：s = "We are happy."
 * 输出："We%20are%20happy."
 * <p>限制：
 * 0 <= s 的长度 <= 10000
 *
 * @author hc
 */
public class Offer5 {

    public String replaceSpace(String s) {
        return s.replace(" ", "%20");
    }

    public String replaceSpace2(String s) {
        int len = s.length();
        if (s == null || len <= 0) {
            return s;
        }
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < len; i++) {
            char ch = s.charAt(i);
            if (ch != ' ') {
                sb.append(ch);
            }else {
                sb.append("%20");
            }
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        System.out.println(new Offer5().replaceSpace2("We are happy."));
    }
}
