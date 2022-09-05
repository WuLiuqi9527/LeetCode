package tips.p_1000.p401_450;

import common.TreeNode;

/**
 * 序列化是将数据结构或对象转换为一系列位的过程，以便它可以存储在文件或内存缓冲区中，
 * 或通过网络连接链路传输，以便稍后在同一个或另一个计算机环境中重建。
 * 设计一个算法来序列化和反序列化 二叉搜索树 。
 * 对序列化 /反序列化算法的工作方式没有限制。
 * 您只需确保二叉搜索树可以序列化为字符串，并且可以将该字符串反序列化为最初的二叉搜索树。
 * 编码的字符串应尽可能紧凑。
 * <p>示例 1：
 * 输入：root = [2,1,3]
 * 输出：[2,1,3]
 * <p>示例 2：
 * 输入：root = []
 * 输出：[]
 * <p>提示：
 * 树中节点数范围是 [0, 10^4]
 * 0 <= Node.val <= 10^4
 * 题目数据 保证 输入的树是一棵二叉搜索树。
 *
 * @author hc
 */
public class Demo449 {

    // Encodes a tree to a single string.
    public static String serialize(TreeNode root) {
        StringBuilder sb = new StringBuilder();
        serialize(root, sb);
        return sb.toString();
    }

    private static void serialize(TreeNode root, StringBuilder sb) {
        if (root == null) {
            return;
        }
        /** 优化点 -> 无需分割符
         * 利用 10e4数据范围可知 char足够与 int 一一对应,
         * 于是不需要分隔符作为分割直接存储对应 char,解码亦然
         * ---存的是字符 使用字符对应的 ASCII 序号,来得到原数字
         */
        sb.append((char) root.val);
        serialize(root.left, sb);
        serialize(root.right, sb);
    }

    // Decodes your encoded data to tree.
    public static TreeNode deserialize(String data) {
        return deserialize(data, 0, data.length() - 1);
    }

    private static TreeNode deserialize(String data, int l, int r) {
        if (l > r) {
            return null;
        }
        int val = data.charAt(l);
        TreeNode root = new TreeNode(val);
        int mid = l;
        while (mid < r && data.charAt(mid + 1) < val) {
            mid++;
        }
        root.left = deserialize(data, l + 1, mid);
        root.right = deserialize(data, mid + 1, r);
        return root;
    }
}
