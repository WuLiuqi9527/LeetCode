package tip.lt1000.p101_150;

import java.util.HashMap;

/**
 * 给定一个二维平面，平面上有 n 个点，求最多有多少个点在同一条直线上。
 * <p>
 * 示例 1:
 * 输入: [[1,1],[3,2],[5,3],[4,1],[2,3],[1,4]]
 * 输出: 4
 * 解释:
 * ^
 * |
 * |  o
 * |     o        o
 * |        o
 * |  o        o
 * +------------------->
 * 0  1  2  3  4  5  6
 *
 * @author hc
 */
public class Demo149 {

    /**
     * 固定一点, 其他点和这个点组成直线, 统计斜率
     */
    public int maxPoints(int[][] points) {

        if (points.length < 3) {
            return points.length;
        }

        // <斜率， 频次>
        int res = 0;
        for (int[] pointOne : points) {
            int vCount = 0;
            int hCount = 0;
            int duplicate = 0;
            int max = 0;
            HashMap<String, Integer> map = new HashMap<>();
            for (int[] pointTwo : points) {

                if (pointOne != pointTwo) {
                    int x = pointOne[0] - pointTwo[0];
                    int y = pointOne[1] - pointTwo[1];

                    if (x == 0 && y == 0) {
                        ++duplicate;
                        continue;
                    }
                    if (x == 0){
                        ++vCount;
                    }
                    if (y ==0){
                        ++hCount;
                    }

                    //分子分母约分
                    int gcd = gcd(x, y);
                    x = x / gcd;
                    y = y / gcd;
                    String key = x + "@" + y;
                    map.put(key, map.getOrDefault(key, 0) + 1);
                    max = Math.max(max, map.get(key));
                }
            }
            max = Math.max(max, hCount);
            max = Math.max(max, vCount);
            res = Math.max(res, max + duplicate + 1);
        }
        return res;
    }

    private int gcd(int a, int b) {
        while (b != 0) {
            int temp = a % b;
            a = b;
            b = temp;
        }
        return a;
    }

    public static void main(String[] args) {
        System.out.println(new Demo149().maxPoints(new int[][]{{1, 1}, {3, 2}, {5, 3}, {4, 1}, {2, 3}, {1, 4}}));
    }
}
