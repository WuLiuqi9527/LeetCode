package tips.p_1000.p351_400;

/**
 * 给定一个 正整数 num ，编写一个函数，如果 num 是一个完全平方数，则返回 true ，否则返回 false 。
 * 进阶：不要 使用任何内置的库函数，如  sqrt 。
 * <p>示例 1：
 * 输入：num = 16
 * 输出：true
 * <p>示例 2：
 * 输入：num = 14
 * 输出：false
 * <p>提示：
 * 1 <= num <= 2^31 - 1
 *
 * @author hc
 */
public class Demo367 {

    public boolean isPerfectSquare(int num) {
        double sqrt = Math.sqrt(num);
        return sqrt == Math.ceil(sqrt);
    }

    public boolean isPerfectSquare2(int num) {
        int l = 1, r = num;
        while (l <= r) {
            int mid = l + (r - l) / 2;
            if (num / mid == mid && num % mid == 0) {
                return true;
            }
            if (num / mid < mid) {
                r = mid - 1;
            } else {
                l = mid + 1;
            }
        }
        return false;
    }
}
