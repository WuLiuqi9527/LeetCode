package tips.f_109.f_10;

/**
 * 给定两个整型数字 N 与 M，以及表示比特位置的 i 与 j（i <= j，且从 0 位开始计算）。
 * 编写一种方法，使 M 对应的二进制数字插入 N 对应的二进制数字的第 i ~ j 位区域，不足之处用 0 补齐。
 * <p>示例1:
 * 输入：N = 1024(10000000000), M = 19(10011), i = 2, j = 6
 * 输出：N = 1100(10001001100)
 * <p>示例2:
 * 输入： N = 0, M = 31(11111), i = 0, j = 4
 * 输出：N = 31(11111)
 *
 * @author hc
 */
public class Face0501 {

    public int insertBits(int N, int M, int i, int j) {
        // 将 N 中 i~j 位置零
        for (int k = i; k <= j; k++) {
            N &= ~(1 << k);
        }
        return N | ( M << i);
    }

    public static void main(String[] args) {
        System.out.println(new Face0501().insertBits(1024, 19, 2, 6));
        System.out.println(new Face0501().insertBits(0, 31, 0, 4));
        System.out.println(new Face0501().insertBits(1143207437, 1017033, 11, 31));
    }
}
