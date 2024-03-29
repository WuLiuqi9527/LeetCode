package tips.p_others;

import common.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

public class Demo1161 {

    public int maxLevelSum(TreeNode root) {
        int level = 1;
        int[] res = new int[]{Integer.MIN_VALUE, level};
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            int sum = 0;
            int size = queue.size();
            while (size-- > 0) {
                TreeNode poll = queue.poll();
                sum += poll.val;
                if (poll.left != null) {
                    queue.offer(poll.left);
                }
                if (poll.right != null) {
                    queue.offer(poll.right);
                }
            }
            if (res[0] < sum) {
                res[0] = sum;
                res[1] = level;
            }
            level++;
        }
        return res[1];
    }
}
