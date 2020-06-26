import java.util.HashSet;
import java.util.Set;

public class ValidSudoku_36 {

    public boolean isValidSudoku(char[][] board) {
        Set<Character> vValidSet = new HashSet<>();
        Set<Character> hValidSet = new HashSet<>();
        Set<Character> bValidSet = new HashSet<>();
        for (int i = 0; i < 9; ++i) {
            for (int j = 0; j < 9; ++j) {
                char hChar = board[i][j], vChar = board[j][i], bChar = board[(i / 3) * 3 + (j / 3)][(i % 3) * 3 + j % 3];
                if (hChar != '.') {
                    if (hValidSet.contains(hChar)) return false;
                    else hValidSet.add(hChar);
                }
                if (vChar != '.') {
                    if (vValidSet.contains(vChar)) return false;
                    else vValidSet.add(vChar);
                }
                if (bChar != '.') {
                    if (bValidSet.contains(bChar)) return false;
                    else bValidSet.add(bChar);
                }
            }
            vValidSet.clear();
            hValidSet.clear();
            bValidSet.clear();
        }
        return true;
    }

}
