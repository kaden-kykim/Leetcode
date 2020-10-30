public class MaximalRectangle_85 {

    public int maximalRectangle(char[][] matrix) {
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) return 0;
        int row = matrix.length, col = matrix[0].length;
        int[][] histMatrix = new int[row][col];
        for (int c = 0; c < col; ++c) {
            int hist = 0;
            for (int r = row - 1; r >= 0; --r) {
                if (matrix[r][c] == '1') histMatrix[r][c] = ++hist;
                else histMatrix[r][c] = hist = 0;
            }
        }

        int result = 0;
        for (int r = 0; r < row; ++r) {
            int[] histRow = histMatrix[r];
            int[] posL = new int[col], posR = new int[col];
            int pos;
            for (int c = 1; c < col; ++c) {
                pos = c;
                while (--pos >= 0 && histRow[c] <= histRow[pos]) pos = posL[pos];
                posL[c] = pos + 1;
            }
            posR[col - 1] = col - 1;
            for (int c = col - 2; c >= 0; --c) {
                pos = c;
                while (++pos < col && histRow[c] <= histRow[pos]) pos = posR[pos];
                posR[c] = pos - 1;
            }
            int max = Integer.MIN_VALUE;
            for (int c = 0; c < col; ++c)
                max = Math.max(max, histRow[c] * (posR[c] - posL[c] + 1));
            result = Math.max(result, max);
            if (result >= (row - r) * col) break;
        }
        return result;
    }

}
