package tips.p_1000.p101_150;

import common.TreeNode;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * 给定一个二叉树，返回其节点值的锯齿形层序遍历。
 * 即先从左往右，再从右往左进行下一层遍历，以此类推，层与层之间交替进行。
 * <p>
 * 例如：
 * 给定二叉树 [3,9,20,null,null,15,7],
 * 3
 * / \
 * 9  20
 * /  \
 * 15   7
 * 返回锯齿形层序遍历如下：
 * [
 * [3],
 * [20,9],
 * [15,7]
 * ]
 *
 * @author hc
 */
public class Demo103 {

    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {

        List<List<Integer>> lists = new LinkedList<>();

        if (root == null) {
            return lists;
        }

        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);

        boolean level = true;
        while (!queue.isEmpty()) {

            int count = queue.size();
            List<Integer> list = new LinkedList<>();

            for (int i = 0; i < count; i++) {

                TreeNode treeNode = queue.poll();
                if (level) {
                    list.add(treeNode.val);
                } else {
                    list.add(0, treeNode.val);
                }

                if (treeNode.left != null) {
                    queue.add(treeNode.left);
                }
                if (treeNode.right != null) {
                    queue.add(treeNode.right);
                }
            }
            level = !level;
            lists.add(list);
        }
        return lists;
    }
}
