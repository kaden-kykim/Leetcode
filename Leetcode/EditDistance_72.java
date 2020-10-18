public class EditDistance_72 {

    public int minDistance(String word1, String word2) {
        int col = word1.length(), row = word2.length();
        int[][] levArray = new int[row + 1][col + 1];
        for (int i = 0; i <= col; ++i) levArray[0][i] = i;
        for (int i = 0; i <= row; ++i) levArray[i][0] = i;

        char[] chArr1 = word1.toCharArray();
        for (int r = 0; r < row; ++r) {
            char rCh = word2.charAt(r);
            for (int c = 0; c < col; ++c) {
                levArray[r + 1][c + 1] = Math.min(Math.min(levArray[r][c + 1] + 1, levArray[r + 1][c] + 1),
                        levArray[r][c] + ((rCh != chArr1[c]) ? 1 : 0));
            }
        }
        return levArray[row][col];
    }

}
