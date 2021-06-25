package tips.f_109.f_10;

/**
 * 节点间通路。给定有向图，设计一个算法，找出两个节点之间是否存在一条路径。
 * <p>示例1:
 * 输入：n = 3, graph = [[0, 1], [0, 2], [1, 2], [1, 2]], start = 0, target = 2
 * 输出：true
 * <p>示例2:
 * 输入：n = 5, graph = [[0, 1], [0, 2], [0, 4], [0, 4], [0, 1], [1, 3], [1, 4], [1, 3], [2, 3], [3, 4]], start = 0, target = 4
 * 输出 true
 * <p>提示：
 * 节点数量n在[0, 1e5]范围内。
 * 节点编号大于等于 0 小于 n。
 * 图中可能存在自环和平行边。
 *
 * @author hc
 */
public class Face0401 {

    public boolean findWhetherExistsPath(int n, int[][] graph, int start, int target) {
        if (start == target) {
            return true;
        }
        for (int[] g : graph) {
            if (g[1] == target) {
                return findWhetherExistsPath(n, graph, start, g[0]);
            }
        }
        return false;
    }

    public boolean findWhetherExistsPath2(int n, int[][] graph, int start, int target) {
        // 考虑自环 增加 visited数组记录已遍历的节点
        boolean[] visited = new boolean[n + 1];
        if (dfs(n, graph, start, target, visited)) {
            return true;
        }
        return false;
    }

    private boolean dfs(int n, int[][] graph, int start, int target, boolean[] visited) {
        if (start == target) {
            return true;
        }

        visited[target] = true;
        for (int[] g : graph) {
            if (g[1] == target && !visited[g[0]]) {
                if (dfs(n, graph, start, g[0], visited)) {
                    return true;
                }
            }
        }
        return false;
    }
}
