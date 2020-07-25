import java.util.ArrayList;
import java.util.List;

public class PalindromePartitioning_131 {

    public List<List<String>> partition(String s) {
        return helper(new ArrayList<>(), new ArrayList<>(), s, 0);
    }

    private List<List<String>> helper(List<List<String>> list, List<String> curList, String s, int start) {
        if (start == s.length()) list.add(new ArrayList<>(curList));
        else {
            for (int i = start + 1; i <= s.length(); ++i) {
                if (isPalindrome(s, start, i)) {
                    curList.add(s.substring(start, i));
                    helper(list, curList, s, i);
                    curList.remove(curList.size() - 1);
                }
            }
        }
        return list;
    }

    public List<List<String>> partition1(String s) {
        if (s == null || s.isEmpty()) return new ArrayList<>();
        return helper1(s, 0);
    }

    private List<List<String>> helper1(String s, int start) {
        List<List<String>> results = new ArrayList<>();
        if (start == s.length() - 1) {
            results.add(new ArrayList<String>(){{ add(s.substring(start)); }});
            return results;
        }
        for (int part = start + 1; part <= s.length(); ++part) {
            if (isPalindrome(s, start, part)) {
                List<List<String>> newResult = helper1(s, part);
                String pre = s.substring(start, part);
                if (newResult.isEmpty()) newResult.add(new ArrayList<String>(){{ add(pre); }});
                else for (List<String> result : newResult) result.add(0, pre);
                results.addAll(newResult);
            }
        }
        return results;
    }

    private boolean isPalindrome(String s, int start, int end) {
        while (start < end) if (s.charAt(start++) != s.charAt(--end)) return false;
        return true;
    }

}
