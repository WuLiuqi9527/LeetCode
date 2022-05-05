package tips.p_1000.p551_600;

import java.util.ArrayDeque;

/**
 * 栈思想 ×
 * CV大法好 √
 *
 * @author hc
 */
public class Demo591 {

    public boolean isValid(String code) {
        ArrayDeque stack = new ArrayDeque<String>();
        int i = 0, n = code.length();
        while (i < n) {
            if (code.charAt(i) == '<') {
                if (i + 1 == n) {
                    return false;
                }
                char c = code.charAt(i + 1);
                if (c >= 'A' && c <= 'Z') {
                    int j = code.indexOf('>', i + 2);
                    if (j < 0) {
                        return false;
                    }
                    String tag = code.substring(i + 1, j);
                    if (tag.length() < 1 || tag.length() > 9) {
                        return false;
                    }
                    for (int z = 0; z < tag.length(); z++) {
                        if (tag.charAt(z) < 'A' || tag.charAt(z) > 'Z') {
                            return false;
                        }
                    }
                    stack.push(tag);
                    i = j + 1;
                } else if (c == '/') {
                    if (i + 2 >= n) {
                        return false;
                    }
                    int j = code.indexOf('>', i + 2);
                    if (j < 0) {
                        return false;
                    }
                    String tag = code.substring(i + 2, j);
                    if (tag.length() < 1 || tag.length() > 9) {
                        return false;
                    }
                    if (stack.isEmpty() || !stack.pop().equals(tag)) {
                        return false;
                    }
                    i = j + 1;
                    if (stack.isEmpty() && i < n) {
                        return false;
                    }
                } else if (c == '!') {
                    if (stack.isEmpty()) {
                        return false;
                    }
                    if (i + 9 >= n) {
                        return false;
                    }
                    // check range here
                    if (!"[CDATA[".equals(code.substring(i + 2, i + 9))) {
                        return false;
                    }
                    int j = code.indexOf("]]>", i + 9);
                    if (j < 0) {
                        return false;
                    }
                    i = j + 3;
                } else {
                    return false;
                }
            } else {
                if (stack.isEmpty()) {
                    return false;
                }
                i++;
            }
        }
        return stack.isEmpty();
    }

    final String CDATA_CONTENT_PATTERN = "<!\\[CDATA\\[.*?\\]\\]>";
    final String TAG_CONTENT_PATTERN = "<([A-Z]{1,9})>[^<]*</\\1>";

    /**
     * 正则匹配
     */
    public boolean isValid2(String code) {
        String res = code.replaceAll(CDATA_CONTENT_PATTERN, "#");
        while (res.contains("</")) {
            String res1 = res.replaceAll(TAG_CONTENT_PATTERN, "#");
            //两次替换没变化直接返回false
            if (res.equals(res1)) {
                return false;
            }
            res = res1;
        }
        return "#".equals(res);
    }
}
