package tips.p_1000.p151_200;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * 给定一个字符串，逐个翻转字符串中的每个单词。
 * <p>
 * 说明：
 * 无空格字符构成一个 单词 。
 * 输入字符串可以在前面或者后面包含多余的空格，但是反转后的字符不能包括。
 * 如果两个单词间有多余的空格，将反转后单词间的空格减少到只含一个。
 * <p>
 * 示例 1：
 * 输入："the sky is blue"
 * 输出："blue is sky the"
 *
 * @author hc
 */
public class Demo151 {

    public String reverseWords(String s) {
        String[] strings = s.trim().split(" +");
        StringBuilder res = new StringBuilder();
        int len = strings.length;
        for (int i = len - 1; i >= 0; i--) {
            res.append(strings[i]);
            if (i == 0) {
                continue;
            }
            res.append(" ");
        }
        return res.toString();
    }

    /**
     * 双端指针
     */
    public String reverseWords2(String s) {
        int left = 0, right = s.length() - 1;
        while (left <= right && s.charAt(left) == ' ') {
            ++left;
        }
        while (left <= right && s.charAt(right) == ' ') {
            --right;
        }

        Deque<String> word = new ArrayDeque<>();
        StringBuilder sb = new StringBuilder();
        while (left <= right) {
            char ch = s.charAt(left);
            if (sb.length() != 0 && ch == ' ') {
                word.addFirst(sb.toString());
                sb.setLength(0);
            } else if (ch != ' ') {
                sb.append(ch);
            }
            ++left;
        }
        // 添加最后一个单词
        word.addFirst(sb.toString());
        return String.join(" ", word);
    }

    public String reverseWords3(String s) {
        StringBuilder sb = new StringBuilder();
        getReverseWords(s, sb, 0, false);
        return sb.toString();
    }

    private void getReverseWords(String s, StringBuilder sb, int start, boolean flag) {
        while (start < s.length() && s.charAt(start) == ' ') {
            ++start;
        }

        if (start == s.length()) {
            return;
        }

        int end = start;
        while (end < s.length() && s.charAt(end) != ' ') {
            ++end;
        }
        getReverseWords(s, sb, end, true);
        sb.append(s.substring(start, end));

        if (flag) {
            sb.append(' ');
        }
    }

    public static void main(String[] args) {
        System.out.println(new Demo151().reverseWords3("the sky is blue"));
        System.out.println(new Demo151().reverseWords3("  hello world!  "));
        System.out.println(new Demo151().reverseWords3("a good   example"));
        System.out.println(new Demo151().reverseWords3("  Bob    Loves  Alice   "));
    }
}
