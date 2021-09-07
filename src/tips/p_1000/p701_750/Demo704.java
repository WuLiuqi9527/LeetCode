package tips.p_1000.p701_750;

public class Demo704 {

    public int search(int[] nums, int target) {
        int ans = -1;
        for (int i = 0; i < nums.length; ++i) {
            if (nums[i] == target) {
                ans = i;
            }
        }
        return ans;
    }

    public int search2(int[] nums, int target) {
        int ans = -1;
        int l  = 0, r = nums.length - 1;
        while (l <= r) {
            int mid = l + (r - l) / 2;
            if (nums[mid] == target) {
                ans = mid;
                break;
            }else if (nums[mid] > target) {
                r = mid - 1;
            }else  {
                l = mid + 1;
            }
        }
        return ans;
    }
}
