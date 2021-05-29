package tips.p_others;

import java.util.HashMap;
import java.util.Map;

/**
 * 给出矩阵 matrix 和目标值 target，返回元素总和等于目标值的非空子矩阵的数量。
 * 子矩阵 x1, y1, x2, y2 是满足 x1 <= x <= x2 且 y1 <= y <= y2 的所有单元 matrix[x][y] 的集合。
 * 如果 (x1, y1, x2, y2) 和 (x1', y1', x2', y2') 两个子矩阵中部分坐标不同（如：x1 != x1'），
 * 那么这两个子矩阵也不同。
 * <p>示例 1：
 * 输入：matrix = [[0,1,0],[1,1,1],[0,1,0]], target = 0
 * 输出：4
 * 解释：四个只含 0 的 1x1 子矩阵。
 * <p>示例 2：
 * 输入：matrix = [[1,-1],[-1,1]], target = 0
 * 输出：5
 * 解释：两个 1x2 子矩阵，加上两个 2x1 子矩阵，再加上一个 2x2 子矩阵。
 * <p>示例 3：
 * 输入：matrix = [[904]], target = 0
 * 输出：0
 * <p>提示：
 * 1 <= matrix.length <= 100
 * 1 <= matrix[0].length <= 100
 * -1000 <= matrix[i] <= 1000
 * -10^8 <= target <= 10^8
 *
 * @author hc
 */
public class Demo1074 {

    public int numSubmatrixSumTarget(int[][] matrix, int target) {
        // 暴力法遍历
        int m = matrix.length, n = matrix[0].length;
        int[][] s = new int[m + 1][n + 1];
        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                s[i][j] = s[i - 1][j] + s[i][j - 1] - s[i - 1][j - 1] + matrix[i - 1][j - 1];
            }
        }

        int res = 0;
        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                for (int k = 1; k <= i; k++) {
                    for (int l = 1; l <= j; l++) {
                        int sum = s[i][j] - s[i][l - 1] - s[k - 1][j] + s[k - 1][l - 1];
                        if (target == sum) {
                            ++res;
                        }
                    }
                }
            }
        }
        return res;
    }

    public int numSubmatrixSumTarget2(int[][] matrix, int target) {
        int m = matrix.length, n = matrix[0].length;
        int[][] s = new int[m + 1][n + 1];
        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                s[i][j] = s[i - 1][j] + s[i][j - 1] - s[i - 1][j - 1] + matrix[i - 1][j - 1];
            }
        }
        int res = 0;
        for (int top = 1; top <= m; top++) {
            for (int bot = top; bot <= m; bot++) {
                Map<Integer, Integer> map = new HashMap<>();
                for (int r = 1; r <= n; r++) {
                    int cur = s[bot][r] - s[top - 1][r];
                    if (cur == target) {
                        res++;
                    }
                    if (map.containsKey(cur - target)) {
                        res += map.get(cur - target);
                    }
                    map.put(cur, map.getOrDefault(cur, 0) + 1);
                }
            }
        }
        return res;
    }
}
