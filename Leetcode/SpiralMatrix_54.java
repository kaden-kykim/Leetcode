import java.util.ArrayList;
import java.util.List;

public class SpiralMatrix_54 {

    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> result = new ArrayList<>();
        if (matrix == null || matrix.length == 0) return result;
        int m = matrix.length, n = matrix[0].length;
        int pad = 0, tr, tc;
        for (int r = 0; r < (m + 1) / 2; ++r) {
            for (tc = pad; tc < n - pad; ++tc) result.add(matrix[r][tc]);
            for (tr = r + 1; tr < m - pad; ++tr) result.add(matrix[tr][n - pad - 1]);
            if (m - pad - 1 != r) for (tc = n - pad - 2; tc >= pad; --tc) result.add(matrix[m - pad - 1][tc]);
            if (n - pad - 1 != pad) for (tr = m - pad - 2; tr >= pad + 1; --tr) result.add(matrix[tr][pad]);
            ++pad;
            if (n - pad < 2) break;
        }
        return result;
    }

}
