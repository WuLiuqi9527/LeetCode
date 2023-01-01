package tips.p_others;

import java.util.HashSet;
import java.util.Set;

public class Demo2351 {

    public char repeatedCharacter(String s) {
        char ans = ' ';
        Set<Character> set = new HashSet<>();
        for (char c : s.toCharArray()) {
            if (set.contains(c)) {
                ans = c;
                break;
            }
            set.add(c);
        }
        return ans;
    }
}
