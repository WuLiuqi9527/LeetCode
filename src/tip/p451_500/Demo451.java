package tip.p451_500;

import java.util.*;

/**
 * 给定一个字符串，请将字符串里的字符按照出现的频率降序排列。
 * <p>
 * 示例 1:
 * 输入: "tree"
 * 输出: "eert"
 * <p>
 * 解释:
 * 'e'出现两次，'r'和't'都只出现一次。
 * 因此'e'必须出现在'r'和't'之前。此外，"eetr"也是一个有效的答案。
 *
 * @author hc
 */
public class Demo451 {

    public String frequencySort(String s) {

        // <字符， 出现的次数>
        Map<Character, Integer> map = new TreeMap<>();
        for (char c : s.toCharArray()) {
            map.put(c, map.getOrDefault(c, 0) + 1);
        }

        List<Map.Entry<Character, Integer>> entryList = new ArrayList<>();
        entryList.addAll(map.entrySet());
        Collections.sort(entryList, ((o1, o2) -> o2.getValue() - o1.getValue()));

        StringBuilder strBuilder = new StringBuilder();
        for (Map.Entry<Character,Integer> entry:entryList){
            for (int i = 0; i < entry.getValue(); i++) {
                strBuilder.append(entry.getKey());
            }
        }

        return strBuilder.toString();
    }

    public static void main(String[] args) {
        System.out.println(new Demo451().frequencySort(new String("tree")));
    }
}
