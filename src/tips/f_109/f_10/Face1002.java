package tips.f_109.f_10;

import java.util.*;

/**
 * 编写一种方法，对字符串数组进行排序，将所有变位词组合在一起。
 * 变位词是指字母相同，但排列不同的字符串。
 * 注意：本题相对原题稍作修改
 * <p>示例:
 * 输入: ["eat", "tea", "tan", "ate", "nat", "bat"],
 * 输出:
 * [
 * ["ate","eat","tea"],
 * ["nat","tan"],
 * ["bat"]
 * ]
 * <p>说明：
 * 所有输入均为小写字母。
 * 不考虑答案输出的顺序。
 *
 * @author hc
 */
public class Face1002 {

    public List<List<String>> groupAnagrams(String[] strs) {

        List<List<String>> lists = new ArrayList<>();
        // 用质数表示26个字母，把字符串的各个字母相乘，这样可保证字母异位词的乘积必定是相等的
        int[] nums = {2, 3, 5, 7, 11, 13, 17, 19, 23, 29, 31, 37, 41, 43, 47, 53, 59, 61, 67, 71, 73, 79, 83, 89, 97, 101};
        Map<Long, List<String>> map = new HashMap<>();

        for (int i = 0; i < strs.length; i++) {
            long n = 1;
            for (char c : strs[i].toCharArray()) {
                n *= nums[c - 'a'];
            }

            if (map.containsKey(n)) {
                List<String> list = map.get(n);
                list.add(strs[i]);
                map.put(n, list);
            } else {
                List<String> list = new ArrayList<>();
                list.add(strs[i]);
                map.put(n, list);
            }
        }

        for (List<String> s : map.values()) {
            lists.add(s);
        }
        return lists;
    }

    public List<List<String>> groupAnagrams2(String[] strs) {

        List<List<String>> res = new ArrayList<>();
        Map<String, List<String>> map = new HashMap<>();
        int len = strs.length;

        for (int i = 0; i < len; i++) {
            char[] chars = strs[i].toCharArray();
            Arrays.sort(chars);
            String str = new String(chars);

            List<String> list;
            if (!map.containsKey(str)) {
                list = new ArrayList<>();
            } else {
                list = map.get(str);
            }
            list.add(strs[i]);
            map.put(str, list);
        }

        for (String c : map.keySet()) {
            res.add(map.get(c));
        }

        return res;
    }

    public static void main(String[] args) {
        System.out.println(new Face1002().groupAnagrams2(new String[]{"eat", "tea", "tan", "ate", "nat", "bat"}));
    }
}
