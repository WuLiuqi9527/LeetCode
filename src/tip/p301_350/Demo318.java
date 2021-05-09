package tip.p301_350;

/**
 * 给定一个字符串数组 words，
 * 找到 length(word[i]) * length(word[j]) 的最大值，并且这两个单词不含有公共字母。
 * 你可以认为每个单词只包含小写字母。如果不存在这样的两个单词，返回 0。
 * <p>示例 1:
 * 输入: ["abcw","baz","foo","bar","xtfn","abcdef"]
 * 输出: 16
 * 解释: 这两个单词为 "abcw", "xtfn"。
 * <p>示例 2:
 * 输入: ["a","ab","abc","d","cd","bcd","abcd"]
 * 输出: 4
 * 解释: 这两个单词为 "ab", "cd"。
 * <p>示例 3:
 * 输入: ["a","aa","aaa","aaaa"]
 * 输出: 0
 * 解释: 不存在这样的两个单词。
 *
 * @author hc
 */
public class Demo318 {

    public int maxProduct(String[] words) {
        int len = words.length;
        int[] hash = new int[len];

        for (int i = 0; i < len; i++) {
            char[] chars = words[i].toCharArray();
            for (char c : chars) {
                hash[i] |= 1 << (c - 'a');
            }
        }

        int max = 0;
        for (int i = 0; i < len - 1; i++) {
            for (int j = i + 1; j < len; j++) {
                if ((hash[i] & hash[j]) == 0) {
                    max = Math.max(max, words[i].length() * words[j].length());
                }
            }
        }
        return max;
    }

    public static void main(String[] args) {
        System.out.println(new Demo318().maxProduct(new String[]{"abcw", "baz", "foo", "bar", "xtfn", "abcdef"}));
        System.out.println(new Demo318().maxProduct(new String[]{"a", "ab", "abc", "d", "cd", "bcd", "abcd"}));
        System.out.println(new Demo318().maxProduct(new String[]{"a", "aa", "aaa", "aaaa"}));
    }
}
