import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class WordBreak_139 {

    private Set<String> wordSet;
    private boolean[] dp;

    public boolean wordBreak(String s, List<String> wordDict) {
        wordSet = new HashSet<>(wordDict);
        dp = new boolean[s.length() + 1];
        return helper(s);
    }

    private boolean helper(String s) {
        if (s.isEmpty()) return true;
        if (dp[s.length()]) return false;
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < s.length(); ++i) {
            sb.append(s.charAt(i));
            if (wordSet.contains(sb.toString()) && helper(s.substring(i + 1))) return true;
        }
        dp[s.length()] = true;
        return false;
    }

}
