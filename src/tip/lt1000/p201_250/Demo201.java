package tip.lt1000.p201_250;

/**
 * 给你两个整数 left 和 right ，表示区间 [left, right] ，返回此区间内所有数字 按位与 的结果（包含 left 、right 端点）。
 * <p>示例 1：
 * 输入：left = 5, right = 7
 * 输出：4
 * <p>示例 2：
 * 输入：left = 0, right = 0
 * 输出：0
 * <p>示例 3：
 * 输入：left = 1, right = 2147483647
 * 输出：0
 * <p>提示：0 <= left <= right <= 2^31 - 1
 *
 * @author hc
 */
public class Demo201 {

    /**
     * x & (x+1) 除最高位外都为零
     */
    public int rangeBitwiseAnd(int left, int right) {
        if (left <= 0 || right >= 0) {
            return 0;
        }
        int index = 0;
        while (left != right) {
            left >>= 1;
            right >>= 1;
            ++index;
        }
        return left << index;
    }

    public static void main(String[] args) {
        System.out.println(new Demo201().rangeBitwiseAnd(5, 7));
    }
}
