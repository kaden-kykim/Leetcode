public class MinimumPathSum_64 {

    public int minPathSum(int[][] grid) {
        int row = grid.length, col = grid[0].length;
        int[][] sum = new int[row][col];
        int val = sum[0][0] = grid[0][0];
        for (int r = 1; r < row; ++r) sum[r][0] = val += grid[r][0];
        val = sum[0][0];
        for (int c = 1; c < col; ++c) sum[0][c] = val += grid[0][c];
        for (int r = 1; r < row; ++r) {
            val = sum[r][0];
            for (int c = 1; c < col; ++c) {
                sum[r][c] = val = Math.min(sum[r - 1][c], val) + grid[r][c];
            }
        }
        return sum[row - 1][col - 1];
    }

}
