package tips.p_1000.p301_350;

import java.util.HashSet;

/**
 * 编写一个函数，以字符串作为输入，反转该字符串中的元音字母。
 * <p>示例 1：
 * 输入："hello"
 * 输出："holle"
 * <p>示例 2：
 * 输入："leetcode"
 * 输出："leotcede"
 *
 * @author hc
 */
public class Demo345 {

    static char[] keys = new char[]{'a', 'e', 'i', 'o', 'u'};
    static HashSet<Character> set = new HashSet<>();

    static {
        for (char key : keys) {
            set.add(key);
            set.add(Character.toUpperCase(key));
        }
    }

    public String reverseVowels(String s) {
        char[] chars = s.toCharArray();
        int n = s.length();
        int l = 0, r = n - 1;
        while (l < r) {
            if (set.contains(chars[l]) && set.contains(chars[r])) {
                swap(chars, l++, r--);
            } else {
                if (!set.contains(chars[l])) {
                    l++;
                }
                if (!set.contains(chars[r])) {
                    r--;
                }
            }
        }
        return String.valueOf(chars);
    }

    void swap(char[] chars, int l, int r) {
        char c = chars[l];
        chars[l] = chars[r];
        chars[r] = c;
    }

    public static void main(String[] args) {
        System.out.println(new Demo345().reverseVowels("leetcode"));
        System.out.println(new Demo345().reverseVowels("hello"));
    }
}
