package tips.p_1000.p451_500;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

/**
 * 给你一个字符串数组 words ，只返回可以使用在 美式键盘 同一行的字母打印出来的单词。键盘如下图所示。
 * 美式键盘 中：
 * 第一行由字符 "qwertyuiop" 组成。
 * 第二行由字符 "asdfghjkl" 组成。
 * 第三行由字符 "zxcvbnm" 组成。
 * <p>示例 1：
 * 输入：words = ["Hello","Alaska","Dad","Peace"]
 * 输出：["Alaska","Dad"]
 * <p>示例 2：
 * 输入：words = ["omk"]
 * 输出：[]
 * <p>示例 3：
 * 输入：words = ["adsdf","sfd"]
 * 输出：["adsdf","sfd"]
 * <p>提示：
 * 1 <= words.length <= 20
 * 1 <= words[i].length <= 100
 * words[i] 由英文字母（小写和大写字母）组成
 *
 * @author hc
 */
public class Demo500 {

    private static HashMap<Character, Integer> map;

    static {
        String[] line = {"qwertyuiop", "asdfghjkl", "zxcvbnm"};
        map = new HashMap<>();
        for (int i = 0; i < line.length; i++) {
            for (char c : line[i].toCharArray()) {
                map.put(c, i);
            }
        }
    }

    public static String[] findWords(String[] words) {
        List<String> ans = new ArrayList<>();
        for (String word : words) {
            String tem = word.toLowerCase();
            boolean isSameLine = true;
            int flag = map.get(tem.charAt(0));
            for (char c : tem.toCharArray()) {
                if (map.get(c) != flag) {
                    isSameLine = false;
                }
            }
            if (isSameLine) {
                ans.add(word);
            }
        }
        return ans.toArray(new String[0]);
    }

    public static void main(String[] args) {
        findWords(new String[]{"Hello", "Alaska", "Dad", "Peace"});
    }
}
