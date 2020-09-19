public class MoveZeroes_283 {

    public void moveZeroes(int[] nums) {
        int nonZeroCount = 0;
        for (int i = 0; i < nums.length; ++i)
            if (nums[i] != 0 && nonZeroCount++ != i) nums[nonZeroCount - 1] = nums[i];
        for (int i = nonZeroCount; i < nums.length; ++i) nums[i] = 0;
    }

}
