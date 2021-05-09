package tip.p251_300;

/**
 * 编写一个程序判断给定的数是否为丑数。
 * 丑数就是只包含质因数 2, 3, 5 的正整数。
 * <p>
 * 示例 1:
 * 输入: 6
 * 输出: true
 * 解释: 6 = 2 × 3
 * <p>
 * 示例 2:
 * 输入: 8
 * 输出: true
 * 解释: 8 = 2 × 2 × 2
 * <p>
 * 示例 3:
 * 输入: 14
 * 输出: false
 * 解释: 14 不是丑数，因为它包含了另外一个质因数 7
 *
 * @author hc
 */
public class Demo263 {

    public boolean isUgly(int n) {

        if (n == 1) {
            return true;
        }
        if (n == 0) {
            return false;
        }

        if (n % 5 == 0) {
            return isUgly(n / 5);
        } else if (n % 3 == 0) {
            return isUgly(n / 3);
        } else if (n % 2 == 0) {
            return isUgly(n >> 1);
        }
        return false;
    }

    public static void main(String[] args) {
        System.out.println(new Demo263().isUgly(14));
    }
}
