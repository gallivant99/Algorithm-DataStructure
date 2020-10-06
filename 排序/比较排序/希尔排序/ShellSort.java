// 希尔排序（改良版插入排序）
// 性能无法确定，取决于递增序列k

public class ShellSort {
 
    private static void sort(int[] nums) {
        int len = nums.length;
        int k = 1;
        
        // 确定递增序列
        while (k * 3 + 1 < len) {
            k = k * 3 + 1;
        }
        
        // 通过递增序列确定每次使用插入排序的步长，直到步长k = 1时结束
        while (k > 0) {
            InsertionSort(nums, k);
            k /= 3;
        }
        
    }

    // 可控制步长的插入排序
    // 当步长step = 1时，为普通的插入排序
    private static void InsertionSort(int[] nums, int step) {
        int len = nums.length;
        for (int i = step; i < len; i++) {
            for (int j = i; j >= step; j--) {
                if (nums[j] > nums[j - step]) {
                    break;
                }
                swap(nums, j, j - step);
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
