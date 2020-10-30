public class UniqueBinarySearchTrees_96 {

    private int[] dp;

    public int numTrees(int n) {
        dp = new int[n + 1];
        dp[0] = dp[1] = 1;
        return helper(n);
    }

    private int helper(int n) {
        if (dp[n] != 0) return dp[n];
        boolean isOdd = n % 2 != 0;
        int result = 0;
        for (int i = 1; i <= n / 2; ++i) result += helper(i - 1) * helper(n - i);
        result <<= 1;
        if (isOdd) result += helper(n / 2) * helper(n / 2);
        return dp[n] = result;
    }

}
