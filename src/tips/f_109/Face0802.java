package tips.f_109;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 设想有个机器人坐在一个网格的左上角，网格 r 行 c 列。
 * 机器人只能向下或向右移动，但不能走到一些被禁止的网格（有障碍物）。
 * 设计一种算法，寻找机器人从左上角移动到右下角的路径。
 *
 * @author hc
 */
public class Face0802 {

    List<List<Integer>> path;
    int row, col;

    public List<List<Integer>> pathWithObstacles(int[][] obstacleGrid) {

        path = new ArrayList<>();
        row = obstacleGrid.length;
        if (row == 0) {
            return path;
        }
        col = obstacleGrid[0].length;
        if (obstacleGrid[row - 1][col - 1] == 1) {
            return path;
        }

        boolean[][] used = new boolean[row][col];
        dfs(obstacleGrid, 0, 0, used);
        return path;
    }

    private boolean dfs(int[][] obstacleGrid, int x, int y, boolean[][] used) {
        if (x >= row || y >= col || obstacleGrid[x][y] == 1 || used[x][y]) {
            return false;
        }

        path.add(Arrays.asList(x, y));
        used[x][y] = true;
        if (x == row - 1 && y == col - 1) {
            return true;
        }
        if (dfs(obstacleGrid, x + 1, y, used) || dfs(obstacleGrid, x, y + 1, used)) {
            return true;
        }
        path.remove(path.size() - 1);
        return false;
    }
}
