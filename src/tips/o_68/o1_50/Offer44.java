package tips.o_68.o1_50;

/**
 * 数字以0123456789101112131415…的格式序列化到一个字符序列中。
 * 在这个序列中，第5位（从下标0开始计数）是 5，第13位是 1，第19位是 4，等等。
 * 请写一个函数，求任意第 n 位对应的数字。
 * <p>示例 1：
 * 输入：n = 3
 * 输出：3
 * <p>示例 2：
 * 输入：n = 11
 * 输出：0
 * <p>限制：
 * 0 <= n < 2^31
 *
 * @author hc
 */
public class Offer44 {

    public int findNthDigit(int n) {
        int digit = 1;
        long start = 1;
        long count = 9;
        while (n > count) {
            n -= count;
            digit += 1;
            start *= 10;
            count = digit * start * 9;
        }
        long num = start + (n - 1) / digit;
        return Long.toString(num).charAt((n - 1) % digit) - '0';
    }
}
