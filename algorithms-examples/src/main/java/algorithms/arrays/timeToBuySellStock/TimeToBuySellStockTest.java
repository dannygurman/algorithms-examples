package algorithms.arrays.timeToBuySellStock;

import org.junit.Assert;
import org.junit.Test;

public class TimeToBuySellStockTest {

    @Test
    public void  given_Resolver_A_WhenCalculatingMaxProfit_ThenResultAsExpected() {
        TimeToBuySellStockTestResolver timeToBuySellStockTestResolver = new TimeToBuySellStockTestResolver_A();
        InternalTestMaxProfitCalculation(timeToBuySellStockTestResolver) ;
    }

    @Test
    public void  given_Resolver_B_WhenCalculatingMaxProfit_ThenResultAsExpected() {
        TimeToBuySellStockTestResolver timeToBuySellStockTestResolver = new TimeToBuySellStockTestResolver_B();
        InternalTestMaxProfitCalculation(timeToBuySellStockTestResolver) ;
    }


    private void InternalTestMaxProfitCalculation(TimeToBuySellStockTestResolver timeToBuySellStockTestResolver){
        int [] prices = new int[]{7,1,5,3,6,4};
        int calculatedProfit = timeToBuySellStockTestResolver.calculateMaxProfit(prices);
        int expectedProfit = 5;//(6-1)
        Assert.assertEquals("", expectedProfit, calculatedProfit);
    }
}
