class Solution {
    //解法一
    public int firstMissingPositive(int[] nums) {
        if (nums == null || nums.length == 0) return 1;
        
        int n = nums.length;
        boolean containsOne = false;
        // step 1 find convert all <= 0 and > n into 1
        for (int i = 0; i < n; i++) {
            if (nums[i] == 1) {
                containsOne = true;
            }
            if (nums[i] <= 0 || nums[i] > n) {
                nums[i] = 1;
            }
        }
        
        if (!containsOne) return 1;
        
        // step 2, turn all positive into negative on the given index(value)
        for (int i = 0; i < n; i++) {
            // note； the value could have been zero already
            int index = Math.abs(nums[i]) - 1;
            if (nums[index] > 0) {
                nums[index] = -1 * nums[index];
            }
        }
        // step 3, find the first non negative number with its index + 1 is the ans
        for (int i = 0; i < n; i++) {
            if (nums[i] > 0) {
                return i + 1;
            }
        }
            
        // edge case, if array did not have negative value
        return n + 1;
    }
}

//解法二
public class Solution {
    public int firstMissingPositive(int[] A) {
        if ( A == null || A.length == 0) return 1;
        int n = A.length;
        for(int i = 0; i < n; ++ i) {
            while(A[i] > 0 && A[i] <= n && A[A[i] - 1] != A[i]) {
                swap(A, i, A[i] - 1);
            }
        }
        for(int i = 0; i < n; ++ i) {
            if(A[i] != i + 1) {
                return i + 1;
            }
        }
        return n + 1;
    }

    private void swap(int[] A, int i, int j) {
        int temp = A[i];
        A[i] = A[j];
        A[j] = temp;
    }
}