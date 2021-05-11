package tip.lt1000.p151_200;

/**
 * 给定一个正整数，返回它在 Excel 表中相对应的列名称。
 * 例如，
 * 1 -> A
 * 2 -> B
 * 3 -> C
 * ...
 * 26 -> Z
 * 27 -> AA
 * 28 -> AB
 * ...
 * 示例 :
 * 输入: 28
 * 输出: "AB"
 * <p>
 * 示例 :
 * 输入: 701
 * 输出: "ZY"
 *
 * @author hc
 */
public class Demo168 {

    /**
     * A -> AB -> BA -> AAB 26进制 减 1 -> 0 ~ 25
     */
    public String convertToTitle(int columnNumber) {

        if (columnNumber <= 0) {
            return "";
        }

        StringBuilder res = new StringBuilder();
        while (columnNumber > 0) {
            --columnNumber;
            res.append((char) ('A' + columnNumber % 26));
            columnNumber = columnNumber / 26;
        }
        return res.reverse().toString();
    }

    public static void main(String[] args) {
        System.out.println(new Demo168().convertToTitle(701));
    }
}
