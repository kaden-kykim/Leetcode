public class JumpGame_55 {

    public boolean canJump(int[] nums) {
        if (nums.length == 1) return true;
        int minIndex = nums.length - 1;
        for (int i = nums.length - 2; i >= 0; --i) {
            if (i + nums[i] >= minIndex) minIndex = i;
        }
        return minIndex == 0;
    }

}
