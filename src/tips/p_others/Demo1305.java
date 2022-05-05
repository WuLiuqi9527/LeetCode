package tips.p_others;

import java.util.*;

/**
 * 给你 root1 和 root2 这两棵二叉搜索树。
 * 请你返回一个列表，其中包含 两棵树 中的所有整数并按 升序 排序。.
 * <p>示例 1：
 * 输入：root1 = [2,1,4], root2 = [1,0,3]
 * 输出：[0,1,1,2,3,4]
 * <p>示例 2：
 * 输入：root1 = [1,null,8], root2 = [8,1]
 * 输出：[1,1,8,8]
 * <p>提示：
 * 每棵树的节点数在[0, 5000] 范围内
 * -10^5<= Node.val <= 10^5
 *
 * @author hc
 */
public class Demo1305 {

    public static class TreeNode {
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

    public static List<Integer> list;

    public List<Integer> getAllElements(TreeNode root1, TreeNode root2) {
        list = new ArrayList<>();
        add(root1);
        add(root2);
        Collections.sort(list);
        return list;
    }

    public static void add(TreeNode root) {
        if (root == null) {
            return;
        }
        add(root.left);
        list.add(root.val);
        add(root.right);
    }
}
