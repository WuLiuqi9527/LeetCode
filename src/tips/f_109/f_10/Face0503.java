package tips.f_109.f_10;

/**
 * 给定一个32位整数 num，你可以将一个数位从0变为1。
 * 请编写一个程序，找出你能够获得的最长的一串1的长度。
 * <p>示例 1：
 * 输入: num = 1775(110111011112)
 * 输出: 8
 * <p>示例 2：
 * 输入: num = 7(01112)
 * 输出: 4
 *
 * @author hc
 */
public class Face0503 {

    public int reverseBits(int num) {
        int maxLen = 0, preLen = 0, curLen = 0, bits = 32;
        while (bits-- > 0) {
            if ((num & 1) == 0) {
                curLen -= preLen;
                preLen = curLen + 1;
            }

            ++curLen;
            maxLen = Math.max(maxLen, curLen);
            num >>= 1;
        }
        return maxLen;
    }

    public static void main(String[] args) {
        System.out.println(new Face0503().reverseBits(1775));
        System.out.println(new Face0503().reverseBits(7));
    }
}
