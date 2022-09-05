package tips.p_1000.p101_150;

import common.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * 给定一个二叉树和一个目标和，找到所有从根节点到叶子节点路径总和等于给定目标和的路径。
 * 说明: 叶子节点是指没有子节点的节点。
 *
 * @author hc
 */
public class Demo113 {

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
