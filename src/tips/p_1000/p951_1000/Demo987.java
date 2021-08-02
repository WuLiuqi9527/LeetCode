package tips.p_1000.p951_1000;

import java.util.*;

/**
 * 给你二叉树的根结点 root ，请你设计算法计算二叉树的 垂序遍历 序列。
 * 对位于 (row, col) 的每个结点而言，
 * 其左右子结点分别位于 (row + 1, col - 1) 和 (row + 1, col + 1) 。树的根结点位于 (0, 0) 。
 * 二叉树的 垂序遍历 从最左边的列开始直到最右边的列结束，按列索引每一列上的所有结点，
 * 形成一个按出现位置从上到下排序的有序列表。如果同行同列上有多个结点，则按结点的值从小到大进行排序。
 * 返回二叉树的 垂序遍历 序列。
 * <p>示例 1：
 * 输入：root = [3,9,20,null,null,15,7]
 * 输出：[[9],[3,15],[20],[7]]
 * <p>示例 2：
 * 输入：root = [1,2,3,4,5,6,7]
 * 输出：[[4],[2],[1,5,6],[3],[7]]
 * <p>示例 3：
 * 输入：root = [1,2,3,4,6,5,7]
 * 输出：[[4],[2],[1,5,6],[3],[7]]
 * <p>提示：
 * 树中结点数目总数在范围 [1, 1000] 内
 * 0 <= Node.val <= 1000
 *
 * @author hc
 */
public class Demo987 {

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

    Map<TreeNode, int[]> map = new HashMap<>();

    public List<List<Integer>> verticalTraversal(TreeNode root) {
        map.put(root, new int[]{0, 0, root.val});
        dfs(root);
        List<int[]> list = new ArrayList<>(map.values());
        // 先按列号排， 在按行号排，最后按 val 排
        Collections.sort(list, (o1, o2) -> {
            if (o1[1] != o2[1]) {
                return o1[1] - o2[1];
            }
            if (o1[0] != o2[0]) {
                return o1[0] - o2[0];
            }
            return o1[2] - o2[2];
        });

        int n = list.size();
        List<List<Integer>> res = new ArrayList<>();
        for (int i = 0; i < n; ) {
            int j = i;
            List<Integer> tem = new ArrayList<>();
            while (j < n && list.get(j)[1] == list.get(i)[1]) {
                tem.add(list.get(j++)[2]);
            }
            res.add(tem);
            i = j;
        }
        return res;
    }

    private void dfs(TreeNode root) {
        if (root == null) {
            return;
        }
        int[] info = map.get(root);
        int row = info[0], col = info[1], val = info[2];
        if (root.left != null) {
            map.put(root.left, new int[]{row + 1, col - 1, root.left.val});
            dfs(root.left);
        }
        if (root.right != null) {
            map.put(root.right, new int[]{row + 1, col + 1, root.right.val});
            dfs(root.right);
        }
    }
}
