package tips.f_109.f_10;

import common.TreeNode;

/**
 * 给定一个有序整数数组，元素各不相同且按升序排列，编写一个算法，创建一棵高度最小的二叉搜索树。
 * <p>示例:
 * 给定有序数组: [-10,-3,0,5,9],
 * 一个可能的答案是：[0,-3,9,-10,null,5]，它可以表示下面这个高度平衡二叉搜索树：
 *
 * @author hc
 */
public class Face0402 {

    public TreeNode sortedArrayToBST(int[] nums) {
        // 有序 找到中位点 构建二叉搜索树
        return help(nums, 0, nums.length);
    }

    private TreeNode help(int[] nums, int left, int right) {
        if (left == right) {
            return null;
        }
        int mid = left + (right - left) / 2;
        TreeNode root = new TreeNode(nums[mid]);
        root.left = help(nums, left, mid);
        root.right = help(nums, mid + 1, right);
        return root;
    }
}
