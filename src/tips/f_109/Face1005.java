package tips.f_109;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 稀疏数组搜索。有个排好序的字符串数组，其中散布着一些空字符串，编写一种方法，找出给定字符串的位置。
 * <p>示例1:
 * 输入: words = ["at", "", "", "", "ball", "", "", "car", "", "","dad", "", ""], s = "ta"
 * 输出：-1
 * 说明: 不存在返回-1。
 * <p>示例2:
 * 输入：words = ["at", "", "", "", "ball", "", "", "car", "", "","dad", "", ""], s = "ball"
 * 输出：4
 * <p>提示:
 * words的长度在[1, 1000000]之间
 *
 * @author hc
 */
public class Face1005 {

    public int findString(String[] words, String s) {

        // 未利用 排好序 条件
        int res = -1;
        Map<String, List<Integer>> map = new HashMap<>();
        for (int i = 0; i < words.length; i++) {
            if (!map.containsKey(words[i])) {
                List<Integer> list = new ArrayList<>();
                list.add(i);
                map.put(words[i], list);
            } else {
                map.get(words[i]).add(i);
            }
        }

        if (map.get(s) != null) {
            res = map.get(s).get(0);
        }

        return res;
    }

    public int findString2(String[] words, String s) {
        for (int i = 0; i < words.length; i++) {
            if (words[i].length() != s.length()) {
                continue;
            }
            if (words[i].equals(s)) {
                return i;
            }
        }
        return -1;
    }

    public int findString3(String[] words, String s) {
        if (words.length <= 0 || s == null || s.isEmpty()) {
            return -1;
        }
        return findHelper(words, s, 0, words.length - 1);
    }

    private int findHelper(String[] words, String s, int l, int r) {

        if (l > r) {
            return -1;
        }

        // 计算中间位mid，但是mid位的字符串可能为空
        int mid = l + (r - l) / 2;
        // 处理空字符串，双指针向两边查找最近的不为空字符串，不能超过当前区间
        if (words[mid].isEmpty()) {
            int left = mid - 1;
            int right = mid + 1;
            while (true) {
                if (left < l && right > r) {
                    return -1;
                } else if (l <= left && !words[left].isEmpty()) {
                    mid = left;
                    break;
                } else if (right <= r && !words[right].isEmpty()) {
                    mid = right;
                    break;
                }
                left--;
                right++;
            }
        }

        // 递归二分查找
        if (words[mid].equals(s)) {
            return mid;
        } else if (words[mid].compareTo(s) > 0) {
            return findHelper(words, s, l, mid - 1);
        } else {
            return findHelper(words, s, mid + 1, r);
        }
    }
}
