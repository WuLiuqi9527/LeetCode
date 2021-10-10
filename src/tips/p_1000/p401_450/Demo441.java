package tips.p_1000.p401_450;

/**
 * 你总共有 n 枚硬币，并计划将它们按阶梯状排列。
 * 对于一个由 k 行组成的阶梯，其第 i 行必须正好有 i 枚硬币。
 * 阶梯的最后一行 可能 是不完整的。
 * 给你一个数字 n ，计算并返回可形成 完整阶梯行 的总行数。
 * <p>示例 1：
 * 输入：n = 5
 * 输出：2
 * 解释：因为第三行不完整，所以返回 2 。
 * <p>示例 2：
 * 输入：n = 8
 * 输出：3
 * 解释：因为第四行不完整，所以返回 3 。
 * <p>提示：
 * 1 <= n <= 2^31 - 1
 *
 * @author hc
 */
public class Demo441 {

    public static int arrangeCoins(int n) {
        // 等差数列求和公式反推
        return (int) ((Math.sqrt(1 + 8.0 * n) - 1) / 2);
    }

    public static int arrangeCoins2(int n) {
        int i = 1;
        while (n >= i) {
            n -= i;
            i++;
        }
        return i - 1;
    }

    public static void main(String[] args) {
        System.out.println(arrangeCoins(5));
        System.out.println(arrangeCoins(8));
    }
}
