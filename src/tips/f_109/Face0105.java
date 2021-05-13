package tips.f_109;

/**
 * 字符串有三种编辑操作:插入一个字符、删除一个字符或者替换一个字符。
 * 给定两个字符串，编写一个函数判定它们是否只需要一次(或者零次)编辑。
 * <p>示例 1:
 * 输入:
 * first = "pale"
 * second = "ple"
 * 输出: True
 * <p>示例 2:
 * 输入:
 * first = "pales"
 * second = "pal"
 * 输出: False
 *
 * @author hc
 */
public class Face0105 {

    public boolean oneEditAway(String first, String second) {
        if (first == null && second == null) {
            return true;
        }
        int fl = first.length();
        int sl = second.length();
        int t = fl - sl;
        if (t > 1 || t < -1) {
            return false;
        }

        int i = 0, j = 0;
        boolean oneChance = true;
        while (i < fl && j < sl) {
            if (first.charAt(i) != second.charAt(j)) {
                if (oneChance) {
                    if (t == 1) {
                        --j;
                    } else if (t == -1) {
                        --i;
                    }
                    oneChance = !oneChance;
                } else {
                    return oneChance;
                }
            }
            ++i;
            ++j;
        }
        return true;
    }
}
