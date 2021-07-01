package tips.p_others;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

/**
 * 小朋友 A 在和 ta 的小伙伴们玩传信息游戏，游戏规则如下：
 * 有 n 名玩家，所有玩家编号分别为 0 ～ n-1，其中小朋友 A 的编号为 0
 * 每个玩家都有固定的若干个可传信息的其他玩家（也可能没有）。传信息的关系是单向的（比如 A 可以向 B 传信息，但 B 不能向 A 传信息）。
 * 每轮信息必须需要传递给另一个人，且信息可重复经过同一个人
 * 给定总玩家数 n，以及按 [玩家编号,对应可传递玩家编号] 关系组成的二维数组 relation。返回信息从小 A (编号 0 ) 经过 k 轮传递到编号为 n-1 的小伙伴处的方案数；若不能到达，返回 0。
 * <p>示例 1：
 * 输入：n = 5, relation = [[0,2],[2,1],[3,4],[2,3],[1,4],[2,0],[0,4]], k = 3
 * 输出：3
 * 解释：信息从小 A 编号 0 处开始，经 3 轮传递，到达编号 4。共有 3 种方案，分别是 0->2->0->4， 0->2->1->4， 0->2->3->4。
 * <p>示例 2：
 * 输入：n = 3, relation = [[0,2],[2,1]], k = 2
 * 输出：0
 * 解释：信息不能从小 A 处经过 2 轮传递到编号 2
 * <p>限制：
 * 2 <= n <= 10
 * 1 <= k <= 5
 * 1 <= relation.length <= 90, 且 relation[i].length == 2
 * 0 <= relation[i][0],relation[i][1] < n 且 relation[i][0] != relation[i][1]
 *
 * @author hc
 */
public class LCP07 {

    public int numWays(int n, int[][] relation, int k) {
        // BFS
        int step = 0, count = 0;
        Queue<Integer> queue = new LinkedList<>();
        // 编号从0开始
        queue.add(0);
        while (!queue.isEmpty()) {
            for (int i = queue.size() - 1; i >= 0; i--) {
                int cur = queue.poll();
                if (step == k && cur == n - 1) {
                    ++count;
                    continue;
                }

                ArrayList<Integer> nexts = next(relation, cur);
                for (int next : nexts) {
                    queue.add(next);
                }
            }
            ++step;
            if (step > k) {
                break;
            }
        }
        return count;
    }

    private ArrayList<Integer> next(int[][] relation, int cur) {
        ArrayList<Integer> res = new ArrayList<>();
        for (int[] r : relation) {
            if (r[0] == cur) {
                res.add(r[1]);
            }
        }
        return res;
    }

    private int res = 0;

    public int numWays2(int n, int[][] relation, int k) {
        //DFS
        for (int i = relation.length - 1; i >= 0; i--) {
            if (relation[i][0] == 0) {
                dfs(relation, relation[i][1], 1, k, n);
            }
        }
        return res;
    }

    private void dfs(int[][] relation, int end, int step, int k, int n) {
        if (step == k && end == n - 1) {
            ++res;
            return;
        }
        if (step > k) {
            return;
        }

        for (int i = relation.length - 1; i >= 0; i--) {
            if (relation[i][0] == end) {
                dfs(relation, relation[i][1], step + 1, k, n);
            }
        }
    }

    public int numWays3(int n, int[][] relation, int k) {
        // dp[i][j] 第 i 轮传递给编号为 j 的方案数
        int[][] dp = new int[k + 1][n];
        // 编号从 0 开始
        dp[0][0] = 1;
        for (int i = 1; i <= k; i++) {
            for (int[] r : relation) {
                dp[i][r[1]] += dp[i - 1][r[0]];
            }
        }
        return dp[k][n - 1];
    }
}
