class Solution {
    /*
    * 解法一： 找出最小值， 然後判斷target 屬於哪一邊， 然後對著那一邊binary search
    * 解法二： 直接bianry search,具體解法見implementation
    */
    public boolean search(int[] nums, int target) {
        if (nums == null || nums.length == 0) return false;
        
        int left = 0;
        int right = nums.length - 1;
        while (left + 1 < right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] == target) return true;
            if (nums[mid] > nums[left]) { // on the first half
                if (nums[left] <= target && target <= nums[mid]) {
                    right = mid;
                } else {
                    left = mid;
                }
            } else if (nums[mid] < nums[left]) {
                if (nums[mid] <= target && target <= nums[right]) {
                    left = mid;
                } else {
                    right = mid;
                }
            } else {
                left++; // duplicated
            }
        }
        
        if (nums[left] == target) return true;
        if (nums[right] == target) return true;
        return false;
    }
}