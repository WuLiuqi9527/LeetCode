package tips.o51_100;

/**
 * 假设把某股票的价格按照时间先后顺序存储在数组中，请问买卖该股票一次可能获得的最大利润是多少？
 * <p>示例 1:
 * 输入: [7,1,5,3,6,4]
 * 输出: 5
 * 解释: 在第 2 天（股票价格 = 1）的时候买入，在第 5 天（股票价格 = 6）的时候卖出，最大利润 = 6-1 = 5 。
 * 注意利润不能是 7-1 = 6, 因为卖出价格需要大于买入价格。
 * <p>示例 2:
 * 输入: [7,6,4,3,1]
 * 输出: 0
 * 解释: 在这种情况下, 没有交易完成, 所以最大利润为 0。
 * <p>限制：
 * 0 <= 数组长度 <= 10^5
 *
 * @author hc
 */
public class Offer63 {

    public int maxProfit(int[] prices) {

        int len = prices.length;
        if (len <= 1) {
            return 0;
        }
        int min = prices[0], res = 0;
        for (int i = 1; i < len; i++) {
            // 先计算 res 再更新 min, 保证了当下 min = prices[i]之前的所有数中的最小值
            res = prices[i] - min > res ? prices[i] - min : res;
            min = prices[i] < min ? prices[i] : min;
        }
        return res;
    }

    public static void main(String[] args) {
        System.out.println(new Offer63().maxProfit(new int[]{7, 1, 5, 3, 6, 4}));
    }
}
