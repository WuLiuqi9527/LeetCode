package tips.f_109;

/**
 * 给定一个字符串，编写一个函数判定其是否为某个回文串的排列之一。
 * 回文串是指正反两个方向都一样的单词或短语。排列是指字母的重新排列。
 * 回文串不一定是字典当中的单词。
 * <p>示例1：
 * 输入："tactcoa"
 * 输出：true（排列有"tacocat"、"atcocta"，等等）
 *
 * @author hc
 */
public class Face0104 {

    public boolean canPermutePalindrome(String s) {
        int[] sum = new int[256];
        int len = s.length();
        for (int i = 0; i < len; i++) {
            char ch = s.charAt(i);
            if (sum[ch] == 0) {
                ++sum[ch];
            } else {
                --sum[ch];
            }
        }

        int res = 0;
        for (int n : sum) {
            res += n;
        }
        return res == 1 || res == 0;
    }

    public static void main(String[] args) {
        System.out.println(new Face0104().canPermutePalindrome("tactcoa"));
    }
}
