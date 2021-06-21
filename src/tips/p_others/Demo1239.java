package tips.p_others;

import java.util.ArrayList;
import java.util.List;

/**
 * 给定一个字符串数组 arr，字符串 s 是将 arr 某一子序列字符串连接所得的字符串，
 * 如果 s 中的每一个字符都只出现过一次，那么它就是一个可行解。
 * 请返回所有可行解 s 中最长长度。
 * <p>示例 1：
 * 输入：arr = ["un","iq","ue"]
 * 输出：4
 * 解释：所有可能的串联组合是 "","un","iq","ue","uniq" 和 "ique"，最大长度为 4。
 * <p>示例 2：
 * 输入：arr = ["cha","r","act","ers"]
 * 输出：6
 * 解释：可能的解答有 "chaers" 和 "acters"。
 * <p>示例 3：
 * 输入：arr = ["abcdefghijklmnopqrstuvwxyz"]
 * 输出：26
 * <p>提示：
 * 1 <= arr.length <= 16
 * 1 <= arr[i].length <= 26
 * arr[i] 中只含有小写英文字母
 *
 * @author hc
 */
public class Demo1239 {

    /**
     * 子序列字符串 可以跳过 回溯
     */
    private int res;

    public int maxLength(List<String> arr) {
        dfs(arr, 0, new StringBuilder());
        return res;
    }

    private void dfs(List<String> arr, int start, StringBuilder sb) {
        if (!check(sb)) {
            return;
        }

        res = Math.max(res, sb.length());
        int size = arr.size();
        for (int i = start; i < size; i++) {
            String s = arr.get(i);
            sb.append(s);
            dfs(arr, i + 1, sb);
            sb.delete(sb.length() - s.length(), sb.length());
        }
    }

    private boolean check(StringBuilder sb) {
        int len = sb.length();
        int[] arr = new int[26];
        for (int i = 0; i < len; i++) {
            int index = sb.charAt(i) - 'a';
            ++arr[index];
            if (arr[index] > 1) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        List<String> list = new ArrayList<>();
        list.add("a");
        list.add("b");
        list.add("c");
        list.add("d");
        list.add("e");
        list.add("f");
        list.add("j");
        System.out.println(new Demo1239().maxLength(list));
    }
}
