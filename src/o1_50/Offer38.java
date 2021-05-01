package o1_50;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * 输入一个字符串，打印出该字符串中字符的所有排列。
 * 你可以以任意顺序返回这个字符串数组，但里面不能有重复元素。
 * <p>示例:
 * 输入：s = "abc"
 * 输出：["abc","acb","bac","bca","cab","cba"]
 * <p>限制：
 * 1 <= s 的长度 <= 8
 *
 * @author hc
 */
public class Offer38 {

    Set<String> list;
    StringBuilder sb;

    public String[] permutation(String s) {
        list = new HashSet<>();
        sb = new StringBuilder();
        boolean[] used = new boolean[s.length()];
        dfs(s, used);
        return list.toArray(new String[0]);
    }

    private void dfs(String s, boolean[] used) {
        if (s.length() == sb.length()) {
            list.add(sb.toString());
            return;
        }

        int len = s.length();
        for (int i = 0; i < len; i++) {

            if (used[i]) {
                continue;
            }

            used[i] = true;
            sb.append(s.charAt(i));
            dfs(s, used);
            sb.setLength(sb.length() - 1);
            used[i] = false;
        }
    }
}
