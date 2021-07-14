package tips.p_1000.p101_150;

import java.util.List;

/**
 * 给定一个三角形 triangle ，找出自顶向下的最小路径和。
 * 每一步只能移动到下一行中相邻的结点上。
 * 相邻的结点 在这里指的是 下标 与 上一层结点下标 相同或者等于 上一层结点下标 + 1 的两个结点。
 * 也就是说，如果正位于当前行的下标 i ，那么下一步可以移动到下一行的下标 i 或 i + 1 。
 *
 * @author hc
 */
public class Demo120 {

    public int minimumTotal(List<List<Integer>> triangle) {
        int n = triangle.size();
        int ans = Integer.MAX_VALUE;
        int[][] f = new int[n][n];
        f[0][0] = triangle.get(0).get(0);
        for (int i = 1; i < n; i++) {
            for (int j = 0; j < i + 1; j++) {
                int val = triangle.get(i).get(j);
                f[i][j] = Integer.MAX_VALUE;
                if (j != 0) {
                    f[i][j] = Math.min(f[i][j], f[i - 1][j - 1] + val);
                }
                if (j != i) {
                    f[i][j] = Math.min(f[i][j], f[i - 1][j] + val);
                }
            }
        }
        for (int i = 0; i < n; i++) {
            ans = Math.min(ans, f[n - 1][i]);
        }
        return ans;
    }

    /**
     * dp[0]=11
     * dp[0]=9  dp[1]=10
     * dp[0]=7  dp[1]=6  dp[2]=10
     * dp[0]=4  dp[1]=1  dp[2]=8  dp[3]=3  dp[4]=0
     */
    public int minimumTotal2(List<List<Integer>> triangle) {
        int n = triangle.size();

        // 为了计算方便 j+1
        int[] dp = new int[n + 1];

        // 自底向上
        for (int i = n - 1; i >= 0; i--) {
            for (int j = 0; j <= i; j++) {
                // 找到行最小
                dp[j] = Math.min(dp[j], dp[j + 1]) + triangle.get(i).get(j);
            }
        }
        return dp[0];
    }
}
