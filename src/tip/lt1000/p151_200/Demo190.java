package tip.lt1000.p151_200;

/**
 * 颠倒给定的 32 位无符号整数的二进制位。
 *
 * 示例 1：
 *
 * 输入: 00000010100101000001111010011100
 * 输出: 00111001011110000010100101000000
 * 解释: 输入的二进制串 00000010100101000001111010011100 表示无符号整数 43261596，
 *      因此返回 964176192，其二进制表示形式为 00111001011110000010100101000000。
 *
 * @author hc
 */
public class Demo190 {

    public int reverseBits(int n) {
        return Integer.reverse(n);
    }

    public int reverseBits2(int n) {
        int res = 0;
        for (int i = 0; i < 32; i++) {
            int bit = n & 1;
            n = n >> 1;
            res = (res << 1) | bit;
        }
        return res;
    }

    public static void main(String[] args) {
        System.out.println(new Demo190().reverseBits(-3));
    }
}
