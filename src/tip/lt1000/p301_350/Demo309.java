package tip.lt1000.p301_350;

/**
 * 给定一个整数数组，其中第 i 个元素代表了第 i 天的股票价格 。
 * 设计一个算法计算出最大利润。在满足以下约束条件下，你可以尽可能地完成更多的交易（多次买卖一支股票）:
 * 你不能同时参与多笔交易（你必须在再次购买前出售掉之前的股票）。
 * 卖出股票后，你无法在第二天买入股票 (即冷冻期为 1 天)。
 * <p>
 * 示例:
 * 输入: [1,2,3,0,2]
 * 输出: 3
 * 解释: 对应的交易状态为: [买入, 卖出, 冷冻期, 买入, 卖出]
 *
 * @author hc
 */
public class Demo309 {

    public int maxProfit(int[] prices) {
        if (prices.length == 0){return 0;}

        // 第 i 天持股
        int dp0 = -prices[0];
        // 第 i 天不持股，没卖出
        int dp1 = 0;
        // 第 i 天不持股，卖出
        int dp2 = 0;

        for (int i = 0; i < prices.length; i++) {
            int newDp0 = Math.max(dp0, dp1 - prices[i]);
            int newDp1 = Math.max(dp1,dp2);
            int newDp2 = dp0 + prices[i];

            dp0 = newDp0;
            dp1 = newDp1;
            dp2 = newDp2;
        }
        return Math.max(dp1,dp2);
    }

    public static void main(String[] args) {
        System.out.println(new Demo309().maxProfit(new int[]{1, 2, 3, 0, 2}));
    }
}
