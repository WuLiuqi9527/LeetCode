package tips.p_1000.p801_850;

import java.util.Arrays;

public class Demo821 {

    public static int[] shortestToChar(String s, char c) {
        if (s.length() == 0) {
            return new int[0];
        }
        int len = s.length();
        int[] res = new int[len];
        Arrays.fill(res, len + 1);

        for (int i = 0, index = -1; i < len; i++) {
            if (c == s.charAt(i)) {
                index = i;
            }
            if (index != -1) {
                res[i] = i - index;
            }
        }

        for (int i = len - 1, index = len; i >= 0; i--) {
            if (c == s.charAt(i)) {
                index = i;
            }
            if (index != len) {
                res[i] = Math.min(res[i], index - i);
            }
        }

        return res;
    }

    public static void main(String[] args) {
        int[] test = shortestToChar("loveleetcode", 'e');
        for (int t : test) {
            System.out.print(t + "\t");
        }
    }
}
