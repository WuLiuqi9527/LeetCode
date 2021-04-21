package o51_100;

/**
 * 字符串的左旋转操作是把字符串前面的若干个字符转移到字符串的尾部。
 * 请定义一个函数实现字符串左旋转操作的功能。
 * 比如，输入字符串"abcdefg"和数字2，该函数将返回左旋转两位得到的结果"cdefgab"。
 * <p>示例 1：
 * 输入: s = "abcdefg", k = 2
 * 输出: "cdefgab"
 * <p>示例 2：
 * 输入: s = "lrloseumgh", k = 6
 * 输出: "umghlrlose"
 * <p>限制：
 * 1 <= k < s.length <= 10000
 *
 * @author hc
 */
public class Offer58Two {

    public String reverseLeftWords(String s, int n) {

        StringBuilder sb = new StringBuilder();
        int len = s.length();
        for (int i = n; i < len; i++) {
            sb.append(s.charAt(i));
        }
        for (int i = 0; i < n; i++) {
            sb.append(s.charAt(i));
        }
        return sb.toString();
    }

    public String reverseLeftWords2(String s, int n) {
        return s.substring(n) + s.substring(0, n);
    }

    public static void main(String[] args) {
        System.out.println(new Offer58Two().reverseLeftWords("lrloseumgh", 6));
        System.out.println(new Offer58Two().reverseLeftWords("abcdefg", 2));
    }
}
