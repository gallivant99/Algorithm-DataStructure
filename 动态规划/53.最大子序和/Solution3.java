class Solution {

    public class record {
        public int leftMax = 0;
        public int rightMax = 0;
        public int max = 0;
        public int sum = 0;

        public record(int leftMax, int rightMax, int max, int sum) {
            this.leftMax = leftMax;
            this.rightMax = rightMax;
            this.max = max;
            this.sum = sum;
        }
    }

    public int maxSubArray(int[] nums) {
        return maxSubArray(nums, 0, nums.length - 1).max;
    }

    public record maxSubArray(int[] nums, int left, int right) {
        if (left == right) {
            return new record(nums[left], nums[left], nums[left], nums[left]);
        }

        int mid = left + (right - left) / 2;

        record l = maxSubArray(nums, left, mid);
        record r = maxSubArray(nums, mid + 1, right);

        int leftMax = Math.max(l.leftMax, l.sum + r.leftMax);
        int rightMax = Math.max(r.rightMax, r.sum + l.rightMax);
        int max = Math.max(l.rightMax + r.leftMax, Math.max(l.max, r.max));
        int sum = l.sum + r.sum;

        return new record(leftMax, rightMax, max, sum);
    }
}
