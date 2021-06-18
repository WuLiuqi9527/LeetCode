package tips.p_1000.p501_550;

/**
 * 给定一个整数，将其转化为7进制，并以字符串形式输出。
 * <p>示例 1:
 * 输入: 100
 * 输出: "202"
 * <p>示例 2:
 * 输入: -7
 * 输出: "-10"
 * 注意: 输入范围是 [-1e7, 1e7] 。
 *
 * @author hc
 */
public class Demo504 {

    public String convertToBase7(int num) {
        return Integer.toString(num, 7);
    }

    public String convertToBase77(int num) {
        int convertToBase = 7;

        StringBuilder sb = new StringBuilder();
        if (num == 0) {
            return "0";
        }

        boolean flag = num < 0;
        num = Math.abs(num);
        while (num != 0) {
            sb.append(num % convertToBase);
            num /= convertToBase;
        }

        if (flag) {
            sb.append("-");
        }

        return sb.reverse().toString();
    }
}
