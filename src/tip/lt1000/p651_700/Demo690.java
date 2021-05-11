package tip.lt1000.p651_700;

import java.util.*;

/**
 * 给定一个保存员工信息的数据结构，它包含了员工 唯一的 id ，重要度 和 直系下属的 id 。
 * 比如，员工 1 是员工 2 的领导，员工 2 是员工 3 的领导。他们相应的重要度为 15 , 10 , 5 。
 * 那么员工 1 的数据结构是 [1, 15, [2]] ，员工 2的 数据结构是 [2, 10, [3]] ，员工 3 的数据结构是 [3, 5, []] 。
 * 注意虽然员工 3 也是员工 1 的一个下属，但是由于 并不是直系 下属，因此没有体现在员工 1 的数据结构中。
 * 现在输入一个公司的所有员工信息，以及单个员工 id ，返回这个员工和他所有下属的重要度之和。
 * <p>示例：
 * 输入：[[1, 5, [2, 3]], [2, 3, []], [3, 3, []]], 1
 * 输出：11
 * 解释：
 * 员工 1 自身的重要度是 5 ，他有两个直系下属 2 和 3 ，而且 2 和 3 的重要度均为 3 。因此员工 1 的总重要度是 5 + 3 + 3 = 11 。
 * <p>提示：
 * 一个员工最多有一个 直系 领导，但是可以有多个 直系 下属
 * 员工数量不超过 2000 。
 *
 * @author hc
 */
public class Demo690 {

    class Employee {
        public int id;
        public int importance;
        public List<Integer> subordinates;
    }

    public int getImportance(List<Employee> employees, int id) {
        int index = -1;
        int size = employees.size();
        for (int i = 0; i < size; i++) {
            if (employees.get(i).id == id) {
                index = i;
            }
        }
        int res = employees.get(index).importance;

        int len = employees.get(index).subordinates.size();
        for (int i = 0; i < len; i++) {
            res += getImportance(employees, employees.get(index).subordinates.get(i));
        }
        return res;
    }

    public int getImportance2(List<Employee> employees, int id) {
        for (Employee e : employees) {
            if (e.id == id) {
                if (e.subordinates.size() == 0) {
                    return e.importance;
                }
                for (int subId : e.subordinates) {
                    e.importance += getImportance(employees, subId);
                }
                return e.importance;
            }
        }
        return 0;
    }

    /** 用队列或者栈存放待处理的结点，不用递归 */
    public int getImportance3(List<Employee> employees, int id) {
        Map<Integer, Employee> map = new HashMap<>();
        for (Employee e : employees) {
            map.put(e.id, e);
        }

        Queue<Employee> queue = new LinkedList<>();
        queue.offer(map.get(id));
        int res = 0;
        while (!queue.isEmpty()) {
            Employee e = queue.poll();
            res += e.importance;
            for (int subId : e.subordinates) {
                queue.offer(map.get(subId));
            }
        }
        return res;
    }
}
