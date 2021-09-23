package tips.p_1000.p301_350;

import java.util.HashSet;
import java.util.Set;

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
        if (n <= 0) {
            return false;
        }
        while (n % 3 == 0) {
            n /= 3;
        }
        return n == 1;
    }

    public boolean isPowerOfThree2(int n) {
        // 题目要求不能使用循环或递归来做，而传参 n 的数据类型为 int，
        // 这引导我们首先分析出 int 范围内的最大 3 次幂是多少，约为 3^19 = 1162261467
        // 如果 n 为 3 的幂的话，那么必然满足 n * 3^k = 1162261467
        // 即 n 与 1162261467 存在倍数关系。
        // 因此，我们只需要判断 n 是否为 1162261467 的约数即可。
        return n > 0 && 1162261467 % n == 0;
    }

    public boolean isPowerOfThree3(int n) {
        // 转3进制 1 10 100 "10*$"匹配
        return Integer.toString(n, 3).matches("10*$");
    }

    /** 打表预处理 */
    static Set<Integer> set = new HashSet<>();

    static {
        int cur = 1;
        set.add(cur);
        while (cur <= Integer.MAX_VALUE / 3) {
            cur *= 3;
            set.add(cur);
        }
    }

    public boolean isPowerOfThree4(int n) {
        return n > 0 && set.contains(n);
    }
}
