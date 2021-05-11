package tip.lt1000.p251_300;

/**
 * 给定一个非负整数 num，反复将各个位上的数字相加，直到结果为一位数。
 * <p>
 * 示例:
 * 输入: 38
 * 输出: 2
 * 解释: 各位相加的过程为：3 + 8 = 11, 1 + 1 = 2。 由于 2 是一位数，所以返回 2。
 * 进阶:
 * 你可以不使用循环或者递归，且在 O(1) 时间复杂度内解决这个问题吗？
 *
 * @author hc
 */
public class Demo258 {

    /**
     * “数根 ”：一个数 num 和 num + 9 的数根是一样的,
     * 所以 num % 9.
     * 但要, 要注意两种特殊情况:
     * 1. num 是 9 的倍数时，结果应该等于 9；
     * 2. num 为 0 时, 结果为 0.
     */
    public int addDigits(int num) {
        if (num == 0) {
            return 0;
        }
        if (num % 9 == 0) {
            return 9;
        }
        return num % 9;
    }

    public int addDigits2(int num) {
        if (num < 10) {
            return num;
        }
        return num % 9 == 0 ? 9 : num % 9;
    }
}
