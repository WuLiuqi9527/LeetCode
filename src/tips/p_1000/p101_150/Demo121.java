package tips.p_1000.p101_150;

/**
 * 给定一个数组 prices ，prices[i] 表示一支给定股票第 i 天的价格。
 * 你只能选择 某一天 买入这只股票，并选择在 未来的某一个不同的日子 卖出该股票。
 * 设计一个算法来计算你所能获取的最大利润。它的第 i 个元素
 * 返回你可以从这笔交易中获取的最大利润。如果你不能获取任何利润，返回 0 。
 * <p>
 * 示例 1：
 * 输入：[7,1,5,3,6,4]
 * 输出：5
 * 解释：在第 2 天（股票价格 = 1）的时候买入，在第 5 天（股票价格 = 6）的时候卖出，最大利润 = 6-1 = 5 。
 * 注意利润不能是 7-1 = 6, 因为卖出价格需要大于买入价格；同时，你不能在买入前卖出股票。
 *
 * @author hc
 */
public class Demo121 {

    public int maxProfit(int[] prices) {
        int res = 0;
        int min = prices[0];
        int len = prices.length;
        for (int i = 1; i < len; i++) {
            res = Math.max(prices[i] - min, res);
            min = Math.min(min, prices[i]);
        }

        return res;
    }

    public static void main(String[] args) {
        System.out.println(new Demo121().maxProfit(new int[]{7, 1, 5, 3, 6, 4}));
        System.out.println(new Demo121().maxProfit(new int[]{7, 6, 4, 3, 1}));
        System.out.println(new Demo121().maxProfit(new int[]{1, 2}));
    }
}
