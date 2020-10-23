class Solution {
    public int maxEnvelopes(int[][] envelopes) {
        if (envelopes.length == 0) {
            return 0;
        }
        
        Arrays.sort(envelopes, (int[] a, int[] b) -> {
            if (a[0] != b[0]) {
                return a[0] - b[0];
            }
            return b[1] - a[1];
        });
        
        int N = envelopes.length;

        int[] dp = new int[N + 1];
        int len = 1;
        dp[1] = envelopes[0][1];

        for (int i = 1; i < N; i++) {
            if (envelopes[i][1] > dp[len]) {
                len++;
                dp[len] = envelopes[i][0];
                dp[len] = envelopes[i][1];
            } else {
                int index = binarySearch(dp, 1, len, envelopes[i][1]);
                dp[index] = envelopes[i][0];
                dp[index] = envelopes[i][1];
            }
        }

        return len;
    }


    private int binarySearch(int[] dp, int left, int right, int target) {
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (dp[mid] >= target) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        return left;
    }
}
