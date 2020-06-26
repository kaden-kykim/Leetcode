public class FirstMissingPositive_41 {

    public int firstMissingPositive(int[] nums) {
        if (nums == null || nums.length == 0) return 1;
        for (byte i = 0; i < nums.length; ++i) {
            while (true) {
                int cur = nums[i];
                if (cur == i + 1) break;
                if (cur < 1 || cur > nums.length || cur == nums[cur - 1]) { nums[i] = -1; break; }
                nums[i] = nums[cur - 1];
                nums[cur - 1] = cur;
            }
        }
        for (int i = 0; i < nums.length; ++i) {
            if (nums[i] == -1) return i + 1;
        }
        return nums.length + 1;
    }

}
