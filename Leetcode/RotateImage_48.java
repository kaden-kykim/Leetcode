public class RotateImage_48 {

    public void rotate(int[][] matrix) {
        if (matrix == null || matrix.length < 2) return;
        int n = matrix.length;
        for (int i = 0; i < n - 1; ++i) {
            for (int j = i; j < n - i - 1; ++j) {
                int row = i, col = j, temp = matrix[row][col];
                for (int k = 0; k < 3; ++k) {
                    int newRow = n - 1 - col, newCol = row;
                    matrix[row][col] = matrix[newRow][newCol];
                    row = newRow;
                    col = newCol;
                }
                matrix[row][col] = temp;
            }
        }
    }

}
