package o1_50;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * 请实现一个函数按照之字形顺序打印二叉树，
 * 即第一行按照从左到右的顺序打印，第二层按照从右到左的顺序打印，
 * 第三行再按照从左到右的顺序打印，其他行以此类推。
 * 提示：
 * 节点总数 <= 1000
 *
 * @author hc
 */
public class Offer32Three {

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    public List<List<Integer>> levelOrder(TreeNode root) {

        List<List<Integer>> lists = new ArrayList<>();
        if (root == null) {
            return lists;
        }

        boolean level = true;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            int size = queue.size();
            List<Integer> list = new ArrayList<>();
            for (int i = 0; i < size; i++) {
                TreeNode poll = queue.poll();

                if (level) {
                    list.add(poll.val);
                } else {
                    list.add(0, poll.val);
                }

                if (poll.left != null) {
                    queue.add(poll.left);
                }
                if (poll.right != null) {
                    queue.add(poll.right);
                }
            }
            level = !level;
            lists.add(list);
        }
        return lists;
    }
}
