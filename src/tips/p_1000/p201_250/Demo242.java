package tips.p_1000.p201_250;

/**
 * 给定两个字符串 s 和 t ，编写一个函数来判断 t 是否是 s 的字母异位词。
 * <p>
 * 示例 1:
 * 输入: s = "anagram", t = "nagaram"
 * 输出: true
 * <p>
 * 示例 2:
 * 输入: s = "rat", t = "car"
 * 输出: false
 *
 * @author hc
 */
public class Demo242 {

    public boolean isAnagram(String s, String t) {

        /**
         * 哈希表
         */
//        if (s.length() != t.length()) {
//            return false;
//        }
//
//        Map<Character, Integer> sMap = new HashMap<>(26);
//
//        for (char c : s.toCharArray()) {
//            sMap.put(c, sMap.getOrDefault(c, 0) + 1);
//        }
//        for (char c : t.toCharArray()) {
//            sMap.put(c, sMap.getOrDefault(c, 0) - 1);
//            if (sMap.get(c) < 0) {
//                return false;
//            }
//        }
//        return true;


        /**
         * 出现频率 数组
         */
        if (s.length() != t.length()) {
            return false;
        }

        int[] freqS = new int[26];

        for (char c : s.toCharArray()) {
            freqS[c - 'a']++;
        }
        for (char c : t.toCharArray()) {
            freqS[c - 'a']--;
        }

        int count = 0;
        for (int i = 0; i < freqS.length; i++) {
            if (freqS[i] == 0) {
                count++;
            }
        }
        if (count == freqS.length) {
            return true;
        }

        return false;
    }

    public static void main(String[] args) {
        System.out.println(new Demo242().isAnagram(new String("anagram"), new String("nagaram")));
    }
}
