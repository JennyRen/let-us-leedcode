class Solution {
    /*
    * 时间复杂度 O(n) , 空间O(n)
     */
    public int trap(int[] height) {
        if (height == null || height.length == 0) return 0;
        int n = height.length;
        int[] left = new int[n];
        left[0] = height[0];
        for (int i = 1; i < n; i++) {
            left[i] = Math.max(left[i - 1], height[i]);
        }

        int[] right = new int[n];
        right[n - 1] = height[n - 1];
        for (int j = n - 2; j >= 0; j--) {
            right[j] = Math.max(right[j + 1], height[j]);
        }
        
        int ans = 0;
        for (int i = 0; i < n; i++) {
            ans += Math.min(left[i], right[i]) - height[i];
        }
        return ans;
    }
}