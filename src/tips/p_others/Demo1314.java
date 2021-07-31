package tips.p_others;

/**
 * 给你一个 m x n 的矩阵 mat 和一个整数 k ，请你返回一个矩阵 answer ，其中每个 answer[i][j] 是所有满足下述条件的元素 mat[r][c] 的和：
 * i - k <= r <= i + k,
 * j - k <= c <= j + k 且
 * (r, c) 在矩阵内。
 * <p>示例 1：
 * 输入：mat = [[1,2,3],[4,5,6],[7,8,9]], k = 1
 * 输出：[[12,21,16],[27,45,33],[24,39,28]]
 * <p>示例 2：
 * 输入：mat = [[1,2,3],[4,5,6],[7,8,9]], k = 2
 * 输出：[[45,45,45],[45,45,45],[45,45,45]]
 * <p>提示：
 * m == mat.length
 * n == mat[i].length
 * 1 <= m, n, k <= 100
 * 1 <= mat[i][j] <= 100
 *
 * @author hc
 */
public class Demo1314 {

    public int[][] matrixBlockSum(int[][] mat, int k) {
        // 暴力
        int m = mat.length, n = mat[0].length;
        int[][] res = new int[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                int sum = 0;
                for (int r = Math.max(i - k, 0); r <= Math.min(i + k, m - 1); r++) {
                    for (int c = Math.max(j - k, 0); c <= Math.min(j + k, n - 1); c++) {
                        sum += mat[r][c];
                    }
                }
                res[i][j] = sum;
            }
        }
        return res;
    }

    public int[][] matrixBlockSum2(int[][] mat, int k) {
        // 前缀和
        int row = mat.length;
        int col = mat[0].length;
        int[][] res = new int[row][col];
        int[][] preSum = new int[row + 1][col + 1];
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                preSum[i + 1][j + 1] = preSum[i][j + 1] + preSum[i + 1][j] - preSum[i][j] + mat[i][j];
            }
        }
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                // 左上角坐标
                int r1 = Math.max(i - k, 0);
                int c1 = Math.max(j - k, 0);
                // 右下角坐标
                int r2 = Math.min(i + k, row - 1);
                int c2 = Math.min(j + k, col - 1);
                res[i][j] = preSum[r2 + 1][c2 + 1] - preSum[r1][c2 + 1] - preSum[r2 + 1][c1] + preSum[r1][c1];
            }
        }
        return res;
    }
}
