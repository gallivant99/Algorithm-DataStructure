// 自顶向下的归并排序


public class MergeSort_1 {
    
    // 辅助数组
    private static int[] help;

    public static void sort(int[] nums) {
        int len = nums.length;
        help = new int[len];
        sort(nums, 0, len - 1);
        return nums;
    }

    private static void sort(int[] nums, int low, int high) {
        if (low >= high) {
            return;
        }
        int mid = low + (high - low) / 2;
        sort(nums, low, mid);
        sort(nums, mid + 1, high);
        merge(nums, low, mid, high);
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

}
