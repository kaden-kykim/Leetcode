import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class SurroundedRegions_130 {

    public void solve(char[][] board) {
        if (board == null || board.length == 0 || board[0].length == 0) return;
        int row = board.length, col = board[0].length;
        for (int r = 0; r < row; ++r) {
            helper(r, 0, row, col, board);
            helper(r, col - 1, row, col, board);
        }
        for (int c = 0; c < col; ++c) {
            helper(0, c, row, col, board);
            helper(row - 1, c, row, col, board);
        }
        for (int r = 0; r < row; ++r) {
            for (int c = 0; c < col; ++c) {
                char ch = board[r][c];
                if (ch == '\0') board[r][c] = 'O';
                else if (ch == 'O') board[r][c] = 'X';
            }
        }
    }

    private void helper(int row, int col, int rLen, int cLen, char[][] board) {
        if (row < 0 || row >= rLen || col < 0 || col >= cLen || board[row][col] != 'O') return;
        board[row][col] = '\0';
        helper(row - 1, col, rLen, cLen, board);
        helper(row + 1, col, rLen, cLen, board);
        helper(row, col - 1, rLen, cLen, board);
        helper(row, col + 1, rLen, cLen, board);
    }

    public void solve2(char[][] board) {
        if (board == null || board.length == 0 || board[0].length == 0) return;
        int row = board.length, col = board[0].length;
        boolean[][] visited = new boolean[row][col];
        for (int r = 0; r < row; ++r) {
            for (int c = 0; c < col; ++c) {
                if (!visited[r][c] && board[r][c] == 'O') {
                    visited[r][c] = true;
                    List<int[]> cells = new ArrayList<>();
                    Stack<int[]> stack = new Stack<>();
                    int[] root = new int[]{r, c};
                    cells.add(root);
                    stack.push(root);
                    boolean isEdge = false;
                    while (!stack.isEmpty()) {
                        int[] cell = stack.pop();
                        if (cell[0] > 0) {
                            int[] above = new int[]{cell[0] - 1, cell[1]};
                            if (!visited[above[0]][above[1]] && board[above[0]][above[1]] == 'O') {
                                visited[above[0]][above[1]] = true;
                                cells.add(above);
                                stack.push(above);
                            }
                        } else isEdge = true;
                        if (cell[0] < row - 1) {
                            int[] below = new int[]{cell[0] + 1, cell[1]};
                            if (!visited[below[0]][below[1]] && board[below[0]][below[1]] == 'O') {
                                visited[below[0]][below[1]] = true;
                                cells.add(below);
                                stack.push(below);
                            }
                        } else isEdge = true;
                        if (cell[1] > 0) {
                            int[] left = new int[]{cell[0], cell[1] - 1};
                            if (!visited[left[0]][left[1]] && board[left[0]][left[1]] == 'O') {
                                visited[left[0]][left[1]] = true;
                                cells.add(left);
                                stack.push(left);
                            }
                        } else isEdge = true;
                        if (cell[1] < col - 1) {
                            int[] right = new int[]{cell[0], cell[1] + 1};
                            if (!visited[right[0]][right[1]] && board[right[0]][right[1]] == 'O') {
                                visited[right[0]][right[1]] = true;
                                cells.add(right);
                                stack.push(right);
                            }
                        } else isEdge = true;
                    }
                    if (!isEdge) {
                        for (int[] cell : cells) board[cell[0]][cell[1]] = 'X';
                    }
                }
            }
        }
    }

}
