package p1_50;

import javax.print.DocFlavor;

/**
 * 给你一个 32 位的有符号整数 x ，返回 x 中每位上的数字反转后的结果。
 * 如果反转后整数超过 32 位的有符号整数的范围 [−231,  231 − 1] ，就返回 0。
 * 假设环境不允许存储 64 位整数（有符号或无符号）。
 * <p>
 * 示例 1：
 * 输入：x = 123
 * 输出：321
 *
 * @author hc
 */
public class Demo7 {

    public int reverse(int x) {

        int res = 0;
        while (x != 0) {

            if (res * 10 / 10 != res) {
                return 0;
            }

            res = res * 10 + x % 10;
            x /= 10;
        }

        return res;
    }

    public static void main(String[] args) {
        System.out.println(new Demo7().reverse(123));
    }
}
