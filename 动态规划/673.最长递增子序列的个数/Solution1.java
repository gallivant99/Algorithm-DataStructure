class Solution {
    public int findNumberOfLIS(int[] nums) {
        //空数组返回0
        if (nums.length == 0)
        {
            return 0;
        }

        //数组长度
        int len = nums.length;

        //dp[i]表示以第i个元素结尾的最长递增子序列的长度
        int[] dp = new int[len];
        Arrays.fill(dp, 1);

        //record[i]表示以第i个元素结尾的最长递增子序列的个数
        int[] record = new int[len];
        Arrays.fill(record, 1);

        for (int i = 1; i < len; i++)
        {
            for (int j = 0; j < i; j++)
            {
                if (nums[i] > nums[j])
                {
                    //第一次遇到更大长度：更新dp[i]和record[i]
                    if (dp[i] < dp[j] + 1)
                    {
                        dp[i] = dp[j] + 1;
                        record[i] = record[j];
                    }
                    //后续遇到最大长度：累加record[i]
                    else if (dp[i] == dp[j] + 1)
                    {
                        record[i] += record[j];
                    }
                }
            }
        }

        //找到最大长度
        int maxLen = dp[0];
        for (int i = 1; i < len; i++) {
            if (maxLen < dp[i]) {
                maxLen = dp[i];
            }
        }

        //找到最大长度对应的个数
        int res = 0;
        for (int i = 0; i < len; i++) {
            if (dp[i] == maxLen) {
                res += record[i];
            }
        }

        return res;
    }
}
