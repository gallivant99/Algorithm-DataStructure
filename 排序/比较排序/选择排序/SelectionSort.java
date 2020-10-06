// 选择排序


public class SelectionSort {

    public static void sort(int[] nums) {
        int len = nums.length;
        for (int i = 0; i < len; i++) {
            int min = i;
            for (int j = i + 1; j < len; j++) {
                if (nums[min] > nums[j]) {
                    min = j;
                }
            }
            swap(nums, min, i);
        }
    }


    private static void swap(int[] nums, int i, int j) {
        if (i == j) {
            return;
        }
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}
