package tips.p_others;

import java.util.Arrays;

public class Demo1663 {

    public String getSmallestString(int n, int k) {
        char[] chars = new char[n];
        Arrays.fill(chars, 'a');
        k -= n;
        for (int i = n-1; k > 0; i--) {
            int incr = Math.min(k, 25);
            chars[i] += incr;
            k -= incr;
        }
        return new String(chars);
    }

    public String getSmallestString2(int n, int k) {
        char[] chars = new char[n];
        k -= n;
        int zStart = n - k / 25;
        Arrays.fill(chars, zStart, n, 'z');
        Arrays.fill(chars, 0, zStart, 'a');
        if (zStart > 0) {
            chars[zStart - 1] += k % 25;
        }
        return new String(chars);
    }
}
