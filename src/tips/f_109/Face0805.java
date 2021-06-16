package tips.f_109;

/**
 * 递归乘法。 写一个递归函数，不使用 * 运算符， 实现两个正整数的相乘。
 * 可以使用加号、减号、位移，但要吝啬一些。
 * <p>示例1:
 * 输入：A = 1, B = 10
 * 输出：10
 * <p>示例2:
 * 输入：A = 3, B = 4
 * 输出：12
 * <p>提示:
 * 保证乘法范围不会溢出
 *
 * @author hc
 */
public class Face0805 {

    public int multiply(int A, int B) {
        if (A == 0 || B == 0) {
            return 0;
        }
        if (A == 1) {
            return B;
        }
        if (B == 1) {
            return A;
        }

        if (A > B) {
            return multiply(A, B - 1) + A;
        } else {
            return multiply(A - 1, B) + B;
        }
    }

    public int multiply2(int A, int B) {
        return A > B ? (B > 1 ? multiply2(A, B - 1) + A : A) :
                (A > 1 ? multiply2(A - 1, B) + B : B);
    }

    public static void main(String[] args) {
        System.out.println(new Face0805().multiply(3, 4));
        System.out.println(new Face0805().multiply2(3, 4));
    }
}
