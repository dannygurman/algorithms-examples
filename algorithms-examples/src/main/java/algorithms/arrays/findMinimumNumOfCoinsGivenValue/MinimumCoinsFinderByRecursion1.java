package algorithms.arrays.findMinimumNumOfCoinsGivenValue;

// Time Complexity: O(m^V)
// Auxiliary Space: O(V)
public class MinimumCoinsFinderByRecursion1 implements MinimumCoinsFinder {

    @Override
    public int findMinimumCoins(int[] coins, int value) {
      int minCoins = findMinimumCoinsInternal(coins, value);
      if (minCoins == Integer.MAX_VALUE) {
          minCoins = CHANGE_NOT_POSSIBLE_MARK;//Legit limitation
        }
      return minCoins;
    }



    public int findMinimumCoinsInternal(int[] coins, int value) {
        // base case
        if (value == 0){
            return 0;
        }

        // Initialize result
        int minimumCoins = Integer.MAX_VALUE;

        // Try every coin that has smaller value than value
        for (int i=0; i< coins.length; i++) {
            int currentCoin = coins[i];
            if (currentCoin <= value) {
                int sub_res = findMinimumCoinsInternal(coins, value-currentCoin);

                // Check for INT_MAX to avoid overflow
                if (sub_res == Integer.MAX_VALUE) {
                   continue;//skip
                }
                //
                // see if result can be minimized meaning sub_res + 1 < res (1 for current coin)
                if (sub_res + 1 < minimumCoins)
                    minimumCoins = sub_res + 1;
            }
        }
        return minimumCoins;
    }

}
