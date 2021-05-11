package tip.lt1000.p301_350;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * 给你一个嵌套的整型列表。请你设计一个迭代器，使其能够遍历这个整型列表中的所有整数。
 * 列表中的每一项或者为一个整数，或者是另一个列表。其中列表的元素也可能是整数或是其他列表。
 * <p>
 * 示例 1:
 * 输入: [[1,1],2,[1,1]]
 * 输出: [1,1,2,1,1]
 * 解释: 通过重复调用 next 直到 hasNext 返回 false，
 * next 返回的元素的顺序应该是: [1,1,2,1,1]。
 *
 * @author hc
 */
public class Demo341 {

    public interface NestedInteger {

        // @return true if this NestedInteger holds a single integer, rather than a nested list.
        public boolean isInteger();

        // @return the single integer that this NestedInteger holds, if it holds a single integer
        // Return null if this NestedInteger holds a nested list
        public Integer getInteger();

        // @return the nested list that this NestedInteger holds, if it holds a nested list
        // Return null if this NestedInteger holds a single integer
        public List<NestedInteger> getList();
    }

    public class NestedIterator implements Iterator<Integer> {

        private List<Integer> list = new ArrayList<>();
        private int index;

        public NestedIterator(List<NestedInteger> nestedList) {
            add(nestedList);
        }

        private void add(List<NestedInteger> nestedList) {
            for (NestedInteger nestedInteger : nestedList){
                if (nestedInteger.isInteger()){
                    list.add(nestedInteger.getInteger());
                }else {
                    add(nestedInteger.getList());
                }
            }
        }

        @Override
        public Integer next() {
            return list.get(index++);
        }

        @Override
        public boolean hasNext() {
            return index < list.size();
        }
    }
}
