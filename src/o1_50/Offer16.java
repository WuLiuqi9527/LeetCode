package o1_50;

/**
 * 实现 pow(x, n) ，即计算 x 的 n 次幂函数（即，x^n）。
 * 不得使用库函数，同时不需要考虑大数问题。
 * <p>示例 1：
 * 输入：x = 2.00000, n = 10
 * 输出：1024.00000
 * <p>示例 2：
 * 输入：x = 2.10000, n = 3
 * 输出：9.26100
 * <p>示例 3：
 * 输入：x = 2.00000, n = -2
 * 输出：0.25000
 * 解释：2-2 = 1/22 = 1/4 = 0.25
 * <p>提示：
 * -100.0 < x < 100.0
 * -2^31 <= n <= 2^31-1
 * -10^4 <= x^n <= 10^4
 *
 * @author hc
 */
public class Offer16 {

    /**
     * 1、n 个 x 直接乘 时间复杂度 O(n)
     * 2、快速幂
     */
    public double myPow(double x, int n) {
        if (n == 0) {
            return 1;
        }
        if (n == 1) {
            return x;
        }
        if (n == -1) {
            return 1 / x;
        }

        double half = myPow(x, n >> 1);
        double mod = myPow(x, n & 1);

        return half * half * mod;
    }

    public static void main(String[] args) {
        System.out.println(new Offer16().myPow(2, 10));
    }
}
