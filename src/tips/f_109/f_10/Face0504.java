package tips.f_109.f_10;

/**
 * 下一个数。给定一个正整数，找出与其二进制表达式中 1 的个数相同且大小最接近的那两个数
 * （一个略大，一个略小）。
 * <p>示例1:
 * 输入：num = 2（或者0b10）
 * 输出：[4, 1] 或者（[0b100, 0b1]）
 * <p>示例2:
 * 输入：num = 1
 * 输出：[2, -1]
 * <p>提示:
 * num的范围在[1, 2147483647]之间；
 * 如果找不到前一个或者后一个满足条件的正数，那么输出 -1。
 *
 * @author hc
 */
public class Face0504 {

    public int[] findClosedNumbers(int num) {
        if (num == 1) {
            return new int[]{2, -1};
        }
        if (num == 2147483647) {
            return new int[]{-1, -1};
        }

        int bit = Integer.bitCount(num);
        int large, small;
        for (large = num + 1; large > 0; large++) {
            if (Integer.bitCount(large) == bit) {
                break;
            }
        }
        for (small = num - 1; small > 0; small--) {
            if (Integer.bitCount(small) == bit) {
                break;
            }
        }
        return new int[]{large, small};
    }
}
