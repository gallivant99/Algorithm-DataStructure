class Solution {
    public int maxProduct(int[] nums) {
        int N = nums.length;

        int[] min = new int[N];
        int[] max = new int[N];

        min[0] = nums[0];
        max[0] = nums[0];

        int res = nums[0];

        for (int i = 1; i < N; i++) {
            if (nums[i] < 0) {
                min[i] = Math.min(max[i - 1] * nums[i], nums[i]);
                max[i] = Math.max(min[i - 1] * nums[i], nums[i]);
            } else if (nums[i] > 0) {
                min[i] = Math.min(min[i - 1] * nums[i], nums[i]);
                max[i] = Math.max(max[i - 1] * nums[i], nums[i]);
            } else {
                min[i] = 0;
                max[i] = 0;
            }
            res = Math.max(res, max[i]);
        }

        return res;
    }
}
