package tips.o1_50;

import java.util.ArrayList;
import java.util.List;

/**
 * 输入一棵二叉树和一个整数，打印出二叉树中节点值的和为输入整数的所有路径。
 * 从树的根节点开始往下一直到叶节点所经过的节点形成一条路径。
 * <p>提示：
 * 节点总数 <= 10000
 *
 * @author hc
 */
public class Offer34 {

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode() {
        }

        TreeNode(int val) {
            this.val = val;
        }

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

    List<List<Integer>> res;
    List<Integer> list;

    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {

        if (root == null) {
            return new ArrayList<>();
        }

        res = new ArrayList<>();
        list = new ArrayList<>();
        dfs(root, targetSum, 0);

        return res;
    }

    private void dfs(TreeNode root, int targetSum, int sum) {

        list.add(root.val);
        if (sum + root.val == targetSum && root.left == null && root.right == null) {
            res.add(new ArrayList<>(list));
            return;
        }
        if (root.left != null) {
            dfs(root.left, targetSum, sum + root.val);
            list.remove(list.size() - 1);
        }
        if (root.right != null) {
            dfs(root.right, targetSum, sum + root.val);
            list.remove(list.size() - 1);
        }
    }
}
