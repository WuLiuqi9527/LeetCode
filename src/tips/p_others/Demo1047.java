package tips.p_others;

/**
 * 给出由小写字母组成的字符串 S，重复项删除操作会选择两个相邻且相同的字母，并删除它们。
 * 在 S 上反复执行重复项删除操作，直到无法继续删除。
 * 在完成所有重复项删除操作后返回最终的字符串。答案保证唯一。
 * <p>
 * 示例：
 * 输入："abbaca"
 * 输出："ca"
 * 解释：
 * 例如，在 "abbaca" 中，我们可以删除 "bb" 由于两字母相邻且相同，这是此时唯一可以执行删除操作的重复项。
 * 之后我们得到字符串 "aaca"，其中又只有 "aa" 可以执行重复项删除操作，所以最后的字符串为 "ca"。
 *
 * @author hc
 */
public class Demo1047 {

    public String removeDuplicates(String S) {

        if (S.length() <= 1) {
            return S;
        }

        char[] s = S.toCharArray();
        // 模拟栈 top栈顶指针
        int top = -1;
        for (int i = 0; i < S.length(); i++) {
            if (top == -1 || s[top] != s[i]) {
                // 不等入栈
                s[++top] = s[i];
            } else {
                // 相等出栈
                --top;
            }
        }
        return String.valueOf(s, 0, top + 1);
    }

    public static void main(String[] args) {
        System.out.println(new Demo1047().removeDuplicates("abbaca"));
    }
}
