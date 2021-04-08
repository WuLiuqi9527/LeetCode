package p201_250;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;

/**
 * 你这个学期必须选修 numCourses 门课程，记为 0 到 numCourses - 1 。
 * <p>在选修某些课程之前需要一些先修课程。先修课程按数组 prerequisites 给出，
 * 其中 prerequisites[i] = [ai, bi] ，表示如果要学习课程 ai 则 必须 先学习课程  bi 。
 * 例如，先修课程对 [0, 1] 表示：想要学习课程 0 ，你需要先完成课程 1 。
 * 请你判断是否可能完成所有课程的学习？如果可以，返回 true ；否则，返回 false 。
 * <p>示例 1：
 * 输入：numCourses = 2, prerequisites = [[1,0]]
 * 输出：true
 * 解释：总共有 2 门课程。学习课程 1 之前，你需要完成课程 0 。这是可能的。
 * <p>示例 2：
 * 输入：numCourses = 2, prerequisites = [[1,0],[0,1]]
 * 输出：false
 * 解释：总共有 2 门课程。学习课程 1 之前，你需要先完成 课程 0 ；并且学习课程 0 之前，你还应先完成课程 1 。这是不可能的。
 * <p>提示：
 * 1 <= numCourses <= 105
 * 0 <= prerequisites.length <= 5000
 * prerequisites[i].length == 2
 * 0 <= ai, bi < numCourses
 * prerequisites[i] 中的所有课程对 互不相同
 *
 * @author hc
 */
public class Demo207 {

    /**
     * 拓扑排序：入度为 0 入队
     */
    public boolean canFinish(int numCourses, int[][] prerequisites) {

        int len = prerequisites.length;
        if (prerequisites == null || len == 0) {
            return true;
        }

        // 记录所有课程的入度
        int[] in = new int[numCourses];

        // HashSet 记录 所有依赖关系
        HashSet<Integer>[] adj = new HashSet[numCourses];
        for (int i = 0; i < numCourses; i++) {
            adj[i] = new HashSet<>();
        }
        for (int[] p : prerequisites) {
            ++in[p[0]];
            adj[p[1]].add(p[0]);
        }

        // 入度为 0 的入队
        Queue<Integer> queue = new LinkedList<>();
        for (int i = 0; i < numCourses; i++) {
            if (in[i] == 0) {
                queue.add(i);
            }
        }

        // 记录出队的课程数
        int cnt = 0;
        while (!queue.isEmpty()) {
            Integer top = queue.poll();
            ++cnt;
            for (int successor : adj[top]) {
                --in[successor];
                if (in[successor] == 0) {
                    queue.add(successor);
                }
            }
        }

        return cnt == numCourses;
    }
}
