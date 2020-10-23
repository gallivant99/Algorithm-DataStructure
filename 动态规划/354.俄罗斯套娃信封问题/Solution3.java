//思路同Solution2.java
class Solution {
    public int maxEnvelopes(int[][] envelopes) {
        if (envelopes.length == 0) {
            return 0;
        }
        
        int N = envelopes.length;


        quickSort(envelopes, 0, N - 1);

        //dp[i]表示嵌套个数为i时，套娃信封最外面的信封所能允许的最小高度。
        //因为已经对宽度升序排序，无需考虑宽度
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


    //二分查找返回插入位置
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

    //三向切分快速排序，对信封按照宽度升序排序，宽度相同时按照高度降序排序
    private void quickSort(int[][] nums, int left, int right) {
        if (left >= right) {
            return;
        }

        int[] val = nums[left];
        int lt = left;
        int gt = right;
        int i = lt + 1;

        while (i <= gt) {
            if (Compare(nums[i], val) < 0) {
                int[] temp = nums[lt];
                nums[lt] = nums[i];
                nums[i] = temp;
                lt++;
                i++;
            } else if (Compare(nums[i], val) > 0) {
                int[] temp = nums[gt];
                nums[gt] = nums[i];
                nums[i] = temp;
                gt--;
            } else {
                i++;
            }
        }

        quickSort(nums, left, lt - 1);
        quickSort(nums, gt + 1, right);
    }

    private int Compare(int[] a, int[] b) {
        if (a[0] != b[0]) {
            return a[0] - b[0];
        }
        return b[1] - a[1];
    }
}
