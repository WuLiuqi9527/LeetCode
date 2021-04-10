package p301_350;

/**
 * 给定一个整数，写一个函数来判断它是否是 3 的幂次方。如果是，返回 true ；否则，返回 false 。
 * 整数 n 是 3 的幂次方需满足：存在整数 x 使得 n == 3^x
 * <p>
 * 示例 1：
 * 输入：n = 27
 * 输出：true
 * <p>
 * 提示：
 * -2^31 <= n <= 2^31 - 1
 * 进阶：
 * 你能不使用循环或者递归来完成本题吗？
 *
 * @author hc
 */
public class Demo326 {

    public boolean isPowerOfThree(int n) {
        // 3的幂次的质因子只有3
        return n > 0 && 1162261467 % n == 0;
    }

    public boolean isPowerOfThree2(int n) {
        // 转3进制 1 10 100 "10*$"匹配
        return Integer.toString(n, 3).matches("10*$");
    }
}
