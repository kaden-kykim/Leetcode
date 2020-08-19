public class HouseRobber_198 {

    public int rob(int[] nums) {
        if (nums == null || nums.length == 0) return 0;
        int length = nums.length;
        if (length == 1) return nums[0];

        int[] sum = new int[length];
        sum[0] = nums[0]; sum[1] = nums[1];
        for (int i = 0; i < length - 2; ++i) {
            sum[i + 2] = Math.max(sum[i + 2], sum[i] + nums[i + 2]);
            if (i + 3 < length) sum[i + 3] = Math.max(sum[i + 3], sum[i] + nums[i + 3]);
        }
        return Math.max(sum[length - 1], sum[length - 2]);
    }

}
