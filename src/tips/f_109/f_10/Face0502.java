package tips.f_109.f_10;

/**
 * 二进制数转字符串。
 * 给定一个介于 0 和 1 之间的实数（如 0.72），类型为 double，打印它的二进制表达式。
 * 如果该数字无法精确地用32位以内的二进制表示，则打印“ERROR”。
 * <p>示例 1:
 * 输入：0.625
 * 输出："0.101"
 * <p>示例 2:
 * 输入：0.1
 * 输出："ERROR"
 * 提示：0.1 无法被二进制准确表示
 * <p>提示：
 * 32位包括输出中的 "0." 这两位。
 *
 * @author hc
 */
public class Face0502 {

    public String printBin(double num) {
        // 十进制小数转二进制 -> 乘2取整
        if (num <= 0 || num >= 1) {
            return "ERROR";
        }

        StringBuilder sb = new StringBuilder();
        sb.append("0.");
        while (num != 0) {
            num *= 2;
            sb.append(num - 1 >= 0 ? 1 : 0);
            if (num >= 1) {
                --num;
            }
            if (sb.length() > 32) {
                return "ERROR";
            }
        }
        return sb.toString();
    }
}
