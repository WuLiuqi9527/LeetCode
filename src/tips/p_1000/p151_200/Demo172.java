package tips.p_1000.p151_200;

/**
 * 给定一个整数 n，返回 n! 结果尾数中零的数量。
 * <p>
 * 示例 1:
 * 输入: 3
 * 输出: 0
 * 解释: 3! = 6, 尾数中没有零。
 * <p>
 * 示例 2:
 * 输入: 5
 * 输出: 1
 * 解释: 5! = 120, 尾数中有 1 个零.
 * 说明: 你算法的时间复杂度应为 O(log n)。
 * <p>
 * 本质：统计 5 的个数
 *
 * @author hc
 */
public class Demo172 {

    public int trailingZeroes(int n) {
        return n == 0 ? 0 : n / 5 + trailingZeroes(n / 5);
    }
}
