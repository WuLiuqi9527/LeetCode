package o1_50;

/**
 * 地上有一个m行n列的方格，从坐标 [0,0] 到坐标 [m-1,n-1] 。
 * 一个机器人从坐标 [0, 0] 的格子开始移动，它每次可以向左、右、上、下移动一格（不能移动到方格外），
 * 也不能进入行坐标和列坐标的数位之和大于 k 的格子。
 * <p>示例 1：
 * 输入：m = 2, n = 3, k = 1
 * 输出：3
 * <p>示例 2：
 * 输入：m = 3, n = 1, k = 0
 * 输出：1
 * <p>提示：
 * 1 <= n,m <= 100
 * 0 <= k <= 20
 *
 * @author hc
 */
public class Offer13 {

    public int movingCount(int m, int n, int k) {
        boolean[][] used = new boolean[m][n];
        return dfs(0, 0, m, n, k, used);
    }

    private int dfs(int i, int j, int m, int n, int k, boolean[][] used) {
        boolean unreasonable = i < 0 || i >= m || j < 0 || j >= n;
        // 行坐标和列坐标的数位之和大于 k
        if (unreasonable || (i / 10 + i % 10 + j / 10 + j % 10) > k || used[i][j]) {
            return 0;
        }

        used[i][j] = true;

        return dfs(i + 1, j, m, n, k, used)
                + dfs(i - 1, j, m, n, k, used)
                + dfs(i, j + 1, m, n, k, used)
                + dfs(i, j - 1, m, n, k, used) + 1;
    }
}
