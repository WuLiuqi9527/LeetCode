package tip.p1_50;

import java.util.*;

/**
 * 给定一个字符串数组，将字母异位词组合在一起。字母异位词指字母相同，但排列不同的字符串。
 * <p>
 * 示例:
 * 输入: ["eat", "tea", "tan", "ate", "nat", "bat"]
 * 输出:
 * [
 * ["ate","eat","tea"],
 * ["nat","tan"],
 * ["bat"]
 * ]
 * <p>
 * 说明：
 * 所有输入均为小写字母。
 * 不考虑答案输出的顺序。
 *
 * @author hc
 */
public class Demo49 {

    public List<List<String>> groupAnagrams(String[] strs) {

        List<List<String>> lists = new ArrayList<>();

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

    public static void main(String[] args) {
        System.out.println(new Demo49().groupAnagrams(new String[]{"eat", "tea", "tan", "ate", "nat", "bat"}));
    }
}
