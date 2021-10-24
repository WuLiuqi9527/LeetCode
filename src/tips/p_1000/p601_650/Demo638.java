package tips.p_1000.p601_650;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author hc
 */
public class Demo638 {

    private List<Integer> price;
    private List<List<Integer>> special;
    Map<List<Integer>, Integer> map;

    public int shoppingOffers(List<Integer> price, List<List<Integer>> special, List<Integer> needs) {
        this.price = price;
        this.special = special;
        this.map = new HashMap<>();
        return dfs(needs);
    }

    public int dfs(List<Integer> needs) {
        if (map.containsKey(needs)) {
            return map.get(needs);
        }
        int res = 0;
        for (int i = 0; i < needs.size(); i++) {
            res += needs.get(i) * price.get(i);
        }

        for (List<Integer> item : special) {
            List<Integer> clone = new ArrayList<>(needs);
            int j = 0;
            for (; j < needs.size(); j++) {
                int differ = needs.get(j) - item.get(j);
                if (differ < 0) {
                    break;
                }
                clone.set(j, differ);
            }

            if (j == needs.size()) {
                res = Math.min(res, item.get(j) + dfs(clone));
            }
        }
        map.put(needs, res);

        return res;
    }
}
