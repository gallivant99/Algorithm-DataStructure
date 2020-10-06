// 冒泡排序


public class BubbleSort {
    
    public static void sort(int[] nums) {
        int len = nums.length;
        boolean flag = true;
        for (int i = len - 1; i > 0; i--) {
            flag = true;
            for (int j = 0; j < i; j++) {
                if (nums[j] > nums[j + 1]) {
                    swap(nums, j, j + 1);
                    flag = false;
                }
            }
            if (flag)
                return;
        }
    }

    private static void swap(int[] nums, int i, int j) {
        if (i == j)
            return;
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
    
}
