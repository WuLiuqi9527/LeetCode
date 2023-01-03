package tips.p_others;

public class Demo2042 {

    public boolean areNumbersAscending(String s) {
        String[] tokens = s.split(" ");
        int start = -1;
        for (int i = 0; i < tokens.length; i++) {
            if (!Character.isDigit(tokens[i].charAt(0))) {
                continue;
            }
            int tem = Integer.parseInt(tokens[i]);
            if (start >= tem) {
                return false;
            }
            start = tem;
        }

        return true;
    }
}
