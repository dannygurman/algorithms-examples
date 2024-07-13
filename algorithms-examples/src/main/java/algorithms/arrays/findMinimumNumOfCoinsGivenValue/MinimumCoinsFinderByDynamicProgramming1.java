package algorithms.arrays.findMinimumNumOfCoinsGivenValue;


import java.util.Arrays;

/**
 * The idea is to find the Number of ways of Denominations By using the Top Down (Memoization).
 *
 * Algorithm: *
 * Creating a 2-D vector to store the Overlapping Solutions
 * Keep Track of the overlapping subproblems while Traversing the array coins[]
 * Recall them whenever needed.
 */


// Function to find the minimum number of coins needed to make a target value
public class MinimumCoinsFinderByDynamicProgramming1 implements MinimumCoinsFinder {

    @Override
    public int findMinimumCoins(int[] coins, int value) {
        // Create a DP table to store results of sub-problems
        int[] dp = new int[value + 1];
        Arrays.fill(dp, CHANGE_NOT_POSSIBLE_MARK); // Initialize DP table with -1

        // Call the utility function to solve the problem
        return minCoinsUtil(coins, value, dp);
    }


    // Utility function for solving the minimum coins problem
    public static int minCoinsUtil(int[] coins, int value, int[] dp)    {
        // Base case: If target value V is 0, no coins are needed
        if (value == 0) {
            return 0;
        }

        // If sub-problem is already solved, return the result from DP table
        if (dp[value] != -1) {
            return dp[value];
        }

        int res = Integer.MAX_VALUE;

        // Iterate over all coins and recursively solve for  sub-problems
        for (int i = 0; i < coins.length; i++) {
            if (coins[i] <= value) {
                // Recursive call to solve for remaining value V - coins[i]
                int sub_res = minCoinsUtil(coins, value - coins[i], dp);

                // If the sub-problem has a valid solution and the total number of coins is smaller
                // than the current result, update the result
                if (sub_res != Integer.MAX_VALUE  && sub_res + 1 < res) {// +1 is for current coin
                    res = sub_res + 1;
                }
            }
        }

        // Save the result in the DP table
        dp[value] = res;

        return res;
    }
}
