//最優解
class Solution {
    public int subarraySum(int[] nums, int k) {
        if (nums == null || nums.length == 0) return 0;
        int count = 0, sum = 0;
        HashMap<Integer, Integer> map = new HashMap<>(); // key is sum. value is count
        map.put(0, 1);
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
            if (map.containsKey(sum - k)) {
                count += map.get(sum - k);
            } 
            map.put(sum, map.getOrDefault(sum, 0) + 1);
        }
        return count;
    }
}
//次優解
public class Solution {
    /**
     * @param nums: a list of integer
     * @param k: an integer
     * @return: return an integer, denote the number of continuous subarrays whose sum equals to k
     */
    public int subarraySum(int[] nums, int k) {
        if (nums == null || nums.length == 0) return 0;
        int n = nums.length;
        int[] sum = new int[n];

        sum[0] = nums[0];
        for (int i = 1; i < n; i++) {
            sum[i] = sum[i - 1] + nums[i];
        }

        // prefix sum: sum[i...j] = sum[i] - sum[j - 1]
        int ans = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j <= i; j++) {
                if (j == 0) {
                    if (sum[i] == k) ans++;
                } else if (sum[i] - sum[j - 1] == k) {
                    ans++;
                }
            }
        }
        return ans;
    }
}