package tips.f_109.f_10;

/**
 * 三步问题。有个小孩正在上楼梯，楼梯有n阶台阶，小孩一次可以上1阶、2阶或3阶。
 * 实现一种方法，计算小孩有多少种上楼梯的方式。结果可能很大，你需要对结果模 1000000007。
 * <p>示例1:
 * 输入：n = 3
 * 输出：4
 * 说明: 有四种走法
 * <p>示例2:
 * 输入：n = 5
 * 输出：13
 * <p>提示:
 * n范围在[1, 1000000]之间
 *
 * @author hc
 */
public class Face0801 {

    public int waysToStep(int n) {
        if (n == 1 || n == 2) {
            return n;
        }

        int[] dp = new int[n + 1];
        dp[1] = 1;
        dp[2] = 2;
        dp[3] = 4;
        for (int i = 4; i <= n; i++) {
            dp[i] = ((dp[i - 1] + dp[i - 2]) % 1000000007 + dp[i - 3]) % 1000000007;
        }
        return dp[n];
    }

    public int waysToStep2(int n) {
        if (n == 1 || n == 2) {
            return n;
        }

        int[] dp = new int[3];
        dp[0] = 1;
        dp[1] = 2;
        dp[2] = 4;
        for (int i = 4; i <= n; i++) {
            int tem = dp[2];
            dp[2] = ((dp[0] + dp[1]) % 1000000007 + dp[2]) % 1000000007;
            dp[0] = dp[1];
            dp[1] = tem;
        }
        return dp[2];
    }

    public static void main(String[] args) {
        System.out.println(new Face0801().waysToStep2(3));
        System.out.println(new Face0801().waysToStep2(5));
    }
}
