package tips.f_109.f_10;

/**
 * 字符串压缩。利用字符重复出现的次数，编写一种方法，实现基本的字符串压缩功能。比如，字符串aabcccccaaa会变为a2b1c5a3。若“压缩”后的字符串没有变短，则返回原先的字符串。你可以假设字符串中只包含大小写英文字母（a至z）。
 * <p>示例1:
 * 输入："aabcccccaaa"
 * 输出："a2b1c5a3"
 * <p>示例2:
 * 输入："abbccd"
 * 输出："abbccd"
 * 解释："abbccd"压缩后为"a1b2c2d1"，比原字符串长度更长。
 * <p>提示：
 * 字符串长度在[0, 50000]范围内。
 *
 * @author hc
 */
public class Face0106 {

    public String compressString(String S) {

        if (S.length() <= 2) {
            return S;
        }

        int index = 1, len = S.length();
        StringBuilder sb = new StringBuilder();

        char tem = S.charAt(0);
        for (int i = 1; i < len; i++) {
            if (tem == S.charAt(i)) {
                ++index;
            } else {
                sb.append(tem + String.valueOf(index));
                tem = S.charAt(i);
                index = 1;
            }
        }
        sb.append(tem + String.valueOf(index));
        return len <= sb.length() ? S : sb.toString();
    }

    /**
     * 快慢指针
     */
    public String compressString2(String S) {
        if (S.length() <= 2) {
            return S;
        }

        StringBuilder sb = new StringBuilder();
        int slow = 0, fast = 0, len = S.length();
        while (fast < len) {
            if (S.charAt(fast) != S.charAt(slow)) {
                sb.append(S.charAt(slow)).append(fast - slow);
                slow = fast;
            }
            ++fast;
        }
        sb.append(S.charAt(slow)).append(fast - slow);
        return len <= sb.length() ? S : sb.toString();
    }

    public static void main(String[] args) {
        System.out.println(new Face0106().compressString2("aabcccccaaa"));
        System.out.println(new Face0106().compressString2("abbccd"));
        System.out.println(new Face0106().compressString2("bbbac"));
    }
}
