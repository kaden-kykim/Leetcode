public class LongestSubstringWithAtLeastKRepeatingCharacters_395 {

    public int longestSubstring(String s, int k) {
        if (s == null) return 0;
        int length = s.length();
        char[] chars = s.toCharArray();
        int[] count = new int[123];
        for (char c : chars) ++count[c];
        for (int i = 0; i < length; ++i) {
            if (k <= count[chars[i]]) continue;
            int j = i + 1;
            while (j < length && count[chars[j]] < k) ++j;
            return Math.max(longestSubstring(s.substring(0, i), k), longestSubstring(s.substring(j), k));
        }
        return length;
    }

    public int longestSubstring1(String s, int k) {
        if (s == null) return 0;
        int length = s.length();
        char[] chars = s.toCharArray();
        int[][] count = new int[length + 1][26];
        for (int i = 0; i < length; ++i) {
            ++count[i][chars[i] - 'a'];
            System.arraycopy(count[i], 0, count[i + 1], 0, 26);
        }
        int max = 0;
        for (int i = 0; i < length; ++i) {
            if (count[length][chars[i] - 'a'] < k) continue;
            int[] startCount = (i == 0) ? new int[26] : count[i - 1];
            for (int j = i + k - 1; j < length; ++j) {
                if (count[length][chars[j] - 'a'] < k) break;
                int[] curCount = count[j];
                boolean possible = true;
                for (int c = 0; c < 26; ++c) {
                    if (curCount[c] != 0) {
                        int n = curCount[c] - startCount[c];
                        if (n != 0 && n < k) possible = false;
                    }
                }
                if (possible) max = Math.max(max, j - i + 1);
            }
        }
        return max;
    }

}
