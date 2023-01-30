package tips.p_others;

public class Demo2303 {

    public static double calculateTax(int[][] brackets, int income) {
        double ans = 0.0, tem = 0.0;
        int len = brackets.length;
        for (int i = 0;i < len; i++) {
            int upper = brackets[i][0];
            int percent = brackets[i][1];
            if (income > upper) {
                ans += (upper - tem) * percent * 1.0 / 100;
                tem = upper;
            } else {
                ans += (income - tem) * percent * 1.0 / 100;
                break;
            }
        }
        return ans;
    }
}
