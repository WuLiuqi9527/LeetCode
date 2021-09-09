package tips.p_1000.p51_100;

import java.util.Arrays;

/**
 * 给定一个包含红色、白色和蓝色，一共 n 个元素的数组，原地对它们进行排序
 * 使得相同颜色的元素相邻，并按照红色、白色、蓝色顺序排列。
 * <p>
 * 此题中，我们使用整数 0、1 和 2 分别表示红色、白色和蓝色。
 * <p>
 * 示例 1：
 * 输入：nums = [2,0,2,1,1,0]
 * 输出：[0,0,1,1,2,2]
 *
 * @author hc
 */
public class Demo75 {

    public void sortColors(int[] nums) {
        // 1、直接调用系统排序
        Arrays.sort(nums);
        // 2、计算出现次数，重组：计数排序思想 时间复杂度 O(n) 空间复杂度 O(k) k为数组的类别数
        int[] count = new int[3];
        for (int num : nums) {
            count[num]++;
        }
        for (int i = 0; i < nums.length; i++) {
            if (i < count[0]) {
                nums[i] = 0;
            } else if (i < count[0] + count[1]) {
                nums[i] = 1;
            } else {
                nums[i] = 2;
            }
        }

        /**
         * 3、利用三路快排
         * 时间复杂度 O(n)   空间复杂度 O(1) 只遍历数组一遍
         */
        int zero = -1;
        int two = nums.length;
        for (int i = 0; i < two; ) {
            if (nums[i] == 1) {
                i++;
            } else if (nums[i] == 2) {
                swap(nums, i, --two);
            } else {
                assert (nums[i] == 0);
                swap(nums, ++zero, i++);
            }
        }
        for (int num : nums) {
            System.out.print(num);
        }
    }

    private void swap(int[] arr, int i, int j) {
        int tem = arr[i];
        arr[i] = arr[j];
        arr[j] = tem;
    }

    public void sortColors2(int[] nums) {
        int zero = 0, one = 0;
        for(int num : nums) {
            if(num == 0) {
                ++zero;
            }else if(num == 1) {
                ++one;
            }
        }
        int index = 0, len = nums.length;
        while(index < len) {
            if(zero-- > 0) {
                nums[index++] = 0;
            }else if(one-- > 0) {
                nums[index++] = 1;
            }else{
                nums[index++] = 2;
            }
        }
    }

    public static void main(String[] args) {
        new Demo75().sortColors2(new int[]{2, 0, 2, 1, 1, 0});
    }
}
