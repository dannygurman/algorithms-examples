package algorithms.arrays.findMinimumNumOfCoinsGivenValue;

// Time Complexity: O(m^V)
// Auxiliary Space: O(V)
public class MinimumCoinsFinderByRecursion1 implements MinimumCoinsFinder{
    @Override
    public int findMinimumCoins(int[] coins, int value) {
        // base case
        if (value == 0){
            return 0;
        }

        // Initialize result
        int res = Integer.MAX_VALUE;

        // Try every coin that has smaller value than value
        for (int i=0; i< coins.length; i++) {
            if (coins[i] <= value) {
                int sub_res = findMinimumCoins(coins, value-coins[i]);

                // Check for INT_MAX to avoid overflow and see if result can be minimized
                //meaning sub_res + 1 < res (1 for current coin)
                if (sub_res != Integer.MAX_VALUE && sub_res + 1 < res)
                    res = sub_res + 1;
            }
        }
        return res;
    }

}
