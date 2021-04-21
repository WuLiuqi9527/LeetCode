package o51_100;

/**
 * 输入一个英文句子，翻转句子中单词的顺序，但单词内字符的顺序不变。为简单起见，标点符号和普通字母一样处理。
 * 例如输入字符串"I am a student. "，则输出"student. a am I"。
 * <p>示例 1：
 * 输入: "the sky is blue"
 * 输出: "blue is sky the"
 * <p>示例 2：
 * 输入: "  hello world!  "
 * 输出: "world! hello"
 * 解释: 输入字符串可以在前面或者后面包含多余的空格，但是反转后的字符不能包括。
 * <p>示例 3：
 * 输入: "a good   example"
 * 输出: "example good a"
 * 解释: 如果两个单词间有多余的空格，将反转后单词间的空格减少到只含一个。
 * <p>说明：
 * 无空格字符构成一个单词。
 * 输入字符串可以在前面或者后面包含多余的空格，但是反转后的字符不能包括。
 * 如果两个单词间有多余的空格，将反转后单词间的空格减少到只含一个。
 *
 * @author hc
 */
public class Offer58One {

    public String reverseWords(String s) {
        String[] split = s.trim().split(" ");

        StringBuilder sb = new StringBuilder();
        for (int i = split.length - 1; i >= 0; --i) {
            if (split[i].equals("")) {continue;}
            if (i == 0) {
                sb.append(split[i]);
            } else {
                sb.append(split[i] + " ");
            }
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        System.out.println(new Offer58One().reverseWords("  hello world!  "));
        System.out.println(new Offer58One().reverseWords("the sky is blue"));
        System.out.println(new Offer58One().reverseWords("a good   example"));
    }
}
