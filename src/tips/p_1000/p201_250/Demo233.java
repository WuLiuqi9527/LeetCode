package tips.p_1000.p201_250;

/**
 * 给定一个整数 n，计算所有小于等于 n 的非负整数中数字 1 出现的个数。
 * <p>示例 1：
 * 输入：n = 13
 * 输出：6
 * <p>示例 2：
 * 输入：n = 0
 * 输出：0
 * <p>提示：
 * 0 <= n <= 2 * 10^9
 *
 * @author hc
 */
public class Demo233 {

    public int countDigitOne(int n) {
        // 分别计算个、十、百......千位上1出现的次数，再求和。
        int num = n;
        int i = 1, count = 0;
        while (num > 0) {
            if (num % 10 == 0) {
                count += num / 10 * i;
            }
            if (num % 10 == 1) {
                count += num / 10 * i + n % i + 1;
            }
            if (num % 10 > 1) {
                count += Math.ceil(num / 10.0) * i;
            }
            num /= 10;
            i *= 10;
        }
        return count;
    }

    public int countDigitOne2(int n) {
        int digit = 1, res = 0;
        int high = n / 10, cur = n % 10, low = 0;
        while (high != 0 || cur != 0) {
            if (cur < 1) {
                res += high * digit;
            } else if (cur == 1) {
                res += high * digit + low + 1;
            } else {
                res += (high + 1) * digit;
            }
            low += cur * digit;
            cur = high % 10;
            high /= 10;
            digit *= 10;
        }
        return res;
    }

    public static void main(String[] args) {
        System.out.println(new Demo233().countDigitOne(13));
        System.out.println(new Demo233().countDigitOne(0));
    }
}
