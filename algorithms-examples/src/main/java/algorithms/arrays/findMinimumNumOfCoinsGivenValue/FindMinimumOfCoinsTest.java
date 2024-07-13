package algorithms.arrays.findMinimumNumOfCoinsGivenValue;

import org.junit.Assert;
import org.junit.Test;

import static algorithms.arrays.findMinimumNumOfCoinsGivenValue.MinimumCoinsFinder.CHANGE_NOT_POSSIBLE_MARK;

public class FindMinimumOfCoinsTest {

    @Test
    public void when_FindMinimumCoins_Recursion1_Than_AsExpected() {
        MinimumCoinsFinder minimumCoinsFinder = new MinimumCoinsFinderByRecursion1();
        verifyMinimumCoins(minimumCoinsFinder);
    }

    @Test
    public void when_FindMinimumCoins_DP1_Than_AsExpected(){
        MinimumCoinsFinder minimumCoinsFinder = new MinimumCoinsFinderByDynamicProgramming1();
        verifyMinimumCoins(minimumCoinsFinder);
    }

    @Test
    public void when_FindMinimumCoins_DP2Optimized_Than_AsExpected(){
        MinimumCoinsFinder minimumCoinsFinder = new MinimumCoinsFinderByDynamicProgramming2();
        verifyMinimumCoins(minimumCoinsFinder);
    }


    private void verifyMinimumCoins(final MinimumCoinsFinder minimumCoinsFinder){
        int coins[] =  {9, 6, 5, 1};
        int value = 11;
        int expectedMinCoins = 2;
        verifyMinimumCoins(minimumCoinsFinder, coins, value, expectedMinCoins);

        int coins_2[] =  {5, 3};
        int value_2 = 4;
        int expectedMinCoins_2 = CHANGE_NOT_POSSIBLE_MARK;
        verifyMinimumCoins(minimumCoinsFinder, coins_2, value_2, expectedMinCoins_2);
   }

    private void verifyMinimumCoins(final MinimumCoinsFinder minimumCoinsFinder, int[] coins, int value, int expectedMinCoins){
        int foundMinimumCoins = minimumCoinsFinder.findMinimumCoins(coins, value);
        Assert.assertEquals("Minimum coins not as expected", expectedMinCoins, foundMinimumCoins);
    }

}
