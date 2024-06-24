package algorithms.arrays.findMinimumNumOfCoinsGivenValue;

import org.junit.Assert;

public class FindMinimumOfCoinsTest {

    public  void testFindMinimumCoinsRecursion1(){

    }



    public  void findMinimumCoinsInternal(final MinimumCoinsFinder minimumCoinsFinder){
        int coins[] =  {9, 6, 5, 1};
        int value = 11;
        int foundMinimumCoins = minimumCoinsFinder.findMinimumCoins(coins, value);
        int expectedMin = 2;
        Assert.assertEquals("Minimum coins not as expected", expectedMin, foundMinimumCoins);
   }
}
