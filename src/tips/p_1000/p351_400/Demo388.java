package tips.p_1000.p351_400;

public class Demo388 {

    public static int lengthLongestPath(String input) {
        if (input == null || input.length() == 0) {
            return 0;
        }

        String[] words = input.split("\n");
        int[] levels = new int[words.length + 1];
        levels[0] = -1;
        int res = 0;
        for (String word : words) {
            int level = word.lastIndexOf("\t") + 2;
            int nameLen = word.length() - (level - 1);
            levels[level] = levels[level - 1] + 1 + nameLen;
            if (word.contains(".")) {
                res = Math.max(res, levels[level]);
            }
        }

        return res;
    }

    public static void main(String[] args) {
        String test = "dir\n\tsubdir1\n\t\tfile1.ext\n\t\tsubsubdir1\n\tsubdir2\n\t\tsubsubdir2\n\t\t\tfile2.ext";
        System.out.println(lengthLongestPath(test));
    }
}
