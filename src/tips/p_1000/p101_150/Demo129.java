package tips.p_1000.p101_150;

import common.TreeNode;

/**
 * 给定一个二叉树，它的每个结点都存放一个 0-9 的数字，每条从根到叶子节点的路径都代表一个数字。
 * 例如，从根到叶子节点路径 1->2->3 代表数字 123。
 * 计算从根到叶子节点生成的所有数字之和。
 * 说明: 叶子节点是指没有子节点的节点。
 * <p>
 * 示例 1:
 * 输入: [1,2,3]
 * 1
 * / \
 * 2   3
 * 输出: 25
 * 解释:
 * 从根到叶子节点路径 1->2 代表数字 12.
 * 从根到叶子节点路径 1->3 代表数字 13.
 * 因此，数字总和 = 12 + 13 = 25.
 *
 * @author hc
 */
public class Demo129 {

    int res;

    public int sumNumbers(TreeNode root) {

        sumNumbers(root, 0);
        return res;
    }

    private void sumNumbers(TreeNode root, int num) {

        if (root == null) {
            return;
        }

        if (root.left == null && root.right == null) {
            res += num * 10 + root.val;
        }

        sumNumbers(root.left, num * 10 + root.val);
        sumNumbers(root.right, num * 10 + root.val);
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);

        System.out.println(new Demo129().sumNumbers(root));
    }
}
