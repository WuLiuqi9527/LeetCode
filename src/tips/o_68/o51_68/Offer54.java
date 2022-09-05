package tips.o_68.o51_68;

import common.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * 给定一棵二叉搜索树，请找出其中第 k 大的节点。
 * <p>限制：
 * 1 ≤ k ≤ 二叉搜索树元素个数
 *
 * @author hc
 */
public class Offer54 {

    public int kthLargest(TreeNode root, int k) {
        // 中序遍历 动态数组ArrayList
        List<Integer> list = new ArrayList<>();
        helper(root, list);
        return list.get(list.size() - k);
    }

    private void helper(TreeNode root, List<Integer> list) {
        if (root == null) {
            return;
        }
        if (root.left != null) {
            helper(root.left, list);
        }
        list.add(root.val);
        if (root.right != null) {
            helper(root.right, list);
        }
    }

    private int res, k;
    public int kthLargest2(TreeNode root, int k) {
        // 优化空间
        this.k = k;
        dfs(root);
        return res;
    }

    private void dfs(TreeNode root) {
        if (root == null || k == 0) {
            return;
        }
        dfs(root.right);
        if (--k == 0) {
            res = root.val;
            return;
        }
        dfs(root.left);
    }

    int pos = 0;
    public int kthLargest3(TreeNode root, int k) {
        // 反向中序遍历  逆向中序递减
        if (root == null) {
            return 0;
        }
        int right = kthLargest3(root.right, k);
        ++pos;
        if (pos == k) {
            return root.val;
        }
        int left = kthLargest3(root.left, k);

        return Math.max(left, right);
    }
}
