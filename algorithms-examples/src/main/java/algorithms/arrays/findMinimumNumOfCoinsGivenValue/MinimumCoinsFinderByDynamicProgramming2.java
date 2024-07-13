package algorithms.arrays.findMinimumNumOfCoinsGivenValue;


//Since the same sub-problems are called again, this problem has both properties Overlapping Sub-problems
// and OPTIMAL Substructure.
// Like other typical Dynamic Programming(DP) problems, re-computations of the same sub-problems can be avoided
// by constructing a temporary array table[][] in a bottom-up manner.

public class MinimumCoinsFinderByDynamicProgramming2 implements MinimumCoinsFinder {

    @Override
    public int findMinimumCoins(int[] coins, int value) {
        // table[i] will be storing the minimum number of coins required for i value.
        // So table[value] will have result

        int table[] = new int[value + 1];

        // Base case (If given value V is 0)
        table[0] = 0;

        // Initialize all table values as Infinite
        for (int i = 1; i <= value ; i ++) {
            table[i] = Integer.MAX_VALUE;
        }

        // Compute minimum coins required for all values from 1 to V
        for (int i = 1; i <= value; i++)  {
            // Go through all coins smaller than i
            for (int j = 0; j < coins.length; j++) {
                if (coins[j] <= i) {
                    int sub_res = table[i - coins[j]];
                    if (sub_res != Integer.MAX_VALUE && sub_res + 1 < table[i])
                        table[i] = sub_res + 1;
                }
            }
        }

        if(table[value] == Integer.MAX_VALUE) {
            return CHANGE_NOT_POSSIBLE_MARK;
        }

        return table[value];

    }
}
