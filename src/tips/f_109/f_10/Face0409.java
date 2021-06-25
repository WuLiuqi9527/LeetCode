package tips.f_109.f_10;

import java.util.ArrayList;
import java.util.List;

/**
 * 从左向右遍历一个数组，通过不断将其中的元素插入树中可以逐步地生成一棵二叉搜索树。
 * 给定一个由不同节点组成的二叉搜索树，输出所有可能生成此树的数组。
 *
 * @author hc
 */
public class Face0409 {

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    List<List<Integer>> lists = new ArrayList<>();
    List<Integer> list = new ArrayList<>();

    public List<List<Integer>> BSTSequences(TreeNode root) {
        if (root == null) {
            lists.add(list);
            return lists;
        }

        List<TreeNode> nodes = new ArrayList<>();
        nodes.add(root);
        traverse(nodes);
        return lists;
    }

    private void traverse(List<TreeNode> nodes) {
        if (nodes.size() == 0) {
            lists.add(new ArrayList<>(list));
            return;
        }

        for (int i = 0; i < nodes.size(); i++) {
            TreeNode root = nodes.remove(i);
            if (root.left != null) {
                nodes.add(root.left);
            }
            if (root.right != null) {
                nodes.add(root.right);
            }

            list.add(root.val);
            traverse(nodes);
            list.remove(list.size() - 1);

            if (root.left != null) {
                nodes.remove(root.left);
            }
            if (root.right != null) {
                nodes.remove(root.right);
            }
            nodes.add(i, root);
        }
    }
}
