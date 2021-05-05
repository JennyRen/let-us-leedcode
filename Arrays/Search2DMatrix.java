class Solution {
    // 思路是把 所有的row 鏈接起來 想象成一個n * m 的一維 array,然後用binary search. 
    // Time Complexity O(log(n * m)) where n is row, m is column
    // 本題用到的技巧是 一維坐標和二維坐標的轉化 
    public boolean searchMatrix(int[][] matrix, int target) {
        if (matrix == null || matrix.length == 0) return false;
        if (matrix[0] == null || matrix[0].length == 0) return false;
        
        int n = matrix.length;
        int m = matrix[0].length;
        
        int left = 0;
        int right = n * m - 1;
        
        while (left + 1 < right) {
            int mid = left + (right - left) / 2;
            
            // 1維轉2維度
            int i = mid / m;
            int j = mid % m;
            if (matrix[i][j] == target) return true;
            
            if (matrix[i][j] > target) {
                right = mid;
            } else {
                left = mid;
            }
        }
        
        int i = left / m;
        int j = left % m;
        if (matrix[i][j] == target) return true;
        i = right / m;
        j = right % m;
        if (matrix[i][j] == target) return true;
        return false;
    }
    
}