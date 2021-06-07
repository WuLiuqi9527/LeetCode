package tips.f_109;

/**
 * 编写一个方法，找出两个数字 a 和 b 中最大的那一个。
 * 不得使用 if-else 或其他比较运算符。
 * <p>示例：
 * 输入： a = 1, b = 2
 * 输出： 2
 *
 * @author hc
 */
public class Face1607 {

    public int maximum(int a, int b) {
        long bit = ((long) a - (long) b) >> 63;
        return bit == 0 ? a : b;
    }

    public int maximum2(int a, int b) {
        return Math.max(a,b);
    }
}
