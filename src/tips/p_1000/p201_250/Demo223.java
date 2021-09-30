package tips.p_1000.p201_250;

/**
 * 在二维平面上计算出两个由直线构成的矩形重叠后形成的总面积。
 * 每个矩形由其左下顶点和右上顶点坐标表示，如图所示。
 * <p>示例:
 * 输入: -3, 0, 3, 4, 0, -1, 9, 2
 * 输出: 45
 * 说明: 假设矩形面积不会超出 int 的范围。
 *
 * @author hc
 */
public class Demo223 {

    public int computeArea(int A, int B, int C, int D, int E, int F, int G, int H) {

        int areaOne = (C - A) * (D - B);
        int areaTwo = (G - E) * (H - F);

        // 水平方向、垂直方向上是否有重叠
        if (C <= E || A >= G || D <= F || B >= H) {
            return areaOne + areaTwo;
        }


        int overlap = (Math.min(C, G) - Math.max(A, E)) * (Math.min(D, H) - Math.max(B, F));
        return areaOne + areaTwo - overlap;
    }

    public static void main(String[] args) {
        System.out.println(new Demo223().computeArea(-3, 0, 3, 4, 0, -1, 9, 2));
    }
}
