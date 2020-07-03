import java.util.Arrays;

public class MaximumSubarray_53 {

    public int maxSubArray(int[] nums) {
        int min = 0, max = Integer.MIN_VALUE;
        int curMax = Integer.MIN_VALUE;
        int sum = 0;

        for (int num : nums) {
            sum += num;
            if (min >= sum) {
                max = min = sum;
                curMax = Math.max(curMax, num);
            } else if (max < sum) {
                max = sum;
                curMax = Math.max(curMax, sum - min);
            }
        }

        return curMax;
    }

}
