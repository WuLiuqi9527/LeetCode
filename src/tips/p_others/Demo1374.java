package tips.p_others;

import java.util.Arrays;

public class Demo1374 {

    public String generateTheString(int n) {
        StringBuilder sb = new StringBuilder();
        if (n % 2 == 0 && --n >= 0) {
            sb.append('a');
        }
        while (n-- > 0) {
            sb.append('b');
        }
        return sb.toString();
    }

    public String generateTheString2(int n) {
        char[] chars = new char[n];
        Arrays.fill(chars, 'a');
        if ((n & 1) != 1) {
            chars[0] = 'b';
        }
        return new String(chars);
    }
}
