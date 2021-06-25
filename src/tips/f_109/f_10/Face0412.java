package tips.f_109.f_10;

import java.util.HashMap;
import java.util.Map;

/**
 * 给定一棵二叉树，其中每个节点都含有一个整数数值(该值或正或负)。
 * 设计一个算法，打印节点数值总和等于某个给定值的所有路径的数量。
 * 注意，路径不一定非得从二叉树的根节点或叶节点开始或结束，
 * 但是其方向必须向下(只能从父节点指向子节点方向)。
 * <p>示例:
 * 给定如下二叉树，以及目标和 sum = 22，
 * 返回: 3
 * 解释：和为 22 的路径有：[5,4,11,2], [5,8,4,5], [4,11,7]
 * <p>提示：
 * 节点总数 <= 10000
 *
 * @author hc
 */
public class Face0412 {

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    private int res = 0;

    public int pathSum(TreeNode root, int sum) {
        if (root == null) {
            return 0;
        }
        dfs(root, sum);
        pathSum(root.left, sum);
        pathSum(root.right, sum);

        return res;
    }

    private void dfs(TreeNode root, int sum) {
        if (root == null) {
            return;
        }

        sum -= root.val;
        if (sum == 0) {
            ++res;
        }
        dfs(root.left, sum);
        dfs(root.right, sum);
    }
}
