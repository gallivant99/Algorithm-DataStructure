class Solution {
    public int maxSubArray(int[] nums) {
        if (nums.length == 0) {
            return 0;
        }

        // 数组长度
        int N = nums.length;

        //dp数组
        int[] dp = new int[N];

        //初始化
        //最大子序和必定以数组中某个元素结尾
        //dp[i]为考虑当前下标（必须包含当前下标元素）为终点的最大子序和
        //转移方程：dp[i] = nums[i] + Math.max(dp[i - 1], 0)
        dp[0] = nums[0];

        //结果
        int res = dp[0];

        for (int i = 1; i < N; i++) {
            dp[i] = nums[i] + Math.max(0, dp[i - 1]);
            res = Math.max(res, dp[i]);
        }

        return res;
    }
}
