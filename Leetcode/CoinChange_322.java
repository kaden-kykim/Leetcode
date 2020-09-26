import java.util.Arrays;

public class CoinChange_322 {

    private int minCount = Integer.MAX_VALUE;

    public int coinChange(int[] coins, int amount) {
        Arrays.sort(coins);
        helper(coins, amount, coins.length - 1, 0);
        return minCount == Integer.MAX_VALUE ? -1 : minCount;
    }

    private void helper(int[] coins, int amount, int index, int depth) {
        if (index < 0) return;
        int count = amount / coins[index];
        if (amount % coins[index] == 0) minCount = Math.min(minCount, depth + count);
        else {
            for (; count >= 0; --count) {
                if (depth + count >= minCount - 1) break;
                helper(coins, amount - count * coins[index], index - 1, depth + count);
            }
        }
    }

}
