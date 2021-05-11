package tip.lt1000.p151_200;

/**
 * 编写一个函数，输入是一个无符号整数（以二进制串的形式），返回其二进制表达式中数字位数为 '1' 的个数（也被称为汉明重量）。
 * <p>
 * 示例 1：
 * 输入：00000000000000000000000000001011
 * 输出：3
 * 解释：输入的二进制串 00000000000000000000000000001011 中，共有三位为 '1'。
 *
 * @author hc
 */
public class Demo191 {

    public int hammingWeight(int n) {
        int res = 0;
        while (n != 0) {
            res += n & 1;
            // java 的负数在内存中是补码表示，符号位为 1 >> 不改变符号位
            // 使用 无符号位右移 >>>
            n >>>= 1;
        }
        return res;
    }

    public int hammingWeight2(int n) {
        int res = 0;
        while (n != 0) {
            // Brian Kernighan算法
            // 功能：n 的比特位最右端的 1 变为 0
            // 执行次数 为 n 的比特位中 1 的个数
            n &= n - 1;
            ++res;
        }
        return res;
    }

    public int hammingWeight3(int n) {
        // java Integer.bitCount() 源码
        n = n - ((n >>> 1) & 0x55555555);
        n = (n & 0x33333333) + ((n >>> 2) & 0x33333333);
        n = (n + (n >>> 4)) & 0x0f0f0f0f;
        n = n + (n >>> 8);
        n = n + (n >>> 16);
        return n & 0x3f;
    }

    public static void main(String[] args) {
        System.out.println(new Demo191().hammingWeight2(-3));
        System.out.println(Integer.bitCount(-3));
    }
}
