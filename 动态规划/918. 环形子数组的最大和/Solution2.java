//计算数组区间[1, (length - 2)]的最小子数组和，然后用数组总数和减去最小和就能得到双区间子段的最大和，再与单区间字段最大和对比得到最终结果


class Solution {
    public int maxSubarraySumCircular(int[] A) {
        int res = A[0];
        int temp = A[0];
        int sum = A[0];
        int len = A.length;

        for (int i = 1; i < len; i++) {
            sum += A[i];
            temp = Math.max(A[i], temp + A[i]);
            res = Math.max(res, temp);
        }
        
        if (len >= 3) {
            int min = A[1];
            temp = A[1];
            for (int i = 2; i < len - 1; i++) {
                temp = Math.min(A[i], temp + A[i]);
                min = Math.min(min, temp);
            }
            
            res = Math.max(res, sum - min);
        }
        
        return res;
    }
}
