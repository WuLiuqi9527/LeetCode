package tips.p_others;

import java.util.Arrays;

public class Demo2185 {

    public int prefixCount(String[] words, String pref) {
        int ans = 0;
        for (String word : words) {
            if (word.startsWith(pref)) {
                ++ans;
            }
        }
        return ans;
    }

    public int prefixCount2(String[] words, String pref) {
        return (int) Arrays.stream(words).filter(word -> word.startsWith(pref)).count();
    }

}
