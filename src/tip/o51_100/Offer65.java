package tip.o51_100;

/**
 * 写一个函数，求两个整数之和，
 * 要求在函数体内不得使用 “+”、“-”、“*”、“/” 四则运算符号。
 * <p>示例:
 * 输入: a = 1, b = 1
 * 输出: 2
 * <p>提示：
 * a, b 均可能是负数或 0
 * 结果不会溢出 32 位整数
 *
 * @author hc
 */
public class Offer65 {

    public int add(int a, int b) {
        return Integer.sum(a, b);
    }

    public int add2(int a, int b) {
        if (a == 0) {
            return b;
        }
        if (b == 0) {
            return a;
        }
        return add(a ^ b, (a & b) << 1);
    }

    public int add3(int a, int b) {
        while (b != 0) {
            int tem = a ^ b;
            b = (a & b) << 1;
            a = tem;
        }
        return a;
    }
}
