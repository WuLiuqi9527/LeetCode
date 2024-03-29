package tips.p_1000.p101_150;

import common.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * 给你二叉树的根节点 root ，返回它节点值的 前序 遍历。
 *
 * @author hc
 */
public class Demo144 {

    public List<Integer> preorderTraversal(TreeNode root) {

        List<Integer> list = new ArrayList<>();
        preorderTraversal(root, list);
        return list;
    }

    private void preorderTraversal(TreeNode root, List<Integer> list) {

        if (root == null){
            return;
        }

        list.add(root.val);
        preorderTraversal(root.left,list);
        preorderTraversal(root.right,list);
    }
}
