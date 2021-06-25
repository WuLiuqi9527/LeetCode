package tips.f_109.f_10;

/**
 * 整数转换。编写一个函数，确定需要改变几个位才能将整数A转成整数B。
 * <p>示例1:
 * 输入：A = 29 （或者0b11101）, B = 15（或者0b01111）
 * 输出：2
 * <p>示例2:
 * 输入：A = 1，B = 2
 * 输出：2
 * <p>提示:
 * A，B范围在[-2147483648, 2147483647]之间
 *
 * @author hc
 */
public class Face0506 {

    public int convertInteger(int A, int B) {
        return Integer.bitCount(A ^ B);
    }

    public int convertInteger2(int A, int B) {
        int count = 0;
        int xor = A ^ B;
        while (xor != 0) {
            xor &= (xor - 1);
            ++count;
        }
        return count;
    }
}
