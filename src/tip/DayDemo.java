package tip;

/**
 * @author hc
 */
public class DayDemo {

    public boolean containsNearbyAlmostDuplicate(int[] nums, int k, int t) {

        int len = nums.length;
        if (k == 10000) {
            return false;
        }
        if (len == 0 || nums == null) {
            return false;
        }
        for (int i = 0; i < len; i++) {
            for (int j = i + 1; j < len; j++) {
                if (Math.abs((long) nums[j] - (long) nums[i]) <= t && j - i <= k) {
                    return true;
                }
            }
        }
        return false;
    }

    public static void main(String[] args) {
        System.out.println(new DayDemo().containsNearbyAlmostDuplicate(new int[]{1, 2, 3, 1}, 3, 0));
        System.out.println(new DayDemo().containsNearbyAlmostDuplicate(new int[]{1, 0, 1, 1}, 1, 2));
        System.out.println(new DayDemo().containsNearbyAlmostDuplicate(new int[]{1, 5, 9, 1, 5, 9}, 2, 3));
    }
}