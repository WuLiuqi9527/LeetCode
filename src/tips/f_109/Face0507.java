package tips.f_109;

/**
 * 配对交换。编写程序，交换某个整数的奇数位和偶数位，尽量使用较少的指令
 * （也就是说，位0与位1交换，位2与位3交换，以此类推）。
 * <p>示例 1:
 * 输入：num = 2（或者0b10）
 * 输出 1 (或者 0b01)
 * <p>示例 2:
 * 输入：num = 3
 * 输出：3
 * <p>提示:
 * num的范围在[0, 2^30 - 1]之间，不会发生整数溢出。
 *
 * @author hc
 */
public class Face0507 {

    /**
     * (xxxx & 1010) >> 1 -> 0x0x
     * (xxxx & 0101) << 1 -> x0x0
     */
    public int exchangeBits(int num) {
        return ((num & 0xaaaaaaaa) >> 1) | ((num & 0x55555555) << 1);
    }

    public static void main(String[] args) {
        System.out.println(new Face0507().exchangeBits(2));
        System.out.println(new Face0507().exchangeBits(3));
    }
}
