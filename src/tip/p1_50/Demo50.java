package tip.p1_50;

/**
 * 实现 pow(x, n) ，即计算 x 的 n 次幂函数（即，x^n）。
 * <p>
 * 示例 1：
 * 输入：x = 2.00000, n = 10
 * 输出：1024.00000
 *
 * @author hc
 */
public class Demo50 {

    public double myPow(double x, int n) {

        if (x == 0) {
            return 0;
        }

        double res = 1;
        long nn = n;

        if (nn < 0) {
            x = 1 / x;
            nn = -nn;
        }

        while (nn > 0) {
            // 非递归快速幂 减少乘法运算的次数
            // https://zhuanlan.zhihu.com/p/95902286
            if ((nn & 1) == 1) {
                res *= x;
            }
            x *= x;
            nn >>= 1;
        }

        return res;
    }

    public static void main(String[] args) {
        System.out.println(new Demo50().myPow(2.1, 3));
    }
}
