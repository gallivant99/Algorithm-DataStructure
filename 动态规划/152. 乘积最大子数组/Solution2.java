class Solution {
    public int maxProduct(int[] nums) {
        int N = nums.length;

        int min = nums[0];
        int max = nums[0];

        int res = nums[0];

        for (int i = 1; i < N; i++) {
            if (nums[i] < 0) {
                int temp = min;
                min = Math.min(max * nums[i], nums[i]);
                max = Math.max(temp * nums[i], nums[i]);
            } else {
                min = Math.min(min * nums[i], nums[i]);
                max = Math.max(max * nums[i], nums[i]);
            }
            res = Math.max(res, max);
        }

        return res;
    }
}
