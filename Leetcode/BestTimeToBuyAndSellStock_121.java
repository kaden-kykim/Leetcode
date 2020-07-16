public class BestTimeToBuyAndSellStock_121 {

    public int maxProfit(int[] prices) {
        int min = Integer.MAX_VALUE, max = 0, maxProfit = 0;
        for (int i : prices) {
            if (i < min) min = max = i;
            else if (max < i) {
                max = i;
                maxProfit = Math.max(maxProfit, max - min);
            }
        }
        return maxProfit;
    }

    public int maxProfit1(int[] prices) {
        if (prices.length == 0) return 0;
        int maxProfit = 0, max = prices[prices.length - 1];
        for (int i = prices.length - 2; i >= 0; --i) {
            int profit = max - prices[i];
            if (profit < 0) max = prices[i];
            else maxProfit = Math.max(maxProfit, profit);
        }
        return maxProfit;
    }

}
