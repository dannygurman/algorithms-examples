package algorithms.arrays.timeToBuySellStock;

public class TimeToBuySellStockTestResolver_B implements TimeToBuySellStockTestResolver {

    @Override
    public int calculateMaxProfit(int[] prices) {
        int leftIndex = 0; // Buy
        int rightIndex = 1; // sell
        int maxProfit = 0;
        while (rightIndex < prices.length) {
            if (prices[leftIndex] < prices[rightIndex]) {
                int currentProfit = prices[rightIndex] - prices[leftIndex];
                maxProfit = Math.max(maxProfit, currentProfit);
            } else {
                //moving left pointer to the right position
                // We always want our left point to be minimum
                leftIndex = rightIndex;
            }
            //increment our right pointer by 1
            rightIndex++;
        }
        return maxProfit;
    }

}