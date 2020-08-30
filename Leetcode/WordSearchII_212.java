import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class WordSearchII_212 {

    public List<String> findWords(char[][] board, String[] words) {
        ImplementTrie implementTrie = new ImplementTrie();
        for (String word : words) implementTrie.insert(word);
        List<String> result = new ArrayList<>();
        for (int r = 0; r < board.length; ++r)
            for (int c = 0; c < board[0].length; ++c)
                helper(implementTrie, result, board, r, c);
        return result;
    }

    private void helper(ImplementTrie implementTrie, List<String> result, char[][] board, int row, int col) {
        if (row < 0 || row >= board.length || col < 0 || col >= board[0].length) return;
        char curChar = board[row][col];
        if ((curChar != ' ') && implementTrie.hasNext(curChar)) {
            implementTrie.pushSet(curChar);
            implementTrie.checkWord(result);
            board[row][col] = ' ';
            helper(implementTrie, result, board, row, col + 1);
            helper(implementTrie, result, board, row + 1, col);
            helper(implementTrie, result, board, row, col - 1);
            helper(implementTrie, result, board, row - 1, col);
            board[row][col] = curChar;
            implementTrie.popSet();
        }
    }

    public List<String> findWords1(char[][] board, String[] words) {
        List<String> results = new ArrayList<>();
        for (String str : words) if (exist1(board, str)) results.add(str);
        return results;
    }

    private boolean exist1(char[][] board, String word) {
        for (int r = 0; r < board.length; ++r)
            for (int c = 0; c < board[0].length; ++c)
                if (helper1(board, r, c, word, 0)) return true;
        return false;
    }

    private boolean helper1(char[][] board, int row, int col, String word, int index) {
        char curChar = word.charAt(index++);
        if (row < 0 || row >= board.length || col < 0 || col >= board[0].length
                || board[row][col] != curChar) return false;
        if (index == word.length()) return true;

        boolean result = false;
        board[row][col] = ' ';
        if (helper1(board, row, col + 1, word, index)
                || helper1(board, row + 1, col, word, index)
                || helper1(board, row - 1, col, word, index)
                || helper1(board, row, col - 1, word, index)) result = true;
        board[row][col] = curChar;
        return result;
    }

    private static class ImplementTrie {

        private final CharSet dummyHead;
        private final Stack<CharSet> setStack = new Stack<>();
        public ImplementTrie() { dummyHead = new CharSet(); setStack.push(dummyHead); }

        public boolean hasNext(char c) { return setStack.peek().next[c - 'a'] != null; }
        public void pushSet(char c) { setStack.push(setStack.peek().next[c - 'a']); }
        public void popSet() { setStack.pop(); }

        public void checkWord(List<String> result) {
            if (setStack.peek().word != null) {
                result.add(setStack.peek().word);
                setStack.peek().word = null;
            }
        }

        public void insert(String word) {
            CharSet set = dummyHead;
            for (char c : word.toCharArray()) {
                int i = c - 'a';
                if (set.next[i] == null) set.next[i] = new CharSet();
                set = set.next[i];
            }
            set.word = word;
        }

        private static class CharSet {
            String word;
            CharSet[] next;
            CharSet() { word = null; next = new CharSet[26]; }
        }

    }

}
