public class PerfectSquares_279 {

    private int[] sqNumbers, dp;

    // Opt Solution, Need to analyze
    public int numSquares(int n) {
        while (n % 4 == 0) n /= 4;
        if (n % 8 == 7) return 4;

        int temp = (int) Math.sqrt(n);
        if (temp * temp == n) return 1;

        for (int i = 1; i * i < n; i++) {
            int b = (int) Math.sqrt(n - i * i);
            if (i * i + b * b == n) return 2;
        }

        return 3;
    }

    public int numSquares1(int n) {
        int[] dp = new int[n + 1];
        for (int i = 1; i < dp.length; ++i) {
            for (int j = 1; j * j <= i; ++j) {
                dp[i] = dp[i] > 0 ? Math.min(dp[i], dp[i - j * j] + 1) : dp[i - j * j] + 1;
            }
        }
        return dp[n];
    }

    public int numSquares2(int n) {
        dp = new int[n + 1];
        sqNumbers = new int[(int) Math.sqrt(n) + 1];
        for (int i = 1; i < sqNumbers.length; ++i) sqNumbers[i] = i * i;
        return helper2(n, 0, Integer.MAX_VALUE);
    }

    private int helper2(int n, int depth, int min) {
        if (n == 0) return 0;
        if (dp[n] != 0) return dp[n];
        if (min < depth) return -1;
        int curMin = Integer.MAX_VALUE;
        for (int i = (int) Math.sqrt(n); i > 0; --i) {
            int count = helper2(n - sqNumbers[i], depth + 1, curMin);
            if (count != -1 && ++count < curMin) curMin = count;
        }
        return dp[n] = curMin;
    }

}
