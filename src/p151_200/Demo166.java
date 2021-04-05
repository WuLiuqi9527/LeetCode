package p151_200;

import java.util.HashMap;
import java.util.Map;

/**
 * 给定两个整数，分别表示分数的分子 numerator 和分母 denominator，以字符串形式返回小数。
 * 如果小数部分为循环小数，则将循环的部分括在括号内。
 * 如果存在多个答案，只需返回 任意一个 。
 * 对于所有给定的输入，保证 答案字符串的长度小于 10^4 。
 * <p>示例 1：
 * 输入：numerator = 1, denominator = 2
 * 输出："0.5"
 * <p>示例 2：
 * 输入：numerator = 2, denominator = 1
 * 输出："2"
 * <p>示例 3：
 * 输入：numerator = 2, denominator = 3
 * 输出："0.(6)"
 * <p>示例 4：
 * 输入：numerator = 4, denominator = 333
 * 输出："0.(012)"
 * <p>示例 5：
 * 输入：numerator = 1, denominator = 5
 * 输出："0.2"
 *
 * @author hc
 */
public class Demo166 {

    public String fractionToDecimal(int numerator, int denominator) {

        StringBuilder res = new StringBuilder();
        long a = numerator, b = denominator;
        if (a < 0 && b > 0 || a > 0 && b < 0) {
            res.append("-");
        }
        a = Math.abs(a);
        b = Math.abs(b);
        res.append(a / b);
        if (a % b == 0) {
            return res.toString();
        }
        res.append(".");
        Map<Long, Integer> map = new HashMap<>();
        while ((a = (a % b) * 10) > 0 && !map.containsKey(a)) {
            map.put(a, res.length());
            res.append(a / b);
        }
        if (a == 0) {
            return res.toString();
        }
        return res.insert(map.get(a).intValue(), "(").append(")").toString();
    }

    public static void main(String[] args) {
        System.out.println(new Demo166().fractionToDecimal(2, 3));
    }
}
