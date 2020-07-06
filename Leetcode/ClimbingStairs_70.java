public class ClimbingStairs_70 {

    public int climbStairs(int n) {
        int[] dp = new int[]{1, 2, 3};
        for (int i = 3; i < n; ++i)
            dp[i % 3] = dp[(i - 2) % 3] + dp[(i - 1) % 3];
        return dp[(n - 1) % 3];
    }

}
