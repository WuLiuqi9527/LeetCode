package problemset;

/**
 * 给你一个字符串 s 、一个字符串 t 。返回 s 中涵盖 t 所有字符的最小子串。
 * 如果 s 中不存在涵盖 t 所有字符的子串，则返回空字符串 "" 。
 * 注意：如果 s 中存在这样的子串，我们保证它是唯一的答案。
 * <p>
 * 示例 1：
 * 输入：s = "ADOBECODEBANC", t = "ABC"
 * 输出："BANC"
 * <p>
 * 示例 2：
 * 输入：s = "a", t = "a"
 * 输出："a"
 * <p>
 * 提示：
 * 1 <= s.length, t.length <= 105
 * s 和 t 由英文字母组成
 *
 * @author hc
 */
public class Demo76 {

    public String minWindow(String s, String t) {

        /**
         * 滑动窗口
         * 不要求顺序 出现频率 区分大小写
         */
        if (s == null || s.length() == 0 || t == null || t.length() == 0 || s.length() < t.length()) {
            return "";
        }

        String res = null;
        int[] need = new int[128], tMap = new int[128];
        char[] tChars = t.toCharArray(), sChars = s.toCharArray();
        for (int i = 0; i < tChars.length; i++) {
            need[tChars[i]]++;
            tMap[tChars[i]]++;
        }
        int left = 0, right = -1, needCount = tChars.length, min = Integer.MAX_VALUE;
        while (right + 1 < sChars.length) {

            if (need[sChars[++right]] > 0) {
                needCount--;
            }

            need[sChars[right]]--;

            // needCount == 0 已经包含所有的 t 字符
            while (needCount == 0) {

                // 更新 res min
                if (tMap[sChars[left]] > 0 && need[sChars[left]] == 0) {
                    if (right - left + 1 < min) {
                        min = right - left + 1;
                        res = s.substring(left, right + 1);
                    }
                    needCount++;
                }

                // left 收缩
                need[sChars[left++]]++;
            }
        }
        return res == null ? "" : res;
    }
}
