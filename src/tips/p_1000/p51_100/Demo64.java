package tips.p_1000.p51_100;

/**
 * 给定一个包含非负整数的 m x n 网格 grid ，
 * 请找出一条从左上角到右下角的路径，使得路径上的数字总和为最小。
 * 说明：每次只能向下或者向右移动一步。
 * <p>
 * 输入：grid = [[1,3,1],[1,5,1],[4,2,1]]
 * 输出：7
 * 解释：因为路径 1→3→1→1→1 的总和最小。
 *
 * @author hc
 */
public class Demo64 {

    public int minPathSum(int[][] grid) {
        if (grid == null || grid.length == 0) {
            return 0;
        }

        int row = grid.length;
        int col = grid[0].length;
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (i == 0 && j == 0) {
                    continue;
                }
                if (i == 0) {
                    grid[i][j] = grid[i][j - 1] + grid[i][j];
                } else if (j == 0) {
                    grid[i][j] = grid[i - 1][j] + grid[i][j];
                } else {
                    grid[i][j] = Math.min(grid[i - 1][j], grid[i][j - 1]) + grid[i][j];
                }
            }
        }
        return grid[row - 1][col - 1];
    }

    public int minPathSum2(int[][] grid) {
        if (grid == null || grid.length == 0) {
            return 0;
        }

        int row = grid.length, col = grid[0].length;
        int[][] dp = new int[row][col];
        dp[0][0] = grid[0][0];
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (i > 0 && j > 0) {
                    dp[i][j] = Math.min(dp[i - 1][j], dp[i][j - 1]) + grid[i][j];
                } else if (i > 0) {
                    dp[i][j] = dp[i - 1][j] + grid[i][j];
                } else if (j > 0) {
                    dp[i][j] = dp[i][j - 1] + grid[i][j];
                }
            }
        }
        return dp[row - 1][col - 1];
    }

    public static void main(String[] args) {
        System.out.println(new Demo64().minPathSum(new int[][]{{1,2, 4,7}, {7,1, 2, 2},{8,0,5,1}, {7,6,0,0}}));
        System.out.println(new Demo64().minPathSum(new int[][]{{1, 3, 1}, {1, 5, 1}, {4, 2, 1}}));
        System.out.println(new Demo64().minPathSum2(new int[][]{{1, 3, 1}, {1, 5, 1}, {4, 2, 1}}));
    }
}
