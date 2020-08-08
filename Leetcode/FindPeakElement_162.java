public class FindPeakElement_162 {

    public int findPeakElement(int[] nums) {
        return helper(nums, 0, nums.length - 1);
    }

    private int helper(int[] nums, int left, int right) {
        if (left == right) return left;
        int middle = (left + right) / 2;
        return (nums[middle] > nums[middle + 1])
                ? helper(nums, left, middle)
                : helper(nums, middle + 1, right);
    }

    public int findPeakElement1(int[] nums) {
        int length = nums.length;
        if (length == 1) return 0;
        if (nums[0] > nums[1]) return 0;
        if (nums[length - 2] < nums[length - 1]) return length - 1;
        int prev = nums[0];
        for (int i = 1; i < length - 1; ++i) {
            if (prev < nums[i] && nums[i] > nums[i + 1]) return i;
            prev = nums[i];
        }
        return length - 1;
    }

}
