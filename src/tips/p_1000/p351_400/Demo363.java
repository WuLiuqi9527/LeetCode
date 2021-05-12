package tips.p_1000.p351_400;

/**
 * 给你一个 m x n 的矩阵 matrix 和一个整数 k ，找出并返回矩阵内部矩形区域的不超过 k 的最大数值和。
 * <p>题目数据保证总会存在一个数值和不超过 k 的矩形区域。
 * <p>提示：
 * m == matrix.length
 * n == matrix[i].length
 * 1 <= m, n <= 100
 * -100 <= matrix[i][j] <= 100
 * -10^5 <= k <= 10^5
 *
 * @author hc
 */
public class Demo363 {

    public int maxSumSubmatrix(int[][] matrix, int k) {
        // 二维前缀和

        int m = matrix.length;
        int n = matrix[0].length;
        int[][] sum = new int[m + 1][n + 1];
        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                sum[i][j] = sum[i][j - 1] + sum[i - 1][j] - sum[i-1][j-1] + matrix[i-1][j-1];
            }
        }

        int res = Integer.MIN_VALUE;
        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                for (int p = i; p <= m; p++) {
                    for (int q = j; q <= n; q++) {
                        int cur = sum[p][q] - sum[i - 1][q] - sum[p][j - 1] + sum[i-1][j-1];
                        res = cur <= k ? Math.max(res, cur) : res;
                    }
                }
            }
        }
        return res;
    }

    public static void main(String[] args) {
        System.out.println(new Demo363().maxSumSubmatrix(new int[][]{{1, 0, 1}, {0, -2, 3}}, 2));
        System.out.println(new Demo363().maxSumSubmatrix(new int[][]{{2, 2, -1}}, 3));
    }
    }
