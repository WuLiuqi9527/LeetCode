package tip.p151_200;

/**
 * 给定一个Excel表格中的列名称，返回其相应的列序号。
 * <p>
 * 例如，
 *      A -> 1
 *      B -> 2
 *      C -> 3
 *      ...
 *      Z -> 26
 *      AA -> 27
 *      AB -> 28
 * ...
 * 示例：
 * 输入: "AB"
 * 输出: 28
 * <p>
 * 示例 3:
 * 输入: "ZY"
 * 输出: 701
 *
 * @author hc
 */
public class Demo171 {

    /**
     * 本质是 26 进制的转化
     */
    public int titleToNumber(String columnTitle) {

        int res = 0;
        for (char ch : columnTitle.toCharArray()){
            res = res * 26 + ch - 'A' + 1;
        }

        return res;
    }

    public static void main(String[] args) {
        System.out.println(new Demo171().titleToNumber("ZY"));
        System.out.println(new Demo171().titleToNumber("AB"));
    }
}
