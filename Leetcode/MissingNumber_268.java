import java.util.Arrays;

public class MissingNumber_268 {

    public int missingNumber(int[] nums) {
        int result = 0;
        for (int i = 0; i <= nums.length; ++i) result ^= i;
        for (int num : nums) result ^= num;
        return result;
    }

    public int missingNumber1(int[] nums) {
        Arrays.sort(nums);
        for (int i = 0; i < nums.length; ++i)
            if (i != nums[i]) return i;
        return nums.length;
    }

}
