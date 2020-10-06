// 单项切分快速排序

pubLic class QuickSort_1 {
    
    public static void sort(int[] nums) {
        sort(nums, 0, nums.length - 1);
    }
    
    private static void sort(int[] nums, int low, int high) {
        if (low >= high) {
            return;
        }
        int index = partition(nums, low, high);
        sort(nums, low, index - 1);
        sort(nums, index + 1, high);
    }

    // 单项切分函数
    private static int partition(int[] nums, int low, int high) {
        int val = nums[high];
        int i = low - 1;
        for (int j = low; j < high; j++) {
            if (nums[j] <= val) {
                i++;
                swap(nums, i, j);
            }
        }
        swap(nums, i + 1, high);
        return i + 1;
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
