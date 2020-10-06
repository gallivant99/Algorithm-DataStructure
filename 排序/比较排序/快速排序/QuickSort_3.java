// 三向切分快速排序


public class QuickSort_3 {
    
    public static void sort(int[] nums) {
        sort(nums, 0, nums.length - 1);
    }
    
    private static void sort(int[] nums, int low, int high) {
        if (low >= high) {
            return;
        }
        int val = nums[low];
        int lt = low;
        int gt = high;
        int i = low + 1;
        while (i <= gt) {
            if (nums[i] < val) {
                swap(nums, lt, i);
                lt++;
                i++;
            } else if (nums[i] > val) {
                swap(nums, gt, i);
                gt--;
            } else {
                i++;
            }
        }
        sort(nums, low, lt - 1);
        sort(nums, gt + 1, high);
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
