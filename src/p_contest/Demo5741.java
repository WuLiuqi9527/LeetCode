package p_contest;

import java.util.Arrays;
import java.util.Comparator;

/**
 * 在一座城市里，你需要建 n 栋新的建筑。这些新的建筑会从 1 到 n 编号排成一列。
 * 这座城市对这些新建筑有一些规定：
 * 每栋建筑的高度必须是一个非负整数。
 * 第一栋建筑的高度 必须 是 0 。
 * 任意两栋相邻建筑的高度差 不能超过  1 。
 * 除此以外，某些建筑还有额外的最高高度限制。这些限制会以二维整数数组 restrictions 的形式给出，其中 restrictions[i] = [idi, maxHeighti] ，表示建筑 idi 的高度 不能超过 maxHeighti 。
 * 题目保证每栋建筑在 restrictions 中 至多出现一次 ，同时建筑 1 不会 出现在 restrictions 中。
 * 请你返回 最高 建筑能达到的 最高高度 。
 * <p>示例 1：
 * 输入：n = 5, restrictions = [[2,1],[4,1]]
 * 输出：2
 * 解释：上图中的绿色区域为每栋建筑被允许的最高高度。
 * 我们可以使建筑高度分别为 [0,1,2,1,2] ，最高建筑的高度为 2 。
 * <p>示例 2：
 * 输入：n = 6, restrictions = []
 * 输出：5
 * 解释：上图中的绿色区域为每栋建筑被允许的最高高度。
 * 我们可以使建筑高度分别为 [0,1,2,3,4,5] ，最高建筑的高度为 5 。
 * <p>示例 3：
 * 输入：n = 10, restrictions = [[5,3],[2,5],[7,4],[10,3]]
 * 输出：5
 * 解释：上图中的绿色区域为每栋建筑被允许的最高高度。
 * 我们可以使建筑高度分别为 [0,1,2,3,3,4,4,5,4,3] ，最高建筑的高度为 5 。
 * <p>提示：
 * 2 <= n <= 10^9
 * 0 <= restrictions.length <= min(n - 1, 105)
 * 2 <= idi <= n
 * idi 是 唯一的 。
 * 0 <= maxHeighti <= 10^9
 *
 * @author hc
 */
public class Demo5741 {

    /**
     * 首先，我们将所有限制条件按照坐标升序排列。
     * 我们首先从左到右，计算每个受限位置只考虑来自左边的约束时能取得的最大高度；
     * 然后从右到左，计算每个受限位置只考虑来自右边的约束时能取得的最大高度。
     * 这样我们就得到了每一个受限位置处的最大高度。这时，我们考虑相邻两个受限位置中间的区域能够取得的最大高度。
     * 假设左边的高度为 L，右边的高度为 R，中间的距离为 D，则我们在这段区间能取得的最大高度必须满足 H-L+H-R ≤ 2D，
     * 从而 H ≤ (L+R+2D) / 2
     * 需要注意的是，最右边的一个区间需要单独考虑，因为它只受到左约束，而没有右约束。
     * <p>时间复杂度 O(MlogM)，因为我们需要对限制条件进行排序。
     * 空间复杂度 O(M)。
     */
    public int maxBuilding(int n, int[][] restrictions) {
        int len = restrictions.length;
        if (len == 0) {
            return n - 1;
        }

        Arrays.sort(restrictions, Comparator.comparingInt(o -> o[0]));
        int[] l = new int[len];
        int[] r = new int[len];

        l[0] = Math.min(restrictions[0][1], restrictions[0][0] - 1);
        for (int i = 1; i < len; ++i) {
            int left = l[i - 1];
            int dist = restrictions[i][0] - restrictions[i - 1][0];
            l[i] = Math.min(restrictions[i][1], left + dist);
        }

        r[len - 1] = restrictions[len - 1][1];
        for (int i = len - 2; i >= 0; --i) {
            int right = r[i + 1];
            int dist = restrictions[i + 1][0] - restrictions[i][0];
            r[i] = Math.min(restrictions[i][1], right + dist);
        }

        int res = 0;
        for (int i = 0; i < len - 1; i++) {
            int lh = Math.min(l[i], r[i]);
            int rh = Math.min(l[i + 1], r[i + 1]);
            int dist = restrictions[i + 1][0] - restrictions[i][0];
            res = Math.max(res, (lh + rh + dist) >> 1);
        }

        return Math.max(res, n - restrictions[len - 1][0] + Math.min(l[len - 1], r[len - 1]));
    }

    public static void main(String[] args) {
        System.out.println(new Demo5741().maxBuilding(5, new int[][]{{2, 1}, {4, 1}}));
        System.out.println(new Demo5741().maxBuilding(10, new int[][]{{5, 3}, {2, 5}, {7, 4}, {10, 3}}));
    }
}
