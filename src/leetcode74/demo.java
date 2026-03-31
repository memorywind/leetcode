package leetcode74;

public class demo {
    public boolean searchMatrix(int[][] matrix, int target) {
        int left = 0;
        int right = matrix[0].length * matrix.length -1 ;
        int mid = 0;
        int row = 0;
        int col = 0;
        while (left <= right) {
            mid = left + (right - left) / 2;
            row = mid / matrix[0].length;
            col = mid % matrix[0].length;
            if (matrix[row][col] == target) {
                return true;
            } else if (matrix[row][col] < target) {
                left = mid + 1;
            }else  {
                right = mid - 1;
            }
        }
        return false;
    }
}
