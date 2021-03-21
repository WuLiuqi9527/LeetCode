package p51_100;

import java.util.LinkedList;
import java.util.List;

/**
 * 给定一个整数 n，生成所有由 1 ... n 为节点所组成的 二叉搜索树 。
 *
 * @author hc
 */
public class Demo95 {

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

    public List<TreeNode> generateTrees(int n) {

        if (n == 0) {
            return new LinkedList<>();
        }

        return dp(1, n);
    }

    private List<TreeNode> dp(int start, int end) {

        List<TreeNode> res = new LinkedList<>();
        if (start > end) {
            res.add(null);
            return res;
        }

        for (int i = start; i <= end; i++) {
            for (TreeNode l : dp(start, i - 1)) {
                for (TreeNode r : dp(i + 1, end)) {
                    res.add(new TreeNode(i, l, r));
                }
            }
        }
        return res;
    }
}
