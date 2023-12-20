package algorithms.arrays.timeToBuySellStock;

public class TimeToBuySellStockTestResolver_A implements TimeToBuySellStockTestResolver {

    @Override
    public int calculateMaxProfit(int[] prices) {
        int leastSoFar = Integer.MAX_VALUE;
        int overallProfit = 0;
        int profitIfSoldToday = 0;

        for (int i = 0; i < prices.length; i++) {
            if (prices[i] < leastSoFar) {
                leastSoFar = prices[i];
            }
            profitIfSoldToday = prices[i] - leastSoFar;
            if (overallProfit < profitIfSoldToday) {
                overallProfit = profitIfSoldToday;
            }
        }
        return overallProfit;
    }
}


