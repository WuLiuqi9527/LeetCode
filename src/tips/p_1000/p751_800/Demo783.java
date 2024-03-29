package tips.p_1000.p751_800;

import common.TreeNode;

/**
 * 给你一个二叉搜索树的根节点 root ，返回 树中任意两不同节点值之间的最小差值 。
 * <p>
 * 示例 1：
 * 输入：root = [4,2,6,1,3]
 * 输出：1
 *
 * @author hc
 */
public class Demo783 {

    private TreeNode pre = null;
    private int res = Integer.MAX_VALUE;
    public int minDiffInBST(TreeNode root) {
        dfs(root);
        return res;
    }

    private void dfs(TreeNode root) {
        if (root == null) {
            return;
        }

        dfs(root.left);
        if (pre != null) {
            res = Math.min(res, root.val - pre.val);
        }
        pre = root;
        dfs(root.right);
    }
}
