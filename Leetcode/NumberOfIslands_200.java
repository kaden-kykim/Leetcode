public class NumberOfIslands_200 {

    public int numIslands(char[][] grid) {
        int count = 0;
        if (grid == null) return count;
        for (int i = 0; i < grid.length; ++i) {
            for (int j = 0; j < grid[0].length; ++j) {
                if (grid[i][j] == '1') {
                    ++count;
                    helper(grid, i, j);
                }
            }
        }
        return count;
    }

    private void helper(char[][] grid, int row, int col) {
        grid[row][col] = '0';
        int r = row, c = col + 1; if (c < grid[0].length && grid[r][c] == '1') helper(grid, r, c);
        r = row + 1; c = col; if (r < grid.length && grid[r][c] == '1') helper(grid, r, c);
        r = row; c = col - 1; if (c >= 0 && grid[r][c] == '1') helper(grid, r, c);
        r = row - 1; c = col; if (r >= 0 && grid[r][c] == '1') helper(grid, r, c);
    }

}
