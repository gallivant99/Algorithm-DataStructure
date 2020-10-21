class Solution {


    //由于是单串dp，且依赖比 i 小的 O(1) 个子问题，因此可以进行空间上的优化
    public int maxSubArray(int[] nums) {
        if (nums.length == 0) {
            return 0;
        }

        //数组长度
        int N = nums.length;

        //全局最优解
        int res = nums[0];

        //以当前下标为终点最优解
        int record = nums[0];

        for (int i = 1; i < N; i++) {
            record = Math.max(record + nums[i], nums[i]);
            res = Math.max(res, record);
        }

        return res;
    }
}
