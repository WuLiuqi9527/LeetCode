package tips.p_1000.p51_100;

/**
 * 给定一个由 整数 组成的 非空 数组所表示的 非负 整数，在该数的基础上加一。
 * 最高位数字存放在数组的首位， 数组中每个元素只存储单个数字。
 * 你可以假设除了整数 0 之外，这个整数不会以零开头。
 * <p>
 * 示例 1：
 * 输入：digits = [1,2,3]
 * 输出：[1,2,4]
 * 解释：输入数组表示数字 123。
 *
 * @author hc
 */
public class Demo66 {

    public int[] plusOne(int[] digits) {

        int len = digits.length;

        if (digits[len - 1] == 9) {
            for (int i = len - 1; i >= 0; --i) {
                ++digits[i];
                digits[i] = digits[i] % 10;
                if (digits[i] != 0) {
                    return digits;
                }
            }
            digits = new int[len + 1];
            digits[0] = 1;
            return digits;
        } else {
            digits[len - 1] += 1;
        }
        return digits;
    }

    public static void main(String[] args) {
        int[] ints = new Demo66().plusOne(new int[]{9, 9, 9});
        for (int i : ints) {
            System.out.print(" ");
            System.out.print(i);
        }
    }
}
