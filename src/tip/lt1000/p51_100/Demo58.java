package tip.lt1000.p51_100;

/**
 * 给你一个字符串 s，由若干单词组成，单词之间用空格隔开。返回字符串中最后一个单词的长度。
 * 如果不存在最后一个单词，请返回 0 。
 * 单词 是指仅由字母组成、不包含任何空格字符的最大子字符串。
 * <p>
 * 示例 1：
 * 输入：s = "Hello World"
 * 输出：5
 *
 * @author hc
 */
public class Demo58 {

    /**
     * s = s.trim();
     * trim() 底层是用 char[] 实现的，会消耗额外的空间，增大空间复杂度
     */
    public int lengthOfLastWord(String s) {
        if (s.length() == 0) {
            return 0;
        }

        int count = 0, len = s.length();
        for (int i = len - 1; i >= 0; --i) {

            if (s.charAt(i) != ' ') {
                ++count;
            } else if (count != 0){
                return count;
            }
        }

        return count;
    }

    public static void main(String[] args) {
        System.out.println(new Demo58().lengthOfLastWord("b   a    "));
    }
}
