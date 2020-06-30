import java.util.*;

public class GroupAnagrams_49 {

    private final int[] primes = new int[]{2, 3, 5, 7, 11, 13, 17, 19, 23, 29, 31, 37, 41, 43, 47, 53, 59, 61, 67, 71, 73, 79, 83, 89, 97, 101};

    public List<List<String>> groupAnagrams(String[] strs) {
        List<List<String>> result = new ArrayList<>();
        if (strs == null || strs.length == 0) return result;
        int length = strs.length;

        long[] keys = new long[length];
        for (int i = 0; i < length; ++i) {
            int key = 1;
            for (char ch: strs[i].toCharArray())
                key *= primes[ch - 'a'];
            keys[i] = key;
        }

        Map<Long, List<String>> map = new HashMap<>();
        for (int i = 0; i < length; ++i) {
            long key = keys[i];
            if (map.containsKey(keys[i])) {
                map.get(keys[i]).add(strs[i]);
            } else {
                List<String> newList = new ArrayList<>();
                newList.add(strs[i]);
                map.put(key, newList);
            }
        }
        result.addAll(map.values());
        return result;
    }

}
