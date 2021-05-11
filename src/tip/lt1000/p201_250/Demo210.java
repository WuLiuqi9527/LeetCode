package tip.lt1000.p201_250;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;

/**
 * 现在你总共有 n 门课需要选，记为 0 到 n-1。
 * 在选修某些课程之前需要一些先修课程。
 * 例如，想要学习课程 0 ，你需要先完成课程 1 ，我们用一个匹配来表示他们: [0,1]
 * 给定课程总量以及它们的先决条件，返回你为了学完所有课程所安排的学习顺序。
 * 可能会有多个正确的顺序，你只要返回一种就可以了。如果不可能完成所有课程，返回一个空数组。
 * <p>示例 1:
 * 输入: 2, [[1,0]]
 * 输出: [0,1]
 * 解释: 总共有 2 门课程。要学习课程 1，你需要先完成课程 0。因此，正确的课程顺序为 [0,1] 。
 * <p>示例 2:
 * 输入: 4, [[1,0],[2,0],[3,1],[3,2]]
 * 输出: [0,1,2,3] or [0,2,1,3]
 * 解释: 总共有 4 门课程。要学习课程 3，你应该先完成课程 1 和课程 2。
 * 并且课程 1 和课程 2 都应该排在课程 0 之后。
 * 因此，一个正确的课程顺序是 [0,1,2,3] 。另一个正确的排序是 [0,2,1,3] 。
 * <p>说明：
 * 输入的先决条件是由边缘列表表示的图形，而不是邻接矩阵。详情请参见图的表示法。
 * 你可以假定输入的先决条件中没有重复的边。
 * <p>提示：
 * 这个问题相当于查找一个循环是否存在于有向图中。如果存在循环，则不存在拓扑排序，因此不可能选取所有课程进行学习。
 * 通过 DFS 进行拓扑排序 - 一个关于Coursera的精彩视频教程（21分钟），介绍拓扑排序的基本概念。
 * 拓扑排序也可以通过 BFS 完成。
 *
 * @author hc
 */
public class Demo210 {

    public int[] findOrder(int numCourses, int[][] prerequisites) {

        if (numCourses <= 0) {
            return new int[0];
        }

        int[] in = new int[numCourses];
        HashSet<Integer>[] adj = new HashSet[numCourses];
        for (int i = 0; i < numCourses; i++) {
            adj[i] = new HashSet<>();
        }

        // 添加所有依赖关系
        for (int[] p : prerequisites) {
            // p[0] 位置入度 +1
            ++in[p[0]];
            // p[0] 被 p[1] 指
            adj[p[1]].add(p[0]);
        }

        // 入度为 0 的 入队
        Queue<Integer> queue = new LinkedList<>();
        for (int i = 0; i < numCourses; i++) {
            if (in[i] == 0) {
                queue.add(i);
            }
        }

        int index = 0;
        int[] res = new int[numCourses];
        while (!queue.isEmpty()) {
            Integer poll = queue.poll();
            res[index++] = poll;

            for (int successor : adj[poll]) {
                // 对于指向 adj[poll] 的所有节点，维护入度 -1
                // 并且判定其是否入度为 0，即是否需要入队
                --in[successor];
                if (in[successor] == 0) {
                    queue.add(successor);
                }
            }
        }

        // 是否能排完所有课程
        if (index == numCourses) {
            return res;
        }

        return new int[0];
    }

    public static void main(String[] args) {
        new Demo210().findOrder(4, new int[][]{{1, 0}, {2, 0}, {3, 1}, {3, 2}});
    }
}
