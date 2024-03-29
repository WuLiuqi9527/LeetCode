package tips.p_1000.p401_450;

/**
 * 给定一个整数，编写一个算法将这个数转换为十六进制数。对于负整数，我们通常使用 补码运算 方法。
 * 注意:
 * 十六进制中所有字母(a-f)都必须是小写。
 * 十六进制字符串中不能包含多余的前导零。如果要转化的数为0，那么以单个字符'0'来表示；
 * 对于其他情况，十六进制字符串中的第一个字符将不会是0字符。
 * 给定的数确保在32位有符号整数范围内。
 * 不能使用任何由库提供的将数字直接转换或格式化为十六进制的方法。
 * <p>示例 1：
 * 输入:
 * 26
 * 输出:
 * "1a"
 * <p>示例 2：
 * 输入:
 * -1
 * 输出:
 * "ffffffff"
 *
 * @author hc
 */
public class Demo405 {
    static char[] chars = new char[]{'0', '1', '2', '3', '4', '5', '6', '7', '8', '9',
            'a', 'b', 'c', 'd', 'e', 'f'};

    public String toHex(int num) {
        if (num == 0) {
            return "0";
        }
        StringBuilder sb = new StringBuilder();

        // 整型一共32位二进制，每4个二进制位是一位8进制，一共可以转为8位8进制，有符号右移通过sb.length() < 8判断有没有全部转化完；
        // 无符号右移最高位补0，全部转化完后num == 0，所以通过判断最终是否为0，判断有没有转化完。
        while (sb.length() < 8 && num != 0) {
            sb.append(chars[num & 0x0f]);
            num >>= 4;
        }
        return sb.reverse().toString();
    }

    public static String toHex2(int num) {
        return Integer.toHexString(num);
    }

    public static void main(String[] args) {
        System.out.println(toHex2(-1));
    }
}
