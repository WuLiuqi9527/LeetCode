package tips.p_1000.p1_50;

/**
 * 罗马数字包含以下七种字符: I， V， X， L，C，D 和 M。
 * <p>
 * 字符          数值
 * I             1
 * V             5
 * X             10
 * L             50
 * C             100
 * D             500
 * M             1000
 * 例如， 罗马数字 2 写做 II ，即为两个并列的 1。12 写做 XII ，即为 X + II 。 27 写做 XXVII, 即为 XX + V + II 。
 * 通常情况下，罗马数字中小的数字在大的数字的右边。但也存在特例，例如 4 不写做 IIII，而是 IV。
 * 数字 1 在数字 5 的左边，所表示的数等于大数 5 减小数 1 得到的数值 4 。
 * 同样地，数字 9 表示为 IX。这个特殊的规则只适用于以下六种情况：
 * <p>
 * I 可以放在 V (5) 和 X (10) 的左边，来表示 4 和 9。
 * X 可以放在 L (50) 和 C (100) 的左边，来表示 40 和 90。
 * C 可以放在 D (500) 和 M (1000) 的左边，来表示 400 和 900。
 * 给定一个罗马数字，将其转换成整数。输入确保在 1 到 3999 的范围内。
 * <p>
 * 示例 1:
 * 输入: "III"
 * 输出: 3
 *
 * @author hc
 */
public class Demo13 {

    public int romanToInt(String s) {

        int res = 0;
        if (s == null || s.length() == 0) {
            return res;
        }

        int len = s.length();
        for (int i = 0; i < len; i++) {
            if (i + 1 < len) {
                if (which(s.charAt(i)) < which(s.charAt(i + 1))) {
                    res -= which(s.charAt(i));
                } else {
                    res += which(s.charAt(i));
                }
            }
        }

        return res + which(s.charAt(len - 1));
    }

    private int which(char c){
        switch (c) {
            case 'I':return 1;
            case 'V':return 5;
            case 'X':return 10;
            case 'L':return 50;
            case 'C':return 100;
            case 'D':return 500;
            case 'M':return 1000;
            default:break;
        }
        return 0;
    }

    public static void main(String[] args) {
        System.out.println(new Demo13().romanToInt("III"));
        System.out.println(new Demo13().romanToInt("IV"));
        System.out.println(new Demo13().romanToInt("IX"));
        System.out.println(new Demo13().romanToInt("LVIII"));
        System.out.println(new Demo13().romanToInt("MCMXCIV"));
    }
}
