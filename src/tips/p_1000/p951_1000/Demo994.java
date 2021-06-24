package tips.p_1000.p951_1000;

import java.util.Deque;
import java.util.LinkedList;

/**
 * 在给定的网格中，每个单元格可以有以下三个值之一：
 * 值 0 代表空单元格；
 * 值 1 代表新鲜橘子；
 * 值 2 代表腐烂的橘子。
 * 每分钟，任何与腐烂的橘子（在 4 个正方向上）相邻的新鲜橘子都会腐烂。
 * 返回直到单元格中没有新鲜橘子为止所必须经过的最小分钟数。如果不可能，返回 -1。
 * <p>示例 1：
 * 输入：[[2,1,1],[1,1,0],[0,1,1]]
 * 输出：4
 * <p>示例 2：
 * 输入：[[2,1,1],[0,1,1],[1,0,1]]
 * 输出：-1
 * 解释：左下角的橘子（第 2 行， 第 0 列）永远不会腐烂，因为腐烂只会发生在 4 个正向上。
 * <p>示例 3：
 * 输入：[[0,2]]
 * 输出：0
 * 解释：因为 0 分钟时已经没有新鲜橘子了，所以答案就是 0 。
 * <p>提示：
 * 1 <= grid.length <= 10
 * 1 <= grid[0].length <= 10
 * grid[i][j] 仅为 0、1 或 2
 *
 * @author hc
 */
public class Demo994 {

    public int orangesRotting(int[][] grid) {
        // BFS
        if (grid == null || grid.length == 0) {
            return 0;
        }
        int m = grid.length, n = grid[0].length;
        int fresh = 0;
        Deque<int[]> deque = new LinkedList<>();
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 2) {
                    deque.add(new int[]{i, j});
                } else if (grid[i][j] == 1) {
                    ++fresh;
                }
            }
        }

        int time = 0;
        int[] dx = new int[]{1, -1, 0, 0};
        int[] dy = new int[]{0, 0, 1, -1};
        while (!deque.isEmpty() && fresh > 0) {
            ++time;
            int size = deque.size();
            for (int i = 0; i < size; i++) {
                int[] tem = deque.poll();
                for (int j = 0; j < 4; j++) {
                    int x = tem[0] + dx[j], y = tem[1] + dy[j];
                    if (x >= 0 && x < m && y >= 0 && y < n && grid[x][y] == 1) {
                        grid[x][y] = 2;
                        --fresh;
                        deque.add(new int[]{x, y});
                    }
                }
            }
        }

        if (fresh > 0) {
            return -1;
        }
        return time;
    }

    public int orangesRotting2(int[][] grid) {
        // DFS
        if (grid == null || grid.length == 0) {
            return 0;
        }

        int m = grid.length, n = grid[0].length;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 2) {
                    dfs(grid, i, j, 2);
                }
            }
        }

        int maxSteep = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 1) {
                    return -1;
                } else {
                    maxSteep = Math.max(maxSteep, grid[i][j]);
                }
            }
        }
        return maxSteep == 0 ? 0 : maxSteep - 2;
    }

    private void dfs(int[][] grid, int i, int j, int steep) {
        // steep用来记录传染路径的长度（当然最后要减2）
        if (i < 0 || i >= grid.length || j < 0 || j >= grid[0].length) {
            return;
        }

        // 只有新鲜橘子或者传播路径比当前路径长的橘子，才继续进行传播。
        if (grid[i][j] != 1 && grid[i][j] < steep) {
            return;
        }

        grid[i][j] = steep;
        ++steep;
        dfs(grid, i - 1, j, steep);
        dfs(grid, i + 1, j, steep);
        dfs(grid, i, j - 1, steep);
        dfs(grid, i, j + 1, steep);
    }
}
