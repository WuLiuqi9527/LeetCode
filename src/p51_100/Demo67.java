package p51_100;

/**
 * 给你两个二进制字符串，返回它们的和（用二进制表示）。
 * 输入为 非空 字符串且只包含数字 1 和 0。
 * <p>
 * 示例 1:
 * 输入: a = "11", b = "1"
 * 输出: "100"
 *
 * @author hc
 */
public class Demo67 {

    public String addBinary(String a, String b) {

        StringBuilder res = new StringBuilder();
        int carry = 0;
        for (int i = a.length() - 1, j = b.length() - 1; i >= 0 || j >= 0; --i, --j) {
            carry += i >= 0 ? a.charAt(i) - '0' : 0;
            carry += j >= 0 ? b.charAt(j) - '0' : 0;
            res.append(carry & 1);
            carry >>= 1;
        }
        res.append(carry == 1 ? carry : "");
        return res.reverse().toString();
    }

    public static void main(String[] args) {
        System.out.println(new Demo67().addBinary("11", "1"));
        System.out.println(new Demo67().addBinary("1010", "1011"));
    }
}
