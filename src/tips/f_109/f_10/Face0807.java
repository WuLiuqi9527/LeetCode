package tips.f_109.f_10;

import java.util.ArrayList;
import java.util.List;

/**
 * 无重复字符串的排列组合。
 * 编写一种方法，计算某字符串的所有排列组合，字符串每个字符均不相同。
 * <p>示例1:
 * 输入：S = "qwe"
 * 输出：["qwe", "qew", "wqe", "weq", "ewq", "eqw"]
 * <p>示例2:
 * 输入：S = "ab"
 * 输出：["ab", "ba"]
 * <p>提示:
 * 字符都是英文字母。
 * 字符串长度在[1, 9]之间。
 *
 * @author hc
 */
public class Face0807 {

    List<String> list;

    public String[] permutation(String S) {
        list = new ArrayList<>();
        char[] ch = S.toCharArray();
        boolean[] used = new boolean[ch.length];
        dfs(ch, used, new StringBuilder());

        int size = list.size();
        String[] res = new String[size];
        for (int i = 0; i < size; i++) {
            res[i] = list.get(i);
        }
        return res;
    }

    private void dfs(char[] ch, boolean[] used, StringBuilder sb) {
        if (sb.length() == ch.length) {
            list.add(sb.toString());
            return;
        }

        int len = ch.length;
        for (int i = 0; i < len; i++) {
            if (used[i]) {
                continue;
            }
            sb.append(ch[i]);
            used[i] = true;
            dfs(ch, used, sb);
            used[i] = false;
            sb.setLength(sb.length() - 1);
        }
    }
}
