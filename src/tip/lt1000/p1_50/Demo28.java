package tip.lt1000.p1_50;

/**
 * 实现 strStr() 函数。
 * 给定一个 haystack 字符串和一个 needle 字符串，
 * 在 haystack 字符串中找出 needle 字符串出现的第一个位置 (从0开始)。如果不存在，则返回 -1。
 * <p>
 * 示例 1:
 * 输入: haystack = "hello", needle = "ll"
 * 输出: 2
 * <p>
 * 示例 2:
 * 输入: haystack = "aaaaa", needle = "bba"
 * 输出: -1
 *
 * @author hc
 */
public class Demo28 {

    public int strStr(String haystack, String needle) {

        if (haystack.length() < needle.length()) {
            return -1;
        }

        int res = 0;
        while (haystack.length() > needle.length()) {
            if (haystack.startsWith(needle)) {
                break;
            } else {
                ++res;
                haystack = haystack.substring(1);
            }
        }

        if (!haystack.startsWith(needle)) {
            return -1;
        }
        return res;
    }

    public static void main(String[] args) {
        System.out.println(new Demo28().strStr("hello", "ll"));
        System.out.println(new Demo28().strStr("aaaaa", "bba"));
        System.out.println(new Demo28().strStr("", ""));
    }
}
