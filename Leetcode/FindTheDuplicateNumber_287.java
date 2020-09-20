public class FindTheDuplicateNumber_287 {

    // Memory Usage: O(1), Need to analyze
    public int findDuplicate(int[] nums) {
        if (nums.length < 2) return 1;
        int slow = nums[0], fast = nums[nums[0]];
        while (slow != fast) {
            slow = nums[slow];
            fast = nums[nums[fast]];
        }
        fast = 0;
        while (slow != fast) {
            slow = nums[slow];
            fast = nums[fast];
        }
        return slow;
    }

    // Memory Usage: O(n)
    public int findDuplicate1(int[] nums) {
        boolean[] check = new boolean[nums.length + 1];
        for (int num : nums) {
            if (check[num]) return num;
            check[num] = true;
        }
        return -1;
    }

}
