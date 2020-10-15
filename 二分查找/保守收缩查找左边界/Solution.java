// 保守收缩查找左边界

class Solution {
    
    public int search(int[] nums, int target) {
        int low = 0;
        int high = nums.length - 1;
        
        while (left < right) {
            int mid = left + (right - left) / 2;
            
            if (nums[mid] < target) {
                low = mid + 1;
            } else if (nums[mid] > target) {
                high = mid;
            } else {
                high--;
            }
        }
        
        if (nums[low] != target) {
            return -1;
        }

        return low;
    }
    
}
