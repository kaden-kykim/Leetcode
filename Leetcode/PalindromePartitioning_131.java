import java.util.ArrayList;
import java.util.List;

public class PalindromePartitioning_131 {

    public List<List<String>> partition(String s) {
        List<List<String>> results = new ArrayList<>();
        if (s == null || s.isEmpty()) return results;
        helper(s, 0, results);
        return results;
    }

    private void helper(String s, int start, List<List<String>> results) {
        if (start == s.length() - 1) { results.add(new ArrayList<String>(){{ add(s.substring(start)); }}); return; }
        for (int part = start + 1; part <= s.length(); ++part) {
            if (isPalindrome(s, start, part)) {
                List<List<String>> newResult = new ArrayList<>();
                String pre = s.substring(start, part);
                helper(s, part, newResult);
                if (newResult.isEmpty()) newResult.add(new ArrayList<String>(){{ add(pre); }});
                else for (List<String> result : newResult) result.add(0, pre);
                results.addAll(newResult);
            }
        }
    }

    private boolean isPalindrome(String s, int start, int end) {
        while (start < end) {
            if (s.charAt(start++) != s.charAt(--end)) return false;
        }
        return true;
    }

}
