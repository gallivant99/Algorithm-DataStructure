class Solution {
    public int maxEnvelopes(int[][] envelopes) {
        if (envelopes.length == 0) {
            return 0;
        }

        // 根据宽度对信封进行升序排序
        // 排完序后将问题转化为求最长递增子序列的问题，用动态规划求解
        Arrays.sort(envelopes, (int[] a, int[] b) -> {
            if (a[0] > b[0]) {
                return 1;
            } else if (a[0] < b[0]) {
                return -1;
            } else {
                return 0;
            }
        });
        
        int len = envelopes.length;

        int[] dp = new int[len];
        Arrays.fill(dp, 1);

        int res = 1;

        for (int i = 1; i < len; i++) {
            for (int j = 0; j < i; j++) {
                if (envelopes[i][0] > envelopes[j][0] && envelopes[i][1] > envelopes[j][1]) {
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
            }
            res = Math.max(res, dp[i]);
        }

        return res;
    }
}
