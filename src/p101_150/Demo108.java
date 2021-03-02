package p101_150;

/**
 * 给你一个整数数组 nums ，其中元素已经按 升序 排列，请你将其转换为一棵 高度平衡 二叉搜索树。
 * 高度平衡 二叉树是一棵满足「每个节点的左右两个子树的高度差的绝对值不超过 1 」的二叉树。
 *
 * @author hc
 */
public class Demo108 {

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

    public TreeNode sortedArrayToBST(int[] nums) {
        if (nums.length == 0) {
            return null;
        }
        return toBST(nums, 0, nums.length - 1);
    }

    private TreeNode toBST(int[] nums, int l, int r) {

        if (l > r) {
            return null;
        }

        // l + (r - l + 1) / 2 向上取整
        // l + (r - l) / 2 向下取整
        int mid = l + (r - l + 1) / 2;
        TreeNode root = new TreeNode(nums[mid]);
        root.left = toBST(nums, l, mid - 1);
        root.right = toBST(nums, mid + 1, r);

        return root;
    }
}
