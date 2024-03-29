package tips.p_1000.p51_100;

/**
 * 给定一个整数 n，求以 1 ... n 为节点组成的二叉搜索树有多少种？
 *
 * @author hc
 */
public class Demo96 {

    /**
     * 假设 n 个节点存在二叉排序树的个数是 G(n)，1为根节点，2为根节点，...，n为根节点，
     * 当 1 为根节点时，其左子树节点个数为 0，右子树节点个数为 n-1，
     * 同理当 2 为根节点时，其左子树节点个数为 1，右子树节点为 n-2，
     * 所以可得 G(n) = G(0) * G(n-1) + G(1) * (n-2) +...+ G(n-1) * G(0) --> 卡塔兰数
     * dp[2] = dp[0]*dp[1] + dp[1]*dp[0]
     * dp[3] = dp[0]*dp[2] + dp[1]*dp[1] + dp[2]*dp[0]
     */
    public int numTrees(int n) {

        int[] dp = new int[n + 1];
        dp[0] = 1;
        dp[1] = 1;

        for (int i = 2; i <= n; i++) {
            for (int j = 1; j <= i; j++) {
                dp[i] += dp[j - 1] * dp[i - j];
            }
        }
        return dp[n];
    }

    public int numTrees2(int n) {
        long c = 1;
        for (int i = 0; i < n; i++) {
            c = c * 2 * (i * 2 + 1) / (i + 2);
        }
        return (int) c;
    }

    public static void main(String[] args) {
        System.out.println(new Demo96().numTrees(3));
        System.out.println(new Demo96().numTrees(4));
        System.out.println(new Demo96().numTrees(5));
    }
}
