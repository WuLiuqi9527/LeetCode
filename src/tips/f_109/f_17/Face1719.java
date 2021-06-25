package tips.f_109.f_17;

/**
 * 给定一个数组，包含从 1 到 N 所有的整数，但其中缺了两个数字。
 * 你能在 O(N) 时间内只用 O(1) 的空间找到它们吗？
 * 以任意顺序返回这两个数字均可。
 * <p>示例 1:
 * 输入: [1]
 * 输出: [2,3]
 * <p>示例 2:
 * 输入: [2,3]
 * 输出: [1,4]
 * <p>提示：
 * nums.length <= 30000
 *
 * @author hc
 */
public class Face1719 {

    public int[] missingTwo(int[] nums) {

        int xor = 0;
        int N = nums.length + 2;
        for (int i = 1; i <= N; i++) {
            xor ^= i;
        }

        for (int num : nums) {
            xor ^= num;
        }

        // 找到两个数不相同的一个二进制位
        int bit = 1;
        while ((xor & 1) == 0) {
            xor >>= 1;
            bit <<= 1;
        }

        // 以该二进制位将数组分成两部分，再做异或
        int num1 = 0, num2 = 0;
        for (int i = 1; i <= N; i++) {
            if ((i & bit) == 0) {
                num1 ^= i;
            }else {
                num2 ^= i;
            }
        }

        for (int num : nums) {
            if ((num & bit) == 0) {
                num1 ^= num;
            } else {
                num2 ^= num;
            }
        }


        return new int[]{num1, num2};
    }
}
