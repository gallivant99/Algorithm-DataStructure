// 堆排序


public class HeapSort {
    
    public static void Sort(int[] nums) {
        int len = nums.length;
        buildHeap(nums);
        for (int i = len - 1; i > 0; i--) {
            swap(nums, 0, i);
            sink(nums, 0, i - 1);
        }
    }
    
    private static void buildHeap(int[] nums) {
        int len = nums.length;
        for (int i = len / 2 - 1; i >= 0; i--) {
            sink(nums, i, len - 1);
        }
    }

    private static void sink(int[] nums, int k, int len) {
        while (k * 2 + 1 <= len) {
            int index = k * 2 + 1;
            if (index < len && nums[index] < nums[index + 1]) {
                index++;
            }
            if (nums[k] >= nums[index]) {
                break;
            }
            swap(nums, k, index);
            k = index;
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
