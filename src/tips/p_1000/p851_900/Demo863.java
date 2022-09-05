package tips.p_1000.p851_900;

import common.TreeNode;

import java.util.*;

/**
 * 给定一个二叉树（具有根结点 root）， 一个目标结点 target ，和一个整数值 K 。
 * 返回到目标结点 target 距离为 K 的所有结点的值的列表。 答案可以以任何顺序返回。
 * <p>示例 1：
 * 输入：root = [3,5,1,6,2,0,8,null,null,7,4], target = 5, K = 2
 * 输出：[7,4,1]
 * 解释：
 * 所求结点为与目标结点（值为 5）距离为 2 的结点，
 * 值分别为 7，4，以及 1
 * <p>注意，输入的 "root" 和 "target" 实际上是树上的结点。
 * 上面的输入仅仅是对这些对象进行了序列化描述。
 * <p>提示：
 * 给定的树是非空的。
 * 树上的每个结点都具有唯一的值 0 <= node.val <= 500 。
 * 目标结点 target 是树上的结点。
 * 0 <= K <= 1000.
 * <p>
 *
 * @author hc
 */
public class Demo863 {

    // 用map记录每个节点的父节点
    private Map<TreeNode, TreeNode> parents = new HashMap<>();

    private Set<TreeNode> used = new HashSet<>();

    private TreeNode targetNode;

    // 找到目标节点后以目标节点为开始位置向三个方向蔓延
    public List<Integer> distanceK(TreeNode root, TreeNode target, int K) {
        find(root, null, target);
        List<Integer> res = new LinkedList<>();
        dfs(targetNode, res, K);
        return res;
    }

    private void find(TreeNode root, TreeNode parent, TreeNode target) {
        if (null == root) {
            return;
        }
        if (root.val == target.val) {
            targetNode = root;
        }
        parents.put(root, parent);
        find(root.left, root, target);
        find(root.right, root, target);
    }

    private void dfs(TreeNode root, List<Integer> collector, int distance) {
        if (root != null && !used.contains(root)) {
            // 标记为已访问
            used.add(root);
            if (distance <= 0) {
                collector.add(root.val);
                return;
            }
            dfs(root.left, collector, distance - 1);
            dfs(root.right, collector, distance - 1);
            dfs(parents.get(root), collector, distance - 1);
        }
    }


    private List<Integer> result;

    public List<Integer> distanceK2(TreeNode root, TreeNode target, int k) {
        result = new ArrayList<>();
        getFormCurr(root, target.val, k);
        return result;
    }

    private int getFormCurr(TreeNode root, int target, int k) {
        if (root == null) return -1;
        if (root.val == target) {
            readDown(root, k);
            return k - 1;
        }
        int le = getFormCurr(root.left, target, k);
        if (le >= 0) {
            if (le == 0) {
                result.add(root.val);
            } else {
                readDown(root.right, le - 1);
                return le - 1;
            }
        }
        int ri = getFormCurr(root.right, target, k);
        if (ri >= 0) {
            if (ri == 0) {
                result.add(root.val);
            } else {
                readDown(root.left, ri - 1);
                return ri - 1;
            }
        }
        return -1;
    }

    private void readDown(TreeNode root, int offset) {
        if (root == null || offset < 0) return;
        if (offset == 0) {
            result.add(root.val);
        }
        readDown(root.left, offset - 1);
        readDown(root.right, offset - 1);
    }
}
