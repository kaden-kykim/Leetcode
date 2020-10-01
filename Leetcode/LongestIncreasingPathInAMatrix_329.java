public class LongestIncreasingPathInAMatrix_329 {

    private int row, col;
    private int[][] dpMatrix;

    public int longestIncreasingPath(int[][] matrix) {
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) return 0;
        row = matrix.length;
        col = matrix[0].length;
        dpMatrix = new int[row][col];
        int maxResult = Integer.MIN_VALUE;
        for (int r = 0; r < row; ++r) {
            for (int c = 0; c < col; ++c)
                maxResult = Math.max(maxResult, helper(matrix, matrix[r][c] - 1, r, c));
        }
        return maxResult - 1;
    }

    private int helper(int[][] matrix, int value, int r, int c) {
        if (r < 0 || r >= row || c < 0 || c >= col || matrix[r][c] <= value) return 1;
        if (dpMatrix[r][c] != 0) return dpMatrix[r][c] + 1;
        int max = 1, val = matrix[r][c];
        max = Math.max(max, helper(matrix, val, r + 1, c));
        max = Math.max(max, helper(matrix, val, r, c + 1));
        max = Math.max(max, helper(matrix, val, r - 1, c));
        max = Math.max(max, helper(matrix, val, r, c - 1));
        return (dpMatrix[r][c] = max) + 1;
    }

}
