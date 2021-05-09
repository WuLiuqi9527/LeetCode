package tip.p51_100;

/**
 * 给定三个字符串 s1、s2、s3，请你帮忙验证 s3 是否是由 s1 和 s2 交错 组成的。
 * 两个字符串 s 和 t 交错 的定义与过程如下，其中每个字符串都会被分割成若干 非空 子字符串：
 * <p>
 * s = s1 + s2 + ... + sn
 * t = t1 + t2 + ... + tm
 * |n - m| <= 1
 * 交错 是 s1 + t1 + s2 + t2 + s3 + t3 + ... 或者 t1 + s1 + t2 + s2 + t3 + s3 + ...
 * 提示：a + b 意味着字符串 a 和 b 连接。
 *
 * @author hc
 */
public class Demo97 {

    int l1, l2, l3;
    String s1, s2, s3;
    boolean[][] visited;

    public boolean isInterleave(String s1, String s2, String s3) {
        l1 = s1.length();
        l2 = s2.length();
        l3 = s3.length();
        if (l1 + l2 != l3) {
            return false;
        }
        visited = new boolean[l1 + 1][l2 + 1];
        this.s1 = s1;
        this.s2 = s2;
        this.s3 = s3;

        return dfs(0, 0, 0);
    }

    private boolean dfs(int i, int j, int k) {
        if (k == l3) {
            return true;
        }
        if (visited[i][j]) {
            return false;
        }

        // 只能向右和向下
        visited[i][j] = true;
        if (i < l1 && s1.charAt(i) == s3.charAt(k) && dfs(i + 1, j, k + 1)) {
            return true;
        }
        if (j < l2 && s2.charAt(j) == s3.charAt(k) && dfs(i, j + 1, k + 1)) {
            return true;
        }
        return false;
    }

    public static void main(String[] args) {
        System.out.println(new Demo97().isInterleave("aabcc", "dbbca", "aadbbcbcac"));
    }
}
