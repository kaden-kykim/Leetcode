public class MaximalSquare_221 {

    public int maximalSquare(char[][] matrix) {
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) return 0;
        int row = matrix.length, col = matrix[0].length;
        int[][] histMatrix = new int[row][col];
        for (int c = 0; c < col; ++c) {
            int hist = 0;
            for (int r = 0; r < row; ++r) {
                if (matrix[r][c] == '1') histMatrix[r][c] = ++hist;
                else histMatrix[r][c] = hist = 0;
            }
        }
        int result = 0;
        for (int r = 0; r < row; ++r) {
            int[] histRow = histMatrix[r];
            for (int c = 0; c < col; ++c) {
                int length = Math.min(histRow[c], col - c);
                for (int len = c + 1; len < c + length; ++len) length = Math.min(length, histRow[len]);
                result = Math.max(result, length * length);
            }
        }
        return result;
    }

}
