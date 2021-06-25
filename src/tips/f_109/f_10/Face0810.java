package tips.f_109.f_10;

/**
 * 编写函数，实现许多图片编辑软件都支持的「颜色填充」功能。
 * 待填充的图像用二维数组 image 表示，元素为初始颜色值。
 * 初始坐标点的行坐标为 sr 列坐标为 sc。需要填充的新颜色为 newColor 。
 * 「周围区域」是指颜色相同且在上、下、左、右四个方向上存在相连情况的若干元素。
 * 请用新颜色填充初始坐标点的周围区域，并返回填充后的图像。
 * <p>示例：
 * 输入：
 * image = [[1,1,1],[1,1,0],[1,0,1]]
 * sr = 1, sc = 1, newColor = 2
 * 输出：[[2,2,2],[2,2,0],[2,0,1]]
 * 解释:
 * 初始坐标点位于图像的正中间，坐标 (sr,sc)=(1,1) 。
 * 初始坐标点周围区域上所有符合条件的像素点的颜色都被更改成 2 。
 * 注意，右下角的像素没有更改为 2 ，因为它不属于初始坐标点的周围区域。
 * <p>提示：
 * image 和 image[0] 的长度均在范围 [1, 50] 内。
 * 初始坐标点 (sr,sc) 满足 0 <= sr < image.length 和 0 <= sc < image[0].length 。
 * image[i][j] 和 newColor 表示的颜色值在范围 [0, 65535] 内。
 *
 * @author hc
 */
public class Face0810 {

    /** 与 p200-岛屿数量 相同 */
    public int[][] floodFill(int[][] image, int sr, int sc, int newColor) {
        boolean unreal = image == null || image.length <= 0 ||
                sr < 0 || sr >= image.length || sc < 0 || sc >= image[0].length;
        if (unreal) {
            return new int[0][];
        }

        int oldColor = image[sr][sc];
        infect(image, sr, sc, oldColor, newColor);
        return image;
    }

    private void infect(int[][] image, int i, int j, int oldColor, int newColor) {
        if (i < 0 || i >= image.length || j < 0 || j >= image[0].length || image[i][j] != oldColor) {
            return;
        }

        // 已访问 直接退出 否则栈溢出
        if (image[i][j] == newColor) {
            return;
        }

        image[i][j] = newColor;
        infect(image, i - 1, j, oldColor, newColor);
        infect(image, i, j - 1, oldColor, newColor);
        infect(image, i + 1, j, oldColor, newColor);
        infect(image, i, j + 1, oldColor, newColor);
    }
}
