package tips.f_109;

/**
 * 数组nums包含从0到n的所有整数，但其中缺了一个。
 * 请编写代码找出那个缺失的整数。你有办法在O(n)时间内完成吗？
 * 注意：本题相对书上原题稍作改动
 * <p>示例 1：
 * 输入：[3,0,1]
 * 输出：2
 * <p>示例 2：
 * 输入：[9,6,4,2,3,5,7,0,1]
 * 输出：8
 *
 * @author hc
 */
public class Face1704 {

    public int missingNumber(int[] nums) {
        int len = nums.length;
        int res = 0;
        for (int i = 1; i <= len; i++) {
            res += i - nums[i-1];
        }
        return res;
    }

    public static void main(String[] args) {
        System.out.println(new Face1704().missingNumber(new int[]{3, 0, 1}));
        System.out.println(new Face1704().missingNumber(new int[]{9, 6, 4, 2, 3, 5, 7, 0, 1}));
    }
}
