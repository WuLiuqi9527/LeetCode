package problemset;

/**
 * 给你 n 个非负整数 a1，a2，...，an，每个数代表坐标中的一个点 (i,ai) 。
 * 在坐标内画 n 条垂直线，垂直线 i 的两个端点分别为 (i, ai) 和 (i, 0) 。
 * 找出其中的两条线，使得它们与 x 轴共同构成的容器可以容纳最多的水。
 * <p>
 * 说明：你不能倾斜容器。
 *
 * @author hc
 */
public class Demo11 {

    public int maxArea(int[] height) {
        if (height.length <= 1) {
            return -1;
        }

        int l = 0, r = height.length - 1;
        int maxA = 0;
        while (l < r) {
            maxA = Math.min(height[l], height[r]) * (r - l) > maxA ? Math.min(height[l], height[r]) * (r - l) : maxA;
            if (height[l] < height[r]) {
                l++;
            } else {
                r--;
            }
        }
        return maxA;
    }
}
