public class LongestIncreasingSubsequence_300 {

    public int lengthOfLIS(int[] nums) {
        int count = 0, larger = Integer.MIN_VALUE, largest = larger;
        for (int num : nums) {
            if (larger < num && num < largest) { larger = largest; largest = num; }
            else if (largest < num) { larger = largest; largest = num; ++count; }
        }

        int rCount = 0, smallest = Integer.MAX_VALUE;
        for (int i = nums.length - 1; i >= 0; --i)
            if (nums[i] < smallest) { smallest = nums[i]; ++rCount; }

        return Math.max(count, rCount);
    }

}
