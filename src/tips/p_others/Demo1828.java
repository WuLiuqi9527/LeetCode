package tips.p_others;

public class Demo1828 {

    public int[] countPoints(int[][] points, int[][] queries) {
        int len = queries.length;
        int[] ans = new int[len];
        for (int[] point : points) {
            for (int i = 0; i < len; i++) {
                if (isInCircle(point, queries[i])) {
                    ans[i]++;
                }
            }
        }
        return ans;
    }

    private boolean isInCircle(int[] point, int[] query) {
        int x = query[0];
        int y = query[1];
        int r = query[2];
        return (x - point[0]) * (x - point[0]) + (y - point[1]) * (y - point[1]) - r * r <= 0;
    }
}
