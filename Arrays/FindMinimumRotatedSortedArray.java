class Solution {
    // 思路 把最後一個element 作爲 search target
    public int findMin(int[] nums) {
        if (nums == null || nums.length == 0) return 0;
        
        int left = 0;
        int right = nums.length - 1;
        int target = nums[nums.length - 1];
        while (left + 1 < right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] > target) {
                left = mid;
            } else {
                right = mid;
            }
        }
        
        return Math.min(nums[left], nums[right]);
    }
}