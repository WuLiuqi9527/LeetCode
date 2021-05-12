package tips.p_others;

/**
 * 给你一个整数数组 perm ，它是前 n 个正整数的排列，且 n 是个 奇数 。
 * 它被加密成另一个长度为 n - 1 的整数数组 encoded ，满足 encoded[i] = perm[i] XOR perm[i + 1] 。
 * 比方说，如果 perm = [1,3,2] ，那么 encoded = [2,1] 。
 * 给你 encoded 数组，请你返回原始数组 perm 。题目保证答案存在且唯一。
 * <p>示例 1：
 * 输入：encoded = [3,1]
 * 输出：[1,2,3]
 * 解释：如果 perm = [1,2,3] ，那么 encoded = [1 XOR 2,2 XOR 3] = [3,1]
 * <p>示例 2：
 * 输入：encoded = [6,5,4,6]
 * 输出：[2,4,1,5,3]
 * <p>提示：
 * 3 <= n < 10^5
 * n 是奇数。
 * encoded.length == n - 1
 *
 * @author hc
 */
public class Demo1734 {

    /**
     * 假设 n=5
     * 则 perm=[a,b,c,d,e]
     * enco=[f,g,h,i]
     * 因为 n 确定，所以可以知道所有数的异或结果, 即 total =  a^b^c^d^e 的结果是知道的
     * 我们知道的是 enco的值，只需要找到 perm 的随意一个位置的值就可以构造答案
     * 可以发现
     * f=a^b, g=b^c, h=c^d, i=d^e
     * -> g ^ i ^ total = (b^c) ^ (d^e) ^ (a^b^c^d^e) = a
     */
    public int[] decode(int[] encoded) {
        int len = encoded.length;
        int a = 1, n = len + 1;
        for (int i = 2; i <= n; i++) {
            a ^= i;
        }

        int[] prem = new int[n];
        for (int i = len - 1; i >= 0; i-=2) {
            a ^= encoded[i];
        }
        prem[0] = a;

        for (int i = 1; i < n; i++) {
            prem[i] = prem[i-1] ^ encoded[i-1];
        }

        return prem;
    }
}
