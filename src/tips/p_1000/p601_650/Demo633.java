package tips.p_1000.p601_650;

/**
 * 给定一个非负整数 c ，你要判断是否存在两个整数 a 和 b，使得 a^2 + b^2 = c 。
 * <p>示例 1：
 * 输入：c = 5
 * 输出：true
 * 解释：1 * 1 + 2 * 2 = 5
 * <p>示例 2：
 * 输入：c = 3
 * 输出：false
 * <p>示例 3：
 * 输入：c = 4
 * 输出：true
 * <p>示例 4：
 * 输入：c = 2
 * 输出：true
 * <p>示例 5：
 * 输入：c = 1
 * 输出：true
 * <p>提示：
 * 0 <= c <= 2^31 - 1
 *
 * @author hc
 */
public class Demo633 {

    public boolean judgeSquareSum(int c) {
        int l = 0, r = (int) Math.sqrt(c);
        while (l <= r) {
            int total = l * l + r * r;
            if (total > c) {
                --r;
            } else if (total < c) {
                ++l;
            } else {
                return true;
            }
        }
        return false;
    }
}
