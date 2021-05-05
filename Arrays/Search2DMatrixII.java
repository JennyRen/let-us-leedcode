class Solution {
    /*
    * 解體思路， 斜綫上某個值的column所有值都比該值小，row上所有值都比該值大， 所以可以用2指針走斜綫來做
    * Time Complexity O(n * m) where n is number of row , m is number of column
    */
    public boolean searchMatrix(int[][] matrix, int target) {
        if (matrix == null || matrix.length == 0) return false;
        if (matrix[0] == null || matrix[0].length == 0) return false;
        
        int n = matrix.length;
        int m = matrix[0].length;
        
        int i = n - 1;
        int j = 0;
        
        while (i >= 0 && j < m) {
            if (matrix[i][j] == target) return true;
            if (matrix[i][j] > target) {
                i--;
            } else {
                j++;
            }
        }
        
        return false;
    }
}