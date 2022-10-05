package utils;

import common.ListNode;

import java.util.Arrays;
import java.util.List;

public class PrintUtils {

    // 打印 int 数组
    public static void printArray(int[] arr) {
        System.out.println(Arrays.stream(arr).boxed().toList());
    }

    // 打印 链表
    public static void printListNode(ListNode root) {
        if (root == null) {
            return;
        }
        StringBuilder sb = new StringBuilder();
        sb.append(root.val);
        while (root.next != null) {
            sb.append("->").append(root.next.val);
            root = root.next;
        }
        System.out.println(sb);
    }

    // 打印 list<String>
    public static void printListString(List<String> list) {
        for (String s : list) {
            System.out.println(s);
        }
    }
}
