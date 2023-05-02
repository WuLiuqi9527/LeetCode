package tips.p_others;

import java.util.HashSet;
import java.util.Set;

public class Demo2423 {

    public static boolean equalFrequency(String word) {
        int[] arr = new int[26];
        for(char w : word.toCharArray()) {
            int idx = w - 'a';
            arr[idx]++;
        }
        for (int i = 0; i < 26; i++) {
            if (arr[i] == 0) {
                continue;
            }
            arr[i]--;
            Set<Integer> set = new HashSet<>();
            for (int j = 0; j < 26; j++) {
                if (arr[j] > 0) {
                    set.add(arr[j]);
                }
            }
            if (set.size() == 1) {
                return true;
            }
            arr[i]++;
        }
        return false;
    }

    public static void main(String[] args) {
        System.out.println(equalFrequency("abcc"));
        System.out.println(equalFrequency("aazz"));
    }
}
