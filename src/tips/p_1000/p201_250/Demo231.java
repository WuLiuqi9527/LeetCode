package tips.p_1000.p201_250;

/**
 * 给定一个整数，编写一个函数来判断它是否是 2 的幂次方。
 *
 * 示例 1:
 * 输入: 1
 * 输出: true
 * 解释: 20 = 1
 *
 * 示例 2:
 * 输入: 16
 * 输出: true
 * 解释: 24 = 16
 *
 * 示例 3:
 * 输入: 218
 * 输出: false
 *
 * @author hc
 */
public class Demo231 {

    public boolean isPowerOfTwo(int n) {

        if (n == 0){return false;}
        while (n % 2 == 0){
            n >>= 1;
        }
        return n == 1;
    }

    public boolean isPowerOfTwo2(int n) {

        if (n <= 0) {
            return false;
        }
        // 1000 如果有两个1，一定不是2的幂
        // 1000 2^n
        // 0111 2^n - 1
        if ((n & (n - 1)) == 0) {
            return true;
        }
        return false;
    }

    public static void main(String[] args) {
        System.out.println(new Demo231().isPowerOfTwo(1));
        System.out.println(new Demo231().isPowerOfTwo(16));
        System.out.println(new Demo231().isPowerOfTwo(218));
    }
}
