package tips.f_109.f_10;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 有重复字符串的排列组合。编写一种方法，计算某字符串的所有排列组合。
 * <p>示例 1:
 * 输入：S = "qqe"
 * 输出：["eqq","qeq","qqe"]
 * <p>示例 2:
 * 输入：S = "ab"
 * 输出：["ab", "ba"]
 * <p>提示:
 * 字符都是英文字母。
 * 字符串长度在[1, 9]之间。
 *
 * @author hc
 */
public class Face0808 {

    private List<String> list;

    public String[] permutation(String S) {
        list = new ArrayList<>();
        char[] chars = S.toCharArray();
        Arrays.sort(chars);
        boolean[] used = new boolean[chars.length];
        dfs(chars, used, new StringBuilder());
        String[] res = new String[list.size()];
        for (int i = 0; i < list.size(); i++) {
            res[i] = list.get(i);
        }
        return res;
    }

    private void dfs(char[] chars, boolean[] used, StringBuilder sb) {
        if (sb.length() == chars.length) {
            list.add(sb.toString());
            return;
        }

        for (int i = 0; i < chars.length; i++) {
            if (used[i]) {
                continue;
            }
            if (i > 0 && chars[i] == chars[i - 1] && used[i - 1]) {
                continue;
            }

            sb.append(chars[i]);
            used[i] = true;
            dfs(chars, used, sb);
            used[i] = false;
            sb.setLength(sb.length() - 1);
        }
    }

    public static void main(String[] args) {
        System.out.println(new Face0808().permutation("qqe"));
    }
}
