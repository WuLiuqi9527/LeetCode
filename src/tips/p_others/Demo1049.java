package tips.p_others;

import java.util.Arrays;
import java.util.Comparator;

/**
 * 有一堆石头，用整数数组 stones 表示。其中 stones[i] 表示第 i 块石头的重量。
 * 每一回合，从中选出任意两块石头，然后将它们一起粉碎。假设石头的重量分别为 x 和 y，且 x <= y。
 * 那么粉碎的可能结果如下：
 * 如果 x == y，那么两块石头都会被完全粉碎；
 * 如果 x != y，那么重量为 x 的石头将会完全粉碎，而重量为 y 的石头新重量为 y-x。
 * 最后，最多只会剩下一块 石头。返回此石头 最小的可能重量 。如果没有石头剩下，就返回 0。
 * <p>示例 1：
 * 输入：stones = [2,7,4,1,8,1]
 * 输出：1
 * 解释：
 * 组合 2 和 4，得到 2，所以数组转化为 [2,7,1,8,1]，
 * 组合 7 和 8，得到 1，所以数组转化为 [2,1,1,1]，
 * 组合 2 和 1，得到 1，所以数组转化为 [1,1,1]，
 * 组合 1 和 1，得到 0，所以数组转化为 [1]，这就是最优值。
 * <p>示例 2：
 * 输入：stones = [31,26,33,21,40]
 * 输出：5
 * <p>示例 3：
 * 输入：stones = [1,2]
 * 输出：1
 * <p>提示：
 * 1 <= stones.length <= 30
 * 1 <= stones[i] <= 100
 *
 * @author hc
 */
public class Demo1049 {

    public int lastStoneWeightII(int[] stones) {
        if (stones == null || stones.length <= 0) {
            return 0;
        }

        int sum = 0;
        for (int stone : stones) {
            sum += stone;
        }

        int maxWeight = sum >> 1;
        // dp[i] 表示，是否有子集数组，重量和为 i
        boolean[] dp = new boolean[maxWeight + 1];
        dp[0] = true;
        for (int stone : stones) {
            for (int i = maxWeight; i >= stone; --i) {
                dp[i] = dp[i] || dp[i - stone];
            }
        }

        for (int i = maxWeight; i >= 0; --i) {
            if (dp[i]) {
                return sum - 2 * i;
            }
        }
        return 0;
    }

    public static void main(String[] args) {
        System.out.println(new Demo1049().lastStoneWeightII(new int[]{2, 7, 4, 1, 8, 1}));
        System.out.println(new Demo1049().lastStoneWeightII(new int[]{31, 26, 33, 21, 40}));
        System.out.println(new Demo1049().lastStoneWeightII(new int[]{1, 2}));
    }
}
