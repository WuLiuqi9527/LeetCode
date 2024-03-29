package tips.p_1000.p551_600;

/**
 * 给你一个大小为 m x n 的网格和一个球。球的起始坐标为 [startRow, startColumn] 。
 * 你可以将球移到在四个方向上相邻的单元格内（可以穿过网格边界到达网格之外）。你 最多 可以移动 maxMove 次球。
 * 给你五个整数 m、n、maxMove、startRow 以及 startColumn ，找出并返回可以将球移出边界的路径数量。
 * 因为答案可能非常大，返回对 109 + 7 取余 后的结果。
 * <p>示例 1：
 * 输入：m = 2, n = 2, maxMove = 2, startRow = 0, startColumn = 0
 * 输出：6
 * <p>示例 2：
 * 输入：m = 1, n = 3, maxMove = 3, startRow = 0, startColumn = 1
 * 输出：12
 * <p>提示：
 * 1 <= m, n <= 50
 * 0 <= maxMove <= 50
 * 0 <= startRow < m
 * 0 <= startColumn < n
 *
 * @author hc
 */
public class Demo576 {

    int MOD = (int) 1e9 + 7;
    int m, n, max;
    int[][] dirs = new int[][]{{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
    int[][][] cache;

    public int findPaths(int m, int n, int maxMove, int startRow, int startColumn) {
        this.m = m;
        this.n = n;
        this.max = maxMove;
        cache = new int[m][n][max + 1];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                for (int k = 0; k <= max; k++) {
                    cache[i][j][k] = -1;
                }
            }
        }
        // 记忆化搜索
        return dfs(startRow, startColumn, max);
    }

    int dfs(int x, int y, int k) {
        // 当前到达了棋盘外的位置，说明找到了一条出界路径，返回 1；
        if (x < 0 || x >= m || y < 0 || y >= n) {
            return 1;
        }
        // 在前面条件不满足的前提下，当剩余步数为 0（不能再走下一步）
        // 说明没有找到一条合法的出界路径，返回 0。
        if (k == 0) {
            return 0;
        }
        if (cache[x][y][k] != -1) {
            return cache[x][y][k];
        }

        int ans = 0;
        for (int[] d : dirs) {
            int nx = x + d[0], ny = y + d[1];
            ans += dfs(nx, ny, k - 1);
            ans %= MOD;
        }

        cache[x][y][k] = ans;
        return ans;
    }
}
