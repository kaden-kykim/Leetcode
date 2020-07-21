import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class LongestConsecutiveSequence_128 {

    public int longestConsecutive(int[] nums) {
        if (nums == null || nums.length == 0) return 0;
        Set<Integer> numSet = new HashSet<>();
        for (int num : nums) numSet.add(num);

        int max = 1;
        for (int num : nums) {
            if (!numSet.contains(num - 1)) {
                int cur = num, len = 1;
                while (numSet.contains(++cur)) ++len;
                max = Math.max(max, len);
            }
        }
        return max;
    }

    public int longestConsecutiveUF(int[] nums) {
        if (nums == null || nums.length == 0) return 0;
        int length = nums.length, max = 1;
        Map<Integer, Integer> parentMap = new HashMap<>(length);
        Map<Integer, Integer> sizeMap = new HashMap<>(length);
        for (int cur : nums) {
            if (parentMap.containsKey(cur)) continue;
            int prev = cur - 1, parent;
            if (parentMap.containsKey(prev)) {
                while (prev != (parent = parentMap.get(prev))) {
                    parentMap.put(parent, parentMap.get(parent));
                    prev = parent;
                }
                parentMap.put(cur, prev);
                sizeMap.put(prev, cur - prev + 1);
                max = Math.max(max, cur - prev + 1);
            } else {
                parentMap.put(cur, cur);
                sizeMap.put(cur, 1);
            }

            int next = cur + 1;
            if (parentMap.containsKey(next)) {
                parent = parentMap.get(cur);
                parentMap.put(next, parent);
                sizeMap.put(parent, sizeMap.get(parent) + sizeMap.get(next));
                max = Math.max(max, sizeMap.get(parent));
            }
        }
        return max;
    }

}
