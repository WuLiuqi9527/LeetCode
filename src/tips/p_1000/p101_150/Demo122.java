package tips.p_1000.p101_150;

/**
 * 给定一个数组，它的第 i 个元素是一支给定股票第 i 天的价格。
 * 设计一个算法来计算你所能获取的最大利润。你可以尽可能地完成更多的交易（多次买卖一支股票）。
 * 注意：你不能同时参与多笔交易（你必须在再次购买前出售掉之前的股票）。
 * <p>示例 1:
 * 输入: [7,1,5,3,6,4]
 * 输出: 7
 * 解释: 在第 2 天（股票价格 = 1）的时候买入，在第 3 天（股票价格 = 5）的时候卖出, 这笔交易所能获得利润 = 5-1 = 4 。
 * 随后，在第 4 天（股票价格 = 3）的时候买入，在第 5 天（股票价格 = 6）的时候卖出, 这笔交易所能获得利润 = 6-3 = 3 。
 *
 * @author hc
 */
public class Demo122 {

    public int maxProfit(int[] prices) {
        if (prices == null || prices.length == 0) {
            return 0;
        }
        // 动态规划
        // 第 i 天只有两种状态，不持有或持有股票
        // 当天不持有股票的状态可能来自昨天卖出或者昨天也不持有，
        // 同理，当天持有股票的状态可能来自昨天买入或者昨天也持有
        // 取最后一天的不持有股票状态就是问题的解
        int len = prices.length;
        int[][] dp = new int[len][2];
        dp[0][0] = 0;
        dp[0][1] = -prices[0];
        for (int i = 1; i < len; i++) {
            dp[i][0] = Math.max(dp[i - 1][0], dp[i - 1][1] + prices[i]);
            dp[i][1] = Math.max(dp[i - 1][1], dp[i - 1][0] - prices[i]);
        }
        return dp[len - 1][0];
    }

    public int maxProfit2(int[] prices) {
        if (prices == null || prices.length == 0) {
            return 0;
        }
        // 动态规划 优化空间
        int len = prices.length;
        int dp0 = 0;
        int dp1 = -prices[0];
        for (int i = 1; i < len; i++) {
            dp0 = Math.max(dp0, dp1 + prices[i]);
            dp1 = Math.max(dp1, dp0 - prices[i]);
        }
        return dp0;
    }

    public int maxProfit3(int[] prices) {
        if (prices == null || prices.length == 0) {
            return 0;
        }
        // 贪心 有高价就卖
        int res = 0;
        int len = prices.length;
        for (int i = 1; i < len; i++) {
            if (prices[i]> prices[i-1]){
                res += prices[i] - prices[i-1];
            }
        }
        return res;
    }

    public static void main(String[] args) {
        System.out.println(new Demo122().maxProfit2(new int[]{7, 1, 5, 3, 6, 4}));
    }
}
