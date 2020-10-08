import java.util.Arrays;

public class KthSmallestElementInASortedMatrix_378 {

    public int kthSmallest(int[][] matrix, int k) {
        int n = matrix.length;
        int l = matrix[0][0], r = matrix[n - 1][n - 1];
        while (l <= r) {
            int mid = l + (r - l) / 2;
            if (helper(matrix, mid) < k) l = mid + 1;
            else r = mid - 1;
        }
        return l;
    }

    private int helper(int[][] matrix, int num) {
        int n = matrix.length, count = 0, r = 0, c = n - 1;
        while (r < n && c >= 0) {
            if (matrix[r][c] <= num) { count += c + 1; ++r;}
            else --c;
        }
        return count;
    }

    public int kthSmallest1(int[][] matrix, int k) {
        int n = matrix.length, nSq = n * n;
        boolean reverse = k > (nSq + 1) / 2;
        int[] curCol = new int[n];
        if (reverse) Arrays.fill(curCol, n - 1); else Arrays.fill(curCol, 0);
        int result = 0;
        if (reverse) {
            for (int i = 0; i <= nSq - k; ++i) {
                int prevCol = -1, maxValue = Integer.MIN_VALUE, maxRow = 0;
                for (int r = n - 1; r >= 0; --r) {
                    int c = curCol[r];
                    if (prevCol < c) {
                        prevCol = c;
                        if (maxValue < matrix[r][c]) {
                            maxValue = matrix[r][c];
                            maxRow = r;
                        }
                    }
                    if (prevCol == n - 1) break;
                }
                --curCol[maxRow];
                result = maxValue;
            }
        } else {
            for (int i = 0; i < k; ++i) {
                int prevCol = n, minValue = Integer.MAX_VALUE, minRow = 0;
                for (int r = 0; r < n; ++r) {
                    int c = curCol[r];
                    if (c < prevCol) {
                        prevCol = c;
                        if (matrix[r][c] < minValue) {
                            minValue = matrix[r][c];
                            minRow = r;
                        }
                    }
                    if (prevCol == 0) break;
                }
                ++curCol[minRow];
                result = minValue;
            }
        }
        return result;
    }

}
