package problemset;

import java.util.TreeSet;

/**
 * @author hc
 */
public class Demo804 {
    public int uniqueMorseRepresentations(String[] words) {
        String[] codes = {".-","-...","-.-.","-..",".","..-.","--.","....","..",".---","-.-",".-..","--","-.","---",".--.","--.-",".-.","...","-","..-","...-",".--","-..-","-.--","--.."};

        TreeSet<String> treeSet = new TreeSet<>();
        for (String word:words){
            StringBuilder res = new StringBuilder();
            for (int i = 0; i < word.length(); i++) {
                res.append(codes[word.charAt(i) - 'a']);
            }
            treeSet.add(res.toString());
        }
        return treeSet.size();
    }

    public static void main(String[] args) {
        System.out.println(new Demo804().uniqueMorseRepresentations(new String[]{"gin", "zen", "gig", "msg"}));
    }
}
