package tips.p_1000.p1_50;

/**
 * 罗马数字包含以下七种字符： I， V， X， L，C，D 和 M。
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
 * 数字 1 在数字 5 的左边，所表示的数等于大数 5 减小数 1 得到的数值 4 。同样地，数字 9 表示为 IX。这个特殊的规则只适用于以下六种情况：
 * <p>
 * I 可以放在 V (5) 和 X (10) 的左边，来表示 4 和 9。
 * X 可以放在 L (50) 和 C (100) 的左边，来表示 40 和 90。
 * C 可以放在 D (500) 和 M (1000) 的左边，来表示 400 和 900。
 * 给定一个整数，将其转为罗马数字。输入确保在 1 到 3999 的范围内。
 * <p>
 * 示例 1:
 * 输入: 9
 * 输出: "IX"
 * <p>
 * 示例 2:
 * 输入: 58
 * 输出: "LVIII"
 * 解释: L = 50, V = 5, III = 3.
 * <p>
 * 示例 3:
 * 输入: 1994
 * 输出: "MCMXCIV"
 * 解释: M = 1000, CM = 900, XC = 90, IV = 4.
 *
 * @author hc
 */
public class Demo12 {

    public String intToRoman(int num) {

        if (num < 1 || num > 3999) {
            return "输入错误";
        }

        String[] keys = new String[]{"I", "IV", "V", "IX", "X", "XL", "L", "XC", "C", "CD", "D", "CM", "M"};
        int[] values = new int[]{1, 4, 5, 9, 10, 40, 50, 90, 100, 400, 500, 900, 1000};

        StringBuilder res = new StringBuilder();
        for (int i = values.length - 1; i >= 0; --i) {

            while (num >= values[i]){
                num -= values[i];
                res.append(keys[i]);
            }
        }

        return res.toString();
    }

    public static void main(String[] args) {
        System.out.println(new Demo12().intToRoman(9));
        System.out.println(new Demo12().intToRoman(58));
        System.out.println(new Demo12().intToRoman(1994));
    }
}
