import java.util.HashMap;

public class LongestSubstringWithoutRepeatingCharacters_3 {

    public int lengthOfLongestSubstring(String s) {
        HashMap<Character, Integer> checkChar = new HashMap<>();
        int longest = 0, startIndex = 0;
        for (int i = 0; i < s.length(); ++i) {
            char c = s.charAt(i);
            Integer val = checkChar.get(c);
            if (val != null && val >= startIndex) {
                longest = Math.max(longest, i - startIndex);
                startIndex = checkChar.get(c) + 1;
            }
            checkChar.put(c, i);
        }
        return Math.max(longest, s.length() - startIndex);
    }

}
