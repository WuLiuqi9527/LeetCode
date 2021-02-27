package problem201_250;

import java.util.HashMap;
import java.util.Map;

/**
 * 给定两个字符串 s 和 t，判断它们是否是同构的。
 * 如果 s 中的字符可以按某种映射关系替换得到 t ，那么这两个字符串是同构的。
 * 每个出现的字符都应当映射到另一个字符，同时不改变字符的顺序。
 * 不同字符不能映射到同一个字符上，相同字符只能映射到同一个字符上，字符可以映射到自己本身。
 * <p>
 * 示例 1:
 * 输入：s = "egg", t = "add"
 * 输出：true
 * <p>
 * 示例 2：
 * 输入：s = "foo", t = "bar"
 * 输出：false
 * <p>
 * 示例 3：
 * 输入：s = "paper", t = "title"
 * 输出：true
 * <p>
 * 提示：
 * 可以假设 s 和 t 长度相同。
 *
 * @author hc
 */
public class Demo205 {

    public boolean isIsomorphic(String s, String t) {

        Map<Character,Character> mapS = new HashMap<>();
        Map<Character,Character> mapT = new HashMap<>();

        for (int i = 0; i < s.length(); i++) {
            char x = s.charAt(i);
            char y = t.charAt(i);

            boolean sToT = mapS.containsKey(x) && mapS.get(x) != y;
            boolean tToS = mapT.containsKey(y) && mapT.get(y) != x;
            if (sToT || tToS){
                return false;
            }
            mapS.put(x,y);
            mapT.put(y,x);
        }
        return true;
    }

    public static void main(String[] args) {
        System.out.println(new Demo205().isIsomorphic(new String("paper"), new String("title")));
    }
}
