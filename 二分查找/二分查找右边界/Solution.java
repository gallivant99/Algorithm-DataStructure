// 二分查找搜寻目标元素右边界

class Solution {

    public int binarySearch(int[] nums, int target) {
        int low = 0;
        int high = target.length - 1;

        while (low < high) {
            int mid = low + (high - low) / 2 + 1;

            if (nums[mid] > target) {
                high = mid - 1;
            } else {
                low = mid;
            }
        }

        if (nums[high] != target) {
            return -1;
        }

        return high;
    }
}
