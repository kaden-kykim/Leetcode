import java.util.HashMap;
import java.util.Map;

public class MajorityElement_169 {

    // Boyer-Moore Voting Algorithm
    public int majorityElement(int[] nums) {
        int major = nums[0], count = 1;
        for (int i = 1; i < nums.length; ++i) {
            if (count == 0) major = nums[i];
            if (nums[i] == major) ++count;
            else --count;
        }
        return major;
    }

    public int majorityElement1(int[] nums) {
        int half = nums.length >> 1;
        Map<Integer, Integer> map = new HashMap<>();
        for (int i : nums) {
            int count = map.getOrDefault(i, 0) + 1;
            if (count > half) return i;
            map.put(i, count);
        }
        return -1;
    }

}
