package tips.p_contest;

/**
 * 全字母句 指包含英语字母表中每个字母至少一次的句子。
 * 给你一个仅由小写英文字母组成的字符串 sentence ，请你判断 sentence 是否为 全字母句 。
 * 如果是，返回 true ；否则，返回 false 。
 * <p>示例 1：
 * 输入：sentence = "thequickbrownfoxjumpsoverthelazydog"
 * 输出：true
 * 解释：sentence 包含英语字母表中每个字母至少一次。
 * <p>示例 2：
 * 输入：sentence = "leetcode"
 * 输出：false
 * <p>提示：
 * 1 <= sentence.length <= 1000
 * sentence 由小写英语字母组成
 *
 * @author hc
 */
public class Demo5734 {

    public boolean checkIfPangram(String sentence) {
        int len = sentence.length();
        if (len < 26) {return false;}

        int[] freq = new int[26];
        for (int i = 0; i < len; i++) {
            ++freq[sentence.charAt(i) - 'a'];
        }
        for (int f : freq) {
            if (f == 0) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        System.out.println(new Demo5734().checkIfPangram("thequickbrownfoxjumpsoverthelazydog"));
        System.out.println(new Demo5734().checkIfPangram("leetcode"));
    }
}
