package tips.p_1000.p201_250;

/**
 * 在一个由 '0' 和 '1' 组成的二维矩阵内，找到只包含 '1' 的最大正方形，并返回其面积。
 * <p>示例 1：
 * 输入：matrix = [["1","0","1","0","0"],["1","0","1","1","1"],["1","1","1","1","1"],["1","0","0","1","0"]]
 * 输出：4
 * <p>提示：
 * m == matrix.length
 * n == matrix[i].length
 * 1 <= m, n <= 300
 * matrix[i][j] 为 '0' 或 '1'
 *
 * @author hc
 */
public class Demo221 {

    public int maximalSquare(char[][] matrix) {

        /**
         * dp[i][j]表示以第 i 行第 j 列为 右下角 所能构成的最大正方形边长, 则递推式为:
         *   dp[i][j] = 1 + min(dp[i-1][j-1], dp[i-1][j], dp[i][j-1]);
         **/
        int max = 0;
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
            return max;
        }

        int row = matrix.length, col = matrix[0].length;
        int[][] dp = new int[row][col];

        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (matrix[i][j] == '1') {
                    if (i == 0 || j == 0) {
                        dp[i][j] = 1;
                    } else {
                        dp[i][j] = 1 + Math.min(dp[i - 1][j - 1], Math.min(dp[i][j - 1], dp[i - 1][j]));
                    }
                    max = Math.max(max, dp[i][j]);
                }
            }
        }
        return max * max;
    }
}
