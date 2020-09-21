public class GameOfLife_289 {

    private int[][] board;
    private int row, col;

    public void gameOfLife(int[][] board) {
        this.board = board;
        this.row = board.length;
        this.col = board[0].length;
        boolean[][] newBoard = getNextGeneration();
        for (int r = 0; r < row; ++r)
            for (int c = 0; c < col; ++c)
                board[r][c] = newBoard[r][c] ? 1 : 0;
    }

    public boolean[][] getNextGeneration() {
        boolean[][] next = new boolean[row][col];
        for (int i = 0; i < row; ++i) {
            for (int j = 0; j < col; ++j) {
                int aliveNeighbors = checkAliveNeighbors(i, j);
                next[i][j] = board[i][j] == 1
                        ? (aliveNeighbors >= 2) && (aliveNeighbors <= 3) && board[i][j] == 1
                        : aliveNeighbors == 3 || board[i][j] == 1;
            }
        }
        return next;
    }

    private int checkAliveNeighbors(int r, int c) {
        int aliveNeighbors = 0;
        for (int i = -1; i <= 1; ++i) {
            if ((r + i < 0) || (r + i >= this.row)) continue;
            for (int j = -1; j <= 1; ++j) {
                if ((c + j < 0) || (c + j >= this.col)) continue;
                if ((i == 0) && (j == 0)) continue;
                if (board[r + i][c + j] == 1) ++aliveNeighbors;
            }
        }
        return aliveNeighbors;
    }

}
