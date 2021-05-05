class Solution {
    /*
    * 时间复杂度 O(n^2)
    */
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        
        if (nums == null || nums.length == 0) return ans;
        
        Arrays.sort(nums);
        int n = nums.length;
        
        for (int i = 0; i < n; i++) {
            // get rid of duplicates
            if (i != 0 && nums[i] == nums[i - 1]) continue;
            int left = i + 1;
            int right = n - 1;
            while (left < right) {
                int sum = nums[i] + nums[left] + nums[right];
                if (sum == 0) {
                    ans.add(Arrays.asList(nums[i], nums[left], nums[right]));
                    left++;
                    right--;
                    while (left < right && nums[left] == nums[left - 1]) {left++;}
                }
                else if (sum > 0) {
                    right--;
                } else {
                    left++;
                }
            }
        }
        
        return ans;
    }
    
}