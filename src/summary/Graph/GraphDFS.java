package summary.Graph;

import java.util.Deque;
import java.util.HashSet;
import java.util.LinkedList;

public class GraphDFS {

    public static void dfs(Node node) {
        if (node == null) {
            return;
        }

        Deque<Node> stack = new LinkedList<>();
        HashSet<Node> visited = new HashSet<>();
        stack.add(node);
        visited.add(node);

        System.out.println(node.value);

        while (!stack.isEmpty()) {
            Node cur = stack.pop();
            for (Node next : cur.nexts) {
                if (!visited.contains(next)) {
                    stack.push(cur);
                    stack.push(next);
                    visited.add(next);

                    System.out.println(next.value);

                    break;
                }
            }
        }
    }
}
