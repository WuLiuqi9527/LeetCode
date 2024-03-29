package tips.p_1000.p401_450;

/**
 * 给定两个字符串形式的非负整数 num1 和 num2 ，计算它们的和。
 * <p>
 * 提示：
 * num1 和num2 的长度都小于 5100
 * num1 和num2 都只包含数字 0-9
 * num1 和num2 都不包含任何前导零
 * 你不能使用任何內建 BigInteger 库， 也不能直接将输入的字符串转换为整数形式
 *
 * @author hc
 */
public class Demo415 {

    public String addStrings(String num1, String num2) {

        StringBuilder sb = new StringBuilder();
        int carry = 0, i = num1.length() - 1, j = num2.length() - 1;
        while (i >= 0 || j >= 0 || carry != 0) {
            if (i >= 0) {
                carry += num1.charAt(i--) - '0';
            }
            if (j >= 0) {
                carry += num2.charAt(j--) - '0';
            }
            sb.append(carry % 10);
            carry /= 10;
        }
        return sb.reverse().toString();
    }

    public static void main(String[] args) {
        System.out.println(new Demo415().addStrings("123", "456"));
    }
}
