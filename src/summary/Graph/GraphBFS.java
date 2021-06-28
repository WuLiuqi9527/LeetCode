package summary.Graph;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;

public class GraphBFS {

    public void bfs(Node node) {
        if (node == null) {
            return;
        }
        Queue<Node> queue = new LinkedList<>();
        HashSet<Node> visited = new HashSet<>();
        queue.add(node);
        visited.add(node);
        while (!queue.isEmpty()) {
            Node cur = queue.poll();
            // 操作处理
            System.out.println(cur.value);

            for (Node next : cur.nexts) {
                if (!visited.contains(next)) {
                    visited.add(next);
                    queue.add(next);
                }
            }
        }
    }
}
