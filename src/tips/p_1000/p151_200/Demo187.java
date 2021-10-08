package tips.p_1000.p151_200;

import java.util.*;

/**
 * 所有 DNA 都由一系列缩写为 'A'，'C'，'G' 和 'T' 的核苷酸组成，例如："ACGAATTCCG"。
 * 在研究 DNA 时，识别 DNA 中的重复序列有时会对研究非常有帮助。
 * 编写一个函数来找出所有目标子串，目标子串的长度为 10，且在 DNA 字符串 s 中出现次数超过一次。
 *
 * <p>示例 1：
 * 输入：s = "AAAAACCCCCAAAAACCCCCCAAAAAGGGTTT"
 * 输出：["AAAAACCCCC","CCCCCAAAAA"]
 * <p>示例 2：
 * 输入：s = "AAAAAAAAAAAAA"
 * 输出：["AAAAAAAAAA"]
 *
 * <p>提示：
 * 0 <= s.length <= 105
 * s[i] 为 'A'、'C'、'G' 或 'T'
 *
 * @author hc
 */
public class Demo187 {

    /**
     * 一个 DNA 序列，从任意位置开始的连续 10 个字母当做一组，将重复的组输出。
     */
    public List<String> findRepeatedDnaSequences(String s) {
        int len = s.length();
        Set<String> res = new HashSet<>();
        for (int i = 0; i <= len - 10; i++) {
            for (int j = i + 1; j <= len - 10; j++) {
                if (s.substring(i, i + 10).equals(s.substring(j, j + 10))) {
                    res.add(s.substring(i, i + 10));
                    break;
                }
            }
        }
        return new ArrayList<>(res);
    }

    public List<String> findRepeatedDnaSequences2(String s) {
        List<String> ans = new ArrayList<>();
        HashMap<String, Integer> map = new HashMap<>();
        for (int i = 0; i <= s.length() - 10; i++) {
            String str = s.substring(i, i + 10);
            map.put(str, map.getOrDefault(str, 0) + 1);
        }
        for (String str : map.keySet()) {
            if (map.get(str) > 1) {
                ans.add(str);
            }
        }
        return ans;
    }

    /**
     * 'A' -> 00
     * 'C' -> 01
     * 'G' -> 10
     * 'T' -> 11
     */
    public List<String> findRepeatedDnaSequences3(String s) {
        int len = s.length();
        if (len < 10) {
            return new ArrayList<>();
        }
        Set<String> res = new HashSet<>();
        Set<Integer> set = new HashSet<>();
        char[] map = new char[26];
        map['A' - 'A'] = 0;
        map['C' - 'A'] = 1;
        map['G' - 'A'] = 2;
        map['T' - 'A'] = 3;
        int key = 0;
        // 第一组单独初始化出来
        for (int i = 0; i < 10; i++) {
            key = key << 2 | map[s.charAt(i) - 'A'];
        }
        set.add(key);

        for (int i = 10; i < len; i++) {
            key = key << 2 | map[s.charAt(i) - 'A'];
            // 2 * 10 取后二十位 & 0xfffff
            key &= 0xfffff;
            if (set.contains(key)) {
                res.add(s.substring(i - 9, i + 1));
            } else {
                set.add(key);
            }
        }
        return new ArrayList<>(res);
    }

    /**
     * 利用 ACSII 表自带映射关系 节省 char[] 数组
     * 'A' -> 65 1000 001
     * 'C' -> 67 1000 011
     * 'G' -> 71 1000 111
     * 'T' -> 84 1010 100
     * 取后三位已经能分辨四个碱基
     */
    public List<String> findRepeatedDnaSequences4(String s) {
        int len = s.length();
        if (len < 10) {
            return new ArrayList<>();
        }
        Set<String> res = new HashSet<>();
        Set<Integer> set = new HashSet<>();
        int key = 0;
        for (int i = 0; i < 10; i++) {
            key = key << 3 | (s.charAt(i) & 0x07);
        }
        set.add(key);
        for (int i = 10; i < len; i++) {
            key = key << 3 | (s.charAt(i) & 0x07);
            // 3 * 10 取后面 三十位
            key &= 0x3fffffff;
            if (set.contains(key)) {
                res.add(s.substring(i - 9, i + 1));
            } else {
                set.add(key);
            }
        }
        return new ArrayList<>(res);
    }

    public static void main(String[] args) {
        new Demo187().findRepeatedDnaSequences2("AAAAACCCCCAAAAACCCCCCAAAAAGGGTTT");
    }
}
