package tips.p_1000.p251_300;

/**
 * 你和你的朋友，两个人一起玩 Nim 游戏：
 * 桌子上有一堆石头。
 * 你们轮流进行自己的回合，你作为先手。
 * 每一回合，轮到的人拿掉 1 - 3 块石头。
 * 拿掉最后一块石头的人就是获胜者。
 * 假设你们每一步都是最优解。请编写一个函数，来判断你是否可以在给定石头数量为 n 的情况下赢得游戏。
 * 如果可以赢，返回 true；否则，返回 false 。
 * <p>示例 1：
 * 输入：n = 4
 * 输出：false
 * 解释：如果堆中有 4 块石头，那么你永远不会赢得比赛；
 * 因为无论你拿走 1 块、2 块 还是 3 块石头，最后一块石头总是会被你的朋友拿走。
 * <p>提示：
 * 1 <= n <= 2^31 - 1
 *
 * @author hc
 */
public class Demo292 {

    /**
     * 巴什博弈
     * 当石子有 1−m 个时，毫无疑问，先手必胜
     * 当石子有 m+1 个时，先手无论拿几个，后手都可以拿干净，先手必败
     * 当石子有 m+2−2m 个时，先手可以拿走几个，剩下 m+1 个，先手必胜
     * 我们不难发现，面临 m+1 个石子的人一定失败。
     * 这样的话两个人的最优策略一定是通过拿走石子，使得对方拿石子时还有 m+1 个
     * 我们考虑往一般情况推广
     * 设当前的石子数为 n = k ∗ (m + 1) + r
     * 先手会首先拿走 r 个，接下来假设后手拿走 x 个，先手会拿走 m+1−x 个，这样博弈下去后手最终一定失败
     * 设当前的石子数为 n = k ∗ (m + 1)
     * 假设先手拿 x 个，后手一定会拿 m+1−x 个，这样下去先手一定失败
     */
    public boolean canWinNim(int n) {
        return n % (3 + 1) != 0;
    }
}
