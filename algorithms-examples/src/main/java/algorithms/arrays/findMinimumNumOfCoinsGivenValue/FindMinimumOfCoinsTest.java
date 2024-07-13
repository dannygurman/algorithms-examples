package algorithms.arrays.findMinimumNumOfCoinsGivenValue;

import org.junit.Assert;
import org.junit.Test;

public class FindMinimumOfCoinsTest {

    @Test
    public void when_FindMinimumCoins_Recursion1_Than_AsExpected(){
        MinimumCoinsFinder minimumCoinsFinder = new MinimumCoinsFinderByRecursion1();
        findMinimumCoinsInternal(minimumCoinsFinder);
    }


    public  void findMinimumCoinsInternal(final MinimumCoinsFinder minimumCoinsFinder){
        int coins[] =  {9, 6, 5, 1};
        int value = 11;
        int foundMinimumCoins = minimumCoinsFinder.findMinimumCoins(coins, value);
        int expectedMin = 2;
        Assert.assertEquals("Minimum coins not as expected", expectedMin, foundMinimumCoins);
   }
}
