import java.util.Arrays;

public class SearchA2DMatrixII_240 {

    public boolean searchMatrix(int[][] matrix, int target) {
        if (matrix == null || matrix.length == 0) return false;
        int row = matrix.length, col = matrix[0].length;
        int r = row - 1, c = 0;
        while (r >= 0 && r < row && c >= 0 && c < col) {
            if (matrix[r][c] == target) return true;
            else if (matrix[r][c] > target) --r;
            else ++c;
        }
        return false;
    }

    public boolean searchMatrix1(int[][] matrix, int target) {
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) return false;
        int col = matrix[0].length - 1;
        for (int[] ints : matrix) {
            if (ints[0] <= target && target <= ints[col]) {
                if (Arrays.binarySearch(ints, target) >= 0) return true;
            }
        }
        return false;
    }

}
