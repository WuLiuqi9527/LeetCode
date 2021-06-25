package tips.f_109.f_17;

/**
 * 设计一个算法，算出 n 阶乘有多少个尾随零。
 * <p>示例 1:
 * 输入: 3
 * 输出: 0
 * 解释: 3! = 6, 尾数中没有零。
 * <p>示例 2:
 * 输入: 5
 * 输出: 1
 * 解释: 5! = 120, 尾数中有 1 个零.
 * 说明: 你算法的时间复杂度应为 O(log n) 。
 *
 * @author hc
 */
public class Face1605 {

    /**
     * 0 是由 *10 得到的，而 10 是由 2 * 5 得到的
     * 因此我们求 n！ 过程中存在多少个 2 * 5
     * 因为 2 的个数必定比 5 的个数多，因此我们只求 5 的个数
     */
    public int trailingZeroes(int n) {
        int res = 0;
        while (n != 0) {
            res += n / 5;
            n /= 5;
        }
        return res;
    }
}
