package tips.p_1000.p351_400;

/**
 * 给你两个整数 a 和 b ，不使用 运算符 + 和 - ，计算并返回两整数之和。
 * <p>示例 1：
 * 输入：a = 1, b = 2
 * 输出：3
 * <p>示例 2：
 * 输入：a = 2, b = 3
 * 输出：5
 * <p>提示：
 * -1000 <= a, b <= 1000
 *
 * @author hc
 */
public class Demo371 {

    public int getSum(int a, int b) {
        return b == 0 ? a : getSum(a ^ b, (a & b) << 1);
    }

    public int getSum2(int a, int b) {
        while (b != 0) {
            int tem = a ^ b;
            b = (a & b) << 1;
            a = tem;
        }
        return a;
    }
}
