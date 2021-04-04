/**
 * @author hc
 */
public class DayDemo {

    public int trap(int[] height) {
        int sum = 0;
        for (int h : height) {
            sum += h;
        }

        int volume = 0;
        int level = 1;
        int left = 0, right = height.length - 1;
        while (left <= right) {
            while (left <= right && height[left] < level) {
                ++left;
            }
            while (left <= right && height[right] < level) {
                --right;
            }
            volume += right - left + 1;
            ++level;
        }
        return volume - sum;
    }
}