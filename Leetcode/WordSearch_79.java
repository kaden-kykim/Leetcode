public class WordSearch_79 {

    public boolean exist(char[][] board, String word) {
        for (int r = 0; r < board.length; ++r) {
            for (int c = 0; c < board[0].length; ++c) {
                if (helper(board, r, c, word, 0)) return true;
            }
        }
        return false;
    }

    private boolean helper(char[][] board, int row, int col, String word, int index) {
        char curChar = word.charAt(index++);
        if (row < 0 || row >= board.length || col < 0 || col >= board[0].length
                || board[row][col] != curChar) return false;
        if (index == word.length()) return true;

        board[row][col] = ' ';
        if (helper(board, row, col + 1, word, index)
                || helper(board, row + 1, col, word, index)
                || helper(board, row - 1, col, word, index)
                || helper(board, row, col - 1, word, index)) return true;
        board[row][col] = curChar;
        return false;
    }

    public boolean exist1(char[][] board, String word) {
        char[] wordArray = word.toCharArray();
        char firstChar = wordArray[0];
        boolean[][] visited = new boolean[board.length][board[0].length];
        for (int r = 0; r < board.length; ++r) {
            for (int c = 0; c < board[0].length; ++c) {
                if (board[r][c] == firstChar) {
                    visited[r][c] = true;
                    if (helper(board, r, c, wordArray, 0, visited)) return true;
                    visited[r][c] = false;
                }
            }
        }
        return false;
    }

    private boolean helper(char[][] board, int curRow, int curCol, char[] word, int index, boolean[][] visited) {
        if (++index == word.length) return true;
        visited[curRow][curCol] = true;

        if (curRow != 0) {
            --curRow;
            if (board[curRow][curCol] == word[index] && !visited[curRow][curCol]
                    && helper(board, curRow, curCol, word, index, visited)) return true;
            ++curRow;
        }

        if (curRow != board.length - 1) {
            ++curRow;
            if (board[curRow][curCol] == word[index] && !visited[curRow][curCol]
                    && helper(board, curRow, curCol, word, index, visited)) return true;
            --curRow;
        }

        if (curCol != 0) {
            --curCol;
            if (board[curRow][curCol] == word[index] && !visited[curRow][curCol]
                    && helper(board, curRow, curCol, word, index, visited)) return true;
            ++curCol;
        }

        if (curCol != board[0].length - 1) {
            ++curCol;
            if (board[curRow][curCol] == word[index] && !visited[curRow][curCol]
                    && helper(board, curRow, curCol, word, index, visited)) return true;
            --curCol;
        }

        visited[curRow][curCol] = false;
        return false;
    }

}
