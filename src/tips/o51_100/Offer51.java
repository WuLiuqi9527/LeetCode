package tips.o51_100;

/**
 * 在数组中的两个数字，如果前面一个数字大于后面的数字，则这两个数字组成一个逆序对。
 * 输入一个数组，求出这个数组中的逆序对的总数。
 * <p>示例 1:
 * 输入: [7,5,6,4]
 * 输出: 5
 * <p>限制：
 * 0 <= 数组长度 <= 50000
 *
 * @author hc
 */
public class Offer51 {

    /**
     * 50000 双重循环一定超时
     */
    int[] nums, tem;

    public int reversePairs(int[] nums) {
        if (nums == null || nums.length <= 1) {
            return 0;
        }
        this.nums = nums;
        tem = new int[nums.length];
        return mergeSort(0, nums.length - 1);
    }

    private int mergeSort(int l, int r) {
        // 递归中止:子数组长度为 1 ，此时终止划分
        if (l >= r) {
            return 0;
        }
        // 分：递归划分
        int mid = (l + r) >> 1;
        int res = mergeSort(l, mid) + mergeSort(mid + 1, r);

        // 治：合并
        for (int k = l; k <= r; k++) {
            tem[k] = nums[k];
        }
        int i = l, j = mid + 1;
        for (int k = l; k <= r; k++) {
            if (i == mid + 1) {
                nums[k] = tem[j++];
            } else if (j == r + 1 || tem[i] <= tem[j]) {
                nums[k] = tem[i++];
            } else {
                nums[k] = tem[j++];
                // 统计逆序对
                res += mid - i + 1;
            }
        }
        return res;
    }

    public static void main(String[] args) {
        System.out.println(new Offer51().reversePairs(new int[]{7, 5, 6, 4}));
    }
}
