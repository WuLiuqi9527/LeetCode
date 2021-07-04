package tips.f_109.f_17;

/**
 * 给定一个直方图(也称柱状图)，假设有人从上面源源不断地倒水，最后直方图能存多少水量?直方图的宽度为 1。
 * 上面是由数组 [0,1,0,2,1,0,1,3,2,1,2,1] 表示的直方图，
 * 在这种情况下，可以接 6 个单位的水（蓝色部分表示水）。 感谢 Marcos 贡献此图。
 * 示例:
 * 输入: [0,1,0,2,1,0,1,3,2,1,2,1]
 * 输出: 6
 *
 * @author hc
 */
public class Face1721 {

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

    public static void main(String[] args) {
        System.out.println(new Face1721().trap(new int[]{3, 1, 2, 5, 2, 4}));
    }
}
