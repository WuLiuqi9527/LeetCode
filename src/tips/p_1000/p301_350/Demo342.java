package tips.p_1000.p301_350;

/**
 * 给定一个整数，写一个函数来判断它是否是 4 的幂次方。如果是，返回 true ；否则，返回 false 。
 * 整数 n 是 4 的幂次方需满足：存在整数 x 使得 n == 4^x
 * <p>
 * 示例 1：
 * 输入：n = 16
 * 输出：true
 *
 * @author hc
 */
public class Demo342 {

    public boolean isPowerOfFour(int n) {
        return Integer.toString(n, 4).matches("10*$");
    }

    public boolean isPowerOfFour2(int n) {
        // 0xaa = (1010 1010) 一个字节 int 四个字节 0xaaaaaaaa
        // (n & (n - 1)) == 0 是否是 2 的幂
        return n > 0 && (n & (n - 1)) == 0 && (n & 0xaaaaaaaa) == 0;
    }

    public boolean isPowerOfFour3(int n) {
        // 4^k = (3+1)^k 泰勒展开
        return n > 0 && (n & (n-1)) == 0 && n % 3 == 1;
    }

    public static void main(String[] args) {
        System.out.println(new Demo342().isPowerOfFour2(5));
    }
}
