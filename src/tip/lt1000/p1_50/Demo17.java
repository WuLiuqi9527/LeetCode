package tip.lt1000.p1_50;

import java.util.ArrayList;
import java.util.List;

/**
 * 给定一个仅包含数字 2-9 的字符串，返回所有它能表示的字母组合。答案可以按 任意顺序 返回。
 * 给出数字到字母的映射如下（与电话按键相同）。注意 1 不对应任何字母。
 *
 * @author hc
 */
public class Demo17 {

    private final String[] letters = {"abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};

    List<String> res = new ArrayList<>();

    public List<String> letterCombinations(String digits) {
        if (digits == null || digits.length() == 0) {
            return res;
        }

        findCombination(digits, 0, "");

        return res;
    }

    private void findCombination(String digits, int index, String s) {

        if (index == digits.length()) {
            res.add(s);
            return;
        }

        char c = digits.charAt(index);
        String letter = letters[c - '2'];
        for (char ch : letter.toCharArray()) {
            findCombination(digits, index + 1, s + ch);
        }
        return;
    }
}
