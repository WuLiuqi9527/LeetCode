package tips.p_1000.p801_850;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 在有向图中，以某个节点为起始节点，从该点出发，每一步沿着图中的一条有向边行走。如果到达的节点是终点（即它没有连出的有向边），则停止。
 * 对于一个起始节点，如果从该节点出发，无论每一步选择沿哪条有向边行走，最后必然在有限步内到达终点，则将该起始节点称作是 安全 的。
 * 返回一个由图中所有安全的起始节点组成的数组作为答案。答案数组中的元素应当按 升序 排列。
 * 该有向图有 n 个节点，按 0 到 n - 1 编号，其中 n 是 graph 的节点数。
 * 图以下述形式给出：graph[i] 是编号 j 节点的一个列表，满足 (i, j) 是图的一条有向边。
 * <p>示例 1：
 * 输入：graph = [[1,2],[2,3],[5],[0],[5],[],[]]
 * 输出：[2,4,5,6]
 * 解释：示意图如上。
 * <p>示例 2：
 * 输入：graph = [[1,2,3,4],[1,2],[3,4],[0,4],[]]
 * 输出：[4]
 * <p>提示：
 * n == graph.length
 * 1 <= n <= 10^4
 * 0 <= graph[i].length <= n
 * graph[i] 按严格递增顺序排列。
 * 图中可能包含自环。
 * 图中边的数目在范围 [1, 4 * 10^4] 内。
 *
 * @author hc
 */
public class Demo802 {

    /**type
     * 0: 未访问
     * 1: 已访问
     * 2: 安全
     * 3: 成环
     */
    public List<Integer> eventualSafeNodes(int[][] graph) {
        List<Integer> res = new ArrayList<>();
        int n = graph.length;
        int[] type = new int[n];
        for (int i = 0; i < n; i++) {
            if (dfs(graph, i, type) == 2) {
                res.add(i);
            }
        }
        return res;
    }

    private int dfs(int[][] graph, int index, int[] type) {
        if (type[index] == 1) {
            return 3;
        }
        if (type[index] != 0) {
            // type[index] == 2 return 2 安全
            // type[index] == 3 return 3 成环
            return type[index];
        }

        type[index] = 1;
        for (int next : graph[index]) {
            if (dfs(graph, next, type) == 3) {
                return 3;
            }
        }
        type[index] = 2;
        return 2;
    }

    /**
     * 如果形成环的话就不加入，用flag[i]进行标记是否已经访问，如果重复访问说明成环，不加入
     * 每次都得遍历环时间复杂度很高
     *         Set<Integer> set = new HashSet<Integer>();//标记成环的点
     *         Set<Integer> f = new HashSet<Integer>();//标记安全的点
     */
    public List<Integer> eventualSafeNodes2(int[][] graph) {
        List<Integer> res = new ArrayList<>();
        int n = graph.length;
        boolean[] flag = new boolean[n];
        for (int i = 0; i < n; i++) {
            if (!dfs2(graph, i, flag)) {
                res.add(i);
            }
            Arrays.fill(flag, false);
        }
        return res;
    }

    private boolean dfs2(int[][] graph, int start, boolean[] flag) {
        if (flag[start]) {
            return true;
        }
        flag[start] = true;
        for (int next : graph[start]) {
            if (dfs2(graph, next, flag)) {
                return true;
            }
        }
        flag[start] = false;
        return false;
    }

    public static void main(String[] args) {
        new Demo802().eventualSafeNodes(new int[][]{{1, 2}, {2, 3}, {5}, {0}, {5}, {}, {}});
        new Demo802().eventualSafeNodes(new int[][]{{1, 2, 3, 4}, {1, 2}, {3, 4}, {0, 4}, {}});
    }
}
