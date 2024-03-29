package tips.p_1000.p251_300;

import common.TreeNode;

import java.util.LinkedList;
import java.util.List;

/**
 * 给定一个二叉树，返回所有从根节点到叶子节点的路径。
 * 说明: 叶子节点是指没有子节点的节点。
 *
 * @author hc
 */
public class Demo257 {

    public List<String> binaryTreePaths(TreeNode root) {

        List<String> list = new LinkedList<>();
        if (root == null) {
            return list;
        }

        if (root.left == null && root.right == null) {
            list.add(String.valueOf(root.val));
            return list;
        }

        List<String> listL = binaryTreePaths(root.left);
        for (String str:listL) {
            list.add(root.val + "->" + str);
        }
        List<String> listR = binaryTreePaths(root.right);
        for (String str:listR) {
            list.add(root.val + "->" + str);
        }

        return list;
    }
}
