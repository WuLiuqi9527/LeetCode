package tips.p_1000.p501_550;

import java.util.Collections;
import java.util.List;

/**
 * 给你一个字符串 s 和一个字符串数组 dictionary 作为字典，找出并返回字典中最长的字符串，
 * 该字符串可以通过删除 s 中的某些字符得到。
 * 如果答案不止一个，返回长度最长且字典序最小的字符串。如果答案不存在，则返回空字符串。
 * <p>示例 1：
 * 输入：s = "abpcplea", dictionary = ["ale","apple","monkey","plea"]
 * 输出："apple"
 * <p>示例 2：
 * 输入：s = "abpcplea", dictionary = ["a","b","c"]
 * 输出："a"
 * <p>提示：
 * 1 <= s.length <= 1000
 * 1 <= dictionary.length <= 1000
 * 1 <= dictionary[i].length <= 1000
 * s 和 dictionary[i] 仅由小写英文字母组成
 *
 * @author hc
 */
public class Demo524 {

    public String findLongestWord(String s, List<String> dictionary) {
        Collections.sort(dictionary, (o1, o2) -> o1.length() != o2.length() ? o2.length() - o1.length() : o1.compareTo(o2));
        int n = s.length();
        for (String d : dictionary) {
            int m = d.length();
            int i = 0, j = 0;
            while (i < n && j < m) {
                if (s.charAt(i) == d.charAt(j)) {
                    ++j;
                }
                ++i;
            }
            if (j == m) {
                return d;
            }
        }
        return "";
    }
}
