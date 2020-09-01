import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class ContainsDuplicate_217 {

    public boolean containsDuplicate(int[] nums) {
        Arrays.sort(nums);
        for (int i = 0; i < nums.length - 1; ++i) if (nums[i] == nums[i + 1]) return true;
        return false;
    }

    public boolean containsDuplicate1(int[] nums) {
        Set<Integer> set = new HashSet<>(nums.length);
        for (int num : nums) if (!set.add(num)) return true;
        return false;
    }

}
