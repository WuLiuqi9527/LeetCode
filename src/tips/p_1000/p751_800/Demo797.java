package tips.p_1000.p751_800;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

/**
 * 给你一个有 n 个节点的 有向无环图（DAG），请你找出所有从节点 0 到节点 n-1 的路径并输出（不要求按特定顺序）
 * 二维数组的第 i 个数组中的单元都表示有向图中 i 号节点所能到达的下一些节点，空就是没有下一个结点了。
 * 译者注：有向图是有方向的，即规定了 a→b 你就不能从 b→a 。
 * <p>示例 1：
 * 输入：graph = [[1,2],[3],[3],[]]
 * 输出：[[0,1,3],[0,2,3]]
 * 解释：有两条路径 0 -> 1 -> 3 和 0 -> 2 -> 3
 * <p>示例 2：
 * 输入：graph = [[4,3,1],[3,2,4],[3],[4],[]]
 * 输出：[[0,4],[0,3,4],[0,1,3,4],[0,1,2,3,4],[0,1,4]]
 * <p>示例 3：
 * 输入：graph = [[1],[]]
 * 输出：[[0,1]]
 * <p>示例 4：
 * 输入：graph = [[1,2,3],[2],[3],[]]
 * 输出：[[0,1,2,3],[0,2,3],[0,3]]
 * <p>示例 5：
 * 输入：graph = [[1,3],[2],[3],[]]
 * 输出：[[0,1,2,3],[0,3]]
 * <p>提示：
 * n == graph.length
 * 2 <= n <= 15
 * 0 <= graph[i][j] < n
 * graph[i][j] != i（即，不存在自环）
 * graph[i] 中的所有元素 互不相同
 * 保证输入为 有向无环图（DAG）
 *
 * @author hc
 */
public class Demo797 {

    List<List<Integer>> ans = new ArrayList<>();
    Deque<Integer> stack = new ArrayDeque<>();

    public List<List<Integer>> allPathsSourceTarget(int[][] graph) {
        stack.offerLast(0);
        dfs(graph, 0, graph.length - 1);
        return ans;
    }

    public void dfs(int[][] graph, int x, int n) {
        if (x == n) {
            ans.add(new ArrayList<>(stack));
            return;
        }
        for (int y : graph[x]) {
            stack.offerLast(y);
            dfs(graph, y, n);
            stack.pollLast();
        }
    }
}
