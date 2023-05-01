package tips.p_others;

public class Demo1033 {

    public int[] numMovesStones(int a, int b, int c) {
        int x = Math.min(Math.min(a, b), c);
        int z = Math.max(Math.max(a, b), c);
        int y = a + b + c - x - z;
        if (z - x < 3) {
            return new int[]{0, 0};
        }
        if (z - y < 3 || y - x < 3) {
            return new int[]{1, z - x - 2};
        }
        return new int[]{2, z - x - 2};
    }
}
