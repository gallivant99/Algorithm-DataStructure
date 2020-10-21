class Solution {
    public int lengthOfLIS(int[] nums) {
        if (nums.length == 0)
            return 0;

        int N = nums.length;
        int[] record = new int[N + 1];
        int len = 1;
        record[1] = nums[0];

        for (int i = 1; i < N; i++) {
            if (nums[i] > record[len]) {
                len++;
                record[len] = nums[i];
            } else {
                int index = binarySearch(record, 1, len, nums[i]);
                record[index] = nums[i];
            }
        }

        return len;
    }


    private int binarySearch(int[] nums, int low, int high, int target) {
        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (nums[mid] >= target) {
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }

        return low;
    }
}
