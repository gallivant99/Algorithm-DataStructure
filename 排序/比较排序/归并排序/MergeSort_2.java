// 自底向上的归并排序

public class MergeSort_2 {
    
    private static int[] help;

    public static void sort(int[] nums) {
        int len = nums.length;
        help = new int[len];
        for (int size = 1; size < len; size *= 2) {
            for (int low = 0; low < len - size; low += size * 2) {
                int high = Math.min(low + size * 2 - 1, len - 1);
                merge(nums, low, low + size - 1, high);
            }
        }
        return nums;
    }

    private static void merge(int[] nums, int low, int mid, int high) {
        for (int k = low; k <= high; k++) {
            help[k] = nums[k];
        }
        int i = low;
        int j = mid + 1;
        for (int k = low; k <= high; k++) {
            if (i > mid) {
                nums[k] = help[j];
                j++;
            }
            else if (j > high) {
                nums[k] = help[i];
                i++;
            }
            else if (help[i] > help[j]) {
                nums[k] = help[j];
                j++;
            }
            else {
                nums[k] = help[i];
                i++;
            }
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
