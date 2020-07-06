import java.util.Arrays;

public class SetMatrixZeroes_73 {

    public void setZeroes(int[][] matrix) {
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) return;
        int row = matrix.length, col = matrix[0].length;
        int zr = -1, zc = -1, r, c;
        for (r = 0; r < row; ++r) {
            for (c = 0; c < col; ++c) {
                if (matrix[r][c] == 0) { zr = r; zc = c; break; }
            }
        }
        if (zr == -1) return;
        for (r = 0; r < row; ++r) {
            if (r == zr) continue;
            for (c = 0; c < col; ++c) {
                if (c == zc) continue;
                if (matrix[r][c] == 0) matrix[zr][c] = matrix[r][zc] = 0;
            }
        }
        for (r = 0; r < row; ++r) {
            if (r == zr) continue;
            for (c = 0; c < col; ++c) {
                if (c == zc) continue;
                if (matrix[r][zc] == 0 || matrix[zr][c] == 0) matrix[r][c] = 0;
            }
        }
        for (r = 0; r < row; ++r) matrix[r][zc] = 0;
        for (c = 0; c < col; ++c) matrix[zr][c] = 0;
    }

}
