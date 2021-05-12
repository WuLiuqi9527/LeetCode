package tips.o1_50;

/**
 * 找出数组中重复的数字。
 * 在一个长度为 n 的数组 nums 里的所有数字都在 0～n-1 的范围内。
 * 数组中某些数字是重复的，但不知道有几个数字重复了，也不知道每个数字重复了几次。
 * 请找出数组中任意一个重复的数字。
 * <p>示例 1：
 * 输入：
 * [2, 3, 1, 0, 2, 5, 3]
 * 输出：2 或 3
 * <p>限制：
 * 2 <= n <= 100000
 *
 * @author hc
 */
public class Offer3 {

    /**
     * 空间复杂度 O(n) 时间复杂度 O(n)
     */
    public int findRepeatNumber(int[] nums) {
        // 边界条件
        int len = nums.length;
        if (len <= 1) {
            return Integer.MAX_VALUE;
        }

        int[] freq = new int[len];
        for (int i = 0; i < len; i++) {
            ++freq[nums[i]];
            if (freq[nums[i]] > 1) {return nums[i];}
        }

        return Integer.MAX_VALUE;
    }

    /**
     * 时间复杂度O(n)，空间复杂度O(1)
     * 可以看做是一种原地哈希，不过没有用到字典
     * 具体做法就是因为题目中给的元素是 < len（nums）的。可以让位置 i 的地方放元素 i 。
     * 如果位置 i 的元素不是 i 的话，那么我们就把 i 元素的位置放到它应该在的位置，即 nums[i] 和 nums[nums[i]] 的元素交换
     * 这样就把原来在 nums[i] 的元素正确归位了
     * 如果发现 要把 nums[i]正确归位的时候，发现 nums[i]（这个nums[i]是下标）那个位置上的元素和要归位的元素已经一样了，说明就重复了
     */
    public int findRepeatNumber2(int[] nums) {
        int len = nums.length;
        for (int i = 0; i < len; i++) {
            while (nums[i] != i) {
                int temp = nums[i];
                if (nums[temp] == nums[i]) {
                    return nums[i];
                }
                nums[i] = nums[temp];
                nums[temp] = temp;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        System.out.println(new Offer3().findRepeatNumber(new int[]{2, 3, 1, 0, 2, 5, 3}));
    }
}
