package tip.p301_350;

import java.util.Arrays;

/**
 * 给定不同面额的硬币 coins 和一个总金额 amount。
 * 编写一个函数来计算可以凑成总金额所需的最少的硬币个数。
 * 如果没有任何一种硬币组合能组成总金额，返回 -1。
 * 你可以认为每种硬币的数量是无限的。
 * <p>
 * 示例 1：
 * 输入：coins = [1, 2, 5], amount = 11
 * 输出：3
 * 解释：11 = 5 + 5 + 1
 *
 * @author hc
 */
public class Demo322 {

    public int coinChange(int[] coins, int amount) {

        if (amount <= 0 || coins.length == 0) {
            return -1;
        }

        Arrays.sort(coins);
        if (coins[0] > amount) {
            return -1;
        }

        int count = 0;
        for (int i = coins.length - 1; i >= 0; i--) {

            count += Math.floor(amount / coins[i]);
            if (amount / coins[i] >= 1) {
                amount = amount % coins[i];
            }
        }
        return count;
    }

    public int coinChange2(int[] coins, int amount) {

        if (coins.length == 0) {
            return -1;
        }

        // amount 背包重量
        int[] memo = new int[amount + 1];
        Arrays.fill(memo, amount + 1);

        memo[0] = 0;
        for (int i = 1; i <= amount; i++) {
            for (int j = 0; j < coins.length; j++) {
                if (i - coins[j] >= 0){
                    memo[i] = Math.min(memo[i], memo[i - coins[j]] + 1);
                }
            }
        }
        return memo[amount] == amount + 1 ? -1 : memo[amount];
    }

    public static void main(String[] args) {
        System.out.println(new Demo322().coinChange2(new int[]{1, 2, 5}, 11));
        System.out.println(new Demo322().coinChange2(new int[]{2}, 3));
        System.out.println(new Demo322().coinChange2(new int[]{1}, 0));
        System.out.println(new Demo322().coinChange2(new int[]{1}, 1));
        System.out.println(new Demo322().coinChange2(new int[]{1}, 2));
    }
}
