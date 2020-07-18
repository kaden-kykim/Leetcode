public class BestTimeToBuyAndSellStockII_122 {

    public int maxProfit(int[] prices) {
        int min = prices[0], max = 0, profit = 0, totalProfit = 0;
        for (int price : prices) {
            if (max < price) {
                max = price;
                profit = Math.max(profit, max - min);
            }
            if (price < max) {
                totalProfit += profit;
                profit = 0;
                min = max = price;
            }
        }
        return totalProfit + profit;
    }

}
