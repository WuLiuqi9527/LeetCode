package tips.p_1000.p451_500;

/**
 * 对于给定的整数 n, 如果n的k（k>=2）进制数的所有数位全为1，则称 k（k>=2）是 n 的一个好进制。
 * 以字符串的形式给出 n, 以字符串的形式返回 n 的最小好进制。
 * <p>示例 1：
 * 输入："13"
 * 输出："3"
 * 解释：13 的 3 进制是 111。
 * <p>示例 2：
 * 输入："4681"
 * 输出："8"
 * 解释：4681 的 8 进制是 11111。
 * <p>示例 3：
 * 输入："1000000000000000000"
 * 输出："999999999999999999"
 * 解释：1000000000000000000 的 999999999999999999 进制是 11。
 * <p>提示：
 * n的取值范围是 [3, 10^18]。
 * 输入总是有效且没有前导 0。
 *
 * @author hc
 */
public class Demo483 {

    /**
     * 设 n 的最小好进制为 k ，转化为 k 进制后的字符串为 "111…11"，
     * 进而 n 可以转化为 n ==  k^(m-1) + k^(m-2) … + k1 + k0
     * (其中 m 待定，是一个常数，为转换为 k 进制的后的字符串的长度）
     * 这就是一个等比数列，根据等比数列的求和公式，
     * 可知 n == (k^m - 1) / (k - 1)，由于题目中要求进制 k 尽量的小，
     * 那么根据求和公式知需要 m 尽可能的大（转换 k 进制后 1 的个数尽量多）。
     * 因为（k>=2），所以 m 的最大值为 m = log2(n + 1)，
     * 并且由于 n 的取值范围是 [3, 10^18]，即 m 的最小值是 2。
     */
    public String smallestGoodBase(String n) {
        long num = Long.parseLong(n);

        // 换底公式
        // 对进行 m 的大小进行穷举（m含义是转换为 k 进制后 1 的个数）
        for (int m = (int) (Math.log(num + 1) / Math.log(2)); m >= 2; m--) {
            // 用二分法搜索对应的 k,(k的含义是 k 进制)
            long l = 2, r = (long) Math.pow(num, 1.0 / (m - 1)) + 1;
            while (l < r) {
                // mid 进制
                long mid = l + (r - l) / 2, sum = 0;

                // 111...111 [m个1] 等比数列求和
                for (int i = 0; i < m; i++) {
                    sum = sum * mid + 1;
                }

                if (sum == num) {
                    return String.valueOf(mid);
                } else if (sum < num) {
                    l = mid + 1;
                } else {
                    r = mid - 1;
                }
            }
        }
        return String.valueOf(num - 1);
    }
}
