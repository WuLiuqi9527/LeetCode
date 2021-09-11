package tips.p_1000.p551_600;

/**
 * 给定一个正整数 n，找出小于或等于 n 的非负整数中，其二进制表示不包含 连续的1 的个数。
 * <p>示例 1:
 * 输入: 5
 * 输出: 5
 * 解释:
 * 下面是带有相应二进制表示的非负整数<= 5：
 * 0 : 0
 * 1 : 1
 * 2 : 10
 * 3 : 11
 * 4 : 100
 * 5 : 101
 * 其中，只有整数3违反规则（有两个连续的1），其他5个满足规则。
 * 说明: 1 <= n <= 10^9
 *
 * @author hc
 */
public class Demo600 {

    static int N = 50;
    // f[i][j] 为考虑二进制长度为 i，而且最高位为 j（0 or 1）时的合法数个数
    static int[][] f = new int[N][2];

    static {
        f[1][0] = 1;
        f[1][1] = 2;
        for (int i = 1; i < N - 1; i++) {
            f[i + 1][0] = f[i][1];
            f[i + 1][1] = f[i][0] + f[i][1];
        }
    }

    int getLen(int n) {
        for (int i = 31; i >= 0; i--) {
            if (((n >> i) & 1) == 1) {
                return i;
            }
        }
        return 0;
    }

    public int findIntegers(int n) {
        if (n == 0) {
            return 1;
        }
        int len = getLen(n);
        int ans = 0, prev = 0;
        for (int i = len; i >= 0; i--) {
            // 当前位是 0 还是 1
            int cur = ((n >> i) & 1);
            // 如果当前位是 1，那么填 0 的话，后面随便填都符合，将方案数累加
            if (cur == 1) {
                ans += f[i + 1][0];
            }
            // 出现连续位为 1，方案数被计算完了
            if (prev == 1 && cur == 1) {
                break;
            }
            prev = cur;
            if (i == 0) {
                ++ans;
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        System.out.println(new Demo600().findIntegers(3));
        System.out.println(new Demo600().findIntegers(5));
    }
}
