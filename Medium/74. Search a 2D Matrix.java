class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int row = matrix.length, col = matrix[0].length;
        // find row first -> bs
        int left = 0, mid = 0, right = row - 1;
        while (left < right) {
            mid = (left + right) / 2;
            if (matrix[mid][col - 1] > target) {
                right = mid;
            } else if (matrix[mid][col - 1] < target) {
                left = mid + 1;
            } else {
                return true;
            }
        }
        // find col now -> bs
        row = right;
        left = 0;
        right = col - 1;
        while (left <= right) {
            mid = (left + right) / 2;
            if (matrix[row][mid] > target) {
                right = mid - 1;
            } else if (matrix[row][mid] < target) {
                left = mid + 1;
            } else {
                return true;
            }
        }
        return false;
    }
}