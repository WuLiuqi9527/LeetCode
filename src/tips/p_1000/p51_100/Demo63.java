package tips.p_1000.p51_100;

/**
 * 一个机器人位于一个 m x n 网格的左上角 （起始点在下图中标记为“Start” ）。
 * 机器人每次只能向下或者向右移动一步。机器人试图达到网格的右下角（在下图中标记为“Finish”）。
 * 现在考虑网格中有障碍物。那么从左上角到右下角将会有多少条不同的路径？
 *
 * @author hc
 */
public class Demo63 {

    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        // dp 对内存消耗进行优化
        int row = obstacleGrid.length;
        int col = obstacleGrid[0].length;
        int[] f = new int[col];

        f[0] = obstacleGrid[0][0] == 0 ? 1 : 0;
        for (int i = 0; i < row; ++i) {
            for (int j = 0; j < col; ++j) {
                if (obstacleGrid[i][j] == 1) {
                    f[j] = 0;
                    continue;
                }
                if (j - 1 >= 0 && obstacleGrid[i][j - 1] == 0) {
                    f[j] += f[j - 1];
                }
            }
        }

        return f[col - 1];
    }

    public int uniquePathsWithObstacles2(int[][] obstacleGrid) {
        // 常规 dp
        if (obstacleGrid == null || obstacleGrid.length == 0) {
            return 0;
        }

        int row = obstacleGrid.length;
        int col = obstacleGrid[0].length;
        int[][] dp = new int[row][col];

        // 第 1 行的格子只有从其左边格子走过去这一种走法，因此初始化 dp[0][j] 值为 1，存在障碍物时为 0。
        for (int i = 0; i < row && obstacleGrid[i][0] == 0; i++) {
            dp[i][0] = 1;
        }
        // 第 1 列的格子只有从其上边格子走过去这一种走法，因此初始化 dp[i][0] 值为 1，存在障碍物时为 0；
        for (int j = 0; j < col && obstacleGrid[0][j] == 0; j++) {
            dp[0][j] = 1;
        }

        for (int i = 1; i < row; i++) {
            for (int j = 1; j < col; j++) {
                if (obstacleGrid[i][j] == 0) {
                    dp[i][j] = dp[i - 1][j] + dp[i][j - 1];
                }
            }
        }

        return dp[row - 1][col - 1];
    }

    public int uniquePathsWithObstacles3(int[][] obstacleGrid) {
        if (obstacleGrid == null || obstacleGrid.length == 0) {
            return 0;
        }

        int row = obstacleGrid.length;
        int col = obstacleGrid[0].length;
        int[][] dp = new int[row][col];
        dp[0][0] = 1;

        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (obstacleGrid[i][j] == 1) {
                    dp[i][j] = 0;
                } else {
                    if (i > 0 && j > 0) {
                        dp[i][j] = dp[i - 1][j] + dp[i][j - 1];
                    } else if (i > 0) {
                        dp[i][j] = dp[i - 1][j];
                    } else if (j > 0) {
                        dp[i][j] = dp[i][j - 1];
                    }
                }
            }
        }
        return dp[row - 1][col - 1];
    }

    public int uniquePathsWithObstacles4(int[][] obstacleGrid) {
        if (obstacleGrid == null || obstacleGrid.length == 0) {
            return 0;
        }

        int row = obstacleGrid.length;
        int col = obstacleGrid[0].length;
        int[][] dp = new int[row + 1][col + 1];
        dp[0][1] = 1;

        for (int i = 1; i <= row; i++) {
            for (int j = 1; j <= col; j++) {
                if (obstacleGrid[i - 1][j - 1] == 1) {
                    dp[i][j] = 0;
                } else {
                    dp[i][j] = dp[i - 1][j] + dp[i][j - 1];
                }
            }
        }
        return dp[row][col];
    }

    public int uniquePathsWithObstacles5(int[][] obstacleGrid) {
        if (obstacleGrid == null || obstacleGrid.length == 0) {
            return 0;
        }

        int row = obstacleGrid.length;
        int col = obstacleGrid[0].length;
        int[][] dp = new int[row + 1][col + 1];
        dp[0][1] = obstacleGrid[0][0] == 1 ? 0 : 1;

        for (int i = 1; i <= row; i++) {
            for (int j = 1; j <= col; j++) {
                if (obstacleGrid[i - 1][j - 1] != 1) {
                    dp[i][j] = dp[i - 1][j] + dp[i][j - 1];
                }
            }
        }
        return dp[row][col];
    }
}
