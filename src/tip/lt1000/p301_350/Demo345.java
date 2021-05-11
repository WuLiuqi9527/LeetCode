package tip.lt1000.p301_350;

/**
 * 编写一个函数，以字符串作为输入，反转该字符串中的元音字母。
 * <p>
 * 示例 1：
 * 输入："hello"
 * 输出："holle"
 * <p>
 * 示例 2：
 * 输入："leetcode"
 * 输出："leotcede"
 *
 * @author hc
 */
public class Demo345 {

    public String reverseVowels(String s) {
        char[] chars = s.toCharArray();
        String letter = "aeiouAEIOU";

        int L = 0;
        int R = s.length()-1;
        char temp;
        while (L< R){
            if (letter.indexOf(chars[L]) != -1 && letter.indexOf(chars[R]) != -1){
                temp = chars[L];
                chars[L] = chars[R];
                chars[R] = temp;
                L++;
                R--;
            }else if (letter.indexOf(chars[L]) != -1){
                R--;
            }else if (letter.indexOf(chars[R]) != -1){
                L++;
            }else {
                L++;
                R--;
            }
        }
        return new String(chars);
    }

    public static void main(String[] args) {
        System.out.println(new Demo345().reverseVowels(new String("leetcode")));
    }
}
