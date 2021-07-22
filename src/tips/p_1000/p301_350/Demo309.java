package tips.p_1000.p301_350;

/**
 * 给定一个整数数组，其中第 i 个元素代表了第 i 天的股票价格 。
 * 设计一个算法计算出最大利润。在满足以下约束条件下，你可以尽可能地完成更多的交易（多次买卖一支股票）:
 * 你不能同时参与多笔交易（你必须在再次购买前出售掉之前的股票）。
 * 卖出股票后，你无法在第二天买入股票 (即冷冻期为 1 天)。
 * <p>示例:
 * 输入: [1,2,3,0,2]
 * 输出: 3
 * 解释: 对应的交易状态为: [买入, 卖出, 冷冻期, 买入, 卖出]
 *
 * @author hc
 */
public class Demo309 {

    public int maxProfit(int[] prices) {
        if (prices == null || prices.length == 0) {
            return 0;
        }
        // 由于可以无限次交易, 所以只定义两个维度, 第一个维度是天数, 第二个维度表示是否持有股票
        // 0 表示不持有, 1 表示持有, 2 表示过渡期
        int[][] dp = new int[prices.length][3];
        dp[0][0] = 0;
        dp[0][1] = -prices[0];
        dp[0][2] = 0;
        for (int i = 1; i < prices.length; i++) {
            // 第i天不持有股票的情况有两种
            // a.第 i-1 天也不持有股票
            // b.第 i-1 天是过渡期
            dp[i][0] = Math.max(dp[i - 1][0], dp[i - 1][2]);
            // 第 i 天持有股票有两种情况
            // a.第 i-1 天也持有股票, 第i天不操作
            // b.第 i-1 天不持有股票, 在第i天买入
            dp[i][1] = Math.max(dp[i - 1][1], dp[i - 1][0] - prices[i]);
            // 第 i 天是冷冻期只有一种情况, 第 i-1 天持有股票且卖出
            dp[i][2] = dp[i - 1][1] + prices[i];
        }
        // 最后最大利润为最后一天, 不持有股票或者进入冷冻期的情况
        return Math.max(dp[prices.length - 1][0], dp[prices.length - 1][2]);
    }

    public int maxProfit2(int[] prices) {
        // 优化空间
        if (prices == null || prices.length == 0) {
            return 0;
        }

        int dp0 = 0;
        int dp1 = -prices[0];
        int dp2 = 0;

        for (int i = 1; i < prices.length; i++) {
            dp0 = Math.max(dp0, dp2);
            dp1 = Math.max(dp1, dp0 - prices[i]);
            dp2 = dp1 + prices[i];
        }
        return Math.max(dp0, dp2);
    }

    public static void main(String[] args) {
        System.out.println(new Demo309().maxProfit(new int[]{1, 2, 3, 0, 2}));
    }
}
