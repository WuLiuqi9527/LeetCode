package p1_50;

import java.util.HashMap;

/**
 * @author hc
 * <p>
 * 给定一个整数数组 nums 和一个目标值 target，请你在该数组中找出和为目标值的那两个整数，并返回他们的数组下标。
 * 你可以假设每种输入只会对应一个答案。但是，数组中同一个元素不能使用两遍。
 */
public class Demo1 {

    public int[] twoSum(int[] nums, int target) {

        /**
         * 暴力解法
         */
//        int[] tem = new int[2];
//        for (int i = 0; i < nums.length - 1; i++) {
//            for (int j = i + 1; j < nums.length; j++) {
//                if (nums[i] + nums[j] == target) {
//                    tem[0]= i;
//                    tem[1] = j;
//                }
//            }
//        }
//        return tem;

        /**
         * 查找表
         * 时间复杂度 O(n)
         */
        // <值， 索引>
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {

            int complement = target - nums[i];
            if (map.containsKey(complement)) {
                // 互补的部分在前面：不断往里添加 所以是往前找
                return new int[]{map.get(complement), i};
            }
            map.put(nums[i], i);
        }
        return new int[]{-1, -1};
    }

    public static void main(String[] args) {

        int[] arr = new Demo1().twoSum(new int[]{2, 11, 7, 15}, 9);
        System.out.println("[" + arr[0] + "," + arr[1] + "]");
    }
}
