import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class WordBreakII_140 {

    private Set<String> wordSet;
    private boolean[] dp;

    public List<String> wordBreak(String s, List<String> wordDict) {
        wordSet = new HashSet<>(wordDict);
        dp = new boolean[s.length() + 1];
        List<String> results = new ArrayList<>();
        helper(s, results, new ArrayList<>());
        return results;
    }

    private boolean helper(String s, List<String> results, List<String> prevList) {
        if (s.isEmpty()) {
            StringBuilder result = new StringBuilder();
            for (String list : prevList) { result.append(list); result.append(' '); }
            results.add(result.toString().trim());
            return true;
        }
        if (dp[s.length()]) return false;
        boolean canBreak = false;
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < s.length(); ++i) {
            sb.append(s.charAt(i));
            String str = sb.toString();
            if (wordSet.contains(str)) {
                prevList.add(str);
                if (helper(s.substring(i + 1), results, prevList)) canBreak = true;
                prevList.remove(prevList.size() - 1);
            }
        }
        dp[s.length()] = !canBreak;
        return canBreak;
    }

}
