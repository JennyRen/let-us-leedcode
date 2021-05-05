public class Solution {

    public double findMedianSortedArrays(int[] A, int[] B) {
        int n = A.length;
        int m = B.length;

        // getmedian => get kth
        int mid = (n + m) / 2;
        if ((n + m) % 2 == 0) {
            int left = find(A, B, mid);
            int right = find(A, B, mid + 1);
            return (left + right) / 2.0;
        } else {
            return find(A, B, mid + 1);
        }

    }
    private int find(int[] A, int[]B, int k)  {
        if (A.length == 0) {
            return B[k - 1];
        }
        if (B.length == 0) {
            return A[k - 1];
        }
        int n = A.length;
        int m = B.length;

        int left = Math.min(A[0], B[0]);
        int right = Math.max(A[n - 1], B[m - 1]);

        while (left + 1 < right) {
            int mid = left + (right - left) / 2;
            // check count
            int count = getCount(A, B, mid);
            if (count < k) {
                left = mid;
            } else {
                right = mid;
            }
        }
        int count = getCount(A, B, left);
        // 为什么大于等于呢？因为如果有重复的话肯定超过了这个数字，如果没有重复就刚好等于
        if (getCount(A, B, left) >= k) return left;
        return right;
    }

    private int getCount(int[] A, int[] B, int mid) {
        int count = 0;

        count += (binarySearch(A, mid));
        count +=  (binarySearch(B, mid));
        return count;
    }

    private int binarySearch(int[] A, int target) {
        int left = 0;
        int right = A.length - 1;
        while (left + 1 < right) {
            int mid = left + (right - left) / 2;
            if (A[mid] <= target) {
                left = mid;
            } else {
                right = mid;
            }
        }

        if (A[left] > target) return left;
        if (A[right] > target) return right;
        return A.length;
    }
}