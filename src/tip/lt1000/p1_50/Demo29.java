package tip.lt1000.p1_50;

/**
 * 给定两个整数，被除数 dividend 和除数 divisor。将两数相除，要求不使用乘法、除法和 mod 运算符。
 * 返回被除数 dividend 除以除数 divisor 得到的商。
 * 整数除法的结果应当截去（truncate）其小数部分，例如：truncate(8.345) = 8 以及 truncate(-2.7335) = -2
 * <p>
 * 示例 1:
 * 输入: dividend = 10, divisor = 3
 * 输出: 3
 * 解释: 10/3 = truncate(3.33333..) = truncate(3) = 3
 * <p>
 * 提示：
 * 被除数和除数均为 32 位有符号整数。
 * 除数不为 0。
 * 假设我们的环境只能存储 32 位有符号整数，其数值范围是 [−2^31,  2^31 − 1]。本题中，如果除法结果溢出，则返回 2^31 − 1。
 *
 * @author hc
 */
public class Demo29 {

    public int divide(int dividend, int divisor) {

        int res = 0;
        boolean sign = (dividend > 0) ^ (divisor > 0);

        // 转为负数处理
        if (dividend > 0) { dividend = -dividend;}
        if (divisor > 0) {divisor = -divisor;}

        while (dividend <= divisor) {
            int temRes = -1;
            int temDivisor = divisor;

            // 负数小于 数值位更大
            // 比除数的两倍还小
            while (dividend <= (temDivisor << 1)) {
                if (temDivisor <= (Integer.MIN_VALUE >> 1)) {break;}

                temRes = temRes << 1;
                temDivisor = temDivisor << 1;
            }
            dividend = dividend - temDivisor;
            res += temRes;
        }

        if (!sign) {
            if (res <= Integer.MIN_VALUE) {return Integer.MAX_VALUE;}
            res = -res;
        }

        return res;
    }

    public static void main(String[] args) {
        System.out.println(new Demo29().divide(10, 3));
        System.out.println(new Demo29().divide(7, -3));
    }
}
