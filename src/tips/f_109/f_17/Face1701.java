package tips.f_109.f_17;

/**
 * 设计一个函数把两个数字相加。不得使用 + 或者其他算术运算符。
 * <p>示例:
 * 输入: a = 1, b = 1
 * 输出: 2
 * <p>提示：
 * a, b 均可能是负数或 0
 * 结果不会溢出 32 位整数
 *
 * @author hc
 */
public class Face1701 {

    public int add(int a, int b) {
        if (a == 0) {
            return b;
        }
        if (b == 0) {
            return a;
        }
        return add(a ^ b, (a & b) << 1);
    }

    public int add2(int a, int b) {
        // 直到 b 没有进位
        while (b != 0) {
            int tem = a ^ b;
            b = (a & b) << 1;
            a = tem;
        }
        return a;
    }

    public static void main(String[] args) {
        System.out.println(new Face1701().add(1, 1));
    }
}
