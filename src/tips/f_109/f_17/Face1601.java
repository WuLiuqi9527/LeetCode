package tips.f_109.f_17;

/**
 * 编写一个函数，不用临时变量，直接交换 numbers = [a, b]中 a 与 b 的值。
 * <p>示例：
 * 输入: numbers = [1,2]
 * 输出: [2,1]
 * <p>提示：
 * numbers.length == 2
 * -2147483647 <= numbers[i] <= 2147483647
 *
 * @author hc
 */
public class Face1601 {

    public int[] swapNumbers(int[] numbers) {
        return new int[]{numbers[1], numbers[0]};
    }

    public int[] swapNumbers2(int[] numbers) {
        // a ^ b ^ b = a;
        // a ^ b ^ a = b;
        numbers[0] = numbers[0] ^ numbers[1];
        numbers[1] = numbers[0] ^ numbers[1];
        numbers[0] = numbers[0] ^ numbers[1];
        return numbers;
    }
}
