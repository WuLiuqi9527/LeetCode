package tips.p_1000.p401_450;

/**
 * 统计字符串中的单词个数，这里的单词指的是连续的不是空格的字符。
 * 请注意，你可以假定字符串里不包括任何不可打印的字符。
 * <p>示例:
 * 输入: "Hello, my name is John"
 * 输出: 5
 * 解释: 这里的单词是指连续的不是空格的字符，所以 "Hello," 算作 1 个单词。
 *
 * @author hc
 */
public class Demo434 {

    public static int countSegments(String s) {
        return s.trim().length() == 0 ? 0 : s.trim().split("\\s+").length;
    }

    public static int countSegments2(String s) {
        int ans = 0;
        int i = 0;
        int n = s.length();
        while (i < n) {
            if (s.charAt(i) == ' ') {
                i++;
                continue;
            }
            while (i < n && s.charAt(i) != ' ') {
                i++;
            }
            ans++;
        }
        return ans;
    }

    public static void main(String[] args) {
        System.out.println(countSegments("Hello, my name is John"));
    }
}
