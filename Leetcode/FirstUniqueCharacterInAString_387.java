import java.util.HashMap;
import java.util.Map;

public class FirstUniqueCharacterInAString_387 {

    public int firstUniqChar(String s) {
        if (s == null || s.isEmpty()) return -1;
        int length = s.length();
        char[] strArr = s.toCharArray();
        int slow = 0, fast = 1;
        int[] count = new int[256];
        ++count[strArr[slow]];
        while (fast < length) {
            ++count[strArr[fast]];
            while (slow < length && count[strArr[slow]] > 1) ++slow;
            if (length <= slow) return -1;
            if (count[strArr[slow]] == 0) ++count[strArr[fast = slow]];
            ++fast;
        }
        return slow;
    }

    public int firstUniqChar1(String s) {
        if (s == null || s.isEmpty()) return -1;
        int length = s.length();
        boolean[] isRepeat = new boolean[length];
        Map<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < length; ++i) {
            char c = s.charAt(i);
            if (map.containsKey(c)) isRepeat[i] = isRepeat[map.get(c)] = true;
            else map.put(c, i);
        }
        for (int i = 0; i < length; ++i) { if (!isRepeat[i]) return i; }
        return -1;
    }

}
