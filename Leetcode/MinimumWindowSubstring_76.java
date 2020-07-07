import java.util.*;

public class MinimumWindowSubstring_76 {

    public String minWindow(String s, String t) {
        int sLength = s.length(), tLength = t.length();

        char[] sChars = s.toCharArray();
        int[] map = new int[128];
        for (char c : t.toCharArray()) ++map[c];

        int left = 0, tCount = tLength;
        int minStart = 0, minLength = Integer.MAX_VALUE;
        for (int right = 0; right < sLength; ++right) {
            if (map[sChars[right]]-- > 0) --tCount;
            while (tCount == 0) {
                if (right - left < minLength) minLength = right - (minStart = left);
                if (++map[sChars[left++]] > 0) ++tCount;
            }
        }
        return minLength != Integer.MAX_VALUE ? s.substring(minStart, minStart + minLength + 1) : "";
    }

    public String minWindow2(String s, String t) {
        if (s == null || t == null || s.isEmpty() || t.isEmpty() || s.length() < t.length()) return "";
        Set<Character> set = new HashSet<>();
        char[] sChars = s.toCharArray();
        int[] hash = new int[128];
        int sLength = s.length();
        for (char c : t.toCharArray()) { set.add(c); --hash[c]; }
        for (char c : sChars) { if (set.contains(c)) ++hash[c]; }
        for (Character c : set) { if (hash[c] < 0) return ""; }

        int last = sLength - 1;
        for (int i = last; i >= 0; --i) {
            char c = sChars[i];
            if (set.contains(c)) {
                if (hash[c] == 0) { last = i; break; }
                --hash[c];
            }
        }
        int minStart = 0, minLength = last + 1;
        int curLength = minLength;
        for (int i = 0; i < sLength; ++i) {
            char c = sChars[i];
            if (set.contains(c)) {
                int count = hash[c];
                if (count == 0) {
                    int n;
                    for (n = last + 1; n < sLength; ++n) {
                        char nChar = sChars[n];
                        if (nChar == c) { last = n; break; }
                        else if (set.contains(nChar)) ++hash[nChar];
                    }
                    curLength = n - i;
                    if (n == sLength) break; else continue;
                } else --hash[c];
            }
            if (--curLength < minLength) {
                minLength = curLength;
                minStart = i + 1;
            }
        }

        return s.substring(minStart, minStart + minLength);
    }

    public String minWindow1(String s, String t) {
        if (s == null || t == null || s.isEmpty() || t.isEmpty()) return "";
        Map<Character, Integer> tMap = new HashMap<>();
        Map<Character, List<Integer>> findMap = new HashMap<>();
        for (char c : t.toCharArray()) tMap.put(c, (tMap.containsKey(c) ? tMap.get(c) + 1 : 1));
        for (Map.Entry<Character, Integer> entry : tMap.entrySet()) findMap.put(entry.getKey(), new ArrayList<>());

        int minStart = -1, minLength = -1;
        int counter = t.length();
        boolean hasWindow = false;
        int firstIndex = -1;
        for (int i = 0; i < s.length(); ++i) {
            char c = s.charAt(i);
            if (findMap.containsKey(c)) {
                List<Integer> list = findMap.get(c);
                list.add(i);
                if (list.size() > tMap.get(c)) list.remove(0);
                else hasWindow = --counter == 0;
                if (firstIndex == -1) firstIndex = i;
                else if (s.charAt(firstIndex) == c) {
                    int min = Integer.MAX_VALUE;
                    for (Map.Entry<Character, List<Integer>> entry : findMap.entrySet()) {
                        List<Integer> l = entry.getValue();
                        if (!l.isEmpty() && l.get(0) < min) { min = l.get(0); firstIndex = min; }
                    }
                }
                if (hasWindow && (minStart == -1 || i - firstIndex <= minLength)) { minStart = firstIndex; minLength = i - firstIndex; }
            }
        }

        return (hasWindow) ? s.substring(minStart, minStart + minLength + 1) : "";
    }

}
