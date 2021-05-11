package tip.lt1000.p401_450;

import java.util.ArrayList;
import java.util.List;

/**
 * 给定一个 m x n 的非负整数矩阵来表示一片大陆上各个单元格的高度。
 * “太平洋”处于大陆的左边界和上边界，而“大西洋”处于大陆的右边界和下边界。
 * 规定水流只能按照上、下、左、右四个方向流动，且只能从高到低或者在同等高度上流动。
 * 请找出那些水流既可以流动到“太平洋”，又能流动到“大西洋”的陆地单元的坐标。
 * 提示：
 * 输出坐标的顺序不重要
 * m 和 n 都小于150
 * <p>
 * 示例：
 * 给定下面的 5x5 矩阵:
 * 太平洋 ~   ~   ~   ~   ~
 * ~  1   2   2   3  (5) *
 * ~  3   2   3  (4) (4) *
 * ~  2   4  (5)  3   1  *
 * ~ (6) (7)  1   4   5  *
 * ~ (5)  1   1   2   4  *
 * *   *   *   *   * 大西洋
 * <p>
 * 返回:
 * [[0, 4], [1, 3], [1, 4], [2, 2], [3, 0], [3, 1], [4, 0]] (上图中带括号的单元).
 *
 * @author hc
 */
public class Demo417 {

    int row, col;
    List<List<Integer>> res;
    int[][] dir = new int[][]{{1, 0}, {-1, 0}, {0, 1}, {0, -1}};

    public List<List<Integer>> pacificAtlantic(int[][] matrix) {

        res = new ArrayList<>();
        if (matrix == null || matrix.length == 0) {
            return res;
        }

        row = matrix.length;
        col = matrix[0].length;
        boolean[][] pa = new boolean[row][col];
        boolean[][] at = new boolean[row][col];

        for (int i = 0; i < row; i++) {
            dfs(matrix, pa, i, 0);
            dfs(matrix, at, i, col - 1);
        }
        for (int j = 0; j < col; j++) {
            dfs(matrix, pa, 0, j);
            dfs(matrix, at, row - 1, j);
        }

        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (pa[i][j] && at[i][j]) {
                    List<Integer> list = new ArrayList<>();
                    list.add(i);
                    list.add(j);
                    res.add(list);
                }
            }
        }
        return res;
    }

    private void dfs(int[][] matrix, boolean[][] sea, int i, int j) {

        sea[i][j] = true;
        for (int k = 0; k < 4; k++) {
            int nextI = i + dir[k][0];
            int nextJ = j + dir[k][1];

            if (isReasonable(nextI, nextJ) && matrix[i][j] <= matrix[nextI][nextJ] && !sea[nextI][nextJ]) {
                dfs(matrix, sea, nextI, nextJ);
            }
        }
    }

    private boolean isReasonable(int i, int j) {
        return i >= 0 && i < row && j >= 0 && j < col;
    }
}
