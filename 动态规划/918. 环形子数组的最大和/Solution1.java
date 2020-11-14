//方法 1：邻接数组


class Solution {
    public int maxSubarraySumCircular(int[] A) {
        int len = A.length;
        int res = A[0];
        int temp = A[0];

        for (int i = 1; i < len; i++) {
            temp = Math.max(A[i], temp + A[i]);
            res = Math.max(res, temp);
        }

        int[] rightSum = new int[len];
        rightSum[len - 1] = A[len - 1];
        for (int i = len - 2; i > -1; i--) {
            rightSum[i] = A[i] + rightSum[i + 1];
        }

        int[] rightMax = new int[len];
        rightMax[len - 1] = rightSum[len - 1];
        for (int i = len - 2; i > -1; i--) {
            rightMax[i] = Math.max(rightMax[i + 1], rightSum[i]);
        }

        int leftSum = 0;
        for (int i = 0; i < len - 2; i++) {
            leftSum += A[i];
            res = Math.max(res, leftSum + rightMax[i + 2]);
        }

        return res;
    }
}
