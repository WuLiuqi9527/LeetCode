package tips.f_109.f_17;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * 给定一组单词words，编写一个程序，找出其中的最长单词，且该单词由这组单词中的其他单词组合而成。
 * 若有多个长度相同的结果，返回其中字典序最小的一项，若没有符合要求的单词则返回空字符串。
 * <p>示例：
 * 输入： ["cat","banana","dog","nana","walk","walker","dogwalker"]
 * 输出： "dogwalker"
 * 解释： "dogwalker"可由"dog"和"walker"组成。
 * <p>提示：
 * 0 <= len(words) <= 200
 * 1 <= len(words[i]) <= 100
 *
 * @author hc
 */
public class Face1715 {

    /**
     * 思路：
     * words 按照长度降序排序，如果长度相等就按照字典序排序。
     * 这样的话如果每个单词都是组合单词，那么最前面的单词就是题目要求的返回单词。
     * 遍历排序后的单词数组，如果是复合单词就返回
     * 复合单词检测思路： 目标单词的前 i个字母是单词列表里面的单词 && 剩下的字母是组合单词
     */
    public String longestWord(String[] words) {

        Arrays.sort(words, (o1, o2) -> o1.length() == o2.length() ?
                o1.compareTo(o2) : o2.length() - o1.length());

        Set<String> set = new HashSet<>(Arrays.asList(words));
        for (String word : words) {
            set.remove(word);
            if (isComposeWord(set, word)) {
                return word;
            }
            set.add(word);
        }
        return "";
    }

    private boolean isComposeWord(Set<String> set, String word) {
        if (word.length() == 0) {
            return true;
        }

        int len = word.length();
        for (int i = 0; i < len; i++) {
            if (set.contains(word.substring(0, i + 1)) && isComposeWord(set, word.substring(i + 1))) {
                return true;
            }
        }

        return false;
    }
}
