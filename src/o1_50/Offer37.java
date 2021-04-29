package o1_50;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 请实现两个函数，分别用来序列化和反序列化二叉树。
 *
 * @author hc
 */
public class Offer37 {

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    public class Codec {

        public String serialize(TreeNode root) {
            if (root == null) {
                return "[]";
            }
            StringBuilder res = new StringBuilder("[");
            Queue<TreeNode> queue = new LinkedList<>();
            queue.add(root);
            // 层序遍历
            while (!queue.isEmpty()) {
                TreeNode node = queue.poll();
                if (node != null) {
                    res.append(node.val + ",");
                    queue.add(node.left);
                    queue.add(node.right);
                } else {
                    res.append("null,");
                }
            }
            // 删掉 最后的","
            res.deleteCharAt(res.length() - 1);
            res.append("]");
            return res.toString();
        }

        public TreeNode deserialize(String data) {
            if (data.equals("[]")) {
                return null;
            }
            // 取出 [] 中间的内容
            String[] vals = data.substring(1, data.length() - 1).split(",");
            TreeNode root = new TreeNode(Integer.parseInt(vals[0]));
            Queue<TreeNode> queue = new LinkedList<>();
            queue.add(root);
            int i = 1;
            // 层序遍历反序列化 从左到右
            while (!queue.isEmpty()) {
                TreeNode node = queue.poll();
                if (!vals[i].equals("null")) {
                    node.left = new TreeNode(Integer.parseInt(vals[i]));
                    queue.add(node.left);
                }
                i++;
                if (!vals[i].equals("null")) {
                    node.right = new TreeNode(Integer.parseInt(vals[i]));
                    queue.add(node.right);
                }
                i++;
            }
            return root;
        }
    }
}
