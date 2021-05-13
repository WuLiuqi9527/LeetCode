package tips.f_109;

/**
 * URL化。编写一种方法，将字符串中的空格全部替换为%20。
 * 假定该字符串尾部有足够的空间存放新增字符，并且知道字符串的“真实”长度。
 * （注：用Java实现的话，请使用字符数组实现，以便直接在数组上操作。）
 * <p>示例 1：
 * 输入："Mr John Smith    ", 13
 * 输出："Mr%20John%20Smith"
 * <p>示例 2：
 * 输入："               ", 5
 * 输出："%20%20%20%20%20"
 * <p>提示：
 * 字符串长度在 [0, 500000] 范围内。
 *
 * @author hc
 */
public class Face0103 {

    public String replaceSpaces(String S, int length) {
        int len = S.length(), index = 0;
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < len; i++) {
            if (index == length) {
                break;
            }
            char c = S.charAt(i);
            if (c == ' ') {
                sb.append("%20");
                ++index;
                continue;
            }
            sb.append(c);
            ++index;
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        System.out.println(new Face0103().replaceSpaces("Mr John Smith ", 13));
        System.out.println(new Face0103().replaceSpaces("               ", 5));
    }
}
