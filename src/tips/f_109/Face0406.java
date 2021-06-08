package tips.f_109;

import java.util.ArrayList;
import java.util.List;

/**
 * 设计一个算法，找出二叉搜索树中指定节点的“下一个”节点（也即中序后继）。
 * 如果指定节点没有对应的“下一个”节点，则返回null。
 * <p>示例 1:
 * 输入: root = [2,1,3], p = 1
 * 输出: 2
 * <p>示例 2:
 * 输入: root = [5,3,6,2,4,null,null,1], p = 6
 * 输出: null
 *
 * @author hc
 */
public class Face0406 {

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    public TreeNode inorderSuccessor(TreeNode root, TreeNode p) {
        if (root == null) {
            return null;
        }

        if (root.val <= p.val) {
            return inorderSuccessor(root.right, p);
        }

        TreeNode left = inorderSuccessor(root.left, p);
        return left == null ? root : left;
    }

    public TreeNode inorderSuccessor2(TreeNode root, TreeNode p) {
        List<TreeNode> list = new ArrayList<>();
        help(root, list);
        for (int i = 0; i < list.size() - 1; i++) {
            if (list.get(i).val == p.val) {
                return list.get(i + 1);
            }
        }
        return null;
    }

    private void help(TreeNode root, List<TreeNode> list) {
        if (root == null) {
            return;
        }
        help(root.left, list);
        list.add(root);
        help(root.right, list);
    }
}
