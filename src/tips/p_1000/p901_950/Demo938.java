package tips.p_1000.p901_950;

/**
 * 给定 二叉搜索树 的根结点 root，返回值位于范围 [low, high] 之间的所有结点的值的和。
 * <p>提示：
 * 树中节点数目在范围 [1, 2 * 104] 内
 * 1 <= Node.val <= 105
 * 1 <= low <= high <= 105
 * 所有 Node.val 互不相同
 *
 * @author hc
 */
public class Demo938 {

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

    private int res = 0;

    public int rangeSumBST(TreeNode root, int low, int high) {
        dfs(root, low, high);
        return res;
    }

    private void dfs(TreeNode root, int low, int high) {
        // 未利用二叉搜索树条件
        if (root == null) {
            return;
        }
        if (root.val >= low && root.val <= high) {
            res += root.val;
        }
        dfs(root.right, low, high);
        dfs(root.left, low, high);
    }

    public int rangeSumBST2(TreeNode root, int low, int high) {
        if (root == null) {
            return 0;
        }
        if (root.val >= low && root.val <= high) {
            return root.val + rangeSumBST2(root.left, low, high) + rangeSumBST2(root.right, low, high);
        } else if (root.val < low) {
            return rangeSumBST2(root.right, low, high);
        } else {
            return rangeSumBST2(root.left, low, high);
        }
    }
}
