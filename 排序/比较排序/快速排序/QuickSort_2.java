// 双向切分快速排序


class QuickSort_2 {
  
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

  
    private static int partition(int[] nums, int low, int high) {
        int val = nums[low];
        int i = low + 1;
        int j = high;
        while (true) {
            while (i < high && nums[i] < val) {
                i++;
            }
            while (j > low && nums[j] > val) {
                j--;
            }
            if (i >= j) {
                break;
            }
            swap(nums, i, j);
            i++;
            j--;
        }
        swap(nums, j, low);
        return j;
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
